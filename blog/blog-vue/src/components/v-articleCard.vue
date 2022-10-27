<template>
    <!-- 时间进度条 -->
    <el-row>
        <el-col :span="6">
            <div class="timebar">
                <div class="time_node"></div>
                <div class="time_line"></div>
                <div class="time_info">{{ article.createTime }}</div>
            </div>
        </el-col>


        <el-col :span="18">
            <div v-if="article.index % 2 == 0" class="article_card">
                <div class="illustration-l">
                    <img :src=article.imgUrl alt="img">
                </div>
                <div class="content-r">
                    <h3>{{ article.title }}</h3>
                    <span style="font-size: 80%;color: #858585"> {{ article.category }} | {{ article.tag }}</span>
                    <hr width="300px" align="left" />
                    <p>{{ article.digest }}</p>
                </div>
            </div>
            <div v-else class="article_card">
                <div class="illustration-r">
                    <img :src=article.imgUrl alt="img">
                </div>
                <div class="content-l">
                    <h3>{{ article.title }}</h3>
                    <span style="font-size: 80%;color: #858585">{{ article.category }} | {{ article.tag }}</span>
                    <hr width="300px" align="left" />
                    <p>{{ article.digest }}</p>
                </div>
            </div>

        </el-col>
    </el-row>



</template>

<script setup>

defineProps({
    article: {
        index: Number,
        title: String,
        createTime: String,
        category: String, // 分类
        tag: String,  // 标签
        digest: String, //摘要
        url: String, //正文地址
        imgUrl: String, //插图地址
    },
})

// onMounted(() => {
//     onMounted(console.log(article))
// })


</script>


<style lang="less" scoped>
.timebar {
    height: 270px;
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
    margin-left: 5%;
    font-size: 80%;
    color: #858585;
}

.article_card {
    width: 100%;
    background-color: rgba(255, 255, 255, 0.6);
    text-align: left;
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
    height: 100%;
    width: 45%;
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
    width: 50%;
    height: 210px;
    margin: 0 2% 0;
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
    line-height: 1.6;
}
</style>