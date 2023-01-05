import java.util.*;
import static java.util.Arrays.asList;

public class CurrencyConverter {
        private static float exchangeRate = -1;
        private static float amount = -1;
        private static String[] exchangeCurrencies;
        private static List<String> currenciesList = new ArrayList<>(asList("RUB", "CNY", "KZT", "BYN","TRY", "USD","UER"));

        public static void setExchangeRate(float rate) {
            if (rate > 0) {
                exchangeRate = rate;
            } else {
                String errorCode = String.format("ValueError: the %s is invalid EXCHANGE RATE value.", rate);
                System.out.println(errorCode);
            }
        }
        public static void setAmount(float value){
            if (value >= 0 ) {
                amount = value;
            } else {
                String errorCode = String.format("ValueError: the %s is invalid AMOUNT value.", value);
                System.out.println(errorCode);
            }
        }
        public static void setExchangeCurrencies(String[] currencies){
            boolean valueError = false;
            if (currencies.length != 2){
                valueError = true;
            }
            if (!valueError){
                exchangeCurrencies = currencies;
            } else {
                String errorCode2 = String.format("ValueError: two  currency values must be passed.");
                System.out.println(errorCode2);
            }
        }
        public static String getExchange(){
            if ((exchangeRate != -1) &&  (amount != -1) && (exchangeCurrencies.length == 2)) {
                float result = amount * exchangeRate;
                System.out.printf("1 %s = %s %s\nЦБ РФ %s\n", exchangeCurrencies[0], exchangeRate, exchangeCurrencies[1], UserInterface.getDate());
                String str = String.format("%s %s = %s %s", amount, exchangeCurrencies[0], result, exchangeCurrencies[1]);
                return str;
            } else {
                return "You entered an incorrect value try again";
            }
        }
    }