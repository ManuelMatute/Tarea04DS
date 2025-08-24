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
public class PriceServiceTest {
    static class FixedPolicy implements PricePolicy {
    private final double v;
    FixedPolicy(double v){ this.v = v; }
    @Override public double calculatePrice(Reservation r){ return v; }
    }
    
    public PriceServiceTest() {
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
  void bestPrice_emptyPolicies_returnsMaxValue() {
    PriceService svc = new PriceService();
    double best = svc.getBestPrice(new Reservation());
    assertEquals(Double.MAX_VALUE, best);
  }

  @Test
  void bestPrice_picksMinimumAmongPolicies() {
    PriceService svc = new PriceService();
    svc.addPolicy(new FixedPolicy(120));
    svc.addPolicy(new FixedPolicy(80));
    svc.addPolicy(new FixedPolicy(100));
    double best = svc.getBestPrice(new Reservation());
    assertEquals(80.0, best);
  }
}
