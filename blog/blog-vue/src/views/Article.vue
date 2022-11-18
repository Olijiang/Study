<template>
    <div class="body">
        <div style="display: flex;justify-content: space-between;">
            <div>
                <div style="width: 200px;display: inline-block;opacity: 0.5;">
                    <el-input v-model="query" />
                </div>
                <div style="margin-left: 20px;display: inline-block;opacity: 0.5;">
                    <el-button color="#626aef" @click="queryHandler">查找</el-button>
                </div>
            </div>

            <div style="margin-left: 20px;opacity: 0.7;" v-if="isLogin">
                <el-button color="#ffae19" @click="addHandler">写文章</el-button>
            </div>
        </div>

        <div v-for="(article, index) in articleList" :key="article.id" :data-index="index" class="article">
            <div class="content">
                <div>
                    <span class="title" @click="articleDeail(article.id)">{{ article.title }} &#160;</span>
                    <span> 时间:</span>
                    <span style="color: #d63a3a;font-size: 90%;">{{ article.createTime }} &#160;</span>
                    <span> 分类:</span>
                    <span style="color: #d63a3a;font-size: 90%;"> {{ article.category }} &#160;</span>
                    <span> 标签:</span>
                    <span style="color: #d63a3a;font-size: 90%;" v-for=" (item, index) in article.tag" :key="index">
                        {{ item }}
                        <span style="color: #00c6a5;"> </span>
                    </span>

                </div>
                <div style="margin: 4px 0; text-indent: 2em;line-height: 20px;">{{ article.digest }}
                </div>
            </div>
            <div class="but" v-if="isLogin">
                <div class="buttom">
                    <el-button type="primary" @click="editHandler(article.id)">编辑</el-button>
                </div>
                <div class="buttom">
                    <el-button type="danger" @click="deleteHandler(article.id)">删除</el-button>
                </div>

            </div>
        </div>

        <ArticleEditorVue :categories="categories" :tags="tags"></ArticleEditorVue>
    </div>

</template>

<script>

import API from '../utils/API'
import ArticleEditorVue from './ArticleEditor.vue'
export default {
    components: {
        ArticleEditorVue,

    },
    props: {},
    data() {
        return {
            query: "",
            articleList: [],
            queryData: {
                authorId: "",
                startPage: 0,
                pageSize: 10
            },
            categories: [],
            tags: []
        }
    },
    methods: {

        queryHandler() {

        },
        addHandler() {
            //清除arcticle
            this.$store.commit("clearArticle")
            this.editDialog = true
        },
        editHandler(aricleId) {
            // 文章信息
            let data = { "ArticleId": aricleId }
            API.get('init/getArticle', data)
                .then(res => {
                    if (res.code == 200) {
                        this.$store.commit("setArticle", res.data)
                        setTimeout(() => {
                            this.editDialog = true
                        }, 100);

                    }
                })
        },
        deleteHandler(aricleId) {

        },
        articleDeail(value) {
            this.$router.push({
                path: "ArticleDetail/" + value
            })
        }
    },
    computed: {
        editDialog: {
            get() {
                return this.$store.state.editDialog
            },
            set(value) {
                this.$store.state.editDialog = value
            }
        },
        isLogin: {
            set(value) {
                this.$store.state.isLogin = value;
            },
            get() {
                return this.$store.state.isLogin;
            }
        },
        authorId() {
            if (this.$store.isLogin)
                return this.$store.state.authorId
            return this.$store.state.defaultAuthorId
        }
    },
    watch: {

    },
    mounted() {
        this.queryData.authorId = this.authorId
        API.get('init/getArticleList', this.queryData)
            .then(res => {
                res.data.forEach(element => {
                    element.tag = JSON.parse(element.tag).tags
                    element.digest = element.digest.replace(/#*.*#/g, '').replace(/[^a-z0-9\u4e00-\u9fa5]/, '').substring(0, 200) // 除去标题部分，截取200个字用来显示
                    this.articleList.push(element)

                });
            })

        let data = { "authorId": this.authorId }
        API.get('init/tags/', data)
            .then(res => {
                this.tags = res.data
            })
        API.get('init/category/', data)
            .then(res => {
                this.categories = res.data
            })
    },
}

</script>

<style lang='less' scoped>
.body {
    text-align: left;
    margin: 60px 3% 30px 3%;
}

.article {
    display: flex;
    justify-content: space-between;
    border: 1px solid rgba(220, 220, 220, 0.6);
    // box-shadow: 0 0px 5px rgba(221, 221, 221, 0.6);
    border-radius: 10px;
    overflow: hidden;
    margin: 15px 0;
    background-color: rgba(255, 255, 255, 0.3);
    padding: 0 10px;
    height: 80px !important;
    transition: all 0.5s;

    &:hover {
        border: 1px solid #5dfaff;
        box-shadow: 0 0 10px #5dfaff;
        transition: all 0.2s ease-in-out;
    }

    .title {
        margin-top: 5px;
        font-size: 20px;
        color: #4b9797;
        display: inline-block;
        cursor: pointer;
        transition: all 0.2s;

        &:hover {
            color: #04d6a2;
        }
    }
}

.content {
    width: 85%;
}

.but {
    margin: auto 0;
    width: 160px;

    .buttom {
        opacity: 0.7;
        display: inline-block;
        margin: 0 0 0 10px;
    }
}

@media(max-width: 650px) {
    .article {
        height: 160px !important;

        .title {
            display: block;
            margin-bottom: 10px;
        }
    }

    .but {
        margin: auto 0;
        width: 80px;

        .buttom {
            display: block;
            margin: 10px 0 0 20px;
        }
    }
}
</style>