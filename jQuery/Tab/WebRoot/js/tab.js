$(document).ready(function(){
	//�ҵ����еı�ǩ
/*	$("li")
	.mouseover(
		function(){
			//��ԭ����ʾ�����ݽ�������
			$("div.contentin").hide();
			//��ǰ��ǩ��Ӧ��������ʾ
		})
	.mouseout(
		function(){
			//����ǰ�����Ӧ����������
			alert("����뿪");
		});*/
	var timeoutid;
	$("#tabfirst li").each(function(index){
		//ÿһ����װli��jquery���󶼻�ִ��function�еĴ���
		//index�ǵ�ǰִ�����function�����li��Ӧ������li��ɵ������е�����ֵ
		//����index��ֵ֮�󣬾Ϳ����ҵ���ǰ��ǩ��Ӧ����������
		$(this).mouseover(function(){
			var liNode=$(this);
			timeoutid=setTimeout(function(){
				//�������ʱ
				/*ԭ����ʾ���ݵı�ǩ��ȥѡ��ʱ������*/
				$("#tabfirst li.tabin").removeClass("tabin");
				/*��ǰ���������¼��ı�ǩ���ѡ��ʱ������*/
				$(liNode).addClass("tabin");
				$("#tabfirst div.contentin").removeClass("contentin");
				
				$("#tabfirst div").eq(index).addClass("contentin");
			},300);
		
		}).mouseout(function(){
			clearTimeout(timeoutid);
		});
	
	});
	
	/*������ҳ��װ����ɺ󣬱�ǩ2��������Ҫװ�뾲̬��htmlҳ��*/

	$("#realcontent").load("TabLoad.html");

	/*ע��������¼�*/
	$("#tabsecond li").each(function(index){	
		$(this).click(function(){
			$("#tabsecond li.tabin").removeClass("tabin");
			$(this).addClass("tabin");
			if(index == 0){
				//װ�뾲̬��������
				$("#realcontent").load("TabLoad.html");
			}else if(index == 1){
				//װ�붯̬���ֽ���
				$("#realcontent").load("TabLoad.jsp div");
			}else if(index == 2){
				//װ��Զ������
				$("#realcontent").load("TabData.jsp");
			}
		});
	});
	
	/*����loadingͼƬ��ajax����ʼ�ͽ������¼�*/
	//����loadingͼƬ��ajax����ʼ�ͽ����������¼�
	$("#contentsecond img").bind("ajaxStart",function(){
		//��div������������
		$("#realcontent").html("");
		//����ҳ��������ajax������ʼǰ��function�е����ݻᱻִ��
		$(this).show();
	}).bind("ajaxStop",function(){
		//����ҳ��������ajax����������function�е����ݻᱻִ��	
		$(this).slideUp("1000");
	});
});

