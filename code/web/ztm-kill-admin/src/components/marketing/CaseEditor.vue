<template>
	<div class="case-editor-box">
		<ul class="nav">
			<ul class="nav">
			<li>内容管理 》 </li>
			<li @click='caseCenter'>案例中心 》 </li>
			<li @click="caseList">案例列表 》</li>
			<li class="active">新增案例 </li>
		</ul>
		</ul>
		<div class="case-editor-centent">
			<el-form :model="ruleForm" :rules="rules" ref="ruleForm" :label-position="labelPosition" class="demo-ruleForm">
				<el-row>
					<el-col :span="8">
						<div class="cover-box">
							<div class="cover-img-box">
								<el-upload class="avatar-uploader" 
									:action="coverUrl" 
									:show-file-list="false" 
									:on-success="handleAvatarSuccess" 
									:before-upload="beforeAvatarUpload">
									<img v-if="imgUrl" :src="imgUrl"  class="cover-img" ref="img">
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
							</div>
							<div class="cover-font-box">
								<p class="cover-title">请上传封面图片</p>
								<p class="cover-size">（建议尺寸490*320像素）</p>
							</div>
						</div>

				
						<el-form-item label="名称：" prop="name">
						    <el-input v-model.trim="ruleForm.name" placeholder="20字符以内"></el-input>
						</el-form-item>
				</el-col>
				<el-col :span="16" >
					 <!-- <quillEditor ref="myTextEditor" v-model.trim="content" :config="editorOption"></quillEditor> -->
					
				</el-col>
			</el-row>
				<div class="button-item">
					<el-button @click='publish' class='publishBtn'>发布</el-button>
				  	<el-button @click='caseCenter' class='cancelBtn'>取消</el-button>
				</div>
			</el-form>
		</div>
		
	</div>
	<!--main-content end-->
	</div>
	<!--case_box end-->

</template>

<script>
	import server from '../../server/myServer';
	import imgUrl from './../../assets/images/ic_addpic.png';
	// import { quillEditor } from 'vue-quill-editor';
	// import 'quill/dist/quill.core.css'
	// import 'quill/dist/quill.snow.css'
	// import 'quill/dist/quill.bubble.css'
	export default {
		name: "CaseEditor",
		
		data() {
			return {
				imgUrl: '',
				labelPosition: 'top',
				rowId:'',
				editorOption: {
                    // something config
               	},
               content:'',
               coverUrl:'http://192.168.5.154:8080/zmt-ow/upload/file',
             	ruleForm: {
             	 	name: ''
             	 	
             	},
             	rules: {
		          	name: [
			            { required: true, message: '请输入名称', trigger: 'blur' },
			            { min:1, max: 20, message: '20字符以内', trigger: 'blur' }
		          	]
					
				}
			}
		},
	

	methods: {
			caseCenter() {
				this.$router.push({ path: '/Main/CaseCenter' });
			},
			caseList() {
				this.$router.push({ path: '/Main/CaseList' });
			},
			//上传封面图片
			handleAvatarSuccess(res, file) {
				this.imgUrl = res.data
			},
			beforeAvatarUpload(file, a, b) {
				const isLt2M = file.size / 1024 / 1024 < 2;
				const isJPG = (file.type == 'image/jpeg'||file.type == 'image/png'||file.type == 'image/jpg')
				if(!isJPG){
					this.$msg('上传封面图片只能是 JPG/JPEG/PNG格式!', 'error', 'center')
					
				};
				if(!isLt2M) {
					this.$msg('上传封面图片大小不能超过 2MB!', 'error', 'center');
				}
				
				return isJPG && isLt2M;
			},
			onEditorChange({ editor, html, text }) {
                this.content = html;
            },
            //发布
			publish(formName){
				var me = this;
				if(!this.imgUrl){
					this.$msg('请上传封面图片', 'error', 'center');
					return false;
				};
				this.$refs.ruleForm.validate((valid) => {
		          if (valid) {
		          	if(!this.content){
						this.$msg('请输入新闻内容', 'error', 'center');
						return false;
					}else{
						
						　let formData =this.ruleForm;   
							formData.imgUrl=this.imgUrl;
							formData.content=this.content
							let alertMsg='新增成功'
							if(this.rowId){
								formData.id=this.rowId;
								formData.type=='公司新闻'?formData.type=1:formData.type=2
								alertMsg='修改成功'
							}
							server()._addcase(formData).then(function(res) {
								var Data = res.data;
								if(Data.success) {
									me.$msg(alertMsg, 'success', 'center')
									me.$router.push({ path: '/Main/caseCenter' });
								} else {
									me.$msg(Data.message, 'error', 'center')
								}
							});
					}
		            
		          } 
        		});
			}
		},
		computed: {
            editor() {
                // return this.$refs.myTextEditor.quillEditor;
            }
       },
		components: {
			// quillEditor
		},
		mounted() {
			let me =this;
//			this.rowData=JSON.parse(localStorage.getItem("caseEditorData")); 
			this.rowId=this.$route.query.id;
			if(this.rowId){
				server()._getcaseDetails({id:this.rowId}).then(function(res) {
					var Data = res.data;
					if(Data.success) {
						me.content=Data.data.content;
						me.imgUrl =Data.data.imgUrl;   
						me.ruleForm.name=Data.data.name
						
					} else {
						me.$msg(Data.message, 'error', 'center')
					}
				});
			}
			
		},

	}
