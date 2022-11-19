<template>
    <div>
        <el-row style="margin-top: 50px;">
            <el-col class="space"></el-col>
            <el-col class="container">
                <el-row>
                    <div style="margin:0 0 1% 2.5%;height: 30px; opacity: 0.7;">
                        <el-button v-if="isLogin" type="primary" @click="uploadDialog = true">上传</el-button>
                    </div>
                </el-row>
                <el-row class="header">
                    <el-col class="item" v-for="item in album" :key="item.id">
                        <img class="cover" :src="item.coverImg">
                        <span class="fenlei">分类</span>
                        <hr class="line" align="center" />
                        <span class="jutifenlei">{{ item.name }}</span>
                    </el-col>
                </el-row>
                <el-row class="fengexian">
                    <el-col :span="1"></el-col>
                    <el-col :span="10" style="margin:1% 0;">
                        <hr width="100%" align="left" />
                    </el-col>
                    <el-col :span="2" style="color: deeppink;margin:1% 0">
                        <span>精选</span>
                    </el-col>
                    <el-col :span="10" style="margin:1% 0;">
                        <hr width="100%" align="right" />
                    </el-col>
                    <el-col :span="1"></el-col>
                </el-row>

                <el-row class="body">

                    <el-col class="item" v-for=" (item, index) in photos1" :key="index">
                        <el-image class="photo" :src="item.img" :preview-src-list="realImg" fit="cover"
                            :initial-index="index" :preview-teleported="true" :hide-on-click-modal=true />

                        <!-- <img :src="item.img" alt=""> -->
                    </el-col>
                </el-row>
                <!-- <el-row class="body1">

                    <el-col class="item" v-for=" (item, index) in photos2" :key="index">
                        <img :src="item.img" alt="">
                    </el-col>

                </el-row> -->
            </el-col>
            <el-col class="space"></el-col>
        </el-row>
        <el-dialog v-model="uploadDialog" top="60px" width="64%" style="min-width: 820px;border-radius: 20px;"
            :close-on-click-modal="false" :close-on-press-escape=false :append-to-body="true">
            <div style="margin-left: 2%;">
                <el-upload v-model:file-list="fileList" ref="uploadRef" list-type="picture-card"
                    :on-preview="handlePictureCardPreview" :on-remove="handleRemove" :http-request="uploadHandler"
                    :on-exceed="exceedHandler" multiple :limit="50">
                    <el-icon>
                        <Plus />
                    </el-icon>
                </el-upload>
            </div>
            <!-- <div style="width: 150px;height: 150px;">
                <img :src="test" alt="" style="width: 100%;">
            </div> -->
            <div style="margin: 2% 0 0 2%;">
                <el-button type="primary" @click="upload">上传</el-button>
                <el-button type="primary" @click="clearAll">清空全部</el-button>
                <el-button type="primary" @click="clearUpload">清空已上传</el-button>
                <el-button type="danger" @click="close">关闭</el-button>
                <div style="display: inline-block;margin-left: 2%;max-width: 150px;">
                    <el-select v-model="albumName" placeholder="选择相册">
                        <el-option v-for="(c, index) in albums" :key="index" :label="c" :value="c">
                        </el-option>
                        <div style="margin: 0 15px;">
                            <el-input v-model="newAlbum" placeholder="新建相册" type="text" @keyup.enter="addAlbum">
                            </el-input>
                        </div>
                    </el-select>
                </div>
                <div style="margin-top: 2%;">
                    <el-progress :percentage="progress.percentage" v-show="progress.show" :status="progress.status" />
                </div>

            </div>


            <el-dialog v-model="dialogVisible" width="70%" top="60px" style="background-color: transparent;">
                <div class="previewDialog">
                    <img :src="dialogImageUrl" />
                </div>
            </el-dialog>
        </el-dialog>

    </div>
</template>

<script>

import { Plus } from '@element-plus/icons-vue'
import API from '../utils/API';

