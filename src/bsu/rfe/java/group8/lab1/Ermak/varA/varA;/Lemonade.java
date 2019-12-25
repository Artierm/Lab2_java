package my.java;


public class Lemonade extends my.java.Food {

    private String taste = null;

    public Lemonade(String taste){
        super("Lemonade");
        this.taste = taste;
    }

    public void setTaste(String taste){
        this.taste = taste;
    }

    public String getTaste(){
        return taste;
    }

    public void consume(){
        System.out.println(this + " has been drunk");
    }

    public int calculateCalories(){
        if (taste.equals("lemon")){
            return 2;
        }
        else if(taste.equals("orange")){
            return 4;
        }
        else if(taste.equals("strawberry")){
            return 3;
        }
        else{
            return 0;
        }
    }

    public String toString() {
        return super.toString() + " taste of '" + taste.toUpperCase() + "'";
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Lemonade)) return false;
            return taste.equals(((Lemonade)arg0).taste);
        }
        else return false;
    }

}