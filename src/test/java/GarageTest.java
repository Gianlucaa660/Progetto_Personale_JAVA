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
    private Motocicletta moto0;
    /*private Motocicletta moto1;
    private Motocicletta moto2;
    private Motocicletta moto3;*/
    private Garage garage;
    
    
    /*@BeforeEach
    public void setUp() {
        garage = new Garage();
        // Aggiungi alcune moto al garage
        try 
        {
            garage.setMoto("Honda", "CRF", 250, "2023-12-03"));
            garage.setMoto("KTM", "SX-F", 450, "1991-12-03"));
        } 
        catch (EccezioneCilindrataNonValida e) 
        {
            // gestisci l'eccezione se necessario
        }
    }*/
    @BeforeEach
    public void setUp() throws EccezioneCilindrataNonValida, EccezionePosizioneOccupata, EccezionePosizioneNonValida
    {
        garage= new Garage();
        moto= new Motocicletta("ktm", "sx-f", 450, "1991-12-03");
        moto0= new Motocicletta("honda", "crf", 250, "2023-12-03");
        /*moto1= new Motocicletta("Honda", "CBR600RR", 600, "2017-06-15");
        moto2= new Motocicletta("Honda", "CBR1000RR", 1000, "2019-03-20"); 
        moto3= new Motocicletta("Yamaha", "MT-07", 700, "2018-12-10");*/
        garage.setMoto(moto, 0);
        garage.setMoto(moto0, 1);
    }
    
    /**
     * Test of posizioneOccupata method, of class Garage.
     */
    @Test
    public void testSetMotoPosizioneOccupata() throws Exception 
    {
        assertThrows(EccezionePosizioneOccupata.class, () -> garage.setMoto(moto, 0));
    }

    /**
     * Test of getMoto method, of class Garage.
     */
    @Test
    public void testGetMoto() throws Exception 
    {
        assertEquals(moto.getIdMotocicletta(),garage.getMoto(0).getIdMotocicletta());
        assertEquals(moto.getMarca(),garage.getMoto(0).getMarca());
        assertEquals(moto.getModello(),garage.getMoto(0).getModello());
        assertEquals(moto.getCilindrata(),garage.getMoto(0).getCilindrata());
        assertEquals(moto.getDataImmatricolazione(),garage.getMoto(0).getDataImmatricolazione());
    }

    /**
     * Test of rimuoviMotoPosizioneNonValida method, of class Garage.
     */
    @Test
    public void testRimuoviMotoPosizioneNonValida() throws EccezionePosizioneVuota, EccezionePosizioneNonValida 
    {
        garage.rimuoviMoto(0);
        assertThrows(EccezionePosizioneVuota.class, () -> garage.getMoto(0));
    }
    
    /**
     * Test of rimuoviMotoPosizioneVuota method, of class Garage.
     */
    @Test
    public void testRimuoviMotoPosizioneVuota() throws EccezionePosizioneVuota, EccezionePosizioneNonValida 
    {
        garage.rimuoviMoto(0);
        assertThrows(EccezionePosizioneVuota.class, () -> garage.getMoto(0));
    }
    
    /**
     * Test of rimuoviMoto method, of class Garage.
     */
    @Test
    public void testRimuoviMoto() throws EccezionePosizioneVuota, EccezionePosizioneNonValida 
    {
        garage.rimuoviMoto(0);
        assertThrows(EccezionePosizioneVuota.class, () -> garage.getMoto(0));
    }
    
    /**
     * Test of modificaMotot method, of class Garage.
     */
    @Test
    public void testModificaMoto() throws Exception 
    {
        garage.modificaMoto(0, moto0);
        assertEquals(moto0.getIdMotocicletta(), garage.getMoto(0).getIdMotocicletta());
        assertEquals(moto0.getMarca(),garage.getMoto(0).getMarca());
        assertEquals(moto0.getModello(),garage.getMoto(0).getModello());
        assertEquals(moto0.getCilindrata(),garage.getMoto(0).getCilindrata());
        assertEquals(moto0.getDataImmatricolazione(),garage.getMoto(0).getDataImmatricolazione());
    }

    /**
     * Test of setMoto method, of class Garage.
     */
    @Test
    public void testSetMoto() throws EccezioneCilindrataNonValida, EccezionePosizioneNonValida, EccezionePosizioneOccupata, EccezionePosizioneVuota
    {
        
    }

    /**
     * Test of getNumMaxMoto method, of class Garage.
     */
    @Test
    public void testGetNumMaxMoto() 
    {
        assertEquals(50, garage.getNumMaxMoto());
    }

    /**
     * Test of getNumMoto method, of class Garage.
     */
    @Test
    public void testGetNumMoto() 
    {
        assertEquals(2, garage.getNumMoto());
    }

    /**
     * Test of elencoMotoMarca method, of class Garage.
     */
    @Test
    public void testElencoMotoMarca() throws EccezioneCilindrataNonValida, EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        Garage garage = new Garage();
        Motocicletta moto1 = new Motocicletta("Honda", "CBR600RR", 600, "2017-06-15");
        Motocicletta moto2 = new Motocicletta("Honda", "CBR1000RR", 1000, "2019-03-20");
        Motocicletta moto3 = new Motocicletta("Yamaha", "MT-07", 700, "2018-12-10");
        garage.setMoto(moto1, 0);
        garage.setMoto(moto2, 1);
        garage.setMoto(moto3, 2);
        String[] expected = {"0-->Honda CBR600RR 600 2017-06-15", "1-->Honda CBR1000RR 1000 2019-03-20"};
        assertArrayEquals(expected, garage.elencoMotoMarca("Honda"));
    }

    /**
     * Test of elencoMotoOrdinatoPerCilindrata method, of class Garage.
     */
    @Test
    public void testElencoMotoOrdinatoPerCilindrata() throws EccezioneCilindrataNonValida, EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        Garage garage = new Garage();
        Motocicletta moto1 = new Motocicletta("Yamaha", "YZF-R1", 1000, "2019-07-20");
        Motocicletta moto2 = new Motocicletta("Kawasaki", "Ninja ZX-6R", 600, "2020-02-10");
        Motocicletta moto3 = new Motocicletta("Suzuki", "GSX-R750", 750, "2018-11-25");
        garage.setMoto(moto1, 0);
        garage.setMoto(moto2, 1);
        garage.setMoto(moto3, 2);
        Motocicletta[] expected = {moto2, moto3, moto1};
        assertArrayEquals(expected, garage.elencoMotoOrdinatoPerCilindrata());
    }

    /**
     * Test of elencoMotoDEpoca method, of class Garage.
     */
    @Test
    public void testElencoMotoDEpoca() throws EccezioneCilindrataNonValida, EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        Garage garage = new Garage();
        Motocicletta moto1 = new Motocicletta("Yamaha", "YZF-R1", 1000, "2010-07-20");
        Motocicletta moto2 = new Motocicletta("Kawasaki", "Ninja ZX-6R", 600, "2020-02-10");
        Motocicletta moto3 = new Motocicletta("Suzuki", "GSX-R750", 750, "1999-11-25");
        garage.setMoto(moto1, 0);
        garage.setMoto(moto2, 1);
        garage.setMoto(moto3, 2);
        Motocicletta[] expected = {moto3};
        assertArrayEquals(expected, garage.elencoMotoDEpoca());
    }

    /**
     * Test of esportaCSV method, of class Garage.
     */
    @Test
    public void testEsportaCSV() throws Exception {
    }

    /**
     * Test of importaDaCSV method, of class Garage.
     */
    @Test
    public void testImportaDaCSV() throws Exception {
    }

    /**
     * Test of toString method, of class Garage.
     */
    @Test
    public void testToString() {
    }
}
