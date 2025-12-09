
public class NegatifYap extends Islem{

	@Override
	public double hesapla(double... sayilar) {
		// tek bir sayi alacaz -1 ile carpcaz
		if(sayilar.length==0)return 0;
		
		return sayilar[0]*-1;
	}

}
