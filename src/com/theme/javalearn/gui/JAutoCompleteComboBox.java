package com.theme.javalearn.gui;
/**
 * @author:lqs
 * date	  :2017年3月21日
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;  
import java.awt.event.KeyEvent;  
import java.awt.event.KeyListener;  
import java.util.Arrays;  
import java.util.List;  
import java.util.Vector;  
  








import javax.swing.ComboBoxModel;  
import javax.swing.DefaultComboBoxModel;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
import javax.swing.JTextField;  
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
  
/** 
 * @author SamZheng 带有自动检查功能的CombBox 
 */  
  
@SuppressWarnings("unchecked")  
public class JAutoCompleteComboBox extends JComboBox {  
  
    private static final long serialVersionUID = 1L;  
    private AutoCompleter completer;  
  
    public JAutoCompleteComboBox() {  
        super();  
        addCompleter();  
    }  
  
    public JAutoCompleteComboBox(ComboBoxModel cm) {  
        super(cm);  
        addCompleter();  
    }  
  
    public JAutoCompleteComboBox(Object[] items) {  
        super(items);  
        addCompleter();  
    }  
  
    public JAutoCompleteComboBox(List v) {  
        super((Vector) v);  
        addCompleter();  
    }  
  
    private void addCompleter() {  
        setEditable(true);  
        setSelectedIndex(-1);
        completer = new AutoCompleter(this);  
    }  
  
    public void autoComplete(String str) {  
        this.completer.autoComplete(str, str.length());  
    }  
  
    public String getText() {  
        return ((JTextField) getEditor().getEditorComponent()).getText();  
    }  
  
    public void setText(String text) {  
        ((JTextField) getEditor().getEditorComponent()).setText(text);  
    }  
  
    public boolean containsItem(String itemString) {  
        for (int i = 0; i < this.getModel().getSize(); i++) {  
            String _item = "" + this.getModel().getElementAt(i);  
            if (_item.equals(itemString)) {  
                return true;  
            }  
        }  
        return false;  
    }  
  
    /* 
     * 测试方法 
     */  
    public static void main(String[] args) {  
        JFrame frame = new JFrame();  
        Object[] items = new Object[] { "zzz", "zba", "aab", "abc", "aab",  
                "dfg", "aba", "hpp", "pp", "hlp","aaaa","abaaa","abcd","abcde" };  
        // 排序内容  
        // java.util.ArrayList list = new  
        // java.util.ArrayList(Arrays.asList(items));  
        // Collections.sort(list);  
        // JComboBox cmb = new JAutoCompleteComboBox(list.toArray());  
        Arrays.sort(items);  
        JComboBox cmb = new JAutoCompleteComboBox(items);  
        cmb.setSelectedIndex(-1);  
        frame.getContentPane().add(cmb);  
        frame.setSize(400, 80);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
}  
  
/** 
 * 自动完成器。自动找到最匹配的项目，并排在列表的最前面。 
 *  
 * @author SamZheng 
 */  
  
@SuppressWarnings("unchecked")  
class AutoCompleter implements KeyListener, ItemListener {  
  
    private JComboBox owner = null;  
    private JTextField editor = null;  
  
    private ComboBoxModel model = null;  
  
    public AutoCompleter(JComboBox comboBox) {  
        owner = comboBox;  
        editor = (JTextField) comboBox.getEditor().getEditorComponent();  
//        editor.addKeyListener(this);  
        editor.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				int length = e.getDocument().getLength();
				// TODO Auto-generated method stub
				System.out.println("removeUpdate:");
				System.out.println("length:"+length);
				int caretPosition = editor.getCaretPosition();
					String text;
					//						text = e.getDocument().getText(0, length).trim();
											text = editor.getText();
											System.out.println("text:"+text);
											autoComplete(text, caretPosition);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("insertUpdate:");
				int length = e.getDocument().getLength();
				System.out.println("length:"+length);
				int caretPosition = editor.getCaretPosition();
					String text;
					//						text = e.getDocument().getText(0, length).trim();
											text = editor.getText();
											System.out.println("text:"+text);
											autoComplete(text, caretPosition);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				System.out.println("changedUpdate:");
			}
		});
        model = comboBox.getModel();  
        owner.addItemListener(this);  
    }  
  
    public void keyTyped(KeyEvent e) {  
    }  
  
    public void keyPressed(KeyEvent e) {  
    }  
  
    public void keyReleased(KeyEvent e) {  
        char ch = e.getKeyChar();  
//        || ch == KeyEvent.VK_DELETE  || Character.isISOControl(ch)
        if (ch == KeyEvent.CHAR_UNDEFINED) {  
            return;  
        }  
  
        int caretPosition = editor.getCaretPosition();  
        System.out.println("caretPosition:"+caretPosition);
        String str = editor.getText();  
        if (str.length() == 0) {  
            return;  
        }  
        autoComplete(str, caretPosition);  
    }  
  
    /** 
     * 自动完成。根据输入的内容，在列表中找到相似的项目. 
     */  
    protected void autoComplete(String strf, int caretPosition) {  
        Object[] opts;  
        opts = getMatchingOptions(strf.substring(0, caretPosition));  
        if (owner != null) {  
            model = new DefaultComboBoxModel(opts);  
            owner.setModel(model);  
        }  
        owner.setSelectedIndex(-1);
//        owner.showPopup();  
        return;
       /* if (opts.length > 0) {  
            // String str = opts[0].toString();  
            if (caretPosition > editor.getText().length())  
                return;  
            editor.setCaretPosition(caretPosition);  
//            editor.setText(editor.getText().trim().substring(0, caretPosition));  
            if (owner != null) {  
                try {  
                    owner.showPopup();  
                    owner.setSelectedIndex(-1);
//                    String eidtText = editor.getText().trim().substring(0, caretPosition);
//                    editor.setText(strf); 
//                    System.out.println("eidtText:---->"+eidtText);
                    System.out.println("strf:---->"+strf);
                } catch (Exception ex) {  
                	
                    ex.printStackTrace();  
                }  
            }  
        }  */
    }  
  
    /** 
     *  
     * 找到相似的项目, 并且将之排列到数组的最前面。 
     *  
     * @param str 
     * @return 返回所有项目的列表。 
     */  
    protected Object[] getMatchingOptions(String str) {  
        List v = new Vector();  
        List v1 = new Vector();  
  
        for (int k = 0; k < model.getSize(); k++) {  
            Object itemObj = model.getElementAt(k);  
            if (itemObj != null) {  
                String item = itemObj.toString().toLowerCase();  
                if (item.startsWith(str.toLowerCase())) {  
                    v.add(model.getElementAt(k));  
                } else {  
                    v1.add(model.getElementAt(k));  
                }  
            } else {  
                v1.add(model.getElementAt(k));  
            }  
        }  
        for (int i = 0; i < v1.size(); i++) {  
            v.add(v1.get(i));  
        }  
        if (v.isEmpty()) {  
            v.add(str);  
        }  
        return v.toArray();  
    }  
  
    public void itemStateChanged(ItemEvent event) {  
        if (event.getStateChange() == ItemEvent.SELECTED) {  
            int caretPosition = editor.getCaretPosition();  
            if (caretPosition != -1) {  
                try {  
                    editor.moveCaretPosition(caretPosition);  
                } catch (IllegalArgumentException ex) {  
                    ex.printStackTrace();  
                }  
            }  
        }  
    }  
}  