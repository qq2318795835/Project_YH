<template>
  <div>
    <div class="body">
<!--      deparmentManage主体-->
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <!--        左边部门树-->
        <div class="treeDept">
          <el-tree class="treeDeptList"
                   :data="treeData"
                   :props="defaultProps"
                   default-expand-all
          >
          </el-tree>
        </div>
        <!--        右边主体-->
        <div class="card-table">
          <!--          添加用户按钮-->
          <div class="addButton">
            <el-button type="success" @click="dialogFormVisible = true">添加</el-button>
          </div>
          <!--            添加用户模态框-->
          <div>
            <el-dialog title="添加用户" :visible.sync="dialogFormVisible" @close="resetForm('addUserform')">
              <el-form key="addUser" :model="addUserform" ref="addUserform" style="width: 670px">
                <el-form-item label="用户名称" prop="uname" :label-width="formLabelWidth">
                  <el-input type="text" v-model="addUserform.uname" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="登录名称" prop="uloginName" :label-width="formLabelWidth">
                  <el-input type="text" v-model="addUserform.uloginName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item  label="登录密码" prop="upwd" :label-width="formLabelWidth">
                  <el-input type="password" v-model="addUserform.upwd" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="员工备注" prop="uremark" :label-width="formLabelWidth">
                  <el-input type="text" v-model="addUserform.uremark" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="部门名称" prop="deptName" :label-width="formLabelWidth">
                  <el-input type="text" v-model="addUserform.deptName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="上级领导" prop="umgr" :label-width="formLabelWidth">
                  <el-input type="text" v-model="addUserform.umgr" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="员工地址" prop="uaddress" :label-width="formLabelWidth">
                  <el-input type="text" v-model="addUserform.uaddress" autocomplete="off"></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="resetForm('addUserform')">重 置</el-button>
                <el-button type="primary" @click="addUserUtil">提 交</el-button>
              </div>
            </el-dialog>
          </div>
          <!--          用户信息表格-->
          <el-card class="card-table-card">
            <el-table
              :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
              height="500"
              border
              style="width: 100%;font-size: 16px;"
              size="small"
            >
              <el-table-column
                prop="uid"
                label="ID"
                width="50px"
              >
              </el-table-column>
              <el-table-column
                prop="uname"
                label="员工姓名"
                width="140px"
              >
              </el-table-column>
              <el-table-column
                prop="uloginName"
                label="登录名"
                width="140px"
              >
              </el-table-column>
              <el-table-column
                prop="uremark"
                label="员工备注"
                width="140px"
                :show-overflow-tooltip="true"
              >
              </el-table-column>
              <el-table-column
                prop="deptName"
                label="所属部门"
                width="140px"
              >
              </el-table-column>
              <el-table-column
                prop="umgr"
                label="上级领导"
                width="140px"
              >
              </el-table-column>
              <el-table-column
                prop="uaddress"
                label="地址"
                width="140px"
              >
              </el-table-column>
              <el-table-column
                prop=""
                label="操作"
              >
                <!--表格中的操作-->
                <template slot-scope="scope">
                  <el-button class="operate-button-1" type="danger" size="small" @click="delMessage(scope.row.uid)">删除</el-button>

                  <el-button class="operate-button-2" type="info" size="small" @click="updateUser_getUser(scope.row.uid)" >修改</el-button>
                    <!--修改用户模态框-->
                    <el-dialog title="修改用户" :visible.sync="dialogFormVisible2" class="abow_dialog">
                      <el-form key="updateUser" :model="updateUserform" ref="updateUserform"
                               style="width: 670px">
                        <el-form-item label="员工名称" prop="uname" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateUserform.uname" autocomplete="off">
                          </el-input>
                        </el-form-item>
                        <el-form-item label="员工备注" prop="uremark" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateUserform.uremark" autocomplete="off">
                          </el-input>
                        </el-form-item>
                        <el-form-item  label="所属部门" prop="deptName" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateUserform.deptName" autocomplete="off">

                          </el-input>
                        </el-form-item>
                        <el-form-item label="上级领导" prop="umgr" :label-width="formLabelWidth">
                          <el-input type="text" v-model="updateUserform.umgr" autocomplete="off">

                          </el-input>
                        </el-form-item>
                      </el-form>
                      <div slot="footer" class="dialog-footer">
                        <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                        <el-button type="warning" @click="updateUser_updateUser(updateUserform.uid)">提交</el-button>
                      </div>
                    </el-dialog>

                </template>
              </el-table-column>
            </el-table>
          </el-card>
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
        name: "userManage",
        components: {breadcrumb,},

        data() {
            //添加用户表单校验规则-未完成
            // var validateDtitle = (rule, value, callback) => {
            //     if (value === '') {
            //         callback(new Error('部门名称不能为空'));
            //     }
            // };
            // var validatedremark = (rule, value, callback) => {
            //     if (value === '') {
            //         callback(new Error('部门说明不能为空'));
            //     } else if (value.length >30){
            //         callback(new Error('部门说明长度不能超过30字'))
            //     }
            // };
            // var validatedAddress = (rule, value, callback) => {
            //     if (value === '') {
            //         callback(new Error('部门地址不能为空'));
            //     }
            // };
            return {
                UserList: null,
                UserOne: null,
                status: 0,
                uid: 0,
                treeData: [
                    {
                        id: '',
                        name: '',
                        //子节点：
                        children: []
                    }
                ],
                defaultProps: {
                    id: 'id',
                    children: 'children',
                    label: 'name'
                },
                tableData: [],
                pagination: {
                    total: 0,
                    pageNum: 1,
                    currenPage: 1,
                    pageSize: 9
                },
                dialogTableVisible: false,
                dialogTableVisible2: false,
                dialogFormVisible: false,
                dialogFormVisible2: false,

                //添加部门表单
                addUserform: {
                    uname: '',
                    uloginName: '',
                    upwd: '',
                    uremark: '',
                    deptName: '',
                    umgr: '',
                    uaddress: ''
                },
                //添加用户输入框宽度
                formLabelWidth: '120px',
                //添加用户表单校验规则-未完成
                // addDeptRules: {
                //     // dpid:[{ validator: validateDpid, trigger: 'blur' }],
                //     dtitle:[{ validator: validateDtitle, trigger: 'blur' }],
                //     dremark:[{ validator: validatedremark, trigger: 'blur' }],
                //     daddress:[{ validator: validatedAddress, trigger: 'blur' }],
                // },
                //修改部门表单
                updateUserform: {
                    uname: '',
                    uremark: '',
                    deptName: '',
                    umgr: '',
                },
            }
        },
        methods: {
            getUserList() {
                this.$axios({
                    method: "get",
                    url: '/User/getUserUtils',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.UserList = response.data.data
                        // console.log(this.UserList)
                        this.tableData = response.data.data
                        this.pagination.total = this.UserList.length
                    } else {
                        return this.$message.error('查询用户列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //获取部门信息树
            getTreeData() {
                this.$axios({
                    method: "get",
                    url: '/Dept/deptTree',
                }).then((response) => {
                    if (response.data != null) {
                        this.treeData = response.data
                        // let _departmentList = JSON.stringify(this.departmentList)
                        // console.log(response.data)
                    } else {
                        return this.$message.error('获取部门树失败')
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
            //添加部门
            addUserUtil() {
                let _this = this;
                let userUtil = {
                    uname: _this.addUserform.uname,
                    uloginName: _this.addUserform.uloginName,
                    upwd: _this.addUserform.upwd,
                    uremark: _this.addUserform.uremark,
                    uaddress: _this.addUserform.uaddress,
                    deptName: _this.addUserform.deptName,
                    umgr: _this.addUserform.umgr,
                }
                // console.log(userUtil)
                this.$axios({
                    method: "post",
                    url: '/User/addUserUtil',
                    data: userUtil,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getUserList()
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
            //重置添加用户表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //删除用户
            async delMessage(uid) {
                let _this = this
                // console.log(uid)
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
                    uid: uid
                }
                //删除部门
                //这里的delete还是没有解决,只能用post代替
                this.$axios({
                    method: "post",
                    url: '/User/delUser',
                    data: _this.$qs.stringify(da)
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.getUserList()
                        this.$message.success('删除成功')
                    } else {
                        return this.$message.error('删除失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //更新前得到用户信息
            updateUser_getUser(uid) {
                // console.log(uid)
                this.$axios.get('/User/getUserUtilById', {
                    params: {
                        uid: uid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateUserform = response.data.data
                        // console.log(this.updateUserform)
                    } else {
                        return this.$message.error('查询用户信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible2 = true
            },
            //更新用户
            updateUser_updateUser(uid) {
                let _this = this;
                let updateUser = {
                    uname: _this.updateUserform.uname,
                    uremark: _this.updateUserform.uremark,
                    deptName: _this.updateUserform.deptName,
                    umgr: _this.updateUserform.umgr,
                }
                this.$axios({
                    method: 'put',
                    url: '/User/updateUserUtil',
                    params: {uid: uid},
                    data: updateUser
                })
                    .then((response) => {
                        // console.log(response.data)
                        if (response.data.code === 1) {
                            _this.getTreeData()
                            _this.getUserList()
                            this.dialogFormVisible2 = false
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
                // this.getUserList();
                this.getUserList();
                this.getTreeData();
            }

    }
</script>

<style>
  .el-card__body {
    padding: 0px;
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
  .treeDept{
    width: 200px;
    height: 640px;
  }
  .treeDeptList{
    width: 200px;
  }
  .card-table{
    width: 100%;
    margin-top: -632px;
    margin-left: 200px;
    /*background-color: #f5f5f5;*/
    /*border: 1px solid red;*/
  }
  .addButton{
    margin-top: 5px;
    margin-left: 20px;
  }
  .card-table-card{
    width: 100%;
    height: 477px;
    margin-top: 11px;
    /*border: 1px solid red;*/
  }
  .pagination{
    /*border: 1px solid red;*/
  }
  .pagination-body{
    text-align: center;
    width: 500px;
    margin-left: 180px;
    margin-top: 5px;
    margin-bottom: 5px;
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
  .operate-button-1{
    margin-left: 25px;
    width: 60px;
  }
  .operate-button-2{
    margin-left: 25px;
    width: 60px;
    /*background-color: #ff6600;*/
    /*border-color: #ff6600;*/
  }
</style>
