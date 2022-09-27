<template>
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
                    <el-input v-model="loginForm.username" type="text" autocomplete="off" />
                </el-form-item>
                <el-form-item label="密&#160;&#160;&#160;&#160;码" prop="password">
                    <el-input v-model="loginForm.password" type="password" autocomplete="off" />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm(loginRef)">登录</el-button>
                    <el-button @click="resetForm(loginRef)">清空</el-button>
                </el-form-item>
            </el-form>
        </div>
    </el-card>
    <el-card class="back">

    </el-card>
    <el-card class="back1">

    </el-card>
</template>

<script>

import ComAPI from '../api/ComAPI'

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
                username: '',
                password: ''
            },
            rules: {
                username: { validator: validateUserName, required: true, trigger: 'blur' },
                password: { validator: validatePassword, required: true, trigger: 'blur' }
            }
        }
    },


    methods: {
        submitForm() {
            this.$refs['loginRef'].validate(valid => {
                if (valid) {
                    // 调api， api返回token， 加入到vuex
                    ComAPI.post('/login', this.loginForm)
                        .then((res) => {
                            if (res.token.type !== 'error') {
                                console.log('token', res.token);
                                this.$store.commit('addToken', res.token)
                                this.$router.push({ name: 'Main' })
                            } else {
                                console.log("非法账户");
                            }

                        }).catch((err) => {
                            console.log(err);
                        })

                } else (
                    console.log('error submit')
                )
            })
        },
        resetForm(loginRef) {
            this.$refs['loginRef'].resetFields()
        }
    }
}
</script>


<style scoped>
.card-body {
    padding-right: 20px
}

.back {
    z-index: -1;
    background-color: #a2ff6f;
    position: absolute;
    top: 0;
    left: 39%;
    border-radius: 20px;
    width: 350px;
    height: 260px;
    margin-top: 20vh;
    rotate: 10deg;
}

.back1 {
    z-index: -1;
    background-color: #6ffff3;
    position: absolute;
    top: 0;
    left: 39%;
    border-radius: 20px;
    width: 350px;
    height: 260px;
    margin-top: 20vh;
    rotate: -10deg;
}

.box-card {
    background-color: #f7ffe8;
    border-radius: 20px;
    width: 350px;
    height: 260px;
    margin: auto;
    margin-top: 20vh;
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
