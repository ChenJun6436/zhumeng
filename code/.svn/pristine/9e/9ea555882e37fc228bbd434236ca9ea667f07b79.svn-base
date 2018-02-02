<template>
	<div class="basicMain">

		<div class="basicBox">
			<a class="btn" href="javaScript:; " @click="showFooterConfig" :class="isFooterConfig?'':'btn-hui' ">底部配置</a>
			<a class="btn " href="javaScript:;" @click="showSEOconfig" :class="!isFooterConfig?'':'btn-hui'">SEO配置</a>
			<!--底部配置start-->
			<div class="footFromBox" v-show="isFooterConfig">
				<!--左边的部分start-->
				<div class="basic_form_left">

					<el-form :label-position="labelPosition" style='width: 360px;padding-left: 40px;padding-right: 109px; padding-bottom: 20px;' label-width="80px" :model="FootBaseFrom" :rules="FootBaseRules" status-icon>
						<el-form-item label="电话:" prop='tel'>
							<el-input v-model="FootBaseFrom.tel" :maxlength="13"></el-input>
						</el-form-item>
						<el-form-item label="手机:" prop='phone'>
							<el-input v-model="FootBaseFrom.phone" :maxlength="11"></el-input>
						</el-form-item>
						<el-form-item label="地址:" prop='address'>
							<el-input v-model="FootBaseFrom.address" :maxlength="51"></el-input>
						</el-form-item>
						<p class="fw litter-title">二维码</p>
						<el-form-item label="备案号:" prop='record'>
							<el-input v-model="FootBaseFrom.record" :maxlength="51" placeholder="输入备案号"></el-input>
						</el-form-item>
						<el-form-item label="名称:" prop='wxName'>
							<el-input v-model="FootBaseFrom.wxName" placeholder="微信公众号"></el-input>
						</el-form-item>
						<el-upload class="avatar-uploader" ref="upload" :on-change="onchange" action="http://192.168.5.154:8080/zmt-ow/upload/file" :show-file-list="false" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
							<img v-if="imageUrl" :src="imageUrl" class="avatar">
							<i v-else class="el-icon-plus avatar-uploader-icon"></i>
						</el-upload>
						<el-form-item label="名称:" prop='wbName'>
							<el-input v-model="FootBaseFrom.wbName" placeholder="官方微博"></el-input>
						</el-form-item>
						<el-upload class="avatar-uploader" ref="upload1" :on-change="onchange1" action="http://192.168.5.154:8080/zmt-ow/upload/file" :show-file-list="false" :on-success="handleAvatarSuccess1" :before-upload="beforeAvatarUpload1">
							<img v-if="imageUrl1" :src="imageUrl1" class="avatar">
							<i v-else class="el-icon-plus avatar-uploader-icon"></i>
						</el-upload>
						<el-input v-model="FootBaseFrom.id" style="display:none"></el-input>
					</el-form>

				</div>

				<!--左边的部分end-->

				<!--右边部分start-->
				<div class="basic_form_right">
					<div>
						<span class="basci_friendLink">友情链接</span>
						<button class="basic_add_link" @click="basic_link">
							<i class="el-icon-plus"></i>新增
						</button>
					</div>
					<ul class="basc_link">
						<li v-for="(item,index) in FootBaseFrom.liksList" :key='index'>
							<el-row :gutter="20">
								<el-col :span="10">
									<div>
										<span>链接名称：</span>
										<input type="text" v-model="item.name" :class="item.falg ? 'noEditInput' : 'canEditInput' " placeholder="友情链接名称（10字内）" v-bind:readonly="item.falg"/>
									</div>
								</el-col>
								<el-col :span="10">
									<div>
										<span>链接：</span>
										<input type="text" v-model="item.url" :class="item.falg ? 'noEditInput' : 'canEditInput' " placeholder="http://" v-bind:readonly="item.falg"/>
									</div>
								</el-col>
								<el-col :span="4">
									<div>
										<img src="../../assets/pic_manage/ic_delete.png" alt="" @click="basic_del(index,item.id)"  />
									</div>
								</el-col>
							</el-row>
						</li>
					</ul>

					<button @click="basic_save" class="bottomSaveMsg">保存</button>

				</div>

				<!--右边部分end-->
			</div>

			<!--底部配置end-->

			<!--SEO配置start-->

			<div v-show="!isFooterConfig" class="SEOconfig">
				<el-form ref="form" :model="SEOform" label-width="200px" :label-position="labelPosition">
					<el-form-item label="官网首页标题（Title）">
						<el-input type="textarea" v-model="SEOform.title" :rows="4" placeholder="100字符内" :maxlength="100"></el-input>
					</el-form-item>
					<el-form-item label="关键词(keywords)">
						<el-input type="textarea" v-model="SEOform.keywords" :rows="6" placeholder="200字符内" :maxlength="200"></el-input>
					</el-form-item>
					<el-form-item label="描述(description)">
						<el-input type="textarea" v-model="SEOform.description" :rows="8" placeholder="400字符内" :maxlength="400"></el-input>
					</el-form-item>
					<el-input v-model="SEOform.id" style="display: none;"></el-input>
				</el-form>
				<button @click="basicSEOSaveMsg" class="SEOSaveM">保存</button>
			</div>

			<!--SEO配置end-->
		</div>

	</div>

