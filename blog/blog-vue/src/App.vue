
<template>

  <vHeaderVue />

  <div class="main" @mousemove="onMousemove(1, $event)" :style="{ backgroundColor: `hsl(${x % 360}, 30%, 90%, 0.3)` }">
    <HomeVue></HomeVue>
  </div>

  <footer @mousemove="onMousemove(2, $event)" :style="{ backgroundColor: `hsl(${y % 360}, 30%, 90%, 1)` }">
    @copyright
  </footer>

  <backToTopVue />

</template>

<script setup>
import { ref } from 'vue';
import vHeaderVue from './components/v-header.vue';
import HomeVue from './views/Home.vue';
import backToTopVue from './components/backToTop.vue';
// 控制背景颜色变化
const x = ref(0)
const y = ref(0)
function onMousemove(index, event) {
  // console.log(event);
  switch (index) {
    case 1:
      x.value = event.clientX
      break;
    case 2:
      y.value = event.clientX
      break;
    default:
      break;
  }
}

</script>

<style lang="less" scoped>
@borderColor: #989898;
@colortransition: 0.1s background-color ease-in-out;
@transition: 0.3s all ease-in-out;


.main {
  position: relative;
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
