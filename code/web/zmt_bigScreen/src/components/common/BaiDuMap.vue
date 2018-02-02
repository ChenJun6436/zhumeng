<template>
  <div class="MapBox" :style='MapBoxStyle'>
    <p class="title">{{nowXian}}地图</p>
    <div id='dituContent'>
     	
    </div>
  </div>
</template>
<script>
	import server from '../../server/myServer'
  import kuang from '../../assets/kuang2.png'
  import dian1 from '../../assets/dituhongdian.png'
  import dian2 from '../../assets/dituhuangdian.png'
  import dian3 from '../../assets/ditulvdian.png'
  import dian4 from '../../assets/ditulandian.png'
  import dian5 from '../../assets/dituzidian.png'
  export default{
    data () {
      return {
        MapBoxStyle:{
          backgroundImage: "url(" + kuang + ")",
        },
      	point: '',
      	nowXian:'',
      	nowSheng : '',
      	nowShi: '',
      	sheng: '',
      	shi:'',
      	xian:'',
      	zhen:'',
      	shengList: [],
      	shiList: [],
      	xianList: [],
        dian:[dian1,dian2,dian3,dian4,dian5]
      }
    },
    props:[
      'topList'
    ],
    created () {
      this._getAddress()
    },
    mounted () {
      // this._getCity()
      // this._getDistrict()
    },
    methods: {
      _getAddressName() {
        let vm = this
        server().getAddressName({district:vm.nowXian}).then(function(res){
          if(res.data.code === '0'){
            vm.sheng =res.data.data.provinceId
            vm.shi = res.data.data.cityId
            vm.xian = res.data.data.districtId
          }
        }).then(function(){
          vm._getProvince()
          
          
        })
      },
      _getAddress() {
        let vm = this
        server().getAddress().then(function(res){
          if(res.data.code === '0'){
            vm.nowSheng = res.data.data[0].province
            vm.nowShi = res.data.data[0].city
            vm.nowXian = res.data.data[0].district
            vm.point = ""+res.data.data[0].province +"" +res.data.data[0].city+""+res.data.data[0].district+""
          }
        }).then(function(){
          vm._getAddressName()
        })
      },
    	_getProvince() {
    		 let vm = this
	    		server()._getProvince().then(function(res){
	        if(res.data.code === '0'){
	        	for(var i in res.data.data){
	        		if(vm.nowSheng != res.data.data[i].value){
	        			vm.shengList.push(res.data.data[i].value)
	        		}
	        	}
	        }
	      }).then(function(){

	        vm._getCity()
	      })
    	},
    	_getCity() {
      let vm = this
      server()._getCity({province_id: vm.sheng}).then(function(res){
        if(res.data.code === '0'){
        	for(var i in res.data.data){
	        		if(vm.nowShi!= res.data.data[i].value){
	        			vm.shiList.push(res.data.data[i].value)
	        		}
	        	}
        }
      }).then(function(){
        vm._getDistrict()
        for(var i of vm.shiList){
					vm.addMarker(i)
				}
        vm.initMap()
      })
    },
    	_getDistrict() {
      let vm = this
      server()._getDistrict({city_id: vm.shi}).then(function(res){
        if(res.data.code === '0'){
        	for(var i in res.data.data){
	        		if(vm.nowXian != res.data.data[i].value){
	        			vm.xianList.push(res.data.data[i].value)
	        		}
        	}
        }
      }).then(function(){
      		for(var i of vm.xianList){
						 vm.addMarker(i)
					}
      })
    },
    	_getTown() {
      let vm = this
      server()._getTown({district_id: vm.xian}).then(function(res){
        if(res.data.code === '0'){
          // console.log(res.data.data)
        }else {
          
        }
      })
    },
    //这几个地方加this
      initMap () {
        let vm = this
        this.createMap(); //创建地图 
        setTimeout(function(){
          vm.setMapEvent();//设置地图事件
        }, 1000)
        
      },
      createMap(){
        var map = new BMap.Map("dituContent",
        	{minZoom:15,maxZoom:11},
        	{enableMapClick:false},
        	);//在百度地图容器中创建一个地图 //最大和最小倍数
        // var point = new BMap.Point(120.328033,31.686802);//定义一个中心点坐标
        var styleJson = [
          {
            "featureType": "road",
            "elementType": "all",
            "stylers": {
              "visibility": "off"
            }
          },
          {
            "featureType": "poilabel",
            "elementType": "all",
            "stylers": {
              "visibility": "off"
            }
          },
          {
            "featureType": "background",
            "elementType": "all",
            "stylers": {
              "visibility": "on"
            }
          },
          {
            "featureType": "background",
            "elementType": "all",
            "stylers": {
              "color": "#a7e7f1",
              "visibility": "on"
            }
          }
				]
        map.setMapStyle({styleJson})
        window.map = map;//将map变量存储在全局
      },
      setMapEvent(){
      	let vm = this
      	// 创建地址解析器实例
      	var myGeo = new BMap.Geocoder();
        map.disableDragging();     //禁止拖拽
        map.centerAndZoom(vm.point,18);//设定地图的中心点和坐标并将地图显示在地图容器中  //中心点和放大范围
        //根据ip获取城市名称
        // myGeo.getLocation(new BMap.Point('104.593976','29.599589'),function(result){
        //   console.log(result);
        //     vm.nowSheng = result.addressComponents.province
        //     vm.nowShi = result.addressComponents.city
        //     vm.nowXian = result.addressComponents.district
        // });
        
				myGeo.getPoint(""+vm.nowSheng+""+vm.nowShi+""+vm.nowXian+""+vm.topList.top5[0].name, function(point){
          if (point) {
            var hhh = {lng:point.lng,lat:point.lat+0.008}
            var marker = new BMap.Marker(hhh,{icon:new BMap.Icon(vm.dian[0], new BMap.Size(100,110))}) // 创建标注
            var label = new BMap.Label(vm.topList.top5[0].name,{offset:new BMap.Size(10,40)});
            label.setStyle({color:'#000',fontSize:'20px',border:'none',background:'none',textShadow:'#FFF 1px 0 0,#FFFF 0 1px 0,#FFF -1px 0 0,#FFF 0 -1px 0'})
            marker.setLabel(label);
            map.addOverlay(marker);
          }else{
            alert("您选择地址没有解析到结果!");
          }
        }, "北京市");
        myGeo.getPoint(""+vm.nowSheng+""+vm.nowShi+""+vm.nowXian+""+vm.topList.top5[1].name, function(point){
          if (point) {
            var hhh = {lng:point.lng,lat:point.lat+0.008}
            var marker = new BMap.Marker(hhh,{icon:new BMap.Icon(vm.dian[1], new BMap.Size(100,110))}) // 创建标注
            var label = new BMap.Label(vm.topList.top5[1].name,{offset:new BMap.Size(5,35)});
            label.setStyle({color:'#000',fontSize:'20px',border:'none',background:'none',textShadow:'#FFF 1px 0 0,#FFFF 0 1px 0,#FFF -1px 0 0,#FFF 0 -1px 0',})
            marker.setLabel(label);
            map.addOverlay(marker);
          }else{
            alert("您选择地址没有解析到结果!");
          }
        }, "北京市");
        myGeo.getPoint(""+vm.nowSheng+""+vm.nowShi+""+vm.nowXian+""+vm.topList.top5[2].name, function(point){
          if (point) {
            var hhh = {lng:point.lng,lat:point.lat+0.008}
            var marker = new BMap.Marker(hhh,{icon:new BMap.Icon(vm.dian[2], new BMap.Size(100,110))}) // 创建标注
            var label = new BMap.Label(vm.topList.top5[2].name,{offset:new BMap.Size(0,25)});
            label.setStyle({color:'#000',fontSize:'20px',border:'none',background:'none',textShadow:'#FFF 1px 0 0,#FFFF 0 1px 0,#FFF -1px 0 0,#FFF 0 -1px 0',})
            marker.setLabel(label);
            map.addOverlay(marker);
          }else{
            alert("您选择地址没有解析到结果!");
          }
        }, "北京市");
        myGeo.getPoint(""+vm.nowSheng+""+vm.nowShi+""+vm.nowXian+""+vm.topList.top5[3].name, function(point){
          if (point) {
            var hhh = {lng:point.lng,lat:point.lat+0.008}
            var marker = new BMap.Marker(hhh,{icon:new BMap.Icon(vm.dian[3], new BMap.Size(100,110))}) // 创建标注
            var label = new BMap.Label(vm.topList.top5[3].name,{offset:new BMap.Size(5,25)});
            label.setStyle({color:'#000',fontSize:'20px',border:'none',background:'none',textShadow:'#FFF 1px 0 0,#FFFF 0 1px 0,#FFF -1px 0 0,#FFF 0 -1px 0',})
            marker.setLabel(label);
            map.addOverlay(marker);
          }else{
            alert("您选择地址没有解析到结果!");
          }
        }, "北京市");
        myGeo.getPoint(""+vm.nowSheng+""+vm.nowShi+""+vm.nowXian+""+vm.topList.top5[4].name, function(point){
          if (point) {
            var hhh = {lng:point.lng,lat:point.lat+0.008}
            var marker = new BMap.Marker(hhh,{icon:new BMap.Icon(vm.dian[4], new BMap.Size(100,110))}) // 创建标注
            var label = new BMap.Label(vm.topList.top5[4].name,{offset:new BMap.Size(-10,25)});
            label.setStyle({color:'#000',fontSize:'20px',border:'none',background:'none',textShadow:'#FFF 1px 0 0,#FFFF 0 1px 0,#FFF -1px 0 0,#FFF 0 -1px 0',})
            marker.setLabel(label);
            map.addOverlay(marker);
          }else{
            alert("您选择地址没有解析到结果!");
          }
        }, "北京市");

      },
      //标注点数组
      //创建marker
      addMarker(a){
				var bdary = new BMap.Boundary();
				bdary.get(a, function(rs){       //获取行政区域
					// map.clearOverlays();        //清除地图覆盖物       
				var count = rs.boundaries.length; //行政区域的点有多少个
		  	var pointArray = [];
					for (var i = 0; i < count; i++) {
						var ply = new BMap.Polygon(rs.boundaries[i], {
							strokeWeight: 2, 
							strokeColor: "#041020",
							strokeOpacity:'1',
							fillColor:"#041020",
							fillOpacity:'1',
							}); //建立多边形覆盖物
						map.addOverlay(ply);  //添加覆盖物
						pointArray = pointArray.concat(ply.getPath());
					}    
				});   
			},
    }
  }
</script>
<style>
  .MapBox{
    width: 10.17rem;
    height: 9rem;
    padding:.4rem .4rem .4rem .33rem;
    box-sizing: border-box;
    background-size: 10.17rem 9rem;
  }
  .title{
    font-size: .21rem;
    color: #64faf9;
    text-align: left;
    font-weight: bold;
  }
  #dituContent{
    margin-top: .5rem;
  	height: 7.6rem;
  	width: 9.5rem;
  }
  .anchorBL,.BMap_cpyCtr{
  	display:none
  }
</style>

