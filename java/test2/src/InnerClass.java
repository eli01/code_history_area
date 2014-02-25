
class Human
{
 private String word = "We ";
 
 protected void en()
 {
  System.out.print("yes, ");
 }
 
  
 class chineseBrain    //一内部类，可以访问外部类的如何成员
  {
  String word = " are ";
  chineseBrain()
  {
   Human.this.en();     //访问外部类 成员方法
   String word =" Chinese";
   System.out.println(Human.this.word+this.word+word);     //内部类访问外部类成员变量 Human.this.word（注意是类名＋this），内部类和外部类的联系就是通过 外部类名＋this 建立的联系 ；访问本类成员变量 this.word ； 局域变量 word
  }
  
 }
}

class behavior
{
 public static void main(String [] args)
 {
  Human chinese = new Human(); //创建外部类对象，是内部类对象存在的先决条件
  Human.chineseBrain perform = chinese.new chineseBrain();  //内部类是不能被看见的，因此要用Human.chineseBrain来声明数据类型；内部类对象存在的前提是外部类对象已经存在，因此使用chinese.new chineseBrain()


  
 }
}