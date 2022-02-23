import os, shutil

def rename_0(path):
	#修改一级文件下的文件名
	path = "D:\\Game\恶犬\\picture\\"
	imgs = os.listdir(path)
	n = 1
	pre = "pi_"
	for i in imgs:
		old_path = path + i
		if(os.path.isdir(old_path)):continue
		new_path = path +pre + str(n) + ".jpg"
		n = n + 1 
		#print(old_path)
		#print(new_path)
		try:
			os.rename(old_path,new_path)
		except Exception as e:
			print(e)
			exit()

def rename_2(path):
	#修改二级文件下的文件名
	dirs = os.listdir(path)
	n = 10000
	pre = "p"
	for i in dirs:
		old_path = path + i
		if(os.path.isdir(old_path)):
			files = os.listdir(path+i)
			for f in files:
				old_path = path + i + '\\' + f
				new_path = path + i + '\\' + pre + str(n) + f[-4:]
				n = n + 1 
				#print(old_path)
				#print(new_path)
				try:
					os.rename(old_path,new_path)
				except Exception as e:
					print(e)
					exit()
			
def remove(path):
	dirs = os.listdir(path)
	for i in dirs:
		old_path = path + i
		if(os.path.isdir(old_path)):
			file = os.listdir(path + i)
			for j in file:
				old_path = path + i + '\\' + j
				new_path = path + '\\' + j
				#print(old_path)
				#print(new_path)
				shutil.move(old_path, new_path)

def rename_1(path):
	#修改一级文件下的文件名
	imgs = os.listdir(path)
	n = 1
	pre = "PI_"
	for i in imgs:
		old_path = path + i
		if(os.path.isdir(old_path)):continue
		new_path = path +pre + str(n) + i[-4:]
		n = n + 1 
		#print(old_path)
		#print(new_path)
		try:
			os.rename(old_path,new_path)
		except Exception as e:
			print(e)
			exit()


#path = "E:\\Yellow\\快点亲亲我吖\\video\\"
#path = "E:\\Yellow\\恶犬\\picture\\"
#path = "E:\\Yellow\\茜公主\\video\\"
path = "D:\\Game\\小猫\\picture\\"

#rename_2(path)
#remove(path)
rename_1(path)