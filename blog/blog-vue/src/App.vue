
<template>

  <header @mousemove="onMousemove(1,$event)" :style="{ backgroundColor: `hsl(${x%360}, 30%, 90%, 0.95)` }"
    :class="headerStyle">
    <navbar></navbar>
  </header>

  <div class="main" @mousemove="onMousemove(2,$event)" :style=" { backgroundColor: `hsl(${y%360}, 30%, 90%, 0.3)` }">
    <Main :headerState=headerState></Main>
  </div>

  <footer @mousemove="onMousemove(3,$event)" :style="{ backgroundColor: `hsl(${z%360}, 30%, 90%, 1)` }">@copyright
  </footer>

</template>

<script setup>
import { onMounted, ref } from 'vue';
import navbar from '@/components/navbar.vue'
import Main from '@/views/Main.vue'

// 控制背景颜色变化
const x = ref(0)
const y = ref(0)
const z = ref(0)
function onMousemove(index, event) {
  // console.log(event);
  switch (index) {
    case 1:
      x.value = event.clientX
      break;
    case 2:
      y.value = event.clientX
      break;
    case 3:
      z.value = event.clientX
      break;
    default:
      break;
  }
}

// 控制header的出现和隐藏
const headerStyle = ref("header-on")
const headerState = ref(1)  // 用于给main中的部分组件控制状态
let oldy = 0;
onMounted(() => {
  window.addEventListener('scroll', () => {
    const y = window.scrollY
    if (y - oldy > 0 && y > 850) { // 向下滚动
      headerStyle.value = "header-off"
      headerState.value = 0
    } else {
      headerStyle.value = "header-on"
      headerState.value = 1
    }
    oldy = y;
  });
})


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

.main {
  margin-top: 50px;
  z-index: 0;
  flex: 1 0 auto;
  transition: @colortransition;
}

footer {
  z-index: 1;
  height: 80px;
  line-height: 80px;
  box-shadow: 0px 0px 1px @borderColor;
  transition: @colortransition;
}
</style>
