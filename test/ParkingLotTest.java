import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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
        Optional<Ticket> ticket = parkingLot.parking(new Car("12345"));
        assertNotNull(ticket);
    }

    @Test
    public void shouldParkingWhenParkingLotIsNotFull() {
        Optional<Ticket> ticket = parkingLot.parking(new Car("12345"));
        assertThat(ticket, is(Optional.of(new Ticket("12345", 1))));
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
        Optional<Ticket> ticket = parkingLot.parking(new Car("12345"));
        assertEquals(Optional.fromNullable(null), ticket);
    }

    @Test
    public void shouldUnParking() {
        Car car = new Car("12345");
        parkingLot.parking(car);
        Optional<Car> resultCar = parkingLot.unParking(Optional.of(new Ticket(car.getCarNum(), 1)));
        assertThat(resultCar, is(Optional.of(car)));
    }

    @Test
    public void shouldUnParkingAndUnParking() {
        Car car1 = new Car("12345");
        Car car2 = new Car("12346");
        Optional<Ticket> ticket1 = parkingLot.parking(car1);
        Optional<Ticket> ticket2 = parkingLot.parking(car2);
        parkingLot.unParking(ticket1);
        parkingLot.unParking(ticket2);
        assertThat(parkingLot.getSpaceNum(), is(spaceNum));
    }

    @Test
    public void shouldNotUnParkingWhenCarIsNotInParkingLot() {
        Car car = new Car("12345");
        Optional<Car> resultCar = parkingLot.unParking(Optional.of(new Ticket(car.getCarNum(), 1)));
        assertEquals(Optional.fromNullable(null), resultCar);
    }
}
