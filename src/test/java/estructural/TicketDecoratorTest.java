/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package estructural;

import clases.Reservation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import clases.Ticket;
import clases.Reservation;


/**
 *
 * @author Manue
 */
public class TicketDecoratorTest {
    
    public TicketDecoratorTest() {
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
void beverage_addsPriceAndText() {
    Ticket base = new Ticket(new Reservation(), 20.0); 
    BeverageDecorator deco = new BeverageDecorator(base, 5.0); 
    assertEquals(25.0, deco.getPrice());
    assertTrue(deco.getETicket().contains("Bebida (+$5"));
}

  @Test
  void beverage_nullDecorated_throwsIAE() {
    assertThrows(IllegalArgumentException.class, () -> new BeverageDecorator(null, 5));
  }

    public class TicketDecoratorImpl extends TicketDecorator {

        public TicketDecoratorImpl() {
            super(null);
        }
    }
    
}
