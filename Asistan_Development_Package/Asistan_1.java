package Asistan_Development_Package;
import javax.sound.sampled.*;
import java.util.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Asistan_1 {
	
	//SCANNER SINIFI
	static Scanner scanner = new Scanner(System.in);
	//ASÝSTAN ÝSMÝ
	static String asistan_name = "JARVÝS";
	//TARÝH VE ZAMAN
	static LocalDate currentDate = LocalDate.now();
    static LocalTime currentTime = LocalTime.now();
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    static String Þuanki_Tarih = currentDate.format(dateFormatter);
    static String Þuanki_Saat = currentTime.format(timeFormatter);
    
	public static void main(String[] args) {
		
		
		System.out.println("\n         - - -     --BEN SÝZÝN ÖZEL ASÝSTANINIZIM--     - - -   \n\n");
	
		
		while (true) {
			
            
			
			//TARÝH VE ZAMAN
			
	        
	        //ASÝSTAN ARAYÜZ
			System.out.println("\n               "+asistan_name.toUpperCase()+" (V1.0)               Saat : "+Þuanki_Saat+" Tarih : "+Þuanki_Tarih+"\n" );
			System.out.print(" Merhaba! Size Nasýl Yardýmcý Olabilirim : \n          (çýkýþ için 'exit') \n");
			String komut = scanner.nextLine();
			
			
			//       ÇIKIÞ
			if (komut.equalsIgnoreCase("exit") || komut.equalsIgnoreCase("çýkýþ") || komut.equalsIgnoreCase("çýkmak") || komut.equalsIgnoreCase("çýk") || komut.equalsIgnoreCase("kapat") || komut.equalsIgnoreCase("kapan")) {
				System.out.println("Asistan Kapatýlýyor. Ýyi Günler!");
				break;
			}
			
			//	     HAVA DURUMU
	
			else if(komut.equalsIgnoreCase("Hava durumu bilgileri") || komut.equalsIgnoreCase("Hava durumu") || komut.equalsIgnoreCase("Hava durumu nedir") || komut.equalsIgnoreCase("Hava durumu nedir?") || komut.equalsIgnoreCase("Hava nasýl") || komut.equalsIgnoreCase("Hava") || komut.equalsIgnoreCase("Hava güzel mi") || komut.equalsIgnoreCase("Hava güzelmi")) {
				
				Hava_Durumu();				
			}
			
			//       WÝKÝPEDÝA
			
			else if(komut.equalsIgnoreCase("Wikipedia") || komut.equalsIgnoreCase("Wiki") || komut.equalsIgnoreCase("araþtýrma yapmak istiyorum") || komut.equalsIgnoreCase("arama") || komut.equalsIgnoreCase("araþtýrma") || komut.equalsIgnoreCase("nedir") || komut.equalsIgnoreCase("öðrenmem gerek") || komut.equalsIgnoreCase("bilmiyorum")) {
				
				 Wikipedia();
				
			}
			
			//komutlara gönderme
			else {
			String yanit = processCommand(komut);
			System.out.println("Asistan: " + yanit);
			}
		}

		scanner.close();
	}//main
	
	//KOMUTLARA CEVAPLAR
	private static String processCommand(String komut) {
		
		   //  ÝSÝM DEÐÝÞTÝRME
		if(komut.equalsIgnoreCase("ismini deðiþtirmek istiyorum") || komut.equalsIgnoreCase("ismin farklý olsun") || komut.equalsIgnoreCase("sana þunu demek istiyorum") || komut.equalsIgnoreCase("sana bunu demek istiyorum") || komut.equalsIgnoreCase("ismini deðiþtir") || komut.equalsIgnoreCase("ismin artýk þu") || komut.equalsIgnoreCase("ismin artýk bu") || komut.equalsIgnoreCase("seni þöyle çaðýrmak istiyorum") || komut.equalsIgnoreCase("ismini deðiþtircem") || komut.equalsIgnoreCase("isim deðiþtir") || komut.equalsIgnoreCase("ismin farklý olsun")) {
			System.out.println(" Bana ne demek istersiniz ? ");
		
			return asistan_isim();
			
		}
		   //  ÝSMÝNÝ ÇAÐIRMA
		
		if(komut.equalsIgnoreCase(asistan_name)) {
			
			return " Buyrun Efendim Beni Çaðýrmýþsýnýz :) \n";
			
		}				
		
		   //  SELAMLAÞMA
		if(komut.equalsIgnoreCase("Selamun aleyküm") || komut.equalsIgnoreCase("selamunaleyküm") || komut.equalsIgnoreCase("sa")) {
			return " Aleyküm Selam Efendim ! \n";
			
		}
		if(komut.equalsIgnoreCase("selam") || komut.equalsIgnoreCase("merhaba") || komut.equalsIgnoreCase("slm") || komut.equalsIgnoreCase("selm") || komut.equalsIgnoreCase("slam")) {
			return " Selaaam ! \n";
			
		}
		
		
		   //  DURUM SORMA
		if (komut.equalsIgnoreCase("Nasýlsýn") || komut.equalsIgnoreCase("Nasýlsýn ?") || komut.equalsIgnoreCase("Nasýlsýn?") || komut.equalsIgnoreCase("Nasýlsýnýz") || komut.equalsIgnoreCase("Naber") || komut.equalsIgnoreCase("Ne yapýyon")) {
			
			return " Ýyiyim Efendim, Siz Nasýlsýnýz ? \n";
		}
		if(komut.equalsIgnoreCase("iyi") || komut.equalsIgnoreCase("iyiyim") || komut.equalsIgnoreCase("bende iyiyim") || komut.equalsIgnoreCase("güzel") || komut.equalsIgnoreCase("fena deðil")) {
			return "Sevindim Bu Konuda \n";
			
		}
		if(komut.equalsIgnoreCase("kötü") || komut.equalsIgnoreCase("kötüyüm") || komut.equalsIgnoreCase("eh iþte") || komut.equalsIgnoreCase("berbat") || komut.equalsIgnoreCase("caným sýkkýn") || komut.equalsIgnoreCase("sýkýlýyorum")) {
			System.out.println(" Böyle Hissetmenize Üzüldüm Ýsterseniz Size Komik Espriler Yapabilirim ( Olur/Olmaz ) \n");
			String espri=scanner.nextLine();
			if(espri.equalsIgnoreCase("olur") || espri.equalsIgnoreCase("evet")) {
				System.out.println("Ben mafya babasýyým çünkü oðlumun adý Mafya.");
			}
			else {
				return " \n";
			}
			System.out.println(" Baþka Ýster Misiniz ? ( Olur/Olmaz ) \n");
			String espri2=scanner.nextLine();
			if(espri2.equalsIgnoreCase("olur") || espri2.equalsIgnoreCase("evet")) {
				
				return "Kim vurduya gittim birazdan geleceðim.\n\n"
					 + "Zenginler et, fakirler hayalet yer.\n\n"
					 + "Hava korsaný uçaðý kaçýracaktý ama yapamadý çünkü uçaðý kaçýrdý.\n\n"
					 + "GÝT'Arý' getir de biraz þarký söyleyelim.\n"
					 + "            -Abi arý sokmasýn! \n";
				
			}
			else {
				return " \n";
			}
			
		}
		
		
		//örnek
		if(komut.equalsIgnoreCase("Nasýlsýn")) {
			
			return " \n"; 
			
		}
		
		
		
		
		
			return " Anlaþýlmadý Lütfen Baþka Bir Þey Deneyiniz ! \n";
		
		
			// yazýyý büyük yazýya çeviriyor  return komut.toUpperCase();
	}//komutlar
	
	//    ÝSÝM DEÐÝÞTÝRME
		public static String asistan_isim() {
			asistan_name = scanner.nextLine();
			return "Peki Teþekkürler Artýk Ýsmim : " + asistan_name.toUpperCase() + "\n";
			
		}//isim deðiþtirme
	
	
	
	
	
	
	
	
	//      HAVA DURUMU	
	public static void Hava_Durumu() {
		System.out.println("\n Hangi þehir ? ");
    	String city = scanner.nextLine();
        String weatherSiteUrl = "https://www.google.com/search?q="+city+"+hava+durumu";
        
       
        try {
            // Jsoup ile web sitesinden HTML içeriðini çek
            Document document = Jsoup.connect(weatherSiteUrl).get();

            // Hava durumu bilgilerini çek
            
            Element temperatureElement = document.select("span.wob_t.q8U8x").first();
            Element spanElement = document.select("span.wob_t[aria-label]").first();
            Element celciusElement = document.select("span.wob_t[role]").first();
            Element cityname = document.select("span.BBwThe").first();
            Element yaðýþ = document.select(".wtsRwe").first();
            
            // Bilgileri konsola yazdýr
            if (temperatureElement != null && spanElement != null && celciusElement != null && cityname != null && yaðýþ != null) {
                String temperature = temperatureElement.text();		          
                
                System.out.println("\n Þehir: " + cityname.text()+"    Saat : "+Þuanki_Saat+" Tarih : "+Þuanki_Tarih+"\n");
                System.out.print(" Sýcaklýk: " + temperature+celciusElement.text()+"\n ");
                for(int i = 0 ; i < yaðýþ.text().length() ; i++) {
                	System.out.print(yaðýþ.text().charAt(i));
                	if(String.valueOf(yaðýþ.text().charAt(i)).equalsIgnoreCase("%")) {
                		
                		System.out.println("");
                				                			                		
                	}
                	if(String.valueOf(yaðýþ.text().charAt(i)).equalsIgnoreCase("s")) {
                		break;
                	}
                	
                }
                System.out.println();
                
             
            }//if 
            
            else {
                System.err.println("Hava durumu bilgileri alýnamadý. (Sonuç Bulunamadý)\n");
            }

        } catch (IOException e) {
        	System.err.println("Hava durumu bilgileri alýnamadý. (Muhtemel Ýnternet Baðlantý Problemi)\n");
            //    hata bilgilerini yazdýrýr         e.printStackTrace();
        }
	}//hava durumu
	
	
	//    WÝKÝPEDÝA 
	public static void Wikipedia() {
    	
    	Scanner scanner= new Scanner(System.in);
	
        // Wikipedia arama URL'si
        String searchUrl = "https://tr.wikipedia.org/w/index.php?search=";
        
        // Arama yapýlacak kelime
        System.out.println("   Wikipedia'da neyi aratmak istiyorsunuz ? ");	        
        String searchTerm = scanner.nextLine();
        System.out.println();
        
        try {
        	
        	
            // Arama sayfasýný Jsoup ile çek
            Document document = Jsoup.connect(searchUrl + searchTerm).get();
            Element titleElement = document.select(".mw-page-title-main").first();  //first ilk elemanýný çekmesine yarýyor
            // Paragraf etiketleri içindeki metinleri seç
            Elements paragraphElements = document.select("p");

            if (titleElement != null && paragraphElements != null) {
                String title = titleElement.text();	       

                System.out.println("Baþlýk : " + title + "\n\n");
             // Her bir paragrafý ekrana yazdýr
                for (int i = 0; i < paragraphElements.size(); i++) {
                	
                	Element paragraph = paragraphElements.get(i);
                	if(paragraph.text().length()>100) {
                		int sayac=0;
                		for(int i2 = 0; i2< paragraph.text().length();i2++) {
                			System.out.print(paragraph.text().charAt(i2));
                			sayac++;
                			
                			if(sayac>110 && String.valueOf(paragraph.text().charAt(i2)).equalsIgnoreCase(" "))  {
                				System.out.println("");
                				sayac=0;
                			}
                		}
                	}
	                System.out.println();
	                System.out.println(); // Her paragrafýn altýna bir satýr boþluk ekle
	            }
             
            } else {
                System.err.println(" Wikipedia verisi alýnamadý. (Sonuç Bulunamadý)\n");
            }
            
         // Paragraf etiketleri içindeki metinleri seç
            

            
            

        } catch (IOException e) {
            //   hata kodlarýný yazdýrýr  e.printStackTrace();
        	System.err.println(" Wikipedia verisi alýnamadý. (Muhtemel Ýnternet Baðlantý Problemi)\n");
        	
        }
        
    }//wiki
		
		public void Komutu_Anlama(String komut) {
			
			for(int i=0;i<komut.length();i++) {
				
				
				
			}
			
			
			
		}
	
				
	}//class
	


