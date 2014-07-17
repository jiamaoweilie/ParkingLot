import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoreSmartParkingBoyTest {
    MoreSmartParkingBoy moreSmartParkingBoy;
    ParkingLot lot1;
    ParkingLot lot2;
    List<ParkingLot> parkingLotList;
    Car car;
    @Before
    public void setUp() throws Exception {
        lot1 = new ParkingLot(1,10);
        lot2 = new ParkingLot(2,8);
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);
        moreSmartParkingBoy = new MoreSmartParkingBoy(parkingLotList);
        car = new Car("12345");
    }

    @Test
    public void shouldParking() {
        lot1.setSpaceNum(6);
        lot2.setSpaceNum(6);
        Optional<Ticket> ticket = moreSmartParkingBoy.park(car);
        assertThat(ticket,is(Optional.of(new Ticket("12345",2))));
    }

    @Test
    public void shouldUnParking() {
        Optional<Ticket> ticket = moreSmartParkingBoy.park(car);
        Optional<Car> carResult = moreSmartParkingBoy.unPark(ticket);
        assertThat(carResult, is(Optional.of(car)));
    }
}
