<template>

	<div class="container">
		<div class="aside">
			<div class="logoDiv">
				<img class="logoImg" src="./../assets/images/logo.png" alt="">
			</div>
			<el-row class="tac">
				<el-col :span="24">
					<el-menu default-active="0" class="el-menu-vertical-demo" background-color="#32323A" text-color="#95A0AA" active-text-color="#FEFFFF" unique-opened>
						<router-link to="/Main/PictureManage">
							<el-menu-item index="0">
								<span slot="title">首页</span>
							</el-menu-item>
						</router-link>
						<el-submenu index="1">
							<template slot="title">
								<span>屠宰场设置</span>
							</template>
							<el-submenu index="1-1">
								<template slot="title">
									<span>合作商管理</span>
								</template>
								<router-link to="/Main/Distributor">
									<el-menu-item index="1-1-1">合作销售商
									</el-menu-item>
								</router-link>
								<router-link to="/Main/Supplier">
									<el-menu-item index="1-1-2">合作供应商
									</el-menu-item>
								</router-link>
								<router-link to="/Main/Inspector">
									<el-menu-item index="1-1-3">检验人员
									</el-menu-item>
								</router-link>
							</el-submenu>
							<router-link to="/Main/Pigsty">
								<el-menu-item index="1-2">
									<span slot="title">猪舍管理</span>
								</el-menu-item>
							</router-link>
							<router-link to="/Main/Subaccount">
								<el-menu-item index="1-3">
									<span slot="title">子账号管理</span>
								</el-menu-item>
							</router-link>
							<el-submenu index="1-4">
								<template slot="title">
									<span>账号管理</span>
								</template>
								<router-link to="/Main/Subaccount_Account">
									<el-menu-item index="1-4-1">账号信息
									</el-menu-item>
								</router-link>
								<router-link to="/Main/Subaccount_Company">
									<el-menu-item index="1-4-2">公司信息
									</el-menu-item>
								</router-link>
								<router-link to="/Main/Account_Safe">
									<el-menu-item index="1-4-3">账号安全
									</el-menu-item>
								</router-link>
							</el-submenu>
						</el-submenu>
						<el-submenu index="2">
							<template slot="title">
								<span>工作台</span>
							</template>
							<el-submenu index="3">
								<template slot="title">
									<span>生猪入场</span>
								</template>
								<router-link to="/Main/PigInList">
									<el-menu-item index="3-1-1">入场生猪列表
									</el-menu-item>
								</router-link>
							</el-submenu>
							<el-submenu index="4">
								<template slot="title">
									<span>猪舍</span>
								</template>
								<router-link to="/Main/Pigsty_List">
									<el-menu-item index="4-1">
										<span slot="title">猪舍列表</span>
									</el-menu-item>
								</router-link>
								<router-link to="/Main/Pigsty_History">
									<el-menu-item index="4-2">
										<span slot="title">猪舍历史生猪</span>
									</el-menu-item>
								</router-link>
							</el-submenu>
							<el-submenu index="5">
								<template slot="title">
									<span>屠宰</span>
								</template>
								<router-link to="/Main/Slaughter">
									<el-menu-item index="5-1">
										<span slot="title">屠宰中心</span>
									</el-menu-item>
								</router-link>
								<router-link to="/Main/SlaughterHistory">
									<el-menu-item index="5-2">
										<span slot="title">已屠宰生猪</span>
									</el-menu-item>
								</router-link>
							</el-submenu>
							<el-submenu index="6">
								<template slot="title">
									<span>检验</span>
								</template>
								<router-link to="/Main/TestList">
									<el-menu-item index="6-1">
										<span slot="title">检验报告</span>
									</el-menu-item>
								</router-link>
							</el-submenu>
							<el-submenu index="7">
								<template slot="title">
									<span>销售</span>
								</template>
								<router-link to="/Main/SaleList">
									<el-menu-item index="7-1">
										<span slot="title">销售订单</span>
									</el-menu-item>
								</router-link>
							</el-submenu>
							<el-submenu index="8">
								<template slot="title">
									<span>报损</span>
								</template>
								<router-link to="/Main/LossList">
									<el-menu-item index="8-1">
										<span slot="title">报损列表</span>
									</el-menu-item>
								</router-link>
							</el-submenu>
						</el-submenu>
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
		width: 181px;
		position: fixed;
		top: 0;
		left: 0;
		height: 100%;
		background-color: #32323A;
	}
	
	.main {
		width: calc(100% - 181px);
		position: relative;
		top: 70px;
		left: 181px;
	}
	
	.header {
		position: fixed;
		top: 0;
		left: 181px;
		height: 70px;
		line-height: 70px;
		width: calc(100% - 181px);
		z-index: 1;
		background-color: white;
	}
	
	.logoDiv {
		background-color: #28282E;
		width: 181px;
		height: 191px;
	}
	
	.logoImg {
		margin: 25px 44px 16px 44px;
		width: 92px;
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
		width: 181px;
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
	.el-menu-item,.el-submenu__title,.el-menu-item{
		height: 61px;
		line-height: 61px;
		font-size: 17px;
		text-align: left;
		padding-left: 33px; 
		font-weight: normal;
	}
	.el-submenu .el-menu-item{
		min-width: 100px;
	}
</style>