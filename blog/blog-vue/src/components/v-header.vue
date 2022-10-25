

<template>
    <header @mousemove="onMousemove" :style="{ backgroundColor: `hsl(${x%360}, 30%, 90%, 0.6)` }" :class="headerStyle">
        <div style="float: left;margin-left: 20px;cursor: pointer;">
            昵称
        </div>
        <div class="nav">
            <div v-for="(item, index) in navItems" :key="index" class="nav-item">
                {{ item }}
                <div class="item-line"></div>
            </div>
            <div v-if="isLogin" class="nav-item1">
                个人中心
                <div class="item-line"></div>
            </div>
            <div v-else class="nav-item">
                登录
                <div class="item-line"></div>
            </div>
        </div>
    </header>
</template>

<script setup>

import { onMounted, ref } from 'vue';

// 控制背景颜色变化
const x = ref(0)
function onMousemove(e) {
    x.value = e.clientX
}

// 判断鼠标的上下滑动  1 up    0 down
const headerStyle = ref("header-on")
let oldy = 0;
onMounted(() => {
    window.addEventListener('mousewheel', () => {
        let y = document.documentElement.scrollTop || document.body.scrollTop
        if (y - oldy > 0) { // 向下滚动
            headerStyle.value = "header-off"
            // headerState.value = 0
        } else {
            headerStyle.value = "header-on"
            // headerState.value = 1
        }
        oldy = y;
    });
})

// 菜单
const navItems = ref(Array)
navItems.value = ["首页", "分类", "文章"]
const isLogin = ref(false)

</script>

<style lang="less" scoped>
@borderColor: #989898;
@colortransition: 0.1s background-color ease-in-out;
@transition: 0.3s all ease-in-out;

.header-on {
    position: fixed;
    z-index: 99;
    width: 100%;
    height: 50px;
    line-height: 50px;
    box-shadow: 0px 0px 5px @borderColor;
    transition: @colortransition, @transition;
}

.header-off {
    opacity: 0.2;
    transform: translate(0, -50px);
    position: fixed;
    z-index: 99;
    width: 100%;
    height: 50px;
    line-height: 50px;
    box-shadow: 0px 0px 5px @borderColor;
    transition: @colortransition, @transition;
}

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

.nav-item1 {
    display: inline-block;
    line-height: 20px;
    margin: 0 10px;
    width: 80px;
    cursor: pointer;
    transition: 0.3s all ease-in-out;

    .item-line {
        position: absolute;
        width: 0;
        margin-top: 10px;
        height: 5px;
        translate: 40px; // 移到居中
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
            translate: 5px;
            width: 70px;
            height: 5px;
            border-radius: 2px;
            background-color: rgb(2, 159, 207);
            transition: 0.3s all ease-in-out;
        }
    }
}
</style>