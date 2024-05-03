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
         
         //se i li bri da aggiungere sono troppi
         //ne aggiungo solo NUM_MAX_VOLUMI
         numeroMotoDaAggiungere=elencoMoto.length;
         if (numeroMotoDaAggiungere>NUM_MAX_MOTO)
             numeroMotoDaAggiungere=NUM_MAX_MOTO;
        
         //Copio l'i-esimo libro dell'array in  volumi
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
                    //non succederà mai perchè l'array volumi è vuoto
                }
         }
         
         
    }
    
    public Motocicletta getMoto(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        Motocicletta mc;
        if (posizione<0 || posizione>=NUM_MAX_MOTO)
            throw new EccezionePosizioneNonValida();
        if (moto[posizione]==null)
            throw  new EccezionePosizioneVuota();
        mc=moto[posizione];
            return new Motocicletta(mc); //restituisco una copia del libro
    }
    
    public void rimuoviMoto(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if(posizione<0 || posizione>NUM_MAX_MOTO)
            throw new EccezionePosizioneNonValida();
 
        if (moto[posizione]==null)
                throw new EccezionePosizioneVuota();
        moto[posizione]=null;
        //    return posizione;
    }
    
    public void setMoto(Motocicletta moto, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        if (posizione<0 || posizione>=NUM_MAX_MOTO)
           throw new EccezionePosizioneNonValida();
        if(this.moto[posizione]!=null)
              throw new EccezionePosizioneOccupata();
        this.moto[posizione]=new Motocicletta(moto);
        //return posizione;  
    }
    
    public void visualizzaMoto()
    {
        Motocicletta[] elencoMoto = null;
        for(int i=0; i<moto.length; i++)
        {
            if(moto!=null)
            {
                elencoMoto[i]=moto[i];
            }
        }
    }
    
    public int getNumMaxMoto()
    {
        return NUM_MAX_MOTO;
    }
    
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
    
    public String[] elencoMotoMarca (String marcaMotoDaCercare)
    {
        int contaMotoMarca=0;
        Motocicletta mc;
        String[] elencoMarcaMoto;
        //Conto il numero di libri di quell'autore
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
            return null; //non ci sono libri di quell'autore.
        //Istanzio DINAMICAMENTE un array di stringhe
        elencoMarcaMoto=new String[contaMotoMarca];
        
        contaMotoMarca=0; //azzero il contatore per usarlo come contatore dell'array
        //Copio il titolo di ogni libro di quell'autore
        //nell'array elencoTitoliAutore
        
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
    
    /*public Motocicletta[] elencoMotoOrdinatoPerCilindrata()
    {
        Motocicletta[] elencoMotoOrdinato=new Motocicletta[this.getNumMoto()];
        Motocicletta mc;
        int c=0; //contatore
        for(int i=0;i<this.getNumMaxMoto();i++)
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
    }*/
    
    
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
