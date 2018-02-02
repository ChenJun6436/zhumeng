<?xml version="1.0" encoding="UTF-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" xid="window" class="window" component="$UI/system/components/justep/window/window" design="device:m;">  
  <div component="$UI/system/components/justep/model/model" xid="model" onParamsReceive="modelParamsReceive" onLoad="modelLoad" onActive="modelActive"/> 
<div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
   
   <div class="x-panel-content" xid="content1"><div component="$UI/system/components/justep/contents/contents" class="x-contents x-full" xid="allContents" onActiveChanged="allContentsActiveChanged" swipe="false" wrap="true" routable="false">
   
   <div class="x-contents-content  x-scroll-view" xid="homePage">
   <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel5" style="background-color:#F1F1F1;">
   <div class="x-panel-content" xid="content10"><div xid="div1"><img src="$UI/pigsInputting/img/logo2x.png" alt="" xid="image1" style="display:block;width:95px;margin:100px auto 0px auto;"></img></div><p xid="p1" style="width:268px;height:45px;background-color:#FFFFFF;color:#CCCCCC;margin:55px auto 22px auto;border-radius: 22px;"><img src="$UI/pigsInputting/img/saoyisao2x.png" alt="" xid="image2" height="20px" style="width:20px;margin-left:20px;margin-top:13px;" bind-click="image2Click"></img>
  <input component="$UI/system/components/justep/input/input" class="form-control" xid="input2" valueUpdateMode="input" style="width:200px;margin-top:-11%;margin-left:20%;background-color:#FFFFFF;border:0px;outline:0px" placeHolder="输入ID或扫码" maxLength="9"></input></p>
  <p xid="confirmBtn" style="width:268px;height:45px;color:#FFFFFF;margin:0px auto 22px auto;border-radius:22px;text-align:center;font-size:16px;line-height:45px;background: -webkit-linear-gradient(left, #75DA94, #53C7EE);  " bind-click="confirmBtnClick"><![CDATA[确定]]>
  </p></div>
   </div></div><div class="x-contents-content" xid="bookbuildPage">
    <div component="$UI/system/components/justep/windowContainer/windowContainer" class="x-window-container" xid="navContainer2" src="$UI/pigsInputting/bookbuild/bookbuildPage.w" autoLoad="true"></div></div> 
   <div class="x-contents-content" xid="farmerPage" onActive="farmerPageActive"><div component="$UI/system/components/justep/windowContainer/windowContainer" class="x-window-container" xid="navContainer3" src="$UI/pigsInputting/farmers/farmer.w" autoLoad="true"></div></div><div class="x-contents-content" xid="minePage">
    <div component="$UI/system/components/justep/windowContainer/windowContainer" class="x-window-container" xid="navContainer4" src="$UI/pigsInputting/mine/minePage.w" autoLoad="true"></div></div> 
  </div>
  </div>
   <div class="x-panel-bottom" xid="bottom1" style="background-color:#28282E；"><div component="$UI/system/components/justep/button/buttonGroup" class="btn-group btn-group-justified" tabbed="true" xid="buttonGroup2" style="height:100%;width:100%;border-top-style:solid;border-top-width:1px;border-color:#CCCCCC #CCCCCC #CCCCCC #CCCCCC;background-color:#28282E;">
   <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top" label="首页" xid="homeBtn" icon="img:$UI/pigsInputting/img/shouye12x.png|" target="homePage" style="color:#3CC6BD;" onClick="homeBtnClick">
    <i xid="i4" style="width:22px;height:20px;"></i>
    <img src="$UI/pigsInputting/img/shouye12x.png" xid="image4" style="width:22px;height:20px;"></img><span xid="span4" style="color: -webkit-linear-gradient(left, #75DA94, #53C7EE);font-size:12px;  ">首页</span></a> 
   <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top" label="建档记录" xid="bookbuildBtn" icon="img:$UI/pigsInputting/img/jiandangjilu22x.png|" style="color:#FFFFFF;" target="bookbuildPage">
    <i xid="i5"></i>
    <img src="$UI/pigsInputting/img/jiandangjilu22x.png" xid="image3" style="width:22px;height:20px;"></img><span xid="span5" style="font-size:12px;">建档记录</span></a> 
  <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top" label="我的养殖户" xid="farmerBrn" icon="img:$UI/pigsInputting/img/wodeyangzhihu22x.png|" style="color:#FFFFFF;" target="farmerPage">
   <i xid="i1"></i>
   <img src="$UI/pigsInputting/img/wodeyangzhihu22x.png" xid="image5" style="width:22px;height:20px;"></img><span xid="span1" style="font-size:12px;">我的养殖户</span></a><a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top" label="我的" xid="mineBtn" icon="img:$UI/pigsInputting/img/wode22x.png|" style="color:#FFFFFF;" target="minePage">
   <i xid="i6"></i>
   <img src="$UI/pigsInputting/img/wode22x.png" xid="image6" style="width:22px;height:20px;"></img><span xid="span6" style="font-size:12px;">我的</span></a>
  </div></div></div>
  <div component="$UI/system/components/justep/popOver/popOver" class="x-popOver" direction="auto" xid="popOver" dismissible="false">
   <div class="x-popOver-overlay" xid="div2"></div>
   <div class="x-popOver-content" xid="div3">
  <div xid="div5" style="width:100%;position:relative;height:50px;">
  <img src="$UI/pigsInputting/img/ic__close.png" alt="" xid="close" style="position:absolute;top:0px;width:20px;right:5px;" height="50px" bind-click="closeClick"></img></div><div xid="div4" style="height:175px;width:210px;border-radius:4px;background-color:#FFFFFF;"><p xid="p2" style="margin:0px ;width:100%;padding-top:30px;font-size:15px;color:#333333;text-align:center;"><![CDATA[您确定激活以下ID?]]></p>
  <p xid="idNo" style="margin:0px auto;width:100%;padding-top:15px;font-size:25px;color:#333333;text-align:center;"><![CDATA[]]></p>
  
  <div xid="div7" style="margin-top:15px;"><a component="$UI/system/components/justep/button/button" class="btn btn-link" label="否" xid="button2" style="border-radius:16px;height:35px;width:75px;line-height:32px;border:1px solid #cccccc;font-size:16px;color:#AFB7BE;margin-right:20px;margin-left:20px;" onClick="{operation:'popOver.hide'}">
   <i xid="i3"></i>
   <span xid="span3">否</span></a>
  <a component="$UI/system/components/justep/button/button" class="btn btn-default" label="是" xid="activeId" style="border-radius:16px;height:35px;width:75px;line-height:32px;border:none;background:-webkit-linear-gradient(left, #75DA94, #53C7EE);" onClick="activeIdClick">
   <i xid="i7"></i>
   <span xid="span7">是</span></a>
  </div></div></div></div>
  </div>