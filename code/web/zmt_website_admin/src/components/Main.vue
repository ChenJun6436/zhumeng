<template>

	<div class="container">
		<div class="aside">
			<div class="logoDiv">
				<img class="logoImg" src="./../assets/images/logo.png" alt="">
			</div>
			<el-row class="tac">
				<el-col :span="24">
					<el-menu default-active="2" class="el-menu-vertical-demo" background-color="#32323A" text-color="#95A0AA" active-text-color="#FEFFFF">
						<router-link to="/Main/PictureManage">
							<el-menu-item index="2">
								<i class="el-icon-picture"></i>
								<span slot="title">图片管理
                </span>
							</el-menu-item>

						</router-link>

						<el-submenu index="1">
							<template slot="title">
								<i class="el-icon-tickets"></i>
								<span>内容管理</span>
							</template>
							<router-link to="/Main/NewsCenter">
								<el-menu-item index="1-1">新闻中心
								</el-menu-item>
							</router-link>
							<router-link to="/Main/CaseCenter">
								<el-menu-item index="1-2">案例中心
								</el-menu-item>
							</router-link>

						</el-submenu>
						<router-link to="/Main/BasicConfiguration">
							<el-menu-item index="3">
								<i class="el-icon-setting"></i>
								<span slot="title">基础配置
                </span>
							</el-menu-item>
						</router-link>

					</el-menu>
				</el-col>
			</el-row>
		</div>
		<div class="right-container">
			<div class="header">

				<ul class="header-usermsg">
					<li>
						<img src="./../assets/images/2.png" alt="">
						<span style="color:#1FB5AD">超级管理员，</span>
						<span>欢迎您！</span>
					</li>
					<li style="margin-left:25px;margin-right:25px">|</li>
					<li class="logOut" @click="layout">退出登录</li>
				</ul>

			</div>
			<div class="main">
				<router-view></router-view>
			</div>
		</div>

	</div>

</template>

<script>
	import myServices from './../server/myServer'
	export default {
		name: "Main",
		data() {
			return {
				msg: "主页框架"
			}
		},
		methods: {

			//退出登录
			layout() {
				let me = this;
				myServices()._logout().then(function(res) {
					var Data = res.data;
					if(Data.success) {
						me.$confirm('您是否确定要退出?', '提示', {
							confirmButtonText: '确定',
							cancelButtonText: '取消',
							type: 'warning'
						}).then(() => {
							me.$router.push({
								path: '/Login'
							})
						}).catch(() => {

						});
					} else {
						me.$message({
							message: Data.message,
							type: 'success'
						})
					}
				})

			}
		}
	}
</script>

<style>
	.aside {
		text-align: center;
		width: 202px;
		position: fixed;
		top: 0;
		left: 0;
		height: 100%;
		background-color: #32323A;
	}
	
	.main {
		width: calc(100% - 202px);
		position: relative;
		top: 70px;
		left: 202px;
	}
	
	.header {
		position: fixed;
		top: 0;
		left: 202px;
		height: 70px;
		line-height: 70px;
		width: calc(100% - 202px);
		z-index: 1;
		background-color: white;
	}
	
	.logoDiv {
		background-color: #28282E;
		width: 202px;
		height: 253px;
	}
	
	.logoImg {
		margin: 36px 43px 38px 42px;
	}
	
	.el-menu {
		border-right: 0px;
	}
	
	.nav-list {
		min-height: 706px;
	}
	
	.nav-list li {
		font-size: 16px;
		line-height: 67px;
		width: 202px;
		height: 67px;
		color: #95A0AA;
		cursor: pointer;
	}
	
	.header a {
		margin-left: 36px;
		color: #666666;
		font-size: 14px;
		font-weight: bold;
	}
	
	.header a img {
		margin-top: 15px;
		margin-right: 14px;
	}
	
	.header-usermsg {
		float: right;
		margin-right: 30px;
	}
	
	.header-usermsg li {
		float: left;
	}
	
	.header-usermsg li img {
		margin-top: 29px;
		margin-right: 4px;
	}
	
	.logOut {
		cursor: pointer;
	}
	
	.is-active {
		background-color: #1FB5AD !important;
	}
	
	.is-active a {
		color: white !important;
		font-weight: bold;
	}
</style>