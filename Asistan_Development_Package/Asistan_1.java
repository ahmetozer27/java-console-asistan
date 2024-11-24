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
	//AS�STAN �SM�
	static String asistan_name = "JARV�S";
	//TAR�H VE ZAMAN
	static LocalDate currentDate = LocalDate.now();
    static LocalTime currentTime = LocalTime.now();
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    static String �uanki_Tarih = currentDate.format(dateFormatter);
    static String �uanki_Saat = currentTime.format(timeFormatter);
    
	public static void main(String[] args) {
		
		
		System.out.println("\n         - - -     --BEN S�Z�N �ZEL AS�STANINIZIM--     - - -   \n\n");
	
		
		while (true) {
			
            
			
			//TAR�H VE ZAMAN
			
	        
	        //AS�STAN ARAY�Z
			System.out.println("\n               "+asistan_name.toUpperCase()+" (V1.0)               Saat : "+�uanki_Saat+" Tarih : "+�uanki_Tarih+"\n" );
			System.out.print(" Merhaba! Size Nas�l Yard�mc� Olabilirim : \n          (��k�� i�in 'exit') \n");
			String komut = scanner.nextLine();
			
			
			//       �IKI�
			if (komut.equalsIgnoreCase("exit") || komut.equalsIgnoreCase("��k��") || komut.equalsIgnoreCase("��kmak") || komut.equalsIgnoreCase("��k") || komut.equalsIgnoreCase("kapat") || komut.equalsIgnoreCase("kapan")) {
				System.out.println("Asistan Kapat�l�yor. �yi G�nler!");
				break;
			}
			
			//	     HAVA DURUMU
	
			else if(komut.equalsIgnoreCase("Hava durumu bilgileri") || komut.equalsIgnoreCase("Hava durumu") || komut.equalsIgnoreCase("Hava durumu nedir") || komut.equalsIgnoreCase("Hava durumu nedir?") || komut.equalsIgnoreCase("Hava nas�l") || komut.equalsIgnoreCase("Hava") || komut.equalsIgnoreCase("Hava g�zel mi") || komut.equalsIgnoreCase("Hava g�zelmi")) {
				
				Hava_Durumu();				
			}
			
			//       W�K�PED�A
			
			else if(komut.equalsIgnoreCase("Wikipedia") || komut.equalsIgnoreCase("Wiki") || komut.equalsIgnoreCase("ara�t�rma yapmak istiyorum") || komut.equalsIgnoreCase("arama") || komut.equalsIgnoreCase("ara�t�rma") || komut.equalsIgnoreCase("nedir") || komut.equalsIgnoreCase("��renmem gerek") || komut.equalsIgnoreCase("bilmiyorum")) {
				
				 Wikipedia();
				
			}
			
			//komutlara g�nderme
			else {
			String yanit = processCommand(komut);
			System.out.println("Asistan: " + yanit);
			}
		}

		scanner.close();
	}//main
	
	//KOMUTLARA CEVAPLAR
	private static String processCommand(String komut) {
		
		   //  �S�M DE���T�RME
		if(komut.equalsIgnoreCase("ismini de�i�tirmek istiyorum") || komut.equalsIgnoreCase("ismin farkl� olsun") || komut.equalsIgnoreCase("sana �unu demek istiyorum") || komut.equalsIgnoreCase("sana bunu demek istiyorum") || komut.equalsIgnoreCase("ismini de�i�tir") || komut.equalsIgnoreCase("ismin art�k �u") || komut.equalsIgnoreCase("ismin art�k bu") || komut.equalsIgnoreCase("seni ��yle �a��rmak istiyorum") || komut.equalsIgnoreCase("ismini de�i�tircem") || komut.equalsIgnoreCase("isim de�i�tir") || komut.equalsIgnoreCase("ismin farkl� olsun")) {
			System.out.println(" Bana ne demek istersiniz ? ");
		
			return asistan_isim();
			
		}
		   //  �SM�N� �A�IRMA
		
		if(komut.equalsIgnoreCase(asistan_name)) {
			
			return " Buyrun Efendim Beni �a��rm��s�n�z :) \n";
			
		}				
		
		   //  SELAMLA�MA
		if(komut.equalsIgnoreCase("Selamun aleyk�m") || komut.equalsIgnoreCase("selamunaleyk�m") || komut.equalsIgnoreCase("sa")) {
			return " Aleyk�m Selam Efendim ! \n";
			
		}
		if(komut.equalsIgnoreCase("selam") || komut.equalsIgnoreCase("merhaba") || komut.equalsIgnoreCase("slm") || komut.equalsIgnoreCase("selm") || komut.equalsIgnoreCase("slam")) {
			return " Selaaam ! \n";
			
		}
		
		
		   //  DURUM SORMA
		if (komut.equalsIgnoreCase("Nas�ls�n") || komut.equalsIgnoreCase("Nas�ls�n ?") || komut.equalsIgnoreCase("Nas�ls�n?") || komut.equalsIgnoreCase("Nas�ls�n�z") || komut.equalsIgnoreCase("Naber") || komut.equalsIgnoreCase("Ne yap�yon")) {
			
			return " �yiyim Efendim, Siz Nas�ls�n�z ? \n";
		}
		if(komut.equalsIgnoreCase("iyi") || komut.equalsIgnoreCase("iyiyim") || komut.equalsIgnoreCase("bende iyiyim") || komut.equalsIgnoreCase("g�zel") || komut.equalsIgnoreCase("fena de�il")) {
			return "Sevindim Bu Konuda \n";
			
		}
		if(komut.equalsIgnoreCase("k�t�") || komut.equalsIgnoreCase("k�t�y�m") || komut.equalsIgnoreCase("eh i�te") || komut.equalsIgnoreCase("berbat") || komut.equalsIgnoreCase("can�m s�kk�n") || komut.equalsIgnoreCase("s�k�l�yorum")) {
			System.out.println(" B�yle Hissetmenize �z�ld�m �sterseniz Size Komik Espriler Yapabilirim ( Olur/Olmaz ) \n");
			String espri=scanner.nextLine();
			if(espri.equalsIgnoreCase("olur") || espri.equalsIgnoreCase("evet")) {
				System.out.println("Ben mafya babas�y�m ��nk� o�lumun ad� Mafya.");
			}
			else {
				return " \n";
			}
			System.out.println(" Ba�ka �ster Misiniz ? ( Olur/Olmaz ) \n");
			String espri2=scanner.nextLine();
			if(espri2.equalsIgnoreCase("olur") || espri2.equalsIgnoreCase("evet")) {
				
				return "Kim vurduya gittim birazdan gelece�im.\n\n"
					 + "Zenginler et, fakirler hayalet yer.\n\n"
					 + "Hava korsan� u�a�� ka��racakt� ama yapamad� ��nk� u�a�� ka��rd�.\n\n"
					 + "G�T'Ar�' getir de biraz �ark� s�yleyelim.\n"
					 + "            -Abi ar� sokmas�n! \n";
				
			}
			else {
				return " \n";
			}
			
		}
		
		
		//�rnek
		if(komut.equalsIgnoreCase("Nas�ls�n")) {
			
			return " \n"; 
			
		}
		
		
		
		
		
			return " Anla��lmad� L�tfen Ba�ka Bir �ey Deneyiniz ! \n";
		
		
			// yaz�y� b�y�k yaz�ya �eviriyor  return komut.toUpperCase();
	}//komutlar
	
	//    �S�M DE���T�RME
		public static String asistan_isim() {
			asistan_name = scanner.nextLine();
			return "Peki Te�ekk�rler Art�k �smim : " + asistan_name.toUpperCase() + "\n";
			
		}//isim de�i�tirme
	
	
	
	
	
	
	
	
	//      HAVA DURUMU	
	public static void Hava_Durumu() {
		System.out.println("\n Hangi �ehir ? ");
    	String city = scanner.nextLine();
        String weatherSiteUrl = "https://www.google.com/search?q="+city+"+hava+durumu";
        
       
        try {
            // Jsoup ile web sitesinden HTML i�eri�ini �ek
            Document document = Jsoup.connect(weatherSiteUrl).get();

            // Hava durumu bilgilerini �ek
            
            Element temperatureElement = document.select("span.wob_t.q8U8x").first();
            Element spanElement = document.select("span.wob_t[aria-label]").first();
            Element celciusElement = document.select("span.wob_t[role]").first();
            Element cityname = document.select("span.BBwThe").first();
            Element ya��� = document.select(".wtsRwe").first();
            
            // Bilgileri konsola yazd�r
            if (temperatureElement != null && spanElement != null && celciusElement != null && cityname != null && ya��� != null) {
                String temperature = temperatureElement.text();		          
                
                System.out.println("\n �ehir: " + cityname.text()+"    Saat : "+�uanki_Saat+" Tarih : "+�uanki_Tarih+"\n");
                System.out.print(" S�cakl�k: " + temperature+celciusElement.text()+"\n ");
                for(int i = 0 ; i < ya���.text().length() ; i++) {
                	System.out.print(ya���.text().charAt(i));
                	if(String.valueOf(ya���.text().charAt(i)).equalsIgnoreCase("%")) {
                		
                		System.out.println("");
                				                			                		
                	}
                	if(String.valueOf(ya���.text().charAt(i)).equalsIgnoreCase("s")) {
                		break;
                	}
                	
                }
                System.out.println();
                
             
            }//if 
            
            else {
                System.err.println("Hava durumu bilgileri al�namad�. (Sonu� Bulunamad�)\n");
            }

        } catch (IOException e) {
        	System.err.println("Hava durumu bilgileri al�namad�. (Muhtemel �nternet Ba�lant� Problemi)\n");
            //    hata bilgilerini yazd�r�r         e.printStackTrace();
        }
	}//hava durumu
	
	
	//    W�K�PED�A 
	public static void Wikipedia() {
    	
    	Scanner scanner= new Scanner(System.in);
	
        // Wikipedia arama URL'si
        String searchUrl = "https://tr.wikipedia.org/w/index.php?search=";
        
        // Arama yap�lacak kelime
        System.out.println("   Wikipedia'da neyi aratmak istiyorsunuz ? ");	        
        String searchTerm = scanner.nextLine();
        System.out.println();
        
        try {
        	
        	
            // Arama sayfas�n� Jsoup ile �ek
            Document document = Jsoup.connect(searchUrl + searchTerm).get();
            Element titleElement = document.select(".mw-page-title-main").first();  //first ilk eleman�n� �ekmesine yar�yor
            // Paragraf etiketleri i�indeki metinleri se�
            Elements paragraphElements = document.select("p");

            if (titleElement != null && paragraphElements != null) {
                String title = titleElement.text();	       

                System.out.println("Ba�l�k : " + title + "\n\n");
             // Her bir paragraf� ekrana yazd�r
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
	                System.out.println(); // Her paragraf�n alt�na bir sat�r bo�luk ekle
	            }
             
            } else {
                System.err.println(" Wikipedia verisi al�namad�. (Sonu� Bulunamad�)\n");
            }
            
         // Paragraf etiketleri i�indeki metinleri se�
            

            
            

        } catch (IOException e) {
            //   hata kodlar�n� yazd�r�r  e.printStackTrace();
        	System.err.println(" Wikipedia verisi al�namad�. (Muhtemel �nternet Ba�lant� Problemi)\n");
        	
        }
        
    }//wiki
		
		public void Komutu_Anlama(String komut) {
			
			for(int i=0;i<komut.length();i++) {
				
				
				
			}
			
			
			
		}
	
				
	}//class
	


