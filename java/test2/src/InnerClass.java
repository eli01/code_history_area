
class Human
{
 private String word = "We ";
 
 protected void en()
 {
  System.out.print("yes, ");
 }
 
  
 class chineseBrain    //һ�ڲ��࣬���Է����ⲿ�����γ�Ա
  {
  String word = " are ";
  chineseBrain()
  {
   Human.this.en();     //�����ⲿ�� ��Ա����
   String word =" Chinese";
   System.out.println(Human.this.word+this.word+word);     //�ڲ�������ⲿ���Ա���� Human.this.word��ע����������this�����ڲ�����ⲿ�����ϵ����ͨ�� �ⲿ������this ��������ϵ �����ʱ����Ա���� this.word �� ������� word
  }
  
 }
}

class behavior
{
 public static void main(String [] args)
 {
  Human chinese = new Human(); //�����ⲿ��������ڲ��������ڵ��Ⱦ�����
  Human.chineseBrain perform = chinese.new chineseBrain();  //�ڲ����ǲ��ܱ������ģ����Ҫ��Human.chineseBrain�������������ͣ��ڲ��������ڵ�ǰ�����ⲿ������Ѿ����ڣ����ʹ��chinese.new chineseBrain()


  
 }
}