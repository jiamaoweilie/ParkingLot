import java.util.List;

/**
* Created by wjia on 7/17/14.
*/
class SmartChooser implements Chooser{
    public ParkingLot chooseLot(List<ParkingLot> parkingLotList1) {
        ParkingLot large = parkingLotList1.get(0);
        for (ParkingLot lot : parkingLotList1) {
            if(lot.getSpaceNum()>large.getSpaceNum()) {
                large = lot;
            }
        }
        return large;
    }

}
