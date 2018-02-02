<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:524px;left:271px;height:auto;" onLoad="modelLoad"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="addressData" idColumn="district" onCustomRefresh="addressDataCustomRefresh"><column label="区/县" name="district" type="String" xid="xid1"></column>
  <column label="市" name="city" type="String" xid="xid2"></column>
  <column label="省" name="province" type="String" xid="xid3"></column>
  <column label="镇" name="town" type="String" xid="xid4"></column>
  <column label="乡" name="village" type="String" xid="xid5"></column>
  <column label="省label" name="provinceLabel" type="String" xid="xid19"></column>
  <column label="市的label" name="cityLabel" type="String" xid="xid20"></column>
  <column label="区的label" name="districtLabel" type="String" xid="xid21"></column>
  <column label="镇的label" name="townLabel" type="String" xid="xid22"></column>
  <column label="乡的label" name="villageLabel" type="String" xid="xid23"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="provinceData" idColumn="id">
   <column label="id" name="id" type="String" xid="column1"></column>
   <column label="option的id" name="fValue" type="String" xid="column2"></column>
   <column label="option的label" name="fLabel" type="String" xid="xid6"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="cityData" idColumn="id">
   <column label="id" name="id" type="String" xid="xid7"></column>
   <column label="value" name="fValue" type="String" xid="xid8"></column>
   <column label="label" name="fLabel" type="String" xid="xid9"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="districtData" idColumn="id">
   <column label="id" name="id" type="String" xid="xid10"></column>
   <column label="value" name="fValue" type="String" xid="xid11"></column>
   <column label="label" name="fLabel" type="String" xid="xid12"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="townData" idColumn="id">
   <column label="id" name="id" type="String" xid="xid13"></column>
   <column label="value" name="fValue" type="String" xid="xid14"></column>
   <column label="label" name="fLabel" type="String" xid="xid15"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="villageData" idColumn="id">
   <column label="id" name="id" type="String" xid="xid16"></column>
   <column label="value" name="fValue" type="String" xid="xid17"></column>
   <column label="label" name="fLabel" type="String" xid="xid18"></column></div>
  </div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" style="background-color:white;border-bottom:1px solid #CCCCCC; " xid="titleBar1">
   <div class="x-titlebar-left" xid="left1">
    <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}" xid="backBtn" style="color:#28282E;">
     <i class="icon-chevron-left" xid="i1"></i>
     <span xid="span1"></span></a> </div> 
   <div class="x-titlebar-title" style="color:#28282E;font-size:17px;line-height:35px;" xid="title1"><![CDATA[地址管理]]></div>
   <div class="x-titlebar-right reverse" xid="right1"></div></div></div>  
    <div class="x-panel-content" xid="content1">
  
  
  
  <div xid="div1" style="margin:23px 20px 0px 20px;"><div component="$UI/system/components/justep/row/row" class="x-row" xid="row1" style="height:45px;">
   <div class="x-col x-col-25" xid="col2"><![CDATA[地址：]]></div>
   <div class="x-col" xid="col3"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select1" style="background-color:white;border-radius: 17px;margin-top: -7px;" bind-optionsValue="fValue" bind-optionsLabel="fLabel" bind-options="provinceData" bind-ref='$model.addressData.ref("province")' onChange="select1Change" bind-labelRef='$model.addressData.ref("provinceLabel")'></select></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row2" style="margin:5px 0px;height:45px;">
   <div class="x-col x-col-25" xid="col5"></div>
   <div class="x-col" xid="col6"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select2" style="background-color:white;border-radius: 17px;" bind-optionsValue="fValue" bind-optionsLabel="fLabel" bind-options="cityData" bind-ref='$model.addressData.ref("city")' onChange="select2Change" bind-labelRef='$model.addressData.ref("cityLabel")'></select></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row3" style="height:45px;">
   <div class="x-col x-col-25" xid="col8"></div>
   <div class="x-col" xid="col9"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select3" style="background-color:white;border-radius: 17px;" bind-optionsValue="fValue" bind-optionsLabel="fLabel" bind-options="districtData" bind-ref='$model.addressData.ref("district")' onChange="select3Change" bind-labelRef='$model.addressData.ref("districtLabel")'></select></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row4" style="margin:5px 0px;height:45px;">
   <div class="x-col x-col-25" xid="col11"></div>
   <div class="x-col" xid="col12"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select4" style="background-color:white;border-radius: 17px;" bind-optionsValue="fValue" bind-optionsLabel="fLabel" bind-options="townData" bind-ref='$model.addressData.ref("town")' onChange="select4Change" bind-labelRef='$model.addressData.ref("townLabel")'></select></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row5" style="height:45px;">
   <div class="x-col x-col-25" xid="col13"></div>
   <div class="x-col" xid="col14"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select5" style="background-color:white;border-radius: 17px;" bind-optionsValue="fValue" bind-optionsLabel="fLabel" bind-options="villageData" bind-ref='$model.addressData.ref("village")' bind-labelRef='$model.addressData.ref("villageLabel")'></select></div>
   </div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row6" style="margin-top:5px;height:45px;">
   <div class="x-col x-col-20" xid="col17"></div>
   <div class="x-col" xid="col18"><img src="$UI/pigsInputting/img/2x.png" alt="" xid="image1" height="14px" style="width:14px;margin-left:5px;"></img>
  <span xid="span2" style="color:#95A0AA;font-size:14px"><![CDATA[找不到我所在地址？联系平台客服]]></span></div></div>
  <a component="$UI/system/components/justep/button/button" class="btn btn-default" label="保存" xid="button1" style="background:-webkit-linear-gradient(left, #75DA94, #53C7EE);border-radius:22px;border:0px;width:100%;margin-top:10px;height:45px;line-height:30px;font-size:16px;" onClick="button1Click">
   <i xid="i2"></i>
   <span xid="span3">保存</span></a></div></div>
  </div> 
</div>