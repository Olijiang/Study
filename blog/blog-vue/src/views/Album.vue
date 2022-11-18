<template>
    <div>
        <el-row class="header">
            <el-col class="space"></el-col>
            <el-col class="item">
                <span class="fenlei">分类</span>
                <hr class="line" align="center" />
                <span class="jutifenlei">全部</span>
            </el-col>
            <el-col class="item">
                <span class="fenlei">分类</span>
                <hr class="line" align="center" />
                <span class="jutifenlei">人物</span>
            </el-col>

            <el-col class="item">
                <span class="fenlei">分类</span>
                <hr class="line" align="center" />
                <span class="jutifenlei">风景</span>
            </el-col>
            <el-col class="item">
                <span class="fenlei">分类</span>
                <hr class="line" align="center" />
                <span class="jutifenlei">科幻</span>
            </el-col>
            <el-col class="space"></el-col>
        </el-row>
        <el-row>
            <el-col :span="1"></el-col>
            <el-col :span="10" style="margin:1% 0;">
                <hr width="100%" align="left" />
            </el-col>
            <el-col :span="2" style="color: deeppink;margin:1% 0">
                <span>
                    精选图片
                </span>
            </el-col>
            <el-col :span="10" style="margin:1% 0;">
                <hr width="100%" align="right" />
            </el-col>
            <el-col :span="1"></el-col>
        </el-row>

        <el-row class="body">
            <el-col class="space"></el-col>
            <el-col class="item"></el-col>
            <el-col class="item"></el-col>
            <el-col class="item"></el-col>
            <el-col class="item"></el-col>
            <el-col class="space"></el-col>
        </el-row>
        <el-row class="body1">
            <el-col class="space"></el-col>
            <el-col class="item"></el-col>
            <el-col class="item"></el-col>
            <el-col class="item"></el-col>
            <el-col class="item"></el-col>
            <el-col class="space"></el-col>
        </el-row>

    </div>
</template>

<script setup>
</script>

<style lang='less' scoped>
@transition: all 0.5s ease-in-out;

.header {
    margin-top: 80px;
    height: 200px;
    flex-wrap: nowrap
}

.body {
    height: 200px;
    flex-wrap: nowrap
}

.body1 {
    margin-top: 50px;
    height: 200px;
    flex-wrap: nowrap
}

.space {
    max-width: 2%;
    flex: 0 0 2%;
}

.item {
    cursor: pointer;
    max-width: 20%;
    flex: 0 0 20%;
    min-width: 200px !important;
    margin: 0 2%;
    border: 1px solid skyblue;
    transition: @transition;

    .line {
        width: 100px;
        transition: @transition;
    }

    .fenlei {
        display: block;
        font-size: 20px;
        margin-top: 50px;
        transition: @transition;
    }

    .jutifenlei {
        display: block;
        font-size: 25px;
        transition: @transition;

    }

    &:hover {
        .line {
            background-color: skyblue;
            height: 1px;
            width: 100%;
        }

        .jutifenlei {
            color: skyblue;
            font-size: 40px;
        }
    }
}

</style>