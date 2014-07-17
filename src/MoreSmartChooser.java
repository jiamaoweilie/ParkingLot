import java.util.List;

/**
* Created by wjia on 7/17/14.
*/
class MoreSmartChooser implements Chooser{
    public ParkingLot chooseLot(List<ParkingLot> parkingLotList1) {
        ParkingLot resultLot = parkingLotList1.get(0);
        for(ParkingLot lot : parkingLotList1){
            double rate = ((double)lot.getSpaceNum())/lot.getTotalNum();
            if(rate<(((double)resultLot.getSpaceNum())/resultLot.getSpaceNum()))
                resultLot = lot;
        }
        return resultLot;
    }

}
