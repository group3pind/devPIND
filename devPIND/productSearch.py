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

def make_naver_search_api_url(node, search_text, start_num, disp_num):
    base_url = 'https://openapi.naver.com/v1/search/' + node + '.json'
    param_query = "?query=" + urllib.parse.quote(search_text)
    param_start = "&start=" + str(start_num)
    param_disp = "&display=" + str(disp_num)
    return base_url + param_query + param_start + param_disp

import urllib.request
def get_request_url(API_url, client_id, client_secret):
    request = urllib.request.Request(API_url)
    request.add_header("X-Naver-Client-Id", client_id)
    request.add_header("X-Naver-Client-Secret", client_secret)
    
    response = urllib.request.urlopen(request)
    if response.getcode() == 200:
        return response.read().decode('utf-8')
    else:
        return None
        print("--- error ---")
        
api_url = make_naver_search_api_url('shop', str(sys.argv[1]), 1, 10)
print(get_request_url(api_url, 'kLYegliLCjVlAjPVO4gX', 'MxUu6RPoKO'))