/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._garagemotociclette;

import eccezioni.*;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author gianluca
 */
public class Motocicletta 
{
    private int idMotocicletta;
    private static int nextId=1;
    private String marca;
    private String modello;
    private int cilindrata;
    private String dataImmatricolazione;
    private static final int NUM_MAX_MOTO=50;
    
    /**
     * Costruttore 
     * @param idMotocicletta
     * @param marca
     * @param modello
     * @param cilindrata 
     * @param dataImmatricolazione
     */
    public Motocicletta(String marca, String modello, int cilindrata, String dataImmatricolazione) throws EccezioneCilindrataNonValida
    {
        this.idMotocicletta=nextId;
        nextId++;
        this.marca=marca;
        this.modello=modello;
        setCilindrata(cilindrata);
        this.dataImmatricolazione=dataImmatricolazione;
    }
    
    /**
     * Costruttore di copia
     * @param motocicletta 
     */
    public Motocicletta(Motocicletta motocicletta)
    {
        this.idMotocicletta=motocicletta.getIdMotocicletta();
        this.marca=motocicletta.getMarca();
        this.modello=motocicletta.getModello();
        this.cilindrata=motocicletta.getCilindrata();
        this.dataImmatricolazione=motocicletta.getDataImmatricolazione();
    }
    
    public String getDataImmatricolazione() 
    {
        return dataImmatricolazione;
    }
    
    public int getAnno()
    {
        LocalDate dataImmatricolazione=LocalDate.parse(this.dataImmatricolazione);
         return dataImmatricolazione.getYear();
    }

    public void setDataImmatricolazione(String dataImmatricolazione) 
    {
        this.dataImmatricolazione = dataImmatricolazione;
    }
    
    public int getIdMotocicletta() 
    {
        return idMotocicletta;
    }
    
    public String getMarca() 
    {
        return marca;
    }

    public void setMarca(String marca) 
    {
        this.marca = marca;
    }

    public String getModello() 
    {
        return modello;
    }

    public void setModello(String modello) 
    {
        this.modello = modello;
    }

    public int getCilindrata() 
    {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) throws EccezioneCilindrataNonValida
    {
        if(cilindrata<0 || cilindrata>1390)
            throw new EccezioneCilindrataNonValida();
        this.cilindrata = cilindrata;
    }
    
    /**
     * Restituisce una stringa con i dati della motocicletta
     * @return 
     */
    @Override
    public String toString() {
        return "ID="+idMotocicletta+", marca=" + marca + ", modello=" + modello + ", cilindrata=" + cilindrata + ", data immatricolazione=" + dataImmatricolazione;
    }
}
