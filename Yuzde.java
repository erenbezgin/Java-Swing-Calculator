
public class Yuzde extends Islem {

	@Override
	public double hesapla(double... sayilar) {
		//formul (sayi * yüzdeorani) / 100
		if(sayilar.length<2)return 0;
		
		double sayi=sayilar[0];
		double yüzde=sayilar[1];
		
		return (sayi*yüzde)/100;
	}

}
