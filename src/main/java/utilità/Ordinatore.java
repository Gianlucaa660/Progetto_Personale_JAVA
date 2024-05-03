/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilità;

import com.mycompany._garagemotociclette.Motocicletta;

/**
 * Classe che contiene metodi statici per ordinare dei vettori
 * @author Studente
 */
public class Ordinatore
{
    /**
     * Scambia due elementi (pos1 e pos2) in un array di interi (array)
     * @param array l'array che contiene gli elementi da scambiare 
     * @param pos1 la posizione edl primo elemento
     * @param pos2 la posizione del secondo elemento
     */
    public static void scambia(int[] array, int pos1, int pos2)
    {
	int s;
	s=array[pos1];
	array[pos1]=array[pos2];
	array[pos2]=s;
    }
    
    /**
     * Scambia due elementi (pos1 e pos2) in un array di stringhe (array)
     * @param array l'array che contiene gli elementi da scambiare 
     * @param pos1 la posizione edl primo elemento
     * @param pos2 la posizione del secondo elemento
     */
    public static void scambia(String[] array, int pos1, int pos2)
    {
	String s;
	s=array[pos1];
	array[pos1]=array[pos2];
	array[pos2]=s;
    }
//SELECTION SORT
    /**
     * Restituisce un array di interi in ordine crescente utilizzando l'algoritmo selection sort
     * @param a array da ordinare
     * @return una copia dell'array ordinato in ordine crescente
     */
    public static int[] selectionSortCrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(aOrdinato[j]<aOrdinato[i])
		    scambia(aOrdinato, i, j);
	    }
	}
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di interi in ordine decrescente
     * @param a array da ordinare
     * @return una copia dell'array ordinato in ordine decrescente
     */
    public static int[] selectionSortDecrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(aOrdinato[j]>aOrdinato[i])
		    scambia(aOrdinato, i, j);
	    }
	}
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di stringhe in ordine alfabetico decrescente utilizaando l'algoritmo selection sort 
     * @param s array da ordinare
     * @return una copia dell'array ordinato in ordine decrescente
     */
    public static String[] selectionSortCrescente(String[] s)
    {
	int N=s.length;
	String[] sOrdinato=new String[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(sOrdinato[i].compareToIgnoreCase(sOrdinato[j])>0)
		    scambia(sOrdinato, i, j);
	    }
	}
	return sOrdinato;
    }
    
    /**
     * Restituisce un array di interi in ordine crescente utilizzando l'algoritmo selection sort
     * @param s array ordinato 
     * @return una copia dell'array ordinato in ordine crescente
     */
    public static String[] selectionSortDecrescente(String[] s)
    {
	int N=s.length;
	String[] sOrdinato=new String[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(sOrdinato[i].compareToIgnoreCase(sOrdinato[j])<0)
		    scambia(sOrdinato, i, j);
	    }
	}
	return sOrdinato;
    }
//BUBBLE SORT
    /**
     * Restituisce un array di interi in ordine decrescente utilizzando l'algoritmo selection sort
     * @param a array ordinato 
     * @return una copia dell'array ordinato in ordine decrescente
     */
    public static int[] bubbleSortCrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	boolean scambioAvvenuto=false;
	do{
	    scambioAvvenuto=false;
	    for(int i=0;i<N-1;i++)
	    {
		if(aOrdinato[i]>aOrdinato[i+1])
		{
		    scambia(aOrdinato, i, i+1);
		    scambioAvvenuto=true;
		}
	    }
	}while(scambioAvvenuto);
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di interi in ordine decrescente utilizzando l'algoritmo selection sort
     * @param a array ordinato 
     * @return una copia dell'array ordinato in ordine decrescente
     */
    public static int[] bubbleSortDecrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	boolean scambioAvvenuto=false;
	do{
	    scambioAvvenuto=false;
	    for(int i=0;i<N-1;i++)
	    {
		if(aOrdinato[i]<aOrdinato[i+1])
		{
		    scambia(aOrdinato, i, i+1);
		    scambioAvvenuto=true;
		}
	    }
	}while(scambioAvvenuto);
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di interi in ordine crescente utilizzando l'algoritmo selection sort
     * @param s array ordinato 
     * @return una copia dell'array ordinato in ordine crescente
     */
    public static String[] bubbleSortCrescente(String[] s)
    {
	int N=s.length;
	String[] sOrdinato=new String[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	boolean scambioAvvenuto=false;
	do{
	    scambioAvvenuto=false;
	    for(int i=0;i<N-1;i++)
	    {
		if(sOrdinato[i].compareToIgnoreCase(sOrdinato[i+1])>0)
		{
		    scambia(sOrdinato, i, i+1);
		    scambioAvvenuto=true;
		}
	    }
	}while(scambioAvvenuto);
	return sOrdinato;
    }
    
    /**
     * Restituisce un array di stringhe in ordine crescente
     * @param N
     * @return array in ordine decrescente
     */
    /*public static Motocicletta[] ordinaMotoCilindrataCrescente(Motocicletta[] moto) 
    {
        int N = moto.length;
        Motocicletta[] motoOrdinato = new Motocicletta[N];
        for (int i = 0; i < N; i++)
            motoOrdinato[i] = moto[i];
        boolean scambioAvvenuto = false;
        do {
            scambioAvvenuto = false;
            for (int i = 0; i < N - 1; i++) {
                if (motoOrdinato[i].getCilindrata > motoOrdinato[i + 1].getCilindrata) {
                    scambia(motoOrdinato, i, i + 1);
                    scambioAvvenuto = true;
                }
            }
        } while (scambioAvvenuto);
        return motoOrdinato;
    }*/
    
    /*private static void scambia(Motocicletta[] vOrdinato, int i, int j) 
    {
        Motocicletta temp = vOrdinato[i];
        vOrdinato[i] = vOrdinato[j];
        vOrdinato[j] = temp;
    }*/
    
    public static void scambia(Motocicletta[] m, int pos1,int pos2)
    {
        Motocicletta sost;
        sost=m[pos1];
        m[pos1]=m[pos2];
        m[pos2]=sost;
    }
    
    public static Motocicletta[] ordinaMotoCilindrataCrescente(Motocicletta[] m) {
        int lunghezza = m.length;
        // Creo una copia di m e la chiamo mOrdinato
        Motocicletta[] mOrdinato = new Motocicletta[lunghezza];
        for (int i = 0; i < lunghezza; i++)
            mOrdinato[i] = m[i];

        for (int i = 0; i < lunghezza - 1; i++) {
            for (int j = i + 1; j < lunghezza; j++) {
                // Confronto le cilindrate delle motociclette e scambio se necessario
                if (mOrdinato[i].getCilindrata() > mOrdinato[j].getCilindrata()) {
                    Motocicletta temp = mOrdinato[i];
                    mOrdinato[i] = mOrdinato[j];
                    mOrdinato[j] = temp;
                }
            }
        }
        return mOrdinato;
    }
}