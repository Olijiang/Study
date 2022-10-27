<template>

    <div class="home-page">
        <img src="../img/P1.png" alt="">
    </div>

    <!-- 文章部分 -->
    <div class="article">
        <template v-for="(aricle, index) in articleList" :key=index>
            <vArticleCard :article=aricle />
        </template>
    </div>

    <div v-if="hasover" class="endmsg">已经到底了...</div>

    <vAuthorCard />

</template>



<script setup>

import vArticleCard from '@/components/v-articleCard.vue'
import vAuthorCard from '@/components/v-authorCard.vue'
import { ref, reactive, onMounted } from 'vue';

const hasover = ref(false)

const articleList = reactive([])

function articleInit() {
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
    articles.forEach((e) => { articleList.push(e) })
}

onMounted(() => {
    // 请求初始数据
    articleInit()
})

</script>


<style lang="less" scoped>
.home-page {
    height: 900px;
    margin-bottom: 30px;

    img {
        opacity: 1;
        width: 100%;
        height: 100%;
        object-fit: cover;
        transition: all 0.5s;
        border-radius: 0px 0px 20px 20px;
    }
}

.article {
    float: left;
    width: 1200px;
    padding-bottom: 30px;
}

.endmsg {
    position: absolute;
    bottom: 15px;
    width: 100%;
    font-size: 90%;
    color: #858585;
}

.authorStyle {
    position: sticky;
    margin: 0px 0 50px 1250px;
    top: 20px;
    width: 250px;
    transition: 0.2s all ease-in-out;

}

.card {
    background-color: rgba(255, 255, 255, 0.5);
    border: 1px solid rgba(235, 235, 235);
    border-radius: 20px;
    transition: all 0.2s ease-in-out;
    // position: absolute;

    &:hover {
        box-shadow: 0 0 10px rgb(219, 219, 219);
        transition: all 0.2s ease-in-out;
    }
}

.author {
    width: 100%;
    height: 300px;
    padding-bottom: 20px;
    .card();

    .tag {
        display: inline-block;
        width: 30%;
        height: 30px;
    }
}

.category {
    top: 350px;
    width: 100%;
    margin-top: 20px;
    height: 250px;
    .card()
}
</style>

