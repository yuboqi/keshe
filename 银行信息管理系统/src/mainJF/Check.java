package mainJF;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Check {//判断方法是否输入框合法
	public boolean checkInputMm(JPasswordField txtMm,JLabel lblMm) {
		  if(txtMm.getText().length()==0) {//获取密码输入框的内容长度
		    lblMm.setText("密码不能为空");//设置警告信息
		    txtMm.requestFocus();//密码输入框获取焦点
		    return false;
		  } lblMm.setText("");
		  return true;}
	
	
	public boolean checkInputZh(JTextField txtzh,JLabel lblzh) {
		  if(txtzh.getText().length()==0) {//获取账号输入框的内容长度
			  lblzh.setText("账号不能为空");//设置警告信息
		    txtzh.requestFocus();//账号输入框获取焦点
		    return false;
		  } lblzh.setText("");
		  return true;}
	

	public boolean checkInputxm(JTextField txtph,JLabel  lblph) {
		  if(txtph.getText().length()==0) {//获取姓名输入框的内容长度
		    lblph.setText("姓名不能为空");//设置警告信息
		    txtph.requestFocus();//姓名输入框获取焦点
		    return false;
		  
		  } lblph.setText("");
		  return true;}
	public boolean checkInputzcm(JTextField txtzcm,JLabel lblzcm) {//判断注册码
		String s="1";
		if(txtzcm.getText().length()==0) {
			lblzcm.setText("请输入注册码");
			txtzcm.requestFocus();//注册码输入框获取焦点
			return false;
		}else if(txtzcm.getText()!=s) {
			lblzcm.setText("注册码错误");
			txtzcm.requestFocus();//注册码输入框获取焦点r
			txtzcm.selectAll();//全选当中的内容
			return false;
		}lblzcm.setText("");
		return true;
	}
	
	public boolean checkInputCk(JTextField txtck,JLabel lblck) {
		  if(txtck.getText().length()==0) {//获取存款输入框的内容长度
		    lblck.setText("存款不能为空");//设置警告信息
		    txtck.requestFocus();//存款输入框获取焦点
		    return false;
		  }else if(!txtck.getText().matches("\\d+")) {//正则匹配整数
		    lblck.setText("存款必须是整数");
		    txtck.requestFocus();//存款输入框获取焦点
		    txtck.selectAll();//全选当中的内容
		    return false;
		  } lblck.setText("");
		  return true;}

}
 

