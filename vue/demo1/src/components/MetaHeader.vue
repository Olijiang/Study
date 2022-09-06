<script setup>
</script>
 
<template>
<!-- 定义一个头部组件 -->
  <div class="meta-header">
    <!-- 左侧logo -->
    <div class="meta-header-logo">Meta.Qing LOGO</div>
    <nav>
        <!-- 右侧导航栏 -->
      <a href="/HTML/">HTML</a> | <a href="/css/">CSS</a> |
      <a href="/JavaScript/">JavaScript</a> | <a href="/jQuery/">jQuery</a> |
      <a href="/Vue3/">Vue3</a> | <a href="/React/">React</a> |
      <a href="/Angular/">Angular</a>
    </nav>
  </div>
</template>
 
<style scoped>
/* 弹性盒子方式来布局 */
.meta-header {
  display: flex;
  width: 100%;
  justify-content: space-between;
  background: #1fd6e766;
  padding: 10px;
}
.meta-header-logo {
  font-weight: bold;
  color: rgba(28, 29, 31, 0.804);
}
</style>