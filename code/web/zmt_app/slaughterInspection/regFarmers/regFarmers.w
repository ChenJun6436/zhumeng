<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:244px;top:334px;left:424px;"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="regFarmersData" idColumn="id"><column label="ID" name="id" type="String" xid="xid1"></column>
  <column label="密码" name="password" type="String" xid="xid2"></column>
  <column label="养殖户姓名" name="farmerName" type="String" xid="xid3"></column>
  <column label="类型ID" name="typeId" type="String" xid="xid4"></column>
  <column label="类型名称" name="typeName" type="String" xid="xid5"></column>
  <column label="饲料名称" name="feedName" type="String" xid="xid6"></column>
  <column label="创建人ID" name="createrId" type="String" xid="xid7"></column>
  <column label="创建人名称" name="createrName" type="String" xid="xid8"></column>
  <column label="联系电话" name="phone" type="String" xid="xid9"></column>
  <column label="地址" name="address" type="String" xid="xid10"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="createrData" idColumn="createrId"><column label="创建人ID" name="createrId" type="String" xid="xid11"></column>
  <column label="创建人姓名" name="createrName" type="String" xid="xid12"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="typeData" idColumn="typeId"><column label="类型ID" name="typeId" type="String" xid="xid13"></column>
  <column label="类型名称" name="typeName" type="String" xid="xid14"></column></div></div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" title="注册养殖户"
          class="x-titlebar" style="background-color:#3CC6BD;">
          <div class="x-titlebar-left"> 
            <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn"> 
              <i class="icon-chevron-left"/>  
              <span></span> 
            </a> 
          </div>  
          <div class="x-titlebar-title">注册养殖户</div>  
          <div class="x-titlebar-right reverse"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link" label="保存" xid="saveBtn" style="font-size: 15px;font-weight: medium;" onClick="saveBtnClick">
   <i xid="i2"></i>
   <span xid="span2">保存</span></a></div>
        </div> 
      </div>  
    <div class="x-panel-content" xid="content1"><div component="$UI/system/components/justep/controlGroup/controlGroup" class="x-control-group" title="title" xid="controlGroup1">
   <div class="x-control-group-title" xid="controlGroupTitle1">
    <span xid="span4">title</span></div> </div>
  </div>
  </div> 
</div>