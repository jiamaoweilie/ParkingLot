import java.util.List;

/**
* Created by wjia on 7/17/14.
*/
class NormalChooser implements Chooser {
    @Override
    public ParkingLot chooseLot(List<ParkingLot> parkingLotList1) {
        ParkingLot result = parkingLotList1.get(0);
        for (ParkingLot lot : parkingLotList1) {
            if (lot.getSpaceNum() > 0) {
                result = lot;
                break;
            }

        }
        return result;
    }

}
