package my.java;



import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        my.java.Food[] breakfast = new my.java.Food[20];
        int countItems = 0;
        boolean flagSort = false;
        boolean flagCal = false;
        for (String arg: args){
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")){
                breakfast[countItems] = new my.java.Cheese();
            }
            else if (parts[0].equals("Apple")){
                breakfast[countItems] = new my.java.Apple(parts[1].toLowerCase());
            }
            else if(parts[0].equals("Lemonade")){
                breakfast[countItems] = new my.java.Lemonade(parts[1].toLowerCase());
            }

            else {
                switch (parts[0]) {
                    case "-sort":
                        flagSort = true;
                        break;
                    case "-calories":
                        flagCal = true;
                        break;
                    default:
                        System.out.println("Cannot find class " + parts[0] + ".\nContinue...\n");
                        countItems--;
                }
            }
            countItems++;
        }

        if (flagSort){
            Arrays.sort(breakfast, new Comparator<my.java.Food>() {
                @Override
                public int compare(my.java.Food o1, my.java.Food o2) {
                    if (o1 instanceof my.java.Lemonade && o2 instanceof my.java.Lemonade) {
                        return -(((my.java.Lemonade) o1).getTaste().compareTo(((my.java.Lemonade) o2).getTaste()));
                    }
                    else if (o1 instanceof my.java.Lemonade && o2 instanceof my.java.Apple) {
                        return -(((my.java.Lemonade) o1).getTaste().compareTo(((my.java.Apple) o2).getSize()));
                    }
                    else if (o1 instanceof my.java.Apple && o2 instanceof my.java.Lemonade) {
                        return -(((my.java.Apple) o1).getSize().compareTo(((my.java.Lemonade) o2).getTaste()));
                    }
                    else if (o1 instanceof my.java.Apple && o2 instanceof my.java.Apple) {
                        return -(((my.java.Apple) o1).getSize().compareTo(((my.java.Apple) o2).getSize()));
                    }
                    else if (o1 instanceof my.java.Cheese && (o2 instanceof my.java.Apple || o2 instanceof my.java.Lemonade)) {
                        return -1;
                    }
                    else if ((o1 instanceof my.java.Apple || o1 instanceof my.java.Lemonade) && o2 instanceof my.java.Cheese) {
                        return 1;
                    }
                    else if (o1 == null) {
                        return 1;
                    }
                    else if (o2 == null) {
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            });
        }

        for (my.java.Food item: breakfast){
            if (item != null){
                item.consume();
            }
            else{
                break;
            }
        }

        int counter = 0;
        my.java.Lemonade check = new my.java.Lemonade("orange");
        for (my.java.Food item: breakfast){

            if (item != null){
                if (item.equals(check)){
                    counter++;
                }
            }
        }
        System.out.println("Amount products of type " + "'" +check + "'" + ": " + counter);

        counter = 0;
        for (my.java.Food item: breakfast){

            if (item != null){
                if (item.equals_type(check)){
                    counter++;
                }
            }
        }
        System.out.println("Amount products of type " + "'" +check.getName() + "'" + ": " + counter);

        if (flagCal){
            int calories = 0;
            for (my.java.Food item: breakfast) {
                if (item != null) {
                    calories += item.calculateCalories();
                }
                else{
                    break;
                }
            }
            System.out.println("Calories: " + calories + '\n');
        }

    }
}