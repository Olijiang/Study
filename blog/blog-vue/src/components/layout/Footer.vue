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
    z-index: 1;
    height: 80px;
    text-align: center;
    vertical-align: middle;
    box-shadow: 0px 0px 1px #dadaad;
    background: linear-gradient(45deg, hsla(0, 30%, 85%, 0.5), hsla(60, 30%, 85%, 0.5), hsla(120, 30%, 85%, 0.5), hsla(180, 30%, 85%, 0.5), hsla(240, 30%, 85%, 0.5), hsla(300, 30%, 85%, 0.5), hsla(360, 30%, 85%, 0.5));
    background-size: 500% 500%;
    animation: Gradient 15s ease infinite;
    font-family: sans-serif;
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