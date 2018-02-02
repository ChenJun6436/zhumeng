<?xml version="1.0" encoding="UTF-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" xid="window" class="window" component="$UI/system/components/justep/window/window" design="device:m;">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;left:258px;top:435px;"/> 

  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
   <div class="x-panel-top" xid="top1"><div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" xid="titleBar1" style="background-color:#3CC6BD;">
   <div class="x-titlebar-left" xid="left1"></div>
   <div class="x-titlebar-title" xid="title1"><span xid="span1" style="font-weight:normal;">登录</span></div>
   <div class="x-titlebar-right reverse" xid="right1"></div>
  </div></div>
   <div class="x-panel-content" xid="content1"><div class="list-group" xid="listGroup2" style="margin-top:30px;">
   
   
   <div xid="div2" class="list-group-item">
   <div class="input-group" component="$UI/system/components/bootstrap/inputGroup/inputGroup" xid="inputGroup1">
    <span class="input-group-addon" xid="span3">账号</span>
    <input type="text" class="form-control" component="$UI/system/components/justep/input/input" xid="nameInput" placeHolder="请输入账号"></input></div> </div><div xid="div3" class="list-group-item">
   <div class="input-group" component="$UI/system/components/bootstrap/inputGroup/inputGroup" xid="inputGroup2">
    <span class="input-group-addon" xid="span4">密码</span>
    <input component="$UI/system/components/justep/input/password" class="form-control" xid="passwordInput" placeHolder="请输入密码"></input></div> </div>
  <div xid="div5" class="list-group-item" style="margin-top:50px;">
   <a component="$UI/system/components/justep/button/button" class="btn btn-default btn-block" label="登录" xid="loginBtn" onClick="loginBtnClick" style="background-color:#3CC6BD;border-color:#3CC6BD;">
    <i xid="i1"></i>
    <span xid="span6">登录</span></a> </div>
  <div xid="div6" class="list-group-item" align="center">
   <a component="$UI/system/components/justep/button/button" class="btn btn-link" label="没有账号？马上注册" xid="registerBtn" style="color:#3CC6BD;" onClick="registerBtnClick">
    <i xid="i2"></i>
    <span xid="span7">没有账号？马上注册</span></a> 
   </div></div></div>
   </div></div>