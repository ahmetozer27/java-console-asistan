package Asistan_Eklentileri;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class SaatVeTakvim {
	public static void main(String[] args) {
		// �u anki tarih ve saat bilgisini al
        LocalDateTime now = LocalDateTime.now();

        // Tarih ve saat bilgisini belirli bir formata d�n��t�r
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Konsola yazd�r
        System.out.println("�u anki tarih ve saat: " + formattedDateTime);
	}
}
