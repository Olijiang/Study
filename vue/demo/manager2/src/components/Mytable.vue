<template>
    <div class="mytable">
        <el-row :gutter="10">
            <el-col :span="5">
                <el-input v-model="queryConfig.query1" class="w-50 m-2" :placeholder="queryConfig.tip1" maxlength="10"
                    @keyup.enter='queryOne' clearable>
                    <template #append>
                        <el-button icon="Search" @click="queryOne" />
                    </template>
                </el-input>
            </el-col>

            <el-col :span="1"> </el-col>
            <el-col :span="5">
                <el-input v-model="queryConfig.query2" class="w-50 m-2" :placeholder="queryConfig.tip2" maxlength="10"
                    @keyup.enter='queryTwo' clearable>
                    <template #append>
                        <el-button icon="Search" @click="queryTwo" />
                    </template>
                </el-input>
            </el-col>
            <el-col :span="5"> </el-col>
            <el-col :span="1">
                <el-button type="primary" plain @click="addMenber" style="width: 80px;">添加{{dialogData.userType}}
                </el-button>
            </el-col>
        </el-row>

        <el-dialog v-model="dialogFormVisible" :close-on-click-modal=false :title="dialogData.title" width="400px"
            @close='cancelDialog' style=" border-radius: 30px; opacity: 0.9;background-color: aliceblue;"
            @keyup.enter='confirm'>
            <el-form :model="target" :rules="rules" ref="dialogRef">
                <el-form-item v-for="(item, index) in dialogData.data" :key="index" :label="item.label"
                    label-width="80px" :prop="item.attr">
                    <!-- 部分选择框 -->
                    <el-select v-if="item.children" v-model="target[item.attr]" :placeholder="item.children.placeholder"
                        style="width: 230px;" :disabled="cacldisable(item.attr, dialogData.oprate)">
                        <el-option v-for="option in item.children.data" :label="option" :value="option" />
                    </el-select>

                    <el-input v-else type="text" v-model="target[item.attr]" autocomplete="off" clearable
                        :disabled="cacldisable(item.attr, dialogData.oprate)" style="margin-right: 50px;" />
                </el-form-item>
            </el-form>

            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="dialogFormVisible=false">取消</el-button>
                    <el-button type="primary" @click="confirm">确认</el-button>
                </span>
            </template>
        </el-dialog>

        <el-table v-loading="pageLoading" id="mytable" :data="dataList" stripe height="674"
            style="width: fit-content;margin-top: 10px;" @selection-change="handleSelectionChange" border
            @filter-change="filterChange">

            <el-table-column type="selection" width="55" />

            <el-table-column type="index" label="编号" width="60" />

            <el-table-column v-for="col in headerList" :key="col.index" :prop="col.prop" :label="col.label"
                :width="col.width?col.width:200" :sortable="caclSort(col.prop)" :default-sort="col.id"
                :filters="col.filters? col.filters:undefined" :column-key="col.prop" />

            <el-table-column label="管理" width="160">
                <template #default="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
                    <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination style="margin-top: 15px;margin-left: 240px;" v-model:currentPage="currentPage"
            v-model:page-size="pageSize" :page-sizes="[15, 30, 50]" background small
            layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
            @current-change="handleCurrentChange" />
    </div>
</template>


