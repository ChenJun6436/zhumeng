<template>
	<div class="PivmainBox">
		<!--新增banner的弹框start-->
		<div class="pic_content">
			<div class="pic_navList">
				<span>图片管理 》</span>
				<span class="pic_navActive">图片列表</span>
			</div>
			<div class="pic_table_newAdd">
				<div class="pic_firstLine">
					<button class="pic_newAddBtn" @click="newAddPic('form')">
	                    <i class="el-icon-plus"></i>新增Banner
	                </button>
				</div>
				<div class="pic_tableComtent">
					<el-table :data="picTableMsg" style="width: 100%">
						<el-table-column prop="url" label="图片">
							<template slot-scope="scope">
								<img class="pic_tableImg" :src="scope.row.url" alt="" />
							</template>
						</el-table-column>
						<el-table-column prop="name" label="名称">
						</el-table-column>
						<el-table-column prop="lastUpdateTime" label="修改时间">
						</el-table-column>
						<el-table-column label="操作">
							<template slot-scope="scope">
								<el-button type="text" size="small" class="pic_delete" @click="pic_del(scope.row,scope.$index)">删除</el-button>
								<el-button type="text" size="small" @click="pic_update(scope.row)">修改</el-button>
							</template>
						</el-table-column>
					</el-table>

				</div>
			</div>

		</div>
		<!--新增banner的弹框end-->

		<!--新增banner的弹框start-->
		<el-dialog title="新增" :visible.sync="dialogFormVisible" :show-close="false">
			<img src="../../assets/pic_manage/ic_close.png" alt="" class="closeBtn1" @click="cloaeDig" />
			<!--<el-form ref="form" class="formData" :model="form" :label-position="labelPosition" label-width="100px" method="post" action="javascript:;" enctype="multipart/form-data"  @submit.prevent="submit">-->
			<el-form :model="form" ref="form" :label-position="labelPosition" label-width="100px">
				<el-form-item label="图片名称">
					<el-input name="name" v-model="form.name" :maxlength="20" placeholder="请输入名称（20个字符以内）"></el-input>
				</el-form-item>
				<el-form-item label="原始图片">
					<div class="orginPicture" v-show="orginIsShow">
						<img class="pic_orginpic" :src="orginPic" alt="" />
					</div>
					<div class="orginPicture" v-show="!orginIsShow">
						<img ref="imgasd" class="pic_yulanpic" :src="orginPic" alt="" />
					</div>

				</el-form-item>
				<el-form-item label="上传图片">
					<div class="fileDiv">
						<el-input class="chooseInput" v-model="form.imgUrl" :disabled="true"></el-input>
						<el-button class="chosePicBtn"><img src="../../assets/pic_manage/ic_folder.png" alt="" />选择</el-button>
						<input name="file" class="noneFile" type="file" @change='getfile($event)' ref="input" />
					</div>
					<el-input style="display:none" v-model="form.id"></el-input>
				</el-form-item>
				<button @click="submitForm($event)" class="saveBtn">保存</button>
			</el-form>
		</el-dialog>
		<!--<img ref="imgasd" class="pic_yulanpic" :src="orginPic"  alt="" />-->
		<!--新增banner的弹框end-->
	</div>
</template>

