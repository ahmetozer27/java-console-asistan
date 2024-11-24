package Asistan_Eklentileri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class Hava_Durumu {
    public static void main(String[] args) {
        // Hava durumu bilgilerini almak istediðiniz þehir ve sitesini belirtin
        String weatherSiteUrl = "https://weather.com/tr-TR/weather/today/l/054a587bd4c7b99b5ed929073c1e8edceefb3a4a9ab0768a4baf87c7bb53e510";
       //ankara String weatherSiteUrl = "https://weather.com/tr-TR/kisisel/bugun/l/TUXX0002:1:TU";

        try {
            // Jsoup ile web sitesinden HTML içeriðini çek
            Document document = Jsoup.connect(weatherSiteUrl).get();

            // Hava durumu bilgilerini çek
            Element time = document.select(".CurrentConditions--timestamp--1ybTk").first();
            Element temperatureElement = document.select(".CurrentConditions--tempValue--MHmYY").first();
            Element citynameElement = document.select(".CurrentConditions--location--1YWj_").first();
            

            // Bilgileri konsola yazdýr
            if (temperatureElement != null && citynameElement != null) {
                String temperature = temperatureElement.text();
                String cityname = citynameElement.text();

                System.out.println("Þehir: " + cityname+"\n");
                System.out.println("Sýcaklýk: " + temperature + "   " +time.text());
             
            } else {
                System.err.println("Hava durumu bilgileri alýnamadý.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

