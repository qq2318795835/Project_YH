<template>
    <div class="m5-body">
      <div class="card-round">
          <el-card shadow="hover" class="m5-card1" v-for="corp in corpData" :key="corp.cid ">
            <div class="main5-card1-body">
              <div class="main5-card1-body-line1">
                123
              </div>
              <div class="main5-card1-body-line2">
                {{corp.cname}}
              </div>
              <div class="main5-card1-body-line3">
                {{corp.ctype}}
                <span class="m4-card1-con2-1-v"></span>
                {{corp.cbusiness_status}}
              </div>
              <div class="main5-card1-body-line4">
                <el-button plain class="main5-card1-body-line4-button">
                  {{corp.crecruitmentStatus}}
                </el-button>
              </div>
            </div>
          </el-card>
      </div>
      <el-pagination class="page1"
                     layout="prev,pager,next,sizes,total"
                     background :total="pagination.total"
                     :current-page="pagination.pageNum"
                     :page-size="pagination.pageSize"
                     :page-sizes="pagination.pageSizes"
                     v-on:current-change="currentChange"
                     @size-change="sizeChange">

      </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "corpCard",
        data(){
            return{
                corpData:null,
                pagination:{
                    pageNum:1,
                    pageSize:8,
                    total:24,
                    pageCount:3,
                    pageSizes:[8,16,24]
                }
            }
        },
        methods:{
            currentChange:function (v) {
                // console.log(v);
                this.pagination.pageNum=v;
                this.getCorpData();
            },

            sizeChange:function(v){
                this.pagination.pageSize=v;
                this.getCorpData();
            },
            getCorpData: function () {
                let _this = this;
                this.$http.get("http://localhost:8080/Api/Corp/",{
                    params: {
                        pageNum: this.pagination.pageNum,
                        pageSize: this.pagination.pageSize,
                    }
                })
                    .then(function(response){
                        console.log(response.data.data);
                        let page = response.data.data;
                        _this.corpData = response.data.data.content;
                        _this.pagination.total = page.totalElements;
                        _this.pagination.pageCount = page.totalPages;
                    })
                    .catch(function (err){
                        console.log(err)
                    });
            }
        },

        mounted() {
            // this.getCorpData();
        }

    }
</script>

<style scoped>
  @import "../../../assets/css/corp_components/corpCard.css";
</style>
<style>
  .el-pagination.is-background .el-pager li:not(.disabled).active {
    background-color: #909399;
    color: #FFF;
  }
  .el-pagination.is-background .el-pager li.active {
    color: #fff;
    cursor: default;
  }
  .el-pagination.is-background .el-pager li:hover {
    color: #ffd04b;
  }
  .el-pagination.is-background .el-pager li:not(.disabled):hover {
    color: #ffd04b;
  }
  .el-pagination.is-background .el-pager li:not(.disabled).active:hover {
    background-color: #909399;
    color: #FFF;
  }
</style>
