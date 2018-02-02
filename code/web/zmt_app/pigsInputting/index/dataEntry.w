<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:520px;left:369px;" onParamsReceive="modelParamsReceive"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="varietyData" idColumn="id"><column label="id" name="id" type="String" xid="xid2"></column>
  <column label="品种名称" name="name" type="String" xid="xid3"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="farmersData" idColumn="famrId"><column label="养殖户id" name="famrId" type="String" xid="xid4"></column>
  <column label="养殖户姓名" name="userName" type="String" xid="xid5"></column>
  <column label="养殖户电话" name="famrphone" type="String" xid="xid1"></column>
  <column label="养殖户地址" name="address" type="String" xid="xid8"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="statusData" idColumn="statusId"><column label="ID" name="statusId" type="String" xid="xid6"></column>
  <column label="状态" name="status" type="String" xid="xid7"></column>
  <data xid="default6">[{&quot;statusId&quot;:&quot;0001&quot;,&quot;status&quot;:&quot;正常&quot;},{&quot;statusId&quot;:&quot;0002&quot;,&quot;status&quot;:&quot;死亡&quot;}]</data></div></div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top2">
   <div component="$UI/system/components/justep/titleBar/titleBar" title="资料录入" class="x-titlebar" style="color:#28282E;font-size:17px;width:100%;;background-color:white;border-bottom-style:solid;border-bottom-width:1px;border-bottom-color:#CCCCCC;" xid="titleBar2">
    <div class="x-titlebar-left" xid="left2">
     <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon" icon="linear linear-chevronleft" onClick="{operation:'window.close'}" xid="backBtn" style="font-weight:200;font-size:17px;color:#28282E;">
      <i class="linear linear-chevronleft" xid="i3"></i>
      <span xid="span3"></span></a> </div> 
    <div class="x-titlebar-title" xid="title2" style="font-size:17px;font-weight:500;color:#28282E;">资料录入</div>
    <div class="x-titlebar-right reverse" xid="right2"></div></div> </div><div class="x-panel-content" xid="content1" style="height:100%;width:100%;position:relative;"><div xid="div1" style="margin:20px auto;width:85%;height:35px;"><div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit1" style="padding:0px 0px 0px 0px;">
        <label class="x-label" xid="id" style="width:25%;"><![CDATA[ID  ：]]></label>
        <input component="$UI/system/components/justep/input/input" class="form-control" xid="idNumber" disabled="true" style="background-color:#FFFFFF;border-color:#ffffff;padding-left: 30px;"></input></div></div>
  <div xid="div2" style="margin:20px auto;width:85%;height:35px;"><div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit2" style="width:100%;padding:0px;">
   <label class="x-label " xid="label1" style="width:25%;"><![CDATA[品 种：]]></label>
   <select component="$UI/system/components/justep/select/select" class="form-control x-edit" xid="variety" bind-options="varietyData" bind-optionsCaption="请选择" bind-optionsValue="id" bind-optionsLabel="name" style="height:35px;width:220px;border-radius:17px;"></select></div></div>
  <div xid="div4" style="margin:20px auto;position:relative;width:85%;height:35px;">
  <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30 pull-left" xid="labelEdit3" style="width:100%;padding:0px;">
    <label class="x-label " xid="label2" style="width:25%;"><![CDATA[养殖户：]]></label>
    <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="farms" placeHolder="姓名/电话" maxLength="25" style="border-radius:17px;width:85%;"></input></div>
  <a component="$UI/system/components/justep/button/button" class="btn btn-link" xid="farmsBtn" style="font-size:16px;color:#AFB7BE;position:absolute;right:0px;top:0px;height:35px;vertical-align:middle;width:15%;" onClick="farmsBtnClick">
   <i xid="i4" class="linear linear-magnifier"></i>
   <span xid="span4" style="font-size:14px;color:#FEFEFE;"></span></a><div component="$UI/system/components/justep/list/list" class="x-list" xid="farmersInfo" style="position:absolute;border-radius:4px;right:0px;width:75%;box-shadow:0 1px 1px rgb(227, 229, 235);background:#FCFCFC;top:38px;color:#28282E;display:none;" autoLoad="true" data="farmersData">
   <ul class="x-list-template" xid="listTemplateUl1">
    <li xid="li1" style="height:35px;width:100%; line-height: 40px;padding-left:15px;" class="famrs" bind-click="li1Click">
  
  
  
  <p xid="famrId" bind-text=' val("famrId")' style="display:none;"></p><p xid="userName" bind-text='val("userName")'></p><p xid="famrphone" bind-text=' val("famrphone")' style="display:none;"></p><p xid="address" bind-text='val("address")' style="display:none;"></p>
  </li></ul> </div></div>
  <div xid="div3" style="margin:20px auto;width:85%;height:35px;display:none;">
   <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit4" style="padding:0px 0px 0px 0px;width:100%;">
    <label class="x-label" xid="label3" style="width:40%;"><![CDATA[养殖户id]]></label>
    <input component="$UI/system/components/justep/input/input" class="form-control" xid="input1" disabled="true" style="background-color:#FFFFFF;border-color:#ffffff;padding:0px;"></input></div> </div><div xid="div5" style="margin:20px auto;width:85%;height:35px;"><div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit7" style="padding:0px 0px 0px 0px;width:100%;">
   <label class="x-label" xid="label6" style="width:40%;"><![CDATA[联系电话：]]></label>
   <input component="$UI/system/components/justep/input/input" class="form-control" xid="phone" disabled="true" style="background-color:#FFFFFF;border-color:#ffffff;padding:0px;"></input></div>
  </div>
  <div xid="div6" style="margin:20px auto;width:85%;height:35px;">
   <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit5" style="padding:0px 0px 0px 0px;width:100%;">
    <label class="x-label " xid="label4" style="width:40%;"><![CDATA[地 址：]]></label>
    <input component="$UI/system/components/justep/input/input" class="form-control" xid="famrsAddress" disabled="true" style="background-color:#FFFFFF;border-color:#ffffff;padding:0px;"></input></div> </div>
  <div xid="div7" style="margin:120px auto 0;width:264px;"><a component="$UI/system/components/justep/button/button" class="btn btn-link" label="上一步" xid=" backStepBtn" style="height:45px;border-radius:22px;line-height:30px;border:1px solid #cccccc;font-size:16px;color:#AFB7BE;width:125px;" onClick=" backStepBtnClick">
   <i xid="i1"></i>
   <span xid="span1" style="font-size:16px;color:#AFB7BF;">上一步</span></a>
  <a component="$UI/system/components/justep/button/button" class="btn btn-default" label="保存" xid="saveBtn" style="height:45px;border-radius:22px;line-height:32px;border:none;background:-webkit-linear-gradient(left, #75DA94, #53C7EE);margin-left:10px;width:125px;" onClick="saveBtnClick">
   <i xid="i7"></i>
   <span xid="span7" style="font-size:16px;color:#FEFEFE;">保存</span></a></div>
  </div>
  </div> 
</div>