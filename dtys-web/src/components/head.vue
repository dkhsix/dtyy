<template>
    <div style=" height: 60px;
        width: 100%;
        background: #FFFFFF;">
        <el-input
                v-model="text"
                class="searchInput"
                placeholder="请输入"
        >
            <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
    </div>
</template>

<script>
    export default {
        name: "menu",
        data() {
            return {
                text: ''
            };
        },
        methods: {}
    }
</script>

<style scoped>
    .searchInput {
        width: 360px;
        float: right;
        margin-right: 50px;
        margin-top: 10px;
        height: 40PX;
        border-radius: 5px;
    }
</style>
