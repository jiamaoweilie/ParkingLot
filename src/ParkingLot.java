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

    public Ticket parking(Car car) {
        if(spaceNum >0) {
            spaceNum--;
            carList.add(car);
            return new Ticket(car.getCarNum(),parkingLotNum);
        }
        else
            return null;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    public Car unParking(Ticket ticket) {
        for(Car car : carList) {
            if(ticket.getCarNum().equals(car.getCarNum())) {
                spaceNum++;
                carList.remove(carList.indexOf(car));
                return new Car(ticket.getCarNum());
            }
        }
        return null;
    }
}
