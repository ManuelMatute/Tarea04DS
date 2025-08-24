package estructural;
import clases.Reservation;
import clases.TicketInterface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// TicketDecorator REFACTORIZADO - Sin herencia, usando Composition
public abstract class TicketDecorator implements TicketInterface {
    protected final TicketInterface decoratedTicket;
    
    public TicketDecorator(TicketInterface decoratedTicket) {
        if (decoratedTicket == null) {
            throw new IllegalArgumentException("Decorated ticket no puede null");
        }
        this.decoratedTicket = decoratedTicket;
    }
    
    // DELEGATION: Delega al objeto decorado sin conocer su estructura interna
    @Override
    public Reservation getReservation() {
        return decoratedTicket.getReservation();
    }
    
    @Override
    public double getPrice() {
        return decoratedTicket.getPrice();
    }
    
    @Override
    public String getETicket() {
        return decoratedTicket.getETicket();
    }
}
