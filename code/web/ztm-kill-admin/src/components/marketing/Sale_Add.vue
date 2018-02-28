<template>

	<div class="news_box">
		<ul class="nav">
			<li>工作台 》 </li>
			<li>销售 》 </li>
			<li>销售订单 》 </li>
			<li class="active">新增销售单 </li>
		</ul>
		<div class="news-content">
			<div style="line-height: 80px">
				<span @click='showAddbox' style='margin-left: 40px;font-size: 18px;font-weight: bold;color: #1FB5AD'> 新增销售单</span>
				<div style='float: right;margin-right: 40px;'>
					<p style='margin-left: 0;text-align:center;'>
						<span :plain="false" class="add-btn">确定</span>
						<span style='background: #BDBDBD;margin-left: 20px;' :plain="true" class="add-btn">取消</span>
					</p>
				</div>
			</div>
			<span class="border_bottom"></span>
			<div style='margin-left: 40px;margin-top: 20px;overflow: hidden'>
				<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" label-position='right' style='width: 630px;float: left;border-right: 1px solid #ddd;padding-right: 80px;'>
					<el-form-item  style=''  label="单号：">
				  		<el-input style='width: 376px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  	</el-form-item>
				  	<el-form-item style=''  label="经销商：" prop='name'>
					  	<el-input style='width: 285px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
					  	<span @click='' :plain="true" class="add-btn" style='margin: 0px;border-radius: 0px;'><span class="el-icon-search"> </span>搜索</span>
					  	<span @click='showAddbox' :plain="true" class="add-btn" style='margin: 0px;border-radius: 0px;margin-left: 20px;'><span class="el-icon-plus"> </span>新增销售商</span>
				  	</el-form-item>
				  	<el-form-item  style=''  label="生猪数量：">
				  		<el-input style='width: 376px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  	</el-form-item>
				  	<el-form-item  style=''  label="生猪重量：">
				  		<el-input style='width: 376px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  	</el-form-item>
				  	<el-form-item  label="备注：">
				  		<el-input
			  				style=''
						  type="textarea"
						  :rows="3"
						  placeholder="200字以内"
						  v-model="ruleForm.name">
						</el-input>
				  	</el-form-item>
				  	<p style='margin-left: 20px;line-height: 60px;font-weight: bold'>凭证
					</p>
					<el-form-item  label="单据号：">
				  		<el-input style='width: 95%;' v-model="ruleForm.name" placeholder='凭证号'></el-input>
				  	</el-form-item>
						<el-form-item  label="">
				  		<el-upload
							  action="https://jsonplaceholder.typicode.com/posts/"
							  list-type="picture-card"
							  :on-preview="handlePictureCardPreview"
							  :on-remove="handleRemove">
							  <i class="el-icon-plus"></i>
							</el-upload>
							<el-dialog :visible.sync="dialogVisible">
							  <img width="100%" :src="dialogImageUrl" alt="">
							</el-dialog>
				  	</el-form-item>
			 	</el-form>
			 	<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" label-position='right' style='width: 523px;float: right;margin-right: 40px;'>
			 		<p style='margin-left: 40px;line-height: 40px;font-weight: bold'>生猪销售信息
					</p>
			 		<el-form-item style='margin-top: 20px;' label="销售地址：" prop='name'>
				  		<el-select style='width: 120px;' v-model="value2" placeholder="请选择">
						    <el-option value='1'>1
						    </el-option>
					  	</el-select>
					  	<el-select style='width: 120px;margin-left: 10px;' v-model="value2" placeholder="请选择">
						    <el-option value='1'>1
						    </el-option>
					  	</el-select>
					  	<el-select style='width: 120px;margin-left: 10px;' v-model="value2" placeholder="请选择">
						    <el-option value='1'>1
						    </el-option>
					  	</el-select>
		  			</el-form-item>
		  			<el-form-item  style=''  label="详细地址：" prop='name'>
				  		<el-input style='width: 420px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  	</el-form-item>
				  	<el-form-item  style=''  label="宰后报告：" prop='name'>
				  		<el-input style='width: 420px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  	</el-form-item>
				  	<el-table :data="tableData" border max-height="520" style='margin-top: 40px;'>
						<el-table-column label="序号">
							<template slot-scope="scope">
								<span v-show='scope.row.type==1'>公司新闻</span>
								<span v-show='scope.row.type==2'>行业新闻</span>
							</template>
						</el-table-column>
						<el-table-column label="耳标号">
							<template slot-scope="scope">
								<span v-show='scope.row.type==1'>公司新闻</span>
								<span v-show='scope.row.type==2'>行业新闻</span>
							</template>
						</el-table-column>
						<el-table-column label="生猪ID">
							<template slot-scope="scope">
								<span class="news-titlt">{{ scope.row.title}}</span>
							</template>
						</el-table-column>
						<el-table-column label="操作">
							<template slot-scope="scope">
								<el-button class='deleteBtn' size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
							</template>
						</el-table-column>
					</el-table>
			 	</el-form>
			</div>
		</div>
		<SaleErAdd v-if='showAdd' @Close='Closes'></SaleErAdd>
	</div>
	<!--main-content end-->
	</div>
	<!--news_box end-->


