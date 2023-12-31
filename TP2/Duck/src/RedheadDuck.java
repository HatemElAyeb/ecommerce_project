public class RedheadDuck extends Duck implements Flyable,Quack{
    private FlightBehavior fb;
    void setFlightBehaviour(FlightBehavior f) {
        fb=f;
    }
    public void display() {
        System.out.println("Found a Redhead one");
    }
    public void fly() {
        System.out.println("Redhead One Flying");
    }
    public void quack() {
        System.out.println("Redhead One Quacking");
    }
    public void FBfly() {
        fb.ToFly();
    }
}
