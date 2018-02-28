/**
 *
 * Created by dev on 2018/1/15
 * 模块：联系我们
 */

$(document).ready(function() {
	 var ggPoint = new BMap.Point(104.068738,30.553437);//创建地图坐标的点
		   
		     //地图初始化
	    	var bm = new BMap.Map("container");//创建地图实例
		    bm.centerAndZoom(ggPoint, 12);
		    var markergg = new BMap.Marker(ggPoint);
		    bm.addOverlay(markergg); //添加谷歌marker
		    var labelgg = new BMap.Label("住梦网络科技股份有限公司",{offset:new BMap.Size(20,-10)});
		    markergg.setLabel(labelgg); //添加谷歌label
	    	setTimeout(function(){
					bm.setZoom(18);   
				}, 2000);  //2秒后放大到18级
			bm.enableScrollWheelZoom(true);
})
