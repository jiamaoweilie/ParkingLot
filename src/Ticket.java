public class Ticket {
    private String CarNum;
    private int ParkingNum;

    public Ticket(String carNum, int parkingNum) {
        CarNum = carNum;
        ParkingNum = parkingNum;
    }

    public String getCarNum() {
        return CarNum;
    }

    public int getParkingNum() {
        return ParkingNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ParkingNum != ticket.ParkingNum) return false;
        if (!CarNum.equals(ticket.CarNum)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = CarNum.hashCode();
        result = 31 * result + ParkingNum;
        return result;
    }
}
