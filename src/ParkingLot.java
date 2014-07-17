import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int spaceNum;
    private int parkingLotNum;
    private List<Car> carList = new ArrayList<Car>();

    public ParkingLot(int parkingLotNum, int spaceNum) {
        this.spaceNum = spaceNum;
        this.parkingLotNum = parkingLotNum;
    }



    public int getParkingLotNum() {
        return parkingLotNum;
    }

    public Optional<Ticket> parking(Car car) {
        if(spaceNum >0) {
            spaceNum--;
            carList.add(car);
            return Optional.of(new Ticket(car.getCarNum(),parkingLotNum));
        }
        else
            return Optional.absent();
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    public Optional<Car> unParking(Optional<Ticket> ticket) {
        for(Car car : carList) {
            if(ticket.get().getCarNum().equals(car.getCarNum())) {
                spaceNum++;
                carList.remove(carList.indexOf(car));
                return Optional.of(new Car(ticket.get().getCarNum()));
            }
        }
        return Optional.absent();
    }
}
