<template>
    <div>
<!--注意这里的拦截问题没有解决，后端拦截器只放行dologin-->
      <navigation />
      <div class="body">

          <el-card class="card-body" style="border-radius: 0px;">
            <breadcrumb />
            <el-scrollbar class="scrollbar-body">
              <div class="main-body">
                <div class="dangernum">
                  <el-card class="stockTitle-card">
                    <div class="title">
                      <h3>库存预警</h3>
                    </div>
                  </el-card>
                  <el-table
                    :data="tableData.slice((pagination.pageNum-1)*pagination.pageSize,pagination.pageNum*pagination.pageSize)"
                    border
                    height="332"
                    tooltip-effect="light"
                    style="width: 100%;font-size: 16px;"
                    size="small">
                    <el-table-column
                      prop="gid"
                      label="ID"
                      width="60"
                    >
                    </el-table-column>
                    <el-table-column
                      prop="gname"
                      label="商品名称"
                      width="143"
                      show-overflow-tooltip
                    >
                    </el-table-column>
                    <el-table-column
                      prop="number"
                      label="库存剩余"
                      width="143"
                    >
                    </el-table-column>
                    <el-table-column
                      prop="dangernum"
                      label="紧急阈值"
                      width="138"
                      show-overflow-tooltip
                    >
                    </el-table-column>

                    <el-table-column
                      prop=""
                      label="操作"
                      width="136"
                    >
                      <!--表格中的操作-->
                      <template slot-scope="scope">
                        <el-button class="operate-button-1" @click="dialogFormVisible = true" type="success" size="small">进货</el-button>
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
                      </template>
                    </el-table-column>
                  </el-table>
                  <!--分页-->
                  <el-card class="pagination">
                    <el-pagination
                      class="pagination-body"
                      @size-change="handleSizeChange"
                      @current-change="handleCurrentChange"
                      :current-page="pagination.pageNum"
                      :page-sizes="[6, 12, 18, 24]"
                      :page-size="pagination.pageSize"
                      layout="total, prev, pager, next, jumper"
                      :total="pagination.total"
                      ref="pagination"
                    >
                    </el-pagination>
                  </el-card>
                </div>
                <div class="stock">
                  <el-card class="houseTitle-card">
                    <div class="title">
                      <h3>仓库余量</h3>
                    </div>
                  </el-card>
                  <div class="houseBody-card">
                    <div class="houseItem1">
                      <el-progress type="dashboard" :percentage="percentage1" :color="colors"></el-progress>

                      <div class="houseName">
                        1号仓库
                      </div>

                      <el-button class="houseButton" type="primary" size="small ">剩余:{{this.houseMargin1}}%</el-button>
                    </div>
                    <div class="houseItem2">
                      <el-progress type="dashboard" :percentage="percentage2" :color="colors"></el-progress>

                      <div class="houseName">
                        2号仓库
                      </div>

                      <el-button class="houseButton" type="primary" size="small ">剩余:{{this.houseMargin2}}%</el-button>
                    </div>
                    <div class="houseItem3">
                      <el-progress type="dashboard" :percentage="percentage3" :color="colors"></el-progress>

                      <div class="houseName">
                        3号仓库
                      </div>

                      <el-button class="houseButton" type="primary" size="small ">剩余:{{this.houseMargin3}}%</el-button>
                    </div>
                    <div class="houseItem4">
                      <el-progress type="dashboard" :percentage="percentage4" :color="colors"></el-progress>

                      <div class="houseName">
                       4号仓库
                      </div>

                      <el-button class="houseButton" type="primary" size="small ">剩余:{{this.houseMargin4}}%</el-button>
                    </div>
                    <div class="houseItem5">
                      <el-progress type="dashboard" :percentage="percentage5" :color="colors"></el-progress>

                      <div class="houseName">
                        5号仓库
                      </div>

                      <el-button class="houseButton" type="primary" size="small ">剩余:{{this.houseMargin5}}%</el-button>
                    </div>
                    <div class="houseItem6">
                      <el-progress type="dashboard" :percentage="percentage6" :color="colors"></el-progress>

                      <div class="houseName">
                        6号仓库
                      </div>

                      <el-button class="houseButton" type="primary" size="small ">剩余:{{this.houseMargin6}}%</el-button>
                    </div>
                    <div class="houseItem7">
                      <el-progress type="dashboard" :percentage="percentage7" :color="colors"></el-progress>

                      <div class="houseName">
                        7号仓库
                      </div>

                      <el-button class="houseButton" type="primary" size="small ">剩余:{{this.houseMargin7}}%</el-button>
                    </div>
                  </div>
                </div>
                <div class="salesAnalysis">
                  <el-card class="Analysis-card">
                    <div class="title">
                      <el-select class="recentYearsSelect" v-model="ryear" clearable placeholder="请选择">
                        <el-option style="height: auto" v-for="(value,index) in recentYears" :key="index" :value="value" @click.native="getAnalysisSales(value)">

                        </el-option>
                      </el-select>
                      <div class="title-body"><h3>年度销售统计</h3></div>
                    </div>
                  </el-card>
                  <div id="salesLineGraphs" class="salesLineGraphs">

                  </div>
                  <el-card class="Analysis-card">
                    <div class="title">
                      <el-select class="recentYearsSelect" v-model="ryear2" clearable placeholder="请选择">
                        <el-option style="height: auto" v-for="(value,index) in recentYears2" :key="index" :value="value" @click.native="getAnalysisSalesBack(value)">

                        </el-option>
                      </el-select>
                      <div class="title-body"><h3>年度销售退货统计</h3></div>
                    </div>
                  </el-card>
                  <div id="salesBackLineGraphs" class="salesLineGraphs">

                  </div>
                </div>
              </div>
    <!--            上传按钮-->
    <!--          <div class="button">-->
    <!--            <input class="file" name="file" type="file" @change="update"/>-->
    <!--          </div>-->
            </el-scrollbar>
          </el-card>

      </div>
      <div class="footer">
        <div class="footer-title">CopyRight-DataSupermacy-Y @2021</div>
      </div>
    </div>
