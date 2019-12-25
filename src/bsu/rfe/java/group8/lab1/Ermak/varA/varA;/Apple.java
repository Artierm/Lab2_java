package my.java;

public class Apple extends my.java.Food {
    private String size;
    public Apple(String size) {
        super("Apple");
        this.size = size;
    }

    public void consume() {
        System.out.println(this + " has eaten");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " size of '" + size.toUpperCase() + "'";
    }

    public int calculateCalories(){
        if (size.equals("big")){
            return 40;
        }
        else if(size.equals("medium")){
            return 30;
        }
        else if(size.equals("little")){
            return 20;
        }
        else{
            return 0;
        }
    }

}
