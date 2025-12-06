package Day6;

import java.util.ArrayList;

public class Problem {
    ArrayList<Integer> numbers;
    char operator;

    public Problem(ArrayList<String> nums){
        numbers = new ArrayList<>();
        for(String num : nums){
            if(nums.getLast().equals(num)){
                operator = num.charAt(0);
            }else {
                numbers.add(Integer.parseInt(num));
            }
        }
    }

    public long solve(){
        long solution = 0;
        if(operator == '+') {
            for (Integer number : numbers) {
                solution += number;
            }
        }else{
            solution = numbers.getFirst();
            for (int i = 1; i < numbers.size(); i++) {
                solution *= numbers.get(i);
            }
        }
        return solution;
    }

    @Override
    public String toString() {
        return numbers + " " + operator;
    }
}
