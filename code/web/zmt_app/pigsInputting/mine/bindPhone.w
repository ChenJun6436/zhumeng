<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;" onLoad="modelLoad"> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" style="background-color:white;border-bottom:1px solid #CCCCCC; " xid="titleBar1">
   <div class="x-titlebar-left" xid="left1">
    <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}" xid="backBtn" style="color:#28282E;">
     <i class="icon-chevron-left" xid="i1"></i>
     <span xid="span1"></span></a> </div> 
   <div class="x-titlebar-title" style="color:#28282E;font-size:17px;line-height:35px;" xid="title1"><![CDATA[绑定手机]]></div>
   <div class="x-titlebar-right reverse" xid="right1"></div></div></div>  
    <div class="x-panel-content" xid="content1">
  
  
  <div xid="div1" style="margin:30px 20px 0px 20px;"><div component="$UI/system/components/justep/row/row" class="x-row" xid="row1" style="border:1px solid #CCCCCC;border-radius: 22px;height:45px;;">
   <div class="x-col x-col-20" xid="col1" style="line-height: 25px;"><![CDATA[手机号]]></div>
   <div class="x-col x-col-50" xid="col2"><input component="$UI/system/components/justep/input/input" class="form-control" xid="newPhone" style="background-color:white; margin-top: -7px;border:0px;padding: 0px;" placeHolder="输入新绑定的手机"></input></div>
   <div class="x-col" xid="col3"><![CDATA[]]>
  <span xid="getCodeBtn" style="background:-webkit-linear-gradient(left, #75DA94, #53C7EE);color:white;height:43px;margin-top:-10px;border-top-right-radius:22px;border-bottom-right-radius:22px;line-height:43px;font-size:14px;text-align:center;display:block;width:116%;" bind-click="span3Click"><![CDATA[获取验证码]]></span></div></div><div component="$UI/system/components/justep/row/row" class="x-row" xid="row2" style="border:1px solid #CCCCCC;border-radius: 22px;height:45px;margin-top:20px;">
   <div class="x-col x-col-20" xid="col4" style="line-height: 34px;"><![CDATA[验证码]]></div>
   <div class="x-col" xid="col6"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input2" style="background-color:white;margin-top: -2px;border:0px;padding: 0px;" placeHolder="输入验证码"></input></div></div><a component="$UI/system/components/justep/button/button" class="btn btn-default" label="确定" xid="button1" style="border:0px;border-radius: 22px;width:100%;background: -webkit-linear-gradient(left, #75DA94, #53C7EE);height:45px;font-size:16px;line-height:30px;margin-top:23px; " onClick="button1Click">
   <i xid="i2"></i>
   <span xid="span2">确定</span></a></div></div>
  </div> 
</div>