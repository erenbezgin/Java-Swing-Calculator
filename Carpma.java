public class Carpma extends Islem {

	@Override
	public double hesapla(double... sayilar) {
		if(sayilar.length==0)return 0;
		//carpma etkisis elaman 1 
		double sonuc=1;
		//foreach çünkü sıra sıra bütün ayıları gezerek yapcaz
		for (double sayi:sayilar) {
			sonuc*=sayi;//sırayla hepsini carpcaz
		}
		return sonuc;
	}

}
