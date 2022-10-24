<template>

    <div style="float: left;margin-left: 20px;cursor: pointer;">
        昵称
    </div>

    <div class="nav">
        <div v-for="(item,index) in navItems" :key="index" class="nav-item">
            {{item}}
            <div class="item-line"></div>
        </div>

    </div>


</template>


<script setup>
import { ref } from 'vue';

const navItems = ref(Array)
navItems.value = ["首页", "分类", "登录"]


</script>


<style lang="less" scoped>
* {
    font-family: "Fantasy", "seSans-serifrif";
    font-weight: bold;
}

.nav {
    z-index: 9999;
    float: right;
    margin-right: 20px;
}

.nav-item {
    display: inline-block;
    line-height: 20px;
    margin: 0 10px;
    width: 40px;
    cursor: pointer;
    transition: 0.3s all ease-in-out;

    .item-line {
        position: absolute;
        width: 0;
        margin-top: 10px;
        height: 5px;
        translate: 25px; // 移到居中
        border-radius: 2px;
        background-color: rgb(2, 159, 207);
        transition: 0.3s all ease-in-out;
        transform: scale(0.1);
    }

    &:hover {
        color: rgb(2, 159, 207);
        transition: 0.3s all ease-in-out;

        .item-line {
            position: absolute;
            transform: scale(1);
            translate: 0;
            width: 40px;
            height: 5px;
            border-radius: 2px;
            background-color: rgb(2, 159, 207);
            transition: 0.3s all ease-in-out;
        }
    }
}
</style>