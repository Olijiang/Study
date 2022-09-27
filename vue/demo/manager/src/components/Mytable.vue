<template>
    <el-row :gutter="10">
        <el-col :span="4">
            <el-input v-model="queryConfig.query1" class="w-50 m-2" :placeholder="queryConfig.tip1" maxlength="10"
                @keyup.enter='queryOne' clearable>
                <template #append>
                    <el-button icon="Search" @click="queryOne" />
                </template>
            </el-input>
        </el-col>

        <el-col :span="1"> </el-col>
        <el-col :span="4">
            <el-input v-model="queryConfig.query2" class="w-50 m-2" :placeholder="queryConfig.tip2" maxlength="10"
                @keyup.enter='queryTwo' clearable>
                <template #append>
                    <el-button icon="Search" @click="queryTwo" />
                </template>
            </el-input>
        </el-col>
        <el-col :span="5"> </el-col>
        <el-col :span="1">
            <el-button type="primary" plain @click="addMenber" style="width: 80px;">添加{{dialogData.type}}
            </el-button>
        </el-col>
    </el-row>

    <el-dialog v-model="dialogFormVisible" :close-on-click-modal=false :title="dialogData.title" width="400px"
        @close='cancelDialog' style=" border-radius: 30px;" @keyup.enter='confirm'>
        <el-form :model="target" :rules="rules" ref="dialogRef">
            <el-form-item v-for="(item, index) in dialogData.details" :key="index" :label="item.lable"
                label-width="80px" :prop="item.attr">
                <el-input type="text" v-model="target[item.attr]" autocomplete="off" clearable
                    :disabled="cacldisable(item.attr, dialogData.oprate)" style="margin-right: 50px;" />
            </el-form-item>
        </el-form>

        <template #footer>
            <span class="dialog-footer">
                <el-button @click="cancelDialog">取消</el-button>
                <el-button type="primary" @click="confirm">确认</el-button>
            </span>
        </template>
    </el-dialog>

    <el-table id="mytable" :data="dataList" stripe height="750" style="width: fit-content">
        <el-table-column v-for="col in headerList" :key="col.index" :prop="col.prop" :label="col.lable"
            :width="col.width?col.width:200" />
        <el-table-column label="管理" width="200">
            <template #default="scope">
                <el-button size="small" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
                <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script>
import { ElMessage } from "element-plus";
import ComAPI from '../api/ComAPI'

