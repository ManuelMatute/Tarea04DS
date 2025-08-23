/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private EventType type;
    private List<Show> shows = new ArrayList<>();

    public Event(EventType type) {
        this.type = type;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }

    public EventType getType() {
        return type;
    }
    public abstract String getEventDetails();
}

