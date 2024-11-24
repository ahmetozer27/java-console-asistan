package Asistan_Eklentileri;

import javax.sound.sampled.*;

public class SesliAsistan {

    public static void main(String[] args) {
        try {
            // Ses formatýný belirle
            AudioFormat format = new AudioFormat(44100, 16, 1, true, false);

            // Mikrofondan ses almak için ses hattýný aç
            TargetDataLine line = AudioSystem.getTargetDataLine(format);
            line.open(format);
            line.start();

            System.out.println("Sesli komut bekleniyor...");

            byte[] buffer = new byte[1024];
            int bytesRead;

            while (true) {
                bytesRead = line.read(buffer, 0, buffer.length);

                // Alýnan ses verisini ekrana yazdýr
                System.out.println("Alýnan ses verisi: " + bytesRead + " byte");

                // Ses verilerini burada iþleyebilirsiniz
            }

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}


