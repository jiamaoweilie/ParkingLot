import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
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
        Ticket ticket = parkingBoy.park(new Car("12345"));
        assertThat(ticket, is(new Ticket("12345",1)));
    }

    @Test
    public void shouldParkingCarWhenLot1IsFullAndLot2IsNotFull() {
        lot1.setSpaceNum(0);
        lot2.setSpaceNum(23);
        Ticket ticket = parkingBoy.park(new Car("12345"));
        assertThat(ticket, is(new Ticket("12345",2)));
    }

    @Test
    public void shouldNotParkingWhenLotsIsFull() {
        lot1.setSpaceNum(0);
        lot2.setSpaceNum(0);
        Ticket ticket = parkingBoy.park(new Car("123456"));
        assertThat(ticket, is(nullValue()));

    }
}
