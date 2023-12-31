package com.assignment;

import com.assignment.rover.Input;
import com.assignment.rover.Rover;
import com.assignment.rover.enums.CommandEnum;
import com.assignment.rover.enums.DirectionEnum;

import java.util.Scanner;

public class Main {

    private static void checkBoundaries(int input, int limit) {
        if (input >= limit || input < 0) {
            throw new IllegalArgumentException(String.format("Input %d is out of grid bound %d", input, limit));
        }
    }

    private static Input getInput() {
        Scanner sc = new Scanner(System.in);
        Input input = new Input();

        // Initialize Grid and obstacles
        System.out.print("Enter grid Length: ");
        input.getGrid().setLength(sc.nextInt());
        System.out.print("Enter grid Breadth: ");
        input.getGrid().setBreadth(sc.nextInt());
        System.out.print("Enter number of obstacles: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter obstacle number %d X: ", i);
            int x = sc.nextInt();
            checkBoundaries(x, input.getGrid().getLength());
            System.out.printf("Enter obstacle number %d Y: ", i);
            int y = sc.nextInt();
            checkBoundaries(y, input.getGrid().getBreadth());
            input.getGrid().addObstacle(x, y);
        }

        // Initialize initial position
        System.out.print("Enter initial position X: ");
        input.getInitialPosition().setX(sc.nextInt());
        checkBoundaries(input.getInitialPosition().getX(), input.getGrid().getLength());
        System.out.print("Enter initial position Y: ");
        input.getInitialPosition().setY(sc.nextInt());
        checkBoundaries(input.getInitialPosition().getY(), input.getGrid().getBreadth());

        // Initialize initial direction
        System.out.print("Enter initial direction: ");
        sc.skip("[\r\n]+");
        input.setInitialDirection(DirectionEnum.valueOf(sc.nextLine()));

        System.out.print("Enter commands: ");
        String commandsInput = sc.nextLine();
        for (char c : commandsInput.toCharArray()) {
            input.getCommands().add(CommandEnum.valueOf(String.valueOf(c)));
        }
        return input;
    }

    private static Rover getRoverInstance(Input input) {
        return new Rover(input.getInitialPosition(), input.getInitialDirection(), input.getGrid());
    }

    public static void main(String[] args) {
        Input input = getInput();
        Rover rover = getRoverInstance(input);
        rover.executeCommands(input.getCommands());

        System.out.println(rover);
    }
}