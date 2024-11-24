package Asistan_Eklentileri;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Wikipedia_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Wikipedia arama URL'si
        String searchUrl = "https://tr.wikipedia.org/w/index.php?search=";

        // Arama yapýlacak kelime
        System.out.println("Wikipedia'da neyi aratmak istiyorsunuz?");
        String searchTerm = scanner.nextLine();
        System.out.println();

        try {
            // Arama sayfasýný Jsoup ile çek
            Document document = Jsoup.connect(searchUrl + searchTerm).get();
            Element titleElement = document.select(".mw-page-title-main").first();  // first ilk elemanýný çekmesine yarýyor

            // Paragraf etiketleri içindeki metinleri seç
            Elements paragraphElements = document.select("p");

            // Baþlýklarý daha geniþ bir kapsamda seç
            Elements basliklar = document.select("h1, h2, h3, h4, h5, h6");

            if (titleElement != null && paragraphElements != null) {
                String title = titleElement.text();

                System.out.println("Baþlýk : " + title + "\n\n");

                // Her bir paragrafý ve ona ait baþlýðý ekrana yazdýr
                for (Element paragraph : paragraphElements) {
                    if (paragraph.text().length() > 100) {
                        int sayac = 0;
                        for (int i2 = 0; i2 < paragraph.text().length(); i2++) {
                            System.out.print(paragraph.text().charAt(i2));
                            sayac++;

                            if (sayac > 110 && String.valueOf(paragraph.text().charAt(i2)).equalsIgnoreCase(" ")) {
                                System.out.println("");
                                sayac = 0;
                            }
                        }
                        System.out.println();
                        System.out.println(); // Her paragrafýn altýna bir satýr boþluk ekle

                        // Bu paragrafýn ait olduðu baþlýðý bul ve yazdýr
                        Element baslikForParagraph = findHeaderForParagraph(paragraph, basliklar);
                        if (baslikForParagraph != null) {
                            System.out.println("Baþlýk: " + baslikForParagraph.text());
                            System.out.println(); // Her baþlýk sonrasýnda bir satýr boþluk ekle
                        }
                    }
                }

            } else {
                System.err.println("Wikipedia verisi alýnamadý.\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static Element findHeaderForParagraph(Element paragraph, Elements basliklar) {
        // Her paragrafýn ait olduðu baþlýðý bulmak için paragrafýn üstündeki bir üst elementi al
        Element parent = paragraph.parent();
        // Bu üst elementin baþlýk etiketini ara
        for (Element baslik : basliklar) {
            if (isDescendant(baslik, parent)) {
                return baslik;
            }
        }
        return null; // Eðer baþlýk bulunamazsa null döndür
    }

    private static boolean isDescendant(Element ancestor, Element descendant) {
        while (descendant != null) {
            if (descendant.equals(ancestor)) {
                return true;
            }
            descendant = descendant.parent();
        }
        return false;
    }
}

