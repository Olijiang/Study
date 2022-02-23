from hashlib import new
import os, shutil
path = "E:\\Yellow\\eq\\"

dirs = os.listdir(path)

v_n = 1
i_n = 1
print('----------------------')
for i in dirs:
    file = os.listdir(path + i)
    for j in file:
        old_path = path + i + '\\' + j
        new_path = path + '\\' + j
        print(old_path)
        print(new_path)
        shutil.move(old_path, new_path)