package Asistan_Eklentileri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DovizGuncelleme {

    public static void main(String[] args) {
        // Belirli aralýklarla güncelleme yapmak için bir zamanlayýcý oluþturun
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Güncelleme görevini oluþturun
        Runnable updateTask = () -> {
            try {
                System.out.println("\n                                            Döviz Kurlarý (Canlý) " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "     (Çýkýþ yapmak için bir tuþa basýn...)");

                //altýn
                Document documentgramaltýn = Jsoup.connect("https://altin.doviz.com/gram-altin").get();
                Document documentçeyrekaltýn= Jsoup.connect("https://altin.doviz.com/ceyrek-altin").get();
                Document documentyarýmaltýn = Jsoup.connect("https://altin.doviz.com/yarim-altin").get();
                Document documenttamaltýn = Jsoup.connect("https://altin.doviz.com/tam-altin").get();
                //dolar
                Document documentdolar = Jsoup.connect("https://kur.doviz.com/serbest-piyasa/amerikan-dolari").get();
                //euro
                Document documenteuro = Jsoup.connect("https://kur.doviz.com/serbest-piyasa/euro").get();
                //sterlin
                Document documentsterlin = Jsoup.connect("https://kur.doviz.com/serbest-piyasa/sterlin").get();

                //Bilgileri al
                //altýn
                Element gramaltýn = documentgramaltýn.select(".text-md.font-semibold.text-white.mt-4").first();
                Element çeyrekaltýn = documentçeyrekaltýn.select(".text-md.font-semibold.text-white.mt-4").first();
                Element yarýmaltýn = documentyarýmaltýn.select(".text-md.font-semibold.text-white.mt-4").first();
                Element tamaltýn = documenttamaltýn.select(".text-md.font-semibold.text-white.mt-4").first();
                //dolar
                Element dolarElement = documentdolar.select(".text-md.font-semibold.text-white.mt-4").first();
                //euro
                Element euroElement = documenteuro.select(".text-md.font-semibold.text-white.mt-4").first();
                //sterlin
                Element sterlinElement = documentsterlin.select(".text-md.font-semibold.text-white.mt-4").first();

                // Güncellenmiþ döviz kurlarýný yazdýrma
                System.out.println("\n        Gram Altýn                     Dolar                     Euro                   Sterlin\n      Alýþ  /  Satýþ "
                        + "            " + dolarElement.text() + "        " + euroElement.text() + "        " + sterlinElement.text() + "\n   " + gramaltýn.text());
                System.out.println("\n       Çeyrek Altýn\n      Alýþ  /  Satýþ \n   " + çeyrekaltýn.text());
                System.out.println("\n        Yarým Altýn\n      Alýþ  /  Satýþ \n   " + yarýmaltýn.text());
                System.out.println("\n         Tam Altýn\n      Alýþ  /  Satýþ \n   " + tamaltýn.text());
                System.out.println("\n                                 (Veriler Döviz.com ' dan alýnmýþtýr.)\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        // Belirli aralýklarla görevi çalýþtýrýn (örneðin, her 10 saniyede bir)
        scheduler.scheduleAtFixedRate(updateTask, 0, 10, TimeUnit.SECONDS);

        // Kullanýcýdan bir tuþa basmasýný bekleyin
        
        new Scanner(System.in).nextLine();

        // Zamanlayýcýyý kapatýn
        scheduler.shutdown();
    }
}


	



