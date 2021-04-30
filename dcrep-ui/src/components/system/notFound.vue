<template>
  <div class="body">
    <h2>抱歉，您输入的地址没有找到</h2>
    <h3>o(╥﹏╥)o</h3>
    <el-button type="text" @click="goLogin">点击返回主页</el-button>
  </div>
</template>

<script>
    export default {
        name: 'notfound',
        data() {
            return {

            }
        },
        methods: {
            goLogin() {
                this.$router.push({
                    path: '/index'
                })
            }
        },
        mounted() {
            (document.getElementById('loading')).style.display = "none"
        }
    }
</script>
<style scoped>
.body{
  color: white;
  background: url("../../assets/img/system/notFound.jpg");
  margin-top: -8px;
  margin-left: -8px;
  background-size: 50% 50%;
  width: 100%;
  height: 100%;
  position: fixed;
  padding: 0
}
</style>
