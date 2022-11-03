<template>
    <el-dialog style v-model="editFlag" top="60px" width="95%" :close-on-click-modal=false :close-on-press-escape=false>
        <div>
            <el-input v-model="title" placeholder="标题"></el-input>
        </div>


        <md-editor v-model="handbook" />

        <el-button type="primary" @click="editHandler(item.index)">保存</el-button>
        <el-button type="danger" @click="deleteHandler(item.index)">取消</el-button>
    </el-dialog>

</template>

<script>
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
export default {
    components: {
        MdEditor
    },
    props: {},
    data() {
        return {
            markdownOption: {
            },
            handbook: "",
            title: ""
        };
    },
    methods: {

    },
    computed: {
        editFlag: {
            set(value) {
                this.$store.state.editFlag = value;
            },
            get() {
                return this.$store.state.editFlag;
            }
        }
    },
    watch: {

    },
    mounted() {

    },
}

</script>

<style lang='less' scoped>
.mavonEditor {
    width: 100%;
    height: 100%;
}
</style>

