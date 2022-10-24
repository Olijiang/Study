<template>

    <div class="home-page">

    </div>

    <!-- 文章部分 -->
    <div class="article">
        <template v-for="(aricle,index) in articles" :key=index>
            <vArticle :article=aricle />
        </template>
        <div class="endmsg">已经到底了...</div>
    </div>

    <div :class="authorStyle">
        <!-- 作者信息 -->
        <div class="author">
            <div style="margin: 20px 0 0 0;">
                <img src="../img/1.png" alt="" style="width: 150px;height: 150px;border-radius: 50%;">
            </div>
            <div>
                <p style="line-height: 10px;color: #ff0000;margin: 20px 0 5px 0;font-size: 20px;">{{ authorInfo.name }}
                </p>
                <p style="font-size: 90%;color: #858585;"> {{ authorInfo.desc }}</p>
            </div>
            <div>
                <span class="tag">文章</span>
                <span class="tag">分类</span>
                <span class="tag">标签</span>
            </div>
            <div>
                <span class="tag" style="color: #6300ff;">{{ authorInfo.articleN }}</span>
                <span class="tag" style="color: #6300ff;">{{ authorInfo.categoryN }}</span>
                <span class="tag" style="color: #6300ff;">{{ authorInfo.tagN }}</span>
            </div>
        </div>
        <!-- 文章分类 -->
        <div class="category">
            文章分类
        </div>
    </div>


</template>



<script setup>

import vArticle from '@/components/v-article.vue'
import { onMounted, ref } from 'vue';


const props = defineProps({
    headerState: Number, // 1 on, 0 off 
})

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

const authorStyle = ref("bar-nofixed") //authorStyle根据滚动情况改变
onMounted(() => {
    window.addEventListener('scroll', () => {
        const y = ref(window.scrollY)
        if (y.value > 928) {
            // 根据header是否展开选择不同的class
            authorStyle.value = (props.headerState == 0) ? "bar-fixed" : "bar-fixed2"
        } else if (y.value < 878) {
            // 转换到跟随主题一起时高度应小于878而不是928, 变小时header一定是展开的, 要减去header的高度
            authorStyle.value = "bar-nofixed"
        }
    });
})

</script>


<style lang="less" scoped>
.home-page {
    height: 100vh;
}

.article {
    width: 1200px;

    .endmsg {
        float: left;
        width: 100%;
        font-size: 90%;
        margin: 0 0 20px 200px;
        color: #858585;
    }
}

.bar-fixed {
    position: fixed;
    right: 75px;
    width: 250px;
    top: 20px;
    transition: 0.2s all ease-in-out;
}

.bar-fixed2 {
    position: fixed;
    right: 75px;
    width: 250px;
    transition: 0.2s all ease-in-out;
    top: 70px;
}

.bar-nofixed {
    display: inline-block;
    right: 75px;
    width: 250px;
    transition: 0.2s all ease-in-out;
}

.card {
    background-color: rgba(255, 255, 255, 0.5);
    border: 1px solid rgba(235, 235, 235);
    border-radius: 20px;
    transition: all 0.2s ease-in-out;

    &:hover {
        box-shadow: 0 0 10px rgb(219, 219, 219);
        transition: all 0.2s ease-in-out;
    }
}

.author {
    .card();
    padding-bottom: 20px;

    .tag {
        display: inline-block;
        width: 30%;
        height: 30px;
    }
}

.category {
    margin-top: 20px;
    height: 250px;
    .card()
}
</style>

