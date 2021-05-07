<template>
    <div>
      <div class="body">
        <el-card class="card-body" style="border-radius: 0px;">
          <breadcrumb />
          <div class="treeDept">
<!--            部门树-->
            <el-tree class="treeDeptList"
                     :data="treeData"
                     :props="defaultProps"
                     default-expand-all
                     @node-click="handleNodeClick"
            >
            </el-tree>
          </div>
          <div class="card-table">
            <div class="addButton">
              <el-button type="success" @click="dialogFormVisible = true">添加</el-button>
            </div>
<!--            添加部门模态框-->
            <div>
              <el-dialog title="添加部门" :visible.sync="dialogFormVisible" @close="resetForm('addDeptform')">
                <el-form key="addDept" :model="addDeptform" ref="addDeptform" :rules="addDeptRules" style="width: 670px">
                  <el-form-item label="父级部门ID" prop="dpid" :label-width="formLabelWidth">
                    <el-input-number v-model="addDeptform.dpid" :min="1" :max="10" autocomplete="off"></el-input-number>
                  </el-form-item>
                  <el-form-item label="部门名称" prop="dtitle" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addDeptform.dtitle" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item  label="部门说明" prop="dremark" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addDeptform.dremark" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="部门地址" prop="daddress" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addDeptform.daddress" autocomplete="off"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="resetForm('addDeptform')">重 置</el-button>
                  <el-button type="primary" @click="addDept">提 交</el-button>
                </div>
              </el-dialog>
            </div>
<!--            部门表格-->
            <el-card class="card-table-card">
              <el-table
                :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
                height="500"
                border
                style="width: 100%;font-size: 16px;"
                size="small"

              >
                <el-table-column
                  prop="did"
                  label="ID"
                  width="140px"
                  >
                </el-table-column>
                <el-table-column
                  prop="dpid"
                  label="部门编号"
                  width="140px"
                >
                </el-table-column>
                <el-table-column
                  prop="dtitle"
                  label="部门名称"
                  width="140px"
                >
                </el-table-column>
                <el-table-column
                  prop="dremark"
                  label="部门说明"
                  width="140px"
                >
                </el-table-column>
                <el-table-column
                  prop="daddress"
                  label="部门地址"
                  width="140px"
                 >
                </el-table-column>
                <el-table-column
                  prop="dcreatetime"
                  label="成立日期"
                  width="140px"
                >
                </el-table-column>
                <el-table-column
                  prop=""
                  label="操作"
                >
                  <!--数据插槽获取行数据id-->
                  <template slot-scope="scope">
                    <el-button class="operate-button-1" type="danger" size="small" @click="delMessage(scope.row.did)">删除</el-button>

                    <el-button class="operate-button-2" type="info" size="small" @click="updateDept_getDept(scope.row.did)" >修改</el-button>
                      <!--修改部门模态框-->
                      <el-dialog title="修改部门" :visible.sync="dialogFormVisible2">
                        <el-form key="updateDept" :model="updateDeptform" ref="updateDeptform"
                                 :rules="addDeptRules" style="width: 670px">
                          <el-form-item label="父级部门ID" prop="dpid" :label-width="formLabelWidth">
                            <el-input-number v-model="updateDeptform.dpid" :min="1" :max="10" autocomplete="off">
                            </el-input-number>
                          </el-form-item>
                          <el-form-item label="部门名称" prop="dtitle" :label-width="formLabelWidth">
                            <el-input type="text" v-model="updateDeptform.dtitle" autocomplete="off">

                            </el-input>
                          </el-form-item>
                          <el-form-item  label="部门说明" prop="dremark" :label-width="formLabelWidth">
                            <el-input type="text" v-model="updateDeptform.dremark" autocomplete="off">

                            </el-input>
                          </el-form-item>
                          <el-form-item label="部门地址" prop="daddress" :label-width="formLabelWidth">
                            <el-input type="text" v-model="updateDeptform.daddress" autocomplete="off">

                            </el-input>
                          </el-form-item>
                        </el-form>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                          <el-button type="warning" @click="updateDept_updateDept(addDeptform.did)">提交</el-button>
                        </div>
                      </el-dialog>
                  </template>
                </el-table-column>
              </el-table>
            </el-card>
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
      <div class="footer">
        <div class="footer-title">CopyRight-DataSupermacy-Y @2021</div>
      </div>
    </div>
</template>

