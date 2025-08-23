/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package clases;

import java.util.Arrays;
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
public class ReservationServiceTest {
    
    public ReservationServiceTest() {
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
    @DisplayName("reserveSeats(): crea la Reservation, reserva los asientos y la asocia al Customer")
    void reserveSeats_addsToCustomer_andReservesChairs() {
        System.out.println("Reservando 2 asientos para el cliente y verificando efectos en Customer y Seats");
        ReservationService svc = new ReservationService();
        Customer c = new Customer("c@e.com");
        Seat s1 = new Seat();
        Seat s2 = new Seat();

        Reservation res = svc.reserveSeats(c, Arrays.asList(s1, s2));

        assertAll("Verificar reserva creada y efectos colaterales",
            () -> assertNotNull(res, "La reserva no debe ser nula"),
            () -> assertTrue(c.getReservations().contains(res), "El cliente debe contener la reserva creada"),
            () -> assertFalse(s1.isAvailable(), "s1 debe quedar reservado"),
            () -> assertFalse(s2.isAvailable(), "s2 debe quedar reservado"),
            () -> assertEquals(2, res.getSeats().size(), "La reserva debe contener 2 asientos")
        );
    }

    @Test
    @DisplayName("releaseSeats(): cancela la Reservation y libera todos los asientos")
    void releaseSeats_cancelsReservation_andReleasesSeats() {
        System.out.println("Liberando los asientos de una reserva existente y verificando limpieza de estado");
        ReservationService svc = new ReservationService();
        Customer c = new Customer("user@mail.com");
        Seat s1 = new Seat();
        Seat s2 = new Seat();

        Reservation res = svc.reserveSeats(c, Arrays.asList(s1, s2));
        assertFalse(s1.isAvailable());
        assertFalse(s2.isAvailable());

        svc.releaseSeats(res);

        assertAll("Verificar cancelacio y liberacion",
            () -> assertTrue(s1.isAvailable(), "s1 debe quedar disponible"),
            () -> assertTrue(s2.isAvailable(), "s2 debe quedar disponible"),
            () -> assertTrue(res.getSeats().isEmpty(), "La reserva debe quedar sin asientos"),
            () -> assertFalse(res.isConfirmed(), "La reserva no debe estar confirmada tras cancelarse")
        );
    }

    @Test
    @DisplayName("reserveSeats() con lista vacía: crea Reservation sin asientos y la asocia al Customer")
    void reserveSeats_withEmptyList_returnsEmptyReservation() {
        System.out.println("Reservando con lista vacia de asientos para validar caso borde");
        ReservationService svc = new ReservationService();
        Customer c = new Customer("edge@case.com");

        Reservation res = svc.reserveSeats(c, Arrays.asList());

        assertAll("Verificar creación y vinculo con el cliente en caso borde",
            () -> assertNotNull(res, "La reserva debe crearse aun sin asientos"),
            () -> assertTrue(res.getSeats().isEmpty(), "La reserva debe quedar sin asientos"),
            () -> assertTrue(c.getReservations().contains(res), "El cliente debe contener la reserva creada")
        );
    }
    
}
