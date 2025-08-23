/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
public class Ticket implements TicketInterface {
    private Reservation reservation;
    private double price;

    public Ticket(Reservation reservation, double price) {
        this.reservation = reservation;
        this.price = price;
    }

    @Override
    public Reservation getReservation() {
        return reservation;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getETicket() {
        return "PDF_DATA_SIMULATED";
    }
}
