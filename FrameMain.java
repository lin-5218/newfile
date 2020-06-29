package caozuo1;

import javax.swing.*;

import java.awt.event.*;
import java.util.concurrent.Semaphore;

public class FrameMain extends JFrame implements ActionListener {
	static private JTextArea jta1 = new JTextArea("");
	static private JTextArea jta2 = new JTextArea("");
	static private JTextArea jta3 = new JTextArea("");
	static public JTextArea jta4 = new JTextArea("");
	static public JTextArea jta5 = new JTextArea("");
	static public JTextArea jta6 = new JTextArea("");
	static public JTextArea jta7 = new JTextArea("");
	static private JRadioButton jrb1 = new JRadioButton("semaphore");
	static private JRadioButton jrb2 = new JRadioButton("waitnotify(默任由第三个线程执行唤醒其他线程)");

	public FrameMain() {
		super("并发控制实例");
		this.setBounds(50, 50, 700, 300);
		this.setLayout(null);
		this.setVisible(true);
		jta1.setBounds(20, 20, 100, 25);
		jta1.setEditable(true);
		add(jta1);

		jta2.setBounds(200, 20, 100, 25);
		jta2.setEditable(true);
		add(jta2);

		jta3.setBounds(380, 20, 100, 25);
		jta3.setEditable(true);
		add(jta3);

		jta4.setBounds(20, 100, 100, 25);
		jta4.setEditable(false);
		add(jta4);

		jta5.setBounds(200, 100, 100, 25);
		jta5.setEditable(false);
		add(jta5);

		jta6.setBounds(380, 100, 100, 25);
		jta6.setEditable(false);
		add(jta6);

		jta7.setBounds(20, 180, 300, 25);
		jta7.setEditable(false);
		add(jta7);

		ButtonGroup grp = new ButtonGroup();
		grp.add(jrb1);
		grp.add(jrb2);
		jrb1.setBounds(400, 160, 100, 25);
		jrb2.setBounds(400, 200, 3250, 25);
		add(jrb1);
		add(jrb2);

		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String str1 = new String();
		String str2 = new String();
		String str3 = new String();
		str1 = jta1.getText();
		str2 = jta2.getText();
		str3 = jta3.getText();
		if (jrb1.isSelected()) {
			if (str1.length() == 0 || str2.length() == 0 || str3.length() == 0) {
				JOptionPane.showMessageDialog(jrb1, "请先输入，再点击按钮");
			} else {
				jta4.setText(null);
				jta5.setText(null);
				jta6.setText(null);

				jta4.setEditable(true);

				jta5.setEditable(true);
				jta6.setEditable(true);
				Semaphore sem1 = new Semaphore(1);
				Semaphore sem2 = new Semaphore(1);
				Semaphore sem3 = new Semaphore(1);

				FirstRunThread f1 = new FirstRunThread(sem1, sem2, sem3, str1);

				SecondRunThread s2 = new SecondRunThread(sem1, sem2, sem3, str2);

				ThirdRunThread t3 = new ThirdRunThread(sem1, sem2, sem3, str3);
				f1.start();
				s2.start();
				t3.start();

				String str4 = new String();
				StringBuffer sb = new StringBuffer();
				sb.append(str1);
				sb.append(str2);
				sb.append(str3);
				str4 = sb.toString();
				jta7.setText(str4);
			}
		}

		if (jrb2.isSelected()) {
			if (str1.length() == 0 || str2.length() == 0 || str3.length() == 0) {
				JOptionPane.showMessageDialog(jrb2, "请先输入，再点击按钮");
			} else {
				jta4.setText(null);
				jta5.setText(null);
				jta6.setText(null);

				jta4.setEditable(true);

				jta5.setEditable(true);
				jta6.setEditable(true);
				Object common = new Object();

				new FirstWaitThread(str1, common).start();

				new SecondWaitThread(str2, common).start();

				new ThirdNotifyThread(str3, common).start();
				String str4 = new String();
				StringBuffer sb = new StringBuffer();
				sb.append(str1);
				sb.append(str2);
				sb.append(str3);
				str4 = sb.toString();
				jta7.setText(str4);

			}
		}

	}

	public static void main(String[] args) {
		FrameMain f = new FrameMain();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
