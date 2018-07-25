package test;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Table {
	JFrame jf=new JFrame("表格测试");
	JButton jb=new JButton("a");
	JTable tab;
	JButton jbrow=new JButton("删除选中行");
	JPanel jp=new JPanel();
	DefaultTableModel model;
	Object[][] obj=
		{
				new Object[] {"李白 ","男","23" },
				new Object[] {"杜甫","男","20"},
				new Object[] {"李清照","女","19"},
				new Object[] {"白居易","男","21"},
				new Object[] {"柏拉图","男","22"},
		};
	//标题
	String[] str= {"姓名","性别","年龄"};
	public void init()
	{
		tab=new JTable(obj,str);
		tab.setCellSelectionEnabled(true);;
		jbrow.addActionListener(event ->
		{
			//返回选中行号
			int[] rowindex=tab.getSelectedRows();
			//model.removeRow(rowindex[0]);
			//tab.updateUI();
			//在表格里面删除选中的行号
//			for(int i =rowindex.length;i>=0;i--) 
//			{
//				model.removeRow(rowindex[i]);
//			}
		});
		
		jp.add(jbrow);
		jf.add(jp,BorderLayout.SOUTH);
		jf.add(new JScrollPane(tab),BorderLayout.CENTER);
		jf.setVisible(true);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) 
	{
		new Table().init();
	}
}
