/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamental;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph
 */
public class EventNotifier {
    private List<EventObserver> observers = new ArrayList<>();
    
    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }
    
    public void notifyObservers(String eventName, String message) {
        for (EventObserver observer : observers) {
            observer.update(eventName, message);
        }
    }
}
