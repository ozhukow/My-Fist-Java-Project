package project;

public class Truck extends Vehicle {
    double max_load;
    double load;

    Truck(double load, double max_load, double petrol_amount, double tank_volume){
        super(petrol_amount, tank_volume);
        if (load <= max_load) {
            this.max_load = max_load;
            this.load = load;
        }
    }

    public double getLoad() {
        return load;
    }

    public double getMax_load() {
        return max_load;
    }

    boolean set(double petrol_amount, double tank_volume, double max_load, double load){
        super.set(petrol_amount, tank_volume);
        if(max_load > 0 && load <= max_load && load > 0){
            this.load = load;
            this.max_load = max_load;
            return true;
        }
        return false;
    }

    public boolean arrive() {
        if (isOnBase) {
            return false;
        }
        super.arrive();
        Base.goods_on_base = Base.goods_on_base + load;
        load = 0;
        return true;
    }

    public boolean leave() {
        if (isOnBase) {
            if (Base.goods_on_base >= max_load) {
                Base.goods_on_base = Base.goods_on_base - max_load;
                load = max_load;
            } else if (Base.goods_on_base <= max_load){
                load = Base.goods_on_base;
                Base.goods_on_base = 0;
            }
            super.leave();
            return true;
        }
        return false;
    }
}
