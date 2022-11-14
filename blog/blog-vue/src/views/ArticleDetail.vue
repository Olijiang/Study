<template>
    <div>
        <transition name="el-fade-in">
            <div class="illustration">
                <img :src=article.img alt="">
                <div class="ArticleInfo">
                    <h1 style="margin: 20px;color:rgb(9, 214, 180);font-size: 50px;"> {{ article.title }} </h1>
                    <p style="margin: 10px;">
                        <el-tag type="success" style="font-size: 15px;">
                            创作时间
                        </el-tag>:
                        <el-tag type="danger" style="font-size: 15px;">
                            {{ article.createTime }}
                        </el-tag>
                    </p>
                    <p style="margin: 10px;">
                        <el-tag type="success" style="font-size: 15px;">
                            分类
                        </el-tag>:
                        <el-tag type="danger" style="font-size: 15px;">
                            {{ article.category }}
                        </el-tag>

                        <el-tag type="success" style="font-size: 15px;margin-left: 20px;">
                            标签
                        </el-tag>:
                        <el-tag type="danger" style="font-size: 15px; margin-right: 10px;"
                            v-for=" (item, index) in article.tag" :key="index">
                            {{ item }}
                        </el-tag>
                    </p>
                </div>
            </div>
        </transition>
        <el-row>
            <el-col class="vacancy"></el-col>
            <el-col class="space"></el-col>
            <el-col class="articleCol">
                <div class="markdown-body" v-html='articleHtml'>
                </div>
            </el-col>
            <el-col class="space"></el-col>
            <el-col class="catelogCol">
                <!-- 目录 -->
                <div class="articleCatelog" :style="{ top: `calc(${tocTop}px)` }">
                    <h3>目 录</h3>

                    <ol>
                        <li v-for="(item, index) in tocContent" :key="index">
                            <span class="toc_item" :id="item.href.substring(1) + 'f'" @click="jump(item.href)">
                                {{ item.level }}. {{ item.text }}
                            </span>
                            <ol v-if="item.children.length != 0">
                                <li v-for="(c, ci) in item.children" :key="ci" style="padding-left: 20px;">
                                    <span class="toc_item" @click="jump(c.href)" :id="c.href.substring(1) + 'f'">
                                        {{ c.level }}. {{ c.text }}
                                    </span>
                                </li>
                            </ol>
                        </li>
                    </ol>
                </div>
            </el-col>
        </el-row>


        <backToTop></backToTop>
    </div>
</template>

<script>
import backToTop from '@/components/backToTop.vue'
import API from '../utils/API';
import markdownToHtml from '@/utils/markdown'

export default {
    components: {
        backToTop
    },
    props: {},
    data() {
        return {
            headings: [],   //存放全部标题
            curHeading: "", //当前激活标题
            articleHtml: "",
            article: {
                title: "",
                category: "",
                tag: [],
                content: "",
                img: ""
            },
            tocContent: "",
            // 标题的id集合
            tocId: [],
            tocTop: 20,
            timeout: null,
            lastTag: null
        }
    },
    methods: {
        detecator() {
            clearTimeout(this.timeout)
            this.timeout = setTimeout(() => {
                let y = document.documentElement.scrollTop || document.body.scrollTop
                this.tocId.forEach(e => {
                    let x = document.querySelector(e).offsetTop + 620
                    if (x - y <= 10) this.lastTag = e
                })
                if (y < 600) this.lastTag = this.tocId[0]
            }, 100);
        },
        jump(hool) {
            document.querySelector(hool).scrollIntoView({ behavior: "smooth" }); //这里的counter1是将要返回地方的id
            this.lastTag = hool
        },
        // 生成目录, 只支持二级
        generateToc() {
            let patt = /<h[1-3]>(.{0,50})<\/h[1-3]>/g;
            let result = this.articleHtml.match(patt)
            let toc = []
            let n = 0
            for (let i = 0; i < result.length; i++) {
                let e = result[i];
                if (toc[n] == undefined) {
                    toc[n] = {}
                    toc[n].level = n + 1
                    toc[n].tag = e
                    toc[n].text = e.replace(/<h[1-3]>/g, "").replace(/<\/h[1-3]>/g, "")
                    toc[n].children = []
                    toc[n].href = "#hool" + toc[n].level
                    // 给result加个定位id
                    result[i] = e.substring(0, 3) + " id='hool" + toc[n].level + "'" + e.substring(3)
                    this.articleHtml = this.articleHtml.replace(e, result[i])
                    this.tocId.push(toc[n].href)
                    continue
                }
                let le = e[2]
                if (le > (toc[n].tag)[2]) {
                    let c = {}
                    c.level = toc[n].level + "." + (toc[n].children.length + 1)
                    c.tag = e
                    c.text = e.replace(/<h[1-3]>/g, "").replace(/<\/h[1-3]>/g, "")
                    c.href = "#hool" + toc[n].level + "_" + (toc[n].children.length + 1)
                    toc[n].children.push(c)
                    // 给result加个定位id
                    result[i] = e.substring(0, 3) + " id='hool" + c.level.replace(".", "_") + "'" + e.substring(3)
                    // 替换this.articleHtml
                    this.articleHtml = this.articleHtml.replace(e, result[i])
                    this.tocId.push(c.href)
                } else {
                    n++;
                    i--;
                }
            }
            this.tocContent = toc
        }
    },
    computed: {

    },
    watch: {
        lastTag: {
            handler(newValue, oldValue) {
                let tag = document.querySelector(newValue + "f")
                let offsetTop = tag.offsetTop
                let w = document.documentElement.clientHeight / 2;
                if (offsetTop > w) {
                    this.tocTop = w - offsetTop
                } else {
                    this.tocTop = 20
                }
                this.tocId.forEach(e => {
                    let tag = document.querySelector(e + "f")
                    if (e == newValue) {
                        tag.style.backgroundColor = '#b2fffe'
                        tag.style.color = '#0400ff'
                    } else {
                        tag.style.backgroundColor = ''
                        tag.style.color = ''
                    }
                })


            }
        }
    },
    mounted() {
        let data = { "ArticleId": this.$route.path.split('/')[2] }
        API.get("api/init/getArticle", data)
            .then(res => {
                this.article = res.data
                this.article.img = "api/" + this.article.img
                this.article.tag = JSON.parse(this.article.tag).tags
                let data = { "fileName": this.article.content.split('\\')[1] }
                API.get("api/init/getContent", data)
                    .then(res => {
                        if (res.code == 200) {
                            // console.log(res);
                            this.articleHtml = markdownToHtml(res.data)
                            this.generateToc()
                            setTimeout(() => {
                                this.lastTag = this.tocId[0]
                                window.addEventListener("scroll", this.detecator)
                            }, 200);
                        }

                    })
            })

    },
}

