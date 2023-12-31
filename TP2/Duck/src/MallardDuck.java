public class MallardDuck extends Duck implements Quack,Flyable {
    private FlightBehavior fb;
    void setFlightBehaviour(FlightBehavior f) {
        fb=f;
    }
    public void display() {
        System.out.println("Found a Mallard one");
    }
    public void fly() {
        System.out.println("Mallard One Flying");
    }
    public void quack() {
        System.out.println("Mallard One Quacking");
    }
    public void FBfly() {
        fb.ToFly();
    }
}
