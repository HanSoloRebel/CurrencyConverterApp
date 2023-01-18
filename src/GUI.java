import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
    private static float amountInput;
    private static String selectedCurrency;
    private static JButton button;
    private static JTextField amountField;
    private static JTextField resultField;
    private static JTextArea historyField;
    private static JPanel jPanel;
    private static String history = new String();
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

        amountField = new JTextField(8);
//        amountField.setPreferredSize(new Dimension(250,40));
//        amountField.setFont(new Font("Arial", Font.PLAIN, 14));
        amountField.setForeground(Color.white);
        amountField.setBackground(Color.black);
        amountField.setCaretColor(Color.white);
        amountField.setBounds(10,50,80,25);
        amountField.setText("value");
        amountField.setHorizontalAlignment(JTextField.TRAILING);
        jPanel.add(amountField);

        historyField = new JTextArea();
        historyField.setBackground(Color.gray);
        historyField.setBounds(10,130,190,190);
        jPanel.add(historyField);

        resultField = new JTextField(8);
//        resultField.setPreferredSize(new Dimension(250,40));
//        resultField.setFont(new Font("Arial", Font.PLAIN, 14));
        resultField.setForeground(Color.white);
        resultField.setBackground(Color.black);
        resultField.setCaretColor(Color.white);
        resultField.setBounds(200,50,80,25);
        resultField.setText("0");
        resultField.setHorizontalAlignment(JTextField.TRAILING);
        jPanel.add(resultField);

        button = new JButton("convert");
        button.setBounds(10,90,80,25);
        button.addActionListener(this);
        jPanel.add(button);

        jComboBox1 = new JComboBox();
        jComboBox1.addItem("RUB");
        jComboBox2 = new JComboBox();
        for (String i : ExchangeRate.getCurrenciesList()){
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
    public static String getSelectedCurrencies(){
        return selectedCurrency;
    }

    public static void setExchangeResult(float res) {
        resultField.setText(String.valueOf(res));
        if (history.isEmpty()){
            history = amountInput + " RUB = " + String.valueOf(res) + " " + selectedCurrency + "\n";
        } else {
            history = history + amountInput + " RUB = " + String.valueOf(res) + " " + selectedCurrency + "\n";
        }
        historyField.setText(history);
        jPanel.revalidate();
    }

    public static String getDate(){
        SimpleDateFormat europeanFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = new Date();
        String europeanDate = europeanFormat.format(currentDate);
        return europeanDate;
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==button){
            amountInput = Float.valueOf(amountField.getText());
            selectedCurrency = jComboBox2.getSelectedItem().toString();
            CurrencyConverter exchange = new CurrencyConverter();
            exchange.setExchangeRate(Float.valueOf(ExchangeRate.getRate()[1]));
            exchange.setAmount(amountInput);
            exchange.setExchangeCurrencies(selectedCurrency);
            exchange.setBase(Float.valueOf(ExchangeRate.getRate()[0]));
            setExchangeResult(exchange.getExchange());
        }
    }
}
