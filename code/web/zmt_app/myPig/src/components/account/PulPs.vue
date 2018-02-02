<template>
  <div class="login-box">
    <Top :HRight='HRight' :HTitle='HTitle' :toUrl='toUrl'></Top>
    <div class="input_box">
      <span class="input_left">原始密码</span>
      <input class="input" type="password" name="" v-model='oldPs' placeholder="请输入原始密码">
    </div>
    <div class="input_box">
      <span class="input_left">新密码</span>
      <input class="input" type="password" name=""  v-model='newPs' placeholder="请输入新密码">
    </div>
    <div class="input_box">
      <span class="input_left">确认密码</span>
      <input class="input" type="password" name=""  v-model='newPs2' placeholder="请确认密码">
    </div>
    <BigBtn @Click='sure' :btnName='btnName' :flag='flag'></BigBtn>
  </div>
</template>

<script>
import crypto from 'crypto'

import BigBtn from './../common/BigBtn'
import Top from './../common/Top'

import server from '../../server/myServer'

export default {
  name: 'PulPs',
  data () {
    return {
      HRight: '',
      HTitle: '修改密码',
      toUrl:'/Main/Percenter',
      btnName: '保存',
      oldPs: '',
      newPs: '',
      newPs2: '',
      flag: true
    }
  },
  methods: {
    getmd5(pass){
        var md5String = ''
        var md5 = crypto.createHash("md5")
        md5.update(pass)
        var md5String = md5.digest('hex')
        return md5String
    },
    sure() {
      let vm = this
      
      vm.oldPs = vm.oldPs.replace(/(^\s+)|(\s+$)/g, "")
      vm.newPs = vm.newPs.replace(/(^\s+)|(\s+$)/g, "")
      vm.newPs2 = vm.newPs2.replace(/(^\s+)|(\s+$)/g, "")
      if(vm.oldPs !== ''){
        if(vm.newPs2 !== ''){
          if(/^[a-zA-Z0-9]{6,15}$/.test(vm.newPs2) ){
            if(vm.newPs === vm.newPs2){
              vm.flag = false
              let pulData = {
                account: JSON.parse(localStorage.getItem('userInfo')).loginName,
                password: vm.getmd5(vm.oldPs),
                newPassword: vm.getmd5(vm.newPs2),
              }
              server()._pulPs(pulData).then(function(res){
                if(res.data.code === '0'){
                  vm.$msg('修改密码成功,请重新登录')
                  localStorage.removeItem('userInfo')
                  setTimeout(function(){
                    vm.$router.push('/Login')
                  }, 1500)
                }else {
                  vm.$msg(res.data.message)
                  vm.flag = true

                }
              })
            }else {
              vm.$msg('两次密码输入不一致')
            }
          }else {
            vm.$msg('6~15位数字或字母组合')
          }
        }else {
          vm.$msg('请输入新密码')
        }
      }else {
        vm.$msg('请输入原始密码')
      }
    },
  },
  components: {
    BigBtn, Top
  },
  created() {
    console.log(1)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    .input_box{
      width: 6.8rem;
      border: 1px solid #e3e3e3;
      .input_left{
        width: 1.2rem;
      }
    }
    .btn-box{
      width: 6.8rem;
    }
  }
</style>
