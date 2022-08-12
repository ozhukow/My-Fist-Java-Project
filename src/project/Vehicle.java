package project;

public class Vehicle {
    public boolean isOnBase = false;
    public boolean driver = true;
    public double tank_volume;
    public double petrol_amount;
    Vehicle(double petrol_amount, double tank_volume){
        if(petrol_amount>0 && petrol_amount<=tank_volume && tank_volume>0){
            this.petrol_amount=petrol_amount;
            this.tank_volume=tank_volume;
        }
    }

    public double getTank_volume() {
        return tank_volume;
    }

    public double getPetrol_amount() {
        return petrol_amount;
    }

    boolean set(double petrol_amount, double tank_volume){
        if(petrol_amount > 0 && petrol_amount <= tank_volume && tank_volume > 0) {
            this.petrol_amount = petrol_amount;
            this.tank_volume = tank_volume;
            return true;
        }
            return false;
    }

    public boolean arrive(){
       if (isOnBase){
           return false;
        }
       Base.people_on_base++;
       Base.vehicles_on_base++;
       driver = false;
       isOnBase = true;

       return true;
    }
    public boolean leave(){
        if (isOnBase){
            double needToFuel = tank_volume - petrol_amount;
            if(Base.petrol_on_base>=needToFuel && Base.people_on_base>0){
                Base.people_on_base--;
                Base.vehicles_on_base--;
                petrol_amount = petrol_amount + needToFuel;
                Base.petrol_on_base = Base.petrol_on_base - needToFuel;
                driver = true;
                isOnBase = false;
                return true;
            }
            return false;
        }
        return false;
    }
}
