package MovieMangement;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private User user;
    private Show show;
    private List<Seat> bookedSeats;

    public Booking(User user, Show show) {
        this.user = user;
        this.show = show;
        this.bookedSeats = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void addBookedSeat(Seat seat) {
        bookedSeats.add(seat);
    }

    public void removeBookedSeat(Seat seat) {
        bookedSeats.remove(seat);
    }
}