<script>
	import myServices from '../../server/myServer'
	import orginPic from '../../assets/pic_manage/ic_picture.png'
	import baseUrl from '../../server/baseUrl'
	export default {
		name: 'PictureManage',
		data() {
			return {
				saveMsgUrl: baseUrl + '/image/save',
				orginPic: orginPic,
				orginIsShow: true,
				pictureSize:'',
				elInput: null,
				msg: "图片管理",
				picTableMsg: [{
					name: '',
					url: '',
					lastUpdateTime: ''
				}],
				dialogFormVisible: false,
				labelPosition: 'left',
				form: {
					id: '',
					name: '',
					imgUrl: ''
				},
				imgUrl: '',
				curRowId: {},
				isAdd: true,
				updateMsg:''
			}
		},
		methods: {
			//点击新增出现新增的弹框
			newAddPic(formName) {
				
				this.dialogFormVisible = true;
				this.orginIsShow = true;
				this.orginPic = orginPic;
				this.form = {
					id: '',
					name: '',
					imgUrl: ''
				}
			},

			//点击弹框右上角的关闭图片，关闭弹窗
			cloaeDig() {
				this.dialogFormVisible = false;
			},
			//选择改变图片
			getfile(e) {
				this.form.imgUrl = e.target.files[0].name;
				this.imgUrl = e.target.files[0];
				this.pictureSize= e.target.files[0].size;
				
//				const isLt2M = pictureSize / 1024 / 1024 < 2;
//				if(!this.isAdd){
//					updateFlag = true;	
//				}
//				if(!isLt2M) {
//					this.$message.error('上传头像图片大小不能超过 2MB!');
//				} else {
					this.orginIsShow = false;
					this.orginPic = this.getObjectURL(e.target.files[0]);
//				}

			},

			getObjectURL(file) {
				var url = null;
				if(window.createObjectURL != undefined) { // basic
					url = window.createObjectURL(file);
				} else if(window.URL != undefined) { // mozilla(firefox)
					url = window.URL.createObjectURL(file);
				} else if(window.webkitURL != undefined) { // webkit or chrome
					url = window.webkitURL.createObjectURL(file);
				}
				return url;
			},
			//form表单的提交（保存事件）
			submitForm(event) {
				var me = this;
				event.preventDefault();
				let formData = new FormData();
				let picSize = this.pictureSize/ 1024 / 1024 < 10;
				if(!picSize){
					me.$message.error("上传头像图片大小不能超过10MB,请重新选择图片!");
					return false
				}
				if(me.isAdd) {
					if(this.form.name != '' && this.imgUrl != '') {} else {
						me.$message.error("请先填写图片的相关信息！");
						return false
					}
				} else {
					if(this.form.name == '') {
						me.$message.error("请先填写图片的相关信息！");
						return false
					}
					if(this.updateMsg ===this.form.imgUrl){
						this.imgUrl = ''
					}
				}
				formData.append('name', this.form.name);
				formData.append('id', this.form.id);
				formData.append('file', this.imgUrl);
				let config = {
					headers: {
						'Content-Type': 'multipart/form-data'
					}
				}
				this.$ajax.post(me.saveMsgUrl, formData, config).then(function(res) {
					var Data = res.data.data;
					if(res.data.success) {
						me.dialogFormVisible = false;
						me.$message({
							message: me.isAdd ? '新增成功！' : '修改成功！',
							type: 'success'
						});
						if(me.isAdd) {
							//更新数据（新增的话添加一条数据，修改的话更新数据）
							me.picTableMsg.push({
								name: Data.name,
								url: baseUrl+ Data.url,
								lastUpdateTime: Data.lastUpdateTime,
								id: Data.id
							})
						} else {
							me.picTableMsg.forEach(function(event) {
								if(event["id"] == me.form.id) {
									event.name = Data.name,
										event.url = baseUrl+Data.url,
										event.lastUpdateTime = Data.lastUpdateTime
								}
							})
						}

					} else {
						me.dialogFormVisible = false;
						me.$message.error(res.data.message);
					}
				})

			},
			//删除当前行
			pic_del(row, index) {
				let me = this;
				let curRowId = {
					id: row.id
				}
				let fd = new FormData()
				for(let o in curRowId) {
					fd.append(o, curRowId[o])
				}
				var dataListLength = this.picTableMsg.length;
				if(dataListLength ===1){
					me.$message.error('不能删除最后一张图片！！');
					return false
				}
				myServices().delPic(fd).then(function(res) {
					let Data = res.data;
					if(Data.success) {
						me.$message({
							message: '删除成功！',
							type: 'success'
						});
						me.picTableMsg.forEach(function(c) {
							if(c['id'] == row.id) {
								me.picTableMsg.splice(index, 1);
							}
						})
					}

				})

			},
			//修改当前行的数据
			pic_update(row) {
				this.dialogFormVisible = true;
				this.orginIsShow = false;
				this.orginPic = row.url;
				this.isAdd = false;
				
				this.form = {
					id: row.id,
					name: row.name,
					imgUrl: row.url
				}
				this.updateMsg = this.form.imgUrl
				
			}

		},
		//页面加载时加载图片的数据
		created: function() {
			let me = this;

		},
		mounted() {
			let me = this;
			myServices().findPic().then(function(res) {
				let Data = res.data;
				if(Data.success) {
					let listArry = Data.data;
					var newArry = [];
					listArry.forEach(function(item){
						newArry.push({
							url : baseUrl+item.url,
							id :item.id,
							lastUpdateTime :item.lastUpdateTime,
							name :item.name,
						})
					});
					me.picTableMsg = newArry;
				} else {
					me.$message.error(Data.message);
				}
			})
		}
	}
