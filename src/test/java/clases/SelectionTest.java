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
public class SelectionTest {
    
    public SelectionTest() {
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
    @DisplayName("addSeat() + getSeats(): agrega y expone los asientos añadidos")
    void addSeat_and_getSeats() {
        System.out.println("Agregando 3 asientos a la Selection y verificando tamaño/lista");
        Selection sel = new Selection();
        sel.addSeat(new Seat());
        sel.addSeat(new Seat());
        sel.addSeat(new Seat());

        assertAll("Verificar almacenamiento",
            () -> assertEquals(3, sel.getSeats().size(), "Debe haber 3 asientos"),
            () -> assertTrue(sel.getSeats().stream().allMatch(s -> s instanceof Seat), "Todos deben ser Seat")
        );
    }

    @Test
    @DisplayName("getAvailableSeats(): filtra correctamente solo los disponibles")
    void getAvailableSeats_filtersOnlyFree() {
        System.out.println("Mezclando asientos libres y reservados para comprobar el filtro");
        Selection sel = new Selection();
        Seat a = new Seat();
        Seat b = new Seat();
        Seat c = new Seat();
        b.reserve();
        sel.addSeat(a); sel.addSeat(b); sel.addSeat(c);

        List<Seat> available = sel.getAvailableSeats();

        assertAll("Verificar filtro por disponibilidad",
            () -> assertEquals(2, available.size(), "Deben quedar 2 disponibles"),
            () -> assertTrue(available.stream().allMatch(Seat::isAvailable), "Todos los devueltos deben estar disponibles")
        );
    }

    @Test
    @DisplayName("getAvailableSeats() con lista vacía: retorna lista vacia")
    void getAvailableSeats_whenEmpty_returnsEmptyList() {
        System.out.println("Selection vacía: la lista de disponibles debe estar vacia");
        Selection sel = new Selection();
        assertTrue(sel.getAvailableSeats().isEmpty(), "No debe haber asientos disponibles");
    }
}
