import com.google.common.base.Optional;

/**
 * Created by wjia on 7/24/14.
 */
public interface ParkingService {
    Optional<Ticket> park(Car car);

    Optional<Car> unPark(Optional<Ticket> ticket);
}
