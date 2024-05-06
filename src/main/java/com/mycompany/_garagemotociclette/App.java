/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._garagemotociclette;

import eccezioni.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilità.*;

/**
 *
 * @author gian
 */
public class App 
{ 
    public static void main(String[] args) 
    {
        
        int numeroVociMenu=13;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        int NUM_MAX_MOTO=50;
        Menu menu;
        Garage p1=new Garage();
      //  Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        String marca,modello, dataImmatricolazione = null;
        int cilindrata,posizione,idMotocicletta,anno;
        TextFile f1 = null;
        
        Garage garage=new Garage();
        Motocicletta mc;
        Motocicletta[] elencoMotoOrdinatePerCilindrata;
        String [] elencoMarcaMoto;
        String [] elencoCilindrataMoto;
        String [] elencoMotoAnnata;
        Motocicletta [] elencoMotoEpoc;
        String nomeFileCSV="moto.csv";
        String nomeFileBinario="Garage.bin";
        
        //cariacamento dati garage
        try 
        {
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBinario));
            p1=(Garage)reader.readObject();
            reader.close();
            System.out.println("Lettura file avvenuta correttamente");
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File non trovato");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Impossibile leggere il dato memorizzato");
        }
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutte le moto del garage";
        vociMenu[2]="2 -->\tAggiungi moto (posizione)";
        vociMenu[3]="3 -->\tCerca moto (posizione)";
        vociMenu[4]="4 -->\tElimina moto (posizione)";
        vociMenu[5]="5 -->\tMostra moto di una specifica marca";
        vociMenu[6]="6 -->\tMostra elenco delle moto presenti ordinato per cilindrata";
        vociMenu[7]="7 -->\tModifica moto";
        vociMenu[8]="8 -->\tVisualizza tutte le moto d'epoca (<2000)";
        vociMenu[9]="9 -->\tEsporta volumi in formato CSV";
        vociMenu[10]="10 -->\tImporta volumi dal file CSV";
        vociMenu[11]="11 -->\tSalva dati garage";
        vociMenu[12]="12 -->\tCarica dati garage";
        /*vociMenu[13]="13 -->\tVisualizza tutte le moto di una cilindrata (cilindrata)";
        vociMenu[14]="14 -->\tMoto della stessa annata";*/
        
        menu=new Menu(vociMenu);
        
        
        
        
        
        do
        {
            //System.out.println("MENU:");
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0:
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    System.out.println(p1.toString());
                    break;
                case 2:
                   // System.out.println("Premi invio per continuare..");
                   // tastiera.nextLine();
                    
                    try 
                    {
                        
                        System.out.print("Marca --> ");
                        marca=tastiera.readString();
                        System.out.print("Modello --> ");
                        modello=tastiera.readString();                                     
                        do
                        {
                            try
                            {
                               System.out.print("Cilindrata --> ");
                               cilindrata=tastiera.readInt(); 
                               break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto.");
                            }
                        }while(true);
                        
                        do
                        {
                            try
                            {
                               System.out.print("Data immatricolazione (AAAA-MM-GG) --> ");
                               dataImmatricolazione=tastiera.readString();
                               break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto.");
                            }   
                        }while(true);
                        
                        do
                        {
                            try
                            {
                                System.out.print("Posizione (0..50) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        mc=new Motocicletta(marca,modello,cilindrata,dataImmatricolazione);
                        p1.setMoto(mc, posizione);
                        System.out.println("Moto inserita correttamente.");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera.");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneOccupata ex) 
                    {
                        System.out.println("Posizione occupata!");
                    } 
                    catch (EccezioneCilindrataNonValida ex) 
                    {
                        System.out.println("Cilindrata non valida!");
                    }
                   break;





                case 3:
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..49) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        mc=p1.getMoto(posizione);
                        System.out.println("Moto cercata:\n"+mc.toString());
                    } 
                    catch(IOException e)
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera");
                    }
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneVuota ex)
                    {
                        System.out.println("Nessuna moto presente in quella posizione!");
                    }
                    break;
                    
                case 4:

                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..50) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        p1.rimuoviMoto(posizione);
                        System.out.println("La moto è stata rimossa correttamente");
                        }
                        catch(IOException e)
                        {
                            System.out.println("Errore. Impossibile leggere da tastiera");
                        }
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione non valida");
                        } 
                        catch (EccezionePosizioneVuota ex) 
                        {
                            System.out.println("La posizione è già vuota. Nessuna moto è stata rimossa");
                    }
                  
                    break;

                case 5:
                    try
                    {
                        System.out.print("Marca --> ");
                        marca=tastiera.readString();
                        elencoMarcaMoto=p1.elencoMotoMarca(marca);
                        if (elencoMarcaMoto!=null)
                        {
                            for(int i=0;i<elencoMarcaMoto.length;i++)
                            {
                                System.out.println(elencoMarcaMoto[i]);
                            }
                        }
                        else
                            System.out.println("Nessuna moto presente della marca scelta.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Errore. Imposssibile leggere da tastiera");
                    }
                    break;
                
                case 6:
                    elencoMotoOrdinatePerCilindrata=p1.elencoMotoOrdinatoPerCilindrata();
                    for(int i=0;i<elencoMotoOrdinatePerCilindrata.length;i++)
                    {
                        System.out.println(elencoMotoOrdinatePerCilindrata[i].toString());
                    }
                    break;
                
                case 7:
                    System.out.print("Modifica moto (posizione) --> ");
                
                    try 
                    {
                        posizione=tastiera.readInt();
                        try 
                        {
                            Motocicletta motoModificata=p1.getMoto(posizione);
                            if(motoModificata!=null)
                            {
                                System.out.println("Dati moto attuale:");
                                System.out.println(motoModificata.toString());
                                System.out.print("Nuova marca --> ");
                                String nuovaMarca=tastiera.readString();
                                System.out.print("Nuovo modello --> ");
                                String nuovoModello=tastiera.readString();
                                System.out.print("Nuova cilindrata --> ");
                                int nuovaCilindrata=tastiera.readInt();
                                System.out.print("Nuova data immatricolazione --> ");
                                String nuovaDataImmatricolazione=tastiera.readString();
                                motoModificata.setMarca(nuovaMarca);
                                motoModificata.setModello(nuovoModello);
                                try 
                                {
                                    motoModificata.setCilindrata(nuovaCilindrata);
                                } 
                                catch (EccezioneCilindrataNonValida ex) 
                                {
                                    System.out.println("Cilindrata non valida!");
                                }
                                motoModificata.setDataImmatricolazione(nuovaDataImmatricolazione);
                                p1.rimuoviMoto(posizione);
                                try 
                                {
                                    p1.setMoto(motoModificata, posizione);
                                    System.out.println("Moto modificata correttamente!");
                                } 
                                catch (EccezionePosizioneOccupata ex) 
                                {
                                    //non succederà mai
                                }
                            }
                        } 
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione non valida!");
                        } 
                        catch (EccezionePosizioneVuota ex) 
                        {
                            System.out.println("Posizione vuota!");
                        }
                    } 
                    catch (IOException ex) 
                    {
                        
                    } 
                    catch (NumberFormatException ex) 
                    {
                        
                    }
                    break;

                case 8:
                    elencoMotoEpoc=p1.elencoMotoDEpoca();
                    if (elencoMotoEpoc!=null)
                    {
                        for(int i=0;i<elencoMotoEpoc.length;i++)
                        {
                            System.out.println(elencoMotoEpoc[i]);
                        }
                    }
                    else
                        System.out.println("Nessuna moto presente della marca scelta.");
                    break;
                
                case 9:
                    try 
                    {
                        p1.esportaCSV(nomeFileCSV);
                        System.out.println("Moto esportate correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile esportare su file");
                    }
                    break;
                case 10:
                    try 
                    {
                        p1.importaDaCSV(nomeFileCSV);
                        System.out.println("Importazione terminata!");
                    } catch (IOException ex) 
                    {
                        System.out.println("Impossibile importare da file");
                    }
                    break;
                
                case 11: //serializzazione
                    try 
                    {
                        ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFileBinario));
                        writer.writeObject(p1);
                        writer.flush();
                        writer.close();
                        System.out.println("Salvataggio avvenuto correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile accedere al file");
                    }
                    break;
                case 12: //deserializzazione
                    try 
                    {
                        ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBinario));
                        p1=(Garage)reader.readObject();
                        reader.close();
                        System.out.println("Lettura file avvenuta correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile accedere al file");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("Impossibile leggere il dato memorizzato");
                    }
                    break;
                    
                /*case 13:
                    try
                    {
                        System.out.print("Cilindrata --> ");
                        cilindrata=tastiera.readInt();
                        elencoCilindrataMoto=p1.elencoMotoCilindrata(cilindrata);
                        if (elencoCilindrataMoto!=null)
                        {
                            for(int i=0;i<elencoCilindrataMoto.length;i++)
                            {
                                System.out.println(elencoCilindrataMoto[i]);
                            }
                        }
                        else
                            System.out.println("Nessuna moto presente della marca scelta.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Errore. Imposssibile leggere da tastiera");
                    }
                    break;
                    
                case 14:
                    try
                    {
                        System.out.print("Anno --> ");
                        anno=tastiera.readInt();
                        elencoMotoAnnata=p1.elencoMotoAnno(anno);
                        if (elencoMotoAnnata!=null)
                        {
                            for(int i=0;i<elencoMotoAnnata.length;i++)
                            {
                                System.out.println(elencoMotoAnnata[i]);
                            }
                        }
                        else
                            System.out.println("Nessuna moto presente della marca scelta.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Errore. Imposssibile leggere da tastiera");
                    }
                    break;*/
            }
        }while(voceMenuScelta!=0);
    }
}
