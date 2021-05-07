<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="card-table">
          <el-card class="card-table-body">
            <!--添加customer按钮-->
            <div class="addButton">
              <el-button type="success" @click="dialogFormVisible = true">添加</el-button>
            </div>
            <!--批量删除按钮-->
            <div class="delCustomersButton">
              <el-button type="danger" plain @click="delCustomers">批量删除</el-button>
            </div>

            <!--添加客户模态框-->
            <div>
              <el-dialog title="添加客户" :visible.sync="dialogFormVisible" @close="resetForm('addCustomerform')">
                <el-form key="addCustomer" :model="addCustomerform" ref="addCustomerform" style="width: 670px">
                  <el-form-item label="客户名称" prop="customernname" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.customernname" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="客户邮编" prop="postcode" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.postcode" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item  label="客户地址" prop="caddress" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.caddress" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="客户座机" prop="ctelephone" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.ctelephone" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="联系人" prop="contact" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.contact" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="联系人电话" prop="contactnumber" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.contactnumber" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="银行账号" prop="backaccount" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.backaccount" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="邮箱" prop="contactemail" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addCustomerform.contactemail" autocomplete="off"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="resetForm('addCustomerform')">重 置</el-button>
                  <el-button type="primary" @click="addCustomer">提 交</el-button>
                </div>
              </el-dialog>
            </div>
            <!--搜索框-->
            <div class="search">
              <el-input
                placeholder="请输入客户名称/地址/联系人"
                prefix-icon="el-icon-search"
                @keyup.enter.native="searchCustomer(search)"
                v-model="search">
              </el-input>
            </div>
            <!--搜索按钮-->
            <div class="search-button">
              <el-button type="primary" style="width: 100px;" @click="searchCustomer(search)">搜索</el-button>
            </div>
            <!--客户列表-->
            <el-table
              :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
              border
              height="478"
              tooltip-effect="light"
              style="width: 100%;font-size: 16px;margin-top: 15px;margin-left: 1px;"
              size="small"
              @selection-change="handleSelectionChange">
              <el-table-column
                type="selection"
                width="55"
              >
              </el-table-column>
              <el-table-column
                prop="cid"
                label="ID"
                width="60"
              >
              </el-table-column>
              <el-table-column
                prop="customernname"
                label="客户名称"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="postcode"
                label="客户邮编"
                width="125"
                >
              </el-table-column>
              <el-table-column
                prop="caddress"
                label="客户地址"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="ctelephone"
                label="客户座机"
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
                label="客户银行账号"
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
                  <el-button class="operate-button-1" type="danger" size="small" @click="delMessage(scope.row.cid)">删除</el-button>

                  <el-button class="operate-button-1" type="info" size="small" @click="updateCustomer_getCustomer(scope.row.cid)" >修改</el-button>
                    <!--修改部门模态框-->
                    <el-dialog title="修改客户" :visible.sync="dialogFormVisible2" style="margin-top: -110px">
                      <el-form key="updateCustomer" :model="updateCustomerform" ref="updateCustomerform"
                               style="width: 670px;">
                        <el-form-item label="客户名称" prop="customernname" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.customernname" autocomplete="off">
                          </el-input>
                        </el-form-item>
                        <el-form-item label="邮编" prop="postcode" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.postcode" autocomplete="off">
                          </el-input>
                        </el-form-item>
                        <el-form-item  label="客户地址" prop="caddress" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.caddress" autocomplete="off">

                          </el-input>
                        </el-form-item>
                        <el-form-item label="客户座机" prop="ctelephone" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.ctelephone" autocomplete="off">

                          </el-input>
                        </el-form-item>
                        <el-form-item label="联系人" prop="contact" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.contact" autocomplete="off">

                          </el-input>
                        </el-form-item>
                        <el-form-item label="联系人电话" prop="contactnumber" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.contactnumber" autocomplete="off">

                          </el-input>
                        </el-form-item>
                        <el-form-item label="银行账号" prop="backaccount" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.backaccount" autocomplete="off">

                          </el-input>
                        </el-form-item>
                        <el-form-item label="邮箱" prop="contactemail" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateCustomerform.contactemail" autocomplete="off">

                          </el-input>
                        </el-form-item>
                      </el-form>
                      <div slot="footer" class="dialog-footer">
                        <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                        <el-button type="warning" @click="updateCustomer_updateCustomer(updateCustomerform.cid)">提交</el-button>
                      </div>
                    </el-dialog>

                </template>
              </el-table-column>
            </el-table>
            <!--          分页-->
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
    <!--    底部-->
    <div class="footer">
      <div class="footer-title">CopyRight-DataSupermacy-Y @2021</div>
    </div>
  </div>
</template>

