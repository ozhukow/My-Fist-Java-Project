package project;

public class Base {
    static int people_on_base = 1000;
    static int vehicles_on_base = 25;
    static double petrol_on_base = 5000;
    static double goods_on_base = 1000;
    static void println(){
        System.out.printf("\nCurrent balance of your base: People(%d) \nVehicles(%d) \nPetrol(%f) \nGoods(%f)\n", people_on_base, vehicles_on_base, petrol_on_base, goods_on_base);
    }

}
