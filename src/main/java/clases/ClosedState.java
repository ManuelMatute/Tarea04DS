/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
public class ClosedState implements TicketState {
    @Override
    public void handle(SupportTicket ticket) {
        System.out.println("Ticket cerrado. Caso resuelto.");
    }

    @Override
    public TicketStatus getStatus() {
        return TicketStatus.CLOSED;
    }
}
