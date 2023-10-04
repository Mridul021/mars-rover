package com.assignment.rover.factory;

import com.assignment.rover.command.Command;
import com.assignment.rover.command.impl.MoveForwardCommandImpl;
import com.assignment.rover.command.impl.TurnLeftCommandImpl;
import com.assignment.rover.command.impl.TurnRightCommandImpl;
import com.assignment.rover.enums.CommandEnum;

public class CommandFactory {
    public static Command getInstance(CommandEnum commandEnum) {
        switch (commandEnum) {
            case M:
                return new MoveForwardCommandImpl();
            case L:
                return new TurnLeftCommandImpl();
            case R:
                return new TurnRightCommandImpl();
            default:
                throw new RuntimeException("Invalid command");
        }
    }
}
