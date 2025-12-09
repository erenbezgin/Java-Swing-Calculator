// islemi abstac olarak tanımlıyorum çünkü alt sınıflar kullanacak değerleri 
public abstract class Islem {
// double ... sayilar demek bura virgülle ayrılarak istenildiği kadar sayi girile bilir demek 
	// örn hesapla(10,20) yada hesapla (10,20,30,40) gibi 
	public abstract double hesapla(double... sayilar);
}
