//��Ҫ����ͨ��Javascript��������ݲ�����ż�еı���ɫ��ͬ
//$(document).ready(function(){
//	
//});
/*�򻯵�readyд��*/
$(function(){
	$("tbody tr:even").css("background-color","#ECE9D8");
	/*�ҵ�����ѧ�ŵ�Ԫ��*/
	var numId=$("tbody td:even");
	/*����Щ��Ԫ��ע�������¼�
	 * �ĸ�dom���󱻰�װ��һ���γ�һ��jQuery����*/
	numId.click(function(){
		//alert("click");
		/*�ҵ���ǰ�������һ��td
		 * ʵ������һ��dom����
		 * this����ǰ�������td*/
		var tdObj=$(this);
		if(tdObj.children("input").length>0){
			/*��ǰtd����input����ִ��click����*/
			return false;
		}
		var text=tdObj.html();
		/*���td�е�����*/
		tdObj.html("");
		/*����һ���ı���*/
		/*���ı���Ŀ�Ⱥ͡�����ͬ*/
		/*ȥ���ı���ı߿�*/
		/*���������ı��������ֵĴ�С*/
		/*�����ı���ı���*/
		/*���td�е��ı�*/
		/*�ӽڵ���븸�ڵ�*/
		var inputObj=$("<input type='text'/>")	
		.width(tdObj.width())		
		.css("border-width","0")		
		.css("font-size","16px")		
		.css("background-color",tdObj.css("background-color"))
		.val(text)	
		.appendTo(tdObj);
		/*ʹ�ı����Ȼ�ý���Ȼ��ѡ��*/
		inputObj.trigger("focus").trigger("select");
		/*��ֹ<input>�ϵ��¼���td�ϴ���*/
		inputObj.click(function(){
			return false;
		});
		//�����ı����ϻس���esc�����Ĳ���
		inputObj.keyup(function(event){
			//��ȡ��ǰ���¼��̵ļ�ֵ
			var keycode=event.which;
			//����س������
			if(keycode==13){
				//��ȡ��ǰ�ı����е�����
				var inputtext=$(this).val();
				//��td�е������޸�Ϊinput�е�����
				tdObj.html(inputtext);
			}
			//����esc�����
			if(keycode==27){
				//��td�е����ݻ�ԭΪtext
				tdObj.html(text);
			}

		});
	});
});