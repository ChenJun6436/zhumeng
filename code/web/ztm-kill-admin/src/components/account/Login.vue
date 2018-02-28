<template>

<div class="login_bg">
    <div class="login_content">
        <div class="login-left">
             <img src="../../assets/login_img/logo.png" alt="">
        </div>
        <div class="login-right">
            <p class="login_title">欢迎登录！</p>
            <div class="importBox">
                <img  src="../../assets/login_img/ic_user.png" alt="">
                <input class="" id="" v-model="ajaxData.username" placeholder="请输入账号" type="text" name="account" maxlength="15">
            </div>
            <div class="importBox">
                <img src="../../assets/login_img/ic_password.png" alt="">
                <input class="" id="" v-model="ajaxData.password" placeholder="请输入密码" type="password" name="password" maxlength="30">
            </div>
            <div class="updatePass">
                <span class="updatePassBtn"  style="cursor:pointer;" @click="updatePass">修改密码</span>
                <el-checkbox label="记住密码" name="type" class="remberMe"></el-checkbox>
            </div>
            <div>
                <button class="sign_in" style="cursor:pointer;" @click="sign_in">登录</button>
            </div>
        </div>
    </div>

</div>
  
</template>

<script>
// import myServices from '../../server/myServer'
import myServices from '../../server/myServer'
export default {
    name:'Login',
    data () {
        return {
            ajaxData:{},
        }
    },
    methods:{

        //登录按钮
        sign_in(){
            let me = this;
            myServices()._login(me.ajaxData).then(function(res){
                let Data = res.data;
                if(Data.success){
                    me.$message({
                        message: '登录成功，正在为您跳转',
                        type: 'success'
                    });
                    setTimeout(function(){
                        me.$router.push({ path: '/Main/PictureManage' })
                    },3000)

                }

            })
        },
        //修改密码
        updatePass(){
            this.$router.push({path:'/ForgetPass'})

        }


    }
}
</script>

<style>
.login_bg{
    background-image: url(./../../assets/login_img/pic_backgroud.jpg);
    position: absolute;
    width: 100%;
    height: 100%;
    background-size: cover;
    background-repeat: no-repeat;
    background-position: 50% 50%;

}
.login_content{
    position: absolute;
    -webkit-box-shadow: 1px 2px 10px 0 rgba(0, 0, 0, 0.1);
    box-shadow: 1px 2px 10px 0 rgba(0, 0, 0, 0.1);
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    width: 620px;
    height: 380px;
    background-color: #fff;
    left: 50%;
    top: 50%;
    margin: -165px -270px;
}
.login-left{
    float: left;
    width: 279px;
    margin-top: 60px;
    text-align: center;
}
.login-right{
    width: 340px;
    margin: 45px 0;
    /* padding: 0 50px; */
    float: left;
    border-left: 1px solid #EFF2F6;
}
.importBox{
    width: 241px;
    height: 41px;
    border: 1px solid #ECEEF3;
    background-color:#F8F9FB; 
    margin-bottom:12px;
    margin-left: 49px; 
}
.importBox input{
    width: 80%;
    height: 41px;
    border:0px;
    outline: 0px;
    background-color:#F8F9FB;

}
.importBox img{
    vertical-align: middle;
    margin-left: 10px;
    margin-right: 12px;
}
.login_title{
   color:#19253C;
   font-size: 18px;
   text-align: center;
   margin-bottom: 22px;
}
.updatePass{
    clear: both;
    margin-top: 15px;
    margin-left: 49px; 
}
.updatePass,.updatePassBtn{
    color: #1FB5AD;
    /*cursor: pointer;*/
}
.remberMe{
    float: right;
    margin-right: 46px;
}
.sign_in{
    width: 241px;
    height: 41px;
    text-align:center;
    color: white;
    vertical-align: middle;
    font-size: 16px;
    background-color: #1FB5AD;
    margin-left: 49px;
    border: 0px;
    outline: 0px;
    margin-top: 22px;
    margin-bottom: 20px;
    }
    /* 修改记住框的样式 */
    .el-checkbox__input.is-checked+.el-checkbox__label{
        color: #1FB5AD;
    }
    .el-checkbox__input.is-checked .el-checkbox__inner, .el-checkbox__input.is-indeterminate .el-checkbox__inner{
        background-color: #1FB5AD;
        border-color: #1FB5AD;
    }
    .el-checkbox__input.is-focus .el-checkbox__inner{
        border-color: #1FB5AD;
    }

</style>


