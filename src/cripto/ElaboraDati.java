package cripto;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;



/**
 *
 */
public class ElaboraDati {

	
	
	static String folder = "c:/Temp/sincro penna/";
	static String matrice[][] = {
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""},
			{"","","","","","","","","","","","",""}};

	/**
	 * verifica la lista di giocatori che sono il risultato della query di ricerca mercato.
	 * 1) carica le info principali (pid, eta, valore, offerta, skill ...
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param codFile
	 * @param budgetDedicato
	 * @throws IOException
	 */
	
	public static void main(String args[]){
		try{
		ElaboraDati.cripta(folder,"prova.txt", null, 0);
		ElaboraDati.decripta(folder,"cript.prova.txt", null, 0);
		}catch (Exception e)
		{
			System.err.println(e);
			}
	}
		
		
		
		
	
	public static void cripta( String folder,String codFile, String budgetDedicato, int numFiltro)
	throws IOException {

		


		Date date1 = new Date();
		System.out.println("---------------------------------------------------------------");
		System.out.println(date1+" elaborazione "+codFile);
		System.out.println("---------------------------------------------------------------");


		

		File fin = new File(folder+codFile);
		FileInputStream fis = new FileInputStream(fin);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		File fout = new File(folder+"cript."+codFile	);
		FileOutputStream fos = new FileOutputStream(fout);
		PrintStream ps = new PrintStream(fos);
		
		
		boolean continua = true;
		
		String appo = "";
		
		
		
		
		int x=0;
		int y=0;
		int j=0;
		int cont = 0;
		int conty = 0;
		int contToken = 0;
		String carattere="";
		while(continua){
			
			while(appo.length()<120){
				try{
					String nextchar = br.readLine();
				
				if(nextchar==null)
					return;
				else {
					nextchar= nextchar.toUpperCase()+" ";
				/*	nextchar=nextchar.replaceAll("J", "I");  */
					
					appo += nextchar;
					appo = appo.replaceAll(" ", "X");
					
				/*	appo = appo.replaceAll(",", " COMMA ");
					appo = appo.replaceAll("[.]+"," STOP ");
					
					appo = appo.replaceAll("\n", " ");
					
					appo = appo.replaceAll(" ", "J"); */
				}
				//System.out.println(appo);
				}catch(StringIndexOutOfBoundsException e){
					System.exit(0);
					//appo+="ENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDEND";
				}
				}
			
			//appo = appo.replaceAll("\n", " ");
			//appo = appo.replaceAll(",", " ");
			//appo = appo.replaceAll(".", "X");
			appo = appo.toUpperCase();
			
			int len = appo.length();
			j=0;
			//ps.println(appo.toUpperCase());
			
			
				
				while(x<10){
					while(y<10){
						carattere = appo.substring(j,j+1);
						//System.out.print("*"+carattere+"*");
						int c = carattere.charAt(0)-65; //0 25
						c =((c+y+1) % 26)+65;
						
						String carattere2= String.valueOf((char)c);
						matrice[x][y]= carattere2;
						System.out.print(carattere2);
						y++;
						j++;
					}
					y=0;
					x++;
				}
			x=0;y=0;
			System.out.println();
			System.out.println();
			System.out.println();
			while(x<10){
				while(y<10){
					carattere =matrice[y][x];
					
					ps.print(carattere);
					System.out.print(matrice[y][x]);
					
					conty++;
					
					y++;
					j++;
					if (conty>=5 ){
						ps.print(" ");
						System.out.print(" ");
						conty=0;
						contToken++;
						if (contToken>=10 ){
							System.out.println();
							ps.println();
							
							contToken=0;
						}
					}
				}
				
				y=0;
				x++;
				
				
			}
			appo = appo.substring(100);
			continua = true;
			x=0;
			y=0;
			
			//conty=0;
			j=0;
			
			
		}	
		fis.close();	
		ps.flush();
		ps.close();
		fos.close();
		
		

	}

	public static void decripta( String folder,String codFile, String budgetDedicato, int numFiltro)
	throws IOException {

		


		Date date1 = new Date();
		System.out.println("---------------------------------------------------------------");
		System.out.println(date1+" elaborazione "+codFile);
		System.out.println("---------------------------------------------------------------");


		

		File fin = new File(folder+codFile);
		FileInputStream fis = new FileInputStream(fin);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		File fout = new File(folder+"decript."+codFile	);
		FileOutputStream fos = new FileOutputStream(fout);
		PrintStream ps = new PrintStream(fos);
		
		
		boolean continua = true;
		
		String appo = "";
	
		
		
		
		int x=0;
		int y=0;
		int j=0;
		int cont = 0;
		int conty = 0;
		String carattere="";
		while(continua){
			
			while(appo.length()<120){
				try{
					String nextchar = br.readLine();
				
				if(nextchar==null)return;
				else {
					appo += nextchar;
					appo = appo.replaceAll("\n", "");//toglie spazi indentazione
					//appo = appo.replaceAll("-", "");//mette spazi reali
					//appo = appo.replaceAll("J", " ");//mette spazi reali
					appo = appo.replaceAll(" ", "");
					
				}
				//System.out.println(appo);
				}catch(StringIndexOutOfBoundsException e){
					System.exit(0);
					//appo+="ENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDENDEND";
				}
				}
			
			//appo = appo.replaceAll(" ", "X");
			
			appo = appo.toUpperCase();
			
			int len = appo.length();
			j=0;
			//ps.println(appo.toUpperCase());
			
			
				
				while(x<10){
					while(y<10){
						carattere = appo.substring(j,j+1);
						
						
						//System.out.print("*"+carattere+"*");
						int c = carattere.charAt(0)-65; //0 25
						c =((c-(x+1)) % 26);
						if (c<0) c=c+ 25 ;
						c+=65;
						
						String carattere2= String.valueOf((char)c);
						
						
						if ("W".equals(carattere2)) carattere2 = " ";
						matrice[x][y]= carattere2;
						System.out.print(carattere2);
						y++;
						j++;
					}
					System.out.println();
					y=0;
					x++;
				}
			x=0;y=0;
			System.out.println();
			
			while(y<10){
				while(x<10){
					String cc=matrice[x][y];
					ps.print(matrice[x][y]);
					System.out.print(matrice[x][y]);
					
					cont++;
					x++;
					j++;
					if (cont>=60){
						
					    	ps.println();
							cont=0;
						
					}
				}
				System.out.println();
				conty++;
				x=0;
				y++;
				if (conty>=60){
				
					ps.print("\n");
					conty=0;
				}
				
			}
			System.out.print("\n");
			appo = appo.substring(100);
			continua = true;
			x=0;
			y=0;
			cont=0;
			conty=0;
			j=0;
			
			
		}	
		fis.close();	
		ps.flush();
		ps.close();
		fos.close();
		
		

	}

	public static int CharToASCII(final char character){
		return (int)character;
	}
 
	/**
	 * Convert the ASCII value to character
	 * @param ascii ascii value
	 * @return character value
	 */
	public static char ASCIIToChar(final int ascii){
		return (char)ascii;		
	}

}
