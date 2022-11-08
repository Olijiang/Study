<template>
    <el-dialog style="border-radius: 10px;" v-model="editFlag" top="60px" width="90%" :close-on-click-modal=false
        :close-on-press-escape=false>
        <div class="header">
            <div class="title">
                <el-input style="font-size: 20px;" size="large" v-model="title" placeholder="标题"></el-input>
            </div>
            <div class="info">
                <el-row>
                    <el-col :span="12">
                        <el-select v-model="catagory" placeholder="选择分类" :filterable="true" :allow-create="true">
                            <el-option label="Java基础" value="1" />
                            <el-option label="Vue基础" value="2" />
                            <el-option label="Vuex基础" value="3" />
                        </el-select>
                    </el-col>
                    <el-col :span="12">
                        <el-select v-model="tag" placeholder="选择标签" collapse-tags :multiple="true" clearable
                            :filterable="true" :allow-create="true" fit-input-width>
                            <el-option label="Java" value="1" />
                            <el-option label="Vue" value="2" />
                            <el-option label="Html" value="3" />
                            <el-option label="Css" value="4" />
                        </el-select>
                    </el-col>
                </el-row>
            </div>

        </div>
        <div class="content">
            <div class="markdown">
                <el-input style="font-size: 18px;" type="textarea" :rows="20" v-model="markdownContent" resize="none"
                    placeholder="文章内容"></el-input>
            </div>
            <div class="resize" @mousedown="drapContent" @dblclick="resetSize"></div>
            <div class="html" v-html="htmlContent"></div>
        </div>
        <el-button type="primary" @click="saveToScript">保存到草稿</el-button>
        <el-button type="primary" @click="saveAndIssue">发表</el-button>
        <el-button type="danger" @click="closeAndSaveToScript">关闭</el-button>
    </el-dialog>

</template>

<script>
import markdownToHtml from '@/utils/markdown'
import { set } from 'lodash';
export default {
    components: {

    },
    props: {},
    data() {
        return {
            title: "",
            catagory: "",
            tag: "",
            markdownContent: ""
        };
    },
    methods: {
        drapContent(e) {
            let left = document.getElementsByClassName("markdown")[0];
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
            this.editFlag = false
        },
        saveAndIssue() {
            this.editFlag = false
        },
        closeAndSaveToScript() {
            this.editFlag = false
        }
    },
    computed: {
        htmlContent() {
            return markdownToHtml(this.markdownContent)
        },
        editFlag: {
            get() {
                return this.$store.state.editFlag
            },
            set(value) {
                this.$store.state.editFlag = value
            }
        }
    }
}

</script>

<style lang='less' scoped>
.header {
    justify-content: space-between;
    display: flex;
    height: 50px;

    .title {
        flex: 0 0 40%;
    }

    .info {
        flex: 0 0 45%;
    }
}

.content {
    justify-content: space-between;
    display: flex;
    width: 100%;
    height: 550px;
    margin: 0 0 20px 0;

    .markdown {

        font-size: 16px;
        // border: 1px slateblue solid;
        width: 50%;
        min-width: 200px;
        // flex: 0 0 50%;
        height: 100%;
    }

    .resize {
        cursor: col-resize;

        width: 8px;
        height: 100px;
        margin: 200px 5px;
        background: linear-gradient(45deg, rgba(255, 13, 0, 0.6), rgba(51, 255, 0, 0.6), rgba(0, 251, 255, 0.6), rgba(0, 60, 255, 0.6), rgba(230, 0, 255, 0.6));
        border-radius: 5px;
    }

    .html {
        overflow-y: auto;
        overflow-x: hidden;
        border-radius: 5px;
        border: 1px rgb(184, 184, 184) solid;
        font-size: 16px;
        width: 48%;
        min-width: 180px;
        height: 100%;
        padding: 0 5px;
    }
}
</style>

