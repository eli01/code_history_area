$(document).ready(function(){
	/*将找到的节点放入缓存*/
	var userNameNode=$("#userName");
	/*找到buttton按钮注册事件*/
	$("#verifyButton").click(function(){
		/*获得文本框的内容*/
		var userName=userNameNode.val();
		/*将内容发给服务器*/
		if(userName==""){
			alert("用户名不能为空");
		}else{
			$.get("http://127.0.0.1:8080/JQuery/UserVerify?userName="+userName,null,function(response){
				/*接收到服务器端返回的数据，填充到div中*/
				$("#result").html(response);
			});
			
		}
	});
	
	/*找到文本框注册事件*/
	userNameNode.keyup(function(){
		/*获取当亲文本框的内容*/
		var value=userNameNode.val();
		if(value==""){
			/*让边框变为红色*/
			userNameNode.addClass("userText");
		}else{
			/*去掉边框和背景*/
			userNameNode.removeClass("userText");
		}
		
	});
});