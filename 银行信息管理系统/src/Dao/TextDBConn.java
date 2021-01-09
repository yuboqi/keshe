package Dao;
public class TextDBConn {//数据库连接测试
	  public static void main(String[] args) {
	    DatabaseConnection dbconn=new DatabaseConnection();
	      if(dbconn.getConnection()!=null) {
	        System.out.println("数据库连接成功");
	        dbconn.close();
	    }
	  }
	}
