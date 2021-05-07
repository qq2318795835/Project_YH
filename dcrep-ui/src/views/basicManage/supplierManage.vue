<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="main-body">
          <!--添加provider按钮-->
          <div class="addButton">
            <el-button type="success" @click="dialogFormVisible = true">添加</el-button>
            <!--添加provider模态框-->
            <div>
              <el-dialog title="添加客户" :visible.sync="dialogFormVisible" @close="resetForm('addProviderform')">
                <el-form key="addCustomer" :model="addProviderform" ref="addCustomerform" style="width: 670px">
                  <el-form-item label="客户名称" prop="providername" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.providername" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="客户邮编" prop="postcode" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.postcode" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item  label="客户地址" prop="address" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.address" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="客户座机" prop="telephone" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.telephone" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="联系人" prop="contact" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.contact" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="联系人电话" prop="contactnumber" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.contactnumber" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="银行账号" prop="backaccount" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.backaccount" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="邮箱" prop="contactemail" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addProviderform.contactemail" autocomplete="off"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="resetForm('addProviderform')">重 置</el-button>
                  <el-button type="primary" @click="addProvider">提 交</el-button>
                </div>
              </el-dialog>
            </div>
          </div>
          <!--批量删除按钮-->
          <div class="delProvidersButton">
            <el-button type="danger" plain @click="delCustomers">批量删除</el-button>
          </div>
          <!--搜索框-->
          <div class="search">
            <el-input
              placeholder="请输入供应商名称/地址/联系人"
              prefix-icon="el-icon-search"
              @keyup.enter.native="searchProvider(search)"
              v-model="search">
            </el-input>
          </div>
          <!--搜索按钮-->
          <div class="search-button">
            <el-button type="primary" style="width: 100px;" @click="searchProvider(search)">搜索</el-button>
          </div>
          <el-card class="card-table-body">
            <!--供应商列表-->
            <el-table
              :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
              border
              height="478"
              tooltip-effect="light"
              style="width: 100%;font-size: 16px;"
              size="small"
              @selection-change="handleSelectionChange">
              <el-table-column
                type="selection"
                width="55"
              >
              </el-table-column>
              <el-table-column
                prop="pid"
                label="ID"
                width="60"
              >
              </el-table-column>
              <el-table-column
                prop="providername"
                label="供应商名称"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="postcode"
                label="供应商邮编"
                width="125"
              >
              </el-table-column>
              <el-table-column
                prop="address"
                label="供应商地址"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="telephone"
                label="供应商座机"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="contact"
                label="联系人"
                width="125"
              >
              </el-table-column>
              <el-table-column
                prop="contactnumber"
                label="联系人电话"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="backaccount"
                label="银行账号"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="contactemail"
                label="邮箱"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop=""
                label="操作"
              >
                <!--表格中的操作-->
                <template slot-scope="scope">
                  <el-button class="operate-button-1" type="danger" size="small" @click="delMessage(scope.row.pid)">删除</el-button>

                  <el-button class="operate-button-1" type="info" size="small" @click="updateProvider_getProvider(scope.row.pid)" >修改</el-button>
                  <!--修改provider模态框-->
                  <el-dialog title="修改客户" :visible.sync="dialogFormVisible2" style="margin-top: -110px">
                    <el-form key="updateCustomer" :model="updateProviderform" ref="updateCustomerform"
                             style="width: 670px;">
                      <el-form-item label="供应商名称" prop="providername" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.providername" autocomplete="off">
                        </el-input>
                      </el-form-item>
                      <el-form-item label="邮编" prop="postcode" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.postcode" autocomplete="off">
                        </el-input>
                      </el-form-item>
                      <el-form-item  label="供应商地址" prop="address" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.address" autocomplete="off">

                        </el-input>
                      </el-form-item>
                      <el-form-item label="供应商座机" prop="telephone" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.telephone" autocomplete="off">

                        </el-input>
                      </el-form-item>
                      <el-form-item label="联系人" prop="contact" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.contact" autocomplete="off">

                        </el-input>
                      </el-form-item>
                      <el-form-item label="联系人电话" prop="contactnumber" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.contactnumber" autocomplete="off">

                        </el-input>
                      </el-form-item>
                      <el-form-item label="银行账号" prop="backaccount" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.backaccount" autocomplete="off">

                        </el-input>
                      </el-form-item>
                      <el-form-item label="邮箱" prop="contactemail" :label-width="formLabelWidth">
                        <el-input type="text" v-model="updateProviderform.contactemail" autocomplete="off">

                        </el-input>
                      </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                      <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                      <el-button type="warning" @click="updateProvider_updateProvider(updateProviderform.pid)">提交</el-button>
                    </div>
                  </el-dialog>
                </template>
              </el-table-column>
            </el-table>
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
        </div>
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
        name: "supplierManage",
        components: {breadcrumb,},

        data(){
          return {
              ProviderList: null,
              ProviderOne: null,
              status: 0,
              pid: 0,
              dialogTableVisible: false,
              dialogTableVisible2: false,
              dialogFormVisible: false,
              dialogFormVisible2: false,
              search: '',
              tableData: [],
              multipleSelection: [],
              pagination: {
                  total: 0,
                  pageNum: 1,
                  currenPage: 1,
                  pageSize: 9
              },
              //添加用户输入框宽度
              formLabelWidth: '120px',
              addProviderform: {
                  providername: '',
                  postcode: '',
                  address: '',
                  telephone: '',
                  contact: '',
                  contactnumber: '',
                  backaccount: '',
                  contactemail: '',
              },
              updateProviderform: {
                  providername: '',
                  postcode: '',
                  address: '',
                  telephone: '',
                  contact: '',
                  contactnumber: '',
                  backaccount: '',
                  contactemail: '',
              },
          }
        },
        methods: {
            handleSelectionChange(val) {
                this.multipleSelection = val;
                // console.log(this.multipleSelection)
            },
            getProviderList() {
                this.$axios({
                    method: "get",
                    url: '/Provider/providerList',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.ProviderList = response.data.data
                        // console.log(this.ProviderList)
                        this.tableData = response.data.data
                        this.pagination.total = this.ProviderList.length
                    } else {
                        return this.$message.error('查询用户列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
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
            //重置添加provider表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //添加供应商
            addProvider(){
                let _this = this;
                let addProviderform = {
                    providername: _this.addProviderform.providername,
                    postcode: _this.addProviderform.postcode,
                    address: _this.addProviderform.address,
                    telephone: _this.addProviderform.telephone,
                    contact: _this.addProviderform.contact,
                    contactnumber: _this.addProviderform.contactnumber,
                    backaccount: _this.addProviderform.backaccount,
                    contactemail: _this.addProviderform.contactemail,
                }
                // console.log(addProviderform)
                this.$axios({
                    method: "post",
                    url: '/Provider/addProvider',
                    data: addProviderform,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getProviderList()
                        this.dialogFormVisible = false
                        return this.$message.success('添加成功')
                    } else {
                        return this.$message.error('添加失败')
                    }
                    _this.dialogFormVisible = false;
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //删除供应商
            async delMessage(pid) {
                let _this = this
                // console.log(pid)
                const confirmResult = await
                    this.$confirm('删除该信息, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).catch(error => error)

                if (confirmResult != 'confirm') {
                    return this.$message.info('已取消删除')
                }
                let da = {
                    pid: pid
                }
                //删除部门
                //这里的delete还是没有解决,只能用post代替
                this.$axios({
                    method: "post",
                    url: '/Provider/delProvider',
                    data: _this.$qs.stringify(da)
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.getProviderList()
                        this.$message.success('删除成功')
                    } else {
                        return this.$message.error('删除失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //批量删除provider
            async delCustomers(){
                let _this = this
                // console.log(this.multipleSelection)
                var list = []
                const confirmResult = await
                    this.$confirm('批量删除信息, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).catch(error => error)

                if (confirmResult != 'confirm') {
                    return this.$message.info('已取消删除')
                }
                for (let i = 0; i < _this.multipleSelection.length; i++) {
                    list.push(_this.multipleSelection[i])
                }
                // console.log(list)
                if (list.length>0){
                    this.$axios({
                        method: "post",
                        url: '/Provider/delProviders',
                        data: list,
                    }).then((response) => {
                        // console.log(response.data)
                        if (response.data.code === 1) {
                            _this.getProviderList()
                            return this.$message.success('批量删除成功')
                        } else {
                            return this.$message.error('批量删除失败')
                        }
                    }).catch(function (error) {
                        console.log(error)
                    });
                } else {
                    this.$notify({
                        title: '删除提示',
                        message: '未选择任何删除项 !!!',
                        type: 'warning'
                    });
                }
            },
            //搜索
            searchProvider(search){
                let _this = this
                if(search!='' && search!=' '){
                    let da = {
                        key: search
                    }
                    this.$axios({
                        method: "post",
                        url: '/Provider/providerListByKey',
                        data: _this.$qs.stringify(da)
                    }).then((response) => {
                        this.status = response.data.code
                        if (this.status === 1) {
                            this.ProviderList = response.data.data
                            // console.log(this.ProviderList)
                            this.tableData = response.data.data
                            this.pagination.total = this.ProviderList.length
                        } else {
                            return this.$message.error('供应商列表失败')
                        }
                    }).catch(function (error) {
                        console.log(error)
                    });
                }else {
                    return this.$message.error('输入不能为空')
                }
            },
            //更新供应商前得到供应商信息
            updateProvider_getProvider(pid){
                // console.log(pid)
                this.$axios.get('/Provider/oneProvider', {
                    params: {
                        pid: pid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateProviderform = response.data.data
                        // console.log(this.updateProviderform.pid)
                        // console.log(this.updateCustomerform)
                    } else {
                        return this.$message.error('查询供应商信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible2 = true
            },
            //更新供应商
            updateProvider_updateProvider(pid){
                let _this = this;
                let updateProviderform = {
                    providername: _this.updateProviderform.providername,
                    postcode: _this.updateProviderform.postcode,
                    address: _this.updateProviderform.address,
                    telephone: _this.updateProviderform.telephone,
                    contact: _this.updateProviderform.contact,
                    contactnumber: _this.updateProviderform.contactnumber,
                    backaccount: _this.updateProviderform.backaccount,
                    contactemail: _this.updateProviderform.contactemail,
                }
                this.$axios({
                    method: 'put',
                    url: '/Provider/updateProvider',
                    params: {pid: pid},
                    data: updateProviderform
                })
                    .then((response) => {
                        // console.log(response.data)
                        if (response.data.code === 1) {
                            _this.getProviderList()
                            this.dialogFormVisible2 = false
                            // console.log(pid)
                            return this.$message.success('修改成功')
                        } else {
                            return this.$message.error('修改失败')
                        }
                        _this.dialogFormVisible = false;
                    }).catch(function (error) {
                    console.log(error)
                });
            },
        },
        mounted() {
            this.getProviderList();
        }
    }
</script>

<style>

</style>

<style scoped>
  >>>.el-card__body {
    padding: 0px;
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
  .delProvidersButton{
    width: 101px;
    margin-left: 110px;
    margin-top: -39px;
  }
  .search{
    width: 400px;
    margin-left: 430px;
    margin-top: -40px;
  }
  .search-button{
    margin-left: 830px;
    margin-top: -39.5px;
  }
  .card-table-body{
    border: none;
    /*margin-top: 80px;*/
    margin-top: 14px;
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
    height: 55.5px;
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
