package Asistan_Eklentileri;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
public class Wikipedia_Bilgi {
	

	    public static void main(String[] args) {
	    	
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
	                System.err.println(" Wikipedia verisi alýnamadý. \n");
	            }
	            
	         // Paragraf etiketleri içindeki metinleri seç
	            

	            
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        scanner.close();
	    }
	


	
	
}
