<template>

    <div class="icon" @click="changeAside()">
        <el-icon v-if="icon1">
            <DArrowLeft style="padding-bottom: 2px;" />
        </el-icon>
        <el-icon v-if="icon2">
            <DArrowRight style="padding-bottom: 2px;" />
        </el-icon>
    </div>


    <p style="float: left;margin: 0;width: 80px;text-align: left;padding-left: 10px;}">
        {{ currentTag.itemName }}
    </p>

    <div class="tags" v-for="tag in tags" :key="tag.index">

        <el-tag @close="handleClose(tag)" @click="handleClick(tag)" class="mx-1" closable :type=tag.type>
            {{ tag.itemName }}
        </el-tag>

    </div>


    <el-dropdown trigger="click" szie="mini" class="user-icon" @command="handleCommand">
        <el-avatar :size="30" icon="UserFilled"></el-avatar>
        <template #dropdown>
            <el-dropdown-menu>
                <el-dropdown-item command="个人信息">
                    <el-icon>
                        <User />
                    </el-icon>个人信息
                </el-dropdown-item>
                <el-dropdown-item command="账户设置">
                    <el-icon>
                        <Setting />
                    </el-icon>账户设置
                </el-dropdown-item>
                <el-dropdown-item command="退出账户">
                    <el-icon>
                        <TurnOff />
                    </el-icon>退出账户
                </el-dropdown-item>
            </el-dropdown-menu>
        </template>
    </el-dropdown>



</template>

<script>

import { ElMessage } from 'element-plus'
export default {
    name: 'Header',
    data() {
        return {
            icon1: true,
            icon2: false
        };
    },
    methods: {
        changeAside() {
            this.isCollapse = !this.isCollapse
            this.icon1 = !this.icon1
            this.icon2 = !this.icon2
            this.$store.commit("foldMenu")
        },
        // 处理下拉菜单
        handleCommand(command) {
            if (command === '退出账户') {
                this.$store.commit('clear')
                this.$router.replace({ name: 'Login' });
                ElMessage({
                    showClose: true,
                    message: '退出成功',
                    type: 'success',
                })
            } else {
                ElMessage({
                    showClose: true,
                    message: '功能正在完善',
                    type: 'warning',
                })
            }

        },
        handleClick(tag) {
            // 跳转 tag 页面， 更新 store 中的当前tag， 让 menu 高亮和 小title 同步更新
            this.$router.push({ name: tag.path })
            this.$store.commit('changeTag', tag)
            // ElMessage(`clikc ${tag.itemName}`)
        },
        handleClose(tag) {
            // 提交store关闭当前tag，路由跳转过去
            this.$store.commit('removeTag', tag)
            this.$router.push({ name: this.currentTag.path })
            // console.log(this.$parent.$parent);
        }
    },
    computed: {
        tags() {
            return this.$store.state.tags
        },
        // 实时获取store更新后的tag
        currentTag() {
            return this.$store.state.currentTag
        }
    }
}
</script>

<style scoped>
.icon {
    margin-left: 5px;
    margin-top: 5px;
    cursor: pointer;
    width: 40px;
    height: 40px;
    float: left;
    border-radius: 50%;
    transition: 0.5s ease;
}

.icon:hover {
    color: #c6c6c6;
    box-shadow: 0 1px 5px #b9bcbc;
    background-color: #e7e7e7;
}

.tags {
    margin-left: 20px;
    cursor: pointer;
    float: left;
}


.user-icon {
    transition: 0.5s ease;
    margin-top: 10px;
    cursor: pointer;
    width: 30px;
    height: 30px;
    margin-right: 20px;
    float: right;
    border-radius: 50%;
}

.user-icon:hover {
    box-shadow: 0 1px 5px #b9bcbc;
}
</style>


<!-- Add "scoped" attribute to limit CSS to this component only -->
