/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._garagemotociclette;

/**
 *
 * @author gianluca
 */
public class Motocicletta 
{
    private String marca;
    private String modello;
    private int cilindrata;
    private String dataImmatricolazione;
    private static final int NUM_MAX_MOTO=50;
    
    /**
     * Costruttore 
     * @param marca
     * @param modello
     * @param cilindrata 
     * @param dataImmatricolazione
     */
    public Motocicletta(String marca, String modello, int cilindrata, String dataImmatricolazione)
    {
        this.marca=marca;
        this.modello=modello;
        this.cilindrata=cilindrata;
        this.dataImmatricolazione=dataImmatricolazione;
    }
    
    /**
     * Costruttore di copia
     * @param motocicletta 
     */
    public Motocicletta(Motocicletta motocicletta)
    {
        this.marca=motocicletta.getMarca();
        this.modello=motocicletta.getModello();
        this.cilindrata=motocicletta.getCilindrata();
        this.dataImmatricolazione=motocicletta.getDataImmatricolazione();
    }
    
    public String getDataImmatricolazione() 
    {
        return dataImmatricolazione;
    }

    public void setDataImmatricolazione(String dataImmatricolazione) 
    {
        this.dataImmatricolazione = dataImmatricolazione;
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

    public void setCilindrata(int cilindrata) 
    {
        this.cilindrata = cilindrata;
    }
    
    /**
     * Restituisce una stringa con i dati della motocicletta
     * @return 
     */
    @Override
    public String toString() {
        return "marca=" + marca + ", modello=" + modello + ", cilindrata=" + cilindrata + ", data immatricolazione=" + dataImmatricolazione;
    }
}
