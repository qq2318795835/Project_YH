<template>
    <div class="main1">
      <div class="small-body">
        <span>热门职位：</span>
        <span v-for="job in hotJob" class="small-line" >
          <a href="" class="small-line">{{job}}</a>
        </span>
      </div>
      <el-container class="main2">
        <el-card class="box-card1">
          <div class="card-line">
            <div class="card-line1">
              <div class="card-line-type">
              <span>技术:</span>
              </div>
              <div class="card-line-type1">
                <span v-for="type1 in jobType1" class="card-line-type1-s">
                  <a href="" @click.prevent="searchType(type1)" class="card-line-type1-1">{{type1}}</a>
                </span>
              </div>
            </div>
            <div class="card-line1">
              <div class="card-line-type">
                <span>产品:</span>
              </div>
              <div class="card-line-type1">
                <span v-for="type1 in jobType2" class="card-line-type1-s">
                  <a href="" @click.prevent="searchType(type1)" class="card-line-type1-1">{{type1}}</a>
                </span>
              </div>
            </div>
            <div class="card-line1">
              <div class="card-line-type">
                <span>设计:</span>
              </div>
              <div class="card-line-type1">
                <span v-for="type1 in jobType3" class="card-line-type1-s">
                  <a href="" @click.prevent="searchType(type1)" class="card-line-type1-1">{{type1}}</a>
                </span>
              </div>
            </div>
            <div class="card-line1">
              <div class="card-line-type">
                <span>运营:</span>
              </div>
              <div class="card-line-type1">
                <span v-for="type1 in jobType4" class="card-line-type1-s">
                  <a href="" @click.prevent="searchType(type1)" class="card-line-type1-1">{{type1}}</a>
                </span>
              </div>
            </div>
            <div class="card-line1">
              <div class="card-line-type">
                <span>市场:</span>
              </div>
              <div class="card-line-type1">
                <span v-for="type1 in jobType5" class="card-line-type1-s">
                  <a href="" @click.prevent="searchType(type1)" class="card-line-type1-1">{{type1}}</a>
                </span>
              </div>
            </div>
            <div class="card-line1">
              <div class="card-line-type">
                <span>HR:</span>
              </div>
              <div class="card-line-type1">
                <span v-for="type1 in jobType6" class="card-line-type1-s">
                  <a href="" @click.prevent="searchType(type1)" class="card-line-type1-1">{{type1}}</a>
                </span>
              </div>
            </div>
            <div class="card-line1">
            <div class="card-line-type">
              <span>高管:</span>
            </div>
            <div class="card-line-type1">
                <span v-for="type1 in jobType7" class="card-line-type1-s">
                  <a href="" @click.prevent="searchType(type1)" class="card-line-type1-1">{{type1}}</a>
                </span>
            </div>
          </div>
            <div class="card-line2">
              <a href="" @click.prevent="goJob" class="card-line-type-a">
                <div class="card-line3">
                  <li class="card-line-type-s">
                    更多职位
                  </li>
                  <li  class="card-line-type-s1">
                    <span class="el-icon-circle-plus-outline"></span>
                  </li>
                </div>
              </a>
            </div>
          </div>
        </el-card>

        <div class="box-card2">
          <img src="../../../assets/images/index_ad/gg1.jpg" height="226" width="522"/>
        </div>
        <div class="box-card3">
          <img src="../../../assets/images/index_ad/gg2.jpg" height="226" width="260"/>
        </div>
        <div class="box-card4">
          <img src="../../../assets/images/index_ad/gg3.jpg" height="112" width="522"/>
        </div>
        <div class="box-card5">
          <img src="../../../assets/images/index_ad/gg4.jpg" height="112" width="260"/>
        </div>
      </el-container>
    </div>
</template>

<script>
    export default {
        data(){
            return{
            name:"",
            hotJob:["室内设计","服务员","服务员","硬件工程师","售前客服","网络销售","物流跟单","物流","知识产权律师",],
                jobType1:["Java","PHP","前端开发","算法工程师",],
                jobType2:["经理","总监","数据分析","数据挖掘",],
                jobType3:["UI设计","平面设计","交互设计师","架构设计",],
                jobType4:["产品运营","网络推广","新媒体运营","网络运营",],
                jobType5:["市场营销","市场推广","品牌公关","策划经理",],
                jobType6:["行政主管","人力专员","HR助理","HR主管",],
                jobType7:["CEO","CTO","执行总裁","副总经理",],

          }
        },
        methods:{
            searchType(type1){
                this.name = type1;
                console.log(this.name);
                this.$http.get("http://localhost:8080/Api/index/Search?content="+this.name).then(function (response) {
                    console.log(response.data);
                }).catch(function (err) {
                    console.log(err);
                });
            },
            goJob(){
                this.$router.push({path:'/job'})
            },
        },
        mounted() {

        },
    }
</script>

<style scoped>
@import "../../../assets/css/index_components/SearchJobByType.css";
</style>
