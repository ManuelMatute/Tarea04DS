/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;
import clases.Ticket;
/**
 *
 * @author Joseph
 */
public class BeverageDecorator extends TicketDecorator {
    private double beveragePrice;
    
    public BeverageDecorator(Ticket decoratedTicket, double beveragePrice) {
        super(decoratedTicket);
        this.beveragePrice = beveragePrice;
    }
    
    @Override
    public double getPrice() {
        return super.getPrice() + beveragePrice;
    }
    
    @Override
    public String getETicket() {
        return super.getETicket() + "\nIncluye: Bebida (+$" + beveragePrice + ")";
    }
}
