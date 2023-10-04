package com.assignment.rover.command.impl;

import com.assignment.rover.Rover;
import com.assignment.rover.command.Command;


public class MoveForwardCommandImpl implements Command {
    public void execute(Rover rover) {
        rover.moveForward();
    }
}
