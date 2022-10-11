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
        {{ currentTag.label }}
    </p>

    <div class="tags" v-for="tag in tags" :key="tag.index">

        <el-tag @close="handleTagClose(tag)" @click="handleTagClick(tag)" class="mx-1" closable :type=tag.type>
            {{ tag.label }}
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

    <!-- 右侧抽屉 -->
    <el-drawer ref="drawerRef" v-model="dialogVisible" title="个人信息维护" :before-close="handleClose" direction="rtl"
        custom-class="demo-drawer" size="550">
        <img src="../images/img.png"
            style="width:150px;height:150px; border-radius:50%; margin-top: -20px;margin-bottom: 10px;" alt="头像" />
        <div class="demo-drawer__content">
            <el-form :model="dialog.data" :rules="rules" ref="dialogRef" style="width: 360px;">
                <el-form-item v-for="(item, index) in dialog.config" :key="index" :label="item.label" label-width="80px"
                    :prop="item.attr">
                    <!-- 部分选择框 -->
                    <el-select v-if="item.children" v-model="dialog.data[item.attr]"
                        :placeholder="item.children.placeholder" style="width: 230px;"
                        :disabled="cacldisable(item.attr)">
                        <el-option v-for="option in item.children.data" :label="option" :value="option" />
                    </el-select>

                    <el-input v-else type="text" v-model="dialog.data[item.attr]" autocomplete="off" clearable
                        :disabled="cacldisable(item.attr)" style="margin-right: 50px;" />
                </el-form-item>
            </el-form>
            <div class="demo-drawer__footer">
                <el-button @click="handleClose">取消</el-button>
                <el-button type="primary" :loading="loading" @click="dialogSubmit">{{
                loading ? '保存中 ...' : '保存'
                }}</el-button>
            </div>
        </div>
    </el-drawer>

</template>

<script>

import { ElMessage } from 'element-plus'
import ComAPI from '@/utils/ComAPI';

export default {
    name: 'Header',
    data() {
        return {
            // 抽屉参数
            loading: false,
            dialogVisible: false,
            change: false,
            rules: {    //dialog表单验证
                id: [{ required: true, message: '请输入账号', trigger: 'blur' },
                { min: 5, max: 10, message: '账号长度在5~10位', trigger: 'blur' }],
                uid: [{ required: true, message: '请输入账号', trigger: 'blur' },
                { min: 5, max: 10, message: '账号长度在5~10位', trigger: 'blur' }],
                name: { required: true, message: '请输入姓名', trigger: 'blur' },
                age: [{ required: true, message: '请输入年龄', trigger: 'blur' },
                { pattern: /^\d{2}$/, message: '请输入合法的年龄', trigger: 'blur' }],
                classId: { required: true, message: '请选择班级', trigger: 'blur' },
                email: [{ required: true, message: '请输入邮箱', trigger: 'blur' },
                { type: 'email', message: '请输入合法的邮箱', trigger: 'blur' }],
                telephone: [{ required: true, message: '请输入手机号', trigger: 'blur' },
                { pattern: /^\d{11}$/, message: '请输入合法的手机号', trigger: 'blur' }],
                credential: { required: true, message: '请输入登录密码', trigger: 'blur' },
                loginType: { required: true, message: '请选择登录类型', trigger: 'blur' },
                status: { required: true, message: '请选择用户身份', trigger: 'blur' },
            },

            // 菜单收起icon变化
            icon1: true,
            icon2: false,
            dialog: {
                config: [],
                data: {}
            }
        };
    },
    methods: {
        dialogSubmit() {
            this.$refs['dialogRef'].validate(valid => {
                if (valid) {
                    // 提交保存
                    this.loading = true
                    // 动画关闭需要一定的时间
                    setTimeout(() => {
                        // api 请求
                        ComAPI.post()
                        ElMessage({
                            type: 'success',
                            message: '保存成功',
                        })
                        this.dialogVisible = false
                        this.change = false
                        this.loading = false
                    }, 400)
                }
            })
        },
        handleClose() {
            if (this.change) {
                ElMessageBox.confirm('是否保存?', {
                    distinguishCancelAndClose: true,
                    confirmButtonText: '保存',
                    cancelButtonText: '不保存',
                }).then(() => {
                    // 验证表单
                    this.$refs['dialogRef'].validate(valid => {
                        if (valid) {
                            this.loading = true
                            // 动画关闭需要一定的时间
                            setTimeout(() => {
                                // api 请求
                                ElMessage({
                                    type: 'success',
                                    message: '保存成功',
                                })
                                this.change = false
                                this.dialogVisible = false
                                this.loading = false
                            }, 400)
                        }
                    })
                }).catch((action) => {
                    if (action == 'cancel') {
                        // 点击关闭 关闭弹窗回到主页面
                        this.dialogVisible = false
                    } else {
                        // 按ESC 啥也不干
                    }
                })
            } else {
                // 没有修改过直接关闭
                this.dialogVisible = false
            }
            this.$refs['dialogRef'].clearValidate() //  重置表单验证结果
        },
        cacldisable(attr) {
            // 计算属性是否可编辑
            return false
        },
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
            } else if (command === '个人信息') {
                // 请求用户数据
                ComAPI.get("/userInfo/get")
                    .then(res => {
                        this.dialog.data = res.user
                        this.dialog.config = JSON.parse(res.userConfig)
                        setTimeout(() => {
                            this.change = false //修改标识符置零
                        }, 100);

                    })
                this.dialogVisible = true
            } else {
                ElMessage({
                    showClose: true,
                    message: '功能正在完善',
                    type: 'warning',
                })
            }

        },
        handleTagClick(tag) {
            // 跳转 tag 页面， 更新 store 中的当前tag， 让 menu 高亮和 小title 同步更新
            this.$router.push({ name: tag.name })
            this.$store.commit('changeTag', tag)
            // ElMessage(`clikc ${tag.itemName}`)
        },
        handleTagClose(tag) {
            // 提交store关闭当前tag，路由跳转过去
            this.$store.commit('removeTag', tag)
            this.$router.push({ name: this.currentTag.name })
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
    },
    watch: {
        dialog: {
            deep: true,
            handler() {
                this.change = true
            }
        }
    },

    mounted() {

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
