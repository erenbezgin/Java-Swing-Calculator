
public class Toplama extends Islem {
	@Override
	public double hesapla(double ...sayilar) {
		double toplam=0;
		//bütün sayıları tek tek gezmek için foreach döngüsü
		for (double sayi:sayilar) {
			toplam+=sayi;//toplaya toplaya gidecez 
		}
		return toplam;
	}
	

}
