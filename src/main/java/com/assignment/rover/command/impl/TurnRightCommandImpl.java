package com.assignment.rover.command.impl;

import com.assignment.rover.Rover;
import com.assignment.rover.command.Command;

public class TurnRightCommandImpl implements Command {
    public void execute(Rover rover) {
        rover.turnRight();
    }
}
