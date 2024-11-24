package Asistan_Eklentileri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Döviz {

	public static void main(String[] args) {
		System.out.println("\n                                            Döviz Kurlarý (Canlý) ");
		try {
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
            Element dolar = documentdolar.select(".text-md.font-semibold.text-white.mt-4").first();
            
            //euro
            Element euro = documenteuro.select(".text-md.font-semibold.text-white.mt-4").first();
            
            //sterlin
            Element sterlin = documentsterlin.select(".text-md.font-semibold.text-white.mt-4").first();
            
            
			System.out.println("\n        Gram Altýn                     Dolar                     Euro                   Sterlin\n      Alýþ  /  Satýþ "+"            "+dolar.text()+"        "+euro.text()+"        "+sterlin.text()+"\n   "+gramaltýn.text());
			System.out.println("\n       Çeyrek Altýn\n      Alýþ  /  Satýþ \n   "+çeyrekaltýn.text());
			System.out.println("\n        Yarým Altýn\n      Alýþ  /  Satýþ \n   "+yarýmaltýn.text());
			System.out.println("\n         Tam Altýn\n      Alýþ  /  Satýþ \n   "+tamaltýn.text());
			
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
