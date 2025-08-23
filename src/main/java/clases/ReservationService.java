/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.util.List;

public class ReservationService {
    
    
    // HELPER: Validación centralizada
    private void validateSeats(List<Seat> seats) {
        if (seats == null || seats.isEmpty()) {
            throw new IllegalArgumentException("La lista de asientos no puede estar vacia o ser null");
        }
        
        for (Seat seat : seats) {
            if (seat == null) {
                throw new IllegalArgumentException("La lista de asientos no puede ser null");
            }
            if (!seat.isAvailable()) {
                throw new IllegalStateException("Uno o mas asientos no estan disponibles");
            }
        }
    }
    
    public Reservation reserveSeats(Customer customer, List<Seat> seats) {
        validateSeats(seats);
        return customer.createReservationWith(seats);
    }
    // REFACTORED: Más expresivo y delega responsabilidad
        public void cancelReservation(Customer customer, Reservation reservation) {
            boolean success = customer.cancelReservation(reservation);
            if (!success) {
                throw new IllegalArgumentException("Reservacion no encontrada para este customer");
            }
        }
    public void releaseSeats(Reservation reservation) {
        reservation.cancelAndReleaseAllSeats();
    }
}
