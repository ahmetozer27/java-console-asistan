package Asistan_Eklentileri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class D�viz {

	public static void main(String[] args) {
		System.out.println("\n                                            D�viz Kurlar� (Canl�) ");
		try {
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
            Element dolar = documentdolar.select(".text-md.font-semibold.text-white.mt-4").first();
            
            //euro
            Element euro = documenteuro.select(".text-md.font-semibold.text-white.mt-4").first();
            
            //sterlin
            Element sterlin = documentsterlin.select(".text-md.font-semibold.text-white.mt-4").first();
            
            
			System.out.println("\n        Gram Alt�n                     Dolar                     Euro                   Sterlin\n      Al��  /  Sat�� "+"            "+dolar.text()+"        "+euro.text()+"        "+sterlin.text()+"\n   "+gramalt�n.text());
			System.out.println("\n       �eyrek Alt�n\n      Al��  /  Sat�� \n   "+�eyrekalt�n.text());
			System.out.println("\n        Yar�m Alt�n\n      Al��  /  Sat�� \n   "+yar�malt�n.text());
			System.out.println("\n         Tam Alt�n\n      Al��  /  Sat�� \n   "+tamalt�n.text());
			
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
