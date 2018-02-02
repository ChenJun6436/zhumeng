define(function(require){
require('$model/UI2/system/components/justep/model/model');
require('$model/UI2/system/components/justep/loadingBar/loadingBar');
require('$model/UI2/system/components/justep/button/button');
require('$model/UI2/system/components/justep/controlGroup/controlGroup');
require('$model/UI2/system/components/justep/titleBar/titleBar');
require('$model/UI2/system/components/justep/panel/child');
require('$model/UI2/system/components/justep/data/data');
require('$model/UI2/system/components/justep/window/window');
require('$model/UI2/system/components/justep/panel/panel');
var __parent1=require('$model/UI2/system/lib/base/modelBase'); 
var __parent0=require('$model/UI2/zmt/slaughterInspection/regFarmers/regFarmers'); 
var __result = __parent1._extend(__parent0).extend({
	constructor:function(contextUrl){
	this.__sysParam='true';
	this.__contextUrl=contextUrl;
	this.__id='';
	this.__cid='cbQJJfe';
	this._flag_='8c22d8afa519ce0b51bff2b83a5fe29f';
	this._wCfg_={};
	this._appCfg_={};
	this.callParent(contextUrl);
 var __Data__ = require("$UI/system/components/justep/data/data");new __Data__(this,{"autoLoad":true,"confirmDelete":true,"confirmRefresh":true,"defCols":{"address":{"define":"address","label":"地址","name":"address","relation":"address","type":"String"},"createrId":{"define":"createrId","label":"创建人ID","name":"createrId","relation":"createrId","type":"String"},"createrName":{"define":"createrName","label":"创建人名称","name":"createrName","relation":"createrName","type":"String"},"farmerName":{"define":"farmerName","label":"养殖户姓名","name":"farmerName","relation":"farmerName","type":"String"},"feedName":{"define":"feedName","label":"饲料名称","name":"feedName","relation":"feedName","type":"String"},"id":{"define":"id","label":"ID","name":"id","relation":"id","type":"String"},"password":{"define":"password","label":"密码","name":"password","relation":"password","type":"String"},"phone":{"define":"phone","label":"联系电话","name":"phone","relation":"phone","type":"String"},"typeId":{"define":"typeId","label":"类型ID","name":"typeId","relation":"typeId","type":"String"},"typeName":{"define":"typeName","label":"类型名称","name":"typeName","relation":"typeName","type":"String"}},"directDelete":false,"events":{},"idColumn":"id","isMain":false,"limit":20,"xid":"regFarmersData"});
 new __Data__(this,{"autoLoad":true,"confirmDelete":true,"confirmRefresh":true,"defCols":{"createrId":{"define":"createrId","label":"创建人ID","name":"createrId","relation":"createrId","type":"String"},"createrName":{"define":"createrName","label":"创建人姓名","name":"createrName","relation":"createrName","type":"String"}},"directDelete":false,"events":{},"idColumn":"createrId","isMain":false,"limit":20,"xid":"createrData"});
 new __Data__(this,{"autoLoad":true,"confirmDelete":true,"confirmRefresh":true,"defCols":{"typeId":{"define":"typeId","label":"类型ID","name":"typeId","relation":"typeId","type":"String"},"typeName":{"define":"typeName","label":"类型名称","name":"typeName","relation":"typeName","type":"String"}},"directDelete":false,"events":{},"idColumn":"typeId","isMain":false,"limit":20,"xid":"typeData"});
}}); 
return __result;});