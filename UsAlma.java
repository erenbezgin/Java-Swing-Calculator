
public class UsAlma extends Islem {

	@Override
	public double hesapla(double... sayilar) {
		// üs almada iki sayi isteyecez
		if(sayilar.length<2)return 0;
		double tavan=sayilar[0];
		double us=sayilar[1];
		return Math.pow(tavan, us);
	}

}
