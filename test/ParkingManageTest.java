import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingManageTest {
    ParkingService parkingManage;
    ParkingService parkingBoy1;
    ParkingService parkingBoy2;
    ParkingLot lot1;
    ParkingLot lot2;
    ParkingLot lot3;
    ParkingLot lot4;

    @Before
    public void setUp() throws Exception {
        List<ParkingLot> parkingLotList1 = new ArrayList<ParkingLot>();
        List<ParkingLot> parkingLotList2 = new ArrayList<ParkingLot>();
        lot1 = new ParkingLot(1, 2);
        lot2 = new ParkingLot(2, 3);
        lot3 = new ParkingLot(3, 3);
        lot4 = new ParkingLot(4, 3);
        parkingLotList1.add(lot1);
        parkingLotList1.add(lot2);
        parkingLotList2.add(lot3);
        parkingLotList2.add(lot4);
        parkingBoy1 = new ParkingBoy(parkingLotList1, new NormalChooser());
        parkingBoy2 = new ParkingBoy(parkingLotList2, new NormalChooser());
        List<ParkingService> parkingBoys = new ArrayList<ParkingService>();
        parkingBoys.add(parkingBoy1);
        parkingBoys.add(parkingBoy2);
        parkingManage = new ParkingManage(parkingBoys);
    }

    @Test
    public void shouldParkCar() {
        Optional<Ticket> ticket = parkingManage.park(new Car("12345"));
        assertThat(ticket, is(Optional.of(new Ticket("12345", 1))));
    }

    @Test
    public void shouldParkto2() {
        lot1.setSpaceNum(0);
        lot2.setSpaceNum(0);
        Optional<Ticket> ticket = parkingManage.park(new Car("12345"));
        assertThat(ticket, is(Optional.of(new Ticket("12345", 3))));
    }

    @Test
    public void shouldGetCar() {
        Car car = new Car("123");
        Optional<Ticket> ticket = parkingManage.park(car);
        assertThat(parkingManage.unPark(ticket), is(Optional.of(car)));
    }
}