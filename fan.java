package test;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class fan {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}
}
class MyFrame extends JFrame{
	private Fans fans[]=new Fans[3];
	private JPanel jp[]=new JPanel[3];
	private JButton jstart[]=new JButton[3];
	private JButton jstop[]=new JButton[3];
	private JButton jrestart[]=new JButton[3];
	private JButton jsta=new JButton();
	private JButton jsto=new JButton();
	private Thread thread[]=new Thread[3];
	public MyFrame() {
		this.setSize(1000,500);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=0;i<3;i++) {
			fans[i]=new Fans();
			jp[i]=new JPanel();
			jp[i].setLayout(new FlowLayout());
			jp[i].setPreferredSize(new Dimension(300,300));
			jstart[i]=new JButton("开始");
			jstop[i]=new JButton("停止");
			jrestart[i]=new JButton("重新旋转");
			jp[i].add(jstart[i]);
			jp[i].add(jstop[i]);
			jp[i].add(jrestart[i]);
			jp[i].add(fans[i]);
			thread[i]=new Thread(fans[i]);
			thread[i].start();
			jp[i].setVisible(true);
		}
		JPanel newjp=new JPanel();
		newjp.setLayout(new FlowLayout());
		//newjp.setPreferredSize(new Dimension(100,100));
		jsta=new JButton("全部开始");
		jsto=new JButton("全部停止");
		newjp.add(jsta);
		newjp.add(jsto);
		jsta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<3;i++) {
					fans[i].restart();
				}
			}
		});
		jsto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<3;i++) {
					fans[i].stopfan();
				}
			}
		});
		newjp.setVisible(true);
		for(int i=0;i<3;i++) {
			this.add(jp[i]);
		}
		this.add(newjp);
		this.setVisible(true);
		for(int i=0;i<3;i++) {
			jstart[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int j=0;j<3;j++) {
						if(jstart[j]==e.getSource()) {
							fans[j].restart();
						}
					}
				}
			});
			jstop[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int j=0;j<3;j++) {
						if(jstop[j]==e.getSource()) {
							fans[j].stopfan();
						}
					}
				}
			});
			jrestart[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int j=0;j<3;j++) {
						if(jrestart[j]==e.getSource()) {
							fans[j].restart();
						}
					}
				}
			});
		}
	}
}
class Fans extends JPanel implements Runnable{
	private int trc;//角度
	private boolean ifstop=true;//开始还是停止
	public Fans() {
		this.setPreferredSize(new Dimension(250,250));
		this.setLayout(new BorderLayout());
		trc=0;
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.drawOval(0,0,190,190);
		g.setColor(Color.red);
		for(int i=0;i<360;i+=90) {
			g.fillArc(5,5,180,180,i+this.trc,30);
		}
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
				synchronized(this) {
					while(ifstop==true) {
						wait();
					}
				}
			}catch(InterruptedException e) {
					e.printStackTrace();
			}
			this.trc+=15;
			repaint();
		}
	}
	public synchronized void stopfan() {
		this.ifstop=true;
	}
	public synchronized void restart() {
		if(this.ifstop==true) {
			this.ifstop=false;
			notify();
		}
	}
}