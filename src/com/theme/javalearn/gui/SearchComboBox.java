package com.theme.javalearn.gui;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JSpinner;

/**
 *  自定义的搜索功能的ComboBox,组合控件
 *	@author:qingshanliao
 *  @date  :2017年3月22日
 */
public class SearchComboBox extends JFrame{
	private JComboBox mComboBox;
	private JTextField textField;
	public SearchComboBox(String titleBorder){
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(236, 10, 112, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(94, 104, 133, 80);
		getContentPane().add(list);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(300, 72, 90, 115);
		getContentPane().add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(236, 10, 129, 21);
		getContentPane().add(comboBox);
	}
	public static void main(String[] args) {
		SearchComboBox searchComboBox = new SearchComboBox("搜索框");
		searchComboBox.setSize(500, 500);
		searchComboBox.setLocation(500, 200);
		searchComboBox.setVisible(true);
	}
}
