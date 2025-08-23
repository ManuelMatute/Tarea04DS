/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package clases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Manue
 */
public class PaymentResultTest {
    
    public PaymentResultTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    


    /**
     * Test of isSuccess method, of class PaymentResult.
     */
 
   
    @Test
    @DisplayName("Ctor(true) establece exito = true y el objeto no es nulo")
    void constructorTrue_setsSuccessTrue_andNotNull() {
        PaymentResult r = new PaymentResult(true);

        assertNotNull(r, "El objeto PaymentResult no debe ser nulo");
        assertTrue(r.isSuccess(), "isSuccess() debe ser true cuando se construye con true");
    }
    
    @Test
    @DisplayName("Ctor(false) establece exito = false (assertFalse y assertEquals)")
    void constructorFalse_setsSuccessFalse() {
        PaymentResult r = new PaymentResult(false);

        assertFalse(r.isSuccess(), "isSuccess() debe ser false cuando se construye con false");
        assertEquals(false, r.isSuccess(), "isSuccess() debe coincidir exactamente con el valor esperado");
    }
    
    @Test
    @DisplayName("Inmutabilidad: no existe setSuccess(boolean) (assertThrows)")
    void immutability_noSetterPresent() {
        assertThrows(
            NoSuchMethodException.class,
            () -> PaymentResult.class.getDeclaredMethod("setSuccess", boolean.class),
            "No deberia existir un metodo setSuccess(boolean)"
        );
    }
    
}
