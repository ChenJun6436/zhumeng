<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="personalData" idColumn="id" onCustomRefresh="personalDataCustomRefresh">
   <column label="ID" name="id" type="String" xid="xid1"></column>
   <column label="姓名" name="name" type="String" xid="xid2"></column>
   <column label="电话" name="phone" type="String" xid="xid3"></column></div></div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" title="个人信息"
          class="x-titlebar" style="background-color:#3CC6BD;">
          <div class="x-titlebar-left"> 
            <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn"> 
              <i class="icon-chevron-left"/>  
              <span></span> 
            </a> 
          </div>  
          <div class="x-titlebar-title">个人信息</div>  
          <div class="x-titlebar-right reverse"> 
          </div>
        </div> 
      </div>  
    <div class="x-panel-content" xid="content1">
  
  <div component="$UI/system/components/justep/list/list" class="x-list" xid="list1" data="personalData">
   <ul class="x-list-template" xid="listTemplateUl1">
    <li xid="li1"><div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit1" style="margin-top:30px;padding:10px;">
   <label class="x-label" xid="label1"><![CDATA[姓名]]></label>
   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="name" bind-ref='ref("name")'></input></div>
  <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit2" style="margin-top:30px;padding:0px 10px;">
   <label class="x-label" xid="label2"><![CDATA[电话号码]]></label>
   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="phone" bind-ref='ref("phone")'></input></div></li></ul> </div><div component="$UI/system/components/justep/row/row" class="x-row" xid="row1" style="margin-top:30px;">
   <div class="x-col" xid="col1"></div>
   <div class="x-col x-col-fixed" xid="col2" style="width:auto;">
    <a component="$UI/system/components/justep/button/button" class="btn btn-link" label="确定" xid="confirm" style="background-color:#3CC6BD;padding:8px 20px;border-radius:3px;border-color:#3CC6BD；;color:#FFFFFF;" onClick="confirmClick">
     <i xid="i10"></i>
     <span xid="span15">确定</span></a> </div> 
   <div class="x-col" xid="col3"></div></div>
  </div>
  </div> 
</div>