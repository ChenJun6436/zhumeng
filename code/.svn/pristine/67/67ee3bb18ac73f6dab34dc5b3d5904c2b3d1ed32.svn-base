<template>

<div class="login_bg1">
    <div class="login_content1">
        <img class="closeBtn" src="../../assets/login_img/ic_close.png" @click="closePage" alt="">
        <div class="login-left1">
             <img src="../../assets/login_img/logo.png" alt="">
        </div>
        <div class="login-right1">
            <p class="login_title1">修改密码！</p>
            <el-form :v-model="formLabelAlign" status-icon :rules="rules1" ref="formLabelAlign"  :label-position="labelPosition" label-width="100px" :model="formLabelAlign">
                <el-form-item label="账号：" style="margin-bottom: 5px;">
                    <span>admin</span>
                </el-form-item>
                <el-form-item label="原密码：" prop="oldPassword">
                    <el-input type="password" placeholder="请输入原始密码" v-model="formLabelAlign.oldPassword"></el-input>
                </el-form-item>
                <el-form-item label="新密码：" prop="password">
                    <el-input type="password" placeholder="数字字母或“_”开头,6-30位" v-model="formLabelAlign.password"></el-input>
                </el-form-item>
                <el-form-item label="确认新密码：" prop="commitPass">
                    <el-input type="password" placeholder="数字字母或“_”开头,6-30位" v-model="formLabelAlign.commitPass"></el-input>
                </el-form-item>
            </el-form>
            <div>
                <button class="sign_in1" @click="updatePs('formLabelAlign')">确定</button>
            </div>
        </div>
    </div>

</div>
  
</template>

<script>
import myServices from '../../server/myServer'
export default {
    name:'ForgetPass',
    data () {
        //输入密码的验证
        var validateOrginPass = (rule,value,callback) =>{
            if(value===''){
                callback(new Error('请先输入旧密码！'))
            }
            callback();
        }
        //输入新密码的验证
        var validatePass = (rule,value,callback) =>{
            var regText1 = /^[1][0-9a-zA-Z\_]{5,30}$/
            if(value ===''){
                callback(new Error('请先输入新密码！'))
            }else if(value ===this.formLabelAlign.oldPassword){
                callback(new Error('旧密码不能与新密码一致！'))
            }else if(!regText1.test(value)){
                callback(new Error('数字字母或“_”开头,6-30位'))
            }
            callback();
        };
        //确认输入密码的验证
        var validatenewPass = (rule,value,callback) =>{
            if(value ===''){
                callback(new Error('请再次输入新密码！'))
            }else if(value !==this.formLabelAlign.password){
                callback(new Error('两次输入的密码不一致！'))
            }else{
                callback();
            }
        }
        return {
            labelPosition:'left',
            ajaxData:{},
            formLabelAlign:{
                oldPassword:'',
                password:'',
                commitPass:''
            },
            rules1:{
                oldPassword:[{
                    validator: validateOrginPass, trigger: 'blur'
                }],
                password:[{
                    validator: validatePass, trigger: 'blur'
                }],
                commitPass:[{
                    validator: validatenewPass, trigger: 'blur'
                }]

            }
        }
    },
    methods:{
        //修改密码确认按钮
        updatePs(formLabelAlign){
            let me = this;
             me.$refs[formLabelAlign].validate((valid) => {
                if (valid) {
                    myServices()._upDatePass(me.formLabelAlign).then(function(res){
                    let Data = res.data;
                    if(Data.success){
                        me.$message({
                            message: '修改成功，即将跳转页面请重新登录！',
                            type: 'success'
                        });
                        setTimeout(function(){
                            me.$router.push({ path: '/' })
                        },3000)

                    }

                })
                    
                } else {
                    return false;
                }
            });
            
        },
        //关闭当前按钮，返回到登录页面
        closePage(){
            this.$router.push({ path: '/' })
        }

    }
}
</script>

<style>
.login_bg1{
    background-image: url(./../../assets/login_img/pic_backgroud.jpg);
    position: absolute;
    width: 100%;
    height: 100%;
    background-size: cover;
    background-repeat: no-repeat;
    background-position: 50% 50%;

}
.login_content1{
    position: absolute;
    -webkit-box-shadow: 1px 2px 10px 0 rgba(0, 0, 0, 0.1);
    box-shadow: 1px 2px 10px 0 rgba(0, 0, 0, 0.1);
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    width: 660px;
    /* height: 420px; */
    background-color: #fff;
    left: 50%;
    top: 50%;
    margin: -165px -270px;
}
.login-left1{
    float: left;
    width: 279px;
    margin-top: 60px;
    text-align: center;
}
.login-right1{
    width: 340px;
    margin: 45px 0;
    /* padding: 0 50px; */
    float: left;
    border-left: 1px solid #EFF2F6;
}
.el-form{
    margin-left: 45px;
}
.el-form-item{
    margin-bottom: 20px;

}
.el-input__inner{
    border: 1px solid #ECEEF3;
    border-radius: 0px;
    background-color: #F8F9FB;
}
.el-form-item__label{
    color: #19253C;
}
.login_title1{
   color:#19253C;
   font-size: 18px;
   text-align: center;
   margin-bottom: 22px;
}
.closeBtn{
    margin-top: 20px;
}

.sign_in1{
    width: 292px;
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
 
</style>


