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
	JFrame jf=new JFrame("������");
	JButton jb=new JButton("a");
	JTable tab;
	JButton jbrow=new JButton("ɾ��ѡ����");
	JPanel jp=new JPanel();
	DefaultTableModel model;
	Object[][] obj=
		{
				new Object[] {"��� ","��","23" },
				new Object[] {"�Ÿ�","��","20"},
				new Object[] {"������","Ů","19"},
				new Object[] {"�׾���","��","21"},
				new Object[] {"����ͼ","��","22"},
		};
	//����
	String[] str= {"����","�Ա�","����"};
	public void init()
	{
		tab=new JTable(obj,str);
		tab.setCellSelectionEnabled(true);;
		jbrow.addActionListener(event ->
		{
			//����ѡ���к�
			int[] rowindex=tab.getSelectedRows();
			//model.removeRow(rowindex[0]);
			//tab.updateUI();
			//�ڱ������ɾ��ѡ�е��к�
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
