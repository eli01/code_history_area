$(document).ready(function(){
	/*����λ����ע���¼�*/
	$(".maintable li").each(function(){
		$(this).click(function(){
			$(".maintable li.tabin").removeClass("tabin");
			$(this).addClass("tabin");
		});
	});
	/*��չ������ע���¼�*/
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
/*����һ���޸�ͼƬ�ķ���*/
function changeIcon(node){
	if(node){
		if(node.css("background-image").indexOf("down.png")>=0){
			node.css("background-image","url('images/up.png')");
		}else{
			node.css("background-image","url('images/down.png')");
		}
	}
}
