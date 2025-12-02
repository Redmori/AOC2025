package Day2;

public class Id {
    String number1;
    String number2;

    public Id(String n1, String n2){
        number1 = n1;
        number2 = n2;
    }

    public long getSum(){
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
            String il = String.valueOf(i);
            if(il.substring(0,il.length()/2).equals(il.substring(il.length()/2))){
                sum += i;
            }
        }
        return sum;
    }

    public long getValue(String number){
        return Long.parseLong(number);
    }

    @Override
    public String toString() {
        return number1 + "-" + number2;
    }
}
