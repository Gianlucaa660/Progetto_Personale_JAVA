/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._garagemotociclette;

import eccezioni.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilità.Ordinatore;
import utilità.TextFile;

/**
 *
 * @author gianluca
 */
public class Garage implements Serializable
{
    private final static int NUM_MAX_MOTO=50;
    private Motocicletta[] moto;
    
    public Garage()
    {
        moto = new Motocicletta[NUM_MAX_MOTO];
    }
    
    
    /**
     * Costruttore di copia
     * @param g 
     */
    public Garage(Garage g)
    {
         moto=new Motocicletta[NUM_MAX_MOTO];
         Motocicletta mc;
         for(int i=0; i<g.getNumMaxMoto();i++)
         {
             try 
             {
                 mc=g.getMoto(i);
                 if (mc!=null)        
                     this.setMoto(mc, i);
             } 
             catch (EccezionePosizioneNonValida ex) 
             {
                 //non succederà mai
             } catch (EccezionePosizioneVuota ex) 
             {
                 //non fare nulla
             } catch (EccezionePosizioneOccupata ex) 
             {
                 //non succederà mai.
             }
         }
    }
    
    public Garage(Motocicletta[] elencoMoto)
    {
         moto=new Motocicletta[NUM_MAX_MOTO];
         int numeroMotoDaAggiungere;
         
         //se le moto da aggiungere sono troppe
         //ne aggiungo solo NUM_MAX_MOTO
         numeroMotoDaAggiungere=elencoMoto.length;
         if (numeroMotoDaAggiungere>NUM_MAX_MOTO)
             numeroMotoDaAggiungere=NUM_MAX_MOTO;
        
         //Copio l'i-esima moto dell'array in elencoMoto
         for (int i=0;i<numeroMotoDaAggiungere;i++)
         {
             if (elencoMoto[i]!=null)
                try 
                {
                    setMoto(elencoMoto[i], i);
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneOccupata ex) 
                {
                    //non succederà mai perchè l'array elencoMoto è vuoto
                }
         }
         
         
    }
    
    /**
     * Restituisce la moto nella posizione "posizione"
     * @param posizione
     * @return 
     * se la posizione non è valida o vuota --> return null
        se ok  ritorna l’oggetto moto
     */
    public Motocicletta getMoto(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        Motocicletta mc;
        if (posizione<0 || posizione>=NUM_MAX_MOTO)
            throw new EccezionePosizioneNonValida();
        if (moto[posizione]==null)
            throw  new EccezionePosizioneVuota();
        mc=moto[posizione];
            return new Motocicletta(mc); //restituisco una copia della moto
    }
    
    /**
     * Rimuove la moto dalla posizione "posizione"
     * @param posizione
     * @return 
     *  se la posizione non è valida --> return -1
        se già vuota --> return -2
        se ok  return 0
     */
    public void rimuoviMoto(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if(posizione<0 || posizione>NUM_MAX_MOTO)
            throw new EccezionePosizioneNonValida();
 
        if (moto[posizione]==null)
                throw new EccezionePosizioneVuota();
        moto[posizione]=null;
        //    return posizione;
    }
    
    /**
     * Inserisce la moto nella posizione "posizione" 
     * @param mc la moto da aggiungere
     * @param posizione
     * @return 
     *  se la posizione non è valida --> return -1
        se la posizione non è vuota --> return -2
        se ok  return 0
     */
    public void setMoto(Motocicletta moto, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        if (posizione<0 || posizione>=NUM_MAX_MOTO)
           throw new EccezionePosizioneNonValida();
        if(this.moto[posizione]!=null)
              throw new EccezionePosizioneOccupata();
        this.moto[posizione]=new Motocicletta(moto);
        //return posizione;  
    }
    
    /**
     * Restituisce il massimo numero di moto
     * che possono essere poste nel garage
     * @return 
     */
    public int getNumMaxMoto()
    {
        return NUM_MAX_MOTO;
    }
    
