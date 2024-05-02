package MovieMangement;

import java.util.*;

class BookingManagerImpl implements BookingManager {
    private List<Show> shows;
    private List<Booking> bookings;

    public BookingManagerImpl(List<Show> shows) {
        this.shows = shows;
        this.bookings = new ArrayList<>();
    }

    
    @Override
    public boolean bookTicket(User user, int showIndex, List<Integer> seatNumbers) {
        if (showIndex < 0 || showIndex >= shows.size()) {
            System.out.println("Invalid show");
            return false;
        }

        Show show = shows.get(showIndex);
        boolean allSeatsBooked = true;
        Booking booking = new Booking(user, show);
        for (int seatNumber : seatNumbers) {
            if (seatNumber < 1 || seatNumber > show.getTotalSeats()) {
                System.out.println("Invalid seat number: " + seatNumber);
                allSeatsBooked = false;
                continue;
            }

            Seat seat = show.getSeats().get(seatNumber - 1);
            if (seat.getStatus() == SeatStatus.AVAILABLE) {
                seat.setStatus(SeatStatus.BOOKED);
                booking.addBookedSeat(seat);
                System.out.println(user.getName() + " booked seat number " + seatNumber + " for show: " + show.getMovie().getTitle() + " at " + show.getTiming());
            } else {
                System.out.println("Seat number " + seatNumber + " is not available for show: " + show.getMovie().getTitle() + " at " + show.getTiming());
                allSeatsBooked = false;
            }
        }
        if (allSeatsBooked) {
            bookings.add(booking);
        }
        return allSeatsBooked;
    }


    @Override
    public boolean cancelTicket(User user, int showIndex, List<Integer> seatNumbers) {
        if (showIndex < 0 || showIndex >= shows.size()) {
            System.out.println("Invalid show");
            return false;
        }

        Show show = shows.get(showIndex);
        boolean allSeatsCancelled = true;
        for (int seatNumber : seatNumbers) {
            if (seatNumber < 1 || seatNumber > show.getTotalSeats()) {
                System.out.println("Invalid seat number: " + seatNumber);
                allSeatsCancelled = false;
                continue;
            }

            Seat seat = show.getSeats().get(seatNumber - 1);
            if (seat.getStatus() == SeatStatus.BOOKED) {
                seat.setStatus(SeatStatus.AVAILABLE);
                System.out.println(user.getName() + " cancelled the booked seat number " + seatNumber + " for show: " + show.getMovie().getTitle() + " at " + show.getTiming());
            } else {
                System.out.println("Seat number " + seatNumber + " is not booked for show: " + show.getMovie().getTitle() + " at " + show.getTiming());
                allSeatsCancelled = false;
            }
        }
        if (allSeatsCancelled) {
            removeBooking(user, showIndex);
        }
        return allSeatsCancelled;
    }

    private void removeBooking(User user, int showIndex) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getUser().equals(user) && booking.getShow().equals(shows.get(showIndex))) {
                iterator.remove();
                break;
            }
        }
    }


    @Override
    public void displayShows() {
        System.out.println("Available Movies and Show Timings:");
        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            System.out.println((i + 1) + ". " + show.getMovie().getTitle() + " at " + show.getTiming());
        }
    }

    @Override
    public void displayBookings(User user) {
        System.out.println("Bookings for User: " + user.getName());
        for (Booking booking : bookings) {
            if (booking.getUser().equals(user)) {
                Show show = booking.getShow();
                System.out.println("Show: " + show.getMovie().getTitle() + " at " + show.getTiming());
                System.out.print("Booked Seats: ");
                for (Seat seat : booking.getBookedSeats()) {
                    System.out.print(seat.getNumber() + " ");
                }
                System.out.println();
            }
        }
    }
    @Override
    public void displaySeatsForShow(int showIndex) {
        if (showIndex < 0 || showIndex >= shows.size()) {
            System.out.println("Invalid show");
            return;
        }

        Show show = shows.get(showIndex);
        System.out.println("Show Timing: " + show.getTiming() + " for Movie: " + show.getMovie().getTitle());
        System.out.println("Available Seats:");
        for (Seat seat : show.getSeats()) {
            if (seat.getStatus() == SeatStatus.AVAILABLE) {
                System.out.print(seat.getNumber() + " ");
            }
        }
        System.out.print("\nBooked Seats:");
        for (Seat seat : show.getSeats()) {
            if (seat.getStatus() == SeatStatus.BOOKED) {
                System.out.print(seat.getNumber() + " ");
            }
        }
        System.out.println("\n");
    }
}