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
public class ShowTest {
    
    public ShowTest() {
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
    @DisplayName("addSection() + getSections(): agrega secciones y las expone")
    void addSection_and_getSections() {
        System.out.println("Agregando 2 secciones y verificando tamaño de la lista");
        Show s = new Show();
        Selection a = new Selection();
        Selection b = new Selection();
        s.addSection(a);
        s.addSection(b);

        assertAll("Verificar almacenamiento de secciones",
            () -> assertEquals(2, s.getSections().size(), "Deben existir 2 secciones"),
            () -> assertSame(a, s.getSections().get(0)),
            () -> assertSame(b, s.getSections().get(1))
        );
    }

    @Test
    @DisplayName("getSections() en show recién creado: lista vacia")
    void getSections_empty_onNewShow() {
        System.out.println("• Show recién creado: no debe tener secciones");
        Show s = new Show();
        assertTrue(s.getSections().isEmpty(), "Lista de secciones vacía");
    }

    @Test
    @DisplayName("addSection(null): el método actual permite insertar null (comportamiento observado)")
    void addSection_null_currentBehavior_allowsNull() {
        System.out.println("Añadiendo null como seccion para documentar comportamiento actual");
        Show s = new Show();
        s.addSection(null);

        assertAll("Verificar comportamiento con null",
            () -> assertEquals(1, s.getSections().size(), "Se añadió un elemento"),
            () -> assertNull(s.getSections().get(0), "El elemento agregado es null (comportamiento actual)")
        );
    }

    @Test
  void addSection_andList() {
    Show show = new Show();
    show.addSection(new Selection());
    show.addSection(new Selection());
    assertEquals(2, show.getSections().size());
  }
}