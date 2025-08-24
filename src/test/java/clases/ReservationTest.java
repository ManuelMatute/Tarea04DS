/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package clases;

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
public class ReservationTest {
    
    public ReservationTest() {
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

    @Test
    @DisplayName("addSeat(): reserva el asiento y lo almacena en la lista")
    void addSeat_reservesAndStoresSeat() {
        System.out.println("Creando Reservation y agregando un Seat libre");
        Reservation r = new Reservation();
        Seat s = new Seat();

        assertTrue(s.isAvailable(), "Precondición: el asiento debe iniciar disponible");
        r.addSeat(s);

        assertAll("Verificar efectos de addSeat",
            () -> assertFalse(s.isAvailable(), "El asiento debe quedar reservado (no disponible)"),
            () -> assertEquals(1, r.getSeats().size(), "La reserva debe contener 1 asiento"),
            () -> assertSame(s, r.getSeats().get(0), "El asiento agregado debe coincidir con el original")
        );
    }

    @Test
    @DisplayName("removeSeat(): libera el asiento y lo quita de la lista")
    void removeSeat_releasesAndRemovesSeat() {
        System.out.println("Agregando 2 asientos y luego removiendo uno para verificar liberacion");
        Reservation r = new Reservation();
        Seat s1 = new Seat();
        Seat s2 = new Seat();

        r.addSeat(s1);
        r.addSeat(s2);
        assertEquals(2, r.getSeats().size(), "Precondicion: deben existir 2 asientos en la reserva");

        r.removeSeat(s1);

        assertAll("Verificar efectos de removeSeat",
            () -> assertTrue(s1.isAvailable(), "El asiento removido debe quedar disponible"),
            () -> assertEquals(1, r.getSeats().size(), "La reserva debe contener 1 asiento tras remover"),
            () -> assertSame(s2, r.getSeats().get(0), "El asiento restante debe ser s2"),
            () -> assertFalse(r.getSeats().contains(s1), "La lista no debe contener a s1")
        );
    }

    @Test
    @DisplayName("confirm() seguido de cancel(): libera todos los asientos, limpia la lista y desconfirma")
    void confirmThenCancel_releasesAll_andResets() {
        System.out.println("Confirmando y luego cancelando para verificar liberacion total y reinicio de estado");
        Reservation r = new Reservation();
        Seat s1 = new Seat();
        Seat s2 = new Seat();
        r.addSeat(s1);
        r.addSeat(s2);

        r.confirm();
        assertTrue(r.isConfirmed(), "Tras confirm(), la reserva debe estar confirmada");

        r.cancelAndReleaseAllSeats();

        assertAll("Efectos de cancel()",
            () -> assertFalse(r.isConfirmed(), "La reserva debe quedar NO confirmada"),
            () -> assertTrue(s1.isAvailable() && s2.isAvailable(), "Todos los asientos deben quedar disponibles"),
            () -> assertTrue(r.getSeats().isEmpty(), "La lista de asientos debe quedar vacía")
        );
    }

    @Test
    @DisplayName("addOption(): almacena las opciones extra (p. ej., Bebida y Parqueo)")
    void addOption_storesExtras() {
        System.out.println("Agregando opciones a la reserva (Bebida, Parqueo)");
        Reservation r = new Reservation();
        Option bebida = new Option("Bebida", new Money(20.0));
        Option parking = new Option("Estacionamiento", new Money(10.0));

        r.addOption(bebida);
        r.addOption(parking);

        assertAll("Verificar opciones agregadas",
            () -> assertEquals(2, r.getOptions().size(), "Deben existir 2 opciones en la reserva"),
            () -> assertTrue(r.getOptions().contains(bebida), "La lista debe contener 'Bebida'"),
            () -> assertTrue(r.getOptions().contains(parking), "La lista debe contener 'Parqueo'")
        );
    }

    @Test
    @DisplayName("cancel() es idempotente: llamarlo dos veces no rompe el estado")
    void cancel_isIdempotent() {
        System.out.println("Probando idempotencia de cancel(): dos llamadas consecutivas...");
        Reservation r = new Reservation();
        Seat s = new Seat();
        r.addSeat(s);                 
        r.cancelAndReleaseAllSeats();              
                      

        assertAll("Estado tras cancel() repetido",
            () -> assertTrue(s.isAvailable(), "El asiento debe permanecer disponible"),
            () -> assertTrue(r.getSeats().isEmpty(), "La lista de asientos debe seguir vacia"),
            () -> assertFalse(r.isConfirmed(), "La reserva debe permanecer no confirmada")
        );
    }
    
    
}