export default {
    components: {
        Plus
    },
    props: {},
    data() {
        return {
            album: [
                { id: 1, name: "全部", coverImg: "src/img/1.png" },
                { id: 2, name: "人物", coverImg: "src/img/2.png" },
                { id: 3, name: "风景", coverImg: "src/img/3.png" },
                { id: 4, name: "科幻", coverImg: "src/img/5.jpg" },
            ],
            photos1: [
                { img: "src/img/p1.png", realImg: "src/img/1.png" },
                { img: "src/img/p2.jpg", realImg: "src/img/1.png" },
                { img: "src/img/p3.jpg", realImg: "src/img/1.png" },
                { img: "src/img/p4.jpg", realImg: "src/img/1.png" },
                { img: "src/img/p1.png", realImg: "src/img/1.png" },
                { img: "src/img/p2.jpg", realImg: "src/img/1.png" },
                { img: "src/img/p3.jpg", realImg: "src/img/1.png" },
                { img: "src/img/p4.jpg", realImg: "src/img/1.png" },
            ],
            realImg: [
                "src/img/p1.png",
                "src/img/p2.jpg",
                "src/img/p3.jpg",
                "src/img/p4.jpg",
                "src/img/p1.png",
                "src/img/p2.jpg",
                "src/img/p3.jpg",
                "src/img/p4.jpg",
            ],
            // dialog
            progress: {
                percentage: 0,
                show: false,
                status: ""
            },
            albumName: "",
            newAlbum: "",
            albums: ["人物", "风景", "科幻"],
            isfull: false,
            uploadDialog: false,
            fileList: [],
            dialogImageUrl: "",
            dialogVisible: false
        }
    },
    methods: {
        addAlbum() {
            this.albums.push(this.newAlbum);
            this.albumName = this.newAlbum
            this.newAlbum = ""
        },
        handleRemove(uploadFile, uploadFiles) {
            console.log(uploadFile, uploadFiles)
        },
        handlePictureCardPreview(uploadFile) {
            this.dialogImageUrl = uploadFile.url
            this.dialogVisible = true
        },
        dealImage(rawbase64) {
            var newImage = new Image();
            var quality = 0.9;    //压缩系数0-1之间
            newImage.src = rawbase64;
            newImage.setAttribute("crossOrigin", 'Anonymous');	//url为外域时需要
            var imgWidth, imgHeight;
            return new Promise(resolve => {
                newImage.onload = async function () {
                    imgWidth = this.width;
                    imgHeight = this.height;
                    var canvas = document.createElement("canvas");
                    var ctx = canvas.getContext("2d");
                    let size = 1920 // 设置压缩尺寸大小
                    if (Math.max(imgWidth, imgHeight) > size) {
                        if (imgWidth > imgHeight) {
                            canvas.width = size;
                            canvas.height = size * imgHeight / imgWidth;
                        } else {
                            canvas.height = size;
                            canvas.width = size * imgWidth / imgHeight;
                        }
                    } else {
                        canvas.width = imgWidth;
                        canvas.height = imgHeight;
                        quality = 1;
                    }
                    ctx.clearRect(0, 0, canvas.width, canvas.height);
                    ctx.drawImage(this, 0, 0, canvas.width, canvas.height);
                    var base64 = canvas.toDataURL("image/jpeg", quality); //压缩语句
                    // 如想确保图片压缩到自己想要的尺寸
                    while (base64.length / 1024 > 500) {
                        quality -= 0.05;
                        base64 = canvas.toDataURL("image/jpeg", quality);
                    }
                    // 防止最后一次压缩低于最低尺寸，只要quality递减合理，无需考虑
                    // while (base64.length / 1024 < 5) {
                    //     quality += 0.01;
                    //     base64 = canvas.toDataURL("image/jpeg", quality);
                    // }
                    resolve(base64)
                }
            })

        },

        uploadHandler(file) {
            let _file = file.file
            // console.log(_file);
            // let reader = new FileReader()
            // reader.readAsDataURL(_file)
            // reader.onload = async e => {
            //     // let base64 = await this.dealImage(e.target.result)
            //     // console.log(base64);
            // }
        },
        exceedHandler() {
            ElMessage({
                showClose: true,
                message: "图片数量超出限制",
                type: 'warning',
            })
        },
        upload() {
            if (this.albumName == "") {
                ElMessage({
                    showClose: true,
                    message: "请选择相册",
                    type: 'warning',
                })
                return
            }
            this.progress.show = true
            this.progress.percentage = 0
            let unit = Math.round((1 / this.fileList.length) * 100)
            this.fileList.forEach(e => {
                if (e.status == "ready") {
                    e.status = "uploading"
                    e.percentage = Math.round(20 * Math.random())
                    let data = {
                        albumName: this.albumName,
                        simplifyImg: "",
                        originalImg: ""
                    }
                    let reader = new FileReader()
                    reader.readAsDataURL(e.raw)
                    reader.onload = async e => {
                        data.originalImg = e.target.result
                        data.simplifyImg = await this.dealImage(e.target.result)
                    }
                    console.log(data);
                    API.post("album/add", data)
                        .then(res => {
                            if (res.code == 200) {
                                e.status = "success"
                                if (this.progress.percentage + unit > 95) {
                                    this.progress.percentage = 100
                                    this.progress.status = "success"
                                }
                                else {
                                    this.progress.percentage += unit
                                }
                            } else {
                                e.status = "fail"
                                this.progress.status = "warning"
                            }
                        }).catch(err => {
                            e.status = "fail"
                            this.progress.status = "exception"
                        })
                }
            })
        },
        clearAll() {
            this.fileList = []
        },
        clearUpload() {
            let len = this.fileList.length
            for (let i = 0; i < len; i++) {
                if (this.fileList[i].status == "success") {
                    this.fileList.splice(i, 1)
                    i--;
                    len--;
                }
            }
        },
        close() {
            this.uploadDialog = false
            this.progress.show = false
            this.progress.status = ""
            this.progress.percentage = 0

        }
    },
    computed: {
        isLogin: {
            set(value) {
                this.$store.state.isLogin = value;
            },
            get() {
                return this.$store.state.isLogin;
            }
        }
    },
    watch: {

    },
    mounted() {

    },
}
</script>

