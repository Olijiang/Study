from cgi import print_arguments
from errno import ESTALE
from lib2to3.pgen2.pgen import generate_grammar
import os
from traceback import print_tb
from PIL import Image
import numpy as np
import tensorflow as tf

path = "../sample/train/" # 图片路径
x_train_path = "../sample/x_train_path"
y_train_path = "../sample/y_train_path"
x_test_path = "../sample/x_test_path"
y_test_path = "../sample/y_test_path"

def gen_datasets(path):
    imgs = os.listdir(path)
    total = len(imgs)

    x_train = [] #特征
    y_train = [] #标签
    x_test = [] #特征
    y_test = [] #标签

    #训练集
    for i in range(int(total*0.95)):
        print("Loding:"+imgs[i])
        imgpath = path+imgs[i]
        img = Image.open(imgpath)
        img = np.array(img.convert("L"))
        img = img/255
        x_train.append(img)
        y_train.append(imgs[i].split("_")[1][:-4])
    #测试集
    for i in range(int(total*0.95),total):
        print("Loding:"+imgs[i])
        imgpath = path+imgs[i]
        img = Image.open(imgpath)
        img = np.array(img.convert("L"))
        img = img/255
        x_test.append(img)
        y_test.append(imgs[i].split("_")[1][:-4])

    x_train, y_train = np.array(x_train), np.array(y_train)
    x_test, y_test = np.array(x_test), np.array(y_test)

    return (x_train, y_train), (x_test, y_test)

# 生成数据集
if os.path.exists(x_train_path) and os.path.exists(y_train_path) and os.path.exists(x_test_path) and os.path.exists(y_test_path):
    print("Loding dataset:----->")
    x_train_save = np.load(x_train_path)
    y_train = np.load(y_train_path)
    x_test_save = np.load(x_test_path)
    y_test = np.load(y_test_path)
    x_train = np.reshape(x_train_save, (len(x_train_save), 60, 22))
    x_test = np.reshape(x_test_save, (len(x_test_save), 60, 22))
else:
    print("Generate Datasets:----->")
    (x_train, y_train), (x_test, y_test) = gen_datasets(path)
    print("Save Datasets:----->")
    x_train_save = np.reshape(x_train, (len(x_train), -1))
    x_test_save = np.reshape(x_test, (len(x_test), -1))
    np.save(x_train_path, x_train)
    np.save(y_train_path, y_train)
    np.save(x_test_path, x_test)
    np.save(y_test_path, y_test)

model = tf.keras.models.Sequential([
    tf.keras.layers.Flatten(),
    tf.keras.layers.Dense(128, activation="relu"),
    tf.keras.layers.Dense(10, activation="softmax")])

model.compile(optimizer="adam",
              loss=tf.losses.SparseCategoricalCrossentropy(from_logits=False),
              metrics=["sparse_categorical_accuracy"])

model.fit(x_train, y_train, batch_size=32, epochs=5, validation_data=(x_test, y_test), validation_freq=1)

model.summary()