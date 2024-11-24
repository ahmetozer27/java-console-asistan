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
        // Belirli aral�klarla g�ncelleme yapmak i�in bir zamanlay�c� olu�turun
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // G�ncelleme g�revini olu�turun
        Runnable updateTask = () -> {
            try {
                System.out.println("\n                                            D�viz Kurlar� (Canl�) " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "     (��k�� yapmak i�in bir tu�a bas�n...)");

                //alt�n
                Document documentgramalt�n = Jsoup.connect("https://altin.doviz.com/gram-altin").get();
                Document document�eyrekalt�n= Jsoup.connect("https://altin.doviz.com/ceyrek-altin").get();
                Document documentyar�malt�n = Jsoup.connect("https://altin.doviz.com/yarim-altin").get();
                Document documenttamalt�n = Jsoup.connect("https://altin.doviz.com/tam-altin").get();
                //dolar
                Document documentdolar = Jsoup.connect("https://kur.doviz.com/serbest-piyasa/amerikan-dolari").get();
                //euro
                Document documenteuro = Jsoup.connect("https://kur.doviz.com/serbest-piyasa/euro").get();
                //sterlin
                Document documentsterlin = Jsoup.connect("https://kur.doviz.com/serbest-piyasa/sterlin").get();

                //Bilgileri al
                //alt�n
                Element gramalt�n = documentgramalt�n.select(".text-md.font-semibold.text-white.mt-4").first();
                Element �eyrekalt�n = document�eyrekalt�n.select(".text-md.font-semibold.text-white.mt-4").first();
                Element yar�malt�n = documentyar�malt�n.select(".text-md.font-semibold.text-white.mt-4").first();
                Element tamalt�n = documenttamalt�n.select(".text-md.font-semibold.text-white.mt-4").first();
                //dolar
                Element dolarElement = documentdolar.select(".text-md.font-semibold.text-white.mt-4").first();
                //euro
                Element euroElement = documenteuro.select(".text-md.font-semibold.text-white.mt-4").first();
                //sterlin
                Element sterlinElement = documentsterlin.select(".text-md.font-semibold.text-white.mt-4").first();

                // G�ncellenmi� d�viz kurlar�n� yazd�rma
                System.out.println("\n        Gram Alt�n                     Dolar                     Euro                   Sterlin\n      Al��  /  Sat�� "
                        + "            " + dolarElement.text() + "        " + euroElement.text() + "        " + sterlinElement.text() + "\n   " + gramalt�n.text());
                System.out.println("\n       �eyrek Alt�n\n      Al��  /  Sat�� \n   " + �eyrekalt�n.text());
                System.out.println("\n        Yar�m Alt�n\n      Al��  /  Sat�� \n   " + yar�malt�n.text());
                System.out.println("\n         Tam Alt�n\n      Al��  /  Sat�� \n   " + tamalt�n.text());
                System.out.println("\n                                 (Veriler D�viz.com ' dan al�nm��t�r.)\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        // Belirli aral�klarla g�revi �al��t�r�n (�rne�in, her 10 saniyede bir)
        scheduler.scheduleAtFixedRate(updateTask, 0, 10, TimeUnit.SECONDS);

        // Kullan�c�dan bir tu�a basmas�n� bekleyin
        
        new Scanner(System.in).nextLine();

        // Zamanlay�c�y� kapat�n
        scheduler.shutdown();
    }
}


	