<script>
    import breadcrumb from "../../components/system/breadcrumb";
    export default {
        name: "customerManage",
        components: {breadcrumb,},

        data(){
            return {
                CustomerList: null,
                CustomerOne: null,
                status: 0,
                cid: 0,
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
                addCustomerform: {
                    customernname: '',
                    postcode: '',
                    caddress: '',
                    ctelephone: '',
                    contact: '',
                    contactnumber: '',
                    backaccount: '',
                    contactemail: '',
                },
                updateCustomerform: {
                    customernname: '',
                    postcode: '',
                    caddress: '',
                    ctelephone: '',
                    contact: '',
                    contactnumber: '',
                    backaccount: '',
                    contactemail: '',
                },
            }
        },
        methods:{
            handleSelectionChange(val) {
                this.multipleSelection = val;
                // console.log(this.multipleSelection)
            },
            getCustomerList() {
                this.$axios({
                    method: "get",
                    url: '/Customer/customerList',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.CustomerList = response.data.data
                        // console.log(this.CustomerList)
                        this.tableData = response.data.data
                        this.pagination.total = this.CustomerList.length
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
            //重置添加客户表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //添加用户
            addCustomer(){
                let _this = this;
                let addCustomerform = {
                    customernname: _this.addCustomerform.customernname,
                        postcode: _this.addCustomerform.postcode,
                        caddress: _this.addCustomerform.caddress,
                        ctelephone: _this.addCustomerform.ctelephone,
                        contact: _this.addCustomerform.contact,
                        contactnumber: _this.addCustomerform.contactnumber,
                        backaccount: _this.addCustomerform.backaccount,
                        contactemail: _this.addCustomerform.contactemail,
                }
                // console.log(addCustomerform)
                this.$axios({
                    method: "post",
                    url: '/Customer/addCustomer',
                    data: addCustomerform,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getCustomerList()
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
            //删除客户
            async delMessage(cid) {
                let _this = this
                // console.log(cid)
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
                    cid: cid
                }
                //删除客户
                //这里的delete还是没有解决,只能用post代替
                this.$axios({
                    method: "post",
                    url: '/Customer/delCustomer',
                    data: _this.$qs.stringify(da)
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.getCustomerList()
                        this.$message.success('删除成功')
                    } else {
                        return this.$message.error('删除失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //批量删除客户
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
                        url: '/Customer/delCustomers',
                        data: list,
                    }).then((response) => {
                        // console.log(response.data)
                        if (response.data.code === 1) {
                            _this.getCustomerList()
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
            searchCustomer(search){
                let _this = this
                if(search!='' && search!=' '){
                  let da = {
                      key: search
                  }
                  this.$axios({
                      method: "post",
                      url: '/Customer/customerListByKey',
                      data: _this.$qs.stringify(da)
                  }).then((response) => {
                      this.status = response.data.code
                      if (this.status === 1) {
                          this.CustomerList = response.data.data
                          // console.log(this.CustomerList)
                          this.tableData = response.data.data
                          this.pagination.total = this.CustomerList.length
                      } else {
                          return this.$message.error('查询用户列表失败')
                      }
                  }).catch(function (error) {
                      console.log(error)
                  });
                }else {
                    return this.$message.error('输入不能为空')
                }
            },
            //更新客户前得到客户信息
            updateCustomer_getCustomer(cid){
                // console.log(cid)
                this.$axios.get('/Customer/oneCustomer', {
                    params: {
                        cid: cid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateCustomerform = response.data.data
                        // console.log(this.updateCustomerform.cid)
                        // console.log(this.updateCustomerform)
                    } else {
                        return this.$message.error('查询客户信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible2 = true
            },
            //更新客户
            updateCustomer_updateCustomer(cid){
                let _this = this;
                let updateCustomerform = {
                    customernname: _this.updateCustomerform.customernname,
                    postcode: _this.updateCustomerform.postcode,
                    caddress: _this.updateCustomerform.caddress,
                    ctelephone: _this.updateCustomerform.ctelephone,
                    contact: _this.updateCustomerform.contact,
                    contactnumber: _this.updateCustomerform.contactnumber,
                    backaccount: _this.updateCustomerform.backaccount,
                    contactemail: _this.updateCustomerform.contactemail,
                }
                this.$axios({
                    method: 'put',
                    url: '/Customer/updateCustomer',
                    params: {cid: cid},
                    data: updateCustomerform
                })
                    .then((response) => {
                        // console.log(response.data)
                        if (response.data.code === 1) {
                            _this.getCustomerList()
                            this.dialogFormVisible2 = false
                            console.log(cid)
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
        mounted(){
            this.getCustomerList();
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
  .card-table{
    /*border: 1px solid red;*/
  }
  .addButton{
    margin-left: 20px;
    margin-top: 10px;
    width: 71px;
  }
  .delCustomersButton{
    width: 101px;
    margin-left: 110px;
    margin-top: -40px;
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
