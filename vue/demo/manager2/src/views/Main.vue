<template>
    <el-container>
        <el-aside width="auto">
            <Transition name="slide-fade">
                <Aside v-if="AideDataOK" :sideData=AideData></Aside>
            </Transition>
        </el-aside>
        <Transition name="slide-fade">
            <el-container v-if="AideDataOK">
                <el-header>
                    <Header> </Header>
                </el-header>
                <el-main>
                    <router-view v-slot="{ Component }">
                        <Transition name="slide-fade">
                            <component :is="Component" />
                        </Transition>
                    </router-view>
                </el-main>
            </el-container>
        </Transition>
    </el-container>
</template>

<script>

import Aside from '../components/Aside.vue'
import Header from '../components/Header.vue'
import ComAPI from '@/utils/ComAPI'

export default {
    name: "Main",
    data() {
        return {
            AideData: [],
            AideDataOK: false,
        };
    },
    components: {
        Aside,
        Header
    },
    methods: {

    },
    created() {
        console.log("请求menuData");
        ComAPI.get('/menu/get').then(res => {
            if (res.code == 200) {
                this.AideData = JSON.parse(res.menuData)
                this.$store.commit("setRouters", this.AideData) //路由信息包含着menuData中
                this.AideDataOK = true
            }
        })
    },
    computed: {

    }
    ,
    watch: {
        AideData: {
            immediate: true,
            handler() {
                //添加动态路由  数据拿过来就要加载一次
                const routers = this.$store.state.userInfo.routers
                // console.log("routers", routers);
                if (routers != null) {
                    // console.log("routers", routers);
                    routers.forEach(e => {
                        const route = {
                            path: e.path,
                            component: () => import('@/views/' + e.name + '.vue'),
                            name: e.name,
                            index: e.index,
                            lable: e.label
                        }
                        // console.log("router", route);
                        this.$router.addRoute('Main', route)
                    })
                }
            }
        }
    }

}
</script>




<style>
/* 过度动画 */
.slide-fade-enter-active {
    transition: all 0.3s ease-in-out;
}

.slide-fade-leave-active {
    transition: all 0.3s;
}

.slide-fade-enter-from {
    transform: translateX(-10px);
    opacity: 0;
}

.slide-fade-leave-to {
    transform: translateX(10px);
    opacity: 0;
}

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

.el-main {
    color: #333;
    text-align: center;
    overflow: hidden;
}

.el-container {

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
  
  