export default {
    data() {
        return {
            dialogFormVisible: false,
            dialogData: {
                type: '',
                oprate: '',
                title: '',
                details: [{ lable: '', attr: '' },],  //lable 和 v-model 绑定的属性
            },
            target: {}, // 存dialog中的对象，dialog关闭时会清空
            targeted: {},   //存放完成的dialog中的对象
            editTarget: {},
            rules: {    //dialog表单验证
                sid: [{ required: true, message: '请输入账号', trigger: 'blur' },
                { min: 5, max: 10, message: '账号长度在5~10位', trigger: 'blur' }],
                tid: [{ required: true, message: '请输入账号', trigger: 'blur' },
                { min: 5, max: 10, message: '账号长度在5~10位', trigger: 'blur' }],
                uid: [{ required: true, message: '请输入账号', trigger: 'blur' },
                { min: 5, max: 10, message: '账号长度在5~10位', trigger: 'blur' }],
                sname: { required: true, message: '请输入姓名', trigger: 'blur' },
                tname: { required: true, message: '请输入姓名', trigger: 'blur' },
                age: [{ required: true, message: '请输入年龄', trigger: 'blur' },
                { pattern: /^\d{2}$/, message: '请输入合法的年龄', trigger: 'blur' }],
                cname: { required: true, message: '请输入班级', trigger: 'blur' },
                grade: { required: true, message: '请输入年级', trigger: 'blur' },
                email: [{ required: true, message: '请输入邮箱', trigger: 'blur' },
                { type: 'email', message: '请输入合法的邮箱', trigger: 'blur' }],
                telephone: [{ required: true, message: '请输入手机号', trigger: 'blur' },
                { pattern: /^\d{11}$/, message: '请输入合法的手机号', trigger: 'blur' }],
                identifier: { required: true, message: '请输入登录账号', trigger: 'blur' },
                credential: { required: true, message: '请输入登录密码', trigger: 'blur' },
                loginType: { required: true, message: '请输入登录类型', trigger: 'blur' },
                statusCode: { required: true, message: '请输入用户身份', trigger: 'blur' },
            },

            queryConfig: {
                query1: '', //查询关键字绑定变量
                query2: '',
                tip1: '',   //placeholder
                tip2: '',
                attr1: '',  //要查的属性
                attr2: ''
            },

            dataList: [],   //table 数据
            headerList: [], //table 数据头

            apiSet: {
                add: '',
                delete: '',
                updata: ''
            }
        }
    },
    props: {
        tableData: Object,
    },
    watch: {
        // 数据过来后赋值给一个本地变量用于筛选显示
        tableData: {
            deep: true,
            handler() {
                // console.log(this.tableData.table.header);
                this.dataList = this.tableData.table.data
                this.headerList = this.tableData.table.header
                this.queryConfig.tip1 = this.tableData.queryconfig.tip1
                this.queryConfig.tip2 = this.tableData.queryconfig.tip2
                this.queryConfig.attr1 = this.tableData.queryconfig.attr1
                this.queryConfig.attr2 = this.tableData.queryconfig.attr2
                this.dialogData.type = this.tableData.dialog.type
                this.dialogData.details = this.tableData.dialog.data
                this.apiSet.add = this.tableData.apiSet.add
                this.apiSet.delete = this.tableData.apiSet.delete
                this.apiSet.updata = this.tableData.apiSet.updata

            }
        },
        dialogFormVisible: {
            handler() {
                // this.$refs['dialogRef'].resetFields()
            }
        }
    },
    mounted() {

    },
    methods: {
        cacldisable(attr, oprate) {
            // id name age 不允许修改
            if (oprate === 'edit') {
                let exp = /id$|sname|tname|age|identifier/
                if (attr.match(exp) != null) {
                    return true
                } else return false
            } else if (oprate === 'delete') return true

        },
        cancelDialog() {
            this.dialogFormVisible = false
            // 清空输入框
            this.$refs['dialogRef'].resetFields()
        },
        addMenber() {
            this.dialogData.title = '添加' + this.dialogData.type
            this.dialogFormVisible = true
            this.dialogData.oprate = 'add'
        },
        confirm() {
            // 验证表单
            this.$refs['dialogRef'].validate(valid => {
                if (valid) {
                    if (this.dialogData.oprate === 'add') {
                        //转存数据, 深拷贝,target 在dialog关闭时会销毁
                        for (let key in this.target) {
                            this.targeted[key] = this.target[key]
                        }
                        this.dialogFormVisible = false
                        //调用添加人员的api
                        ComAPI.post(this.apiSet.add, this.targeted)
                            .then(res => {
                                if (res.code === 200) {
                                    ElMessage({
                                        showClose: true,
                                        message: '添加成功',
                                        type: 'success',
                                    })
                                    //tabledata里面也加一个 或者 重定向当前页面重新向数据库请求
                                    // console.log(this.targeted);
                                    this.tableData.table.data.push(this.targeted)
                                }
                            }).catch(err => {
                                ElMessage({
                                    showClose: true,
                                    message: '添加失败',
                                    type: 'error',
                                })
                                console.log(err);
                            })
                    } else if (this.dialogData.oprate === 'edit') {
                        for (let key in this.target) {
                            this.targeted[key] = this.target[key]
                        }
                        this.dialogFormVisible = false
                        //调用添加人员的api
                        ComAPI.post(this.apiSet.updata, this.targeted)
                            .then(res => {
                                if (res.code === 200) {
                                    ElMessage({
                                        showClose: true,
                                        message: '修改成功',
                                        type: 'success',
                                    })
                                    //把 targeted 的值 赋值给 editTarget， 相当于 给了row
                                    for (let key in this.targeted) {
                                        this.editTarget[key] = this.targeted[key]
                                    }
                                }
                            }).catch(err => {
                                ElMessage({
                                    showClose: true,
                                    message: '修改失败',
                                    type: 'error',
                                })
                                console.log(err);
                            })
                    } else if (this.dialogData.oprate === 'delete') {
                        this.dialogFormVisible = false
                        ComAPI.post(this.apiSet.delete, this.targeted)
                            .then(res => {
                                console.log(res);
                                if (res.code === 200) {
                                    ElMessage({
                                        showClose: true,
                                        message: '删除成功',
                                        type: 'success',
                                    })
                                    //把 targeted 从 tableData 中移除
                                    // console.log(this.tableData.table.data);
                                    for (let i = 0; i < (this.tableData.table.data).length; i++) {
                                        // console.log(this.queryConfig.attr1);
                                        // console.log(this.targeted[this.queryConfig.attr1]);
                                        // console.log(this.tableData.table.data[i][this.queryConfig.attr1])
                                        if (this.targeted[this.queryConfig.attr1] === this.tableData.table.data[i][this.queryConfig.attr1]) {
                                            this.tableData.table.data.splice(i, 1)
                                        }
                                    }
                                }
                            }).catch(err => {
                                ElMessage({
                                    showClose: true,
                                    message: '删除失败',
                                    type: 'error',
                                })
                                console.log(err);
                            })

                    }
                }
            })
        },
        queryOne() {
            this.dataList = this.tableData.table.data.filter((p) => {
                let pat = "/^" + this.queryConfig.query1 + "/"
                for (let key in p) {
                    if (key === this.queryConfig.attr1) {
                        let value = p[key]
                        return value.match(eval(pat)) !== null
                    }
                }
            })
        },
        queryTwo() {
            this.dataList = this.tableData.table.data.filter((p) => {
                let pat = "/^" + this.queryConfig.query2 + "/"
                for (let key in p) {
                    if (key === this.queryConfig.attr2) {
                        let value = p[key]
                        return value.match(eval(pat)) !== null
                    }
                }
            })
        },
        handleEdit(index, row) {
            this.dialogData.title = '编辑' + this.dialogData.type
            this.dialogFormVisible = true
            //选中行的值 赋给 target
            for (let key in row) {
                this.target[key] = row[key]
            }
            //选中行的值 赋给 editTarget  关联
            this.editTarget = row
            this.dialogData.oprate = 'edit'

            // console.log('row:', row)
            // console.log(this.editTarget)
            // ElMessage(`click on Edit`);
        },
        handleDelete(index, row) {
            this.dialogData.title = '删除' + this.dialogData.type
            this.dialogFormVisible = true
            //选中行的值 赋给 target
            for (let key in row) {
                this.target[key] = row[key]
            }
            this.targeted = row
            this.dialogData.oprate = 'delete'

            // ElMessage(`click on Delete`);
        },
    },
    computed: {
    }
};

</script>

