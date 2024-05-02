package MovieMangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Movie movie1 = new Movie("Movie 1", "Action");
        Movie movie2 = new Movie("Movie 2", "Comedy");

        
        Show show1 = new Show(movie1, "10:00 AM", 50);
        Show show2 = new Show(movie1, "1:00 PM", 50);

        
        Show show3 = new Show(movie2, "11:00 AM", 50);
        Show show4 = new Show(movie2, "3:00 PM", 50);


        List<Show> shows = new ArrayList<>();
        shows.add(show1);
        shows.add(show2);
        shows.add(show3);
        shows.add(show4);


        BookingManagerImpl bookingManager = new BookingManagerImpl(shows);


        // Displaying All the shows
        bookingManager.displayShows();

        User user1 = new User("John");
        User user2 = new User("Alice");
        
        //Display the seats
        bookingManager.displaySeatsForShow(0);
        bookingManager.displaySeatsForShow(2);


        // book the tickets for the show
        List<Integer> bookedSeatsUser1 = Arrays.asList(1, 2, 3);
        bookingManager.bookTicket(user1, 0, bookedSeatsUser1); 

        List<Integer> bookedSeatsUser2 = Arrays.asList(4, 5);
        bookingManager.bookTicket(user2, 2, bookedSeatsUser2); 

    
        bookingManager.displayBookings(user1);
        bookingManager.displayBookings(user2);

   
        List<Integer> cancelledSeatsUser1 = Arrays.asList(1);
        bookingManager.cancelTicket(user1, 0, cancelledSeatsUser1);


        bookingManager.displayBookings(user1);
        bookingManager.displaySeatsForShow(0);
        bookingManager.displaySeatsForShow(2);
    }
}


