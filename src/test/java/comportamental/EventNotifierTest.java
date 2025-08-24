/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package comportamental;

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
public class EventNotifierTest {
    
    public EventNotifierTest() {
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

    /**
     * Test of addObserver method, of class EventNotifier.
     */
    @Test
    public void testAddObserver() {
        System.out.println("addObserver");
        EventObserver observer = null;
        EventNotifier instance = new EventNotifier();
        instance.addObserver(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    static class CapturingObserver implements EventObserver {
    String last;
    @Override public void update(String eventName, String message) { last = eventName + "|" + message; }
  }

  @Test
  void notifyObservers_callsUpdate() {
    EventNotifier n = new EventNotifier();
    CapturingObserver obs = new CapturingObserver();
    n.addObserver(obs);
    n.notifyObservers("EVENTO", "Mensaje");
    assertEquals("EVENTO|Mensaje", obs.last);
  }
    
}
