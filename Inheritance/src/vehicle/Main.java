package vehicle;

public class Main {
    public static void main(String[] args) {

        SportCar sportCar = new SportCar(20.0, 200);
        sportCar.drive(10);
        System.out.println(sportCar.getFuel());
    }
}
