import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.IOException;

public class ExchangeRate {
    private static String[] result = new String[2];
    private static String url = "https://cbr.ru/currency_base/daily/?UniDbQuery.Posted=True&UniDbQuery.To=" + GUI.getDate();
    private static Map<String, String[]> exchangeDB = new HashMap<>(){{
        put("DKK", new String[] {"Датская крона", " Датские кроны", "0", "0"});
        put("USD", new String[] {"Доллар США", "Доллара США", "0", "0"});
        put("EUR", new String[] {"Евро", "Евро", "0", "0"});
        put("INR", new String[] {"Индийских рупий", "Индийские рупии", "0", "0"});
        put("KZT", new String[] {"Казахстанский тенге", "Казахстанских тенге", "0", "0"});
        put("CAD", new String[] {"Канадский доллар", "Канадских доллара", "0", "0"});
        put("CNY", new String[] {"Китайский юань", "Китайских юаней", "0", "0"});
        put("NOK", new String[] {"Норвежская крона", "Норвежских крон", "0", "0"});
        put("GBP", new String[] {"Фунт стерлингов", "Фунта стерлингов", "0", "0"});
        put("CHF", new String[] {"Швейцарский франк", "Швейцарских франка", "0", "0"});
        put("JPY", new String[] {"Японская иена", "Японских иен", "0", "0"});
        put("BYN", new String[] {"Белорусский рубль", "Белорусских рубля", "0", "0"});
    }};

    private static Document getPage() throws IOException {
//        Document page = Jsoup.parse(new URL (url), 3000);
        Document page = Jsoup.connect(url).get();
//        URLDecoder.decode( url, "UTF-8")
        return page;
    }

    public static Set<String> getCurrenciesList(){
        return exchangeDB.keySet();
    }
    public static String[] getRate(){
        try{
//            System.out.println(getPage());
            Document page = getPage();
            Elements data = page.select("tr");
            for (Element i : data) {
                String currency = i.text();
                String[] cur = currency.split(" ");
                if (exchangeDB.containsKey(cur[1])){
                    exchangeDB.get(cur[1])[exchangeDB.get(cur[1]).length - 1] = cur[cur.length - 1];
                    exchangeDB.get(cur[1])[exchangeDB.get(cur[1]).length -2] = cur[2];
                }
            }
//            System.out.println(Arrays.toString(exchangeDB.get(GUI.getSelectedCurrencies())));
            result[0] = exchangeDB.get(GUI.getSelectedCurrencies())[2].replace(",", "."); //base
            result[1] = exchangeDB.get(GUI.getSelectedCurrencies())[3].replace(",", "."); //rate
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
