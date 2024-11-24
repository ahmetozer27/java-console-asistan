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

        // Arama yap�lacak kelime
        System.out.println("Wikipedia'da neyi aratmak istiyorsunuz?");
        String searchTerm = scanner.nextLine();
        System.out.println();

        try {
            // Arama sayfas�n� Jsoup ile �ek
            Document document = Jsoup.connect(searchUrl + searchTerm).get();
            Element titleElement = document.select(".mw-page-title-main").first();  // first ilk eleman�n� �ekmesine yar�yor

            // Paragraf etiketleri i�indeki metinleri se�
            Elements paragraphElements = document.select("p");

            // Ba�l�klar� daha geni� bir kapsamda se�
            Elements basliklar = document.select("h1, h2, h3, h4, h5, h6");

            if (titleElement != null && paragraphElements != null) {
                String title = titleElement.text();

                System.out.println("Ba�l�k : " + title + "\n\n");

                // Her bir paragraf� ve ona ait ba�l��� ekrana yazd�r
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
                        System.out.println(); // Her paragraf�n alt�na bir sat�r bo�luk ekle

                        // Bu paragraf�n ait oldu�u ba�l��� bul ve yazd�r
                        Element baslikForParagraph = findHeaderForParagraph(paragraph, basliklar);
                        if (baslikForParagraph != null) {
                            System.out.println("Ba�l�k: " + baslikForParagraph.text());
                            System.out.println(); // Her ba�l�k sonras�nda bir sat�r bo�luk ekle
                        }
                    }
                }

            } else {
                System.err.println("Wikipedia verisi al�namad�.\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static Element findHeaderForParagraph(Element paragraph, Elements basliklar) {
        // Her paragraf�n ait oldu�u ba�l��� bulmak i�in paragraf�n �st�ndeki bir �st elementi al
        Element parent = paragraph.parent();
        // Bu �st elementin ba�l�k etiketini ara
        for (Element baslik : basliklar) {
            if (isDescendant(baslik, parent)) {
                return baslik;
            }
        }
        return null; // E�er ba�l�k bulunamazsa null d�nd�r
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

