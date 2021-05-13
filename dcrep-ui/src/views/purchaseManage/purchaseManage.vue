<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="main-body">
          <!--添加Inports按钮-->
          <div class="addButton">
            <el-button type="success" @click="dialogFormVisible = true">添加</el-button>
            <!--添加Inports模态框-->
            <div>
              <el-dialog title="添加进货单" :visible.sync="dialogFormVisible" @close="resetForm('addInportsform')">
                <el-form key="addInports" :model="addInportsform" ref="addInportsform" style="width: 670px">
                  <el-form-item class="form-item" label="商品名称" prop="goodsid" :label-width="formLabelWidth">
                    <el-select class="form-item-input" filterable v-model="addInportsform.goodsid" placeholder="请选择">
                      <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value">

                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item class="form-item2" label="供应商" prop="providerid" :label-width="formLabelWidth">
                    <el-select class="form-item-input" filterable v-model="addInportsform.providerid" placeholder="请选择">
                      <el-option style="height: auto" v-for="(value, key) in providerName" :key="key" :value="value">

                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item class="form-item"  label="进货数量/箱" prop="number" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addInportsform.number" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item2" label="进货价格/元" prop="inportprice" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addInportsform.inportprice" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item" label="商品重量/kg" prop="totalweight" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addInportsform.totalweight" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item2" label="入库名称" prop="sid" :label-width="formLabelWidth">
                    <el-select class="form-item-input" filterable v-model="addInportsform.sid" placeholder="请选择">
                      <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value">

                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item class="form-item" label="支付类型" prop="description" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addInportsform.paytype" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item class="form-item2" label="操作人员" prop="operateperson" :label-width="formLabelWidth">
                    <el-input class="form-item-input" type="text" v-model="addInportsform.operateperson" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item  label="入库时间" prop="inporttime" :label-width="formLabelWidth">
                    <el-date-picker
                      v-model="addInportsform.inporttime"
                      format="yyyy-MM-dd"
                      value-format="yyyy-MM-dd"
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
                      v-model="addInportsform.remark"
                    >
                    </el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="resetForm('addInportsform')">重 置</el-button>
                  <el-button type="primary" @click="addInports">提 交</el-button>
                </div>
              </el-dialog>
            </div>
          </div>
          <!--商品选择查询-->
          <div class="goodsSelect">
            <el-select class="form-item-input" filterable v-model="gname"  placeholder="请选择商品">
              <el-option @click.native="getInportsList" value="">所有进货</el-option>
              <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value" @click.native="getInportsByGid(key)">

              </el-option>
            </el-select>
          </div>
          <!--供应商选择查询-->
          <div class="providerSelect">
            <el-select class="form-item-input" filterable v-model="pname"  placeholder="请选择供应商">
              <el-option @click.native="getInportsList" value="">所有供应商</el-option>
              <el-option style="height: auto" v-for="(value, key) in providerName" :key="key" :value="value" @click.native="getInportsByPid(key)">

              </el-option>
            </el-select>
          </div>
          <!--仓库选择查询-->
          <div class="houseSelect">
            <el-select class="form-item-input" filterable v-model="sname"  placeholder="请选择仓库">
              <el-option @click.native="getInportsList" value="">所有进货</el-option>
              <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value" @click.native="getInportsBySid(key)">

              </el-option>
            </el-select>
          </div>
          <!--日期选择查询-->
          <div class="dateSelect">
              <el-date-picker
                v-model="sdate"
                format="yyyy-MM-dd"
                value-format="yyyy-MM-dd"
                @change="getInportByDate"
                type="date"
                placeholder="选择日期">
              </el-date-picker>
          </div>
        </div>
        <el-card class="card-table-body">
          <!--Inports列表-->
          <el-table
            :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
            border
            height="478"
            tooltip-effect="light"
            style="width: 100%;font-size: 16px;"
            size="small">
            <el-table-column
              prop="iid"
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
              prop="inportprice"
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
              prop="inporttime"
              label="入库日期"
              width="125"
              :formatter="formatterTime"
            >
            </el-table-column>
            <el-table-column
              prop="pname"
              label="供应商"
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
                <el-button class="operate-button-1" type="danger" size="small" @click="delMessage(scope.row.iid)">删除</el-button>

                <el-button class="operate-button-1" type="info" size="small" @click="updateInports_getInports(scope.row.iid)" >修改</el-button>
                  <!--修改Inports模态框-->
                  <el-dialog title="修改进货" :visible.sync="dialogFormVisible2" style="margin-top: -100px">

                    <el-form key="updateInports" :model="updateInportsform" ref="updateInportsform" style="width: 670px">
                      <el-form-item class="form-item" label="商品名称" prop="goodsid" :label-width="formLabelWidth">
                        <el-select class="form-item-input" filterable v-model="updateInportsform.goodsid" placeholder="请选择">
                          <el-option style="height: auto" v-for="(value, key) in goodsName" :key="key" :value="value">

                          </el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item class="form-item2" label="供应商" prop="providerid" :label-width="formLabelWidth">
                        <el-select class="form-item-input" filterable v-model="updateInportsform.providerid" placeholder="请选择">
                          <el-option style="height: auto" v-for="(value, key) in providerName" :key="key" :value="value">

                          </el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item class="form-item"  label="进货数量/箱" prop="number" :label-width="formLabelWidth">
                        <el-input class="form-item-input" type="text" v-model="updateInportsform.number" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item class="form-item2" label="进货价格/元" prop="inportprice" :label-width="formLabelWidth">
                        <el-input class="form-item-input" type="text" v-model="updateInportsform.inportprice" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item class="form-item" label="商品重量/kg" prop="totalweight" :label-width="formLabelWidth">
                        <el-input class="form-item-input" type="text" v-model="updateInportsform.totalweight" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item class="form-item2" label="入库名称" prop="sid" :label-width="formLabelWidth">
                        <el-select class="form-item-input" filterable v-model="updateInportsform.sid" placeholder="请选择">
                          <el-option style="height: auto" v-for="(value, key) in houseName" :key="key" :value="value">

                          </el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item class="form-item" label="支付类型" prop="paytype" :label-width="formLabelWidth">
                        <el-input class="form-item-input" type="text" v-model="updateInportsform.paytype" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item class="form-item2" label="操作人员" prop="operateperson" :label-width="formLabelWidth">
                        <el-input class="form-item-input" type="text" v-model="updateInportsform.operateperson" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item  label="入库时间" prop="inporttime" :label-width="formLabelWidth">
                        <el-date-picker
                          v-model="updateInportsform.inporttime"
                          format="yyyy-MM-dd"
                          value-format="yyyy-MM-dd"
                          type="date"
                          placeholder="选择日期">
                        </el-date-picker>
                      </el-form-item>
                      <el-form-item class="form-item2" label="退货备注" prop="outportinfo" :label-width="formLabelWidth">
                        <el-input class="form-item-input" type="text" v-model="updateInportsform.outportinfo" placeholder="暂无" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item label="备注" prop="remark" :label-width="formLabelWidth">
                        <el-input
                          type="textarea"
                          rows="3"
                          :autosize="{ minRows: 1, maxRows: 3}"
                          placeholder="请输入内容"
                          v-model="updateInportsform.remark"
                        >
                        </el-input>
                      </el-form-item>
                    </el-form>
                      <div slot="footer" class="dialog-footer" style="margin-top: -50px;">
                        <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                        <el-button type="warning" @click="updateInports_updateInports(updateInportsform.iid)">提交</el-button>
                      </div>
                  </el-dialog>

                <el-button class="operate-button-1" type="primary" size="small" @click="returnGoods_getInports(scope.row.iid)" >退货</el-button>
                  <!--退货模态框-->
                  <el-dialog title="退货" :visible.sync="dialogFormVisible3" @close="resetForm('outPortForm')">
                    <el-form key="outports" :model="outPortForm" ref="outPortForm">
                      <el-form-item label="退货数量/箱" prop="number" :label-width="formLabelWidth">
                        <el-input style="width: 300px" v-model="outPortForm.number" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item label="退货重量/kg" prop="totalweight" :label-width="formLabelWidth">
                        <el-input style="width: 300px" v-model="outPortForm.totalweight" autocomplete="off"></el-input>
                      </el-form-item>
                      <el-form-item  label="退货时间" prop="outputtime" :label-width="formLabelWidth">
                        <el-date-picker
                          v-model="outPortForm.outputtime"
                          format="yyyy-MM-dd"
                          value-format="yyyy-MM-dd"
                          type="date"
                          placeholder="选择日期">
                        </el-date-picker>
                      </el-form-item>
                      <el-form-item style="width: 700px;" label="退货说明" prop="remark" :label-width="formLabelWidth">
                        <el-input
                          type="textarea"
                          rows="3"
                          :autosize="{ minRows: 1, maxRows: 3}"
                          placeholder="请输入内容"
                          v-model="outPortForm.remark"
                        >
                        </el-input>
                      </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                      <el-button @click="dialogFormVisible3 = false">取 消</el-button>
                      <el-button type="primary" @click="returnGoods(updateInportsform.iid)">提交</el-button>
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
        name: "purchaseManage",
        components: {breadcrumb,},

        data(){
            return {
                InportList:null,
                InportOne:null,
                status: 0,
                iid:0,
                dialogFormVisible: false,
                dialogFormVisible2: false,
                dialogFormVisible3: false,
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
                    pageSize: 9
                },
                //添加Goods输入框宽度
                formLabelWidth: '120px',
                addInportsform: {
                    paytype: '',
                    operateperson : '',
                    goodsid: '',
                    inportprice: '',
                    number: '',
                    providerid: '',
                    remark: '',
                    inporttime: '',
                    totalweight: '',
                    sid: '',
                },
                updateInportsform: {
                    paytype: '',
                    operateperson : '',
                    goodsid: '',
                    inportprice: '',
                    number: '',
                    providerid: '',
                    remark: '',
                    inporttime: '',
                    totalweight: '',
                    sid: '',
                    outportinfo:'',
                },
                outPortForm: {
                    paytype: '',
                    providerid: '',
                    outputtime: '',
                    operateperson : '',
                    outportprice: '',
                    number: '',
                    remark: '',
                    goodsid: '',
                    sid: '',
                    totalweight: '',
                    iid:'',
                },
            }
        },
        methods: {
            //InportsList
            getInportsList() {
                this.$axios({
                    method: "get",
                    url: '/Inports/inportsUtils',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.InportList = response.data.data
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.tableData.length

                    } else {
                        return this.$message.error('查询进货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                // this.getGoodsName()
                // console.log(this.goodsName)
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
            //重置添加Inports表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //添加inports
            addInports(){
                let _this = this;
                let addInportsform = {
                    paytype: _this.addInportsform.paytype,
                    operateperson : _this.addInportsform.operateperson,
                    goodsid: this.getByValue(this.goodsName,_this.addInportsform.goodsid),
                    inportprice: _this.addInportsform.inportprice,
                    number: _this.addInportsform.number,
                    providerid: this.getByValue(this.providerName,_this.addInportsform.providerid),
                    remark: _this.addInportsform.remark,
                    inporttime: _this.addInportsform.inporttime,
                    totalweight: _this.addInportsform.totalweight,
                    sid: this.getByValue(this.houseName,_this.addInportsform.sid),
                }
                // console.log(addInportsform)
                this.$axios({
                    method: "post",
                    url: '/Inports/addInports',
                    data: addInportsform,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getInportsList()
                        this.dialogFormVisible = false
                        return this.$message.success('添加成功')
                    } else if(response.data.code === -2) {
                        return this.$message.error('本仓库余量不足,请选择其他仓库！！！')
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
                    url: '/Inports/goodsName',
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
                    url: '/Goods/providerName',
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
                    url: '/Inports/houseName',
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
            getInportsByGid(gid){
                this.$axios({
                    method: "post",
                    url: '/Inports/inportsListByGid',
                    params:{
                        gid:gid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.InportList = response.data.data
                        // console.log(this.InportList)
                        this.tableData = response.data.data
                        this.pagination.total = this.InportList.length
                    } else {
                        return this.$message.error('获取进货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //供应商选择查询
            getInportsByPid(pid){
                this.$axios({
                    method: "post",
                    url: '/Inports/inportsListByPid',
                    params:{
                        pid:pid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.InportList = response.data.data
                        // console.log(this.InportList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.InportList.length
                    } else {
                        return this.$message.error('获取进货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            getInportsBySid(sid){
                this.$axios({
                    method: "post",
                    url: '/Inports/inportsListBySid',
                    params:{
                        sid:sid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.InportList = response.data.data
                        // console.log(this.InportList)
                        this.tableData = response.data.data
                        // console.log(this.tableData)
                        this.pagination.total = this.InportList.length
                    } else {
                        return this.$message.error('获取进货列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //日期查询Inports
            getInportByDate(val){
                let inporttime = val
                if(inporttime!=null){
                  // console.log(inporttime)
                  this.$axios({
                      method: "post",
                      url: '/Inports/inportsListByDate',
                      params:{
                          inporttime:inporttime
                      }
                  }).then((response) => {
                      this.status = response.data.code
                      if (this.status === 1) {
                          // console.log(response.data)
                          this.InportList = response.data.data
                          // console.log(this.InportList)
                          this.tableData = response.data.data
                          // console.log(this.tableData)
                          this.pagination.total = this.InportList.length
                      } else {
                          return this.$message.error('获取进货列表失败')
                      }
                  }).catch(function (error) {
                      console.log(error)
                  });
                }
                else if (inporttime == null){
                    this.getInportsList()
                }
            },
            //删除Inports
            async delMessage(iid) {
                let _this = this
                // console.log(iid)
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
                    iid: iid
                }
                //删除Goods
                //这里的delete还是没有解决,只能用post代替
                this.$axios({
                    method: "post",
                    url: '/Inports/delInports',
                    data: _this.$qs.stringify(da)
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.getInportsList()
                        this.$message.success('删除成功')
                    } else {
                        return this.$message.error('删除失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //修改前得到Inports
            updateInports_getInports(iid){
                // console.log(iid)
                this.$axios.get('/Inports/oneInports2', {
                    params: {
                        iid: iid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateInportsform = response.data.data
                        // console.log(this.updateInportsform)
                        //id换name
                        this.updateInportsform.goodsid = this.goodsName[this.updateInportsform.goodsid]
                        this.updateInportsform.providerid = this.providerName[this.updateInportsform.providerid]
                        this.updateInportsform.sid = this.houseName[this.updateInportsform.sid]
                    } else {
                        return this.$message.error('查询进货信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible2 = true
            },
            //修改Inports
            updateInports_updateInports(iid){
                let _this = this;
                let updateInportsform = {
                    paytype: _this.updateInportsform.paytype,
                    operateperson : _this.updateInportsform.operateperson,
                    goodsid: this.getByValue(this.goodsName,_this.updateInportsform.goodsid),
                    inportprice: _this.updateInportsform.inportprice,
                    number: _this.updateInportsform.number,
                    providerid: this.getByValue(this.providerName,_this.updateInportsform.providerid),
                    remark: _this.updateInportsform.remark,
                    inporttime: _this.updateInportsform.inporttime,
                    totalweight: _this.updateInportsform.totalweight,
                    sid: this.getByValue(this.houseName,_this.updateInportsform.sid),
                }
                // console.log(updateInportsform)
                this.$axios({
                    method: "put",
                    url: '/Inports/updateInports',
                    params: {iid: iid},
                    data: updateInportsform,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getInportsList()
                        this.dialogFormVisible2 = false
                        return this.$message.success('更新成功')
                    } else if(response.data.code === -2) {
                        return this.$message.error('本仓库余量不足,请选择其他仓库！！！')
                    }
                    return  this.$message.error('更新失败！！！')
                }).catch(function (error) {
                    console.log(error)
                });
            },
            returnGoods_getInports(iid){
                this.$axios.get('/Inports/oneInports2', {
                    params: {
                        iid: iid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateInportsform = response.data.data
                        // console.log(this.updateInportsform)
                    } else {
                        return this.$message.error('查询进货信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible3 = true
            },
            returnGoods(iid){
                let _this = this
                let outPortForm= {
                        paytype: _this.updateInportsform.paytype,
                        providerid: _this.updateInportsform.providerid,
                        outputtime: _this.outPortForm.outputtime,
                        operateperson : _this.updateInportsform.operateperson,
                        outportprice: _this.updateInportsform.inportprice,
                        number: _this.outPortForm.number,
                        remark: _this.outPortForm.remark,
                        goodsid: _this.updateInportsform.goodsid,
                        sid: _this.updateInportsform.sid,
                        totalweight: _this.outPortForm.totalweight,
                        iid:iid,
                    }
                // console.log(outPortForm)
                this.$axios({
                    method: "post",
                    url: '/Outports/addOutports',
                    data: outPortForm,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.dialogFormVisible3 = false
                        return this.$notify({
                            title: '添加退货成功',
                            message: '请到退货管理查看！',
                            type: 'success'
                        });
                    }
                    return  this.$message.error('添加失败！！！')
                }).catch(function (error) {
                    console.log(error)
                });
            },
        },
        mounted() {
            this.getInportsList()
            this.getGoodsName()
            this.getProviderName()
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
  /*商品供应商选择器太长，可能与侧边栏有关，样式形变*/
  .el-scrollbar {
    height: auto;
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
  .providerSelect{
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
    margin-top: 5px;
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
