
package _21670310160_Azzam_Almekhlafi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _21670310160_Azzam_Almekhlafi_Main1 {
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		
	
		File inputFile = new File ("C:\\Users\\hp\\OneDrive\\Documents\\GitHub\\BSM103_AzzamALMEKHLAFI\\Odev\\_21670310160_Azzam_Almekhlafi\\src\\_21670310160_Azzam_Almekhlafi\\text.txt");
		sc = new Scanner (inputFile);
		_21670310160_Azzam_Almekhlafi_Kayit kayit =new _21670310160_Azzam_Almekhlafi_Kayit (0 , ""  ,"");
		 _21670310160_Azzam_Almekhlafi_Tum_Metotlar getir=new _21670310160_Azzam_Almekhlafi_Tum_Metotlar();

		StringTokenizer alan=null;
		long TcKimlik=0;
		String TamAdi="";
		String TAmSoyadi="";
		
			int i=0 ;

			while(sc.hasNextLine() && i<2500 ){
				alan=new StringTokenizer(sc.nextLine(), ",");
				TcKimlik=Long.parseLong(alan.nextToken());
				TamAdi=alan.nextToken();
				TAmSoyadi=alan.nextToken();

				 kayit =new _21670310160_Azzam_Almekhlafi_Kayit(TcKimlik,TamAdi,TAmSoyadi);
				 getir.Insert(kayit);
						i++;
						
			}
			getir.resize();

			int j=0;
			while(sc.hasNextLine() && j<5000 ){
				alan=new StringTokenizer(sc.nextLine(), ",");
				TcKimlik=Long.parseLong(alan.nextToken());
				TamAdi=alan.nextToken();
				TAmSoyadi=alan.nextToken();

				kayit =new _21670310160_Azzam_Almekhlafi_Kayit(TcKimlik,TamAdi,TAmSoyadi);
				if(j>=2500)
				 getir.Insert(kayit);
			j++;	 
			}
			System.out.println(getir.Return_Kayit_Sayisi());
			_21670310160_Azzam_Almekhlafi_Kayit gerilenTckimlikKaydi = getir.Delete(7756591263L);
			getir.Ekrana_Yazdir(gerilenTckimlikKaydi);
			System.out.println(getir.Return_Kayit_Sayisi());
			_21670310160_Azzam_Almekhlafi_Kayit en_Buyuk_kayit= getir.En_Buyuk_Kaydi_Cikar();
			getir.Ekrana_Yazdir(en_Buyuk_kayit);
			_21670310160_Azzam_Almekhlafi_Kayit silinenKayit =getir.Delete_pos(43);
			getir.Ekrana_Yazdir(silinenKayit);
			_21670310160_Azzam_Almekhlafi_Kayit arama= getir.Search(9377761894L);
			getir.Ekrana_Yazdir(arama);
			System.out.println(getir.Return_Seviye_Sayisi());
			//getir.print();

			

	}

	





}
