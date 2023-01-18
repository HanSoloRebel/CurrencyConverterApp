import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static float exchangeRate = -1;
    private static float base = -1;
    private static float amount = -1;
    private static String exchangeCurrency;
//    private static String exchangeCurrency;
    //    private static List<String> currenciesList = new ArrayList<>(asList("RUB", "CNY", "KZT", "BYN","TRY", "USD","UER");
    private static Map<String, String[]> currencyDictionary = new HashMap<>(){{
        put("RUB", new String[] {"Российский рубль", "Российского рубля"});
        put("CNY", new String[] {"Китайский юань", "Китайского юаня"});
        put("KZT", new String[] {"Казахстанский тенге", "Казахстанского тенге"});
        put("BYN", new String[] {"Белорусский рубль", "Беларусского рубля"});
        put("TRY", new String[] {"Турецкая лира", "Турецкой лиры"});
        put("USD", new String[] {"Доллар США", "Доллара США"});
        put("UER", new String[] {"Евро", "Евро"});
    }};

    public static Set<String> getCurrencyDictionary() {
        return currencyDictionary.keySet();
    }

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
    public static void setBase(float value){
        if (value >= 0 ) {
            base = value;
        }
    }
    public static void setExchangeCurrencies(String currency){
        boolean valueError = false;
//        if (currencies.length == 2){
//            for (String i : currencies){
//                if (!currenciesList.contains(i)){
//                if (!(currencyDictionary.keySet()).contains(currency)){
        if (!ExchangeRate.getCurrenciesList().contains(currency)){
                    String errorCode1 = String.format("ValueError: the %s is not in currency list.", currency);
                    System.out.println(errorCode1);
                    valueError = true;
                }
//            }
            if (!valueError){
                exchangeCurrency = currency;
            }
        } /*else {
            String errorCode2 = String.format("ValueError: two  currency values must be passed.");
            System.out.println(errorCode2);
        }*/
//    }
    public static float getExchange(){
        float result = 0;
        if ((exchangeRate != -1) &&  (amount != -1) && (base != -1) && (exchangeCurrency.length() != 0)) {
            result = (amount * base) / exchangeRate;
//            System.out.printf("1 %s = %s %s\nЦБ РФ %s\n", currencyDictionary.get(exchangeCurrencies[0])[0], exchangeRate, currencyDictionary.get(exchangeCurrencies[1])[1], UserInterface.getDate());
//            String str = String.format("%s %s = %s %s", amount, exchangeCurrencies[0], result, exchangeCurrencies[1]);
        }/* else {
            return "You entered an incorrect value try again";
        }*/
        return result;
    }
}
