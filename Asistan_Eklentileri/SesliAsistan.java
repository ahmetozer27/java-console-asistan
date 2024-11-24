package Asistan_Eklentileri;

import javax.sound.sampled.*;

public class SesliAsistan {

    public static void main(String[] args) {
        try {
            // Ses format�n� belirle
            AudioFormat format = new AudioFormat(44100, 16, 1, true, false);

            // Mikrofondan ses almak i�in ses hatt�n� a�
            TargetDataLine line = AudioSystem.getTargetDataLine(format);
            line.open(format);
            line.start();

            System.out.println("Sesli komut bekleniyor...");

            byte[] buffer = new byte[1024];
            int bytesRead;

            while (true) {
                bytesRead = line.read(buffer, 0, buffer.length);

                // Al�nan ses verisini ekrana yazd�r
                System.out.println("Al�nan ses verisi: " + bytesRead + " byte");

                // Ses verilerini burada i�leyebilirsiniz
            }

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}


