import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HesapMakinesi extends JFrame implements ActionListener {

   //eclips ekledi
	private static final long serialVersionUID = 1L;
	
    final Color arkaplan = new Color(32, 32, 32);      
    final Color butonkoyu = new Color(59, 59, 59);     
    final Color butonislem = new Color(50, 50, 50);    
    final Color butonmavi = new Color(255, 255, 255); 
    final Color yazirengi = Color.WHITE;               

    // Bilesenler
    JLabel ekranyazisi; 
    JPanel tuspaneli;   
    
    // Hafiza 
    double birincisayi = 0; 
    Islem suankiIslem = null; 
    boolean yenisayigirilecek = true; 

    // ana metot 
    public static void main(String[] args) {
        new HesapMakinesi(); 
    }
    
    // kurucu metot 
    public HesapMakinesi() {
        setTitle("Hesap Makinesi");
        setSize(360, 550); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(true);
        
        // ekran oluşturuyoruz  
        ekranyazisi = new JLabel("0"); 
        ekranyazisi.setFont(new Font("Segoe UI", Font.BOLD, 48)); 
        ekranyazisi.setForeground(yazirengi); 
        ekranyazisi.setHorizontalAlignment(SwingConstants.RIGHT); 
        ekranyazisi.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        ekranyazisi.setOpaque(true); 
        ekranyazisi.setBackground(arkaplan);
        
        add(ekranyazisi, BorderLayout.NORTH);
        
        // tus paneli
        tuspaneli = new JPanel();
       
        tuspaneli.setLayout(new GridLayout(6, 4, 5, 5)); 
        tuspaneli.setBackground(arkaplan);
        
        //butonlar 
        tuspaneli.add(ozelButonOlustur("%", butonislem));
        tuspaneli.add(ozelButonOlustur("CE", butonislem));
        tuspaneli.add(ozelButonOlustur("C", butonislem));
        tuspaneli.add(ozelButonOlustur("Sil", butonislem));

        tuspaneli.add(ozelButonOlustur("1/x", butonislem));
        tuspaneli.add(ozelButonOlustur("x²", butonislem));
        tuspaneli.add(ozelButonOlustur("√x", butonislem));
        tuspaneli.add(ozelButonOlustur("/", butonislem));

        tuspaneli.add(ozelButonOlustur("7", butonkoyu));
        tuspaneli.add(ozelButonOlustur("8", butonkoyu));
        tuspaneli.add(ozelButonOlustur("9", butonkoyu));
        tuspaneli.add(ozelButonOlustur("×", butonislem));

        tuspaneli.add(ozelButonOlustur("4", butonkoyu));
        tuspaneli.add(ozelButonOlustur("5", butonkoyu));
        tuspaneli.add(ozelButonOlustur("6", butonkoyu));
        tuspaneli.add(ozelButonOlustur("-", butonislem));

        tuspaneli.add(ozelButonOlustur("1", butonkoyu));
        tuspaneli.add(ozelButonOlustur("2", butonkoyu));
        tuspaneli.add(ozelButonOlustur("3", butonkoyu));
        tuspaneli.add(ozelButonOlustur("+", butonislem));

        tuspaneli.add(ozelButonOlustur("+/-", butonkoyu));
        tuspaneli.add(ozelButonOlustur("0", butonkoyu));
        tuspaneli.add(ozelButonOlustur(".", butonkoyu));
        tuspaneli.add(ozelButonOlustur("=", butonmavi)); 

        add(tuspaneli, BorderLayout.CENTER);
        setVisible(true);
    }

    
    private JButton ozelButonOlustur(String yazi, Color renk) {
        JButton buton = new JButton(yazi);
        buton.setFont(new Font("Segoe UI", Font.PLAIN, 20)); 
        buton.setBackground(renk);     
        if (yazi.equals("=")) {
            buton.setForeground(Color.BLACK); 
        } else {
            buton.setForeground(Color.WHITE);
        } 
        buton.setFocusPainted(false);  
        buton.setBorder(BorderFactory.createLineBorder(arkaplan)); 
        buton.addActionListener(this); 
        return buton;
    }

    //tusa basinca 
    @Override
    public void actionPerformed(ActionEvent e) {
        String komut = e.getActionCommand(); 

        // Rakamlar
        if ("0123456789".contains(komut)) {
            if (yenisayigirilecek || ekranyazisi.getText().equals("0")) {
                ekranyazisi.setText("");
                yenisayigirilecek = false;
            }
            ekranyazisi.setText(ekranyazisi.getText() + komut);
        }
        
        // Virgül
        else if (komut.equals(".")) {
            if (!ekranyazisi.getText().contains(".")) {
                ekranyazisi.setText(ekranyazisi.getText() + ".");
            }
        }

        // Temizleme
        else if (komut.equals("C")) {
            ekranyazisi.setText("0");
            birincisayi = 0;
            suankiIslem = null;
        }
        else if (komut.equals("CE")) {
            ekranyazisi.setText("0"); 
        }
        else if (komut.equals("Sil")) {
            String yazi = ekranyazisi.getText();
            if (yazi.length() > 0) {
                yazi = yazi.substring(0, yazi.length() - 1);
                if (yazi.isEmpty()) yazi = "0";
                ekranyazisi.setText(yazi);
            }
        }

        // Eşittir
        else if (komut.equals("=")) {
            if (suankiIslem != null) {
                try {
                    double ikinciSayi = Double.parseDouble(ekranyazisi.getText());
                    double sonuc = suankiIslem.hesapla(birincisayi, ikinciSayi);
                    sonucuEkranaYaz(sonuc);
                    birincisayi = sonuc; 
                    suankiIslem = null;
                    yenisayigirilecek = true;
                } catch (Exception hata) {
                    ekranyazisi.setText("Hata");
                }
            }
        }

        // İşlemler
        else {
            double ekranDegeri = 0;
            try {
                ekranDegeri = Double.parseDouble(ekranyazisi.getText());
            } catch (NumberFormatException ex) { return; }

            if (komut.equals("+")) {
                birincisayi = ekranDegeri;
                suankiIslem = new Toplama();
                yenisayigirilecek = true;
            }
            else if (komut.equals("-")) {
                birincisayi = ekranDegeri;
                suankiIslem = new Cikarma();
                yenisayigirilecek = true;
            }
            else if (komut.equals("×")) {
                birincisayi = ekranDegeri;
                suankiIslem = new Carpma();
                yenisayigirilecek = true;
            }
            else if (komut.equals("/")) {
                birincisayi = ekranDegeri;
                suankiIslem = new Bolme();
                yenisayigirilecek = true;
            }
            else {
                // Tek tuşlu işlemler
                try {
                    double anlikSonuc = 0;
                    if (komut.equals("√x")) anlikSonuc = new Karekok().hesapla(ekranDegeri);
                    else if (komut.equals("x²")) anlikSonuc = new UsAlma().hesapla(ekranDegeri, 2);
                    else if (komut.equals("1/x")) anlikSonuc = new BirBoluX().hesapla(ekranDegeri);
                    else if (komut.equals("+/-")) anlikSonuc = new NegatifYap().hesapla(ekranDegeri);
                    else if (komut.equals("%")) anlikSonuc = ekranDegeri / 100.0; // Yüzdeyi basit hesaplayalım

                    sonucuEkranaYaz(anlikSonuc);
                    yenisayigirilecek = true; 

                } catch (Exception hata) {
                    ekranyazisi.setText("Hata");
                }
            }
        }
    }

    private void sonucuEkranaYaz(double sayi) {
        if (sayi % 1 == 0) {
            ekranyazisi.setText(String.valueOf((int) sayi));
        } else {
            ekranyazisi.setText(String.valueOf(sayi));
        }
    }
}