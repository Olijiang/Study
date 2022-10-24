<template>
    <!-- 时间进度条 -->
    <div class="timebar">
        <div class="time_node"></div>
        <div class="time_line"></div>
        <div class="time_info">2020.12.12 || 时间趣闻</div>
    </div>

    <div v-if="article.index%2==0" class="article_card">
        <div class="illustration-l">
            <img :src=article.img alt="img">
        </div>
        <div class="content-r">
            <h3>{{article.title}}</h3>
            <span style="font-size: 80%;color: #858585"> 时间 || 分类 || 描述 </span>
            <hr width="300px" align="left" />
            <p>{{article.abstract}}</p>
        </div>
    </div>
    <div v-else class="article_card">
        <div class="illustration-r">
            <img :src=article.img alt="img">
        </div>
        <div class="content-l">
            <h3>{{article.title}}</h3>
            <span style="font-size: 80%;color: #858585"> 时间 || 分类 || 描述 </span>
            <hr width="300px" align="left" />
            <p>{{article.abstract}}</p>
        </div>
    </div>
</template>

<script setup>
import { onMounted } from 'vue';


defineProps({
    article: {
        index: Number,
        title: String,
        abstract: String,
        img: String,
    },
})

// onMounted(() => {
//     onMounted(console.log(article))
// })


</script>


<style lang="less" scoped>
.timebar {
    // border: 1px solid darkblue;
    position: relative;
    float: left;
    width: 250px;
    height: 270px;
    margin: 0 60px 0 80px;
}

.time_node {
    background-color: rgba(186, 214, 215, 0.8);
    position: absolute;
    left: 75px;
    top: 100px;
    width: 11px;
    height: 11px;
    border-radius: 11px;
}

.time_line {
    float: left;
    margin-left: 80px;
    border-left: 1px solid #cfcbcb;
    height: 100%;
    text-align: center;
    width: 2px;
}

.time_info {
    float: left;
    margin-top: 90px;
    margin-left: 10px;
    font-size: 80%;
    color: #858585;
    width: 150px;
}

.article_card {
    float: left;
    background-color: rgba(255, 255, 255, 0.6);
    text-align: left;
    width: 800px;
    height: 250px;
    border-radius: 20px;
    border: 1px solid rgba(235, 235, 235);
    transition: all 0.2s ease-in-out;
    margin-bottom: 20px;

    img {
        height: 100%;
        width: 100%;
        object-fit: cover;
        vertical-align: middle;
        transition: all 0.5s ease-in-out;
    }

    &:hover {
        border: 1px solid #5dfaff;
        box-shadow: 0 0 10px #5dfaff;
        transition: all 0.2s ease-in-out;

        img {
            transition: all 0.5s ease-in-out;
            transform: scale(1.1, 1.1);
        }

    }
}

.illustration {
    width: 380px;
    height: 100%;
    overflow: hidden;
}

.illustration-l {
    float: left;
    border-radius: 20px 10px 10px 20px;
    .illustration()
}

.illustration-r {
    border-radius: 10px 20px 20px 10px;
    float: right;
    .illustration()
}

.content {
    padding-top: 10px;
    width: 380px;
    height: 210px;
    margin: 0 20px 0;
    overflow: hidden;
}

.content-l {
    float: left;

    .content()
}

.content-r {
    float: right;
    .content()
}

h3 {
    color: #4b9797;
    cursor: pointer;
    height: 25px;
    line-height: 1.2;
    margin: 10px 5px 10px 0;
    font-size: 20px;
    overflow: hidden;
    transition: all 0.5s ease-in-out;

    &:hover {
        font-size: 22px;
        transition: all 0.5s ease-in-out;
    }
}

p {
    // font-size:%;
    margin: 10px 0 10px;
    text-indent: 2em; //首行缩进
    line-height: 1.5;
    font-family: "仿宋";
}
</style>