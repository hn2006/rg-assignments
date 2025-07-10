package Question_5;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setModel("BMW");
        car.accelerate(100);
        System.out.println(car.getModel() + " moving at " + car.getSpeed() + " km/h");
    }
}
