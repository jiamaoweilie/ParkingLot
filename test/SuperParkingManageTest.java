import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wjia on 7/24/14.
 */
public class SuperParkingManageTest {
    ParkingService superParkingManage;
    ParkingService parkingManage1;
    ParkingService parkingManage2;
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
        parkingManage1 = new ParkingManage(parkingBoys);
        parkingManage2 = new ParkingManage(null);
        List<ParkingService> parkingManages = new ArrayList<ParkingService>();
        parkingManages.add(parkingManage1);
        parkingManages.add(parkingManage2);
        superParkingManage = new ParkingManage(parkingManages);
    }

    @Test
    public void shouldPark() {
        assertThat(superParkingManage.park(new Car("12345")), is(Optional.of(new Ticket("12345",1))));
    }

    @Test
    public void shouldGetCar() {
        Car car = new Car("12345");
        Optional<Ticket> ticket = superParkingManage.park(car);
        assertThat(superParkingManage.unPark(ticket), is(Optional.of(car)));

    }
}
