<template>
    <div class="body">
        <div style="display: flex;justify-content: space-between;">
            <div>
                <div style="width: 200px;display: inline-block;">
                    <el-input v-model="query" />
                </div>
                <div style="margin-left: 20px;display: inline-block;">
                    <el-button color="#626aef" @click="queryHandler">查找</el-button>
                </div>
            </div>

            <div style="margin-left: 20px;">
                <el-button color="#ffae19" @click="addHandler">新增文章</el-button>
            </div>
        </div>
        <div>
            <TransitionGroup tag="div" @before-enter="onBeforeEnter" @enter="onEnter" @leave="onLeave">
                <div v-for="(item, index) in computedList" :key="item.index" :data-index="index" class="item">
                    <div style="width: 85%;">
                        <div>
                            <span style="margin-top: 5px;font-size: 20px; color:#ff0000;display: inline-block;">{{
                                    item.title
                            }}</span>
                            <span style="margin: 0 20px; line-height: 20px;font-size: 80%;color: #4f8edd">
                                {{ item.createTime }} || {{ item.tag }}</span>
                        </div>
                        <div style="margin: 4px 0; text-indent: 2em;line-height: 20px;">{{ item.digest }}
                        </div>
                    </div>
                    <div style="margin: auto 0;">
                        <el-button type="primary" @click="editHandler(item.index)">编辑</el-button>
                        <el-button type="danger" @click="deleteHandler(item.index)">删除</el-button>
                    </div>
                </div>
            </TransitionGroup>
        </div>
    </div>
    <!-- <ArticleEditorVue></ArticleEditorVue> -->
</template>

<script>

import gsap from 'gsap'
import ArticleEditorVue from './ArticleEditor.vue'

export default {
    components: {
        ArticleEditorVue
    },
    props: {},
    data() {
        return {
            editFlag: false,
            query: "",
            list: [
                { index: 1, title: "段落标题段落标题段落标题段落标题段落标题", createTime: "2012-01-23", category: "Vue", tag: "vuex", digest: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
                { index: 2, title: "段落标题", createTime: "2014-02-21", category: "Java", tag: "多线程", digest: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" },
                { index: 3, title: "段落标题", createTime: "2015-01-27", category: "Vue", tag: "router", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/3.png" },
                { index: 4, title: "段落标题", createTime: "2016-02-15", category: "Redis", tag: "redis", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
                { index: 5, title: "段落标题", createTime: "2017-11-23", category: "Python", tag: "CNN", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" },
                { index: 6, title: "段落标题", createTime: "2018-05-29", category: "Vue", tag: "mock", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/3.png" },
                { index: 7, title: "段落标题", createTime: "2019-08-01", category: "Java", tag: "springboot", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
                { index: 8, title: "段落标题", createTime: "2021-04-29", category: "Vue", tag: "vuex", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" }
            ]
        }
    },
    methods: {
        onBeforeEnter(el) {
            el.style.opacity = 0
            el.style.height = 0
        },
        onEnter(el, done) {
            gsap.to(el, {
                opacity: 1,
                height: '55px',
                delay: el.dataset.index * 0.15,
                onComplete: done
            })
        },
        onLeave(el, done) {
            gsap.to(el, {
                opacity: 0,
                height: 0,
                delay: el.dataset.index * 0.15,
                onComplete: done
            })
        },
        queryHandler() {

        },
        addHandler() {

        },
        editHandler(aricleId) {
            console.log(this.$store.state.editFlag);
            this.$store.state.editFlag = true
        },
        deleteHandler(aricleId) {

        },
    },
    computed: {
        computedList() {
            return (this.list.filter((item) => item.title.includes(this.query))).filter((item) => item.digest.includes(this.query))
        }
    },
    watch: {

    },
    mounted() {

    },
}

</script>

<style lang='less' scoped>
.body {
    text-align: left;
    margin: 60px 3% 30px 3%;
}

.item {
    display: flex;
    justify-content: space-between;
    border: 1px solid #9c9c9c;
    box-shadow: 0 1px 2px #c7c7c7;
    border-radius: 10px;
    overflow: hidden;
    margin: 10px 0;
    padding: 0 10px;
    height: 55px;
}
</style>