/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany._garagemotociclette.Garage;
import com.mycompany._garagemotociclette.Motocicletta;
import eccezioni.EccezioneCilindrataNonValida;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author gianluca
 */
public class GarageTest {
    
    public GarageTest() {
    }
    
    private Motocicletta moto;
    private Garage garage;
    
    @BeforeEach
    public void setUp() throws EccezioneCilindrataNonValida
    {
        garage= new Garage();
        moto= new Motocicletta("ktm", "sx-f", 450, "2023-12-03");
    }

    /**
     * Test of getMoto method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testGetMoto() throws Exception 
    {
        
    }

    /**
     * Test of rimuoviMoto method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testRimuoviMoto() throws Exception {
    }

    /**
     * Test of setMoto method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testSetMoto() throws EccezioneCilindrataNonValida, EccezionePosizioneNonValida, EccezionePosizioneOccupata, EccezionePosizioneVuota
    {
        Motocicletta m1=new Motocicletta("ktm","sx-f",450,"2023-12-03");
        Motocicletta atteso=new Motocicletta("ktm","sx-f",450,"2023-12-03");
        Motocicletta attuale;
        Garage g1=new Garage();
        g1.setMoto(m1, 0);
        attuale=g1.getMoto(0);
        assertEquals(atteso, attuale, "set get motocicletta ktm sx-f");
    }

    /**
     * Test of getNumMaxMoto method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumMaxMoto() {
    }

    /**
     * Test of getNumMoto method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumMoto() {
    }

    /**
     * Test of elencoMotoMarca method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testElencoMotoMarca() {
    }

    /**
     * Test of elencoMotoOrdinatoPerCilindrata method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testElencoMotoOrdinatoPerCilindrata() {
    }

    /**
     * Test of elencoMotoDEpoca method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testElencoMotoDEpoca() {
    }

    /**
     * Test of esportaCSV method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testEsportaCSV() throws Exception {
    }

    /**
     * Test of importaDaCSV method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testImportaDaCSV() throws Exception {
    }

    /**
     * Test of toString method, of class Garage.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
    }
}
