$(document).ready(function(){
	/*给定位功能注册事件*/
	$(".maintable li").each(function(){
		$(this).click(function(){
			$(".maintable li.tabin").removeClass("tabin");
			$(this).addClass("tabin");
		});
	});
	/*给展开收起注册事件*/
	$(".newshead").each(function(index){		
		$(this).click(function(){
			
			var bodyNode=$(".newsbody").eq(index);
			changeIcon($(this));
			if(bodyNode.css("height")=="58px"){
				bodyNode.addClass("fullpage");
			}else{
				bodyNode.removeClass("fullpage");
			}
			
		});
	});

});
/*定义一个修改图片的方法*/
function changeIcon(node){
	if(node){
		if(node.css("background-image").indexOf("down.png")>=0){
			node.css("background-image","url('images/up.png')");
		}else{
			node.css("background-image","url('images/down.png')");
		}
	}
}
