package MovieMangement;

public class Seat {
	private int number;
    private SeatStatus status;

    public Seat(int number) {
        this.number = number;
        this.status = SeatStatus.AVAILABLE;
    }

    public int getNumber() {
        return number;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

}
