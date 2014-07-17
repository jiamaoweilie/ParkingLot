import com.google.common.base.Optional;

import java.util.List;

public class MoreSmartParkingBoy extends ParkingBoy {
    public MoreSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Optional<Ticket> park(Car car){
        ParkingLot resultLot = parkingLotList.get(0);
        for(ParkingLot lot : parkingLotList){
            double rate = ((double)lot.getSpaceNum())/lot.getTotalNum();
            if(rate<(((double)resultLot.getSpaceNum())/resultLot.getSpaceNum()))
                resultLot = lot;
        }
        return resultLot.parking(car);
    }
}
