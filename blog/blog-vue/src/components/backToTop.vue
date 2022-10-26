
<template>
    <div :class="boxStyle">
        <div class="box" @click="toTop" @mousemove="onMousemove"
            :style="{ backgroundColor: `hsl(${(x % 40) * 99}, 30%, 90%, 0.5)` }">
            <svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg">
                <path fill="#efa228"
                    d="M572.235 205.282v600.365a30.118 30.118 0 1 1-60.235 0V205.282L292.382 438.633a28.913 28.913 0 0 1-42.646 0 33.43 33.43 0 0 1 0-45.236l271.058-288.045a28.913 28.913 0 0 1 42.647 0L834.5 393.397a33.43 33.43 0 0 1 0 45.176 28.913 28.913 0 0 1-42.647 0l-219.618-233.23z">
                </path>
            </svg>
        </div>
    </div>
</template>

<script setup>

import { onMounted, ref } from 'vue';

// 控制背景颜色
const x = ref(0)
function onMousemove(e) {
    x.value = e.clientX
}

// 添加监听事件控制模块的显示
const boxStyle = ref("noshow")
onMounted(() => {
    window.addEventListener('scroll', () => {
        var y = document.documentElement.scrollTop || document.body.scrollTop
        boxStyle.value = (y > 800) ? "show" : "noshow"
    });
})


function toTop() {
    let y = document.documentElement.scrollTop || document.body.scrollTop
    // 步长按二次函数变化
    // 大致步数定位100步, 但实际中会少一些, 因为当前高度小于步长时会直接到顶部
    let n = 100
    let step = y / (n / 2)    //起始步长
    let a = step / n        //步长变化率
    const myTimer = setInterval(() => {
        y -= step
        if (y <= 0) {
            y = 0
            window.clearInterval(myTimer)
        }
        window.scrollTo(0, y) //这是值是指离开网页顶部的距离
        step -= a
    }, 5);
}

</script>

<style lang="less" scoped>
.show {
    width: 50px;
    position: fixed;
    bottom: 150px;
    right: 5px;
    transition: all 0.5s;

    .box {
        transition: all 0.5s;
        box-shadow: 0px 0px 2px #efa228;
        padding: 10px;
        width: 30px;
        height: 30px;
        border-radius: 10px;

        &:hover {
            box-shadow: 0px 0px 8px #efa228;
        }
    }
}

.noshow {
    width: 50px;
    position: fixed;
    bottom: 150px;
    right: -55px;
    transition: all 0.5s;

    .box {
        box-shadow: 0px 0px 5px #efa228;
        padding: 10px;
        width: 30px;
        height: 30px;
        border-radius: 10px;
    }
}
</style>
