/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
public class OpenState implements TicketState{
   @Override
    public void handle(SupportTicket ticket) {
        System.out.println("Ticket abierto. En espera de atención.");
    }

    @Override
    public TicketStatus getStatus() {
        return TicketStatus.OPEN;
    }
}