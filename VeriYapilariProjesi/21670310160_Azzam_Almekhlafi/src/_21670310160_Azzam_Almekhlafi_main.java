import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _21670310160_Azzam_Almekhlafi_main {
		
		 
		 public static void main(String[] args) {
			 @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
             
			 System.out.print("Hangi dosya okumak istersiniz ornek2.txt mi yada ornek1.txt mi :");
			   
			 String file = sc.nextLine();
			 
			  File inputFile = new File(file);
		        try {
		        	 
		        	 int l=0,g=0,h=0;
		             if (file.equals("ornek2.txt")) {
		                 l=2; g=4; h=3;
		             } else if (file.equals("ornek1.txt")) {
		                 l=4; g=4; h=4;
		             }

		            Scanner scanner = new Scanner(inputFile);
		            scanner.nextLine();
		            scanner.nextLine();
					//karnof haritasi okumak icin
		           
		            boolean[][] kmap = new boolean[l][ g];
		            for (int i = 0; i < l; i++) { 
			            int k=0;
		                String line = scanner.nextLine();
		                for (int j = 0; j < g; j++) {
		                	
		                    char c = line.charAt(j+k );

		                    kmap[i][j] = (c == '1');

		                    k++;
		                }
		            }
		            
		            
		           
		            
		           if(h==3) {System.out.println("A \tB\tC\tOutput");}else if (h==4) {
			            System.out.println("x \t y \t z \t t \t Output");
		           }
		                  //duruluk tablosu olusturmak icin   
		           
		            boolean[][]  min = new boolean [(int) Math.pow(2, h)][h+1]; 
		            int y =0;
		            int k=0;
		          
		             
		            for (int i = 0; i < l; i++) {
		                for (int j = 0; j < g; j++) {
		                	if(h==3) {
		                	int a = i;
		                    int b = j / 2;
		                    int c = j % 2;
		                    
		                    min[k][0]= (a == 1) ? true : false;
		                    min[k][1]= (b == 1) ? true : false;
		                    min[k][2]= (c == 1) ? true : false;
		                   
		                    
		                    switch (y) {
		                    case 0 :
		                    	min [0][3] = kmap[i][j]  ;

		                    case 1:
		                    	min [1][3] = kmap[i][j]  ;

		                    case 2:
		                    	min [3][3] = kmap[i][j]  ;

		                    case 3:
		                    	min [2][3] = kmap[i][j]  ;

		                    case 4:
		                    	min [4][3] = kmap[i][j]  ;

		                    case 5:
		                    	min [5][3] = kmap[i][j]  ;
		                       

		                    case 6:
		                    	min [7][3] = kmap[i][j]  ;
		                        

		                    case 7:
		                    	min [6][3] = kmap[i][j]  ;
		                    	
		                    
		                        

		                        break;

		                    }
		                    

		                    k++;
		                    y++;
		                }  else if(h==4) {
		                	boolean a, b, c, d;
		                	
		                        a = (y & 8) != 0;
		                        min[y][0]=a;
		                        b = (y & 4) != 0;
                        		min[y][1]=b;

		                        c = (y & 2) != 0;
		                        min[y][2]=c;

		                        d = (y & 1) != 0;
		                        min[y][3]=d;

		                	switch(y) {
		                	case 0:
		                		min[0][4]=kmap[i][j];
		                	case 1:
		                		min [1][4]=kmap[i][j];
		                	case 2:
		                		min[3][4]=kmap[i][j];
		                	case 3:
		                		min [2][4]=kmap[i][j];
		                	case 4:
		                		min[4][4]=kmap[i][j];
		                	case 5:
		                		min [5][4]=kmap[i][j];
		                	case 6:	
		                		min[7][4]=kmap[i][j];
		                	case 7:
		                		min [6][4]=kmap[i][j];
		                	case 8:
		                		min [12][4]=kmap[i][j];
		                	case 9:
		                		min [13][4]=kmap[i][j];
		                	case 10:
		                		min [15][4]=kmap[i][j];
		                	case 11:
		                		min [14][4]=kmap[i][j];
		                	case 12:
		                		min [8][4]=kmap[i][j];
		                	case 13:
		                		min [9][4]=kmap[i][j];
		                	case 14:
		                		min [11][4]=kmap[i][j];
		                	case 15:
		                		min [10][4]=kmap[i][j];


		                		break;



		                	}
		                	
		                	 k++;
			                    y++;
		                	
		                	}
		                }
		                
		            }
		            //doruluk tablusu yaz
		            for(int i=0; i< min.length; i++){
		            	for(int j=0; j<h+1; j++)
		            	
		            {   
	                    System.out.print(min[i][j]+"\t");
	
		            } 
		            System.out.println();
		            }
		            System.out.println();

		            //Boole fonksiyonunun minterimlerin toplami ve maksterimlerin çarpimi olusturmak icin
		            
		            String minterms = "";
		            String maxterms = "";
		            
		            for (int i = 0; i < min.length; i++) {
		            	boolean dort=false;
		            	boolean f=false;
		                boolean bir = min[i][0];
		                boolean iki = min[i][1];
		                boolean uc = min[i][2];
		                
		                if(h==4) { dort = min[i][3];
		                 f= min[i][4];
		                }else if(h==3) { f=min[i][3];}
		                if(h==3) {
		                if (f == true) {
		                    minterms += (bir == false ? "A'" : "A") + (iki == false ? "B'" : "B") + (uc == false? "C'" : "C") + " + ";
		                } else {
		                    maxterms += (bir == false ? "A" : "A'") + "+" + (iki == false ? "B" : "B'") + "+" + (uc == false ? "C" : "C'") + " * ";
		                }}else if(h==4) {
		                	if (f == true) {
			                    minterms += (bir == false ? "x'" : "x") + (iki == false ? "y'" : "y") + (uc == false? "z'" : "z") +(dort == false? "t'" : "t")+ " + ";
			                } else {
			                    maxterms += (bir == false ? "x" : "x'") + "+" + (iki == false ? "y" : "y'") + "+" + (uc == false ? "z" : "z'") +(dort == false? "t" : "t'")+ " * ";
			                }
		                	
		                }
		            }
		            System.out.println();

		            minterms = minterms.substring(0, minterms.length() - 3);
		            maxterms = maxterms.substring(0, maxterms.length() - 3);
		            
		            System.out.println("Minterms toplami : " + minterms);
		            System.out.println("Maxterms çarpimi : " + maxterms);
		            
		            
		            // fonksiyonunun tumleyeninin minterimlerin toplami ve maksterimlerin çarpimi olusturmak icin

		            String mintermsTum = "";
		            String maxtermsTum = "";
		            
		            for (int i = 0; i < min.length; i++) {
		            	boolean dort1=false;
		            	boolean f1=false;
		            	boolean bir1 = min[i][0];
		                boolean iki1= min[i][1];
		                boolean uc1 = min[i][2];
		                if(h==4) { dort1 = min[i][3];
		                 f1= min[i][4];
		                }else if(h==3) { f1=min[i][3];}
		                
		                if(h==3) {
		                if (f1 == false ) {
		                	mintermsTum += (bir1 == false ? "A'" : "A") + (iki1 == false ? "B'" : "B") + (uc1 == false? "C'" : "C") + " + ";
		                } else {
		                    maxtermsTum += (bir1 == false ? "A" : "A'") + "+" + (iki1 == false ? "B" : "B'") + "+" + (uc1 == false ? "C" : "C'") + " * ";
		                } } else if(h==4) {
		                	if (f1 == false ) {
			                	mintermsTum += (bir1 == false ? "x'" : "x") + (iki1 == false ? "y'" : "y") + (uc1 == false? "z'" : "z") +(dort1 == false? "t'" : "t")+ " + ";
			                } else {
			                    maxtermsTum += (bir1 == false ? "x" : "x'") + "+" + (iki1 == false ? "y" : "y'") + "+" + (uc1 == false ? "z" : "z'") +(dort1 == false? "t" : "t'") + " * ";
			                }
		                }
		            }
		            System.out.println();

		           mintermsTum = mintermsTum.substring(0, mintermsTum.length() - 3);
		            maxtermsTum = maxtermsTum.substring(0, maxtermsTum.length() - 3);
		            
		            System.out.println("tümleyeninin minterimlerin toplami: " + mintermsTum);
		            System.out.println(" tümleyeninin maksterimlerin çarpimi: " + maxtermsTum);

		            	
		            	
		            scanner.close();
		        } catch (FileNotFoundException e) {
		            System.out.println("File not found!");
		            e.printStackTrace();
		        }
		    }
		
		 
		 
		 
		}
		