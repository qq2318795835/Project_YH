<template>
    <div class="main4">
      <div class="line-f">
        <p class="txt1">热招职位</p>
      </div>
      <div class="main4-body">
        <el-card shadow="hover" class="m4-card1">
          <div class="m4-card1-con">
            <div class="m4-card1-con1">
              <div class="m4-card1-con1-1">
                合成工艺主管/组长
              </div>
              <div class="m4-card1-con1-2">
                18-25K·14薪
              </div>
            </div>
            <div class="m4-card1-con2">
              <div class="m4-card1-con2-1">
                天津
                <span class="m4-card1-con2-1-v"></span>
                一年以内
                <span class="m4-card1-con2-1-v"></span>
                博士
              </div>
            </div>
          </div>
          <hr class="style7"/>
          <div class="m4-card1-con-B">
            <div class="m4-card1-con-B-1">

            </div>
            <div class="m4-card1-con-B-2">
              凯莱英医药集团
            </div>
            <div class="m4-card1-con-B-3">
              其他行业
              <span class="m4-card1-con2-1-v"></span>
              已上市
            </div>
          </div>
        </el-card>
      </div>
      <div class="m4-button1">
        <a href="" @click.prevent="goJob" class="card-line-type-a">
          <el-button type="primary" class="m4-button1-b1">查看更多</el-button>
        </a>
      </div>
    </div>
</template>

<script>
    export default {
        name: "hotJob",
        methods:{
            goJob(){
                this.$router.push({path:'/job'})
            },
        },
    }
</script>

<style scoped>
@import "../../../assets/css/index_components/hotJob.css";
</style>
