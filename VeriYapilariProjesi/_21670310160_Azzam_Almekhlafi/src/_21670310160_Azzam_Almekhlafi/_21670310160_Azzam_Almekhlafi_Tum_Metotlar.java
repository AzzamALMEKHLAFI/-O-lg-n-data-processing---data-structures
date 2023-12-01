	package _21670310160_Azzam_Almekhlafi;

import java.util.Scanner;

public class _21670310160_Azzam_Almekhlafi_Tum_Metotlar {
	
	int heap_size=0;
	private _21670310160_Azzam_Almekhlafi_Kayit[] array=new _21670310160_Azzam_Almekhlafi_Kayit [2500];
	
	
	public int Parent(int i) {
		return (i-1)/2;
		}
	
	public   void Max_heapify(int i) {
		int largest=i;
		int left = 2*i+1;
		int right=2*i+2;
		if(left<heap_size && array[left].getTc()>array[largest].getTc())
			largest=left;
		if(right<heap_size && array[right].getTc()>array[largest].getTc())
			largest=right;
		if(largest != i) {
			_21670310160_Azzam_Almekhlafi_Kayit temp=array[i];
			array[i]=array[largest];
			array[largest]=temp;
			Max_heapify(largest);
		}
	}

	public _21670310160_Azzam_Almekhlafi_Kayit Delete_pos(int index) {
		 int SonKayit = heap_size - 1;
		 int ilkindex= index;
		 if(index<0 || index>SonKayit) {return null;}
		 _21670310160_Azzam_Almekhlafi_Kayit SilenecekKayit = this.array[index];
		 this.array[index] = this.array[SonKayit];
		 this.array[SonKayit]=null;
			int parent = Parent(index);
		 while(this.array[parent].getTc() < this.array[index].getTc()) {
			 _21670310160_Azzam_Almekhlafi_Kayit temp=this.array[index];
				array[parent]= this.array[index];
				this.array[index]=temp;
				
				index = parent;
				parent=(index-1)/2;
		 }
		 if(ilkindex==index)
			 Max_heapify(index);
		 this.heap_size--;
			return SilenecekKayit;

			
	}
	 
	 public _21670310160_Azzam_Almekhlafi_Kayit Delete(long TcKimlik) {
		 int j = -1;
		 
		 for (int i = 0; i < this.heap_size; i++) {
		if(TcKimlik==this.array[i].getTc()){
			j=i;
			break;
	}
		}
		 _21670310160_Azzam_Almekhlafi_Kayit  silinmiskayit= Delete_pos(j);
		return silinmiskayit; 
	 }
	 
	 public  void Insert (_21670310160_Azzam_Almekhlafi_Kayit kayit)  {
			int kindex = this.heap_size;
			this.array[kindex]=kayit;
			
			int pindex = kindex==0 ? 0 : (kindex - 1)/2;
			
		while (this.array[pindex].getTc()<this.array[kindex].getTc()) {
			_21670310160_Azzam_Almekhlafi_Kayit temp=this.array[pindex];
			this.array[pindex]= this.array[kindex];
			this.array[kindex]=temp;
			
			kindex = pindex;
			pindex = (kindex - 1)/2;
		}
			
			this.heap_size++;
		}
	 
	 public  void resize() {
		 int yeniSize= this.array.length*2;
			_21670310160_Azzam_Almekhlafi_Kayit[] temp= new _21670310160_Azzam_Almekhlafi_Kayit[yeniSize];
			
			for (int i = 0; i <= this.array.length-1; i++) {
				temp[i]=this.array[i];
			}
			this.array=temp;
			  
			 }
	 
	 
	public void print() {
		for (int i = 0; i < this.heap_size; i++) {
			System.out.println(this.array[i]);
		}		
	}
	
	public int Return_Seviye_Sayisi() {
		if(this.heap_size==0)
			return 0;
		int sayac=1;
		int SonElement=this.heap_size-1;
		int parent=Parent(SonElement);
		while(SonElement>0) {
			sayac++;
			SonElement=parent;
		 parent=Parent(SonElement);
		}
		return sayac;

	}
   
	
       public int Return_Kayit_Sayisi( ) {
		
		return this.heap_size;
	}
    public _21670310160_Azzam_Almekhlafi_Kayit Search(long TcKimlik){
    	for (int i = 0; i < this.heap_size; i++) {
    		if(this.array[i].getTc()==TcKimlik) {
    			return this.array[i]; 
    			}
		}
    	
		return null;	
    }
    
    public void Ekrana_Yazdir(_21670310160_Azzam_Almekhlafi_Kayit kayit) {
		System.out.println(kayit);
	}
    
    public _21670310160_Azzam_Almekhlafi_Kayit En_Buyuk_Kaydi_Cikar() {
    	long enBuyuk=this.array[0].getTc();
    	for(int i = 1; i<this.heap_size; i++) {
    		if(this.array[i].getTc() >enBuyuk) {
    			enBuyuk=this.array[i].getTc();}
    	}
    	_21670310160_Azzam_Almekhlafi_Kayit enBuyukKayt = Search(enBuyuk);
		return enBuyukKayt;
    	
    }
	

}
