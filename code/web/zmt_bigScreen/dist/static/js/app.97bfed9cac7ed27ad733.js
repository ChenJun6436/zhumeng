webpackJsonp([6],{NHnr:function(e,n,t){"use strict";function r(e){t("UFsB")}Object.defineProperty(n,"__esModule",{value:!0});var a=t("VCXJ"),i={name:"app",methods:{getBrowserVersion:function(){var e=navigator.userAgent.toLowerCase(),n=[],t="",r="",a="";if(e.indexOf("msie")>0){var i=/msie [\d.]+;/gi;t="IE",r=""+e.match(i)}else if(e.indexOf("firefox")>0){var o=/firefox\/[\d.]+/gi;t="firefox",r=""+e.match(o)}else if(e.indexOf("chrome")>0){var c=/chrome\/[\d.]+/gi;t="chrome",r=""+e.match(c)}else if(e.indexOf("safari")>0&&e.indexOf("chrome")<0){var s=/version\/[\d.]+/gi;t="safari",r=""+e.match(s)}else if(e.indexOf("opera")>=0){var u=/version\/[\d.]+/gi;t="opera",r=""+e.match(u)}else{var f=navigator.appName;if("Netscape"==f){var l=e.split(";"),p=l[7].replace(/[ ]/g,""),d=p.match(/[\d\.]/g).toString(),h=d.replace(/[,]/g,"");r=h,t="IE"}}return a=(r+"").replace(/[^0-9.]/gi,""),n.push(t),n.push(a),n}},created:function(){var e=this.getBrowserVersion()[0],n=this.getBrowserVersion()[1];"IE"===e&&n<=8&&alert("请使用IE9以上游览器访问！")},mounted:function(){}},o=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},c=[],s={render:o,staticRenderFns:c},u=s,f=t("X4nt"),l=r,p=f(i,u,!1,l,null,null),d=p.exports,h=t("zO6J");a.default.use(h.a);var m=function(e){return Promise.all([t.e(0),t.e(3)]).then(function(){return e(t("0MVy"))}.bind(null,t)).catch(t.oe)},g=function(e){return Promise.all([t.e(0),t.e(4)]).then(function(){return e(t("s6+2"))}.bind(null,t)).catch(t.oe)},v=function(e){return Promise.all([t.e(0),t.e(1)]).then(function(){return e(t("CuAn"))}.bind(null,t)).catch(t.oe)},x=function(e){return Promise.all([t.e(0),t.e(2)]).then(function(){return e(t("mekX"))}.bind(null,t)).catch(t.oe)},b=["/","Login","Main","Discount","LookDiscount","DataAnalysis"],w=[{path:"/Login",name:"Login",component:m},{path:"/",redirect:"/Login"},{path:"/Main",component:g,children:[{path:"/",redirect:"/Main/DataAnalysis"},{path:"/Main/Discount",name:"Discount",component:v},{path:"/Main/DataAnalysis",name:"DataAnalysis",component:x}]}],D=new h.a({routes:w});D.beforeEach(function(e,n,t){var r=!1;b.forEach(function(n){n===e.name&&(r=!0)}),r?t():t(!1)});var O=D,y=t("2sCs"),E=t.n(y);t("briU");a.default.prototype.$ajax=E.a,a.default.config.productionTip=!1,new a.default({el:"#app",router:O,render:function(e){return e(d)}})},UFsB:function(e,n){}},["NHnr"]);
//# sourceMappingURL=app.97bfed9cac7ed27ad733.js.map