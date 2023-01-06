import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInterface {

    public static String getDate(){
        SimpleDateFormat europeanFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = new Date();
        String europeanDate = europeanFormat.format(currentDate);
        return europeanDate;
    }

    public static JFrame getFrame(){
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit newToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSizeDimension = newToolkit.getScreenSize();
        jFrame.setBounds(screenSizeDimension.width/2 - 350, screenSizeDimension.height/2 - 200, 700, 400);
        jFrame.setTitle("Currency Converter App");
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JTextField textField1 = new JTextField(8);
        JTextField textField2 = new JTextField(8);
        textField1.setHorizontalAlignment(JTextField.RIGHT);
        textField2.setHorizontalAlignment(JTextField.RIGHT);
        textField1.setLocation(100, 200);
        jPanel.add(textField1);
        jPanel.add(textField2);
        JComboBox<String> jComboBox1 = new JComboBox();
        JComboBox<String> jComboBox2 = new JComboBox();
        for (String i : CurrencyConverter.getCurrencyDictionary()){
            jComboBox1.addItem(i);
            jComboBox2.addItem(i);
        }
        jPanel.add(jComboBox1);
        jPanel.add(jComboBox2);
        jPanel.revalidate();

        return jFrame;
    }
}
