package mainJF;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

//import connection.DatabaseConnection;
import Dao.DatabaseConnection;
/**
 * 
 * @author 22476
 *
 */
public class DateOperate {//�������������
	//��������
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    //�������ѧ��
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder zh=new StringBuilder("2019401");//�˺�ǰ7λ��ͬ
    	StringBuilder zh1=new StringBuilder(String.valueOf(getNum(1,999)));//���ȡ��3λ
    	if(zh1.length()==1) {
    		zh1=zh1.insert(0, "00");//�����1λ����ǰ������2��0
    		zh=zh.append(zh1);//ǰ6λ���3λƴ�ӳ�ѧ��
    	}else if(zh1.length()==2) {
    		zh1=zh1.insert(0, "0");//�����2λ����ǰ������1��0
    		zh=zh.append(zh1);
    	}else {
    		zh=zh.append(zh1);
    	}
    	return zh;
    }
    //��������������� 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    public static void main(String[] args) throws IOException {
    	File f1=new File("f:/eclipse/kehu.txt");
    	addYE();
    }
    public static void addYE() throws IOException {//�������
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	String sql="insert into scj(zh,xm,ye) values(?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
	    		File f1=new File("f:/eclipse/kehu.txt");
	    	//	addFile(f1,"�˺�","����","���");//�Ƚ��ı���һ���б���
    		for(int i=1;i<=20;) {
    			String zh=getStuno().toString();//�����ȡ�˺�
    			if(!alist.contains(zh)) {//�ж��ʺ��Ƿ�Ψһ
    				alist.add(zh);//���ʺż��뼯��
    				String xm=getChineseName();//�����ȡ����
    				int ye=getNum(100, 100000);//�����ȡ���
    				pstmt.setString(1, zh);//�����1��ռλ��������
    	    		pstmt.setString(2, xm);//�����2��ռλ��������
    	    		pstmt.setInt(3, ye);//�����3��ռλ��������
    	    		addFile(f1,zh,xm,ye);//ʹ�÷���ѭ�������ı��ĵ�
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//ѧ��Ψһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "�ɹ�����");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getInt(1));//��ȡ��һ���ֶ��˺�
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
    			row.add(rs.getInt(3));//��ȡ�������ֶ����
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��
    }
    public static void addFile(File f1,String zh,String xm,int ye) throws IOException {//��������ɵ����ݼ����ı��ĵ�
    	 f1=new File("f:/eclipse/kehu.txt");
    	 FileWriter fw=new FileWriter(f1,true);
    	 fw.write(zh+"\t");
    	 fw.write(xm+"\t");
		 fw.write(ye+"\r");
		 fw.flush();
    }
}
//    public static void addFile(File f1,String zh,String xm,String ye) throws IOException {//��������ɵ����ݼ����ı��ĵ�
//   	 f1=new File("f:/eclipse/kehu.txt");
//   	 FileWriter fw=new FileWriter(f1,true);
//   	 fw.write(zh+"\t");
//   	 fw.write(xm+"\t");
//   	 fw.write(ye+"\r");
//	 fw.flush();
//   }
//}
