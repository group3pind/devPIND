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
    print(obj['class'])
    plt.text(x,y-10, obj['class'], size=18, color='red')
    co.append([int(x), int(x+w), int(y), int(y+h)])
    
    
ax.imshow(img)
# plt.show()