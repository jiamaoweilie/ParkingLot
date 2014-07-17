import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    ParkingBoy parkingBoy;
    ParkingLot lot1;
    ParkingLot lot2;

    @Before
    public void setUp() throws Exception {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        lot1 = new ParkingLot(1, 50);
        lot2 = new ParkingLot(2, 50);
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);
        parkingBoy = new ParkingBoy(parkingLotList);
    }

    @Test
    public void shouldParkingCarWhenTwoParkingLotIsEmpty() {
        Optional<Ticket> ticket = parkingBoy.park(new Car("12345"));
        assertThat(ticket, is(Optional.of(new Ticket("12345", 1))));
    }

    @Test
    public void shouldParkingCarWhenLot1IsFullAndLot2IsNotFull() {
        lot1.setSpaceNum(0);
        lot2.setSpaceNum(23);
        Optional<Ticket> ticket = parkingBoy.park(new Car("12345"));
        assertThat(ticket, is(Optional.of(new Ticket("12345",2))));
    }

    @Test
    public void shouldNotParkingWhenLotsIsFull() {
        lot1.setSpaceNum(0);
        lot2.setSpaceNum(0);
        Optional<Ticket> ticket = parkingBoy.park(new Car("123456"));
        assertEquals(ticket, Optional.fromNullable(null));
    }

    @Test
    public void shouldUnParkingWhenCarIsInParkingLots() {
        Car car = new Car("12345");
        Optional<Ticket> ticket = parkingBoy.park(car);
        Optional<Car> resultCar = parkingBoy.unPark(ticket);
        assertEquals(Optional.of(car),resultCar);
    }

    @Test
    public void shouldNotUnParkingWhenCarIsNotInParkingLots() {
        Optional<Car> resultCar = parkingBoy.unPark(Optional.of(new Ticket("12345",1)));
        assertEquals(Optional.fromNullable(null),resultCar);
    }
}
