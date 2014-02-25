$(document).ready(function(){
	/*页面中的dom已经装载完成时，执行的代码*/
	$(".main > a,.hmain > a").click(function(){
		/*获得主菜单下子菜单所在的ul*/
		var ulNode=$(this).next("ul");
		/*if (ulNode.css("display") == "none") {
			ulNode.css("display","block");
		} else {
			ulNode.css("display","none");
		}*/	
		/*show()方法用来显示节点，相对应的有hide()方法
		 * show()方法可以有三种形式：
		 * 1.show(300)
		 * 2.show("slow/normal/fast")
		 * 3.show()*/
		
		/*自动判断节点是否已经显示*/
		//ulNode.toggle(500);
		//ulNode.slideDown("slow");
		//ulNode.slideUp("slow");
		ulNode.slideToggle();
		changeIcon($(this));
	});
	/*注册一个鼠标悬浮和离开的事件*/
	$(".hmain").hover(
		function(){
			/*鼠标悬停时拉开*/
			$(this).children("ul").slideDown();
			changeIcon($(this).children("a"));
		},
		function(){
			/*鼠标离开时卷起*/
			$(this).children("ul").slideUp();
			changeIcon($(this).children("a"));
		}
	);
});

/**
 * 定义修改主菜单的指示图标的方法
 * 这里地址是从显示页面所在的位置算起的
 */
function changeIcon(mainNode){
	if(mainNode){
		if(mainNode.css("background-image").indexOf("collapsed.gif")>=0){
			mainNode.css("background-image","url('images/expanded.gif')");
		}else{
			mainNode.css("background-image","url('images/collapsed.gif')");
		}
	}
}