</template>

<script>
	import myServices from '../../server/myServer'
	export default {
		name: 'BasicConfiguration',
		data() {
			return {
				basicUrl: 'http://192.168.5.154:8080/zmt-ow /upload/file',
				labelPosition: 'left',
				isFooterConfig: true,
				FootBaseFrom: {
					id:'',
					tel: '',
					phone: '',
					address: '',
					record: '',
					wxName: '',
					wbName: '',
					wxImg: '',
					wbImg: '',
					liksList: []
				},
				SEOform: {
					id:'',
					title: '',
					keywords: '',
					description: ''
				},
				FootBaseRules: {
					tel: [{
							required: true,
							message: '请输入电话号码',
							trigger: 'blur'
						},
						{
							pattern: /^(0[0-9]{2,3}\-)([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/,
							message: '电话号码格式不正确',
							trigger: 'blur'
						}
					],
					phone: [{
							required: true,
							message: '请输入手机号码',
							trigger: 'blur'
						},
						{
							pattern: /^1[34578]\d{9}$/,
							message: '手机号码格式不正确',
							trigger: 'blur'
						}
					],
					address: [{
							required: true,
							message: '请输入地址',
							trigger: 'blur'
						},
						{
							max: 50,
							message: '地址最大长度50位',
							trigger: 'blur'
						}
					],
					record: [{
							required: true,
							message: '请输入备案号',
							trigger: 'blur'
						},
						{
							max: 50,
							message: '备案号最大长度50位',
							trigger: 'blur'
						}
					],
					wxName: [{
						required: true,
						message: '请输入地址',
						trigger: 'blur'
					}],
					wbName: [{
						required: true,
						message: '请输入地址',
						trigger: 'blur'
					}],
				},
				imageUrl: '',
				imageUrl1: '',

			}
		},
		methods: {
			//微信公众号图片选择事件
			onchange(file, fileList) {
				this.imageUrl = URL.createObjectURL(file.raw);
			},
			//微信公众号图片上传成功后调用事件
			handleAvatarSuccess(res, file) {
				this.FootBaseFrom.wxImg = res.data;
			},
			//微信公众号图片上传前调用事件
			beforeAvatarUpload(file) {
				const isLt2M = file.size / 1024 / 1024 < 2;
				if(!isLt2M) {
					this.$message.error('上传头像图片大小不能超过 2MB!');
				}
				return isLt2M;
			},
			onchange1(file, fileList) {
				this.imageUrl1 = URL.createObjectURL(file.raw);
			},
			//官方微博图片成功后调用事件
			handleAvatarSuccess1(res, file) {
				this.FootBaseFrom.wbImg = res.data;
			},
			//官方微博图片上传前调用事件
			beforeAvatarUpload1(file) {
				const isLt2M = file.size / 1024 / 1024 < 2;
				if(!isLt2M) {
					this.$message.error('上传头像图片大小不能超过 2MB!');
				}
				return isLt2M;
			},
			//底部配置的新增保存
			basic_save() {
				var me = this;
				myServices().basicSaveMsg(me.FootBaseFrom).then(function(res) {
					let Data = res.data;
					if(Data.success) {
						//页面加载就请求已有的友情链接数据
						myServices().basicGetLink().then(function(linkRes) {
							let linkData = linkRes.data;
							if(linkData.success) {
								me.FootBaseFrom.liksList = linkData.data;
								me.FootBaseFrom.id = Data.data.id;
							}else{
								me.$message.error(linkData.message);
							}
						})
						me
						me.$message({
							message: '保存成功',
							type: 'success'
						});
					} else {
						me.$message.error(Data.message);
					}
				})

			},

			//点击新增一条友情链接
			basic_link() {
				let me = this;
				me.FootBaseFrom.liksList.push({
					name: '',
					url: '',
					falg: false
				})

			},
			//删除友情链接
			basic_del(index,id) {
				let me = this;
				//删除新添加的链接
				var axisData={
					id:id
				}
				if(id==undefined){
					me.FootBaseFrom.liksList.splice(index, 1);
				}else{
					//删除原本就存在的链接
					me.$confirm('您确定要删除该链接吗？','提示',{
						confirmButtonText: '确定',
				        cancelButtonText: '取消',
				        type: 'warning'
					}).then(()=>{
						myServices().delbasicGetLink(axisData).then(function(res) {
						let Data = res.data;
						if(Data.success) {
							me.FootBaseFrom.liksList.splice(index, 1);
							me.$message({
								message: '删除成功！',
								type: 'success'
							});
						} else {
							me.$message.error(Data.message);
						}
			})
					})
					
				}

			},
			//展示底部配置
			showFooterConfig() {
				this.isFooterConfig = true;
			},
			//展示SEO配置
			showSEOconfig() {
				this.isFooterConfig = false;
			},
			//SEO的新增保存
			basicSEOSaveMsg() {
				let me = this;
				myServices().basicSEOSaveMsg(me.SEOform).then(function(res) {
					let Data = res.data;
					if(Data.success) {
						me.SEOform.id = Data.data.id;
						me.$message({
							message: '保存成功',
							type: 'success'
						});
					} else {
						me.$message.error(Data.message);
					}
				})
			}
		},
		created: function() {
			
			//底部配置的相关请求
			let me = this;
			//页面首次加载，请求已存在的数据
			myServices().basicGetAllMessage().then(function(res) {
				let Data = res.data.data;
				if(res.data.success) {
					//页面加载就请求已有的友情链接数据
					myServices().basicGetLink().then(function(linkRes) {
						let linkData = linkRes.data;
						if(linkData.success) {
							me.FootBaseFrom ={
							id:Data.id,
							tel: Data.tel,
							phone: Data.phone,
							address: Data.addres,
							record: Data.record,
							wxName: Data.wxName,
							wbName: Data.wbName,
							wxImg: Data.wxImg,
							wbImg: Data.wbImg,
							liksList:linkData.data
						}
						me.imageUrl = Data.wxImg
						me.imageUrl1 = Data.wbImg
						}else{
							me.$message.error(linkData.message);
						}
					})
					
					
				} else {
					me.$message.error(Data.message);
				}
			})
			
			//SEO配置的相关请求
			myServices().getBasicSEOAllMsg().then(function(res) {
				var SEoData = res.data.data;
				if(res.data.success){
					me.SEOform = {
						id:SEoData.id,
						title: SEoData.title,
						keywords: SEoData.keywords,
						description:SEoData.description
					}
					
					
				}else{
					me.$message.error(res.data.message);
				}
				
				
				
			})
			
		}
	}
</script>

<style scope lang='scss'>
	.SEOconfig {
		background-color: white;
		min-height: 750px;
		padding-top: 41px;
		padding-left: 41px;
	}
	
	.el-textarea {
		width: 60%;
	}
	
	.el-form-item {
		margin-bottom: 39px;
	}
	
	.el-textarea textarea {
		background-color: #F8F9FB;
	}
	
	.SEOSaveM,
	.bottomSaveMsg {
		width: 91px;
		height: 32px;
		background-color: #BDBDBD;
		color: white;
		border-radius: 4px;
		border: 1px solid #BDBDBD;
		outline: 0px;
		float: right;
	}
	
	.SEOSaveM {
		margin-right: 34%;
	}
	
	.bottomSaveMsg {
		margin-right: 10%;
		margin-top: 85px;
	}
	
	.basicMain {
		padding: 29px 37px 0px 36px;
	}
	
	.footFromBox {
		min-height: 850px;
		background-color: white;
	}
	
	.basic_form_left {
		margin-top: 40px;
		width: 45%;
		float: left;
		border-right: 1px solid #ECEEF3;
	}
	
	.basic_form_right {
		margin-top: 40px;
		float: left;
		width: 50%;
		padding-left: 56px;
	}
	
	.basc_link li {
		margin-top: 30px;
	}
	
	.basc_link li input {}
	
	.noEditInput {
		border: 0px;
		outline: 0px;
	}
	
	.canEditInput {
		height: 31px;
		background-color: #F8F9FB;
		outline: 0px;
		border: 1px solid #ECEEF3;
		border-radius: 4px;
	}
	
	.btn {
		display: inline-block;
		width: 126px;
		height: 41px;
		background-color: #34C4BC;
		font-size: 16px;
		color: #ffffff;
		text-align: center;
		line-height: 41px;
	}
	
	.basci_friendLink {
		color: #333333;
		font-weight: 600;
	}
	
	.basic_add_link {
		width: 74px;
		height: 28px;
		color: white;
		background-color: #1FB5AD;
		line-height: 28px;
		text-align: center;
		border-radius: 4px;
		margin-left: 21px;
		outline: 0px;
		border: 0px;
	}
	
	.btn:visited {
		color: #ffffff;
	}
	
	.el-input input {
		background-color: #F8F9FB;
	}
	
	.btn:link {
		color: #ffffff;
	}
	
	.btn-hui {
		background-color: #D2D2DC;
	}
	
	.fw {
		font-weight: 600;
		color: #333333;
	}
	
	.litter-title {
		line-height: 60px;
	}
	
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
		width: 121px;
		height: 121px;
		margin-left: 80px;
		margin-bottom: 17px;
	}
	
	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}
	
	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 121px;
		height: 121px;
		line-height: 121px;
		text-align: center;
	}
	
	.avatar {
		width: 121px;
		height: 121px;
		display: block;
	}
</style>