public class Main {
    public static void main(String[] args) {
        float rate = 6.5f;
        float value = 100;
        String[] currencies = new String[] {"RUB", "KZT"};
        CurrencyConverter exchange = new CurrencyConverter();
        exchange.setExchangeRate(rate);
        exchange.setAmount(value);
        exchange.setExchangeCurrencies(currencies);
        String result = exchange.getExchange();
        System.out.printf("%s.", result);
    }
}
