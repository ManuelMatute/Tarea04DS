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
public class RefundStrategyTest {
    
    public RefundStrategyTest() {
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
  void noRefund_returnsFalse() {
    RefundStrategy s = new NoRefundStrategy();
    assertFalse(s.processRefund(new Ticket(new Reservation(), 10)));
  }

  @Test
  void standardRefund_returnsTrue() {
    RefundStrategy s = new StandardRefundStrategy();
    assertTrue(s.processRefund(new Ticket(new Reservation(), 10)));
  }
    
}
