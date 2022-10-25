<template>
    <div class=authorStyle>
        <!-- 作者信息 -->
        <div class="author">
            <img src="../img/1.png" alt="">

            <p style="line-height: 10px;color: #ff0000;margin: 20px 0 5px 0;font-size: 20px;">{{ authorInfo.name }}
            </p>
            <p style="font-size: 90%;color: #858585;"> {{ authorInfo.desc }}</p>

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

import { onMounted, ref } from 'vue';


const props = defineProps({
    authorInfo: {
        name: String,
        desc: String,
        articleN: Number,
        categoryN: Number,
        tagN: Number
    }
})

onMounted(() => {
    const authorInfo = props.authorInfo
})


</script>


<style lang="less" scoped>
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

    img {
        margin-top: 20px;
        width: 150px;
        height: 150px;
        border-radius: 50%;
        object-fit: cover;
        transition: all 0.8s ease;

        &:hover {
            transform: rotate(360deg);
            transition: all 0.8s ease;

        }
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

