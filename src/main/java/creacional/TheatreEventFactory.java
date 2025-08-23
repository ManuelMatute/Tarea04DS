/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creacional;
import clases.Event;
import clases.EventType;
/**
 *
 * @author Joseph
 */
public class TheatreEventFactory implements EventFactory {
    @Override
    public Event createEvent() {
        return new Event(EventType.THEATRE) {
            @Override
            public String getEventDetails() {
                return "Obra de teatro con actores profesionales";
            }
        };
    }
}
