package project;

public class Bus extends Vehicle{
    int max_people;
    int people;

    Bus(int people, int max_people, double petrol_amount, double tank_volume){
        super(petrol_amount, tank_volume);
        if(people <= max_people){
            this.people = people;
            this.max_people = max_people;
        }
    }

    public int getPeople() {
        return people;
    }

    public int getMax_people() {
        return max_people;
    }

    boolean set(double petrol_amount, double tank_volume, int max_people, int people){
        super.set(petrol_amount, tank_volume);
        if(max_people > 0 && people <= max_people && people > 0){
            this.people = people;
            this.max_people = max_people;
            return true;
        }
        return false;
    }
    public boolean arrive(){
        if (isOnBase){
            return false;
        }
        super.arrive();
        Base.people_on_base = Base.people_on_base + people;
        people = 0;
        return true;
    }
    public boolean leave(){
        if (isOnBase){
            if(Base.people_on_base >= max_people){
                Base.people_on_base = Base.people_on_base - max_people;
                people = max_people;
            }
            else if(Base.people_on_base < max_people){
                people = Base.people_on_base;
                Base.people_on_base=0;

            }
            super.leave();
            return true;
        }
        return false;
    }
}
