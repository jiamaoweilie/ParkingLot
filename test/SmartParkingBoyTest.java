import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {

    ParkingBoy parkingBoy;
    ParkingLot lot1;
    ParkingLot lot2;
    Car car;

    @Before
    public void setUp() throws Exception {
        lot1 = new ParkingLot(1,1);
        lot2 = new ParkingLot(2,2);
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);
        parkingBoy = new ParkingBoy(parkingLotList, new SmartChooser());
        car = new Car("12345");
    }

    @Test
    public void shouldParking() {
        Optional<Ticket> ticket = parkingBoy.park(car);
        assertThat(ticket,is(Optional.of(new Ticket("12345",2))));
    }


    @Test
    public void shouldUnParking() {
        Optional<Ticket> ticket = parkingBoy.park(car);
        Optional<Car> carResult = parkingBoy.unPark(ticket);
        assertThat(carResult, is(Optional.of(car)));
    }
}
