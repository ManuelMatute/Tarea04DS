/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package clases;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
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
public class CustomerTest {
    
    public CustomerTest() {
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
     * Customer.
     */
    
    @Test
    @DisplayName("addReservation() guarda la reserva en la lista del cliente")
    void addReservation_storesReservationInList() {
        System.out.println("Creando Customer y agregando una Reservation");
        Customer c = new Customer("c@e.com");
        Reservation r = new Reservation();

        c.addReservation(r);

        assertAll("Verificar almacenamiento de la reserva",
            () -> assertEquals(1, c.getReservations().size(), "Debe haber 1 reserva"),
            () -> assertTrue(c.getReservations().contains(r), "La lista debe contener la reserva agregada")
        );
    }

    @Test
    @DisplayName("getContactInfo() devuelve el contacto provisto en el constructor")
    void getContactInfo_returnsProvidedValue() {
        System.out.println("Verificando getter de contacto del Customer");
        Customer c = new Customer("c@e.com");
        assertEquals("c@e.com", c.getContactInfo(), "El contacto debe coincidir con el proporcionado");
    }

    @Test
    @DisplayName("update(event, message) imprime notificación con email, evento y mensaje")
    void update_printsNotification() {
        System.out.println("Capturando la salida de consola para verificar el mensaje de update()");

        Customer c = new Customer("c@e.com");

        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            c.update("TEATRO", "Confirmado");
        } finally {
            System.setOut(original);
        }

        String out = baos.toString();
        assertAll("Verificar contenido de la notificacion",
            () -> assertTrue(out.contains("Notificacion para c@e.com"), "Debe contener el email del cliente"),
            () -> assertTrue(out.contains("sobre TEATRO"), "Debe mencionar el evento"),
            () -> assertTrue(out.contains("Confirmado"), "Debe incluir el mensaje")
        );
    }
    
    
}
