<template>


    <div class="home-page">
        <transition name="el-fade-in">
            <img src="../img/P1.png" alt="">
        </transition>
    </div>

    <el-row v-if="ok">
        <el-col class="space"></el-col>
        <el-col class="ArticleCard">
            <!-- 文章部分 -->
            <div v-for="(aricle, index) in articleList" :key=index>
                <transition name="el-zoom-in-top">
                    <vArticleCard :article=aricle />
                </transition>
            </div>
        </el-col>
        <el-col class="space"></el-col>
        <el-col class="AuthorCard">
            <vAuthorCard></vAuthorCard>
        </el-col>
        <el-col class="space"></el-col>
    </el-row>


    <div v-if="hasover" class="endmsg">已经到底了...</div>

</template>



<script>

import vArticleCard from '@/components/v-articleCard.vue'
import vAuthorCard from '@/components/v-authorCard.vue'
import API from '../utils/API'

export default {
    name: 'Home',
    props: {},
    components: {
        vArticleCard,
        vAuthorCard
    },
    data() {
        return {
            hasover: false,
            articleList: [],
            ok: false
        }
    },
    methods: {

    },
    computed: {
    },
    watch: {

    },
    mounted() {
        API.get('/init')
            .then(res => {
                this.articleList = res.articles
                this.$store.commit("setAuthorInfo", res.author)
                this.ok = true
            })
    },
}


</script>


<style lang="less" scoped>
.home-page {
    width: 100%;
    height: 900px;
    margin-bottom: 30px;
    transition: all 0.3s ease;

    img {
        height: 100%;
        width: 100%;
        object-fit: cover;
        vertical-align: middle;
        transition: all 0.5s ease-in-out;
        border-radius: 0px 0px 20px 20px;
        transition: all 0.3s ease;
    }
}

.endmsg {
    position: absolute;
    bottom: 15px;
    width: 100%;
    font-size: 90%;
    color: #858585;
}

.ArticleCard {
    max-width: 70%;
    flex: 0 0 70%;
    transition: all 0.5s ease;
}

.AuthorCard {
    display: block;
    transition: all 0.5s ease;
    max-width: 16%;
    flex: 0 0 16%;
}

.space {
    max-width: 3%;
    flex: 0 0 3%;
}

@media (max-width: 1000px) {
    .ArticleCard {
        max-width: 95%;
        flex: 0 0 95%;
        transition: all 0.5s ease;


    }

    .AuthorCard {
        max-width: 0%;
        // flex: 0 0 0%;
        transition: all 0.5s ease;

        * {
            display: none;
        }
    }
}
</style>

