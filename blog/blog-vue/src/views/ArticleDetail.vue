<template>
    <div>
        <transition name="el-fade-in">
            <div class="illustration">
                <img src="../img/5.jpg" alt="">
                <div class="ArticleInfo">
                    <h1 style="margin: 10px;"> 文章标题 </h1>
                    <p style="margin: 10px;"> info </p>
                </div>
            </div>
        </transition>
        <el-row>
            <el-col class="space"></el-col>
            <el-col class="articleRow">
                <div class="articleBody" v-html='articleBody'>

                </div>
            </el-col>
            <el-col class="space"></el-col>
            <el-col class="contentRow">
                <!-- 目录 -->
                <div class="articleContent">
                    文章目录
                </div>

            </el-col>
        </el-row>


        <backToTop></backToTop>
    </div>
</template>

<script>
import backToTop from '@/components/backToTop.vue'
import API from '../utils/API';
import { marked } from 'marked';

export default {
    components: {
        backToTop
    },
    props: {},
    data() {
        return {
            headings: [],   //存放全部标题
            curHeading: "", //当前激活标题
            rawArticle: "", //原始 markdown 格式的文档
            articleBody: ""
        }
    },
    methods: {

    },
    computed: {

    },
    watch: {

    },
    mounted() {
        API.get("/article/id=1")
            .then(res => {
                console.log(res);
                this.articleBody = marked.parse(res.data)
            })
    },
}

</script>

<style lang='less' scoped>
.illustration {
    position: relative;
    width: 100%;
    height: 400px;
    margin-bottom: 20px;

    img {
        height: 100%;
        width: 100%;
        object-fit: cover;
        vertical-align: middle;
        transition: all 0.5s ease-in-out;
        border-radius: 0px 0px 10px 10px;
        transition: all 0.3s ease;
    }

    .ArticleInfo {
        position: absolute;
        width: 100%;
        height: 100%;
        // color: white;
        top: 150px;
        margin: 0 auto;
    }
}


.articleRow {

    max-width: 75%;
    flex: 0 0 75%;
    transition: all 0.5s ease;
    margin-bottom: 30px;
    text-align: left;

    .articleBody {
        overflow-y: hidden;
        border: 2px solid aquamarine;
        height: 1000px;
    }
}

.contentRow {
    max-width: 15%;
    flex: 0 0 15%;

    .articleContent {
        border: 2px solid aquamarine;
        width: 100%;
        height: auto;
        min-height: 200px;
    }
}

.space {
    max-width: 3%;
    flex: 0 0 3%;
}
</style>