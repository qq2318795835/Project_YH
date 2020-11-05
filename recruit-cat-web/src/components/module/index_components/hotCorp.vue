<template>
<div class="main5">
  <div class="line-f">
    <p class="txt1">热门企业</p>
  </div>
  <div class="m5-body">
    <el-card shadow="hover" class="m5-card1">
      <div class="main5-card1-body">
        <div class="main5-card1-body-line1">
          123
        </div>
        <div class="main5-card1-body-line2">
          跟谁学
        </div>
        <div class="main5-card1-body-line3">
          123其他行业
          <span class="m4-card1-con2-1-v"></span>
          已上市123123
        </div>
        <div class="main5-card1-body-line4">
          <el-button plain class="main5-card1-body-line4-button">
            568个热招职位
          </el-button>
        </div>
      </div>
    </el-card>

  </div>
  <div class="m4-button1">
    <a href="" @click.prevent="goCorp" class="card-line-type-a">
      <el-button type="primary" class="m4-button1-b1">查看更多</el-button>
    </a>
  </div>
  <div class="back-top">
    <el-backtop class="back-top-icon">
    </el-backtop>
  </div>
</div>
</template>

<script>
    export default {
        name: "hotCorp",
        methods:{
            goCorp(){
                this.$router.push({path:'/corp'})
            },
        },
    }
</script>

<style scoped>
@import "../../../assets/css/index_components/hotCorp.css";
</style>
