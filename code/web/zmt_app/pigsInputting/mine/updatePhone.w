<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:395px;left:103px;height:auto;" onLoad="modelLoad"> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" style="background-color:white;border-bottom:1px solid #CCCCCC; ">
          <div class="x-titlebar-left"> 
            <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn" style="color:#28282E;"> 
              <i class="icon-chevron-left"/>  
              <span></span> 
            </a> 
          </div>  
          <div class="x-titlebar-title" style="color:#28282E;font-size:17px;line-height:35px;"><![CDATA[修改手机号]]></div>  
          <div class="x-titlebar-right reverse"> 
          </div>
        </div> 
      </div>  
    <div class="x-panel-content" xid="content1"><div xid="div1" style="padding:0px 19px 0px 16px;"><div component="$UI/system/components/justep/row/row" class="x-row" xid="row1" style="margin-top:16px;height:45px;">
   <div class="x-col x-col-fixed" xid="col1" style="color:#28282E;font-size:15px;line-height:35px;"><![CDATA[手机号]]></div>
   <div class="x-col x-col-fixed" xid="col2" style="color:#28282E;font-size:15px;line-height:35px;"><![CDATA[]]></div>
   <div class="x-col x-col-fixed" xid="col3" style="padding:0px;"><a component="$UI/system/components/justep/button/button" class="btn btn-default pull-right" label="获取验证码" xid="codeBtn" style="height:40px;border-radius: 20px;background: -webkit-linear-gradient(left, #75DA94, #53C7EE);border:0;" onClick="button1Click">
   <i xid="i1"></i>
   <span xid="span1">获取验证码</span></a></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row2" style="margin-top:30px;border:1px solid #DCDCDC;border-radius: 22px;height:45px;">
   <div class="x-col x-col-33" xid="col5" style="line-height:35px;font-size:15px;color:#28282E;"><![CDATA[验证码]]></div>
   <div class="x-col" xid="col6"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input1" style="outline:0px;background-color:white;border:0px;margin-top:-2px;padding:0px;height:36px;font-size:15px;line-height:35px;" placeHolder="请输入验证码"></input></div></div><a component="$UI/system/components/justep/button/button" class="btn btn-default" label="确定" xid="button2" style="width:100%;border-radius:20px;background:-webkit-linear-gradient(left, #75DA94, #53C7EE);border:0;height:45px;font-size:16px;line-height:30px;margin-top:23px;" onClick="button2Click">
   <i xid="i2"></i>
   <span xid="span2">确定</span></a>
  </div></div>
  </div> 
</div>