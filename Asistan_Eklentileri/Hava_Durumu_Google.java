package Asistan_Eklentileri;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Hava_Durumu_Google {
	
		    public static void main(String[] args) {
		    	Scanner scanner = new Scanner(System.in);
		    	while(true) {
		    	//tarih ve zaman
		    	LocalDate currentDate = LocalDate.now();
			    LocalTime currentTime = LocalTime.now();
			    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			    String �uanki_Tarih = currentDate.format(dateFormatter);
			    String �uanki_Saat = currentTime.format(timeFormatter);
			    
		        // Hava durumu bilgilerini almak istedi�iniz �ehir ve sitesini belirtin
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
		                String bosluk = " ";
		                
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
		                System.err.println("Hava durumu bilgileri al�namad�.");
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		    }//while
		    	
		    }
	
}
