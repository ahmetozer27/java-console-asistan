package Asistan_Eklentileri;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Komutu_AnlamaV2 {

	public static void main(String[] args) {
		String komut ="1+2 ka�t�r?    ";
		for(int i=0;i<komut.length();i++) {
			if(komut.charAt(i)== '+' || komut.charAt(i)=='-' || komut.charAt(i)=='*' || komut.charAt(i)=='/') {
				String tutulacakKarakterler="+-*/0123456789";
				BigDecimal Sayi1 = null,Sayi2 = null;
				
				StringBuilder filtrelenmiskomut = new StringBuilder();
						for (int i2 = 0; i2 < komut.length(); i2++) {
				            char karakter = komut.charAt(i2);

				            // Tutulacak karakterler i�inde olanlar� ekleyin
				            if (tutulacakKarakterler.contains(String.valueOf(karakter))) {
				            	filtrelenmiskomut.append(karakter);
				            }
				        }
						for(int i3=0;i3<filtrelenmiskomut.length();i3++) {
							if(filtrelenmiskomut.charAt(i3)== '+' || filtrelenmiskomut.charAt(i3)=='-' || filtrelenmiskomut.charAt(i3)=='*' || filtrelenmiskomut.charAt(i3)=='/') {
								
								if(filtrelenmiskomut.charAt(i3)=='/') {
									Sayi1 = new BigDecimal(filtrelenmiskomut.substring(0, i3));
									Sayi2 = new BigDecimal(filtrelenmiskomut.substring(i3+1, filtrelenmiskomut.length()));
									
								}
								else {
									Sayi1 = new BigDecimal(filtrelenmiskomut.substring(0, i3));
									Sayi2 = new BigDecimal(filtrelenmiskomut.substring(i3+1, filtrelenmiskomut.length()));
									
								}
						
								
								
								if(filtrelenmiskomut.charAt(i3)== '+') {
									BigDecimal toplam = Sayi1.add(Sayi2);
									System.out.println("Sonu� : "+toplam);
									
								}
								else if(filtrelenmiskomut.charAt(i3)== '-') {
									BigDecimal ��karma = Sayi1.subtract(Sayi2);
									System.out.println("Sonu� : "+��karma);
								
								}
								else if(filtrelenmiskomut.charAt(i3)== '*') {
									BigDecimal �arp�m = Sayi1.multiply(Sayi2);
									System.out.println("Sonu� : "+�arp�m);
								
								}
								else if(filtrelenmiskomut.charAt(i3)== '/') {
									BigDecimal B�lme = Sayi1.divide(Sayi2,10, RoundingMode.HALF_UP);
									BigDecimal B�lmeOndal�kKontrol = B�lme.stripTrailingZeros();
									
									if (B�lme.stripTrailingZeros().scale() <= 0) {
							            // E�er ondal�k k�s�m s�f�rsa, ondal�k k�sm� yazd�rma
							            System.out.println("Sonu� : " + B�lme.setScale(0));
							        } else {
							            System.out.println("Sonu� : " + B�lmeOndal�kKontrol);
							        }
								
								}
								
						}
							
							
							
				
			}
			}
			
			
		}
	}
	
		}

