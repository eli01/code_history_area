 import java.awt.*;
 import java.util.*;
 import java.applet.Applet;

 public class GridBagEx1 extends Applet {
	 //��һ������������ʼ����ť�ĺ�������������ť�ַ������������ֹ�����������
     protected void makebutton(String name,GridBagLayout gridbag, GridBagConstraints c) {
         Button button = new Button(name);//�����ǰ�ť����ȻҲ�����Ǳ��
         gridbag.setConstraints(button, c);//������½��İ�ť��һ���������������
         add(button);//���������ť�ŵ��̳�applet���������������
     }

     //�����������ɳ�ʼ������
     public void init() {
         GridBagLayout gridbag = new GridBagLayout();//ʵ�����������ֹ�����
         GridBagConstraints c = new GridBagConstraints();//ʵ����һ������

         setFont(new Font("SansSerif", Font.PLAIN, 14));//���ö��������ڵ���������
         setLayout(gridbag);//���ö��������Ĳ��ֹ�����

         c.fill = GridBagConstraints.BOTH;//���õ������仯ʱ����Ŀ�͸߶�������Ӧ������������
         c.weightx = 1.0;
         makebutton("Button1", gridbag, c);
         makebutton("Button2", gridbag, c);
         makebutton("Button3", gridbag, c);

           c.gridwidth = GridBagConstraints.REMAINDER; //end row
         makebutton("Button4", gridbag, c);//ָ����һ�����Ϊ����

         c.weightx = 0.0;                  //reset to the default
         makebutton("Button5", gridbag, c); //another row

           c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
         makebutton("Button6", gridbag, c);

           c.gridwidth = GridBagConstraints.REMAINDER; //end row
         makebutton("Button7", gridbag, c);

           c.gridwidth = 1;                //reset to the default
           c.gridheight = 2;
         c.weighty = 1.0;
         makebutton("Button8", gridbag, c);

         c.weighty = 0.0;                  //reset to the default
           c.gridwidth = GridBagConstraints.REMAINDER; //end row
           c.gridheight = 1;               //reset to the default
         makebutton("Button9", gridbag, c);
         makebutton("Button10", gridbag, c);

         setSize(300, 100);
     }

     public static void main(String args[]) {
           Frame f = new Frame("GridBag Layout Example");
           GridBagEx1 ex1 = new GridBagEx1();

           ex1.init();

           f.add("Center", ex1);
           f.pack();
           f.setSize(f.getPreferredSize());
           f.show();
     }
 }
