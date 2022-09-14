package ReverseBigInteger;

import javax.swing.*;

public class GUI extends JFrame {
    public static void main(String[] args) {
        GUI test = new GUI();
    }

    public GUI(){
        JFrame frame = new JFrame("数字反转示例");
        JPanel panel = new JPanel();
        JTextField textField = new JTextField();
        textField.setText("请输入整数或者小数！");
        textField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField);
        frame.add(panel);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
