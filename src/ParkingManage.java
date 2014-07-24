import com.google.common.base.Optional;

import java.util.List;

/**
 * Created by wjia on 7/24/14.
 */
public class ParkingManage implements ParkingService{
    private List<ParkingService> parkingServices;
    public ParkingManage(List<ParkingService> parkingServices) {
        this.parkingServices = parkingServices;
    }

    public Optional<Ticket> park(Car car) {
        for (ParkingService parkingBoy : parkingServices) {
            Optional<Ticket> ticket = parkingBoy.park(car);
            if (ticket.isPresent())
                return ticket;
        }
        return Optional.absent();
    }

    public Optional<Car> unPark(Optional<Ticket> ticket) {
        for(ParkingService parkingBoy : parkingServices){
            Optional<Car> car = parkingBoy.unPark(ticket);
            if(car.isPresent())
                return car;
        }
        return Optional.absent();
    }
}
