<template>
    <div id="jobPage" class="job-card">
      <el-card shadow="hover" class="box-card" v-for="job in jobData" :key="job.jid " >
        <div class="m4-card1-con">
          <div class="m4-card1-con1">
            <div class="m4-card1-con1-1">
              {{job.jname}}
            </div>
            <div class="m4-card1-con1-2">
              {{job.jsal}}
            </div>
          </div>
          <div class="m4-card1-con2">
            <div class="m4-card1-con2-1">
              {{job.jaddress.substring(0,2)}}
              <span class="m4-card1-con2-1-v"></span>
              {{job.jexperience}}
              <span class="m4-card1-con2-1-v"></span>
              {{job.jeducation}}
            </div>
            <div class="m4-card1-talk">
              <el-button size="mini" type="info" class="m4-card1-talk-button">
                <span class="el-icon-chat-dot-round"></span>
                <span class="m4-card1-talk-body">立即沟通</span>
              </el-button>
            </div>
          </div>
        </div>
        <div class="m4-card1-con-time">
          <span class="m4-card1-con-time-b">发布于：{{job.jupdateTime}}</span>
        </div>
        <div class="m4-card1-body2">
          <div class="m4-card1-body2-line3">
            <img src="../../../assets/images/band/band1.jpg" width="55" height="56">
          </div>
          <div class="m4-card1-body2-line1" v-if="corpData['a'+job.jid]">
            {{corpData['a'+job.jid].cname}}
          </div>
          <div class="m4-card1-body2-line2">
            {{corpData['a'+job.jid].ctype}}
            <span class="m4-card1-body2-line1-v1"></span>
            {{corpData['a'+job.jid].cbusiness_status}}
            <span class="m4-card1-body2-line1-v1"></span>
            {{corpData['a'+job.jid].cscale}}
          </div>
        </div>
      </el-card>
      <el-pagination class="page1"
                     layout="prev,pager,next,sizes,total"
                     background :total="pagination.total"
                     :current-page="pagination.pageNum"
                     :page-size="pagination.pageSize"
                     :page-sizes="pagination.pageSizes"
                     v-on:current-change="currentChange"
                     @size-change="sizeChange">
      </el-pagination>
      <div class="back-top">
        <el-backtop class="back-top-icon">
        </el-backtop>
      </div>
    </div>
</template>

<script>
    export default {
        name: "jobCard",
        data(){
            return{
                jobData:null,
                corpData:{},
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
                this.getJobData();
            },

            sizeChange:function(v){
                this.pagination.pageSize=v;
                this.getJobData();
            },
            getJobData: function () {
                let _this = this;
                this.$http.get("http://localhost:8080/Api/Job/",{
                    params: {
                        pageNum: this.pagination.pageNum,
                        pageSize: this.pagination.pageSize,
                        }
                    })
                    .then(async function(response) {
                            console.log(response.data.data);
                            // console.log(JSON.stringify(response));
                            let page = response.data.data;
                            _this.jobData = response.data.data.content;
                            _this.pagination.total = page.totalElements;
                            _this.pagination.pageCount = page.totalPages;

                            const cid = response.data.data.content[0].cid;
                            console.log(response.data.data.content[0].cid);
                            let corpData = {};
                            let jobs = response.data.data.content;
                            for(let i=0;i<jobs.length;i++){
                               await _this.getCorpData(jobs[i].cid,jobs[i].jid);
                            }


                        }).catch(function (err) {
                            console.log(err)
                        });
            },
            getCorpData:async function (cid,jid) {
                let _this = this;
                await this.$http.get('http://localhost:8080/Api/Corp/CropDetail', {
                    params: {
                        Cid: cid,
                }
                })
                    .then(function (response) {
                        _this.corpData['a'+jid]=response.data.data;
                        console.log(response.data.data);
                    })
                    .catch(function (err) {
                        console.log(err);
                    });
            }
        },
        mounted() {
            this.getJobData();
            // this.getCorpData();
        }

    }
</script>

<style scoped>
@import "../../../assets/css/job_components/jobCard.css";
</style>
