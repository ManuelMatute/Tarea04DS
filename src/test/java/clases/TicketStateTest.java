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

/**
 *
 * @author Manue
 */
public class TicketStateTest {
    
    public TicketStateTest() {
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

    @Test void openState_statusOPEN(){ assertEquals(TicketStatus.OPEN, new OpenState().getStatus()); }
  @Test void closedState_statusCLOSED(){ assertEquals(TicketStatus.CLOSED, new ClosedState().getStatus()); }
  @Test void escalatedState_statusESCALATED(){ assertEquals(TicketStatus.ESCALATED, new EscalatedState().getStatus()); }

    public class TicketStateImpl implements TicketState {

        public void handle(SupportTicket ticket) {
        }

        public TicketStatus getStatus() {
            return null;
        }
    }
    
}
