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
public class SeatTest {
    
    public SeatTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isAvailable method, of class Seat.
     */
    
    @Test
    @DisplayName("Nuevo Seat inicia disponible (isAvailable = true)")
    void newSeat_isAvailableTrue() {
        System.out.println(" Creando Seat nuevo y verificando disponibilidad inicial");
        Seat s = new Seat();
        assertTrue(s.isAvailable(), "Un asiento nuevo debe estar disponible");
    }

    @Test
    @DisplayName("reserve() marca asiento como no disponible")
    void reserve_makesUnavailable() {
        System.out.println("Reservando el Seat y comprobando que queda no disponible");
        Seat s = new Seat();
        s.reserve();
        assertFalse(s.isAvailable(), "Tras reservar, el asiento no debe estar disponible");
    }

    @Test
    @DisplayName("release() tras reservar vuelve a disponible")
    void release_afterReserve_makesAvailable() {
        System.out.println("Reservando y luego liberando el Seat para verificar el cambio de estado");
        Seat s = new Seat();
        s.reserve();
        s.release();
        assertTrue(s.isAvailable(), "Tras liberar, el asiento debe volver a estar disponible");
    }
    
    
    
}
