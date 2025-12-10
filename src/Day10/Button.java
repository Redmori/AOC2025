package Day10;

import java.util.ArrayList;

public class Button {

    ArrayList<Integer> lightNumbers;

    public Button(String input){
        lightNumbers = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (int i = 0; i < splitInput.length; i++) {
            int lightValue = Integer.parseInt(splitInput[i]);
            lightNumbers.add(lightValue);
        }
    }

    @Override
    public String toString(){
        return "(" + lightNumbers + ")";
    }
}
