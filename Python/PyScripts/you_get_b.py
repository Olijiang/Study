import os,sys
import time

fir_time = time.time()
directory = 'F:\\Download\\'  # 设置下载目录
#url = 'https://www.bilibili.com/bangumi/play/ss34394'  # 需要下载的视频地址
url = input('URL:')
if url == '':
	sys.exit()
cookies = 'D:\\SOFTWARE\\Jupyter\\cookies.sqlite'  # cookie所在地址
cmd = 'you-get -i -c ' + cookies + ' ' + url  # 视频信息
os.system(cmd)
print('Time:{:.2f}s'.format(time.time() - fir_time))
confirm = input("DownLoad  Y/N:")
if confirm == 'Y' or 'y':
    Format = input("Format:")  # 根据提示选择下载信息
    con = input('DownLoad ALL? Y/N:')
    if con == 'Y' or 'y':
    	cmd = Format + ' -c ' + cookies + ' -o ' + directory + ' --playlist ' + url
    else:
    	cmd = Format + ' -c ' + cookies + ' -o ' + directory + ' ' + url
    print(cmd)
# os.system(cmd)
