/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package clases;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
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
public class SupportTicketTest {
    
    public SupportTicketTest() {
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
    @DisplayName("Estado inicial, campos basicos y marca de tiempo valida")
    void initialState_fieldsAndTimestamp() {
        System.out.println("Creando SupportTicket nuevo (issue=PAYMENT)");
        LocalDateTime before = LocalDateTime.now();
        SupportTicket st = new SupportTicket(IssueType.PAYMENT, new Customer("c@e.com"));
        LocalDateTime after = LocalDateTime.now();

        assertAll("Validar estado inicial y metadatos",
            () -> assertEquals(TicketStatus.OPEN, st.getStatus(), "El estado inicial debe ser OPEN"),
            () -> assertEquals(IssueType.PAYMENT, st.getIssueType(), "El tipo de incidencia debe coincidir"),
            () -> assertNotNull(st.getCustomer(), "Debe tener un Customer asociado"),
            () -> assertNotNull(st.getCreatedAt(), "Debe registrar fecha/hora de creacio"),
            () -> assertTrue(!st.getCreatedAt().isBefore(before) && !st.getCreatedAt().isAfter(after),
                    "createdAt debe estar entre el inicio y fin de la creacion")
        );
    }

    @Test
    @DisplayName("escalate(): cambia a ESCALATED y muestra mensaje acorde en consola")
    void escalate_changesStatusAndPrints() {
        System.out.println("Ejecutando escalate() y capturando salida de consola");

        SupportTicket st = new SupportTicket(IssueType.ACCESS, new Customer("x@y.com"));

        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            st.escalate(); 
        } finally {
            System.setOut(original);
        }

        String out = baos.toString();
        assertAll("Validar transición a ESCALATED y mensaje",
            () -> assertEquals(TicketStatus.ESCALATED, st.getStatus(), "El estado debe ser ESCALATED"),
            () -> assertTrue(out.contains("Ticket escalado"), "Debe imprimir mensaje de escalamiento")
        );
    }

    @Test
    @DisplayName("close(): cambia a CLOSED y muestra mensaje acorde en consola")
    void close_changesStatusAndPrints() {
        System.out.println("Ejecutando close() y capturando salida de consola");

        SupportTicket st = new SupportTicket(IssueType.OTHER, new Customer("z@z.com"));

        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            st.close(); 
        } finally {
            System.setOut(original);
        }

        String out = baos.toString();
        assertAll("Validar transicion a CLOSED y mensaje",
            () -> assertEquals(TicketStatus.CLOSED, st.getStatus(), "El estado debe ser CLOSED"),
            () -> assertTrue(out.contains("Ticket cerrado"), "Debe imprimir mensaje de cierre")
        );
    }
}