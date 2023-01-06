import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
    private static float amountInput;
    private static String[] selectedCurrencies = new String[2];
    private static JButton button;
    private static JTextField textField1;
    private static JTextField textField2;
    private static JPanel jPanel;
    private static JComboBox<String> jComboBox1;
    private static JComboBox<String> jComboBox2;
    GUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit newToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSizeDimension = newToolkit.getScreenSize();
        this.setBounds(screenSizeDimension.width/2 - 350, screenSizeDimension.height/2 - 200, 700, 400);
        this.setTitle("Currency Converter App");

        jPanel = new JPanel();
        this.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setBackground(Color.gray);

        textField1 = new JTextField(8);
//        textField.setPreferredSize(new Dimension(250,40));
//        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField1.setForeground(Color.white);
        textField1.setBackground(Color.black);
        textField1.setCaretColor(Color.white);
        textField1.setBounds(10,50,80,25);
        textField1.setText("value");
        textField1.setHorizontalAlignment(JTextField.TRAILING);
        jPanel.add(textField1);

        textField2 = new JTextField(8);
//        textField.setPreferredSize(new Dimension(250,40));
//        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField2.setForeground(Color.white);
        textField2.setBackground(Color.black);
        textField2.setCaretColor(Color.white);
        textField2.setBounds(200,50,80,25);
        textField2.setText("0");
        textField2.setHorizontalAlignment(JTextField.TRAILING);
        jPanel.add(textField2);

        button = new JButton("convert");
        button.setBounds(10,90,80,25);
        button.addActionListener(this);
        jPanel.add(button);

        jComboBox1 = new JComboBox();
        jComboBox2 = new JComboBox();
        for (String i : CurrencyConverter.getCurrencyDictionary()){
            jComboBox1.addItem(i);
            jComboBox2.addItem(i);
        }
        jComboBox1.setBounds(100,50, 50,25);
        jComboBox2.setBounds(290,50, 50,25);
        jPanel.add(jComboBox1);
        jPanel.add(jComboBox2);

//        this.pack();
        this.setVisible(true);
    }

    public static float getAmountInput(){
        return amountInput;
    }
    public static String[] getSelectedCurrencies(){
        return selectedCurrencies;
    }

    public static void setExchangeResult(float res) {
        textField2.setText(String.valueOf(res));
        jPanel.revalidate();
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==button){
            amountInput = Float.valueOf(textField1.getText());
            selectedCurrencies[0] = jComboBox1.getSelectedItem().toString();
            selectedCurrencies[1] = jComboBox2.getSelectedItem().toString();
            CurrencyConverter exchange = new CurrencyConverter();
            exchange.setExchangeRate(ExchangeRate.getRate());
            exchange.setAmount(amountInput);
            exchange.setExchangeCurrencies(selectedCurrencies);
            setExchangeResult(exchange.getExchange());

        }
    }
}
