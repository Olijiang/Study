<template>
    <footer>
        <div style="margin: auto;">@copyright</div>
    </footer>
</template>

<script>

export default {
    name: 'Footer',
    components: {

    },
    props: {},
    data() {
        return {

        }
    },
    methods: {

    },
    computed: {

    },
    watch: {

    },
    mounted() {

    },
}

</script>

<style lang='less' scoped>
footer {
    display: flex;
    height: 80px;
    text-align: center;
    vertical-align: middle;
    box-shadow: 0px 0px 1px #dadaad;
    background: linear-gradient(45deg, hsl(0, 30%, 90%, 0.8), hsl(60, 60%, 90%, 0.8), hsl(120, 60%, 90%, 0.8), hsl(180, 60%, 90%, 0.8), hsl(240, 60%, 90%, 0.8), hsl(320, 60%, 90%, 0.8), hsl(360, 60%, 90%, 0.8));
    background-size: 400% 400%;
    animation: Gradient 15s ease infinite;
    font-family: Consolas;
    // font-size: 20px;
    transition: all 0.5s;

    @keyframes Gradient {
        0% {
            background-position: 0 50%;
        }

        50% {
            background-position: 100% 50%;
        }

        100% {
            background-position: 0 50%;
        }
    }
}
</style>