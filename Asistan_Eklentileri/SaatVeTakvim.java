package Asistan_Eklentileri;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class SaatVeTakvim {
	public static void main(String[] args) {
		// Þu anki tarih ve saat bilgisini al
        LocalDateTime now = LocalDateTime.now();

        // Tarih ve saat bilgisini belirli bir formata dönüþtür
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Konsola yazdýr
        System.out.println("Þu anki tarih ve saat: " + formattedDateTime);
	}
}
