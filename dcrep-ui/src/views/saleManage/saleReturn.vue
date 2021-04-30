<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="main-body">
          <!--商品选择查询-->
          <div class="goodsSelect">
            <el-select class="form-item-input" clearable filterable v-model="gname"  placeholder="请选择商品">
              <el-option @click.native="getSalesBackList" value="">所有进货</el-option>
              <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value" @click.native="getSalesBackByGid(key)">

              </el-option>
            </el-select>
          </div>
          <!--客户选择查询-->
          <div class="customerSelect">
            <el-select class="form-item-input" clearable filterable v-model="cname"  placeholder="请选择供应商">
              <el-option @click.native="getSalesBackList" value="">所有供应商</el-option>
              <el-option style="height: auto" v-for="(value, key) in customerName" :key="key" :value="value" @click.native="getSalesBackByCid(key)">

              </el-option>
            </el-select>
          </div>
          <!--仓库选择查询-->
          <div class="houseSelect">
            <el-select class="form-item-input" clearable filterable v-model="sname"  placeholder="请选择仓库">
              <el-option @click.native="getSalesBackList" value="">所有进货</el-option>
              <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value" @click.native="getSalesBackBySid(key)">

              </el-option>
            </el-select>
          </div>
          <!--日期选择查询-->
          <div class="dateSelect">
            <el-date-picker
              v-model="sdate"
              format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"
              @change="getSalesBackByDate"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </div>
        <el-card class="card-table-body">
          <!--SalesBack列表-->
          <el-table
            :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
            border
            height="480"
            tooltip-effect="light"
            style="width: 100%;font-size: 16px;"
            size="small">
            <el-table-column
              prop="sbid"
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
              prop="salebackprice"
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
              prop="cname"
              label="客户"
              width="125"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="salesbacktime"
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
              prop="ssid"
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
        name: "saleReturn",
        components: {breadcrumb,},

        data() {
            return {
                SaleBackList:null,
                status: 0,
                tableData: [],
                goodsName:[],
                gname:'',
                customerName: [],
                cname:'',
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
        methods: {
            //SaleBackList
            getSalesBackList() {
                this.$axios({
                    method: "get",
                    url: '/SalesBack/findAllSalesBack2',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.SaleBackList = response.data.data
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.tableData.length
                    } else {
                        return this.$message.error('查询销售退货列表失败')
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
                    url: '/SalesBack/goodsName',
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
            getCustomerName(){
                this.$axios({
                    method: "get",
                    url: '/SalesBack/customerName',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.customerName = response.data.data
                        // console.log(this.customerName)
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
                    url: '/SalesBack/houseName',
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
            getSalesBackByGid(gid){
                this.$axios({
                    method: "post",
                    url: '/SalesBack/findSalesBackByGid',
                    params:{
                        gid:gid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.SaleBackList = response.data.data
                        // console.log(this.SaleBackList)
                        this.tableData = response.data.data
                        this.pagination.total = this.SaleBackList.length
                    } else {
                        return this.$message.error('获取退货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //供应商选择查询
            getSalesBackByCid(cid){
                this.$axios({
                    method: "post",
                    url: '/SalesBack/findSalesBackByCid',
                    params:{
                        cid:cid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.SaleBackList = response.data.data
                        // console.log(this.SaleBackList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.SaleBackList.length
                    } else {
                        return this.$message.error('获取退货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //仓库查询
            getSalesBackBySid(sid){
                this.$axios({
                    method: "post",
                    url: '/SalesBack/findSalesBackBySid',
                    params:{
                        sid:sid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.SaleBackList = response.data.data
                        // console.log(this.SaleBackList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.SaleBackList.length
                    } else {
                        return this.$message.error('获取退货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //日期查询
            getSalesBackByDate(val){
                let salesbacktime = val
                if(salesbacktime!=null){
                    // console.log(salesbacktime)
                    this.$axios({
                        method: "post",
                        url: '/SalesBack/findSalesBackByDate',
                        params:{
                            salesbacktime:salesbacktime
                        }
                    }).then((response) => {
                        this.status = response.data.code
                        if (this.status === 1) {
                            // console.log(response.data)
                            this.SaleBackList = response.data.data
                            // console.log(this.SaleBackList)
                            this.tableData = response.data.data
                            // console.log(this.tableData)
                            this.pagination.total = this.SaleBackList.length
                        } else {
                            return this.$message.error('获取退货列表失败')
                        }
                    }).catch(function (error) {
                        console.log(error)
                    });
                }
                else if (salesbacktime == null){
                    this.getSalesBackList()
                }
            },
        },
        mounted() {
            this.getSalesBackList()
            this.getGoodsName()
            this.getCustomerName()
            this.getHouseName()
        }
    }
</script>

<style>
  .el-card__body {
    padding: 0px;
  }
  /*讨厌的element样式使得修改商品供应商选择器margin-bottom为-17px,样式覆盖，多加17*/
  .el-select-dropdown__list{
    margin-bottom: 17px;
  }
</style>

<style scoped>
  .body{
    margin-left: 214px;
    margin-right: -8px;
    margin-top: -181px;
  }
  .card-body{
    border: none;
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
  .customerSelect{
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
