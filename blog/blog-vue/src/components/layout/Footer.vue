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
    background: linear-gradient(45deg, #ff5757, #ffc157, #fcff57, #57ff68, #57ffe3, #575fff, #db57ff);
    background-size: 500% 500%;
    animation: Gradient 15s ease infinite;
    font-family: sans-serif;

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