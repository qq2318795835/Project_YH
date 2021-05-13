<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="main-body">
          <!--商品选择查询-->
          <div class="goodsSelect">
            <el-select class="form-item-input" clearable filterable v-model="gname"  placeholder="请选择商品">
              <el-option @click.native="getOutportsList" value="">所有进货</el-option>
              <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value" @click.native="getOutportsByGid(key)">

              </el-option>
            </el-select>
          </div>
          <!--供应商选择查询-->
          <div class="providerSelect">
            <el-select class="form-item-input" clearable filterable v-model="pname"  placeholder="请选择供应商">
              <el-option @click.native="getOutportsList" value="">所有供应商</el-option>
              <el-option style="height: auto" v-for="(value, key) in providerName" :key="key" :value="value" @click.native="getOutportsByPid(key)">

              </el-option>
            </el-select>
          </div>
          <!--仓库选择查询-->
          <div class="houseSelect">
            <el-select class="form-item-input" clearable filterable v-model="sname"  placeholder="请选择仓库">
              <el-option @click.native="getOutportsList" value="">所有进货</el-option>
              <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value" @click.native="getOutportsBySid(key)">

              </el-option>
            </el-select>
          </div>
          <!--日期选择查询-->
          <div class="dateSelect">
            <el-date-picker
              v-model="sdate"
              format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"
              @change="getOutportsByDate"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </div>

        <el-card class="card-table-body">
          <!--Outports列表-->
          <el-table
            :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
            border
            height="480"
            tooltip-effect="light"
            style="width: 100%;font-size: 16px;"
            size="small">
            <el-table-column
              prop="oid"
              label="ID"
              width="60"
            >
            </el-table-column>
            <el-table-column
              prop="gname"
              label="商品名称"
              width="150"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="number"
              label="退货数量"
              width="90"
            >
            </el-table-column>
            <el-table-column
              prop="totalweight"
              label="退货重量/kg"
              width="120"
              show-overflow-tooltip
            >

            </el-table-column>
            <el-table-column
              prop="outportprice"
              label="退货价格"
              width="100"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="paytype"
              label="支付方式"
              width="90"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="pname"
              label="供应商"
              width="125"

            >
            </el-table-column>
            <el-table-column
              prop="outputtime"
              label="退货日期"
              width="125"
              show-overflow-tooltip
              :formatter="formatterTime"
            >
            </el-table-column>
            <el-table-column
              prop="sname"
              label="存放地址"
              width="110"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="operateperson"
              label="入库审核"
              width="120"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="iid"
              label="进货ID"
              width="80"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="remark"
              label="备注"
              show-overflow-tooltip
            >
            </el-table-column>
          </el-table>
          <!--分页-->
          <div class="pagination">
            <el-pagination
              class="pagination-body"
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pagination.pageNum"
              :page-sizes="[11, 22, 33, 44]"
              :page-size="pagination.pageSize"
              layout="total, prev, pager, next, jumper"
              :total="pagination.total"
              ref="pagination"
            >
            </el-pagination>
          </div>
        </el-card>
      </el-card>
    </div>
    <div class="footer">
      <div class="footer-title">CopyRight-DataSupermacy-Y @2021</div>
    </div>
  </div>
</template>

