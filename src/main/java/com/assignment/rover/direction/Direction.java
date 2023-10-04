package com.assignment.rover.direction;

import com.assignment.rover.enums.DirectionEnum;
import com.assignment.rover.grid.Position;

public interface Direction {
    Direction turnLeft();

    Direction turnRight();

    Position moveForward(Position currentPosition);

    DirectionEnum getSymbol();
}
