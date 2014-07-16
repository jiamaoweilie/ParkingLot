public class Car {
    private String carNum;

    public Car(String carNum) {
        this.carNum = carNum;
    }

    public String getCarNum() {
        return carNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!carNum.equals(car.carNum)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return carNum.hashCode();
    }
}
