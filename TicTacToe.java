import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
class TicTacToe extends Canvas implements ActionListener
{
	JFrame f;
	JPanel p1,p2;
	JButton b[]=new JButton[19];
	int A[]=new int[19];
	int B[]=new int[19];
	int C[]=new int[19];
	JMenuBar mb;
	JMenuItem New,Exit,about;
	JCheckBoxMenuItem Player1,Player2;
	JMenu help,File,Option;
	Icon i1,i2;
	int count=0,d=0,c=0,e=0,hp=0;
	static int who=0;
	public static void main(String... s)
	{
		new TicTacToe("TicTacToe",0);
	}
	TicTacToe(String st,int fg)
	{
		MyDialog1.tt=this;
		count=fg;
		i1=new ImageIcon("o.gif");
		i2=new ImageIcon("x.gif");
		f=new JFrame(st);
		p1=new JPanel();
		p2=new JPanel();
		mb=new JMenuBar();
		New=new JMenuItem("New");
		Exit=new JMenuItem("Exit");
		Option=new JMenu("Options");
		Player1=new JCheckBoxMenuItem("Player 1",true);
		Player2=new JCheckBoxMenuItem("Player 2",false);
		Option.add(Player1);
		Option.add(Player2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(Player1);
		bg.add(Player2);
		File=new JMenu("File");
		File.add(New);
		File.add(Option);
		File.addSeparator();
		File.add(Exit);
		mb.add(File);
		about=new JMenuItem("About");
		help=new JMenu("Help");
		help.add(about);
		mb.add(help);
		f.setJMenuBar(mb);
		New.addActionListener(this);
		Exit.addActionListener(this);
		about.addActionListener(this);
		for(int i=0;i<9;i++)
		{
			b[i]=new JButton();
			p1.add(b[i]);
			b[i].addActionListener(this);
		}
		for(int i=10;i<19;i++)
		{
			b[i]=new JButton();
			p2.add(b[i]);
			b[i].addActionListener(this);
		}
		b[9]=new JButton("START");
		b[9].setBounds(289,280,80,30);
		b[9].setBackground(Color.YELLOW);
		b[9].setForeground(Color.RED);
		f.add(b[9]);
		b[9].addActionListener(this);
		f.add(this);
		p1.setLayout(new GridLayout(3,3));
		p2.setLayout(new GridLayout(3,3));
		f.setSize(680,650);
		f.setVisible(true);
		f.setLocation(300,40);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
		setBackground(Color.YELLOW);
		setForeground(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.drawString("TIC TAC TOE GAME",100,100);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g.drawString("******************************************************************",100,360);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.drawString("PRABHAV GARG",128,460);
		g.drawOval(278,160,100,100);
		g.drawOval(298,180,25,25);
		g.drawOval(335,180,25,25);
		g.drawArc(293,170,70,80,180,180);
		g.drawArc(293,178,70,60,180,180);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b[9])
		{
			if(Player1.isSelected())
			{
				f.remove(p2);
				f.setContentPane(p1);
				f.validate();
				f.repaint();
				count=0;
			}
			else
			{
				f.remove(p1);
				f.setContentPane(p2);
				f.validate();
				f.repaint();
			}
		}
		if(e.getActionCommand().equals("Exit"))
		{
		System.exit(0);
		}
		if(e.getActionCommand().equals("About"))
		{
			new MyDialog1(4).setVisible(true);
		}
		else if(Player1.isSelected())
		{
			if(e.getActionCommand().equals("New"))
			{
				f.setVisible(false); d=0; count=-10; 
				for(int j=0;j<19;j++)
				{A[j]=0; B[j]=0; C[j]=0;}
					TicTacToe.who=0;
				new TicTacToe("Prabhav",0);
				f.validate();
				f.repaint();
			}
			if(count==0) {new MyDialog1(6).setVisible(true); count++; }
			if(TicTacToe.who==1)
			{
				if(count==1)
				{
					if(e.getSource()!=b[4])
					{for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i])
						{count++; b[i].setIcon(i1); A[i]=1; C[i]=1;
						b[i]=null; b[4].setIcon(i2); B[4]=1; b[4]=null; C[4]=1;}
					}}
					else
					{
						count++;
						b[4].setIcon(i1); A[4]=1; C[4]=1;
						b[4]=null; b[0].setIcon(i2); B[0]=1; b[0]=null; C[0]=1;
					}
				}
				else if(count==2)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i1); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
							if(B[0]+B[1]+B[2]==2&&C[0]+C[1]+C[2]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[1]==0) {b[1].setIcon(i2); B[1]=1;C[1]=1; b[1]=null;}if(B[2]==0) {b[2].setIcon(i2); B[2]=1;C[2]=1; b[2]=null;}}
							else if(B[3]+B[4]+B[5]==2&&C[3]+C[4]+C[5]!=3)	{if(B[3]==0) {b[3].setIcon(i2); B[3]=1; C[3]=1; b[3]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}}
							else if(B[6]+B[7]+B[8]==2&&C[6]+C[7]+C[8]!=3)	{if(B[6]==0) {b[6].setIcon(i2); B[6]=1; C[6]=1; b[6]=null;}if(B[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[0]+B[3]+B[6]==2&&C[0]+C[3]+C[6]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[3]==0) {b[3].setIcon(i2); B[3]=1;C[3]=1; b[3]=null;}if(B[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else if(B[1]+B[4]+B[7]==2&&C[1]+C[4]+C[7]!=3)	{if(B[1]==0) {b[1].setIcon(i2); B[1]=1; C[1]=1; b[1]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}}
							else if(B[2]+B[5]+B[8]==2&&C[2]+C[5]+C[8]!=3)	{if(B[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(B[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[0]+B[4]+B[8]==2&&C[0]+C[4]+C[8]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[2]+B[4]+B[6]==2&&C[2]+C[4]+C[6]!=3)	{if(B[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else if(A[0]+A[1]+A[2]==2&&C[0]+C[1]+C[2]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[1]==0) {b[1].setIcon(i2); B[1]=1;C[1]=1; b[1]=null;}if(A[2]==0) {b[2].setIcon(i2); B[2]=1;C[2]=1; b[2]=null;}}
							else if(A[3]+A[4]+A[5]==2&&C[3]+C[4]+C[5]!=3)	{if(A[3]==0) {b[3].setIcon(i2); B[3]=1; C[3]=1; b[6]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}}
							else if(A[6]+A[7]+A[8]==2&&C[6]+C[7]+C[8]!=3)	{if(A[6]==0) {b[6].setIcon(i2); B[6]=1; C[6]=1; b[6]=null;}if(A[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[0]+A[3]+A[6]==2&&C[0]+C[3]+C[6]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[3]==0) {b[3].setIcon(i2); B[3]=1;C[3]=1; b[3]=null;}if(A[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else if(A[1]+A[4]+A[7]==2&&C[1]+C[4]+C[7]!=3)	{if(A[1]==0) {b[1].setIcon(i2); B[1]=1; C[1]=1; b[1]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}}
							else if(A[2]+A[5]+A[8]==2&&C[2]+C[5]+C[8]!=3)	{if(A[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(A[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[0]+A[4]+A[8]==2&&C[0]+C[4]+C[8]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[2]+A[4]+A[6]==2&&C[2]+C[4]+C[6]!=3)	{if(A[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else
							{
								for(int k=0;k<9;k++)
								{
									if(C[k]!=1)
									{
										b[k].setIcon(i2); B[k]=1; C[k]=1; b[k]=null; break;
									}
								}
							}
				}
				else if(count==3)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i1); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
				if(A[0]+A[1]+A[2]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[3]+A[4]+A[5]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[6]+A[7]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[3]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[1]+A[4]+A[7]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[5]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[4]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[4]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[1]+B[2]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[3]+B[4]+B[5]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[6]+B[7]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[3]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[1]+B[4]+B[7]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[5]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[4]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[4]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(d==1){c=1;	for(int j=0;j<=9;j++)	b[j]=null;}
			else if(count==6&&d!=1)	{new MyDialog1(5).setVisible(true); c=1;}
			else{
					if(B[0]+B[1]+B[2]==2&&C[0]+C[1]+C[2]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[1]==0) {b[1].setIcon(i2); B[1]=1;C[1]=1; b[1]=null;}if(B[2]==0) {b[2].setIcon(i2); B[2]=1;C[2]=1; b[2]=null;}}
					else if(B[3]+B[4]+B[5]==2&&C[3]+C[4]+C[5]!=3)	{if(B[3]==0) {b[3].setIcon(i2); B[3]=1; C[3]=1; b[3]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}}
					else if(B[6]+B[7]+B[8]==2&&C[6]+C[7]+C[8]!=3)	{if(B[6]==0) {b[6].setIcon(i2); B[6]=1; C[6]=1; b[6]=null;}if(B[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[3]+B[6]==2&&C[0]+C[3]+C[6]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[3]==0) {b[3].setIcon(i2); B[3]=1;C[3]=1; b[3]=null;}if(B[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
					else if(B[1]+B[4]+B[7]==2&&C[1]+C[4]+C[7]!=3)	{if(B[1]==0) {b[1].setIcon(i2); B[1]=1; C[1]=1; b[1]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}}
					else if(B[2]+B[5]+B[8]==2&&C[2]+C[5]+C[8]!=3)	{if(B[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(B[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[4]+B[8]==2&&C[0]+C[4]+C[8]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[2]+B[4]+B[6]==2&&C[2]+C[4]+C[6]!=3)	{if(B[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[0]+A[1]+A[2]==2&&C[0]+C[1]+C[2]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[1]==0) {b[1].setIcon(i2); B[1]=1;C[1]=1; b[1]=null;}if(A[2]==0) {b[2].setIcon(i2); B[2]=1;C[2]=1; b[2]=null;}}
					else if(A[3]+A[4]+A[5]==2&&C[3]+C[4]+C[5]!=3)	{if(A[3]==0) {b[3].setIcon(i2); B[3]=1; C[3]=1; b[3]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}}
					else if(A[6]+A[7]+A[8]==2&&C[6]+C[7]+C[8]!=3)	{if(A[6]==0) {b[6].setIcon(i2); B[6]=1; C[6]=1; b[6]=null;}if(A[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[3]+A[6]==2&&C[0]+C[3]+C[6]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[3]==0) {b[3].setIcon(i2); B[3]=1;C[3]=1; b[3]=null;}if(A[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[1]+A[4]+A[7]==2&&C[1]+C[4]+C[7]!=3)	{if(A[1]==0) {b[1].setIcon(i2); B[1]=1; C[1]=1; b[1]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}}
					else if(A[2]+A[5]+A[8]==2&&C[2]+C[5]+C[8]!=3)	{if(A[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(A[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[4]+A[8]==2&&C[0]+C[4]+C[8]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[2]+A[4]+A[6]==2&&A[2]+C[4]+C[6]!=3)	{if(A[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
					else
					{
						for(int k=0;k<9;k++)
						{
							if(C[k]==0)
							{
								b[k].setIcon(i2); B[k]=1; C[k]=1; b[k]=null; break;
							}
						}
					}}
				}
				else if(count==4)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i1); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
					if(A[0]+A[1]+A[2]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[3]+A[4]+A[5]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[6]+A[7]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[3]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[1]+A[4]+A[7]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[5]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[4]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[4]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[1]+B[2]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[3]+B[4]+B[5]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[6]+B[7]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[3]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[1]+B[4]+B[7]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[5]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[4]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[4]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(d==1){c=1;	for(int j=0;j<=9;j++)	b[j]=null;}
			else if(count==6&&d!=1)	{new MyDialog1(5).setVisible(true); c=1;}
			else{
							if(B[0]+B[1]+B[2]==2&&C[0]+C[1]+C[2]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[1]==0) {b[1].setIcon(i2); B[1]=1;C[1]=1; b[1]=null;}if(B[2]==0) {b[2].setIcon(i2); B[2]=1;C[2]=1; b[2]=null;}}
							else if(B[3]+B[4]+B[5]==2&&C[3]+C[4]+C[5]!=3)	{if(B[3]==0) {b[3].setIcon(i2); B[3]=1; C[3]=1; b[3]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}}
							else if(B[6]+B[7]+B[8]==2&&C[6]+C[7]+C[8]!=3)	{if(B[6]==0) {b[6].setIcon(i2); B[6]=1; C[6]=1; b[6]=null;}if(B[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[0]+B[3]+B[6]==2&&C[3]+C[3]+C[6]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[3]==0) {b[3].setIcon(i2); B[3]=1;C[3]=1; b[3]=null;}if(B[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else if(B[1]+B[4]+B[7]==2&&C[1]+C[4]+C[7]!=3)	{if(B[1]==0) {b[1].setIcon(i2); B[1]=1; C[1]=1; b[1]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}}
							else if(B[2]+B[5]+B[8]==2&&C[2]+C[5]+C[8]!=3)	{if(B[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(B[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[0]+B[4]+B[8]==2&&C[0]+C[4]+C[8]!=3)	{if(B[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[2]+B[4]+B[6]==2&&C[2]+C[4]+C[6]!=3)	{if(B[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(B[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(B[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else if(A[0]+A[1]+A[2]==2&&C[0]+C[1]+C[2]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[1]==0) {b[1].setIcon(i2); B[1]=1;C[1]=1; b[1]=null;}if(A[2]==0) {b[2].setIcon(i2); B[2]=1;C[2]=1; b[2]=null;}}
							else if(A[3]+A[4]+A[5]==2&&C[3]+C[4]+C[5]!=3)	{if(A[3]==0) {b[3].setIcon(i2); B[3]=1; C[3]=1; b[3]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}}
							else if(A[6]+A[7]+A[8]==2&&C[6]+C[7]+C[8]!=3)	{if(A[6]==0) {b[6].setIcon(i2); B[6]=1; C[6]=1; b[6]=null;}if(A[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[0]+A[3]+A[6]==2&&C[0]+C[3]+C[6]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[3]==0) {b[3].setIcon(i2); B[3]=1;C[3]=1; b[3]=null;}if(A[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else if(A[1]+A[4]+A[7]==2&&C[1]+C[4]+C[7]!=3)	{if(A[1]==0) {b[1].setIcon(i2); B[1]=1; C[1]=1; b[1]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[7]==0) {b[7].setIcon(i2); B[7]=1;C[7]=1; b[7]=null;}}
							else if(A[2]+A[5]+A[8]==2&&C[2]+C[5]+C[8]!=3)	{if(A[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(A[5]==0) {b[5].setIcon(i2); B[5]=1;C[5]=1; b[5]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[0]+A[4]+A[8]==2&&C[0]+C[4]+C[8]!=3)	{if(A[0]==0) {b[0].setIcon(i2); B[0]=1; C[0]=1; b[0]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[8]==0) {b[8].setIcon(i2); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[2]+A[4]+A[6]==2&&C[2]+C[4]+C[6]!=3)	{if(A[2]==0) {b[2].setIcon(i2); B[2]=1; C[2]=1; b[2]=null;}if(A[4]==0) {b[4].setIcon(i2); B[4]=1;C[4]=1; b[4]=null;}if(A[6]==0) {b[6].setIcon(i2); B[6]=1;C[6]=1; b[6]=null;}}
							else
							{
								for(int k=0;k<9;k++)
								{
									if(C[k]!=1)
									{
										b[k].setIcon(i2); B[k]=1; C[k]=1; b[k]=null; break;
									}
								}
							}}
						
					
				}
				else if(count==5)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i1); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
				}
			}
			else if(TicTacToe.who==2)
			{
				if(count==1)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i2); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
					if(B[0]+B[1]+B[2]==2&&C[0]+C[1]+C[2]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(B[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
					else if(B[3]+B[4]+B[5]==2&&C[3]+C[4]+C[5]!=3)	{if(B[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[3]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
					else if(B[6]+B[7]+B[8]==2&&C[6]+C[7]+C[8]!=3)	{if(B[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[3]+B[6]==2&&C[0]+C[3]+C[6]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(B[1]+B[4]+B[7]==2&&C[1]+C[4]+C[7]!=3)	{if(B[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
					else if(B[2]+B[5]+B[8]==2&&C[2]+C[5]+C[8]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[4]+B[8]==2&&C[0]+C[4]+C[8]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[2]+B[4]+B[6]==2&&C[2]+C[4]+C[6]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[0]+A[1]+A[2]==2&&C[0]+C[1]+C[2]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(A[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
					else if(A[3]+A[4]+A[5]==2&&C[3]+C[4]+C[5]!=3)	{if(A[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[6]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
					else if(A[6]+A[7]+A[8]==2&&C[6]+C[7]+C[8]!=3)	{if(A[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[3]+A[6]==2&&C[0]+C[3]+C[6]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[1]+A[4]+A[7]==2&&C[1]+C[4]+C[7]!=3)	{if(A[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
					else if(A[2]+A[5]+A[8]==2&&C[2]+C[5]+C[8]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[4]+A[8]==2&&C[0]+C[4]+C[8]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[2]+A[4]+A[6]==2&&C[2]+C[4]+C[6]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else
					{
						for(int k=0;k<9;k++)
						{
							if(C[k]!=1)
							{
								b[k].setIcon(i1); B[k]=1; C[k]=1; b[k]=null; break;
							}
						}
					}
				}
				else if(count==2)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i2); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
				
					if(B[0]+B[1]+B[2]==2&&C[0]+C[1]+C[2]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(B[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
					else if(B[3]+B[4]+B[5]==2&&C[3]+C[4]+C[5]!=3)	{if(B[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[3]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
					else if(B[6]+B[7]+B[8]==2&&C[6]+C[7]+C[8]!=3)	{if(B[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[3]+B[6]==2&&C[0]+C[3]+C[6]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(B[1]+B[4]+B[7]==2&&C[1]+C[4]+C[7]!=3)	{if(B[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
					else if(B[2]+B[5]+B[8]==2&&C[2]+C[5]+C[8]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[4]+B[8]==2&&C[0]+C[4]+C[8]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[2]+B[4]+B[6]==2&&C[2]+C[4]+C[6]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[0]+A[1]+A[2]==2&&C[0]+C[1]+C[2]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(A[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
					else if(A[3]+A[4]+A[5]==2&&C[3]+C[4]+C[5]!=3)	{if(A[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[3]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
					else if(A[6]+A[7]+A[8]==2&&C[6]+C[7]+C[8]!=3)	{if(A[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[3]+A[6]==2&&C[0]+C[3]+C[6]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[1]+A[4]+A[7]==2&&C[1]+C[4]+C[7]!=3)	{if(A[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
					else if(A[2]+A[5]+A[8]==2&&C[2]+C[5]+C[8]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[4]+A[8]==2&&C[0]+C[4]+C[8]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[2]+A[4]+A[6]==2&&A[2]+C[4]+C[6]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else
					{
						for(int k=0;k<9;k++)
						{
							if(C[k]==0)
							{
								b[k].setIcon(i1); B[k]=1; C[k]=1; b[k]=null; break;
							}
						}
					}
				}
				else if(count==3)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i2); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
						if(A[0]+A[1]+A[2]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[3]+A[4]+A[5]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[6]+A[7]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[3]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[1]+A[4]+A[7]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[5]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[4]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[4]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[1]+B[2]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[3]+B[4]+B[5]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[6]+B[7]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[3]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[1]+B[4]+B[7]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[5]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[4]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[4]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(d==1){c=1;	for(int j=0;j<=9;j++)	b[j]=null;}
			else if(count==6&&d!=1)	{new MyDialog1(5).setVisible(true); c=1;}
					//
						//
						else{	if(B[0]+B[1]+B[2]==2&&C[0]+C[1]+C[2]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(B[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
							else if(B[3]+B[4]+B[5]==2&&C[3]+C[4]+C[5]!=3)	{if(B[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[3]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
							else if(B[6]+B[7]+B[8]==2&&C[6]+C[7]+C[8]!=3)	{if(B[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[0]+B[3]+B[6]==2&&C[3]+C[3]+C[6]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
							else if(B[1]+B[4]+B[7]==2&&C[1]+C[4]+C[7]!=3)	{if(B[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
							else if(B[2]+B[5]+B[8]==2&&C[2]+C[5]+C[8]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[0]+B[4]+B[8]==2&&C[0]+C[4]+C[8]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
							else if(B[2]+B[4]+B[6]==2&&C[2]+C[4]+C[6]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
							else if(A[0]+A[1]+A[2]==2&&C[0]+C[1]+C[2]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(A[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
							else if(A[3]+A[4]+A[5]==2&&C[3]+C[4]+C[5]!=3)	{if(A[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[3]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
							else if(A[6]+A[7]+A[8]==2&&C[6]+C[7]+C[8]!=3)	{if(A[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[0]+A[3]+A[6]==2&&C[0]+C[3]+C[6]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
							else if(A[1]+A[4]+A[7]==2&&C[1]+C[4]+C[7]!=3)	{if(A[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
							else if(A[2]+A[5]+A[8]==2&&C[2]+C[5]+C[8]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[0]+A[4]+A[8]==2&&C[0]+C[4]+C[8]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
							else if(A[2]+A[4]+A[6]==2&&C[2]+C[4]+C[6]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
							else
							{
								for(int k=0;k<9;k++)
								{
									if(C[k]!=1)
									{
										b[k].setIcon(i1); B[k]=1; C[k]=1; b[k]=null; break;
									}
								}
							}}
						
					
				}
				else if(count==4)
				{
					for(int i=0;i<9;i++)
					{
						if(e.getSource()==b[i]&&C[i]==0)
						{
							count++;
							b[i].setIcon(i2); A[i]=1; C[i]=1;
							b[i]=null;
						}
					}
				if(A[0]+A[1]+A[2]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[3]+A[4]+A[5]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[6]+A[7]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[3]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1; System.out.println("HI");}
			else if(A[1]+A[4]+A[7]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[5]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[0]+A[4]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(A[2]+A[4]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[1]+B[2]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[3]+B[4]+B[5]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[6]+B[7]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[3]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[1]+B[4]+B[7]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[5]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[0]+B[4]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(B[2]+B[4]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;hp=1;}
			else if(d==1){c=1;	for(int j=0;j<=9;j++)	b[j]=null;}
			else if(count==6&&d!=1)	{new MyDialog1(5).setVisible(true); c=1;}
			else{
					if(B[0]+B[1]+B[2]==2&&C[0]+C[1]+C[2]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(B[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
					else if(B[3]+B[4]+B[5]==2&&C[3]+C[4]+C[5]!=3)	{if(B[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[3]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
					else if(B[6]+B[7]+B[8]==2&&C[6]+C[7]+C[8]!=3)	{if(B[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[3]+B[6]==2&&C[3]+C[3]+C[6]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(B[1]+B[4]+B[7]==2&&C[1]+C[4]+C[7]!=3)	{if(B[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
					else if(B[2]+B[5]+B[8]==2&&C[2]+C[5]+C[8]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[0]+B[4]+B[8]==2&&C[0]+C[4]+C[8]!=3)	{if(B[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(B[2]+B[4]+B[6]==2&&C[2]+C[4]+C[6]!=3)	{if(B[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(B[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(B[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[0]+A[1]+A[2]==2&&C[0]+C[1]+C[2]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[1]==0) {b[1].setIcon(i1); B[1]=1;C[1]=1; b[1]=null;}if(A[2]==0) {b[2].setIcon(i1); B[2]=1;C[2]=1; b[2]=null;}}
					else if(A[3]+A[4]+A[5]==2&&C[3]+C[4]+C[5]!=3)	{if(A[3]==0) {b[3].setIcon(i1); B[3]=1; C[3]=1; b[3]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}}
					else if(A[6]+A[7]+A[8]==2&&C[6]+C[7]+C[8]!=3)	{if(A[6]==0) {b[6].setIcon(i1); B[6]=1; C[6]=1; b[6]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[3]+A[6]==2&&C[0]+C[3]+C[6]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[3]==0) {b[3].setIcon(i1); B[3]=1;C[3]=1; b[3]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else if(A[1]+A[4]+A[7]==2&&C[1]+C[4]+C[7]!=3)	{if(A[1]==0) {b[1].setIcon(i1); B[1]=1; C[1]=1; b[1]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[7]==0) {b[7].setIcon(i1); B[7]=1;C[7]=1; b[7]=null;}}
					else if(A[2]+A[5]+A[8]==2&&C[2]+C[5]+C[8]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[5]==0) {b[5].setIcon(i1); B[5]=1;C[5]=1; b[5]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[0]+A[4]+A[8]==2&&C[0]+C[4]+C[8]!=3)	{if(A[0]==0) {b[0].setIcon(i1); B[0]=1; C[0]=1; b[0]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[8]==0) {b[8].setIcon(i1); B[8]=1;C[8]=1; b[8]=null;}}
					else if(A[2]+A[4]+A[6]==2&&C[2]+C[4]+C[6]!=3)	{if(A[2]==0) {b[2].setIcon(i1); B[2]=1; C[2]=1; b[2]=null;}if(A[4]==0) {b[4].setIcon(i1); B[4]=1;C[4]=1; b[4]=null;}if(A[6]==0) {b[6].setIcon(i1); B[6]=1;C[6]=1; b[6]=null;}}
					else
					{
					for(int k=0;k<9;k++)
						{
							if(C[k]!=1)
							{
								b[k].setIcon(i1); B[k]=1; C[k]=1; b[k]=null; break;
							}
						}
					}}
				}
			}
			if(TicTacToe.who==2){
			if(A[0]+A[1]+A[2]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[3]+A[4]+A[5]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[6]+A[7]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			//if(A[0]+A[3]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1; System.out.println("HII");}
			if(A[1]+A[4]+A[7]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[2]+A[5]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[0]+A[4]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[2]+A[4]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(B[0]+B[1]+B[2]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[3]+B[4]+B[5]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[6]+B[7]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[0]+B[3]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[1]+B[4]+B[7]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[2]+B[5]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[0]+B[4]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[2]+B[4]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(d==1){c=1;	for(int j=0;j<=9;j++)	b[j]=null;}
			if(count==5&&d!=1)	{new MyDialog1(5).setVisible(true); c=1;}}
			if(TicTacToe.who==1&&hp==0){if(d==1){c=1;	for(int j=0;j<=9;j++)	b[j]=null;}
			if(count==6&&d!=1)	{new MyDialog1(5).setVisible(true); c=1;}}}
			if(TicTacToe.who==1&&hp==0)
			{
			if(A[0]+A[1]+A[2]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[3]+A[4]+A[5]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[6]+A[7]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[0]+A[3]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[1]+A[4]+A[7]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[2]+A[5]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[0]+A[4]+A[8]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(A[2]+A[4]+A[6]==3)	{new MyDialog1(7).setVisible(true);d=1;}
			if(B[0]+B[1]+B[2]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[3]+B[4]+B[5]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[6]+B[7]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[0]+B[3]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[1]+B[4]+B[7]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[2]+B[5]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[0]+B[4]+B[8]==3)	{new MyDialog1(3).setVisible(true);d=1;}
			if(B[2]+B[4]+B[6]==3)	{new MyDialog1(3).setVisible(true);d=1;}		
		}
		else if(Player2.isSelected())
		{
			if(e.getActionCommand().equals("New"))
			{
				System.out.println("GHUssa");
				f.setVisible(false); d=0; count=10; 
				for(int j=0;j<19;j++)
				{A[j]=0; B[j]=0; C[j]=0;}
				 new TicTacToe("Prabhav",0);
				f.setContentPane(p2);
				f.remove(p1);
				f.validate();
				f.repaint();
			}
			else if(e.getSource()==b[10])
			{
				if(count%2==0)
				{b[10].setIcon(i1); A[10]=1;}
				else
				{b[10].setIcon(i2); B[10]=1;}
				count++;
				b[10]=null;
			}
			else if(e.getSource()==b[11])
			{
				if(count%2==0)
				{b[11].setIcon(i1); A[11]=1;}
				else
				{b[11].setIcon(i2); B[11]=1;}
				count++;
				b[11]=null;
			}
			else if(e.getSource()==b[12])
			{
				if(count%2==0)
				{b[12].setIcon(i1); A[12]=1;}
				else
				{b[12].setIcon(i2); B[12]=1;}
				count++;
				b[12]=null;
			}
			else if(e.getSource()==b[13])
			{
				if(count%2==0)
				{b[13].setIcon(i1); A[13]=1;}
				else
				{b[13].setIcon(i2); B[13]=1;}
				count++;
				b[13]=null;
			}
			else if(e.getSource()==b[14])
			{
				if(count%2==0)
				{b[14].setIcon(i1); A[14]=1;}
				else
				{b[14].setIcon(i2); B[14]=1;}
				count++;
				b[14]=null;
			}
			else if(e.getSource()==b[15])
			{
				if(count%2==0)
				{b[15].setIcon(i1); A[15]=1;}
				else
				{b[15].setIcon(i2); B[15]=1;}
				count++;
				b[15]=null;
			}
			else if(e.getSource()==b[16])
			{
				if(count%2==0)
				{b[16].setIcon(i1); A[16]=1;}
				else
				{b[16].setIcon(i2); B[16]=1;}
				count++;
				b[16]=null;
			}
			else if(e.getSource()==b[17])
			{
				if(count%2==0)
				{b[17].setIcon(i1); A[17]=1;}
				else
				{b[17].setIcon(i2); B[17]=1;}
				count++;
				b[17]=null;
			}
			else if(e.getSource()==b[18])
			{
				if(count%2==0)
				{b[18].setIcon(i1); A[18]=1;}
				else
				{b[18].setIcon(i2); B[18]=1;}
				count++;
				b[18]=null;
			}
			if(A[10]+A[11]+A[12]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(A[13]+A[14]+A[15]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(A[16]+A[17]+A[18]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(A[10]+A[13]+A[16]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(A[11]+A[14]+A[17]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(A[12]+A[15]+A[18]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(A[10]+A[14]+A[18]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(A[12]+A[14]+A[16]==3)	{new MyDialog1(1).setVisible(true);d=1;}
			if(B[10]+B[11]+B[12]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(B[13]+B[14]+B[15]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(B[16]+B[17]+B[18]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(B[10]+B[13]+B[16]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(B[11]+B[14]+B[17]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(B[12]+B[15]+B[18]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(B[10]+B[14]+B[18]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(B[12]+B[14]+B[16]==3)	{new MyDialog1(2).setVisible(true);d=1;}
			if(d==1){c=1;	for(int j=10;j<=18;j++)	b[j]=null;}
			if(count==9&&d!=1)	{new MyDialog1(5).setVisible(true); c=1;}
		}
	}
}
class MyDialog1 extends JFrame implements ActionListener
{
	static TicTacToe tt;
	JFrame f1;
	JLabel tf;
	JButton b1,b2,b3;
	MyDialog1(int a)
	{
		String s="";
		if(a==1) s="Player1 Won..!!";
		if(a==2) s="Player2 Won..!!";
		if(a==3) s="Computer Won..!!";
		if(a==4) s="This Game is Designed by Prabhav Garg..!!";
		if(a==5) s="Game Draw..!!";
		if(a==6) s="Wanna Play First..??";
		if(a==7) s="You won..!!";
		f1=new JFrame();
		tf=new JLabel(s);
		if(a!=4)
		tf.setBounds(100,30,250,40);
		else
		tf.setBounds(20,30,250,40);
		add(tf);
		if(a==6){
		b1=new JButton("Yes");
		b2=new JButton("No");
		b1.setBounds(60,100,80,30);
		add(b1);
		b1.addActionListener(this);
		b2.setBounds(160,100,80,30);
		add(b2);
		b2.addActionListener(this);
		}
		else
		{b3=new JButton("OK");
		b3.setBounds(100,100,80,30);
		add(b3);
		b3.addActionListener(this);
		}
		setSize(300,200);
		setLocation(450,220);
		setLayout(null);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b3)
		{
			this.setVisible(false);
		}
		if(e.getSource()==b1)
		{
			TicTacToe.who=1;
			this.setVisible(false);
		}
		if(e.getSource()==b2)
		{
			TicTacToe.who=2;
			this.setVisible(false);
			tt.b[4].setIcon(tt.i1); tt.B[4]=1; tt.b[4]=null; tt.C[4]=1;
		}
	}
}