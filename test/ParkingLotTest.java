import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {
    ParkingLot parkingLot;
    int parkingNum = 50;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(parkingNum);
    }

    @Test
    public void shouldParking() {
        String result = parkingLot.parking(new Car("12345"));
        assertNotNull(result);
    }

    @Test
    public void shouldParkingWhenParkingLotIsNotFull() {
        String resultCarNum = parkingLot.parking(new Car("12345"));
        assertThat(resultCarNum,is("12345"));
    }

    @Test
    public void shouldParkingAndParking() {
        parkingLot.parking(new Car("12345"));
        parkingLot.parking(new Car("12344"));
        assertThat(parkingLot.getParkingNum(),is(parkingNum-2));
    }

    @Test
    public void shouldNotParkingWhenParkingLotIsFull() {
        parkingNum =0;
        parkingLot.setParkingNum(parkingNum);
        String resultString = parkingLot.parking(new Car("12345"));
        assertThat(resultString, is("ParkingLot is full!"));
    }

    @Test
    public void shouldUnParking() {
        Car car = new Car("12345");
        parkingLot.parking(car);
        Car resultCar = parkingLot.unParking(car.getCarNum());
        assertThat(resultCar, is(car));
    }

    @Test
    public void shouldUnParkingAndUnParking() {
        Car car1 = new Car("12345");
        Car car2 = new Car("12346");
        parkingLot.parking(car1);
        parkingLot.parking(car2);
        parkingLot.unParking(car1.getCarNum());
        parkingLot.unParking(car2.getCarNum());
        assertThat(parkingLot.getParkingNum(), is(parkingNum));
    }

    @Test
    public void shouldNotUnParkingWhenCarIsNotInParkingLot() {
        Car car = new Car("12345");
        Car resultCar = parkingLot.unParking(car.getCarNum());
        assertThat(resultCar, is(nullValue()));
    }
}