<script>
import { ElMessage } from "element-plus";
import ComAPI from '@/utils/ComAPI';
export default {
    data() {
        return {
            total: 10,
            pageLoading: false,
            currentPage: 1,
            pageSize: 15,
            dialogFormVisible: false,
            dialogData: {
                userType: '',
                oprate: '',
                title: '',
                data: [{ label: '', attr: '' },],  //label 和 查询用的属性
            },
            target: {}, // 存dialog中的对象，dialog关闭时会清空
            targeted: {},   //存放完成的dialog中的对象
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

            queryConfig: {
                query1: '', //查询关键字绑定变量
                query2: '',
                tip1: '',   //placeholder
                tip2: '',
                attr1: '',  //要查的属性
                attr2: ''
            },
            //

            dataList: [],   //table 数据
            headerList: [], //table 数据头

            apiSet: {
                get: '',
                add: '',
                delete: '',
                update: ''
            },
            multipleSelection: [],

            // 存放查询筛选的条件
            filterSet: {}
        }
    },
    props: {
        tableData: Object,
    },
    watch: {
        // 数据过来后赋值给一个本地变量用于筛选显示
        tableData: {
            immediate: true,
            deep: true,
            handler() {
                // console.log("tableData", this.tableData);
                // this.dataList = this.tableData.data   //列表数据
                this.headerList = this.tableData.config.tableHeader   //表头数据
                this.queryConfig = this.tableData.config.queryConfig
                this.dialogData = this.tableData.config.dialog
                this.apiSet = this.tableData.config.apiSet

            }
        },
        dialogFormVisible: {
            handler() {
                // this.$refs['dialogRef'].resetFields()
            }
        },

    },
    mounted() {
        // 请求第一页表格数据
        this.getTableData()
    },
    methods: {
        filterChange(column) {
            let key
            // 记录筛选属性
            for (key in column) {
                this.filterSet[key] = []
            }
            // console.log(column[key]);
            // 记录筛选属性的值
            for (let i in column[key]) {
                // console.log(column[key][i]);
                this.filterSet[key].push(column[key][i])
            }
            console.log(this.filterSet);
            // 生成表单
            this.getTableData()

        },
        getTableData() {
            let data = {
                current: this.currentPage,
                pageSize: this.pageSize,
                filter: []  //{ attr = "", values = [] }
            };
            let n = 0
            for (let attr in this.filterSet) {
                if (this.filterSet[attr].length > 0) {
                    data.filter.push({ "attr": attr, "values": [] })
                    this.filterSet[attr].forEach(value => {
                        data.filter[n].values.push(value)
                    });
                }
                n++
            }
            this.pageLoading = true
            ComAPI.post(this.apiSet.get, data).then(res => {
                if (res.code === 200) {
                    this.dataList = res.data
                    this.total = res.total
                }
                setTimeout(() => {
                    this.pageLoading = false
                }, 50);
            })
        },
        handleSizeChange() {
            // 页面size改变
            this.currentPage = 1
            this.getTableData()
        },
        handleCurrentChange(val) {
            // 页码变化
            this.getTableData()
        },
        filterHandler(value, row, column) {
            console.log(value); //
            const property = column['property']
            return row[property] === value
        },
        handleSelectionChange(val) {
            // val  多选的对象  数组
            console.log(val);
        },
        caclSort(value) {
            if (value.match(/id$/) != null) return true
            return false
        },
        cacldisable(attr, oprate) {
            // id name age 不允许修改
            if (oprate === 'edit') {
                let exp = /id|ame$|age/
                if (attr.match(exp) != null) {
                    return true
                } else return false
            } else if (oprate === 'delete') return true

        },
        cancelDialog() {
            // this.$refs['dialogRef'].resetFields()  //重置表单数据  
            this.$refs['dialogRef'].clearValidate() //  重置表单验证结果
            if (this.dialogData.oprate != "add") {
                // 当操作不是 add 时， 清除dialog数据
                this.target = {}
            }
            this.dialogFormVisible = false
        },
        addMenber() {
            this.dialogData.title = '添加' + this.dialogData.userType
            this.dialogFormVisible = true
            this.dialogData.oprate = 'add'
        },
        confirm() {
            // 验证表单
            this.$refs['dialogRef'].validate(valid => {
                if (valid) {
                    // add 操作关闭时dialog数据不会清除，成功后要手动清除数据
                    let data = {
                        obj: this.target
                    }
                    if (this.dialogData.oprate === 'add') {
                        //调用添加人员的api
                        ComAPI.post(this.apiSet.add, data).then(res => {
                            if (res.code === 200) {
                                ElMessage({
                                    showClose: true,
                                    message: '添加成功',
                                    type: 'success',
                                })
                                //tabledata里面也加一个 或者 重定向当前页面重新向数据库请求
                                this.tableData.data.push(this.target)
                                this.dialogFormVisible = false
                            }
                        })
                    } else if (this.dialogData.oprate === 'edit') {
                        //调用添加人员的api
                        ComAPI.post(this.apiSet.update, data).then(res => {
                            if (res.code === 200) {
                                ElMessage({
                                    showClose: true,
                                    message: '修改成功',
                                    type: 'success',
                                })
                                //把 targeted 的值 赋值给 editTarget， 相当于 给了row
                                for (let key in this.targeted) {
                                    this.targeted[key] = this.target[key]
                                }
                                this.dialogFormVisible = false
                            }
                        })
                    } else if (this.dialogData.oprate === 'delete') {
                        ComAPI.post(this.apiSet.delete, data).then(res => {
                            console.log(res);
                            if (res.code === 200) {
                                ElMessage({
                                    showClose: true,
                                    message: '删除成功',
                                    type: 'success',
                                })
                                //把 targeted 从 tableData 中移除
                                for (let i = 0; i < this.tableData.data.length; i++) {
                                    // console.log(this.queryConfig.attr1);
                                    // console.log(this.targeted[this.queryConfig.attr1]);
                                    // console.log(this.tableData.data[i][this.queryConfig.attr1])
                                    if (this.targeted[this.queryConfig.attr1] === this.tableData.data[i][this.queryConfig.attr1]) {
                                        this.tableData.data.splice(i, 1)
                                    }
                                }
                                this.dialogFormVisible = false
                            }
                        })
                    }
                }
            })
        },
        queryOne() {
            this.dataList = this.tableData.data.filter((p) => {
                // 从头开始匹配
                // let pat = "/^" + this.queryConfig.query1 + "/"
                // for (let key in p) {
                //     if (key === this.queryConfig.attr1) {
                //         let value = p[key]
                //         return value.match(eval(pat)) !== null
                //     }
                // }
                // 包含内容即可
                for (let key in p) {
                    if (key === this.queryConfig.attr1) {
                        let value = p[key]
                        return value.indexOf(this.queryConfig.query1) !== -1
                    }
                }
            })
        },
        queryTwo() {
            this.dataList = this.tableData.data.filter((p) => {
                // let pat = "/^" + this.queryConfig.query2 + "/"
                // for (let key in p) {
                //     if (key === this.queryConfig.attr2) {
                //         let value = p[key]
                //         return value.match(eval(pat)) !== null
                //     }
                // }
                // 包含内容即可
                for (let key in p) {
                    if (key === this.queryConfig.attr2) {
                        let value = p[key]
                        return value.indexOf(this.queryConfig.query2) !== -1
                    }
                }
            })
            // 排序
        },
        handleEdit(index, row) {
            this.dialogFormVisible = true
            this.dialogData.title = '编辑' + this.dialogData.userType
            //选中行的值 赋给 target
            for (let key in row) {
                this.target[key] = row[key]
            }
            //选中行的值 赋给 editTarget  关联, 用于后续修改row
            this.targeted = row
            this.dialogData.oprate = 'edit'
        },
        handleDelete(index, row) {
            this.dialogFormVisible = true
            this.dialogData.title = '删除' + this.dialogData.userType
            //选中行的值 赋给 target
            for (let key in row) {
                this.target[key] = row[key]
            }
            this.targeted = row
            this.dialogData.oprate = 'delete'
        },
    },
    computed: {
    }
};

</script>


<style scoped>
.mytable {
    position: absolute;
    overflow: hidden;
    min-width: 500px;
    width: 1300px;
    height: 750px;
    padding: 25px;
    border: 1px solid rgb(243, 238, 232);
    border-radius: 20px;
    box-shadow: 3px 3px 5px rgb(169, 169, 169);
}
</style>