</script>

<style lang='less' scoped>
.illustration {
    position: relative;
    width: 100%;
    height: 600px;
    margin-bottom: 20px;
    transition: all 0.5s;

    img {
        height: 100%;
        width: 100%;
        object-fit: cover;
        vertical-align: middle;
        transition: all 0.5s ease-in-out;
        border-radius: 0px 0px 10px 10px;
        transition: all 0.3s ease;
    }

    .ArticleInfo {
        position: absolute;
        width: 100%;
        // height: 100%;
        // color: white;
        top: 300px;
        margin: 0 auto;
    }
}

.vacancy {
    flex: 0 0 15%;
    max-width: 60%;
    transition: all 0.5s;
}

.articleCol {
    min-height: 300px;
    max-width: 60%;
    transition: all 0.5s ease;
    margin-bottom: 30px;
    text-align: left;

    .markdown-body {
        margin: 0;
        padding: 10px 40px;
        overflow-y: hidden;
        border-radius: 10px;
        background-color: rgba(255, 255, 255, 0.6);
        box-shadow: 0 0 5px rgb(200, 200, 200);
        transition: all 0.5s;

        &:hover {
            box-shadow: 0 0 10px rgb(200, 200, 200);
            transition: all 0.5s;
        }

    }
}

.catelogCol {
    max-width: 15%;
    flex: 0 0 15%;

    .articleCatelog {
        padding: 10px;
        margin: 0 0 30px 0;
        position: sticky;
        width: 220px;
        height: auto;
        min-height: 200px;
        border-radius: 15px;
        background-color: rgba(255, 255, 255, 0.6);
        box-shadow: 0 0 10px rgb(200, 200, 200);
        transition: all 0.5s;

        &:hover {
            box-shadow: 0 0 10px rgb(200, 200, 200);
            transition: all 0.5s;
        }
    }
}

.space {
    max-width: 3%;
    flex: 0 0 3%;
}

@media (max-width: 1200px) {
    .vacancy {
        max-width: 0%;
        flex: 0 0 0%;
        transition: all 0.5s;

        * {
            display: none;
        }
    }

    .articleCol {
        max-width: 70%;
        flex: 0 0 80%;
        transition: all 0.5s ease;
        margin-bottom: 30px;
        text-align: left;
    }

    .catelogCol {
        max-width: 20%;
        flex: 0 0 20%;
    }
}

@media (max-width: 800px) {
    .articleCol {
        max-width: 95%;
        flex: 0 0 95%;
        transition: all 0.5s ease;
        margin-bottom: 30px;
        text-align: left;
    }

    .catelogCol {
        max-width: 0;

        * {
            display: none;
        }
    }
}

li,
ol {
    margin: 0;
    padding: 0;
    text-align: left;
    list-style: none;
}


.toc_item {
    display: block;
    border-radius: 10px;
    cursor: pointer;
    padding: 5px;
    margin: 0 0 5px 5px;
    transition: all 0.3s;

    &:hover {
        background: rgb(238, 248, 247);
    }
}
</style>