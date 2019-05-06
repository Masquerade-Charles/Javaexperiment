package test;
import java.util.*;
import java.io.*;
public class FRW {
	static int maxn=1000005;
	static Scanner in=new Scanner(System.in);
	static int Browerbook(String brower[][],int len1,String path) {
		String str1,str2,str3;
		str1=new String();
		str2=new String();
		str3=new String();
		System.out.println("�������鼮����:");
		str1=in.next();
		System.out.println("�������鼮��:");
		str2=in.next();
		System.out.println("���������ѧ������:");
		str3=in.next();
		Book b=new Book(str1,str2,str3);
		brower[len1][0]=b.getbookname();
		brower[len1][1]=b.getbookid();
		brower[len1][2]=b.getsname();
		brower[len1][3]="��";
		len1++;
		String sep=new String("    ");
		try {
			File file=new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(path);
			for(int i=0;i<len1;i++) {
				for(int j=0;j<4;j++) {
					if(j==3) {
						fw.write(brower[i][j]);
						fw.write("\r\n");
					}
					else fw.write(brower[i][j]+sep);
				}
			}
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return len1;
	}
	static int Takebook(String brower[][],int len1,String take[][],int len2,String path1,String path2) {
		String str1,str2,str3;
		str1=new String();
		str2=new String();
		str3=new String();
		System.out.println("�����뻹��ѧ������:");
		str1=in.next();
		System.out.println("�����뻹��ѧ��ѧ��:");
		str2=in.next();
		System.out.println("����������:");
		str3=in.next();
		Student s=new Student(str1,str2,str3);
		take[len2][0]=str1;
		take[len2][1]=str2;
		take[len2][2]=str3;
		len2++;
		String sep=new String("    ");
		try {
			File file=new File(path2);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(path2);
			for(int i=0;i<len2;i++) {
				for(int j=0;j<3;j++) {
					if(j==2) {
						fw.write(take[i][j]);
						fw.write("\r\n");
					}
					else {
						fw.write(take[i][j]+sep);
					}
				}
			}
			fw.close();
			int pos=0;
			for(int i=0;i<len1;i++) {
				if(brower[i][0].equals(str3)&&brower[i][2].equals(str1))
					pos=i;
			}
			fw=new FileWriter(path1);
			brower[pos][3]="��";
			for(int i=0;i<len1;i++) {
				for(int j=0;j<4;j++) {
					if(j==3) {
						fw.write(brower[i][j]);
						fw.write("\r\n");
					}
					else fw.write(brower[i][j]+sep);
				}
			}
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return len2;
	}
	static void show(String path) {
		try {
			File file=new File(path);
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String str=new String();
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			br.close();
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String brower[][]=new String[maxn][4];
		int len1=1;
		brower[0][0]="����";
		brower[0][1]="���";
		brower[0][2]="����ѧ������";
		brower[0][3]="�Ƿ���";
		String take[][]=new String[maxn][3];
		int len2=1;
		take[0][0]="����ѧ������";
		take[0][1]="ѧ��";
		take[0][2]="����";
		String path1=new String("D:\\java���"+File.separator+"�����.txt");
		String path2=new String("D:\\java���"+File.separator+"�����.txt");
		int op;
		while(true) {
			System.out.println("��ѡ����Ҫ���еĲ���:1.����  2.����  3.��ʾ�����  4.��ʾ�����");
			op=in.nextInt();
			if(op==1) {
				len1=Browerbook(brower,len1,path1);
			}
			else if(op==2) {
				len2=Takebook(brower,len1,take,len2,path1,path2);
			}
			else if(op==3) {
				show(path1);
			}
			else {
				show(path2);
			}
		}
	}

}
class Book{
	private String bookname;
	private String bookid;
	private String sname;
	public Book(String _bookname,String _bookid,String _sname) {
		bookname=_bookname;
		bookid=_bookid;
		sname=_sname;
	}
	public String getbookname() {
		return this.bookname;
	}
	public String getbookid() {
		return this.bookid;
	}
	public String getsname() {
		return this.sname;
	}
}
class Student{
	private String sname;
	private String sid;
	private String bookname;
	public Student(String _sname,String _sid,String _bookname) {
		sname=_sname;
		sid=_sid;
		bookname=_bookname;
	}
	public String getsname() {
		return this.sname;
	}
	public String getsid() {
		return this.sid;
	}
	public String getbookname() {
		return this.bookname;
	}
}