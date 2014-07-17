import com.google.common.base.Optional;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Optional<Ticket> park(Car car) {
        for(ParkingLot lot : parkingLotList){
            if(lot.getSpaceNum()>0)
                return lot.parking(car);
        }
        return Optional.absent();
    }

    public Optional<Car> unPark(Optional<Ticket> ticket) {
        for(ParkingLot lot : parkingLotList) {
            if (lot.getParkingLotNum() == ticket.get().getParkingNum())
                return lot.unParking(ticket);
        }
        return Optional.absent();
    }
}
