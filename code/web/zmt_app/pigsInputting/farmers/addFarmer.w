<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:148px;left:197px;" onLoad="modelLoad"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="typeData" idColumn="id"><column isCalculate="false" label="id" name="id" type="String" xid="xid1"></column>
  <column label="显示的值" name="fValue" type="String" xid="xid2"></column>
  <column label="隐藏的id" name="fId" type="String" xid="xid3"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="provinceData" idColumn="id"><column label="id" name="id" type="String" xid="xid4"></column>
  <column label="option的id" name="fValue" type="String" xid="xid5"></column>
  <column label="option的label" name="fLabel" type="String" xid="xid6"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="cityData" idColumn="id"><column label="id" name="id" type="String" xid="xid7"></column>
  <column label="value" name="fValue" type="String" xid="xid8"></column>
  <column label="label" name="fLabel" type="String" xid="xid9"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="districtData" idColumn="id"><column label="id" name="id" type="String" xid="xid10"></column>
  <column label="value" name="fValue" type="String" xid="xid11"></column>
  <column label="label" name="fLabel" type="String" xid="xid12"></column></div><div component="$UI/system/components/justep/data/data" autoLoad="true" xid="townData" idColumn="id"><column label="id" name="id" type="String" xid="xid13"></column>
  <column label="value" name="fValue" type="String" xid="xid14"></column>
  <column label="label" name="fLabel" type="String" xid="xid15"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="villageData" idColumn="id"><column label="id" name="id" type="String" xid="xid16"></column>
  <column label="value" name="fValue" type="String" xid="xid17"></column>
  <column label="label" name="fLabel" type="String" xid="xid18"></column></div>
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="data1" idColumn="id"><column label="ID" name="id" type="String" xid="xid19"></column>
  <column label="电话号码" name="tel" type="String" xid="xid20"></column></div></div>  
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
          <div class="x-titlebar-title" style="color:#28282E;font-size:17px;line-height:35px;"><![CDATA[新建养殖户]]></div>  
          <div class="x-titlebar-right reverse"> 
          </div>
        </div> 
      </div>  
    <div class="x-panel-content" xid="content1"><div xid="div1" style="margin-left:20px;margin-top:25px;"><div component="$UI/system/components/justep/row/row" class="x-row" xid="row1">
   <div class="x-col x-col-33" xid="col1" bind-html="'账&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;号：'"></div>
   <div class="x-col" xid="col3"><![CDATA[JD字母+9位数字账号]]></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row2" style="margin-top:5px;">
   <div class="x-col x-col-33" xid="col5" bind-html="'密&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;码：'"></div>
   <div class="x-col" xid="col4"><![CDATA[ZMT123456]]></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row3" style="margin-top:5px;height:35px;line-height:35px;">
   <div class="x-col x-col-33" xid="col7" bind-html="'姓&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;名：'"></div>
   <div class="x-col" xid="col6"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input1" style="background-color:white;border-radius:17px;line-height:30px;height:35px;width:95%;" maxLength="15"></input></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row4" style="margin-top:10px;height:35px;line-height:35px;">
   <div class="x-col x-col-33" xid="col9"><![CDATA[联系电话：]]></div>
   <div class="x-col" xid="col8"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input2" style="background-color:white;border-radius:17px;line-height:30px;height:35px;width:95%;" maxLength="11"></input></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row5" style="margin-top:10px;height:35px;line-height:35px;">
   <div class="x-col x-col-33" xid="col11" bind-html="'类&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;型：'"></div>
   <div class="x-col" xid="col10"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select2" style="border-radius:17px;line-height:30px;height:35px;width:95%;" bind-options="typeData" bind-optionsValue="fId" bind-optionsLabel="fValue"></select></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row6" style="margin-top:10px;height:35px;line-height:35px;">
   <div class="x-col x-col-33" xid="col13"><![CDATA[饲料名称：]]></div>
   <div class="x-col" xid="col12"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input3" style="background-color:white;border-radius:17px;line-height:30px;height:35px;width:95%;" placeHolder="养殖户使用的饲料名称" maxLength="15"></input></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row7" style="margin-top:10px;height:35px;line-height:35px;">
   <div class="x-col x-col-33" xid="col15"><![CDATA[养殖地址：]]></div>
   <div class="x-col" xid="col14"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select3" style="border-radius:17px;line-height:30px;height:35px;width:95%;" bind-options="provinceData" bind-optionsValue="fValue" bind-optionsLabel="fLabel" onChange="select3Change"></select></div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row8" style="margin-top:10px;height:35px;line-height:35px;">
   <div class="x-col x-col-33" xid="col16"><![CDATA[]]></div>
   
  <div class="x-col" xid="col30" style="margin-left:-5px;">
   <div component="$UI/system/components/justep/row/row" class="x-row" xid="row13" style="margin:0px;padding:0px;height:35px;line-height:35px;">
    <div class="x-col" xid="col32">
     <select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select11" style="border-radius: 17px;height:35px;" bind-options="cityData" bind-optionsValue="fValue" bind-optionsLabel="fLabel" onChange="select11Change"></select></div> 
    <div class="x-col" xid="col31">
     <select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select10" style="border-radius: 17px;height:35px;width:95%;" bind-options="districtData" bind-optionsValue="fValue" bind-optionsLabel="fLabel" onChange="select10Change"></select></div> </div> </div></div>
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row9" style="margin-top:10px;height:35px;line-height:35px;">
   <div class="x-col x-col-33" xid="col18"><![CDATA[]]></div>
   <div class="x-col" xid="col19" style="margin-left:-5px;">
    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row11" style="margin:0px;padding:0px;height:35px;line-height:35px;">
   <div class="x-col" xid="col24"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select8" style="border-radius: 17px;height:35px;" bind-options="townData" bind-optionsValue="fValue" bind-optionsLabel="fLabel" onChange="select8Change"></select></div>
   <div class="x-col" xid="col25"><select component="$UI/system/components/justep/select/select" bind-optionsCaption="请选择..." class="form-control" xid="select9" style="border-radius: 17px;height:35px;width:95%;" bind-options="villageData" bind-optionsValue="fValue" bind-optionsLabel="fLabel"></select></div></div></div> </div></div>
  <div xid="div2" style="margin-top:50px;margin-bottom: 25px;"><div component="$UI/system/components/justep/row/row" class="x-row" xid="row14" style="height:45px;">
   <div class="x-col" xid="col34"><a component="$UI/system/components/justep/button/button" class="btn btn-default" label="取消" xid="button1" style="height:45px;width:80%;border-radius:22px;background-color:white;color:#AFB7BF;font-size:16px;line-height:35px;margin-left:20%;border:1px solid #DCDCDC;" onClick="button1Click">
   <i xid="i1"></i>
   <span xid="span1">取消</span></a></div>
   <div class="x-col" xid="col35"><a component="$UI/system/components/justep/button/button" class="btn btn-default" label="确定" xid="button2" style="background-color:white;width:80%;height:45px;border-radius:22px;color:#FEFEFE;font-size:16px;line-height:35px;background: -webkit-linear-gradient(left, #75DA94, #53C7EE); border:0px;" onClick="button2Click">
   <i xid="i2"></i>
   <span xid="span2">确定</span></a></div></div></div></div>
  </div> 
</div>