package Dao;
public class TextDBConn {//���ݿ����Ӳ���
	  public static void main(String[] args) {
	    DatabaseConnection dbconn=new DatabaseConnection();
	      if(dbconn.getConnection()!=null) {
	        System.out.println("���ݿ����ӳɹ�");
	        dbconn.close();
	    }
	  }
	}
