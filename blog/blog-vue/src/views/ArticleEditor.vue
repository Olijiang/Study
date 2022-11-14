<template>
    <el-dialog style="border-radius: 10px; z-index: 2;margin-bottom: 100px;" v-model="editDialog" top="60px" width="90%"
        :close-on-click-modal=false :close-on-press-escape=false>
        <el-form id="myform" :model="article" ref="articleRef" :rules="rules">
            <div class="header">
                <el-row>
                    <el-col :span="12">
                        <div class="title">
                            <el-form-item prop="title">
                                <el-input style="font-size: 20px;" size="large" v-model="article.title"
                                    placeholder="标题">
                                </el-input>
                            </el-form-item>
                        </div>
                        <div class="info">
                            <el-row>
                                <el-col :span="7">
                                    <el-form-item prop="category">
                                        <el-select v-model="article.category" placeholder="选择分类">
                                            <el-option v-for="(c, index) in categories" :key="index" :label="c"
                                                :value="c">
                                            </el-option>
                                            <div style="margin: 0 15px;">
                                                <el-input v-model="newCategory" placeholder="新建分类" type="text"
                                                    @keyup.enter="addCategory"></el-input>
                                            </div>
                                        </el-select>
                                    </el-form-item>
                                </el-col>

                                <el-col :span="1"></el-col>
                                <el-col :span="7">
                                    <el-form-item prop="tag">
                                        <el-select v-model="article.tag" placeholder="选择标签" collapse-tags
                                            :multiple="true" clearable>
                                            <el-option v-for="(c, index) in tags" :key="index" :label="c" :value="c">
                                            </el-option>
                                            <div style="margin: 0 15px;">
                                                <el-input v-model="newTag" placeholder="新建标签" type="text"
                                                    @keyup.enter="addTag">
                                                </el-input>
                                            </div>
                                        </el-select>
                                    </el-form-item>
                                </el-col>
                                <el-col :span="1"></el-col>
                                <el-col :span="8">
                                    <el-upload ref="uploadRef" class="upload-demo" name="illustrate" action="#"
                                        accept=".png, .jpg" :http-request="uploadHandler" :limit="1"
                                        :on-remove="imgRemove">
                                        <template #trigger>
                                            <el-button type="primary">选择插图</el-button>
                                        </template>
                                    </el-upload>
                                </el-col>
                            </el-row>
                        </div>
                    </el-col>

                    <el-col :span="1"></el-col>

                    <el-col :span="6">
                        <div v-if="imgOK" style="height:150px;width: 250px; translate:0 -30px ;">
                            <img :src="article.img" alt="">
                        </div>
                    </el-col>
                    <el-col :span="4">
                        <div>
                            <el-button type="primary" @click="saveToScript">保存到草稿</el-button>
                        </div>
                        <div style="margin: 10px 0;">
                            <el-button type="primary" @click="saveAndIssue">发表</el-button>
                        </div>
                        <div style="margin: 10px 0;">
                            <el-button type="danger" @click="closeAndSaveToScript">关闭</el-button>
                        </div>
                    </el-col>

                </el-row>
            </div>
            <div class="content">
                <div class="markdown-body">
                    <el-input style="font-size: 18px;height: 100%;" type="textarea" v-model="article.content"
                        resize="none" placeholder="文章内容"></el-input>
                </div>
                <div class="resize" @mousedown="drapContent" @dblclick="resetSize"></div>
                <div class="html" v-html="htmlContent"></div>
            </div>
        </el-form>
        <el-button type="primary" @click="saveToScript">保存到草稿</el-button>
        <el-button type="primary" @click="saveAndIssue">发表</el-button>
        <el-button type="danger" @click="closeAndSaveToScript">关闭</el-button>
        <el-button type="danger" @click="test">test</el-button>

        <backToTopVue></backToTopVue>
        <el-backtop></el-backtop>
    </el-dialog>
</template>

