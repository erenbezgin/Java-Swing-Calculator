
public class BirBoluX extends Islem {

	@Override
	public double hesapla(double... sayilar) {
		double sayi=sayilar[0];
		if(sayi==0) {
			throw new ArithmeticException("Sıfırın tersi alınamaz!");
		}
		return 1.0/sayi;
	}

}
