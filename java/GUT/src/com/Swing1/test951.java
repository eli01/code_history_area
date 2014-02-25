package com.Swing1;
import java.awt.*;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
public class test951 extends JFrame {
public test951() {
	String string;
	string="gvydhsasnao";
   String array[]={"fds","gsda","hgfed"};
Vector<String> items = new Vector<String>();
for (int i = 1; i<array.length; i++) {
items.add(array[i]);
}
JComboBox cb = new JComboBox(items);
System.out.println(cb.getSelectedItem().toString());
this.setLayout(new FlowLayout());
this.add(cb);
}
public static void main(String[] args) {
test951 t = new test951();
t.setSize(200, 200);
t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
t.setVisible(true);
}
}








