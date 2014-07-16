import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        for(ParkingLot lot : parkingLotList){
            if(lot.getSpaceNum()>0)
                return lot.parking(car);
        }
        return null;
    }
}
