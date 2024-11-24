package Asistan_Eklentileri;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Komutu_AnlamaV2 {

	public static void main(String[] args) {
		String komut ="1+2 kaçtýr?    ";
		for(int i=0;i<komut.length();i++) {
			if(komut.charAt(i)== '+' || komut.charAt(i)=='-' || komut.charAt(i)=='*' || komut.charAt(i)=='/') {
				String tutulacakKarakterler="+-*/0123456789";
				BigDecimal Sayi1 = null,Sayi2 = null;
				
				StringBuilder filtrelenmiskomut = new StringBuilder();
						for (int i2 = 0; i2 < komut.length(); i2++) {
				            char karakter = komut.charAt(i2);

				            // Tutulacak karakterler içinde olanlarý ekleyin
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
									System.out.println("Sonuç : "+toplam);
									
								}
								else if(filtrelenmiskomut.charAt(i3)== '-') {
									BigDecimal çýkarma = Sayi1.subtract(Sayi2);
									System.out.println("Sonuç : "+çýkarma);
								
								}
								else if(filtrelenmiskomut.charAt(i3)== '*') {
									BigDecimal çarpým = Sayi1.multiply(Sayi2);
									System.out.println("Sonuç : "+çarpým);
								
								}
								else if(filtrelenmiskomut.charAt(i3)== '/') {
									BigDecimal Bölme = Sayi1.divide(Sayi2,10, RoundingMode.HALF_UP);
									BigDecimal BölmeOndalýkKontrol = Bölme.stripTrailingZeros();
									
									if (Bölme.stripTrailingZeros().scale() <= 0) {
							            // Eðer ondalýk kýsým sýfýrsa, ondalýk kýsmý yazdýrma
							            System.out.println("Sonuç : " + Bölme.setScale(0));
							        } else {
							            System.out.println("Sonuç : " + BölmeOndalýkKontrol);
							        }
								
								}
								
						}
							
							
							
				
			}
			}
			
			
		}
	}
	
		}

