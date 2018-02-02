<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:622px;left:456px;height:auto;"> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" style="background-color:white;border-bottom:1px solid #CCCCCC; " xid="titleBar1">
   <div class="x-titlebar-left" xid="left1">
    <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}" xid="backBtn" style="color:#28282E;">
     <i class="icon-chevron-left" xid="i1"></i>
     <span xid="span1"></span></a> </div> 
   <div class="x-titlebar-title" style="color:#28282E;font-size:17px;line-height:35px;" xid="title1"><![CDATA[修改密码]]></div>
   <div class="x-titlebar-right reverse" xid="right1"></div></div></div>  
    <div class="x-panel-content" xid="content1"><div xid="div1" style="margin:30px 20px 0px 20px;"><div component="$UI/system/components/justep/row/row" class="x-row" xid="row1" style="border:1px solid #CCCCCC;border-radius: 22px;height:45px;">
   <div class="x-col x-col-33" xid="col1" style="line-height: 23px;padding-left:10px;font-size: 16px;"><![CDATA[原始密码]]></div>
   <div class="x-col" xid="col3"><input component="$UI/system/components/justep/input/password" class="form-control" xid="oldPassWord" placeHolder="输入原始密码" style="background-color:white;margin-top: -8px;border:0px;font-size: 16px;"></input></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row2" style="margin:20px 0px;border:1px solid #CCCCCC;border-radius: 22px;height:45px;">
   <div class="x-col x-col-33" xid="col5" style="line-height: 31px;padding-left:10px;font-size: 16px;"><![CDATA[新密码]]></div>
   <div class="x-col" xid="col6"><input component="$UI/system/components/justep/input/password" class="form-control" xid="newPassWord" placeHolder="输入新密码" style="background-color:white;margin-top: -2px;border:0px;font-size: 16px;" bind-blur="newPassWordBlur"></input></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row3" style="border:1px solid #CCCCCC;border-radius: 22px;height:45px;">
   <div class="x-col x-col-33" xid="col8" style="line-height: 31px;padding-left:10px;font-size: 16px;"><![CDATA[确认密码]]></div>
   <div class="x-col" xid="col9"><input component="$UI/system/components/justep/input/password" class="form-control" xid="conNewPassWord" placeHolder="请确认密码" style="background-color:white;margin-top: -2px;border:0px;font-size: 16px;" bind-blur="conNewPassWordBlur"></input></div></div>
  <a component="$UI/system/components/justep/button/button" class="btn btn-default" label="确定" xid="button1" style="margin-top:20px;border:0px;border-radius: 22px;width:100%;background: -webkit-linear-gradient(left, #75DA94, #53C7EE);height:45px;font-size:16px;line-height:30px;margin-top:23px; " onClick="button1Click">
   <i xid="i2"></i>
   <span xid="span2">确定</span></a>
  <p xid="p1" style="margin-top:20px;"><span xid="span3" style="margin-left:35%;"><img src="$UI/pigsInputting/img/2x.png" alt="" xid="image1" height="14px" style="width:14px;"></img>
  <span xid="span4" style="margin-left:5px;font-size:14px;color:#95A0AA;" bind-click="span4Click"><![CDATA[忘记密码?]]></span></span>
  </p></div></div>
  </div> 
</div>