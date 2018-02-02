/**
 * 创建于 2016/9/5.
 */
(function(){

    //默认参数
    var defaults = {
            async :false,//默认设置非异步加载
            showLine :false,//默认显示连接线
            showIcon: false,//默认显示图标
            zNodes : null,//默认静态数据
            url : "",//默认异步加载路径
            check :true,//默认是否显示多选按钮
            singleClick :false,//默认单击功能关闭
            singlePath :false,//默认单一展开关闭
            checkType:"checkbox",
            callBackClick :function(treeNode){},
            radioType:"all"
    };

    $.fn.myTreeDome = function(options){
        //合并参数
        var params = $.extend({},defaults,options);

        //获取当前
        var thisSelector = $(this).selector;
        //console.log($(this).addClass("sidebar-nav"));
        //设置参数
        var setting = {
            view: {
                showLine: params.showLine,
                showIcon: params.showIcon,
                dblClickExpand: dblClickExpand()
            },
            check: {
                enable:true,
                chkStyle:params.checkType, 
                chkboxType :{ "Y" : "ps", "N" : "ps" },
                autoCheckTrigger: true,
                radioType:"all"
            },
            async :{
                enable: params.async,
                url :params.url,
                type : "post",
                autoParam: ["id", "name=n", "level=lv"],
                contentType: "application/x-www-form-urlencoded",
                dataFilter: []
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeExpand: singleOpen(),
                onCheck:params.onCheck,
                onClick :singleClick(),
                onDblClick :onDblClick()
            }
        };
        //判断双击的开启和关闭
        function dblClickExpand(){
            if(params.singleClick == false){
                return true;
            }else {
                return false;
            }
        }

        //判断单击的开启和关闭并且回调
        function singleClick(){
            if(params.singleClick == false){
                return null;
            }else {
                function onClick(e,treeId, treeNode){
                    var zTree = $.fn.zTree.getZTreeObj(""+treeId+"");
                    zTree.expandNode(treeNode,null, null, null, true);
                    params.callBackClick(treeNode);
                }
                return onClick;
            }
        }

        //双击的回调
        function onDblClick(){
            if(dblClickExpand() == true){
                function onDbClick(e,treeId, treeNode){
                    params.callBackClick(treeNode);
                }
                return onDbClick;
            }else {
                return null;
            }
        }

        //判断是否单一展开
        function singleOpen(){
            if(params.singlePath == true){
                var curExpandNode = null;
                function beforeExpand(treeId, treeNode) {
                    var pNode = curExpandNode ? curExpandNode.getParentNode():null;
                    var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
                    var zTree = $.fn.zTree.getZTreeObj(""+treeId+"");
                    for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
                        if (treeNode !== treeNodeP.children[i]) {
                            zTree.expandNode(treeNodeP.children[i], false);
                        }
                    }
                    while (pNode) {
                        if (pNode === treeNode) {
                            break;
                        }
                        pNode = pNode.getParentNode();
                    }
                    if (!pNode) {
                        singlePath(treeNode,treeId);
                    }
                }
                function singlePath(newNode,treeId) {
                    if (newNode === curExpandNode) return;
                    var zTree = $.fn.zTree.getZTreeObj(""+treeId+""),
                        rootNodes, tmpRoot, tmpTId, i, j, n;
                    if (!curExpandNode) {
                        tmpRoot = newNode;
                        while (tmpRoot) {
                            tmpTId = tmpRoot.tId;
                            tmpRoot = tmpRoot.getParentNode();
                        }
                        rootNodes = zTree.getNodes();
                        for (i=0, j=rootNodes.length; i<j; i++) {
                            n = rootNodes[i];
                            if (n.tId != tmpTId) {
                                zTree.expandNode(n, false);
                            }
                        }
                    } else if (curExpandNode && curExpandNode.open) {
                        if (newNode.parentTId === curExpandNode.parentTId) {
                            zTree.expandNode(curExpandNode, false);
                        } else {
                            var newParents = [];
                            while (newNode) {
                                newNode = newNode.getParentNode();
                                if (newNode === curExpandNode) {
                                    newParents = null;
                                    break;
                                } else if (newNode) {
                                    newParents.push(newNode);
                                }
                            }
                            if (newParents!=null) {
                                var oldNode = curExpandNode;
                                var oldParents = [];
                                while (oldNode) {
                                    oldNode = oldNode.getParentNode();
                                    if (oldNode) {
                                        oldParents.push(oldNode);
                                    }
                                }
                                if (newParents.length>0) {
                                    zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
                                } else {
                                    zTree.expandNode(oldParents[oldParents.length-1], false);
                                }
                            }
                        }
                    }
                }
                return beforeExpand;
            }else {
                return null;
            }
        }


        //调用zTree插件
       var ztree= $.fn.zTree.init(
            $(""+thisSelector+""),
            setting,
            params.zNodes
        );
        
        return ztree;
    };
})(jQuery);


