
public class Bolme extends Islem{

	@Override
	public double hesapla(double... sayilar) {
		if(sayilar.length==0)return 0;
		double sonuc=sayilar[0];//ilk sayiyi alcaz
		for (int i=1;i<sayilar.length;i++) {
			if(sayilar[i]==0) {
				throw new ArithmeticException("Bir sayı sıfıra bölünemez!");
			}
			sonuc/=sayilar[1];
		}
		return sonuc;
	}

}
