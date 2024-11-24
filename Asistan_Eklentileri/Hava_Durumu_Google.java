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
			    String Þuanki_Tarih = currentDate.format(dateFormatter);
			    String Þuanki_Saat = currentTime.format(timeFormatter);
			    
		        // Hava durumu bilgilerini almak istediðiniz þehir ve sitesini belirtin
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
		                String bosluk = " ";
		                
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
		                System.err.println("Hava durumu bilgileri alýnamadý.");
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		    }//while
		    	
		    }
	
}
