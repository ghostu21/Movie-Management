package MovieMangement;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private Movie movie;
    private String timing;
    private List<Seat> seats;

    public Show(Movie movie, String timing, int totalSeats) {
        this.movie = movie;
        this.timing = timing;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTiming() {
        return timing;
    }

    public int getTotalSeats() {
        return seats.size();
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getAvailableSeats() {
        int availableSeats = 0;
        for (Seat seat : seats) {
            if (seat.getStatus() == SeatStatus.AVAILABLE) {
                availableSeats++;
            }
        }
        return availableSeats;
    }
    public int getBookedSeats() {
        return getTotalSeats() - getAvailableSeats();
    }
}