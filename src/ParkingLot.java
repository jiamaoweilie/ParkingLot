import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int parkingNum;
    private List<Car> carList = new ArrayList<Car>();

    public ParkingLot(int parkingNum) {
        this.parkingNum = parkingNum;
    }

    public String parking(Car car) {
        if(parkingNum>0) {
            parkingNum--;
            carList.add(car);
            return car.getCarNum();
        }
        else
            return "ParkingLot is full!";
    }

    public int getParkingNum() {
        return parkingNum;
    }

    public void setParkingNum(int parkingNum) {
        this.parkingNum = parkingNum;
    }

    public Car unParking(String carNum) {
        for(Car car : carList) {
            if(carNum.equals(car.getCarNum())) {
                parkingNum++;
                carList.remove(carList.indexOf(car));
                return new Car(carNum);
            }
        }
        return null;
    }
}
