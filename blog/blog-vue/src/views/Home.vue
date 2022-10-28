<template>

    <div class="home-page">
        <img src="../img/P1.png" alt="">
    </div>

    <el-row>
        <el-col class="space"></el-col>
        <el-col class="ArticleCard">
            <!-- 文章部分 -->
            <div v-for="(aricle, index) in articleList" :key=index>
                <vArticleCard :article=aricle />
            </div>
        </el-col>
        <el-col class="space"></el-col>
        <el-col class="AuthorCard">
            <vAuthorCard></vAuthorCard>
        </el-col>
        <el-col class="space"></el-col>
    </el-row>


    <div v-if="hasover" class="endmsg">已经到底了...</div>

</template>



<script>

import vArticleCard from '@/components/v-articleCard.vue'
import vAuthorCard from '@/components/v-authorCard.vue'

export default {
    name: 'Home',
    props: {},
    components: {
        vArticleCard,
        vAuthorCard
    },
    data() {
        return {
            hasover: false,
            articleList: [],
            authorInfo: {}
        }
    },
    methods: {
        articleInit() {
            let articles = [
                { index: 1, title: "段落标题段落标题段落标题段落标题段落标题", createTime: "2012-01-23", category: "Vue", tag: "vuex", digest: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
                { index: 2, title: "段落标题", createTime: "2014-02-21", category: "Java", tag: "多线程", digest: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" },
                { index: 3, title: "段落标题", createTime: "2015-01-27", category: "Vue", tag: "router", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/3.png" },
                { index: 4, title: "段落标题", createTime: "2016-02-15", category: "Redis", tag: "redis", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
                { index: 5, title: "段落标题", createTime: "2017-11-23", category: "Python", tag: "CNN", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" },
                { index: 6, title: "段落标题", createTime: "2018-05-29", category: "Vue", tag: "mock", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/3.png" },
                { index: 7, title: "段落标题", createTime: "2019-08-01", category: "Java", tag: "springboot", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
                { index: 8, title: "段落标题", createTime: "2021-04-29", category: "Vue", tag: "vuex", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" }
            ]
            articles.forEach((e) => { this.articleList.push(e) })
        }
    },
    computed: {

    },
    watch: {

    },
    mounted() {
        this.articleInit()
    },
}


</script>


<style lang="less" scoped>


.home-page {
    width: 100%;
    height: 900px;
    margin-bottom: 30px;
    transition: all 0.3s ease;

    img {
        height: 100%;
        width: 100%;
        object-fit: cover;
        vertical-align: middle;
        transition: all 0.5s ease-in-out;
        border-radius: 0px 0px 20px 20px;
        transition: all 0.3s ease;
    }
}

.endmsg {
    position: absolute;
    bottom: 15px;
    width: 100%;
    font-size: 90%;
    color: #858585;
}

.ArticleCard {
    max-width: 70%;
    flex: 0 0 70%;
    transition: all 0.5s ease;
}

.AuthorCard {
    display: block;
    transition: all 0.5s ease;
    max-width: 16%;
    flex: 0 0 16%;
}

.space {
    max-width: 3%;
    flex: 0 0 3%;
}

@media (max-width: 1000px) {
    .ArticleCard {
        max-width: 95%;
        flex: 0 0 95%;
        transition: all 0.5s ease;


    }

    .AuthorCard {
        max-width: 0%;
        // flex: 0 0 0%;
        transition: all 0.5s ease;

        * {
            display: none;
        }
    }
}
</style>

