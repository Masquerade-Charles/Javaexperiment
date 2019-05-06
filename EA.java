package test;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class EA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		new Eventdeal();
	}

}
class Eventdeal{
	private JFrame MyFrame=new JFrame();
	private JTextField it=new JTextField();
	private JButton b1;
	private JButton b2;
	private JButton b3;
	public Eventdeal() {
		init();
		Event listener=new Event();
		listener.set(MyFrame,it);
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
	}
	public void init() {
		MyFrame.setSize(600,400);
		MyFrame.setLayout(null);   
		//this.getContentPane().setBackground(Color.BLUE);
		MyFrame.setResizable(false);
		MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		it.setLocation(200,100);
		it.setSize(200,50);
		MyFrame.add(it);
		JLabel l=new JLabel("������Ҫ�²����:");
		Font f=new Font("����",Font.PLAIN,18);
		l.setFont(f);
		l.setBounds(20,75,200,100);
		MyFrame.add(l);
		b1=new JButton("ȷ��");
		b1.setFont(f);
		b1.setBounds(50,200,130,50);
		MyFrame.add(b1);
		b2=new JButton("���¿�ʼ");
		b2.setFont(f);
		b2.setBounds(220,200,130,50);
		MyFrame.add(b2);
		b3=new JButton("�˳�");
		b3.setFont(f);
		b3.setBounds(390,200,130,50);
		MyFrame.add(b3);
		MyFrame.setVisible(true);
	}
}
class Event implements ActionListener{
	private JFrame it;
	private JTextField t;
	private int ans;
	private Random rand=new Random();
	private int sum=0;
	private JLabel l=new JLabel();
	private JLabel j=new JLabel();
	public void set(JFrame MyFrame,JTextField x) {
		t=x;
		it=MyFrame;
		ans=rand.nextInt(100);
		Font f=new Font("����",Font.PLAIN,18);
		l.setFont(f);
		l.setBounds(0,20,200,100);
		j.setFont(f);
		j.setBounds(450,75,200,100);
		it.add(l);
		it.add(j);
	}
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		if(action.equals("ȷ��")) {
			String x=t.getText();
			int number=Integer.parseInt(x);
			if(number==ans) {
				it.remove(j);
				t.setEditable(false);
				l.setText("��ϲ��¶���!");
				it.getContentPane().setBackground(Color.white);
				it.setVisible(true);
			}
			else if(number<ans) {
				sum++;
				String str="���Ѿ�����"+sum+""+"��";
				//System.out.println(str);
				l.setText(str);
				j.setText("̫С");
				it.getContentPane().setBackground(Color.BLUE);
				it.setVisible(true);
			}
			else {
				sum++;
				String str="���Ѿ�����"+sum+""+"��";
				//System.out.println(str);
				l.setText(str);
				//System.out.println(l.getText());
				j.setText("̫��");
				it.getContentPane().setBackground(Color.RED);
				it.setVisible(true);
			}
		}
		else if(action.equals("���¿�ʼ")) {
			l.setText("");
			j.setText("");
			Font f=new Font("����",Font.PLAIN,18);
			l.setFont(f);
			l.setBounds(0,20,200,100);
			j.setFont(f);
			j.setBounds(450,75,200,100);
			it.getContentPane().setBackground(Color.white);
			t.setEditable(true);
			t.setText("");
			sum=0;
			ans=rand.nextInt(100);
			it.setVisible(true);
		}
		else {
			System.exit(0);
		}
	}
}