$(document).ready(function(){
	/*���ҵ��Ľڵ���뻺��*/
	var userNameNode=$("#userName");
	/*�ҵ�buttton��ťע���¼�*/
	$("#verifyButton").click(function(){
		/*����ı��������*/
		var userName=userNameNode.val();
		/*�����ݷ���������*/
		if(userName==""){
			alert("�û�������Ϊ��");
		}else{
			$.get("http://127.0.0.1:8080/JQuery/UserVerify?userName="+userName,null,function(response){
				/*���յ��������˷��ص����ݣ���䵽div��*/
				$("#result").html(response);
			});
			
		}
	});
	
	/*�ҵ��ı���ע���¼�*/
	userNameNode.keyup(function(){
		/*��ȡ�����ı��������*/
		var value=userNameNode.val();
		if(value==""){
			/*�ñ߿��Ϊ��ɫ*/
			userNameNode.addClass("userText");
		}else{
			/*ȥ���߿�ͱ���*/
			userNameNode.removeClass("userText");
		}
		
	});
});