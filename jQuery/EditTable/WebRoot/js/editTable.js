//需要首先通过Javascript来解决内容部分奇偶行的背景色不同
//$(document).ready(function(){
//	
//});
/*简化的ready写法*/
$(function(){
	$("tbody tr:even").css("background-color","#ECE9D8");
	/*找到所有学号单元格*/
	var numId=$("tbody td:even");
	/*给这些单元格注册点击的事件
	 * 四个dom对象被包装在一起形成一个jQuery对象*/
	numId.click(function(){
		//alert("click");
		/*找到当前鼠标点击的一个td
		 * 实际上是一个dom对象
		 * this代表当前被点击的td*/
		var tdObj=$(this);
		if(tdObj.children("input").length>0){
			/*当前td中有input，不执行click处理*/
			return false;
		}
		var text=tdObj.html();
		/*清空td中的内容*/
		tdObj.html("");
		/*创建一个文本框*/
		/*是文本框的宽度和……相同*/
		/*去掉文本框的边框*/
		/*重新设置文本框中文字的大小*/
		/*设置文本框的背景*/
		/*获得td中的文本*/
		/*子节点插入父节点*/
		var inputObj=$("<input type='text'/>")	
		.width(tdObj.width())		
		.css("border-width","0")		
		.css("font-size","16px")		
		.css("background-color",tdObj.css("background-color"))
		.val(text)	
		.appendTo(tdObj);
		/*使文本框先获得焦点然后被选中*/
		inputObj.trigger("focus").trigger("select");
		/*禁止<input>上的事件向td上传播*/
		inputObj.click(function(){
			return false;
		});
		//处理文本框上回车和esc按键的操作
		inputObj.keyup(function(event){
			//获取当前按下键盘的键值
			var keycode=event.which;
			//处理回车的情况
			if(keycode==13){
				//获取当前文本框中的内容
				var inputtext=$(this).val();
				//将td中的内容修改为input中的内容
				tdObj.html(inputtext);
			}
			//处理esc的情况
			if(keycode==27){
				//将td中德内容还原为text
				tdObj.html(text);
			}

		});
	});
});