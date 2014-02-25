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
	JFrame frame = new JFrame("JTable的排序测试");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 表格中显示的数据
	Object rows[][] = { { 1, "王明", "中国", 44 }, { 2, "姚明", "中国", 25 },
	{ 3, "赵子龙", "西蜀", 1234 }, { 4, "曹操", "北魏", 2112 },
	{ 5, "Bill Gates", "美国", 45 }};
	String columns[] = { "序号", "姓名", "国籍", "年龄" };
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
