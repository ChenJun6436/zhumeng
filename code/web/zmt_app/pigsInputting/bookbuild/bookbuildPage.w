<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:203px;left:245px;" onParamsReceive="modelParamsReceive" onunLoad="modelUnLoad" onLoad="modelLoad"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="bookbuildData" idColumn="id" onCustomRefresh="bookbuildDataCustomRefresh"><column label="id" name="id" type="String" xid="xid1"></column>
  <column label="生猪唯一标签" name="sign" type="String" xid="xid2"></column>
  <column label="创建时间" name="createTime" type="String" xid="xid3"></column></div></div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" title="建档记录" class="x-titlebar" style="background-color:white;border-bottom:1px solid #CCCCCC; " xid="titleBar2">
   <div class="x-titlebar-left" xid="left2">
    </div> 
   <div class="x-titlebar-title" xid="title2" style="color:#28282E;font-size:17px;line-height:35px;">建档记录</div>
   <div class="x-titlebar-right reverse" xid="right2"></div></div></div>  
    <div class="x-panel-content" xid="content1">
  <div xid="div1" style="margin:0 auto;border-bottom:1px solid #DDDDDD;padding:15px 0;width:90%;"><input component="$UI/system/components/justep/input/input" class="form-control pull-left" xid="searchInput" style="border-radius:17px;width:80%;" placeHolder="输入ID" maxLength="30"></input>
  <img src="$UI/pigsInputting/img/search2x.png" alt="" xid="searchBtn" height="35px" style="margin-left:5px;width:50px;margin-top:2px;" bind-click="searchBtnClick"></img></div><div component="$UI/system/components/justep/row/row" class="x-row" xid="row2" style="margin-top:5px;">
   <div class="x-col" xid="col4"><input component="$UI/system/components/justep/input/input" class="form-control" xid="startDate" dataType="Date" max="js:new Date()" placeHolder="请选择开始日期" style="border-radius:17px" onChange="startDateChange"></input></div>
   <div class="x-col x-col-fixed" xid="col6" style="width:auto;padding:10px 0px;"><span xid="span1" style="width:auto;"><![CDATA[—]]></span></div><div class="x-col" xid="col9"><input component="$UI/system/components/justep/input/input" class="form-control" xid="endDate" dataType="Date" bind-click="endDateClick" placeHolder="请选择结束日期" style="border-radius:17px" max="js:new Date()" onChange="endDateChange"></input></div></div>
  <div xid="div3" style="width:100%;height:10px;background-color:#F0F2F4;"></div><div component="$UI/system/components/justep/list/list" class="x-list" xid="list1" data="bookbuildData" style="padding:0px 15px;">
   <ul class="x-list-template" xid="listTemplateUl1">
    <li xid="li1">
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="person" style="border-bottom:solid 1px  #DDDDDD;height:45px;padding:0px;" bind-click="personClick">
   <div class="x-col" xid="col10" style="height:45px;padding:0px;"><div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit1" style="height:45px;font-size:16px;color:#28282E;">
   <label class="x-label " xid="label1" style="padding:0px;width:35px;"><![CDATA[ID:]]></label>
   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="sign" style="border-color:#FFFFFF;padding:0px;background-color:#FFFFFF;font-size:16px;color:#28282E;" disabled="true" bind-text=' val("sign")' bind-ref='ref("sign")'></input></div></div>
   <div class="x-col" xid="col12" style="padding:0px"><span xid="createTime" bind-text='val("createTime")' style="margin-left:40px;color:#95A0AA;line-height:45px;font-size:15px;"></span></div>
  <div class="x-col x-col-fixed" xid="col13" style="width:auto;padding:0px;"><a component="$UI/system/components/justep/button/button" class="btn btn-link" xid="button1" icon="icon-chevron-right" style="color:#C0C0C0;width:10px;padding:0px;margin-top:10px;height:100%;">
   <i xid="i1" class="icon-chevron-right"></i>
   <span xid="span4"></span></a></div></div>
  
  </li></ul> </div>
  </div>
  </div> 
</div>