<style lang='less' scoped>
@transition: all 0.5s ease-in-out;

.container {
    max-width: 96%;
    flex: 0 0 96%;
}

.header {
    height: 200px;
    transition: @transition;
}

.body {
    transition: @transition;
}


.space {
    height: 100%;
    max-width: 2%;
    flex: 0 0 2%;
}

.item {
    position: relative;
    cursor: pointer;
    border-radius: 5px;
    height: 200px;
    max-width: 20%;
    flex: 0 0 20%;
    min-width: 200px !important;
    margin: 0 2.5% 2%;
    // border: 1px solid skyblue;
    transition: @transition;

    .cover {
        opacity: 0.7;
        z-index: -1;
        top: 0;
        left: 0;
        position: absolute;
        height: 100%;
        width: 100%;
        // object-fit: cover;
        // vertical-align: middle;
        transition: all 0.5s ease-in-out;
        border-radius: 10px;
    }

    .photo {
        z-index: -1;
        top: 0;
        left: 0;
        position: absolute;
        height: 100%;
        width: 100%;
        // object-fit: cover;
        // vertical-align: middle;
        transition: all 0.5s ease-in-out;
        border-radius: 10px;
    }

    .line {
        width: 100px;
        transition: @transition;
    }

    .fenlei {
        display: block;
        font-size: 20px;
        margin-top: 20%;
        transition: @transition;
    }

    .jutifenlei {
        color: rgb(0, 255, 170);
        display: block;
        font-size: 25px;
        transition: @transition;
    }

    &:hover {
        .line {
            width: 100%;
        }

        .jutifenlei {
            // color: skyblue;
            font-size: 40px;
        }

        .cover {
            transform: scale(1.1, 1.1);
            opacity: 0.5;
        }

        .photo {
            transform: scale(1.1, 1.1);
        }
    }
}

@media (max-width: 1060px) {
    .header {
        height: 150px;
    }

    .body {
        margin-top: 20px;
    }


    .item {
        height: 150px;
        max-width: 20%;
        flex: 0 0 20%;
        min-width: 150px !important;
    }

    .fengexian {
        margin-top: 20px;
    }
}

@media (max-width: 800px) {
    .header {
        height: 350px;
        flex-wrap: wrap;
    }

    .body {
        margin-top: 10px;
        flex-wrap: wrap;
    }

    .fengexian {
        margin-top: 0px;
    }

    .item {
        height: 150px;
        max-width: 45%;
        flex: 0 0 45%;
        min-width: 200px !important;
    }
}

.previewDialog {
    z-index: 2;
    width: 100%;
    height: 80%;

    img {
        z-index: 10;
        width: 100%;
        object-fit: cover;
    }
}
</style>