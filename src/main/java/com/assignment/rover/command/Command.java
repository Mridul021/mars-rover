package com.assignment.rover.command;

import com.assignment.rover.Rover;

public interface Command {
    void execute(Rover rover);
}
