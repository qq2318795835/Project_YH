<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="main-body">
          <!--添加Sales按钮-->
          <div class="addButton">
            <el-button type="success" @click="dialogFormVisible = true">添加</el-button>
            <!--添加Sales模态框-->
            <div>
              <el-dialog title="添加销售单" :visible.sync="dialogFormVisible" @close="resetForm('addSalesform')">
                <el-form key="addSales" :model="addSalesform" ref="addSalesform" style="width: 670px">
                  <el-form-item class="form-item" label="商品名称" prop="goodsid" :label-width="formLabelWidth">
                    <el-select class="form-item-input" filterable v-model="addSalesform.goodsid" placeholder="请选择">
                      <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value">

                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item class="form-item2" label="客户" prop="customerid" :label-width="formLabelWidth">
                    <el-select class="form-item-input" filterable v-model="addSalesform.customerid" placeholder="请选择">
                      <el-option style="height: auto" v-for="(value, key) in customerName" :key="key" :value="value">

                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item class="form-item"  label="发货数量/箱" prop="number" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addSalesform.number" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item2" label="发货价格/元" prop="saleprice" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addSalesform.saleprice" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item" label="商品重量/kg" prop="totalweight" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addSalesform.totalweight" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item2" label="出库名称" prop="sid" :label-width="formLabelWidth">
                    <el-select class="form-item-input" filterable v-model="addSalesform.sid" placeholder="请选择">
                      <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value">

                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item class="form-item" label="支付类型" prop="description" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addSalesform.paytype" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item2" label="操作人员" prop="operateperson" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addSalesform.operateperson" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item  label="发货时间" prop="salestime" :label-width="formLabelWidth">
                    <el-date-picker
                      v-model="addSalesform.salestime"
                      type="date"
                      placeholder="选择日期">
                    </el-date-picker>
                  </el-form-item>
                  <el-form-item label="备注" prop="remark" :label-width="formLabelWidth">
                    <el-input
                      type="textarea"
                      rows="3"
                      :autosize="{ minRows: 1, maxRows: 3}"
                      placeholder="请输入内容"
                      v-model="addSalesform.remark"
                    >
                    </el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="resetForm('addSalesform')">重 置</el-button>
                  <el-button type="primary" @click="addSales">提 交</el-button>
                </div>
              </el-dialog>
            </div>
          </div>
          <!--商品选择查询-->
          <div class="goodsSelect">
            <el-select class="form-item-input" filterable v-model="gname"  placeholder="请选择商品">
              <el-option @click.native="getSalesList" value="">所有销售单</el-option>
              <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value" @click.native="getSalesByGid(key)">

              </el-option>
            </el-select>
          </div>
          <!--客户选择查询-->
          <div class="customerSelect">
            <el-select class="form-item-input" filterable v-model="cname"  placeholder="请选择客户">
              <el-option @click.native="getSalesList" value="">所有客户</el-option>
              <el-option style="height: auto" v-for="(value, key) in customerName" :key="key" :value="value" @click.native="getSalesByCid(key)">

              </el-option>
            </el-select>
          </div>
          <!--仓库选择查询-->
          <div class="houseSelect">
            <el-select class="form-item-input" filterable v-model="sname"  placeholder="请选择仓库">
              <el-option @click.native="getSalesList" value="">所有进货</el-option>
              <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value" @click.native="getSalesBySid(key)">

              </el-option>
            </el-select>
          </div>
          <!--日期选择查询-->
          <div class="dateSelect">
            <el-date-picker
              v-model="sdate"
              format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"
              @change="getSalesByDate"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </div>
        <el-card class="card-table-body">
          <!--Sales列表-->
          <el-table
            :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
            border
            height="477"
            tooltip-effect="light"
            style="width: 100%;font-size: 16px;"
            size="small">
            <el-table-column
              prop="ssid"
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
              label="商品数量"
              width="90"
            >
            </el-table-column>
            <el-table-column
              prop="saleprice"
              label="商品价格"
              width="90"
              show-overflow-tooltip
            >

            </el-table-column>
            <el-table-column
              prop="totalweight"
              label="总重量/kg"
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
              prop="salestime"
              label="出货日期"
              width="125"
              :formatter="formatterTime"
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
              prop="sname"
              label="存放地址"
              width="110"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop="operateperson"
              label="入库审核"
              width="100"
              show-overflow-tooltip
            >
            </el-table-column>
            <el-table-column
              prop=""
              label="操作"
            >
              <!--表格中的操作-->
              <template slot-scope="scope">
                <el-button class="operate-button-1" type="danger" size="small" @click="delMessage(scope.row.ssid)">删除</el-button>

                <el-button class="operate-button-1" type="info" size="small" @click="updateSales_getSales(scope.row.ssid)" >修改</el-button>
                <!--修改Sales模态框-->
                <el-dialog title="修改进货" :visible.sync="dialogFormVisible2" style="margin-top: -100px">

                  <el-form key="updateSales" :model="updateSalesForm" ref="updateSalesForm" style="width: 670px">
                    <el-form-item class="form-item" label="商品名称" prop="goodsid" :label-width="formLabelWidth">
                      <el-select class="form-item-input" filterable v-model="updateSalesForm.goodsid" placeholder="请选择">
                        <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value">

                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item class="form-item2" label="客户" prop="customerid" :label-width="formLabelWidth">
                      <el-select class="form-item-input" filterable v-model="updateSalesForm.customerid" placeholder="请选择">
                        <el-option style="height: auto" v-for="(value, key) in customerName" :key="key" :value="value">

                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item class="form-item"  label="销售数量/箱" prop="number" :label-width="formLabelWidth">
                      <el-input class="form-item-input" type="text" v-model="updateSalesForm.number" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item class="form-item2" label="销售价格/元" prop="saleprice" :label-width="formLabelWidth">
                      <el-input class="form-item-input" type="text" v-model="updateSalesForm.saleprice" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item class="form-item" label="商品重量/kg" prop="totalweight" :label-width="formLabelWidth">
                      <el-input class="form-item-input" type="text" v-model="updateSalesForm.totalweight" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item class="form-item2" label="入库名称" prop="sid" :label-width="formLabelWidth">
                      <el-select class="form-item-input" filterable v-model="updateSalesForm.sid" placeholder="请选择">
                        <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value">

                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item class="form-item" label="支付类型" prop="paytype" :label-width="formLabelWidth">
                      <el-input class="form-item-input" type="text" v-model="updateSalesForm.paytype" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item class="form-item2" label="操作人员" prop="operateperson" :label-width="formLabelWidth">
                      <el-input class="form-item-input" type="text" v-model="updateSalesForm.operateperson" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item  label="入库时间" prop="salestime" :label-width="formLabelWidth">
                      <el-date-picker
                        v-model="updateSalesForm.salestime"
                        format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd"
                        type="date"
                        placeholder="选择日期">
                      </el-date-picker>
                    </el-form-item>
                    <el-form-item class="form-item2" label="退货备注" prop="salebackinfo" :label-width="formLabelWidth">
                      <el-input class="form-item-input" type="text" v-model="updateSalesForm.salebackinfo" placeholder="暂无" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="备注" prop="remark" :label-width="formLabelWidth">
                      <el-input
                        type="textarea"
                        rows="3"
                        :autosize="{ minRows: 1, maxRows: 3}"
                        placeholder="请输入内容"
                        v-model="updateSalesForm.remark"
                      >
                      </el-input>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer" style="margin-top: -50px;">
                    <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                    <el-button type="warning" @click="updateSales_updateSales(updateSalesForm.ssid)">提交</el-button>
                  </div>
                </el-dialog>

                <el-button class="operate-button-1" type="primary" size="small" @click="salesBack_getSales(scope.row.ssid)" >退货</el-button>
                <!--退货模态框-->
                <el-dialog title="退货" :visible.sync="dialogFormVisible3" @close="resetForm('salesBackForm')">
                  <el-form key="SalesBack" :model="salesBackForm" ref="salesBackForm">
                    <el-form-item label="退货数量/箱" prop="number" :label-width="formLabelWidth">
                      <el-input style="width: 300px" v-model="salesBackForm.number" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="退货重量/kg" prop="totalweight" :label-width="formLabelWidth">
                      <el-input style="width: 300px" v-model="salesBackForm.totalweight" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item  label="退货时间" prop="salesbacktime" :label-width="formLabelWidth">
                      <el-date-picker
                        v-model="salesBackForm.salesbacktime"
                        format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd"
                        type="date"
                        placeholder="选择日期">
                      </el-date-picker>
                    </el-form-item>
                    <el-form-item class="form-item2" label="入库名称" prop="sid" :label-width="formLabelWidth">
                      <el-select class="form-item-input" filterable v-model="salesBackForm.sid" placeholder="请选择">
                        <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value">

                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item style="width: 720px;" label="退货说明" prop="remark" :label-width="formLabelWidth">
                      <el-input
                        type="textarea"
                        rows="3"
                        :autosize="{ minRows: 1, maxRows: 3}"
                        placeholder="请输入内容"
                        v-model="salesBackForm.remark"
                      >
                      </el-input>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible3 = false">取 消</el-button>
                    <el-button type="primary" @click="SalesBack(updateSalesForm.ssid)">提交</el-button>
                  </div>
                </el-dialog>

              </template>
            </el-table-column>
          </el-table>
          <!--分页-->
          <div class="pagination">
            <el-pagination
              class="pagination-body"
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pagination.pageNum"
              :page-sizes="[9, 18, 27, 36]"
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
        name: "commoditySaleManage",
        components: {breadcrumb,},

        data() {
            return {
                SalesList:null,
                SaleskOne:null,
                status: 0,
                sbid:0,
                dialogFormVisible: false,
                dialogFormVisible2: false,
                dialogFormVisible3: false,
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
                    pageSize: 9
                },
                //添加Goods输入框宽度
                formLabelWidth: '120px',
                addSalesform: {
                    customerid: '',
                    goodsid: '',
                    number: '',
                    operateperson: '',
                    paytype: '',
                    remark: '',
                    salebackinfo: '',
                    saleprice: '',
                    salestime: '',
                    sid: '',
                    totalweight: '',
                },
                updateSalesForm: {
                    customerid: '',
                    goodsid: '',
                    number: '',
                    operateperson: '',
                    paytype: '',
                    remark: '',
                    salebackinfo: '',
                    saleprice: '',
                    salestime: '',
                    sid: '',
                    totalweight: '',
                    gname: '',
                    cname: '',
                    sname: '',
                },
                salesBackForm: {
                    customerid: '',
                    goodsid: '',
                    number: '',
                    operateperson: '',
                    paytype: '',
                    remark: '',
                    salebackprice: '',
                    salesbacktime: '',
                    sid: '',
                    totalweight: '',
                    ssid:'',
                },
            }
        },
        methods: {
            //getSalesList
            getSalesList() {
                this.$axios({
                    method: "get",
                    url: '/Sales/findAllSales2',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.SalesList = response.data.data
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.tableData.length
                    } else {
                        return this.$message.error('查询销售列表失败')
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
            //重置添加Sales表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //添加Sales
            addSales(){
                let _this = this;
                let addSalesform = {
                    paytype: _this.addSalesform.paytype,
                    operateperson : _this.addSalesform.operateperson,
                    goodsid: this.getByValue(this.goodsName,_this.addSalesform.goodsid),
                    saleprice: _this.addSalesform.saleprice,
                    number: _this.addSalesform.number,
                    customerid: this.getByValue(this.customerName,_this.addSalesform.customerid),
                    remark: _this.addSalesform.remark,
                    salestime: _this.addSalesform.salestime,
                    totalweight: _this.addSalesform.totalweight,
                    sid: this.getByValue(this.houseName,_this.addSalesform.sid),
                    salebackinfo: _this.addSalesform.salebackinfo,
                }
                // console.log(addSalesBackform)
                this.$axios({
                    method: "post",
                    url: '/Sales/addSales',
                    data: addSalesform,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getSalesList()
                        this.dialogFormVisible = false
                        return this.$message.success('添加成功')
                    } else if(response.data.code === -2) {
                        return this.$message.error('商品余量不足！！！')
                    } else if (response.data.code === -3){
                        return this.$message.error('商品不存在！！！')
                    }
                    return  this.$message.error('添加失败！！！')
                    _this.dialogFormVisible = false;
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //商品nameList
            getGoodsName(){
                this.$axios({
                    method: "get",
                    url: '/Sales/goodsName',
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
            //客户nameList
            getCustomerName(){
                this.$axios({
                    method: "get",
                    url: '/Sales/customerName',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.customerName = response.data.data
                        // console.log(this.customerName)
                    } else {
                        return this.$message.error('查询客户name失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            getHouseName(){
                this.$axios({
                    method: "get",
                    url: '/Sales/houseName',
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
            getSalesByGid(gid){
                this.$axios({
                    method: "get",
                    url: '/Sales/findSalesByGid',
                    params:{
                        gid:gid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.SalesList = response.data.data
                        // console.log(this.SalesList)
                        this.tableData = response.data.data
                        this.pagination.total = this.SalesList.length
                    } else {
                        return this.$message.error('获取销售列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //客户选择查询
            getSalesByCid(cid){
                this.$axios({
                    method: "get",
                    url: '/Sales/findSalesByCid',
                    params:{
                        cid:cid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.SalesList = response.data.data
                        // console.log(this.SalesList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.SalesList.length
                    } else {
                        return this.$message.error('获取销售列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            getSalesBySid(sid){
                this.$axios({
                    method: "get",
                    url: '/Sales/findSalesBySid',
                    params:{
                        sid:sid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.SalesList = response.data.data
                        // console.log(this.SalesList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.SalesList.length
                    } else {
                        return this.$message.error('获取进货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //日期查询Sales
            getSalesByDate(val){
                let salestime = val
                if(salestime!=null){
                    // console.log(salestime)
                    this.$axios({
                        method: "get",
                        url: '/Sales/findSalesByDate',
                        params:{
                            salestime:salestime
                        }
                    }).then((response) => {
                        this.status = response.data.code
                        if (this.status === 1) {
                            // console.log(response.data)
                            this.SalesList = response.data.data
                            // console.log(this.SalesList)
                            this.tableData = response.data.data
                            // console.log(this.tableData)
                            this.pagination.total = this.SalesList.length
                        } else {
                            return this.$message.error('获取进货列表失败')
                        }
                    }).catch(function (error) {
                        console.log(error)
                    });
                }
                else if (salestime == null){
                    this.getInportsList()
                }
            },
            //删除Sales
            async delMessage(ssid) {
                let _this = this
                // console.log(ssid)
                const confirmResult = await
                    this.$confirm('删除该信息,且不可恢复,是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).catch(error => error)

                if (confirmResult != 'confirm') {
                    return this.$message.info('已取消删除')
                }
                let da = {
                    ssid: ssid
                }
                //删除
                //这里的delete还是没有解决,只能用post代替
                this.$axios({
                    method: "post",
                    url: '/Sales/delSales',
                    data: _this.$qs.stringify(da)
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.getSalesList()
                        this.$message.success('删除成功')
                    } else {
                        return this.$message.error('删除失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //修改前得到Sales
            updateSales_getSales(ssid){
                // console.log(ssid)
                this.$axios.get('/Sales/getSales2', {
                    params: {
                        ssid: ssid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateSalesForm = response.data.data
                        // console.log(this.updateSalesForm)
                        //id换name
                        this.updateSalesForm.goodsid = this.goodsName[this.updateSalesForm.goodsid]
                        this.updateSalesForm.customerid = this.customerName[this.updateSalesForm.customerid]
                        this.updateSalesForm.sid = this.houseName[this.updateSalesForm.sid]
                    } else {
                        return this.$message.error('查询销售信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible2 = true
            },
            //修改Sales
            updateSales_updateSales(ssid){
                let _this = this;
                let updateSalesForm = {
                    paytype: _this.updateSalesForm.paytype,
                    operateperson : _this.updateSalesForm.operateperson,
                    goodsid: this.getByValue(this.goodsName,_this.updateSalesForm.goodsid),
                    saleprice: _this.updateSalesForm.saleprice,
                    number: _this.updateSalesForm.number,
                    customerid: this.getByValue(this.customerName,_this.updateSalesForm.customerid),
                    remark: _this.updateSalesForm.remark,
                    salestime: _this.updateSalesForm.salestime,
                    totalweight: _this.updateSalesForm.totalweight,
                    sid: this.getByValue(this.houseName,_this.updateSalesForm.sid),
                    salebackinfo: _this.updateSalesForm.salebackinfo
                }
                // console.log(updateSalesForm)
                this.$axios({
                    method: "put",
                    url: '/Sales/updateSales',
                    params: {ssid: ssid},
                    data: updateSalesForm,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getSalesList()
                        this.dialogFormVisible2 = false
                        return this.$message.success('更新成功')
                    }
                    return  this.$message.error('更新失败！！！')
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //退货前得到销售信息
            salesBack_getSales(ssid){
                this.$axios.get('/Sales/getSales2', {
                    params: {
                        ssid: ssid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateSalesForm = response.data.data
                        this.updateSalesForm.sid = this.houseName[this.updateSalesForm.sid]
                        // console.log(this.updateSalesForm)
                    } else {
                        return this.$message.error('查询进货信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible3 = true
            },
            //退货
            SalesBack(ssid){
                let _this = this
                let salesBackForm= {
                    paytype: _this.updateSalesForm.paytype,
                    customerid: _this.updateSalesForm.customerid,
                    salesbacktime: _this.salesBackForm.salesbacktime,
                    operateperson : _this.updateSalesForm.operateperson,
                    salebackprice: _this.updateSalesForm.saleprice,
                    number: _this.salesBackForm.number,
                    remark: _this.salesBackForm.remark,
                    goodsid: _this.updateSalesForm.goodsid,
                    sid: this.getByValue(this.houseName,_this.salesBackForm.sid),
                    totalweight: _this.salesBackForm.totalweight,
                    ssid:ssid,
                }
                // console.log(salesBackForm)
                this.$axios({
                    method: "post",
                    url: '/SalesBack/addSalesBack',
                    data: salesBackForm,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.dialogFormVisible3 = false
                        return this.$notify({
                            title: '添加退货成功',
                            message: '请到退货管理查看！',
                            type: 'success'
                        });
                    }else if (response.data.code === -2){
                        return this.$message.error('仓库余量不足，请选择其他仓库！！！')
                    }
                    return  this.$message.error('添加失败！！！')
                }).catch(function (error) {
                    console.log(error)
                });
            },
        },
        mounted() {
            this.getSalesList()
            this.getGoodsName()
            this.getCustomerName()
            this.getHouseName()
        }
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
  .addButton{
    margin-left: 20px;
    margin-top: 10px;
    width: 71px;
  }
  .goodsSelect{
    margin-left: 150px;
    margin-top: -40px;
  }
  .customerSelect{
    margin-left: 430px;
    margin-top: -40px;
  }
  .houseSelect{
    margin-left: 710px;
    margin-top: -40px;
  }
  .dateSelect{
    margin-left: 990px;
    margin-top: -40px;
  }
  .form-item{
    width: 350px;
  }
  .form-item-input{
    width: 220px;
  }
  .form-item2{
    width: 350px;
    margin-top: -62px;
    float: right;
  }
  .card-table-body{
    border: none;
    /*margin-top: 80px;*/
    margin-top: 15px;
  }
  .pagination{
    /*border: 1px solid red;*/
  }
  .pagination-body{
    text-align: center;
    width: 500px;
    margin-left: 330px;
    margin-top: 6px;
    /*margin-top: 125px;*/
    margin-bottom: 5px;
  }
  .operate-button-1{
    margin-left: 10px;
    /*width: 60px;*/
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
