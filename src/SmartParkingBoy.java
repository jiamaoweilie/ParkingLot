import com.google.common.base.Optional;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Optional<Ticket> park(Car car) {
        ParkingLot large = parkingLotList.get(0);
        for (ParkingLot lot : parkingLotList) {
            if(lot.getSpaceNum()>large.getSpaceNum()) {
                large = lot;
            }
        }
        return large.parking(car);
    }
}