</script>

<style lang='scss'>
	table thead tr th {
		background-color: #FBFBFB !important;
		text-align: center !important;
		border: 0px !important;
	}
	
	table tbody tr td {
		text-align: center !important;
	}
	
	.PivmainBox {
		.pic_content {
			padding: 10px 37px 0px 36px;
		}
		.pic_navList {
			margin-bottom: 16px;
			margin-top: 7px;
		}
		.pic_navActive {
			color: #1FB5AD;
		}
		.pic_table_newAdd {
			background-color: white;
		}
		.pic_firstLine {
			height: 79px;
			border-bottom: 1px solid #F0F2F7;
		}
		.pic_newAddBtn {
			outline: 0px;
			border: #1FB5AD 1px solid;
			background-color: #1FB5AD;
			color: white;
			width: 127px;
			height: 38px;
			border-radius: 4px;
			margin-left: 39px;
			margin-top: 21px;
		}
		.pic_tableComtent {
			padding-top: 22px;
			padding-left: 39px;
			padding-right: 23px;
		}
		.pic_tableImg {
			width: 141px;
			height: 79px;
		}
		.el-dialog {
			width: 661px;
			height: 492px;
		}
		.orginPicture {
			border: 1px solid #CCCCCC;
			border-radius: 4px;
			display: inline-block;
			width: 279px;
			height: 140px;
		}
		.pic_yulanpic {
			width: 100%;
			height: 100%;
		}
		.el-form {
			padding-left: 118px;
		}
		.el-form-item label {
			font-size: 16px;
			color: #444444;
			font-weight: bold;
		}
		.el-input {
			width: 279px;
		}
		.uploadPic {
			width: 72px;
			height: 38px;
		}
		.closeBtn1 {
			position: absolute;
			top: 0px;
			right: 0px;
		}
		.chooseInput {
			width: 207px;
		}
		.chosePicBtn {
			background-color: #1FB5AD;
			color: white;
			width: 72px;
			height: 40px;
			padding: 0px;
			padding-bottom: 4px;
		}
		.chosePicBtn:hover {
			background-color: #1FB5AD;
			color: white;
		}
		.fileDiv {
			position: relative;
		}
		.noneFile {
			width: 69px;
			height: 41px;
			position: absolute;
			left: 212px;
			opacity: 0;
		}
		.pic_delete {
			color: #FA8564;
		}
		.saveBtn {
			width: 91px;
			height: 32px;
			text-align: center;
			color: white;
			border-radius: 4px;
			outline: 0px;
			background-color: #1FB5AD;
			border: 0px;
			margin-left: 35%;
			margin-top: 34px;
		}
		.el-dialog__headerbtn {
			z-index: 100;
			background-image: url(../../assets/pic_manage/ic_close.png);
		}
		.el-dialog__header {
			background-color: #1FB5AD;
			font-size: 16px;
			font-weight: bold;
		}
		.el-dialog__title {
			color: white;
		}
		.el-table th tr {
			background-color: #FBFBFB;
		}
		.pic_orginpic {
			margin-top: 19%;
			margin-left: 43%;
		}
	}
</style>