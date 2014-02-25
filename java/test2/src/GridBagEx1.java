 import java.awt.*;
 import java.util.*;
 import java.applet.Applet;

 public class GridBagEx1 extends Applet {
	 //做一个可以用来初始化按钮的函数，参数：按钮字符串、网袋布局管理器、容器
     protected void makebutton(String name,GridBagLayout gridbag, GridBagConstraints c) {
         Button button = new Button(name);//这里是按钮，当然也可以是别的
         gridbag.setConstraints(button, c);//将这个新建的按钮与一个网袋容器相关联
         add(button);//将这个按按钮放到继承applet的这个顶层容器里
     }

     //用这个函数完成初始化工作
     public void init() {
         GridBagLayout gridbag = new GridBagLayout();//实例化网袋布局管理器
         GridBagConstraints c = new GridBagConstraints();//实例化一个容器

         setFont(new Font("SansSerif", Font.PLAIN, 14));//设置顶层容器内的文字字体
         setLayout(gridbag);//设置顶层容器的布局管理器

         c.fill = GridBagConstraints.BOTH;//设置当容器变化时组件的宽和高都会自适应填满顶层容器
         c.weightx = 1.0;
         makebutton("Button1", gridbag, c);
         makebutton("Button2", gridbag, c);
         makebutton("Button3", gridbag, c);

           c.gridwidth = GridBagConstraints.REMAINDER; //end row
         makebutton("Button4", gridbag, c);//指定这一个组件为结束

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
