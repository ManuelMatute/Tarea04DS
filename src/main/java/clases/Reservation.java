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

public class Reservation {
    private List<Seat> seats = new ArrayList<>();
    private List<Option> options = new ArrayList<>();
    private boolean confirmed = false;

    
    
    // NUEVO: Método que encapsula la lógica de reservar múltiples asientos
    public void reserveSeats(List<Seat> seatsToReserve) {
        for (Seat seat : seatsToReserve) {
            if (!seat.isAvailable()) {
                throw new IllegalStateException("Asiento no disponible");
            }
            addSeat(seat);
        }
    }
    
    
    // MEJORADO: Más expresivo sobre lo que hace
    public void addSeat(Seat seat) {
        if (seats.contains(seat)) {
            throw new IllegalArgumentException("Asiento ya está reservado");
        }
        seats.add(seat);
        seat.reserve();
    }
    // NUEVO: Método más expresivo para cancelación completa
        public void cancelAndReleaseAllSeats() {
            for (Seat seat : seats) {
                seat.release();
            }
            seats.clear();
            confirmed = false;
        }
    public void removeSeat(Seat seat) {
        seats.remove(seat);
        seat.release();
    }

    public void confirm() {
        confirmed = true;
    }

    

    public void addOption(Option option) {
        options.add(option);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Option> getOptions() {
        return options;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
