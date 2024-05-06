/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany._garagemotociclette.Motocicletta;
import eccezioni.EccezioneCilindrataNonValida;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author gianluca
 */
public class MotociclettaTest {
    
    public MotociclettaTest() 
    {
        
    }
    private Motocicletta moto;
    
    @BeforeEach
    public void setUp() throws EccezioneCilindrataNonValida
    {
        moto= new Motocicletta("ktm", "sx-f", 450, "2023-12-03");
    }

    /**
     * Test of getDataImmatricolazione method, of class Motocicletta.
     */
    @Test
    public void testGetDataImmatricolazione() 
    {
        String atteso="2023-12-03";
        assertEquals(atteso, moto.getDataImmatricolazione());
    }

    /**
     * Test of getAnno method, of class Motocicletta.
     */
    @Test
    public void testGetAnno() 
    {
        int atteso=2023;
        assertEquals(atteso, moto.getAnno());
    }

    /**
     * Test of setDataImmatricolazione method, of class Motocicletta.
     */
    @Test
    public void testSetDataImmatricolazione() 
    {
        moto.setDataImmatricolazione("2023-12-03");
        assertEquals("2023-12-03", moto.getDataImmatricolazione());
    }

    /**
     * Test of getIdMotocicletta method, of class Motocicletta.
     */
    @Test
    public void testGetIdMotocicletta() 
    {
        int atteso=1;
        assertEquals(atteso, moto.getIdMotocicletta());
    }

    /**
     * Test of getMarca method, of class Motocicletta.
     */
    @Test
    public void testGetMarca() 
    {
        String atteso="ktm";
        assertEquals(atteso, moto.getMarca());
    }

    /**
     * Test of setMarca method, of class Motocicletta.
     */
    @Test
    public void testSetMarca() 
    {
        moto.setMarca("ktm");
        assertEquals("ktm", moto.getMarca());
    }

    /**
     * Test of getModello method, of class Motocicletta.
     */
    @Test
    public void testGetModello() 
    {
        String atteso="sx-f";
        assertEquals(atteso, moto.getModello());
    }

    /**
     * Test of setModello method, of class Motocicletta.
     */
    @Test
    public void testSetModello() 
    {
        moto.setModello("sx-f");
        assertEquals("sx-f", moto.getModello());
    }

    /**
     * Test of getCilindrata method, of class Motocicletta.
     */
    @Test
    public void testGetCilindrata() 
    {
        int atteso=450;
        assertEquals(atteso, moto.getCilindrata());
    }

    /**
     * Test of setCilindrata method, of class Motocicletta.
     */
    @Test
    public void testSetCilindrata() throws Exception 
    {
        moto.setCilindrata(450);
        assertEquals(450, moto.getCilindrata());
    }

    /**
     * Test of toString method, of class Motocicletta.
     */
    @Test
    public void testToString() 
    {
        
    }
    
}
