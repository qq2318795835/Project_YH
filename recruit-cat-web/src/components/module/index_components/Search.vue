<template>
  <div class="search" >
    <el-form :model="SearchForm" ref="SearchForm" class="search" @keyup.enter.native="submitForm('SearchForm.contents'),goJob()">
        <el-form-item class="search-input">
          <el-input type="text" v-model="SearchForm.contents" placeholder="搜索职位公司"></el-input>
        </el-form-item>
        <el-form-item class="search-button">
          <el-button type="info" @click="submitForm('SearchForm.contents'),goJob()"  class="search-button-button">搜索</el-button>
        </el-form-item>
    </el-form>

  </div>
</template>

<script>
    export default {
        name: "Search",
        data() {
            return {
                SearchForm: {
                    contents: ''
                }
            };
        },
        methods:{
            submitForm(){
                console.log(this.SearchForm.contents);
                this.$http.get("http://localhost:8080/Api/index/Search?content="+this.SearchForm.contents).then(function (response) {
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
@import "../../../assets/css/index_components/Search.css";
</style>
