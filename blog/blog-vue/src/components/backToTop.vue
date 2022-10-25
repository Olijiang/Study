
<template>
    <div :class="boxStyle">
        <div class="box" @click="toTop">
            <svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg">
                <path fill="#989898"
                    d="M572.235 205.282v600.365a30.118 30.118 0 1 1-60.235 0V205.282L292.382 438.633a28.913 28.913 0 0 1-42.646 0 33.43 33.43 0 0 1 0-45.236l271.058-288.045a28.913 28.913 0 0 1 42.647 0L834.5 393.397a33.43 33.43 0 0 1 0 45.176 28.913 28.913 0 0 1-42.647 0l-219.618-233.23z">
                </path>
            </svg>
        </div>
    </div>
</template>

<script setup>

import { onMounted, ref } from 'vue';

const props = defineProps({
    time: Number,
})

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
    // 判断 高度小于5000px 在0.5s内完成, 大于5000px 在1s内完成
    let step    //步长
    let a   // 步长变化率, 匀速变化
    // 判断是否有指定 时间值

    if (props.time == undefined) {

        if (y > 5000) {
            step = 1 + (y - 100) / 50
            a = (y - 100) / 5000
        } else {
            step = 1 + (y - 50) / 25
            a = (y - 50) / 1250
        }
    } else {
        if (props.time < 0) {
            throw "time cannot < 0"
        }
        let stepN = props.time * 1000 / 10 //计算回到顶部所需要的步数
        a = 2 * (y - stepN) / (stepN * stepN)
        step = 1 + 2 * (y - step) / stepN
    }

    const myTimer = setInterval(() => {
        y -= step
        if (y <= 0) {
            y = 0
            window.clearInterval(myTimer)
        }
        window.scrollTo(0, y) //这是值是指离开网页顶部的距离
        step -= a
    }, 10);

    // document.documentElement.scrollTop = 0;
}

</script>

<style lang="less" scoped>
.show {
    width: 50px;
    position: fixed;
    bottom: 200px;
    right: 5px;
    transition: all 0.5s;

    .box {
        box-shadow: 0px 0px 2px;
        padding: 10px;
        width: 30px;
        height: 30px;
        border-radius: 10px;
    }
}

.noshow {
    width: 50px;
    position: fixed;
    bottom: 200px;
    right: -55px;
    transition: all 0.5s;

    .box {
        box-shadow: 0px 0px 2px;
        padding: 10px;
        width: 30px;
        height: 30px;
        border-radius: 10px;
    }
}
</style>
