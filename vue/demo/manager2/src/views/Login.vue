<template>
    <div>


        <el-card class="box-card">
            <template #header>
                <div class="card-header">
                    <span>登&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;录</span>
                </div>
            </template>
            <div class="card-body">
                <el-form ref="loginRef" :model="loginForm" status-icon :rules="rules" label-width="80px"
                    class="demo-ruleForm">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="loginForm.username" type="text" autocomplete="off" placeholder="请输入账户" />
                    </el-form-item>
                    <el-form-item label="密&#160;&#160;&#160;&#160;码" prop="password">
                        <el-input v-model="loginForm.password" type="password" autocomplete="off" placeholder="请输入密码" />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm()">登录</el-button>
                        <el-button @click="resetForm()">清空</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
        <el-card class="back">

        </el-card>
        <el-card class="back1">

        </el-card>
    </div>
</template>

<script>

import md5 from "js-md5"
import ComAPI from '@/utils/ComAPI'
export default {
    data() {
        const validatePassword = (rule, value, callback) => {

            if (value === '') {
                callback('请输入密码')
            } else {
                callback()
            }
        }
        const validateUserName = (rule, value, callback) => {
            if (value === '') {
                callback('请输入用户名')
            } else {
                let idReg = /^\d{5,10}$/
                if (idReg.test(value)) {
                    callback()
                } else {
                    callback('请输入正确的用户名')
                }
            }
        }
        return {
            loginForm: {
                username: '4050000',
                password: '123'
            },
            rules: {
                username: { validator: validateUserName, required: true, trigger: 'blur' },
                password: { validator: validatePassword, required: true, trigger: 'blur' }
            },
            nameSet: []
        }
    },


    methods: {
        submitForm() {
            console.log("请求登录");
            this.$refs['loginRef'].validate(valid => {
                if (valid) {
                    // 调api，接口数据：
                    // uid  
                    // username  用于姓名展示
                    // userType  用户类型
                    // token 校验用户真实性

                    let salt = String(Math.round(new Date().getTime())).substring(0, 8); //1 分钟
                    console.log(salt);
                    this.loginForm.password = md5(this.loginForm.password + "snion~!@#$4413_)(*&)") //加固定密钥加密
                    console.log("password ", this.loginForm.password);
                    this.loginForm.password = md5(this.loginForm.password + salt)   //加时间戳加密
                    // console.log("login ", this.loginForm);
                    ComAPI.post('/login', this.loginForm).then((res) => {
                        // console.log(res);
                        if (res.code === 200) {
                            this.$store.commit('addToken', res)
                            this.$router.push({ name: 'Main' })
                        } else {
                            this.loginForm.password = ""
                        }
                    })
                }
            })
        },
        resetForm() {
            this.$refs['loginRef'].resetFields()
        }
    },
}
</script>


<style scoped>
.card-body {
    padding-right: 20px
}

.el-card {
    border-radius: 30px !important;
}

.back {
    border: 1px solid red;
    opacity: 0.4;
    z-index: -1;
    background-color: #a2ff6f;
    position: absolute;
    left: 39%;
    width: 350px;
    height: 260px;
    margin-top: 20vh;
    rotate: 10deg;
}

.back1 {
    border: 1px solid green;
    opacity: 0.4;
    z-index: -1;
    background-color: #6ffff3;
    position: absolute;
    left: 39%;
    width: 350px;
    height: 260px;
    margin-top: 20vh;
    rotate: -10deg;
}

.box-card {
    border: 1px solid blue;
    opacity: 0.9;
    background-color: #f7ffe8;
    width: 350px;
    height: 260px;
    margin: auto;
    margin-top: 20vh;
    position: absolute;
    left: 39%;
}

.card-header {
    font-size: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.text {
    font-size: 14px;
}

.el-form-item__label {
    justify-content: center;
}
</style>
