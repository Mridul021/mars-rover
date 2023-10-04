package com.assignment.rover.direction.impl;

import com.assignment.rover.direction.Direction;
import com.assignment.rover.enums.DirectionEnum;
import com.assignment.rover.grid.Position;

import static com.assignment.rover.enums.DirectionEnum.N;

public class NorthDirectionImpl implements Direction {
    public Direction turnLeft() {
        return new WestDirectionImpl();
    }

    public Direction turnRight() {
        return new EastDirectionImpl();
    }

    public Position moveForward(Position currentPosition) {
        return new Position(currentPosition.getX(), currentPosition.getY() + 1);
    }

    public DirectionEnum getSymbol() {
        return N;
    }
}
