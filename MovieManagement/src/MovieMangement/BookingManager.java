package MovieMangement;

import java.util.List;

public interface BookingManager {

	boolean bookTicket(User user, int showIndex, List<Integer> seatNumbers);
//    boolean bookTicket(User user, int showIndex, int seatNumber);
//    boolean cancelTicket(User user, int showIndex, int seatNumber);
//    void displayShows();
//	void displaySeatsForShow(int showIndex);
//}

	boolean cancelTicket(User user, int showIndex, List<Integer> seatNumbers);

	void displayShows();

	void displayBookings(User user);

	void displaySeatsForShow(int showIndex);
}