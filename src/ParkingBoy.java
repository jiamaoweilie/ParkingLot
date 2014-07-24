import com.google.common.base.Optional;

import java.util.List;

public class ParkingBoy implements ParkingService {
    private final Chooser chooser;
    protected List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList, Chooser chooser1) {
        this.parkingLotList = parkingLotList;
        chooser = chooser1;
    }


    @Override
    public Optional<Ticket> park(Car car) {
        ParkingLot result = chooser.chooseLot(parkingLotList);
        return result.parking(car);
    }

    @Override
    public Optional<Car> unPark(Optional<Ticket> ticket) {
        for(ParkingLot lot : parkingLotList) {
            if (lot.getParkingLotNum() == ticket.get().getParkingLotNum())
                return lot.unParking(ticket);
        }
        return Optional.absent();
    }

}
