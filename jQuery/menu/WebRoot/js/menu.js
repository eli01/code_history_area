$(document).ready(function(){
	/*ҳ���е�dom�Ѿ�װ�����ʱ��ִ�еĴ���*/
	$(".main > a,.hmain > a").click(function(){
		/*������˵����Ӳ˵����ڵ�ul*/
		var ulNode=$(this).next("ul");
		/*if (ulNode.css("display") == "none") {
			ulNode.css("display","block");
		} else {
			ulNode.css("display","none");
		}*/	
		/*show()����������ʾ�ڵ㣬���Ӧ����hide()����
		 * show()����������������ʽ��
		 * 1.show(300)
		 * 2.show("slow/normal/fast")
		 * 3.show()*/
		
		/*�Զ��жϽڵ��Ƿ��Ѿ���ʾ*/
		//ulNode.toggle(500);
		//ulNode.slideDown("slow");
		//ulNode.slideUp("slow");
		ulNode.slideToggle();
		changeIcon($(this));
	});
	/*ע��һ������������뿪���¼�*/
	$(".hmain").hover(
		function(){
			/*�����ͣʱ����*/
			$(this).children("ul").slideDown();
			changeIcon($(this).children("a"));
		},
		function(){
			/*����뿪ʱ����*/
			$(this).children("ul").slideUp();
			changeIcon($(this).children("a"));
		}
	);
});

/**
 * �����޸����˵���ָʾͼ��ķ���
 * �����ַ�Ǵ���ʾҳ�����ڵ�λ�������
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
