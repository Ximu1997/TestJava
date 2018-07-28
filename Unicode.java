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
	//定义一个窗体和容器
	JFrame jf=new JFrame("俄罗斯方块");
	JPanel jp=new JPanel();
	//定义一个二维数组
	JButton mapBt[][] = new JButton[10][10];
	//创建一个定时器
	//游戏开始
	//定义一个随机数类
	Random rd=new Random();
	public void init() 
	{
		FlowLayout  gb=new FlowLayout ();
		gb.setHgap(0);
		gb.setVgap(0);
		//绘制背景
		//循环赋值
		for (int i = 0;i < mapBt.length;i++) 
		{
			for(int j = 0;j<mapBt.length;j++) 
			{
				mapBt[i][j]=new JButton();
			}
		}
		//循环输出
		for (int i = 0;i < mapBt.length;i++) 
		{
			for(int j = 0;j<mapBt.length;j++) 
			{
				jp.add(mapBt[i][j]);
				
			}
		}
		//i控制行.j控制列
        int i, j;   
        //循环设置按钮属性
        for(i=0; i<mapBt.length; i++)
            for(j=0; j<mapBt.length; j++)
            {
                mapBt[i][j].setBackground(Color.white);
               mapBt[i][j].setPreferredSize(new Dimension(30,50));
                mapBt[i][j].setEnabled(false);
           }
		//游戏主体
		//把画板中心定义成“自己”
//		mapBt[(mapBt.length-1)/2][(mapBt.length-1)/2].
// 		setBackground(Color.cyan);
        //给窗体加上监听器
        jf.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) 
			{
				switch(e.getKeyCode()) 
				{
				//向右
					case 39:
					changeFlavor(1);
					break;
					//向上
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
	//控制方块往下掉的方法体
	private void time() 
	{
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
			//初始化行和列
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
	//画方块的方法体
	private void Dra(int Draw) 
	{
		int w=0;
		int h=0;
		switch(Draw) 
		{
		//正方形
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
	//控制上下左右移动的方法体
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
		
		//1代表右
			case 1:
    		        if(b<mapBt.length-1) 
    		        {
            			mapBt[a][b].setBackground(Color.white);
            			mapBt[a][b+1].setBackground(Color.cyan);
            			
    		        }
    		        break;
    		    //2上
			case 2:
		        if(a>0) 
		        {
        			mapBt[a][b].setBackground(Color.white);
        			mapBt[a-1][b].setBackground(Color.cyan);
        			
		        }
		        	break;
		        	//向上
			
			case 3:
				//向下移动
    		        if(a<mapBt.length-1) 
     		        {
	        			mapBt[a][b].setBackground(Color.white);
	        			mapBt[a+1][b].setBackground(Color.cyan);
	        			
     		        }
        		break;
			case 4:
				//向左移动
    		        if(b>0) 
     		        {
	        			mapBt[a][b].setBackground(Color.white);
	        			mapBt[a][b-1].setBackground(Color.cyan);
	        			System.out.println(a+"+ "+b);
     		        }
        		break;
		        	
		}
	}	
	//程序启动入口
	public static void main(String[] args) 
	{
		new Unicode().init();
	}
}