////获取json数据
//function ajaxData(){
//  var data;
//  $.ajax({
//      type : 'get',
//      url : "data.json",
//      async:false,
//      dataType: "json",
//      success: function(msg){
//          data = msg;
//      }
//  });
//  return data;
//}


/**
 * 一一一一一一一一一一【共有】一一一一一一一一一一
 * @param {showLine}是否显示连接线 类型:布尔 （true:是 false：否) 一一默认：true
 * @param {showIcon}是否显示图标 类型:布尔 （true:是 false：否) 一一默认：true
 * @param {check}多选按钮 类型:布尔 （true:开启 false：关闭) 一一默认：false
 * @param {url}路径 类型:字符串 一一默认：""
 * @param {singleClick}单击/双击 类型: 布尔 （true:开启 false：关闭) 一一默认：false
 * @param {singlePath}展开单一 类型: 布尔 （true:开启 false：关闭) 一一默认：false
 * @param {callBackClick}点击回调（只有内容点击才回调，父级不会回调） 类型: function
 *
 *
 * 一一一一一一一一一一【一次性加载数据】一一一一一一一一一一
 * @param {zNodes}节点 类型:object 一一默认：null
 *
 *
 * 一一一一一一一一一一【异步加载数据】一一一一一一一一一一
 * @param {async}异步 类型:布尔 （true:开启 false：关闭）一一默认：false
 *
 */
$(document).ready(function(){
    //简单json数据树
//  $("#myTreeDome1-1").myTreeDome({
//      zNodes : ajaxData().data2
//  });
//
    //显示多选按钮
//  $("#myTreeDome1-2").myTreeDome({
//      zNodes : ajaxData().data3,
//      check :true,
//      showIcon:false,
//      showLine:false
//  });
//
//  //不显示连接线
//  $("#myTreeDome1-3").myTreeDome({
//      showLine :false,
//      zNodes : ajaxData().data2
//  });
//
//  //不显示图标
//  $("#myTreeDome1-4").myTreeDome({
//      showIcon: false,
//      zNodes : ajaxData().data2
//  });
//
//  //自定义图标
//  $("#myTreeDome1-5").myTreeDome({
//      showIcon: true,
//      zNodes : ajaxData().data1
//  });
//  //单击
//  $("#myTreeDome1-6").myTreeDome({
//      zNodes : ajaxData().data3,
//      singleClick : true
//  });
//
//  //单一展开
//  $("#myTreeDome1-7").myTreeDome({
//      zNodes : ajaxData().data3,
//      singleClick : true,
//      singlePath : true
//
//  });
//
//  //单击回调
//  $("#myTreeDome1-8").myTreeDome({
//      zNodes : ajaxData().data3,
//      singleClick : true,
//      singlePath : true,
//      callBackClick : function(treeNode){
//          alert(treeNode)
//      }
//  });
//
//  //双击回调
//  $("#myTreeDome1-9").myTreeDome({
//      zNodes : ajaxData().data3,
//      singlePath : true,
//      callBackClick : function(treeNode){
//          alert(treeNode)
//      }
//  });
//
//
//  //异步加载数据树
//  $("#myTreeDome2-1").myTreeDome({
//      async :true,
//      url : "getNodes.php",
//      singleClick : true
//  });




});

