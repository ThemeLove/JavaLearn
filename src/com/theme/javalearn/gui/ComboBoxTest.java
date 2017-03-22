package com.theme.javalearn.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.theme.javalearn.base.forechTest;

/**
 * 该类是用来测试JComboBox的类
 * @author:lqs date :2017年3月20日
 */
public class ComboBoxTest {
	private static Vector<String> contoris=new Vector<String>();
	private static JComboBox<String> jComboBox;
	private static ComboBoxEditor editor;
	private static JTextField editText;

	public static void main(String[] args) {
		contoris.add("中");
		contoris.add("中国");
		contoris.add("中国人");
		contoris.add("中国人民");
		contoris.add("中国人民币");
		contoris.add("中国人民币汇");
		contoris.add("中国人民币汇率");
		JFrame jFrame = new JFrame("ComboBox测试");
		DefaultComboBoxModel<String> myComboBoxModel = new DefaultComboBoxModel<String>(contoris);
		jComboBox = new JComboBox<>(myComboBoxModel);
		jComboBox.setLocation(80, 13);
		jComboBox.setSize(289, 44);
		jComboBox.setEditable(true);
		jComboBox.setSelectedIndex(-1);
		editor = jComboBox.getEditor();
		jComboBox.setBorder(BorderFactory.createTitledBorder("请选择国家"));
		editText = (JTextField) editor.getEditorComponent();
		 jComboBox.configureEditor(editor, "");
		jFrame.getContentPane().setLayout(null);
		jFrame.getContentPane().add(jComboBox);
		jFrame.setSize(500, 500);
		jFrame.setVisible(true);
		jComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				int stateChange = e.getStateChange();
				if (stateChange==ItemEvent.SELECTED) {
					java.lang.String item = e.getItem().toString();
					System.out.println("选择的Item:" + item);
				}
			}
		});
		editText.addKeyListener(new KeyAdapter() {

			// 当键盘弹起的时候,监听删除键弹起的时候
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_DELETE|| e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					System.out.println("keyReleased");
					String text = editText.getText().trim();
					editText.setText(text);
					editText.setCaretPosition(text.length());
					
					Vector<String> tempItems =new Vector<>();
					if (text.isEmpty()) {
						System.out.println("keyReleased		editText:"+"empty");
						tempItems = contoris;
					} else {
						System.out.println("keyReleased		editText:"+text);
						tempItems = updateItems(text);
					}
					DefaultComboBoxModel<String> myComboBoxModel2 = new DefaultComboBoxModel<String>(tempItems);
					jComboBox.setModel(myComboBoxModel2);
					
//					jComboBox.setSelectedIndex(-1);
					jComboBox.showPopup();
				}
			}
						public  Vector<String> updateItems(String text) {
							Vector<String> temp = new Vector<String>();
							for (String country : contoris) {
								if (country.contains(text)) {
									temp.add(country);
								}
							}
							return temp;
						};
		});

		editText.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				java.lang.String text = editText.getText();
				System.out.println("removeUpdate：" + text);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				java.lang.String text = editText.getText();
				System.out.println("insertUpdate：" + text);
				
				editText.setText(text);
				editText.setCaretPosition(text.length());
				
				
				Vector<String> tempItems = new Vector<>();
				if (text.isEmpty()) {
					System.out.println("insertUpdate  editText:"+"empty");
					tempItems = contoris;
				} else {
					System.out.println("insertUpdate  editText:"+text);
					tempItems = updateItems(text);
				}
				DefaultComboBoxModel<String> myComboBoxModel2 = new DefaultComboBoxModel<String>(tempItems);
				jComboBox.setModel(myComboBoxModel2);
//				jComboBox.setSelectedIndex(-1);
				jComboBox.showPopup();
			}
			public  Vector<String> updateItems(String text) {
				Vector<String> temp = new Vector<String>();
				for (String country : contoris) {
					if (country.contains(text)) {
						temp.add(country);
					}
				}
				return temp;
			};
			@Override
			public void changedUpdate(DocumentEvent e) {
				java.lang.String text = editText.getText();
				System.out.println("changedUpdate：" + text);
			}
		});
	}


}