</template>

<script scope>
	const cityOptions = ['上海', '北京', '广州', '深圳'];
	import server from '../../server/myServer';
	import SaleErAdd from '../common/SaleEr_Add'
	export default {
		name: "SaleAdd",
		data() {
			return {
				value2:'',
				showAdd: false,
				radio:'2',
				value1:'',
				cur:1,
				curPage:10,
				recordsTotal:0,
				tableData: [],
				ruleForm:{
					name:'',
				},
				rules:{
					name: [
			            { required: true, message: '请输入活动名称', trigger: 'blur' },
			            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
		          	],
				},
				tableData: [],
				dialogImageUrl: '',
        dialogVisible: false,
        checkAll: false,
        checkedCities: ['上海', '北京'],
        cities: cityOptions,
        isIndeterminate: true
			}
		},
		mounted() {
     	console.log(this.urls)
 	 	} ,
		methods: {
			handleCheckAllChange(val) {
	        this.checkedCities = val ? cityOptions : [];
	        this.isIndeterminate = false;
	      },
	      Closes(){
	      	this.showAdd = false
	      },
	      showAddbox(){
	      	this.showAdd = true
	      },
      handleCheckedCitiesChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.cities.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
      },
			handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
			//新增新闻
			addBtn() {
//				this.$router.push({ name: 'NewsEditor',params:{other:1}});
				this.$router.push({ name: 'Distributor_Add',params:{type:'ad1'} });
			},
			//编辑新闻
			handleEdit(index,row) {
//				localStorage.setItem('newsEditorData', JSON.stringify(row));
				this.$router.push({ name: 'NewsEditor',query:{id:row.id}});
			},
			//删除新闻
			handleDelete(index,row){
				debugger;
				var me = this;
				server()._deleteNews({id:row.id}).then(function(res) {
					var Data = res.data;
					if(Data.success) {
						me.$msg('删除成功', 'success', 'center')
						me.getData();
					} else {
						me.$msg(Data.message, 'error', 'center')
					}
				});
			},
			//点击页码和跳页
	    handleCurrentChange(val) {
	    	this.cur=val;
	    	this.getData();
	    },
	    //页面加载数据
	    getData(){
	    	let me = this;
			let newsTableData={
				page:me.cur,
				size:me.curPage
			};
			server()._newsTable(newsTableData).then(function(res) {
				var Data = res.data;
				if(Data.success) {
					me.tableData = Data.list
					me.recordsTotal=Data.recordsTotal;
					console.log(me.tableData)
				} else {
					me.$msg(Data.message, 'error', 'center')
				}
			});
	    }
    },
		components: {
			SaleErAdd
		},
		
		created() {
			//页面加载数据
			this.getData();
		},
		 
	}

</script>

<style lang='scss'>
	.el-upload-list--picture-card .el-upload-list__item{
		width: 120px;
		height: 120px;
	}
	.el-upload--picture-card{
		width: 120px;
		height: 120px;
		line-height: 127px;
	}
	.news_box {
		margin: 0 35px;
		.nav {
			height: 45px;
			line-height: 45px;
			font-size: 14px;
			li {
				float: left;
				color: #666666;
				cursor: default;
			}
			.active {
				color: #1FB5AD;
			}
		}
		.news-content {
			min-height: 500px;
			background: #FFFFFF;
			border: 1px solid #E3E5EB;
			.news-titlt {
				display: block;
				min-width: 150px;
				overflow: hidden;
				text-overflow:ellipsis;
				white-space: nowrap;
			}
			.add-btn {
				color: #FFFFFF;
				display: inline-block;
				padding: 0 22px;
				text-align: center;
				line-height: 38px;
				font-size: 14px;
				background: #1FB5AD;
				border-radius: 5px;
				margin: 20px 0px 20px 40px;
				cursor: pointer;
			}
			.border_bottom {
				display: block;
				width: 100%;
				border-bottom: 1px solid #F0F2F7;
			}
			.tableData {
				width: 95%;
				margin: 20px auto;
			}
			.editBtn,
			.editBtn:hover {
				color: #3C91DD;
				background: none;
			}
			.deleteBtn,
			.deleteBtn:hover {
				color: #F65342;
				background: none;
			}
			.el-table th {
				& {
					padding: 20px 0px;
					background: #FBFBFB;
				}
				&>.cell {
					color: #777777;
					font-size: 14px;
					text-align: center;
				}
			}
			.el-table td,
			.el-table th.is-leaf {
				border-bottom: none;
			}
			.el-table td {
				text-align: center;
				color: #566175;
				font-size: 14px;
			}
			.el-table::before {
				background: #FFFFFF;
			}
			.el-button {
				cursor: pointer;
				background: none;
				border: none;
			}
			.el-pagination.is-background .el-pager li.active{
				background: #1FB5AD;
			}
		}
	}
</style>