</template>

<script>
  import navigation from "../components/system/navigation";
  import breadcrumb from "../components/system/breadcrumb";
    export default {
        name: "index",
        components: {navigation,breadcrumb},

        data(){
          return{
              DangerNumGoodsList: null,
              HouseList: [],
              tableData: [],
              gid: 0,
              pagination: {
                  total: 0,
                  pageNum: 1,
                  currenPage: 1,
                  pageSize: 6
              },
              percentage1: 0,
              houseMargin1: 0,
              percentage2: 0,
              houseMargin2: 0,
              percentage3: 0,
              houseMargin3: 0,
              percentage4: 0,
              houseMargin4: 0,
              percentage5: 0,
              houseMargin5: 0,
              percentage6: 0,
              houseMargin6: 0,
              percentage7: 0,
              houseMargin7: 0,
              colors: [
                  {color: '#1989fa', percentage: 20},
                  {color: '#6f7ad3', percentage: 40},
                  {color: '#5cb87a', percentage: 60},
                  {color: '#e6a23c', percentage: 80},
                  {color: '#f56c6c', percentage: 100}
              ],
              goodsName:[],
              gname:'',
              providerName: [],
              pname:'',
              houseName:[],
              sname:'',
              dialogFormVisible: false,
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
              title:[],
              recentYears:[],
              recentYears2:[],
              ryear:this.ryear,
              ryear2:this.ryear2,
              CurrentTime: '',
              lastYear:'',
              salestime:'',
              AnalysisSales:{},
              AnalysisSalesBack:{},
          }
        },
        methods:{
            //上传
            // update(e){
            //     let file = e.target.files[0];
            //     let param = new FormData(); //创建form对象
            //     param.append('fileName',file);//通过append向form对象添加数据
            //     console.log(param.get('fileName')); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
            //     let config = {
            //         headers:{'Content-Type':'multipart/form-data'} //这里是重点，需要和后台沟通好请求头，Content-Type不一定是这个值
            //     };
            //     this.$axios.post('http://127.0.0.1:8079/Dept/upLoad',param,config)
            //         .then(response=>{
            //             console.log(response.data);
            //         })
            // },
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
            getDangerNumGoods() {
                this.$axios({
                    method: "get",
                    url: '/Index/findDangerNumGoods',
                }).then((response) => {
                    if (response.data.code === 1) {
                        this.DangerNumGoodsList = response.data.data
                        // console.log(this.DangerNumGoodsList)
                        this.tableData = response.data.data
                        this.pagination.total = this.tableData.length
                    } else {
                        return this.$message.info('查询库存紧张商品列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
            },
            getHouse(){
                this.$axios({
                    method: "get",
                    url: '/Index/findAllHouse',
                }).then((response) => {
                    if (response.data.code === 1) {
                        this.HouseList = response.data.data
                        // console.log(this.HouseList)
                        this.percentage1 = parseFloat(((1000-this.HouseList[0].margin)/10).toFixed(2))
                        this.houseMargin1 = parseFloat(((this.HouseList[0].margin)/10).toFixed(2))
                        // console.log(this.percentage1)
                        this.percentage2 = parseFloat(((1000-this.HouseList[1].margin)/10).toFixed(2))
                        this.houseMargin2 = parseFloat(((this.HouseList[1].margin)/10).toFixed(2))
                        this.percentage3 = parseFloat(((1000-this.HouseList[2].margin)/10).toFixed(2))
                        this.houseMargin3 = parseFloat(((this.HouseList[2].margin)/10).toFixed(2))
                        this.percentage4 = parseFloat(((1000-this.HouseList[3].margin)/10).toFixed(2))
                        this.houseMargin4 = parseFloat(((this.HouseList[3].margin)/10).toFixed(2))
                        this.percentage5 = parseFloat(((1000-this.HouseList[4].margin)/10).toFixed(2))
                        this.houseMargin5 = parseFloat(((this.HouseList[4].margin)/10).toFixed(2))
                        this.percentage6 = parseFloat(((1000-this.HouseList[5].margin)/10).toFixed(2))
                        this.houseMargin6 = parseFloat(((this.HouseList[5].margin)/10).toFixed(2))
                        this.percentage7 = parseFloat(((1000-this.HouseList[6].margin)/10).toFixed(2))
                        this.houseMargin7 = parseFloat(((this.HouseList[6].margin)/10).toFixed(2))
                    } else {
                        return this.$message.error('查询仓库列表失败')
                    }
                }).catch(function (error) {
                    console.log(error)
                });
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
                        this.dialogFormVisible = false
                        // return this.$message.success('添加成功')
                        const h = this.$createElement;
                        this.$notify({
                            title: '成功',
                            dangerouslyUseHTMLString: true,
                            message: h('p', null, [
                                h('a',
                                    ['添加进货成功，是否退货管理查看？',
                                        h('el-button', {
                                            style: {
                                                marginTop: '5px'
                                            },
                                            attrs: {
                                                size: 'small',
                                                type: 'primary'
                                            },
                                            on: {
                                                click: this.toPurchase // 路由加载之后，调用关闭消息弹窗的方法
                                            },
                                        }, '确定')
                                    ],
                                ),
                            ]),
                            type : 'success'
                        });
                    } else if(response.data.code === -2) {
                        return this.$message.error('本仓库余量不足,请选择其他仓库！！！')
                    } else if (response.data.code === -1)
                    return  this.$message.error('添加失败！！！')
                    _this.dialogFormVisible = false;
                }).catch(function (error) {
                    console.log(error)
                });
            },
            toPurchase() {
                this.$router.replace('/purchaseManage')
            },
            //值寻键
            getByValue(map, searchValue) {
                for (var key in map) {
                    if (map[key] == searchValue)
                        return key;
                }
            },
            //获取当前时间
            getCurrentDate(){
                const nowDate = new Date();
                const date = {
                    year: nowDate.getFullYear(),
                    month: nowDate.getMonth() + 1,
                    date: nowDate.getDate(),
                }
                const newmonth = date.month>10?date.month:'0'+date.month
                const day = date.date>10?date.date:'0'+date.date
                this.CurrentTime = date.year + '-' + newmonth + '-' + day
                this.lastYear = (date.year-1)
                // console.log(this.lastYear)
                // console.log(this.CurrentTime)
            },
            //获取近五年
            getrecentYears(){
                if (this.ryear==null ){
                    this.ryear = this.lastYear
                }
                if (this.ryear2==null){
                    this.ryear2 = this.lastYear
                }
                const nowDate = new Date();
                this.recentYears.push(nowDate.getFullYear())
                this.recentYears2.push(nowDate.getFullYear())
                for (let i = 1; i < 5; i++) {
                    this.recentYears.push(nowDate.getFullYear()-i)
                    this.recentYears2.push(nowDate.getFullYear()-i)
                }
                // console.log(this.recentYears)
            },
            //销售折线图
            async getAnalysisSales(salestime){
                let myChart = this.$echarts.getInstanceByDom(document.getElementById('salesLineGraphs'))
                if(myChart == null){
                    myChart = this.$echarts.init(document.getElementById('salesLineGraphs'))
                }
                let option = {
                    title: {
                        text: '销售统计折线图'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: []
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {
                                name: '销售折线图',
                            }
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
                    },
                    yAxis: {
                        type: 'value',
                    },
                    series: []
                };
                myChart.setOption(option)
                // salestime = salestime || this.lastYear
                // console.log(salestime)
                if (salestime!=null){
                  await this.$axios({
                      method: "post",
                      url: '/Index/AnalysisSales',
                      params:{
                          salestime:salestime
                      }
                  }).then((response) => {
                      if (response.data.code=== 1) {
                          // console.log(response.data)
                          this.AnalysisSales = response.data.data
                          // console.log(this.AnalysisSales)
                          var Item = function() {
                              return {
                                  name: '',
                                  type: 'line',
                                  data: []
                              }
                          };
                          var legends = [];// 准备存放图例数据
                          var series = []; // 准备存放图表数据

                          for (let i = 0; i < this.AnalysisSales.length; i++) {
                              var it = new Item();
                              legends.push(this.AnalysisSales[i][1])
                              it.name = this.AnalysisSales[i][1]
                              it.data = this.AnalysisSales[i][2]
                              series.push(it)
                          }
                          option.legend.data = legends
                          option.series = series
                          myChart.setOption(option,true)
                      }
                      else {
                          return this.$message.error('数据加载失败！！！')
                      }
                  }).catch(function (error) {
                      console.log(error)
                  });
                }else {
                    this.getAnalysisSales(this.lastYear)
                }
            },
            //销售退货折线图
            async getAnalysisSalesBack(salesbacktime){
                let myChart = this.$echarts.getInstanceByDom(document.getElementById('salesBackLineGraphs'))
                if(myChart == null){
                    myChart = this.$echarts.init(document.getElementById('salesBackLineGraphs'))
                }
                let option = {
                    title: {
                        text: '销售退货统计折线图'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: []
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: []
                };
                // salesbacktime = salesbacktime || this.lastYear
                // console.log(salesbacktime)
                if (salesbacktime!=null){
                  await this.$axios({
                      method: "post",
                      url: '/Index/AnalysisSalesBack',
                      params:{
                          salesbacktime:salesbacktime
                      }
                  }).then((response) => {
                      if (response.data.code=== 1) {
                          // console.log(response.data)
                          this.AnalysisSalesBack = response.data.data
                          // console.log(this.AnalysisSalesBack)
                          var Item = function() {
                              return {
                                  name: '',
                                  type: 'line',
                                  data: []
                              }
                          };

                          var legends = [];// 准备存放图例数据
                          var series = []; // 准备存放图表数据

                          for (let i = 0; i < this.AnalysisSalesBack.length; i++) {
                              var it = new Item();
                              legends.push(this.AnalysisSalesBack[i][1])
                              it.name = this.AnalysisSalesBack[i][1]
                              it.data = this.AnalysisSalesBack[i][2]
                              series.push(it)
                          }
                          option.legend.data = legends
                          option.series = series
                          myChart.setOption(option,true)
                      }
                      else {
                          return this.$message.error('数据加载失败！！！')
                      }
                  }).catch(function (error) {
                      console.log(error)
                  });
                }else {
                    this.getAnalysisSalesBack(this.lastYear)
                }
            }
        },
        mounted() {
            this.getDangerNumGoods()
            this.getHouse()
            this.getCurrentDate()
            this.getrecentYears()
            this.getAnalysisSalesBack()
            this.getAnalysisSales()
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
.scrollbar-body{
  height: 585px;
}
  .el-scrollbar__thumb{
    background-color: #7e848a;
  }

.body{
  margin-left: 214px;
  margin-right: -8px;
  margin-top: -181px;
}
.card-body{
  border: none;
}
  .button{
    margin-top: 30px;
    margin-bottom: 30px;
    margin-left: 30px;
  }
  .main-body{

  }
  .dangernum{
    /*border: 1px solid red;*/
    width: 621px;
    margin-left: 15px;
    float: left;
  }
  .title{
    margin-left: 20px;
  }
  .stockTitle-card{
    border-left: 5px solid #67c23a;
    width: 616px;
    height: 50px;
    border-radius: 0px;
    display: flex;
    justfy-content: center;
    align-items: center;
  }
  .operate-button-1{
    margin-left: 30px;
    /*width: 60px;*/
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
.pagination{

}
.pagination-body{
  text-align: center;
  width: 500px;
  margin-top: 5px;
  /*margin-top: 125px;*/
  margin-bottom: 5px;
  margin-left: 20px;
}
.stock{

  width: 643px;
  margin-top: 20px;
  margin-left: 650px;
}
.houseTitle-card{
  border-left: 5px solid #67c23a;
  width: 638px;
  height: 50px;
  border-radius: 0px;
  /*margin-top: 20px;*/
  display: flex;
  justfy-content: center;
  align-items: center;
}
  .houseBody-card{
    height: 372px;
  }
  .houseItem1{
    width: 127px;
    margin-top: 15px;
    margin-left: 70px;
  }
  .houseName{
    width: 60px;
    text-align: center;
    font-size: 12px;
    margin-left: 33px;
    margin-top: -20px;
  }
  .houseButton{
    margin-top: 5px;
    margin-left: 14px;
    width: 101px;
  }
  .houseItem2{
    width: 127px;
    margin-top: -163px;
    margin-left: 258px;
  }
  .houseItem3{
    width: 127px;
    margin-top: -163px;
    margin-left: 445px;
  }
  .houseItem4{
    /*border: 1px solid red;*/
    width: 127px;
    margin-top: 34px;
    margin-left: 25px;
  }
  .houseItem5{
    /*border: 1px solid red;*/
    width: 127px;
    margin-top: -162px;
    margin-left: 180px;
  }
  .houseItem6{
    /*border: 1px solid red;*/
    width: 127px;
    margin-top: -163px;
    margin-left: 334px;
  }
  .houseItem7{
    /*border: 1px solid red;*/
    width: 127px;
    margin-top: -163px;
    margin-left: 486px;
  }
  .salesAnalysis{
    width: 1280px;
    margin-top: 30px;
    margin-left: 15px;
  }
  .Analysis-card{
    border-left: 5px solid #67c23a;
    width: 1273px;
    height: 60px;
    border-radius: 0px;
    /*margin-top: 20px;*/
    display: flex;
    justfy-content: center;
    align-items: center;
  }
  .recentYearsSelect{
    width: 90px;
    float: left;
    margin-top: -7px;
  }
  .title-body{
    margin-left: 100px;
  }
  .salesLineGraphs{
    height: 500px;
    width: 1200px;
    text-align: center;
    margin: 30px auto 30px;
  }
  .footer{
    height: 55px;
    text-align: center;
    margin-left: 210px;
    margin-right: -8px;
    margin-bottom: -8px;
    background-color: #545c64;
    color: #fff;
  }
  .footer-title{
    line-height: 55px;
    margin-right: 40px;
  }
</style>
