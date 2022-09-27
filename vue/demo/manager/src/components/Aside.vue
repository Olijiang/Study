<template>
    <el-menu :default-active=activeIndex class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
        :collapse="isCollapse" style="text-align:left; border: none;" background-color='#F5F7FA' mode="vertical">

        <el-menu-item v-for="item in noChild" :key="item.index" @click=selectMenu(item) :index="item.index">
            <el-icon>
                <component :is=item.iconName></component>
            </el-icon>
            <template #title>{{item.itemName}}</template>
        </el-menu-item>

        <el-sub-menu v-for="item in hasChild" :key="item.index" :index="item.index">
            <template #title>
                <el-icon>
                    <component :is=item.iconName></component>
                </el-icon>
                <span>{{item.itemName}}</span>
            </template>
            <el-menu-item-group>
                <el-menu-item v-for="subItem in item.children" :key="subItem.index" :index="subItem.index"
                    @click=selectMenu(subItem)>{{subItem.itemName}}</el-menu-item>
            </el-menu-item-group>
        </el-sub-menu>

    </el-menu>
</template>

<style>
aside .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 180px;
    min-height: 400px;
}

aside .el-menu {
    height: 100%;
    /* color: #e9fdff; */
}

aside .el-menu-item,
.el-sub-menu__title {
    height: 50px !important;
}

aside .el-menu-item-group__title {
    display: none;
}
</style>

<script>

import ComAPI from '../api/ComAPI'

export default {
    name: 'Aside',
    data() {
        return {
            sideData: [],
        }
    },
    methods: {
        handleOpen() {
            // console.log(this.$store);
            // console.log(this.isCollapse);
        },
        handleClose(key, keyPath) {
            // console.log(key, keyPath);
        },
        selectMenu(item) {
            // 路由跳转
            this.$router.push({
                name: item.path
            })
            // console.log(item.itemName, item.index)
            // menu 点击事件逻辑, vuex 中存放一个激活tag， 
            // 1 切换激活 tag, 根据需要 addTag
            this.$store.commit('changeTag', item)
            this.$store.commit('addTag')
        },
    },
    computed: {
        activeIndex() {
            // console.log(this.$store.state.currentTag)
            return this.$store.state.currentTag.index
        },
        isCollapse() {
            return this.$store.state.isCollapse
        },
        // 过滤有无子选项的菜单
        noChild() {
            return this.sideData.filter((p) => {
                return p.children == null
            })
        },
        hasChild() {
            return this.sideData.filter((p) => {
                return p.children != null
            })
        },
    },
    created() {
        let type = this.$store.state.token.type
        ComAPI.post('/getAside', type)
            .then(res => {
                this.sideData = res.data
                // console.log(res.data);
            }).catch(err => {
                console.log(err);
            })
    }
}
</script>