	import java.awt.BorderLayout;
	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.RowSorter;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.table.TableModel;
	import javax.swing.table.TableRowSorter;
	public class TestSortedTable {
	public static void main(String args[]) {
	JFrame frame = new JFrame("JTable���������");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// �������ʾ������
	Object rows[][] = { { 1, "����", "�й�", 44 }, { 2, "Ҧ��", "�й�", 25 },
	{ 3, "������", "����", 1234 }, { 4, "�ܲ�", "��κ", 2112 },
	{ 5, "Bill Gates", "����", 45 }};
	String columns[] = { "���", "����", "����", "����" };
	TableModel model = new DefaultTableModel(rows, columns);
	JTable table = new JTable(model);
	RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	table.setRowSorter(sorter);
	JScrollPane pane = new JScrollPane(table);
	frame.add(pane, BorderLayout.CENTER);
	frame.setSize(300, 150);
	frame.setVisible(true);
	}
	
}
