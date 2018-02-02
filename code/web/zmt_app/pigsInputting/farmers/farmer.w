<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:241px;left:142px;" onLoad="modelLoad" onActive="modelActive" onParamsReceive="modelParamsReceive" onunLoad="modelUnLoad"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="farmerData" idColumn="id" onCustomRefresh="farmerDataCustomRefresh"><column label="id" name="id" type="String" xid="xid1"></column>
  <column label="创建时间" name="createTime" type="String" xid="xid2"></column>
  <column label="姓名" name="userName" type="String" xid="xid3"></column>
  <column label="电话" name="phone" type="String" xid="xid4"></column>
  <column label="类型" name="farmType" type="String" xid="xid5"></column>
  <column label="地址" name="address" type="String" xid="xid6"></column>
  <column label="饲料名称" name="fooderName" type="String" xid="xid7"></column>
  <column label="账号" name="account" type="String" xid="xid8"></column></div></div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" style="background-color:#FFFFFF;border-bottom:1px solid #CCCCCC;" xid="titleBar1">
   <div class="x-titlebar-left" xid="left1">
    </div> 
   <div class="x-titlebar-title" style="color:#28282E;line-height:35px;font-size:17px;" xid="title1">我的养殖户</div>
   <div class="x-titlebar-right reverse" xid="right1">
    <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon" label="button" xid="button1" icon="img:$UI/pigsInputting/img/add2x.png|" style="color:#28282E;" onClick="button1Click">
     <i xid="i1"></i>
     <img src="$UI/pigsInputting/img/add2x.png" xid="image2" height="15px" style="width:15px;"></img><span xid="span1"></span></a> </div> </div></div>  
    <div class="x-panel-content" xid="content1"><div xid="div3" style="background-color:white;"><div xid="div1" style="border-bottom:1px solid #DDDDDD;height:64px;margin:0px 16px;background-color:white;">
   <p xid="p1" style="padding:16px 0px;">
    <input component="$UI/system/components/justep/input/input" class="form-control" xid="input1" style="height:33px;background-color:#FFFFFF;border-radius: 17px;width:80%;" placeHolder="输入名称/联系方式"></input>
    <img src="$UI/pigsInputting/img/search2x.png" alt="" xid="image1" class="pull-right" style="display:inline-block;width:46px;margin-top:-33px;margin-right: 10px;" height="34px" bind-click="image1Click"></img></p> 
  </div><div xid="div2" style="margin:0px 16px;height:67px;background-color:white;">
   <div component="$UI/system/components/justep/row/row" class="x-row" xid="row2">
    <div class="x-col" xid="col4">
     <input component="$UI/system/components/justep/input/input" class="form-control" xid="startDate" dataType="Date" max="js:new Date()" placeHolder="请选择开始日期" style="background: url($UI/pigsInputting/img/date2x.png) no-repeat 95% !important;color:#CCCCCC;border-radius: 17px;margin-left: -8px;background-size:20px 21px !important;" onChange="startDateChange"></input></div> 
    <div class="x-col x-col-fixed" xid="col6" style="width:auto;padding:10px 0px;">
     <span xid="span2" style="width:auto;">—</span></div> 
    <div class="x-col" xid="col9">
     <input component="$UI/system/components/justep/input/input" class="form-control" xid="endDate" dataType="Date" placeHolder="请选择结束日期" style="background: url($UI/pigsInputting/img/date2x.png) no-repeat 95% !important;color:#CCCCCC;border-radius: 17px;background-size:20px 21px !important;" onChange="endDateChange"></input></div> </div> 
  </div></div>
  
  <p xid="p2" style="height:10px;background-color:#F0F2F4;"></p><div component="$UI/system/components/justep/list/list" class="x-list" xid="list1" data="farmerData" style="background-color:white;">
   <ul class="x-list-template" xid="listTemplateUl1">
     <li xid="li1" bind-click="li1Click" style="border-bottom:1px solid #DDDDDD;height:63px;margin:0px 15px;" class="liList">
     
  <p xid="p3" style="font-size:16px;line-height:50px;padding:0px;margin:0px !important;"><span xid="span3" bind-text='val("createTime")' style="width:28%;display:block;float:left;"><![CDATA[]]></span>
  <span xid="span5" bind-text='val("userName")' style="width:20%;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;display:block;float:left;"><![CDATA[]]></span>
  <span xid="span6" bind-text='val("phone")' style="display:block;float:left;width:30%;"><![CDATA[]]></span>
  <span xid="span7" bind-text='val("farmType")' style="display:block;float:left;"><![CDATA[]]></span>
  <a component="$UI/system/components/justep/button/button" class="btn btn-link pull-right" xid="button2" icon="linear linear-chevronright" style="color:#95A0AA;padding:0px;margin-top:13px;">
   <i xid="i2" class="linear linear-chevronright"></i>
   <span xid="span8"></span></a></p></li></ul> 
  </div></div>
  </div> 
</div>