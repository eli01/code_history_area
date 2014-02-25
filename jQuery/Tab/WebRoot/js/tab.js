$(document).ready(function(){
	//找到所有的标签
/*	$("li")
	.mouseover(
		function(){
			//将原来显示的内容进行隐藏
			$("div.contentin").hide();
			//当前标签对应的区域显示
		})
	.mouseout(
		function(){
			//将当前区域对应的内容隐藏
			alert("鼠标离开");
		});*/
	var timeoutid;
	$("#tabfirst li").each(function(index){
		//每一个包装li的jquery对象都会执行function中的代码
		//index是当前执行这个function代码的li对应在所有li组成的数组中的索引值
		//有了index的值之后，就可以找到当前标签对应的内容区域
		$(this).mouseover(function(){
			var liNode=$(this);
			timeoutid=setTimeout(function(){
				//鼠标悬浮时
				/*原来显示内容的标签除去选中时的属性*/
				$("#tabfirst li.tabin").removeClass("tabin");
				/*当前发生悬浮事件的标签添加选中时的属性*/
				$(liNode).addClass("tabin");
				$("#tabfirst div.contentin").removeClass("contentin");
				
				$("#tabfirst div").eq(index).addClass("contentin");
			},300);
		
		}).mouseout(function(){
			clearTimeout(timeoutid);
		});
	
	});
	
	/*在整个页面装入完成后，标签2的区域需要装入静态的html页面*/

	$("#realcontent").load("TabLoad.html");

	/*注册鼠标点击事件*/
	$("#tabsecond li").each(function(index){	
		$(this).click(function(){
			$("#tabsecond li.tabin").removeClass("tabin");
			$(this).addClass("tabin");
			if(index == 0){
				//装入静态完整界面
				$("#realcontent").load("TabLoad.html");
			}else if(index == 1){
				//装入动态部分界面
				$("#realcontent").load("TabLoad.jsp div");
			}else if(index == 2){
				//装入远程数据
				$("#realcontent").load("TabData.jsp");
			}
		});
	});
	
	/*对于loading图片绑定ajax请求开始和结束的事件*/
	//对于loading图片绑定ajax请求开始和交互结束的事件
	$("#contentsecond img").bind("ajaxStart",function(){
		//把div里面的内容清空
		$("#realcontent").html("");
		//整个页面中任意ajax交互开始前，function中的内容会被执行
		$(this).show();
	}).bind("ajaxStop",function(){
		//整个页面中任意ajax交互结束后，function中的内容会被执行	
		$(this).slideUp("1000");
	});
});

