public class Karekok extends Islem {

    @Override
    public double hesapla(double... sayilar) {
       
        double sayi = sayilar[0];

        // Negatif sayıların karekökü yok var ama ben almıyorun aq 
        if (sayi < 0) {
            throw new ArithmeticException("Negatif sayının karekökü alınamaz!");
        }
        return Math.sqrt(sayi);
    }
}