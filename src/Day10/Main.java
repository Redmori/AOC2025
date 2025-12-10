package Day10;

import util.AOC;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day10/input.txt");
        AOC.printInput(input);

        ArrayList<Machine> machines = createMachines(input);

        long presses = 0;
        for(Machine machine : machines){
            System.out.println("Starting machine: " + (machines.indexOf(machine) + 1) + "/" + machines.size());
            presses += machine.calculatePresses();
            System.out.println("machine needs " + presses);
        }

        System.out.println("Day 10 Part 1: " + presses);
    }

    private static ArrayList<Machine> createMachines(String[] input) {
        ArrayList<Machine> machines = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String[] splitInput = input[i].split(" ");
            //Light
            String lights = input[i].substring(1, splitInput[0].length()-1);

            //Buttons
            ArrayList<Button> buttons = new ArrayList<>();
            for (int j = 1; j < splitInput.length - 1; j++) {
                Button newButton = new Button(splitInput[j].substring(1, splitInput[j].length() - 1));
                buttons.add(newButton);
                System.out.println(newButton);
            }

            //Joltage (Ignore for now)

            Machine newMachine = new Machine(lights, buttons);
            machines.add(newMachine);
            System.out.println(newMachine);
        }
        return machines;
    }
}
