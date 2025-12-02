package Day2;

import java.util.Arrays;
import java.util.Objects;

public class Id {
    String number1;
    String number2;

    public Id(String n1, String n2){
        number1 = n1;
        number2 = n2;
    }

    public long getSum2(){
        long n1 = getValue(number1);
        long n2 = getValue(number2);

        long sum = 0;
        for (long i = n1; i <= n2; i++) {
            String il = String.valueOf(i);
            if(il.substring(0,il.length()/2).equals(il.substring(il.length()/2))){
                sum += i;
            }
        }
        return sum;
    }

    public long getSumN(){
        long n1 = getValue(number1);
        long n2 = getValue(number2);

        long sum = 0;
        for (long i = n1; i <= n2; i++) {
            sum += getSumOfString(String.valueOf(i));
        }
        return sum;
    }

    public long getSumOfString(String number){
        long sum = 0;
        for(int k = 1; k <= number.length()/2; k++) {
            String regex = "(?<=\\G.{" + k + "})";
            String[] array = number.split(regex);
            if(isEqual(array)) {
                sum += Long.parseLong(number);
                break;
            }
        }
        return sum;
    }

    private boolean isEqual(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if(!Objects.equals(array[i], array[0]))
                return false;
        }
        //System.out.println(Arrays.toString(array));
        return true;
    }

    public long getValue(String number){
        return Long.parseLong(number);
    }

    @Override
    public String toString() {
        return number1 + "-" + number2;
    }
}
