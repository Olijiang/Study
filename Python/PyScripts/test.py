from wsgiref.headers import Headers
import requests, json

url = "https://yz.scu.edu.cn/score/Query--"
headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36',
        'X-Requested-With': 'XMLHttpRequest'}

data = {'zjhm':'513022199703256697','xm':'张国彬', 'ksbh':'106102085411946'}
#Headers = {'Content-type':'application/x-www-form-urlencoded'}
req =requests.post(url,data=data,headers=headers)
print (req.text)

			