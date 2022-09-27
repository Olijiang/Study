<template>
    <el-container>
        <el-aside width="auto"> <Aside></Aside> </el-aside>
        <el-container>
            <el-header>
                <Header> </Header>
            </el-header>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>

import Aside from '../components/Aside.vue'
import Header from '../components/Header.vue'

export default {
    name: "Main",
    data() {
        return {
        };
    },
    components: {
        Aside,
        Header
    },
    methods:{

    }
}
</script>

<style lang="less" scoped>
.el-header {
    background-color: #FAFAFA;
    text-align: center;
    line-height: 50px;
    height: 50px !important;
    padding: 0 !important;
    box-shadow: 0 1px 5px #b9bcbc;
}

.el-aside {
    text-align: center;
    line-height: 200px;
}

.el-main{
    color: #333;
    text-align: center;
}
.el-container{
    
    height: 100vh;
}
body>.el-container {
    margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
    line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
    line-height: 320px;
}
</style>
  
  