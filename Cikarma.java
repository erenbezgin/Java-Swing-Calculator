public class Cikarma extends Islem {
	
@Override
public double hesapla(double... sayilar) {
//eger hiçsayı gelmezse islem yapmamak icin 
	if(sayilar.length==0);
	//ilk sayinin basa gelmesi için dizinin ilk elemanı başa gelecek 
	double sonuc=sayilar[0];
	// birinci sayidan baslayip sonuna kadar digerlerinden cikariyoz 
	for (int i=1;i<sayilar.length;i++) {
		sonuc-=sayilar[i];
	}
	return sonuc;
}
}