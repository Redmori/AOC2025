package Day10;

import java.util.ArrayList;
import java.util.Arrays;

public class Machine {
    String lights;
    public ArrayList<Button> buttons;
    public ArrayList<Integer> joltage;

    public Machine(String l, ArrayList<Button> bs, String j){
        lights = l;
        buttons = bs;
        joltage = new ArrayList<>();
        String[] splitJoltage = j.split(",");
        for (int i = 0; i < splitJoltage.length; i++) {
            joltage.add(Integer.valueOf(splitJoltage[i]));
        }
    }

    public int calculatePresses(){
        boolean[] currentLights = new boolean[lights.length()];
        boolean[] targetLights = new boolean[lights.length()];
        for (int i = 0; i < lights.length(); i++) {
            if(lights.charAt(i) == '#'){
                targetLights[i] = true;
            }
        }

        int minPresses = Integer.MAX_VALUE;

        for(Button button : buttons){
            System.out.println("starting button " + (buttons.indexOf(button) + 1 ) + "/" + buttons.size());
            boolean[] hasPressed = new boolean[buttons.size()];
            //TODO check if already at target
            minPresses = Math.min(minPresses, pressButton(button, hasPressed, 0, Integer.MAX_VALUE, currentLights.clone(), targetLights));
        }

        return minPresses;
    }

    public int pressButton(Button button, boolean[] hasPressed, int presses, int currentMinPresses, boolean[] clights, boolean[] tlights) {
        //System.out.println("Press button: " + button + " with " + (presses+1) + " presses of "+ Arrays.toString(hasPressed) + " gives " + Arrays.toString(clights) + " ");

        hasPressed[buttons.indexOf(button)] = true;
        presses ++;
        if(presses >= currentMinPresses){
            return presses;
        }
        boolean[] newLights = changeLights(button, clights);

        if(Arrays.equals(newLights, tlights)){
            return presses;
        }

        int lowestPresses = Integer.MAX_VALUE;
        for (int i = 0; i < hasPressed.length; i++) {
            if(!hasPressed[i]){
                int nextPresses = pressButton(buttons.get(i), hasPressed.clone(), presses, lowestPresses, newLights, tlights);
                lowestPresses = Math.min(lowestPresses, nextPresses);
            }
        }
        return lowestPresses;

    }

    private boolean[] changeLights(Button button, boolean[] clights) {
        boolean[] newLights = clights.clone();
        for (Integer lightNumber : button.lightNumbers) {
            newLights[lightNumber] = !newLights[lightNumber];
        }
        return newLights;
    }

    @Override
    public String toString() {
        return "[" + lights + "] " + buttons + " {" + joltage + "}";
    }
}
