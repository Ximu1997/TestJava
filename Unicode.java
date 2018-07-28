import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Unicode {
	//����һ�����������
	JFrame jf=new JFrame("����˹����");
	JPanel jp=new JPanel();
	//����һ����ά����
	JButton mapBt[][] = new JButton[10][10];
	//����һ����ʱ��
	//��Ϸ��ʼ
	//����һ���������
	Random rd=new Random();
	public void init() 
	{
		FlowLayout  gb=new FlowLayout ();
		gb.setHgap(0);
		gb.setVgap(0);
		//���Ʊ���
		//ѭ����ֵ
		for (int i = 0;i < mapBt.length;i++) 
		{
			for(int j = 0;j<mapBt.length;j++) 
			{
				mapBt[i][j]=new JButton();
			}
		}
		//ѭ�����
		for (int i = 0;i < mapBt.length;i++) 
		{
			for(int j = 0;j<mapBt.length;j++) 
			{
				jp.add(mapBt[i][j]);
				
			}
		}
		//i������.j������
        int i, j;   
        //ѭ�����ð�ť����
        for(i=0; i<mapBt.length; i++)
            for(j=0; j<mapBt.length; j++)
            {
                mapBt[i][j].setBackground(Color.white);
               mapBt[i][j].setPreferredSize(new Dimension(30,50));
                mapBt[i][j].setEnabled(false);
           }
		//��Ϸ����
		//�ѻ������Ķ���ɡ��Լ���
//		mapBt[(mapBt.length-1)/2][(mapBt.length-1)/2].
// 		setBackground(Color.cyan);
        //��������ϼ�����
        jf.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) 
			{
				switch(e.getKeyCode()) 
				{
				//����
					case 39:
					changeFlavor(1);
					break;
					//����
					case 38:
						changeFlavor(2);
						break;
					case 40:
						changeFlavor(3);
						break;
					case 37:
						changeFlavor(4);
						break;
				}
        	}
        });
        jp.setLayout(gb);
        jf.setFocusable(true);
        jf.setSize(320, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(jp);
		jf.setVisible(true);
		Dra(1);
		Dra(2);
	}
	//���Ʒ������µ��ķ�����
	private void time() 
	{
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
			//��ʼ���к���
			int x=0;
			int y=rd.nextInt(mapBt.length-1);
			
			public void run() {
				mapBt[x][y].setBackground(Color.cyan);
				System.out.println(y);
				if(x>0) 
				{
					mapBt[x][y].
				 	setBackground(Color.cyan);
					mapBt[x-1][y].
				 	setBackground(Color.white);
				}
				if(x==mapBt.length-1||mapBt[x+1][y].
					 	getBackground().equals(Color.cyan)) 
				{timer.cancel();}
				x++;
			}
		},0,1000);
	}
	//������ķ�����
	private void Dra(int Draw) 
	{
		int w=0;
		int h=0;
		switch(Draw) 
		{
		//������
		case 1:
			mapBt[w][h].setBackground(Color.cyan);
			mapBt[w][h+1].setBackground(Color.cyan);
			mapBt[w+1][h].setBackground(Color.cyan);
			mapBt[w+1][h+1].setBackground(Color.cyan);
			break;
			//z
		case 2:
			mapBt[w][h].setBackground(Color.cyan);
			mapBt[w][h+1].setBackground(Color.cyan);
			mapBt[w+1][h+1].setBackground(Color.cyan);
			mapBt[w+1][h+2].setBackground(Color.cyan);
			break;
		}
	}
	//�������������ƶ��ķ�����
	private void changeFlavor(int flavor) 
	{
		int a=0;
		int b=0;
		for(int q=0;q<mapBt.length;q++) 
		{
			for( int w=0;w<mapBt.length;w++) 
			{
				if(mapBt[q][w].getBackground().equals(Color.cyan)) 
				{
					a=q;
					b=w;
					break;
				}
			}
		}
		switch(flavor) 
		{
		
		//1������
			case 1:
    		        if(b<mapBt.length-1) 
    		        {
            			mapBt[a][b].setBackground(Color.white);
            			mapBt[a][b+1].setBackground(Color.cyan);
            			
    		        }
    		        break;
    		    //2��
			case 2:
		        if(a>0) 
		        {
        			mapBt[a][b].setBackground(Color.white);
        			mapBt[a-1][b].setBackground(Color.cyan);
        			
		        }
		        	break;
		        	//����
			
			case 3:
				//�����ƶ�
    		        if(a<mapBt.length-1) 
     		        {
	        			mapBt[a][b].setBackground(Color.white);
	        			mapBt[a+1][b].setBackground(Color.cyan);
	        			
     		        }
        		break;
			case 4:
				//�����ƶ�
    		        if(b>0) 
     		        {
	        			mapBt[a][b].setBackground(Color.white);
	        			mapBt[a][b-1].setBackground(Color.cyan);
	        			System.out.println(a+"+ "+b);
     		        }
        		break;
		        	
		}
	}	
	//�����������
	public static void main(String[] args) 
	{
		new Unicode().init();
	}
}
