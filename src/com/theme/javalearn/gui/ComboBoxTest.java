package com.theme.javalearn.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * 该类是用来测试JComboBox的类
 * @author:lqs
 * date	  :2017年3月20日
 */
public class ComboBoxTest {
	static MyComboBoxModel<String> myComboBoxModel ;
	private static String[] contoris=new String[]{"中国","俄罗斯","美国","毛里求斯","日本","韩国"};
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("ComboBox测试");
		 myComboBoxModel = new ComboBoxTest().new MyComboBoxModel<String>();
		JComboBox<String> jComboBox = new JComboBox<>(myComboBoxModel);
		jComboBox.setLocation(174, 13);
		jComboBox.setSize(195, 44);
		jComboBox.setEditable(true);
		jComboBox.configureEditor(jComboBox.getEditor(), "请选择国家");
		jFrame.getContentPane().setLayout(null);
		jFrame.getContentPane().add(jComboBox);
		jFrame.setSize(500, 500);
		jFrame.setVisible(true);
	}
	
	
	public class MyComboBoxModel<String> extends DefaultComboBoxModel<String>{
		private static final long serialVersionUID = 1L;
		public MyComboBoxModel(){
			
			for (java.lang.String country : Arrays.asList(contoris)) {
				addElement((String) country);
			}
		}
		@Override
		public void setSelectedItem(Object anObject) {
			System.out.println("setSelectedItem------->" +anObject.toString());
			super.setSelectedItem(anObject);
			
		}
		@Override
		public Object getSelectedItem() {
			System.out.println("getSelectedItem------->" +super.getSelectedItem().toString());
			return super.getSelectedItem();
		}
		@Override
		public int getSize() {
			System.out.println("getSize------->" +super.getSize());
			return super.getSize();
		}
		@Override
		public String getElementAt(int index) {
			System.out.println("getElementAt------->" +index);
			return super.getElementAt(index);
		}
		@Override
		public int getIndexOf(Object anObject) {
			System.out.println("getIndexOf------->" +super.getIndexOf(anObject));
			return super.getIndexOf(anObject);
		}
		@Override
		public void addElement(String anObject) {
			System.out.println("addElement------->" +anObject.toString());
			super.addElement(anObject);
		}
		@Override
		public void insertElementAt(String anObject, int index) {
			System.out.println("insertElementAt------->" +anObject.toString()+ "index:"+ index);
			super.insertElementAt(anObject, index);
		}
		@Override
		public void removeElementAt(int index) {
			// TODO Auto-generated method stub
			super.removeElementAt(index);
		}
		@Override
		public void removeElement(Object anObject) {
			// TODO Auto-generated method stub
			super.removeElement(anObject);
		}
		@Override
		public void removeAllElements() {
			// TODO Auto-generated method stub
			super.removeAllElements();
		}
		
		
	}
}
