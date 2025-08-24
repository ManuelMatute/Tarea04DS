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
public class TicketServiceTest {
    
    public TicketServiceTest() {
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

    static class FakePayOK implements PaymentProcessor {
    @Override public PaymentResult processPayment(double amount){ return new PaymentResult(true); }
    }
    static class FakePayFail implements PaymentProcessor {
    @Override public PaymentResult processPayment(double amount){ return new PaymentResult(false); }
    }
    static class FixedPolicy implements PricePolicy {
    private final double v; FixedPolicy(double v){ this.v=v; }
    @Override public double calculatePrice(Reservation r){ return v; }
    }
    static class DummyRefund implements RefundStrategy {
    @Override public boolean processRefund(Ticket t){ return true; }
    }

    @Test
    void purchase_success_returnsTicket() {
        TicketService svc = new TicketService(new FakePayOK(), new FixedPolicy(50), new DummyRefund());
        Ticket t = svc.purchase(new Reservation());
        assertNotNull(t);
        assertEquals(50.0, t.getPrice());
     }

    @Test
    void purchase_fail_returnsNull() {
        TicketService svc = new TicketService(new FakePayFail(), new FixedPolicy(50), new DummyRefund());
        Ticket t = svc.purchase(new Reservation());
        assertNull(t);
    }
    
}
