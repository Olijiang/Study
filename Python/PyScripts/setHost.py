hostpath = "C:\\Windows\\System32\\drivers\\etc\\hosts"
import requests, threading, re
from bs4 import BeautifulSoup
header = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36 Core/1.77.101.400 QQBrowser/10.9.4622.400"}
print("waiting...")
ipstr = []
def getUrlIp():
    url = "https://github.com.ipaddress.com/"
    html = requests.get(url, headers=header)
    html.encoding = "utf-8"
    soup = BeautifulSoup(html.text, "lxml")
    UrlIp = soup.select('.comma-separated li')[0].text
    ipstr.append(UrlIp + "   " + 'github.com' + '\n')

def getDomainIp():
    url = "https://fastly.net.ipaddress.com/github.global.ssl.fastly.net"
    html = requests.get(url, headers=header)
    html.encoding = "utf-8"
    soup = BeautifulSoup(html.text, "lxml")
    DomainIp = soup.select('.comma-separated li')[0].text  
    ipstr.append(DomainIp + "   " + 'github.global.ssl.fastly.net' + '\n')

def getStaticIp():
    url = "https://github.com.ipaddress.com/assets-cdn.github.com"
    html = requests.get(url, headers=header)
    html.encoding = "utf-8"
    soup = BeautifulSoup(html.text, "lxml")
    StaticIp = soup.select('ul li strong')
    for i in range(4):
        ipstr.append(StaticIp[i].text + "   " + 'assets-cdn.github.com' + '\n')
        
thread = [] #线程池
thread.append(threading.Thread(target=getUrlIp))
thread.append(threading.Thread(target=getDomainIp))
thread.append(threading.Thread(target=getStaticIp))
for th in thread:
    th.start()
for th in thread:
    th.join()

try:
    with open(hostpath,"r+") as f:
        old = f.readlines(6000)
        f.seek(0)
        for each in ipstr:
            f.write(each)
        for each in old:
            if(re.search("github", each)):  #旧相关部分丢弃
                pass
            else:
                f.write(each)
        print("updata github ip successfully")
except:print("error")

for i in range(10000000):pass
