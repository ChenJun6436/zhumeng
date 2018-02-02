<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:462px;left:429px;height:auto;" onParamsReceive="modelParamsReceive"> 
  <div component="$UI/system/components/justep/data/data" autoLoad="true" xid="bookbuilInfoData" idColumn="createTime"><column label="时间" name="createTime" type="String" xid="xid2"></column>
  <column label="名称" name="createrName" type="String" xid="xid3"></column>
  <column label="地址" name="address" type="String" xid="xid9"></column>
  <column label="事件" name="thing" type="String" xid="xid5"></column>
  <column label="状态" name="status" type="String" xid="xid1"></column></div></div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1" style="padding:5px 10px;"> 
      <div class="x-panel-top" xid="top2">
   <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" style="color:#28282E;font-size:17px;width:100%;;background-color:white;border-bottom-style:solid;border-bottom-width:1px;border-bottom-color:#CCCCCC;" xid="titleBar">
    <div class="x-titlebar-left" xid="left2">
     <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon" icon="linear linear-chevronleft" onClick="{operation:'window.close'}" xid="button1" style="font-weight:200;font-size:17px;color:#28282E;">
      <i class="linear linear-chevronleft" xid="i3"></i>
      <span xid="span3"></span></a> </div> 
    <div class="x-titlebar-title" xid="title2" style="font-size:17px；color:#28282E;"></div>
    <div class="x-titlebar-right reverse" xid="right2"></div></div> </div><div class="x-panel-content x-scroll-view" xid="content1" _xid="C7C6A59AA020000177E4124514F61CEC" style="bottom:0px;background-size:cover;top:0px;">
  <div class="x-scroll" component="$UI/system/components/justep/scrollView/scrollView" xid="scrollView1">
   <div class="x-content-center x-pull-down container" xid="div1">
    <i class="x-pull-down-img glyphicon x-icon-pull-down" xid="i1"></i>
    <span class="x-pull-down-label" xid="span1">下拉刷新...</span></div> 
   <div class="x-scroll-content" xid="div2"><div component="$UI/system/components/justep/list/list" class="x-list" xid="list1" data="bookbuilInfoData" style="padding-top:65px;">
   <ul class="x-list-template" xid="listTemplateUl1">
    <li xid="li1">
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row1" style="padding-left:10px;">
    <div class="tx-col x-col-fixed" xid="col16" style="position:relative;width:25px;">
     <p xid="p3" style="border:1px solid #DDDDDD;border-radius:50%;position:absolute;top:10px;left:0;width:9px;height:9px;"></p>
     <div xid="div7" style="border-left:1px solid #DDDDDD;position:absolute;width:1px;padding-bottom:2px;left:4px;top:19px;height:101%;" bind-style="{display: val(&quot;status&quot;) =='已销售'?'none':'block'}"></div></div> 
    <div class="x-col x-col-fixed" xid="col1" style="width:auto;border-bottom:1px solid #dddddd;padding:0px 10px 0px 0px;">
     <p xid="p1" style="width:50px;" bind-text=' val("createTime")'></p></div> 
    <div class="x-col" xid="col2" style="border-bottom:1px solid #dddddd;padding:0px">
     <div component="$UI/system/components/justep/row/row" class="x-row" xid="row3" style="padding:0px;">
      <div component="$UI/system/components/justep/row/row" class="x-row" xid="row5" style="padding:0px;">
       <div class="x-col" xid="col13" style="padding:0px">
        <span xid="span6" style="font-size:16px;color:#28282E;text-align:right;" bind-text='val("createrName")'></span>
  <span xid="span4" bind-text='val("status")' style="display:none;"></span></div> 
       <div class="x-col" xid="col14" style="padding:0px">
        <p xid="p2" style="font-size:16px;color:#28282E;padding:0px 5px 0px 0px;text-align:right;margin: 0 0 5px;" bind-text=' val("thing")'></p></div> </div> </div> 
     <div component="$UI/system/components/justep/row/row" class="x-row" xid="row4" style="padding:0px">
      <div class="x-col" xid="col10" style="padding:0px">
       <img src="$UI/pigsInputting/img/dizhi2x.png" alt="" xid="image1" style="width:9px;height:13px" height="13px" bind-style="{display: val(&quot;address&quot;) ==''?'none':'bolck'}"></img>
       <span xid="span7" bind-text='val("address")' style="font-size:14px;color:#95A0AA;"></span></div> </div> </div> </div></li></ul> </div>
  </div>
   <div class="x-content-center x-pull-up" xid="div3">
    <span class="x-pull-up-label" xid="span2">加载更多...</span>
  </div> </div></div>
  </div> 
</div>