# -*- coding: utf8 -*-
import sys
from imp import reload
import argparse
import requests
from PIL import Image, ImageDraw, ImageFont
from io import BytesIO
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import matplotlib.patches as patches
import re
import urllib
import json
from _overlapped import NULL
import numpy as np

MYAPP_KEY = '7e152a735ba9005a49be5f9b0ac22755'
url = "https://kapi.kakao.com/v1/vision/product/detect"

headers = {'Authorization': 'KakaoAK {}'.format(MYAPP_KEY)}

filename = 'C:/PINDMediaServer/'+str(sys.argv[1])
files = { 'file' : open(filename, 'rb')}

response = requests.post(url, headers=headers, files=files)
result = response.json()

fig_w, fig_h = result['result']['width'], result['result']['height']
img = mpimg.imread(filename)

fig,ax = plt.subplots(figsize=(10,10))
co = []
for obj in result['result']['objects']:
    x, y = obj['x1']*fig_w, obj['y1']*fig_h
    w, h = obj['x2']*fig_w - x, obj['y2']*fig_h - y
    rect = patches.Rectangle((x, y), w, h, lw=5, edgecolor='c', facecolor='none')
    ax.add_patch(rect)
    plt.text(x,y-10, obj['class'], size=18, color='red')
    co.append([int(x), int(x+w), int(y), int(y+h)])
    
    
ax.imshow(img)
# plt.show()

im = Image.open(filename)
i = 0

def get_main_color(file):
    img = Image.open(file)
    colors = img.getcolors(1920*1024) #put a higher value if there are many colors in your image
    max_occurence, most_present = 0, 0
    try:
        for c in colors:
            if c[0] > max_occurence:
                (max_occurence, most_present) = c
        return most_present
    except TypeError:
        raise Exception("Too many colors in the image")
colorRs = []        
for cx1, cx2, cy1, cy2 in co:
    innerCX1, innerCY1, innerCX2, innerCY2 = cx1+int((cx2-cx1)/4), cy1+int((cy2-cy1)/4), cx2-int((cx2-cx1)/4), cy2-int((cy2-cy1)/4)
    im2 = im.crop((innerCX1, innerCY1, innerCX2, innerCY2))
    cropfile = 'C:/PINDMediaServer/images/test_crop'+ str(i) +'.png'
    im2 = im2.resize((150,150))
    im2.save(cropfile, quality=95)
    i = i+1
    cR, cG, cB = get_main_color(cropfile)[0], get_main_color(cropfile)[1], get_main_color(cropfile)[2]
    
    if cR >= 185 and cG >= 185 and cB >= 185:
        print('White')
    elif cR <= 50 and cG <= 50 and cB <= 50:
        print('Black')
    elif cR >= 94 and cG <= cR and cG <= (cR-50) and cB < cR:
        print('Orange')
    elif cR >= 127 and cG >= 127 and (cB < cG or cB < cR) and (cR-cB==50 or cG-cB==50):
        print('Yellow')
    elif cR > 61 and cR < 94 and cG < 61 and cB >= 127:
        print('Navy')
    elif cR >= 127 and cG < 94 and cB >= 127:
        print('Purple')
    elif cR >= 127 and cG < (cR-30) and cB < (cR-50):
        print('Red')
    elif cR < (cG-50) and cG >= 127 and cB < (cG-50):
        print('Green')
    elif cR < (cB-50) and cG < cB and cB >= 127:
        print('Blue')
    elif cR >= 127 and cG >= 127 and cB >= 127:
        print('White')
    elif cR <= 61 and cG <= 61 and cB <= 61:
        print('Black')
    else:
        print('')