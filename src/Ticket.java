public class Ticket {
    private String CarNum;
    private int ParkingLotNum;

    public Ticket(String carNum, int parkingLotNum) {
        CarNum = carNum;
        ParkingLotNum = parkingLotNum;
    }

    public String getCarNum() {
        return CarNum;
    }

    public int getParkingLotNum() {
        return ParkingLotNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ParkingLotNum != ticket.ParkingLotNum) return false;
        if (!CarNum.equals(ticket.CarNum)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = CarNum.hashCode();
        result = 31 * result + ParkingLotNum;
        return result;
    }
}