<script>
import backToTopVue from '@/components/backToTop.vue';
import markdownToHtml from '@/utils/markdown'
import API from '../utils/API';
export default {
    components: {
        backToTopVue
    },
    props: {
        tags: Array,
        categories: Array,
        propArticle: Object,
    },
    data() {
        return {
            newCategory: "",
            newTag: "",
            imgOK: false,
            editFlag: false,
            article: {
                title: "",
                category: "",
                tag: [],
                content: "",
                img: ""
            },
            rules: {
                title: { required: true, message: "请输入标题", trigger: 'blur' },
                category: { required: true, message: "请选择分类", trigger: 'blur' },
                tag: { required: true, message: "请选择标签", trigger: 'blur' }
            }
            // textareaT: {}
        };
    },
    methods: {
        test() {

        },
        uploadHandler(file) {
            // console.log(file.file);
            let _file = file.file
            let reader = new FileReader()
            reader.readAsDataURL(_file)
            reader.onload = e => {
                this.article.img = e.target.result
                this.imgOK = true
            }
        },
        imgRemove() {
            this.imgOK = false
        },
        addCategory() {
            console.log("add new category", this.newCategory);
            this.categories.push(this.newCategory)
            this.article.category = this.newCategory
            this.newCategory = ""
        },
        addTag() {
            console.log("add new tag", this.newTag);
            this.tags.push(this.newTag)
            this.article.tag.push(this.newTag)
            this.newTag = ""
        },
        drapContent(e) {
            let left = document.getElementsByClassName("markdown-body")[0];
            let right = document.getElementsByClassName('html')[0];

            let leftWid = window.getComputedStyle(left).getPropertyValue('width')
            let rightWid = window.getComputedStyle(right).getPropertyValue('width')

            let oldX = e.clientX;
            document.onmousemove = function (e) {
                // 移动的距离
                let diffX = (e.clientX - oldX);
                if (leftWid.slice(0, -2) > 100 && rightWid.slice(0, -2) > 100) {
                    // 左右宽度大于100时可拉动
                    left.style.width = `calc(${leftWid} + ${diffX}px)`;
                    right.style.width = `calc(${rightWid} - ${diffX}px)`;
                    // console.log("left:", leftWid, "         rirgt:", rightWid, "  diffX", diffX);
                }
            }
            document.onmouseup = function () {
                document.onmousemove = null;
                document.onmouseup = null;
            }
        },
        resetSize() {
            let left = document.getElementsByClassName("markdown")[0];
            let right = document.getElementsByClassName('html')[0];
            left.style.width = `50%`;
            right.style.width = `calc(50% - 20px)`;
            document.onmouseup = function () {
                document.onmousemove = null;
                document.onmouseup = null;
            }
        },
        saveToScript() {

            // this.editDialog = false
        },
        saveAndIssue() {
            this.$refs['articleRef'].validate((valid) => {
                if (valid) {
                    if (this.article.img == "") {
                        ElMessage({
                            showClose: true,
                            message: "请选择一张插图",
                            type: 'warning',
                        })
                        return
                    }
                    if (this.article.content == "") {
                        ElMessage({
                            showClose: true,
                            message: "内容不能为空",
                            type: 'warning',
                        })
                        return
                    }
                    if (this.editFlag) {
                        // 修改
                        API.post("api/article/updata", this.article)
                            .then(res => {
                                if (res.code == 200) {
                                    ElMessage({
                                        type: 'success',
                                        message: '修改成功',
                                    })
                                }
                            })
                    } else {
                        // 新增
                        API.post("api/article/add", this.article)
                            .then(res => {
                                if (res.code == 200) {
                                    ElMessage({
                                        type: 'success',
                                        message: '发表成功',
                                    })
                                }
                            })
                    }
                    this.editDialog = false

                }
            })

        },
        resetForm() {
            this.$refs['articleRef'].resetFields()
        },
        closeAndSaveToScript() {
            this.editDialog = false
        }
    },
    computed: {
        htmlContent() {
            return markdownToHtml(this.article.content)
        },
        editDialog: {
            get() {
                return this.$store.state.editDialog
            },
            set(value) {
                this.$store.state.editDialog = value
            }
        }
    },
    watch: {
        propArticle: {
            deep: true,
            handler() {
                this.article.title = this.propArticle.title
                this.article.content = this.propArticle.content
                this.article.tag = JSON.parse(this.propArticle.tag).tags
                this.article.category = this.propArticle.category
                this.article.img = "api/" + this.propArticle.img
                this.imgOK = true
                this.editFlag = true
            }
        },

        editDialog: {
            handler() {
                setTimeout(() => {
                    this.resetForm()
                }, 100);
            }
        }
    },
    mounted() {

    }
}

</script>

<style lang='less' scoped>
.header {
    .title {
        margin: 0 0 30px 0;
        width: 80%;
    }

    .info {
        margin: 0 0 20px 0;
    }

    img {
        height: 100%;
        width: 100%;
        object-fit: cover;
        vertical-align: middle;
    }
}

.content {
    z-index: 20;
    position: relative;
    justify-content: space-between;
    display: flex;
    width: 100%;
    min-height: 500px;
    margin: 0 0 20px 0;

    .markdown-body {
        font-size: 16px;
        width: 50%;
        min-width: 200px;
        height: auto;
    }

    .resize {
        position: sticky;
        top: 25vh;
        cursor: col-resize;
        width: 8px;
        height: 100px;
        margin: calc(25% - 100px) 5px;
        background: linear-gradient(45deg, rgba(255, 13, 0, 0.6), rgba(51, 255, 0, 0.6), rgba(0, 251, 255, 0.6), rgba(0, 60, 255, 0.6), rgba(230, 0, 255, 0.6));
        border-radius: 5px;
    }

    .html {
        overflow-y: auto;
        overflow-x: hidden;
        border-radius: 5px;
        border: 1px rgb(214, 214, 214) solid;
        font-size: 16px;
        width: 48%;
        min-width: 180px;
        padding: 0 5px;
    }
}
</style>

