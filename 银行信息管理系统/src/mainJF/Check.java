package mainJF;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Check {//�жϷ����Ƿ������Ϸ�
	public boolean checkInputMm(JPasswordField txtMm,JLabel lblMm) {
		  if(txtMm.getText().length()==0) {//��ȡ�������������ݳ���
		    lblMm.setText("���벻��Ϊ��");//���þ�����Ϣ
		    txtMm.requestFocus();//����������ȡ����
		    return false;
		  } lblMm.setText("");
		  return true;}
	
	
	public boolean checkInputZh(JTextField txtzh,JLabel lblzh) {
		  if(txtzh.getText().length()==0) {//��ȡ�˺����������ݳ���
			  lblzh.setText("�˺Ų���Ϊ��");//���þ�����Ϣ
		    txtzh.requestFocus();//�˺�������ȡ����
		    return false;
		  } lblzh.setText("");
		  return true;}
	

	public boolean checkInputxm(JTextField txtph,JLabel  lblph) {
		  if(txtph.getText().length()==0) {//��ȡ�������������ݳ���
		    lblph.setText("��������Ϊ��");//���þ�����Ϣ
		    txtph.requestFocus();//����������ȡ����
		    return false;
		  
		  } lblph.setText("");
		  return true;}
	public boolean checkInputzcm(JTextField txtzcm,JLabel lblzcm) {//�ж�ע����
		String s="1";
		if(txtzcm.getText().length()==0) {
			lblzcm.setText("������ע����");
			txtzcm.requestFocus();//ע����������ȡ����
			return false;
		}else if(txtzcm.getText()!=s) {
			lblzcm.setText("ע�������");
			txtzcm.requestFocus();//ע����������ȡ����r
			txtzcm.selectAll();//ȫѡ���е�����
			return false;
		}lblzcm.setText("");
		return true;
	}
	
	public boolean checkInputCk(JTextField txtck,JLabel lblck) {
		  if(txtck.getText().length()==0) {//��ȡ������������ݳ���
		    lblck.setText("����Ϊ��");//���þ�����Ϣ
		    txtck.requestFocus();//���������ȡ����
		    return false;
		  }else if(!txtck.getText().matches("\\d+")) {//����ƥ������
		    lblck.setText("������������");
		    txtck.requestFocus();//���������ȡ����
		    txtck.selectAll();//ȫѡ���е�����
		    return false;
		  } lblck.setText("");
		  return true;}

}
 

