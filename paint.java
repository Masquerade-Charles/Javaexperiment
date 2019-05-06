package test;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class paint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ans();
	}

}
abstract class MyShape{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int x4;
	private int y4;
	public MyShape(){
		x1=0;y1=0;
		x2=0;y2=0;
		x3=0;y3=0;
		x4=0;y4=0;
	}
	public MyShape(int _x1,int _y1,int _x2,int _y2,int _x3,int _y3,int _x4,int _y4) {
		x1=_x1;y1=_y1;
		x2=_x2;y2=_y2;
		x3=_x3;y3=_y3;
		x4=_x4;y4=_y4;
	}
	public void set(int _x1,int _y1,int _x2,int _y2,int _x3,int _y3,int _x4,int _y4) {
		x1=_x1;y1=_y1;
		x2=_x2;y2=_y2;
		x3=_x3;y3=_y3;
		x4=_x4;y4=_y4;
	}
	public int getx1() {
		return x1;
	}
	public int gety1() {
		return y1;
	}
	public int getx2() {
		return x2;
	}
	public int gety2() {
		return y2;
	}
	public int getx3() {
		return x3;
	}
	public int gety3() {
		return y3;
	}
	public int getx4() {
		return x4;
	}
	public int gety4() {
		return y4;
	}
	public abstract void draw(Graphics g);
}
class MyLine extends MyShape{
	public MyLine(int _x1,int _y1,int _x2,int _y2,int _x3,int _y3,int _x4,int _y4,Graphics g) {
		this.set(_x1,_y1,_x2,_y2,_x3,_y3,_x4,_y4);
		draw(g);
	}
	public void draw(Graphics g) {
		int x1=this.getx1();
		int y1=this.gety1();
		int x2=this.getx2();
		int y2=this.gety2();
		g.drawLine(x1,y1,x2,y2);
	}
}
class MyRectangle extends MyShape{
	public MyRectangle(int _x1,int _y1,int _x2,int _y2,int _x3,int _y3,int _x4,int _y4,Graphics g) {
		this.set(_x1,_y1,_x2,_y2,_x3,_y3,_x4,_y4);
		draw(g);
	}
	public void draw(Graphics g) {
		int x1=this.getx1();
		int y1=this.gety1();
		int x2=this.getx2();
		int y2=this.gety2();
		int x3=this.getx3();
		int x4=this.getx4();
		int y3=this.gety3();
		int y4=this.gety4();
		int width=(int)Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		int height=(int)Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
		g.drawRect(x1,y1,width,height);
	}
}
class MyOval extends MyShape{
	public MyOval(int _x1,int _y1,int _x2,int _y2,int _x3,int _y3,int _x4,int _y4,Graphics g) {
		this.set(_x1,_y1,_x2,_y2,_x3,_y3,_x4,_y4);
		draw(g);
	}
	public void draw(Graphics g) {
		int x1=this.getx1();
		int y1=this.gety1();
		int x2=this.getx2();
		int y2=this.gety2();
		int x3=this.getx3();
		int x4=this.getx4();
		int y3=this.gety3();
		int y4=this.gety4();
		int width=(int)Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		int height=(int)Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
		g.drawOval(x1,y1,width,height);
	}
}
class Ans extends JFrame{
	public Ans() {
		super();
		setBounds(0,0,1000,1000);
		setVisible(true);
		setLayout(null);   
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graphics g=this.getGraphics();
		g.setColor(Color.BLACK);
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Random rand=new Random();
		for(int i=0;i<20;i++) {
			int x1,y1,x2,y2,x3,y3,x4,y4;
			int op;
			x1=rand.nextInt(500);
			x2=rand.nextInt(500);
			x3=rand.nextInt(500);
			x4=rand.nextInt(500);
			y1=rand.nextInt(500);
			y2=rand.nextInt(500);
			y3=rand.nextInt(500);
			y4=rand.nextInt(500);
			op=rand.nextInt(3);
			if(op==0) {
				new MyLine(x1,y1,x2,y2,x3,y3,x4,y4,g);
			}
			else if(op==1) {
				new MyRectangle(x1,y1,x2,y2,x3,y3,x4,y4,g);
			}
			else {
				new MyOval(x1,y1,x2,y2,x3,y3,x4,y4,g);
			}
		}
	}
}
