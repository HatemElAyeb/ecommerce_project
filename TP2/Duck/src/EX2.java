class EX2{
    public static void main(String[] args){
        FB1 f1 =new FB1();
        FB2 f2 =new FB2();

         //Decoy duck test
        DecoyDuck b = new DecoyDuck();
        b.display();

        //Rubber duck tests
        RubberDuck bat = new RubberDuck();
        bat.display();
        bat.quack();
        
        //Red Head duck tests
        RedheadDuck Dii =new RedheadDuck();
        Dii.display();
        Dii.quack();
        Dii.fly();
        Dii.setFlightBehaviour(f2);
        Dii.FBfly();
        
        //Mallard Duck tests
        MallardDuck m = new MallardDuck();
        m.display();
        m.quack();
        m.fly();
        m.setFlightBehaviour(f2);
        m.FBfly();
        m.setFlightBehaviour(f1);
        m.FBfly();
    }    
}