<script>
    import breadcrumb from "../../components/system/breadcrumb";
    export default {
        name: "returnManage",
        components: {breadcrumb,},

        data(){
            return {
                OutportList:null,
                status: 0,
                tableData: [],
                goodsName:[],
                gname:'',
                providerName: [],
                pname:'',
                houseName:[],
                sname:'',
                sdate:'',
                pagination: {
                    total: 0,
                    pageNum: 1,
                    currenPage: 1,
                    pageSize: 11
                },
            }
        },
        methods:{
            //OutportsList
            getOutportsList() {
                this.$axios({
                    method: "get",
                    url: '/Outports/findAllOutports2',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.OutportList = response.data.data
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.tableData.length
                    } else {
                        return this.$message.error('查询进货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //表格中时间只显示年月日
            formatterTime(row,column){
                let data = row[column.property]
                return  /\d{4}-\d{1,2}-\d{1,2}/g.exec(data )
            },
            //分页:pageSize改变
            handleSizeChange(newSize) {
                this.pagination.pageSize = newSize
                // this.getDepartmentList()
            },
            //分页:pageNum改变
            handleCurrentChange(newPage) {
                this.pagination.pageNum = newPage
                // this.getDepartmentList()
            },
            //商品nameList
            getGoodsName(){
                this.$axios({
                    method: "get",
                    url: '/Outports/goodsName',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.goodsName = response.data.data
                        // console.log(this.goodsName)
                    } else {
                        return this.$message.error('查询商品name失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //供应商nameList
            getProviderName(){
                this.$axios({
                    method: "get",
                    url: '/Outports/providerName',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.providerName = response.data.data
                        // console.log(this.providerName)
                        // console.log(this.getByValue(this.providerName,'娃哈哈集团'))
                    } else {
                        return this.$message.error('查询供应商name失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            getHouseName(){
                this.$axios({
                    method: "get",
                    url: '/Outports/houseName',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.houseName = response.data.data
                        // console.log(this.houseName)
                    } else {
                        return this.$message.error('查询仓库name失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //值寻键
            getByValue(map, searchValue) {
                for (var key in map) {
                    if (map[key] == searchValue)
                        return key;
                }
            },
            //商品选择查询
            getOutportsByGid(gid){
                this.$axios({
                    method: "post",
                    url: '/Outports/findOutportsByGid',
                    params:{
                        gid:gid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.OutportList = response.data.data
                        // console.log(this.OutportList)
                        this.tableData = response.data.data
                        this.pagination.total = this.OutportList.length
                    } else {
                        return this.$message.error('获取退货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //供应商选择查询
            getOutportsByPid(pid){
                this.$axios({
                    method: "post",
                    url: '/Outports/findOutportsByPid',
                    params:{
                        pid:pid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.OutportList = response.data.data
                        // console.log(this.OutportList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.OutportList.length
                    } else {
                        return this.$message.error('获取退货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //仓库查询
            getOutportsBySid(sid){
                this.$axios({
                    method: "post",
                    url: '/Outports/findOutportsBySid',
                    params:{
                        sid:sid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.OutportList = response.data.data
                        // console.log(this.OutportList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.OutportList.length
                    } else {
                        return this.$message.error('获取退货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //日期查询
            getOutportsByDate(val){
                let outputtime = val
                if(outputtime!=null){
                    // console.log(outputtime)
                    this.$axios({
                        method: "post",
                        url: '/Outports/findOutportsByDate',
                        params:{
                            outputtime:outputtime
                        }
                    }).then((response) => {
                        this.status = response.data.code
                        if (this.status === 1) {
                            // console.log(response.data)
                            this.OutportList = response.data.data
                            // console.log(this.OutportList)
                            this.tableData = response.data.data
                            // console.log(this.tableData)
                            this.pagination.total = this.OutportList.length
                        } else {
                            return this.$message.error('获取退货列表失败')
                        }
                    }).catch(function (error) {
                        console.log(error)
                    });
                }
                else if (outputtime == null){
                    this.getOutportsList()
                }
            },
        },
        mounted(){
            this.getOutportsList()
            this.getGoodsName()
            this.getProviderName()
            this.getHouseName()
        },
    }
</script>

<style>


</style>

<style scoped>
  >>>.el-card__body {
    padding: 0px;
  }
  /*讨厌的element样式使得修改商品供应商选择器margin-bottom为-17px,样式覆盖，多加17*/
  >>>.el-select-dropdown__list{
    margin-bottom: 17px;
  }
  /*商品供应商选择器太长，可能与侧边栏有关，样式形变*/
  .el-scrollbar {
    height: auto;
  }
  .body{
    margin-left: 214px;
    margin-right: -8px;
    margin-top: -181px;
  }
  .main-body{

  }
  .card-body{
    border: none;
  }
  .goodsSelect{
    width: 220px;
    float: left;
    margin-top: 10px;
    margin-right: 80px;
    margin-left: 50px;
  }
  .providerSelect{
    width: 220px;
    float: left;
    margin-top: 10px;
    margin-right: 80px;
  }
  .houseSelect{
    width: 220px;
    float: left;
    margin-top: 10px;
    margin-right: 80px;
  }
  .dateSelect{
    width: 220px;
    float: left;
    margin-top: 10px;
  }
  .form-item-input{
    width: 220px;
  }
  .card-table-body{
    border: none;
    /*margin-top: 80px;*/
    margin-top: 63px;
  }
  .pagination{
    /*border: 1px solid red;*/
  }
  .pagination-body{
    text-align: center;
    width: 500px;
    margin-left: 330px;
    margin-top: 5px;
    /*margin-top: 125px;*/
    margin-bottom: 5px;
  }
  .footer{
    height: 55px;
    text-align: center;
    margin-left: 210px;
    margin-right: -8px;
    background-color: #545c64;
    color: #fff;
  }
  .footer-title{
    line-height: 55px;
    margin-right: 40px;
  }
</style>
