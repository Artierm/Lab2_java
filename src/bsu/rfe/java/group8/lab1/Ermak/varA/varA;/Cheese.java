package my.java;



public class Cheese extends my.java.Food {
    public Cheese() {
        super("Cheese");
    }
    public void consume() {
        System.out.println(this + " has eaten");
    }

    public int calculateCalories(){
        return 80;
    }

}