    /**
     * Restituisce il numero di moto presenti nel garage
     * @return 
     */
    public int getNumMoto()
    {
        int contatore=0;
        for(int i=0;i<this.getNumMaxMoto();i++)
        {
            if(moto[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    /**
     * Restituisce un array contenente tutti i modelli
     * della marca passata come parametro
     * @param marcaMotoDaCercare
     * @return array di stringhe
     */
    public String[] elencoMotoMarca (String marcaMotoDaCercare)
    {
        int contaMotoMarca=0;
        Motocicletta mc;
        String[] elencoMarcaMoto;
        //Conto il numero di moto di quella mrca
        for(int i=0;i<this.getNumMaxMoto();i++)
        {
            try 
            {
                mc=this.getMoto(i);
                if (mc.getMarca().equalsIgnoreCase(marcaMotoDaCercare))
                    contaMotoMarca++;   
            }
            catch (EccezionePosizioneNonValida ex)
            {
                //non succederà mai
            } 
            catch (EccezionePosizioneVuota ex) 
            {
                    //non fare nulla.
            }
        }
        
        if (contaMotoMarca==0)
            return null; //non ci sono moto di quella marca.
        //Istanzio DINAMICAMENTE un array di stringhe
        elencoMarcaMoto=new String[contaMotoMarca];
        
        contaMotoMarca=0; //azzero il contatore per usarlo come contatore dell'array
        //Copio i dati di ogni moto di quella marca
        //nell'array elencoMarcaMoto
        
        for(int i=0;i<this.getNumMaxMoto();i++)
        {
            try {
                mc=this.getMoto(i);
                if (mc.getMarca().equalsIgnoreCase(marcaMotoDaCercare))
                {
                    elencoMarcaMoto[contaMotoMarca]=mc.toString();
                    contaMotoMarca++;
                } 
            }
            catch (EccezionePosizioneNonValida ex) 
            {
                   //non succederà mai
            } 
            catch (EccezionePosizioneVuota ex) 
            {
                //non fare nulla
            }
        }
        return elencoMarcaMoto;
    }
    
    /**
     * Restituisce un array contenente tutte le moto
     * presenti nel garage ordinate per cilindrata crescente
     * @return Array di moto
     */
    public Motocicletta[] elencoMotoOrdinatoPerCilindrata()
    {
        Motocicletta[] elencoMotoOrdinato=new Motocicletta[getNumMoto()];
        Motocicletta mc;
        int c=0; //contatore
        for(int i=0;i<getNumMaxMoto();i++)
        {
            try 
            {
                mc=getMoto(i);
                elencoMotoOrdinato[c]=mc;
                c++; 
            }
            catch (EccezionePosizioneNonValida ex) 
            {
                //non succederà mai
            } 
            catch (EccezionePosizioneVuota ex) 
            {
                //non fare nulla
            }
        }
        //ordino l'array delle moto presenti
        elencoMotoOrdinato=Ordinatore.ordinaMotoCilindrataCrescente(elencoMotoOrdinato);
        return elencoMotoOrdinato;
    }
    
    public Motocicletta[] elencoMotoDEpoca() 
    {
        Motocicletta[] motoEpoca = new Motocicletta[getNumMoto()];
        int c = 0; // contatore
        for (int i = 0; i < getNumMaxMoto(); i++) {
            try {
                Motocicletta mc = getMoto(i);
                if (mc.getAnno() < 2000) { // Verifica se l'anno della motocicletta è minore di 2000
                    motoEpoca[c] = mc;
                    c++;
                }
            } catch (EccezionePosizioneNonValida ex) {
                // non succederà mai
            } catch (EccezionePosizioneVuota ex) {
                // non fare nulla
            }
        }
        // ridimensiono l'array per eliminare eventuali elementi nulli aggiunti in precedenza
        Motocicletta[] motoEpocaPre2000 = new Motocicletta[c];
        System.arraycopy(motoEpoca, 0, motoEpocaPre2000, 0, c);
        return motoEpocaPre2000;
    }
    
    public void esportaCSV(String nomeFile) throws IOException
    {
        TextFile f1;
        Motocicletta mc;
        f1= new TextFile(nomeFile,'W'); //Apro ill file in scrittura
        String datiMoto;
        for(int i=0;i<this.getNumMaxMoto();i++)
        {
            try 
            {
                mc=this.getMoto(i);
                datiMoto=i+";"+mc.getIdMotocicletta()+";"+mc.getMarca()+";"+mc.getModello()+";"+mc.getCilindrata()+";"+mc.getDataImmatricolazione();
                f1.toFile(datiMoto);
            }                             
            catch (EccezionePosizioneVuota ex) 
            {
                    //non fare nulla, vai alla prossima posizione
            } catch (FileException ex) 
            {
                //non succederà mai
            } catch (EccezionePosizioneNonValida ex) 
            {
                
            }
        }
        f1.closeFile();  //Tutti i volumi sono statoi scritti
    }
    
    public void importaDaCSV(String nomeFile) throws IOException
    {
        String rigaLetta;
        String[] datiMoto;
        TextFile f1;
        int posizione,cilindrata,idMotocicletta;
        String marca, modello, dataImmatricolazione;
        Motocicletta mc;
        f1=new TextFile(nomeFile, 'R');

        do
        {
            try
            {
                rigaLetta=f1.fromFile();
                datiMoto=rigaLetta.split(";");
                posizione=Integer.parseInt(datiMoto[0]);
                idMotocicletta=Integer.parseInt(datiMoto[1]);
                marca=datiMoto[2];
                modello=datiMoto[3];
                cilindrata=Integer.parseInt(datiMoto[4]);
                dataImmatricolazione=datiMoto[5];
                mc=new Motocicletta(marca,modello,cilindrata,dataImmatricolazione);
                try 
                {
                    this.setMoto(mc, posizione);
                }
                catch (EccezionePosizioneNonValida ex) 
                {
                    //non faccio nulla
                } catch (EccezionePosizioneOccupata ex) 
                {
                    //non faccio nulla
                }
            }
            catch (FileException ex) 
            {
                //fine del file 
                f1.closeFile();
                System.out.println("Importazione terminata!");
                break;
            } 
            catch (EccezioneCilindrataNonValida ex) 
            {
                //non fare nulla
            }
        }while(true);
    }
    
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_MOTO;i++)
        {
            if (moto[i]==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+moto[i].toString()+"\n";
        }
        
        return s;
    }
}
