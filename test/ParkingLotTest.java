import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {
    ParkingLot parkingLot;
    int spaceNum = 50;
    int parkingLotNum = 1;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(parkingLotNum, spaceNum);
    }

    @Test
    public void shouldParking() {
        Ticket ticket = parkingLot.parking(new Car("12345"));
        assertNotNull(ticket);
    }

    @Test
    public void shouldParkingWhenParkingLotIsNotFull() {
        Ticket ticket = parkingLot.parking(new Car("12345"));
        assertThat(ticket, is(new Ticket("12345", 1)));
    }

    @Test
    public void shouldParkingAndParking() {
        parkingLot.parking(new Car("12345"));
        parkingLot.parking(new Car("12344"));
        assertThat(parkingLot.getSpaceNum(), is(spaceNum - 2));
    }

    @Test
    public void shouldNotParkingWhenParkingLotIsFull() {
        spaceNum = 0;
        parkingLot.setSpaceNum(spaceNum);
        Ticket ticket = parkingLot.parking(new Car("12345"));
        assertThat(ticket, is(nullValue()));
    }

    @Test
    public void shouldUnParking() {
        Car car = new Car("12345");
        parkingLot.parking(car);
        Car resultCar = parkingLot.unParking(new Ticket(car.getCarNum(),1));
        assertThat(resultCar, is(car));
    }

    @Test
    public void shouldUnParkingAndUnParking() {
        Car car1 = new Car("12345");
        Car car2 = new Car("12346");
        Ticket ticket1 = parkingLot.parking(car1);
        Ticket ticket2 = parkingLot.parking(car2);
        parkingLot.unParking(ticket1);
        parkingLot.unParking(ticket2);
        assertThat(parkingLot.getSpaceNum(), is(spaceNum));
    }

    @Test
    public void shouldNotUnParkingWhenCarIsNotInParkingLot() {
        Car car = new Car("12345");
        Car resultCar = parkingLot.unParking(new Ticket(car.getCarNum(), 1));
        assertThat(resultCar, is(nullValue()));
    }
}
