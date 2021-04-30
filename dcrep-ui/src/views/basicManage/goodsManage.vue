<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="main-body">
          <!--添加Goods按钮-->
          <div class="addButton">
            <el-button type="success" @click="dialogFormVisible = true">添加</el-button>
            <!--添加Goods模态框-->
            <div>
              <el-dialog title="添加客户" :visible.sync="dialogFormVisible" @close="resetForm('addGoodsform')">
                <el-form key="addGoods" :model="addGoodsform" ref="addGoodsform" style="width: 670px">
                  <el-form-item label="商品名称" prop="gname" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.gname" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="商品产地" prop="produceplace" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.produceplace" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item  label="商品规格" prop="size" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.size" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="商品包装" prop="gpackage" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.gpackage" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="生成批号" prop="productcode" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.productcode" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="批准文号" prop="promitcode" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.promitcode" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="商品描述" prop="description" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.description" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="商品价格" prop="price" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.price" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="库存数量" prop="number" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.number" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="库存预警" prop="dangernum" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.dangernum" autocomplete="off"></el-input>
                  </el-form-item>
<!--                  <el-form-item label="图片" prop="gimg" :label-width="formLabelWidth">-->
<!--                    <el-input type="text" v-model="addGoodsform.gimg" autocomplete="off"></el-input>-->
<!--                  </el-form-item>-->
                  <el-form-item label="是否有效" prop="available" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.available" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="供货商" prop="pid" :label-width="formLabelWidth">
                    <el-input type="text" v-model="addGoodsform.pid" autocomplete="off"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="resetForm('addGoodsform')">重 置</el-button>
                  <el-button type="primary" @click="addGoods">提 交</el-button>
                </div>
              </el-dialog>
            </div>
          </div>
          <!--批量删除按钮-->
          <div class="delGoodsListButton">
            <el-button type="danger" plain @click="delGoods">批量删除</el-button>
          </div>
          <!--搜索框-->
          <div class="search">
            <el-input
              placeholder="请输入商品名称/产地"
              prefix-icon="el-icon-search"
              @keyup.enter.native="searchGoods(search)"
              v-model="search">
            </el-input>
          </div>
          <!--搜索按钮-->
          <div class="search-button">
            <el-button type="primary" style="width: 100px;" @click="searchGoods(search)">搜索</el-button>
          </div>
          <!--供应商选择器-->
          <div class="dropdown">
            <el-dropdown>
              <span class="el-dropdown-link">
                <el-button >{{providerTitle}}<i class="el-icon-arrow-down el-icon--right"></i></el-button>
              </span>
              <el-dropdown-menu slot="dropdown" >
                <el-dropdown-item @click.native="getGoodsList">所有商品</el-dropdown-item>
                <el-dropdown-item v-for="(value, key) in providerName" :key="key" @click.native="getGoodsByPid(key,value)">{{value}}</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
          <el-card class="card-table-body">
            <!--Goods列表-->
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
                prop="gid"
                label="ID"
                width="60"
              >
              </el-table-column>
              <el-table-column
                prop="gname"
                label="商品名称"
                width="220"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="produceplace"
                label="商品产地"
                width="125"
              >
              </el-table-column>
              <el-table-column
                prop="size"
                label="商品规格"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="price"
                label="商品价格"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="number"
                label="商品库存"
                width="125"
              >
              </el-table-column>
              <el-table-column
                prop="dangernum"
                label="预警库存"
                width="125"
                show-overflow-tooltip
              >
              </el-table-column>
              <el-table-column
                prop="available"
                label="是否有效"
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
                  <el-button class="operate-button-1" type="danger" size="small" @click="delMessage(scope.row.gid)">删除</el-button>

                  <el-button class="operate-button-1" type="info" size="small" @click="updateGoods_getGoods(scope.row.gid)" >修改</el-button>
                    <!--修改Goods模态框-->
                    <el-dialog title="修改商品" :visible.sync="dialogFormVisible2" style="margin-top: -100px">

                      <el-form key="updateGoods" :model="updateGoodsform" ref="updateGoodsform"
                               style="width: 670px;">
                        <el-form-item class="form-item" label="供应商" prop="pid" :label-width="formLabelWidth">
                          <el-select class="form-item-input" filterable v-model="updateGoodsform.pid" placeholder="请选择">
                            <el-option style="height: auto" v-for="(value, key) in providerName" :key="key" :value="value">

                            </el-option>
                          </el-select>
                        </el-form-item>
  <!--                      <el-form-item class="form-item-img" prop="gimg">-->
  <!--                        <img class="form-item-img-img"  v-bind:src="updateGoodsform.gimg">-->
  <!--                      </el-form-item>-->
                        <el-form-item class="form-item" style="height: 43px;" label="商品名称" prop="gname" :label-width="formLabelWidth">
                          <el-input class="form-item-input" type="text" v-model="updateGoodsform.gname" autocomplete="off">
                          </el-input>
                        </el-form-item>
                        <el-form-item class="form-item" label="商品描述" prop="description" :label-width="formLabelWidth" >
                          <el-input
                            class="form-item-input"
                            type="textarea"
                            rows="3"
                            :autosize="{ minRows: 1, maxRows: 3}"
                            placeholder="请输入内容"
                            v-model="updateGoodsform.description"
                          >
                          </el-input>
                        </el-form-item>
                        <el-form-item class="form-item2" label="产地" prop="produceplace" :label-width="formLabelWidth">
                          <el-input class="form-item-input2" type="text" v-model="updateGoodsform.produceplace" autocomplete="off">
                          </el-input>
                        </el-form-item>
                        <el-form-item class="form-item2" label="规格" prop="size" :label-width="formLabelWidth">
                          <el-input class="form-item-input2" type="text" v-model="updateGoodsform.size" autocomplete="off" style="width: 220px;">
                          </el-input>
                        </el-form-item>
                        <el-form-item class="form-item2" label="比准文号" prop="promitcode" :label-width="formLabelWidth">
                          <el-input class="form-item-input2" type="text" v-model="updateGoodsform.promitcode" autocomplete="off" style="width: 220px;">
                          </el-input>
                        </el-form-item>
                        <el-form-item class="form-item2" label="库存量" prop="number" :label-width="formLabelWidth">
                          <el-input class="form-item-input2" type="text" v-model="updateGoodsform.number" autocomplete="off" style="width: 220px;">
                          </el-input>
                        </el-form-item>
                        <div class="form-item3-body">
                          <el-form-item class="form-item3" label="包装" prop="gpackage" :label-width="formLabelWidth">
                            <el-input class="form-item-input3" type="text" v-model="updateGoodsform.gpackage" autocomplete="off" style="width: 220px;">
                            </el-input>
                          </el-form-item>
                          <el-form-item class="form-item3" label="生产批号" prop="productcode" :label-width="formLabelWidth">
                            <el-input class="form-item-input3" type="text" v-model="updateGoodsform.productcode" autocomplete="off" style="width: 220px;">
                            </el-input>
                          </el-form-item>
                          <el-form-item class="form-item3" label="销售价格" prop="productcode" :label-width="formLabelWidth">
                            <el-input class="form-item-input3" type="text" v-model="updateGoodsform.productcode" autocomplete="off" style="width: 220px;">
                            </el-input>
                          </el-form-item>
                          <el-form-item class="form-item3" label="库存预警" prop="productcode" :label-width="formLabelWidth">
                            <el-input class="form-item-input3" type="text" v-model="updateGoodsform.productcode" autocomplete="off" style="width: 220px;">
                            </el-input>
                          </el-form-item>
                        </div>
                        <el-form-item label="是否有效" prop="available" :label-width="formLabelWidth">
                          <el-radio v-model="updateGoodsform.available" label="1">有效</el-radio>
                          <el-radio v-model="updateGoodsform.available" label="0">无效</el-radio>
                        </el-form-item>
                      </el-form>
                      <div slot="footer" class="dialog-footer" style="margin-top: -50px;">
                        <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                        <el-button type="warning" @click="updateGoods_updateGoods(updateGoodsform.gid)">提交</el-button>
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
        name: "goodsManage",
        components: {breadcrumb,},

        data (){
            return {
                GoodsList: null,
                GoodOne: null,
                status: 0,
                gid: 0,
                dialogFormVisible: false,
                dialogFormVisible2: false,
                search: '',
                providerName: [],
                providerTitle:'',
                providerNameOne:'',
                tableData: [],
                multipleSelection: [],
                pagination: {
                    total: 0,
                    pageNum: 1,
                    currenPage: 1,
                    pageSize: 9
                },
                //添加Goods输入框宽度
                formLabelWidth: '120px',
                addGoodsform: {
                    gname: '',
                    produceplace: '',
                    size: '',
                    gpackage: '',
                    productcode: '',
                    promitcode: '',
                    description: '',
                    price: '',
                    number: '',
                    dangernum: '',
                    gimg: '',
                    available: '',
                    pid: '',
                },
                updateGoodsform:{
                    gname: '',
                    produceplace: '',
                    size: '',
                    gpackage: '',
                    productcode: '',
                    promitcode: '',
                    description: '',
                    price: '',
                    number: '',
                    dangernum: '',
                    gimg: '',
                    available: '',
                    pid: '',
                    pname:'',
                },
            }
        },

        methods: {
            handleSelectionChange(val) {
                this.multipleSelection = val;
                // console.log(this.multipleSelection)
            },
            getGoodsList() {
                this.$axios({
                    method: "get",
                    url: '/Goods/goodsList',
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        this.GoodsList = response.data.data
                        // console.log(this.GoodsList)
                        this.tableData = response.data.data
                        this.pagination.total = this.GoodsList.length
                        this.providerTitle = '供应商'
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
            //重置添加商品表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //添加商品
            addGoods(){
                let _this = this;
                let addGoodsform = {
                    gname: _this.addGoodsform.gname,
                    produceplace: _this.addGoodsform.produceplace,
                    size: _this.addGoodsform.size,
                    gpackage: _this.addGoodsform.gpackage,
                    productcode: _this.addGoodsform.productcode,
                    promitcode: _this.addGoodsform.promitcode,
                    description: _this.addGoodsform.description,
                    price: _this.addGoodsform.price,
                    number: _this.addGoodsform.number,
                    dangernum: _this.addGoodsform.dangernum,
                    gimg: _this.addGoodsform.gimg,
                    available: _this.addGoodsform.available,
                    pid: _this.addGoodsform.pid,
                }
                // console.log(addGoodsform)
                this.$axios({
                    method: "post",
                    url: '/Goods/addGoods',
                    data: addGoodsform,
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        _this.getGoodsList()
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
            //删除Goods
            async delMessage(gid) {
                let _this = this
                // console.log(gid)
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
                    gid: gid
                }
                //删除Goods
                //这里的delete还是没有解决,只能用post代替
                this.$axios({
                    method: "post",
                    url: '/Goods/delGoods',
                    data: _this.$qs.stringify(da)
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        this.getGoodsList()
                        this.$message.success('删除成功')
                    } else {
                        return this.$message.error('删除失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //批量删除Goods
            async delGoods(){
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
                        url: '/Goods/delGoodsList',
                        data: list,
                    }).then((response) => {
                        // console.log(response.data)
                        if (response.data.code === 1) {
                            _this.getGoodsList()
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
            searchGoods(search){
                let _this = this
                if(search!='' && search!=' '){
                    let da = {
                        key: search
                    }
                    this.$axios({
                        method: "post",
                        url: '/Goods/goodsListByKey',
                        data: _this.$qs.stringify(da)
                    }).then((response) => {
                        this.status = response.data.code
                        if (this.status === 1) {
                            this.GoodsList = response.data.data
                            // console.log(this.GoodsList)
                            this.tableData = response.data.data
                            this.pagination.total = this.GoodsList.length
                        } else {
                            return this.$message.error('商品列表失败')
                        }
                    }).catch(function (error) {
                        console.log(error)
                    });
                }else {
                    return this.$message.error('输入不能为空')
                }
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
            //值寻键
            getByValue(map, searchValue) {
                for (var key in map) {
                    if (map[key] == searchValue)
                        return key;
                }
            },
            //供应商name查询goods
            getGoodsByPid(pid,title){
                this.providerTitle = title
                this.$axios({
                    method: "post",
                    url: '/Goods/goodsListByPid',
                    params:{
                        pid:pid
                    }
                }).then((response) => {
                    this.status = response.data.code
                    if (this.status === 1) {
                        // console.log(response.data)
                        this.GoodsList = response.data.data
                        // console.log(this.GoodsList)
                        this.tableData = response.data.data
                        this.pagination.total = this.GoodsList.length
                    } else {
                        return this.$message.error('获取商品列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            //更新供应商前得到商品信息
            updateGoods_getGoods(gid){
                // console.log(gid)
                this.$axios.get('/Goods/oneGoods', {
                    params: {
                        gid: gid,
                    }
                }).then((response) => {
                    // console.log(response.data)
                    if (response.data.code === 1) {
                        // console.log(response.data)
                        this.updateGoodsform = response.data.data
                        this.updateGoodsform.available = response.data.data.available.toString()
                        //id换name
                        this.updateGoodsform.pid = this.providerName[this.updateGoodsform.pid]
                        // console.log(this.updateGoodsform.pid)
                        // console.log(this.updateGoodsform)
                    } else {
                        return this.$message.error('查询商品信息失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
                this.dialogFormVisible2 = true
            },
            //更新商品
            updateGoods_updateGoods(gid){
                let _this = this;
                let updateGoodsform = {
                    gname: _this.updateGoodsform.gname,
                    produceplace: _this.updateGoodsform.produceplace,
                    size: _this.updateGoodsform.size,
                    gpackage: _this.updateGoodsform.gpackage,
                    productcode: _this.updateGoodsform.productcode,
                    promitcode: _this.updateGoodsform.promitcode,
                    description: _this.updateGoodsform.description,
                    price: _this.updateGoodsform.price,
                    number:  _this.updateGoodsform.number,
                    dangernum:  _this.updateGoodsform.dangernum,
                    gimg: _this.updateGoodsform.gimg,
                    available: _this.updateGoodsform.available,
                    pid: this.getByValue(this.providerName,_this.updateGoodsform.pid),
                }
                // console.log(updateGoodsform)
                this.$axios({
                    method: 'put',
                    url: '/Goods/updateGoods',
                    params: {gid: gid},
                    data: updateGoodsform
                }).then((response) => {
                        // console.log(response.data)
                        if (response.data.code === 1) {
                            _this.getGoodsList()
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
            this.getGoodsList()
            this.getProviderName()
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
  .delGoodsListButton{
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
  .dropdown{
    margin-left: 1150px;
    margin-top: -40px;
    line-height: 28px;
    width: 100px;
  }
  .card-table-body{
    border: none;
    /*margin-top: 80px;*/
    margin-top: 14px;
  }
  .form-item-img{
    /*border: 1px solid red;*/
    margin-top: -65px;
    margin-right: -30px;
    float: right;
  }
  .form-item-img-img{
    width: 230px;
    height: 230px;
  }
  .form-item{
    width: 450px;
  }
  .form-item-input{
    width: 320px;
  }
  .form-item2{
    width: 340px;
  }
  .form-item-input2{
    width: 220px;
  }
  .form-item3-body{
    width: 340px;
    margin-right: -30px;
    margin-top: -248px;
    float: right;
  }
  .form-item3{
    width: 340px;
  }
  .form-item-input3{
    width: 220px;
  }
  .operate-button-1{
    margin-left: 20px;
    /*width: 60px;*/
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
