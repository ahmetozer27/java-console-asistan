package Asistan_Eklentileri;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Komutu_Anlama {

	

	public static void main(String[] args) {
		//matematiksel i�lemleri anlas�n
		String komut ="hkba1wdjhkaw 156  /12    ";
		for(int i=0;i<komut.length();i++) {
			
			
			if(komut.charAt(i)== '+' || komut.charAt(i)=='-' || komut.charAt(i)=='x' || komut.charAt(i)=='*' || komut.charAt(i)=='/') {
				BigInteger Sayi1 = null,Sayi2 = null;
				BigDecimal Sayi3 = null,Sayi4 = null;
				//+ dan �nceki say�y� bulduk
				for(int i2=0;i2<i;i2++) {
					int temp1=i;
					if(Character.isDigit(komut.charAt(i2))) { //isdigit say� olup olmad���n� kontrol ediyor						
						
						if(komut.charAt(i)=='/') {
						Sayi3 = new BigDecimal(komut.substring(i2, temp1).trim());
						
						break;
						}
						else {
						Sayi1 = new BigInteger(komut.substring(i2, temp1).trim());
						
						break;
						}
						}
					
					}
				
				
				//+ dan sonraki say�y� bulduk
				for(int i3=i+1;i3<komut.length();i3++) {
					if(!Character.isDigit(komut.charAt(i3)) ){
						if(komut.charAt(i)=='/') {
							Sayi4 = new BigDecimal(komut.substring(i+1, i3).trim());
							System.out.println(Sayi4);
							break;
							}
						else {
						Sayi2 = new BigInteger(komut.substring(i+1, i3).trim());
						
						break;
							}
					}else {
						if(komut.charAt(i)=='/') {
							Sayi4 = new BigDecimal(komut.substring(i+1, komut.length()).trim());
							System.out.println(Sayi4);
							
							break;
						}else {
						Sayi2 = new BigInteger(komut.substring(i+1, komut.length()).trim());
						
						break;
						}
					}
				}
				
				
				if(komut.charAt(i)== '+') {
					BigInteger Toplam = Sayi1.add(Sayi2);
					System.out.println("Sonu� : "+Toplam);
				}
				else if(komut.charAt(i)== '-') {
					BigInteger ��kartma = Sayi1.subtract(Sayi2);
					System.out.println("Sonu� : "+��kartma);
				}
				else if(komut.charAt(i)== '*' || komut.charAt(i)== 'x') {
					BigInteger �arpma = Sayi1.multiply(Sayi2);
					System.out.println("Sonu� : "+�arpma);
				}
				else if(komut.charAt(i)== '/') {
					BigDecimal B�lme = Sayi3.divide(Sayi4,10, RoundingMode.HALF_UP);
					BigDecimal B�lmeOndal�kKontrol = B�lme.stripTrailingZeros(); //ondal�k k�sm�ndaki 0 lar� siliyor
					
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