<script>
    import breadcrumb from "../../components/system/breadcrumb";
    export default {
        name: "departmentManage",
        components: {breadcrumb,},
        data(){
            //添加部门-表单校验规则
            // var validateDpid = (rule, value, callback) => {
            //     if (value === '') {
            //         callback(new Error('用户名不能为空'));
            //     }else if (value < 1){
            //         callback(new Error('父级ID不能小于1'));
            //     }
            // };
            var validateDtitle = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('部门名称不能为空'));
                }
            };
            var validatedremark = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('部门说明不能为空'));
                } else if (value.length >30){
                    callback(new Error('部门说明长度不能超过30字'))
                }
            };
            var validatedAddress = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('部门地址不能为空'));
                }
            };
            return{
                departmentList:null,
                departmentOne:null,
                status:0,
                dpid:0,
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
                pagination:{
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
                addDeptform: {
                    dpid: '',
                    dtitle:'',
                    dremark:'',
                    daddress:'',
                },
                //输入框宽度
                formLabelWidth: '120px',
                //添加部门-表单校验规则数组
                addDeptRules: {
                    // dpid:[{ validator: validateDpid, trigger: 'blur' }],
                    dtitle:[{ validator: validateDtitle, trigger: 'blur' }],
                    dremark:[{ validator: validatedremark, trigger: 'blur' }],
                    daddress:[{ validator: validatedAddress, trigger: 'blur' }],
                },
                //修改部门表单
                updateDeptform: {
                    dpid: '',
                    dtitle:'',
                    dremark:'',
                    daddress:'',
                },
            }
        },
        methods:{
            //获取部门信息List
            getDepartmentList(){
                this.$axios({
                    method: "get",
                    url: '/Dept/deptList',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1){
                        this.departmentList = response.data.data
                        this.tableData = response.data.data
                        this.pagination.total = this.departmentList.length
                    } else {
                        return this.$message.error('查询部门列表失败')
                    }
                }).catch(function (error){
                    console.log(error)
                });
            },
            //点击部门树标题查询部门信息，未完成
            handleNodeClick(data) {
                // console.log(data);
                let _this = this;
                // let dpid = {
                //     dpid: data.dpid,
                // }
                // console.log(dpid)
                // this.$axios({
                //     method: "post",
                //     url: 'http://localhost:8080/Dept/moreDept',
                //     data: _this.$qs.stringify(dpid),
                // }).then((response) => {
                //     console.log(response.data)
                //      this.departmentOne = response.data
                // }).catch(function (error){
                //     console.log(error)
                // });
            },
            //获取部门信息树
            getTreeData(){
                this.$axios({
                    method: "get",
                    url: '/Dept/deptTree',
                }).then((response) => {
                    if (response.data!=null){
                        this.treeData = response.data
                        // let _departmentList = JSON.stringify(this.departmentList)
                        // console.log(response.data)
                    } else {
                        return this.$message.error('获取部门树失败')
                    }
                }).catch(function (error){
                    console.log(error)
                });
            },
            //分页:pageSize改变
            handleSizeChange(newSize){
                this.pagination.pageSize = newSize
                // this.getDepartmentList()
            },
            //分页:pageNum改变
            handleCurrentChange(newPage){
                this.pagination.pageNum = newPage
                // this.getDepartmentList()
            },
            //添加部门
            addDept(){
                let _this = this;
                let dept = {
                    dpid : _this.addDeptform.dpid,
                    dtitle : _this.addDeptform.dtitle,
                    dremark : _this.addDeptform.dremark,
                    daddress : _this.addDeptform.daddress,
                }
                // console.log(dept)
                this.$axios({
                    method: "post",
                    url: '/Dept/addDept',
                    data: dept,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1){
                        _this.getTreeData()
                        _this.getDepartmentList()
                        this.dialogFormVisible = false
                        return this.$message.success('添加成功')
                    }else {
                        return this.$message.error('添加失败')
                    }
                    _this.dialogFormVisible = false;
                }).catch(function (error){
                    console.log(error)
                });
            },
            //重置添加部门表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //删除提示
            async delMessage(did) {
                let _this = this
                // console.log(did)
                const confirmResult = await
                this.$confirm('删除该信息, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).catch(error => error)

                if(confirmResult!='confirm'){
                    return this.$message.info('已取消删除')
                }
                let da = {
                    did: did
                }
                //删除部门
                //这里的delete还是没有解决,只能用post代替
                this.$axios({
                    method: "post",
                    url: '/Dept/delDEPT',
                    data: _this.$qs.stringify(da)
                }).then((response) => {
                    // console.log(response.data)
                    if(response.data.code === 1){
                        this.getDepartmentList()
                        this.getTreeData()
                        this.$message.success('删除成功')
                    }else {
                        return this.$message.error('删除失败')
                    }
                }).catch(function (error){
                    console.log(error)
                });
            },
            //获得一条dept，不与数据库交互，直接访问departmentList
            updateDept_getDept(did){
                // console.log(did)
                // console.log(this.departmentList)
                this.$axios.get('/Dept/oneDept', {
                    params: {
                        did: did,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if(response.data.code === 1){
                        // console.log(response.data)
                        this.updateDeptform = response.data.data
                        // console.log(this.updateDeptform)
                    }else {
                        return this.$message.error('查询部门信息失败')
                    }
                }).catch(function (error){
                    console.log(error)
                });
                this.dialogFormVisible2=true
            },
            updateDept_updateDept(did){
                let _this = this;
                let updatedept = {
                    dpid : _this.updateDeptform.dpid,
                    dtitle : _this.updateDeptform.dtitle,
                    dremark : _this.updateDeptform.dremark,
                    daddress : _this.updateDeptform.daddress,
                }
                  this.$axios({
                      method: 'put',
                      url: '/Dept/updateDept',
                      params: {did: did},
                      data: updatedept
                  })
                      .then((response) => {
                      // console.log(response.data)
                      if (response.data.code === 1){
                          _this.getTreeData()
                          _this.getDepartmentList()
                          this.dialogFormVisible2 = false
                          return this.$message.success('修改成功')
                      }else {
                          return this.$message.error('修改失败')
                      }
                      _this.dialogFormVisible = false;
                  }).catch(function (error){
                      console.log(error)
                  });
            },
        },
        mounted() {
            this.getDepartmentList();
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
    /*border: 1px solid red;*/
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
    margin-left: 35px;
    width: 80px;
  }
  .operate-button-2{
    margin-left: 35px;
    width: 80px;
    /*background-color: #ff6600;*/
    /*border-color: #ff6600;*/
  }
</style>
