package _21670310160_Azzam_Almekhlafi;

public class _21670310160_Azzam_Almekhlafi_Kayit {
	private long tcNO ;
	private String Adi="" ;
	private String Soyadi="" ;
	

	public _21670310160_Azzam_Almekhlafi_Kayit(long tcNO, String Adi, String Soyadi){
		this.tcNO=tcNO;
		this.Adi=Adi;
		this.Soyadi=Soyadi;		
	}
	
	public long getTc( ) {
		return tcNO;
	}
	public String getAdi( ) {
		return Adi;
	}
	public String getSoyadi( ) {
		return Soyadi;
	}
	public void setTc ( long NewTcNO) {
		this.tcNO = NewTcNO ; 
		}
	public void setAdi ( String NewAdi) {
		this.Adi = NewAdi ; 
		}

	public void setSoyadi (  String NewSoyadi ) {
		this.Soyadi = NewSoyadi ; 
		}
	public String toString() {
		return tcNO+","+ Adi+ ","+ Soyadi ;
	}


}
