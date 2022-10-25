<template>

    <div class="home-page">
        <img src="../img/P1.jpg" alt="">
    </div>

    <!-- 文章部分 -->
    <div class="article">
        <template v-for="(aricle, index) in articles" :key=index>
            <vArticle :article=aricle />
        </template>
    </div>
    <div v-if="hasover" class="endmsg">已经到底了...</div>

    <vAuthorCard :authorInfo=authorInfo />


</template>



<script setup>

import vArticle from '@/components/v-article.vue'
import vAuthorCard from '@/components/v-authorCard.vue'
import { ref } from 'vue';

const hasover = ref(false)

const authorInfo = ref({
    name: "神华里绫",
    desc: "这是我的blog",
    articleN: 99,
    categoryN: 99,
    tagN: 99
})



const articles = [
    { index: 1, title: "段落标题段落标题段落标题段落标题段落标题", abstract: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", img: "src/img/1.png" },
    { index: 2, title: "段落标题", abstract: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", img: "src/img/2.png" },
    { index: 3, title: "段落标题", abstract: "段落摘要段落摘要", img: "src/img/3.png" },
    { index: 4, title: "段落标题", abstract: "段落摘要段落摘要", img: "src/img/1.png" },
    { index: 5, title: "段落标题", abstract: "段落摘要段落摘要", img: "src/img/2.png" }
]



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