</script>

<style scope lang='scss'>
	@mixin fontSet($size, $color, $bold) {
		font-family: "Microsoft YaHei", "Helvetica Neue", Helvetica, "Hiragino Sans GB", Arial, sans-serif;
		font-size: $size;
		color: $color;
		font-weight: $bold;
	}
	
	.case-editor-box {
		margin: 0 35px;
		.nav {
			height: 45px;
			line-height: 45px;
			@include fontSet(14px, #666666, 500) font-size: 14px;
			li {
				float: left;
				/*color: #666666;*/
				cursor: default;
			}
			.cursor {
				cursor: pointer;
			}
			.active {
				color: #1FB5AD;
			}
		}
		.case-editor-centent {
			min-height: 500px;
			background: #FFFFFF;
			border: 1px solid #E3E5EB;
			padding: 40px;
			.avatar-uploader .el-upload {
				/*border: 1px dashed #d9d9d9;*/
				border-radius: 6px;
				cursor: pointer;
				position: relative;
				overflow: hidden;
			}
			.el-icon-plus:before {
				content: none;
			}
			.avatar-uploader .el-upload:hover {
				border-color: #409EFF;
			}
			.avatar-uploader-icon {
				@include fontSet(28px, #8c939d, 500) width: 178px;
				height: 178px;
				line-height: 178px;
				text-align: center;
			}
			.cover-box {
				width: 100%;
				height: 185px;
			}
			.cover-img-box {
				width: 160px;
				height: 160px;
				float: left;
				background: #FBFBFB url(../../assets/images/ic_addpic.png) no-repeat;
				border: 1px solid #ECEEF3;
				background-position: center center;
			}
			.cover-img {
				width: 160px;
				height: 160px;
			}
			.cover-font-box {
				margin: 50px 10px;
				float: left;
			}
			.cover-title {
				@include fontSet(16px, #444444, 600);
			}
			.cover-size {
				margin-top: 10px;
				@include fontSet(12px, #999999, 500);
			}
			.demo-ruleForm{
				@include fontSet(14px, #444444, 600);
				.el-select{
					display: block;
				}
			}
			.editor-box{
				width: 100%;
				height: 300px;
				border: 1px solid #ECEEF3;
			}
			.el-col-16{
				padding-left:50px;
				.ql-container{
					height: 570px;
				}
			}
			.button-item{
				text-align: right;
				.el-button{
					padding: 10px 35px;
					border: none;
					@include fontSet(16px, #ffffff, 500);
				}
				.publishBtn{
					background:#1FB5AD ;
				}
				.cancelBtn{
					background:#BDBDBD ;
				}
			}
			
		}
	}
	
</style>