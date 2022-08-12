package project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void viewList(ArrayList<Vehicle> Vehicle) {
        for (int i = 0; i < Vehicle.toArray().length; i++) {
            System.out.print("" + i + ")");
            if (Vehicle.get(i) instanceof Bus) {
                System.out.println("Bus " + Vehicle.get(i).getPetrol_amount() + " " + Vehicle.get(i).getTank_volume() + " " + ((Bus) Vehicle.get(i)).getPeople() + " " + ((Bus) Vehicle.get(i)).getMax_people());
            } else if (Vehicle.get(i) instanceof Truck) {
                System.out.println("Truck " + Vehicle.get(i).getPetrol_amount() + " " + Vehicle.get(i).getTank_volume() + " " + ((Truck) Vehicle.get(i)).getLoad() + " " + ((Truck) Vehicle.get(i)).getMax_load());

            } else if (Vehicle.get(i) instanceof Vehicle) {
                System.out.println("Vehicle " + Vehicle.get(i).getPetrol_amount() + " " + Vehicle.get(i).getTank_volume());
            }
        }
    }

    public static void viewBase() {
        Base.println();
    }

    public static void main(String[] args){
        Base.println();
        ArrayList<Vehicle> Vehicle = new ArrayList<>(1);
        Vehicle.add(new Vehicle(15, 20));
        Vehicle.add(new Truck(5, 10, 40, 50));
        Vehicle.add(new Bus(0, 5, 25, 30));
        boolean isOnBase = Vehicle.get(0).isOnBase;
        System.out.println(isOnBase);
        int number=0;
       while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Add 1 vehicle");
            System.out.println("2.Add 1 bus");
            System.out.println("3.Add 1 truck");
            System.out.println("4.View list");
            System.out.println("5.Arrive");
            System.out.println("6.Leave");
            System.out.println("7.Base status");
           System.out.println("8.End");
            System.out.println("Enter your choice: ");
            while (true){
                try {
                    number = Integer.parseInt(scanner.nextLine());
                    if(number > 7 || number <= 0) throw new InputMismatchException();
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Try again");
                }
                catch (NumberFormatException e){
                    System.out.println("Enter number not a word");
                }
            }
                switch (number) {
                    case 1:
                        System.out.println("Enter tank_volume");
                        double tank_volume = scanner.nextDouble();
                        System.out.println("Enter patrol_amount");
                        double patrol_amount = scanner.nextDouble();
                        Vehicle.add(new Vehicle(patrol_amount, tank_volume));
                        break;
                    case 2:
                        System.out.println("Enter people on the board");
                        int people = scanner.nextInt();
                        System.out.println("Enter max people on the board");
                        int max_people = scanner.nextInt();
                        System.out.println("Enter patrol_amount");
                        double patrol_amount_bus = scanner.nextDouble();
                        System.out.println("Enter tank_volume");
                        double tank_volume_bus = scanner.nextDouble();
                        Vehicle.add(new Bus(people, max_people, patrol_amount_bus, tank_volume_bus));
                        break;
                    case 3:
                        System.out.println("Enter load of the truck");
                        double load = scanner.nextDouble();
                        System.out.println("Enter max load of the track");
                        double max_load = scanner.nextDouble();
                        System.out.println("Enter patrol_amount");
                        double patrol_amount_truck = scanner.nextDouble();
                        System.out.println("Enter tank_volume");
                        double tank_volume_truck = scanner.nextDouble();
                        Vehicle.add(new Truck(load, max_load, patrol_amount_truck, tank_volume_truck));
                        break;
                    case 4:
                        viewList(Vehicle);
                        break;
                    case 5:
                        System.out.println("Choose which car you want let to go to the base");
                        viewList(Vehicle);
                        Scanner scanner1 = new Scanner(System.in);
                        int number1 = scanner1.nextInt();
                        Vehicle.get(number1).arrive();
                        break;
                    case 6:
                        System.out.println("Choose which car you want let to go out of your base");
                        viewList(Vehicle);
                        Scanner scanner2 = new Scanner(System.in);
                        int number2 = scanner2.nextInt();
                        Vehicle.get(number2).leave();
                        break;
                    case 7:
                        viewBase();
                        break;
                    case 8:
                        return;
                    default:System.out.println("Enter correct number");
                    break;

                }


            }
        }
    }
