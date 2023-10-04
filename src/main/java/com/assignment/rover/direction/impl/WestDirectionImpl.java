package com.assignment.rover.direction.impl;

import com.assignment.rover.direction.Direction;
import com.assignment.rover.enums.DirectionEnum;
import com.assignment.rover.grid.Position;

import static com.assignment.rover.enums.DirectionEnum.W;

public class WestDirectionImpl implements Direction {
    public Direction turnLeft() {
        return new SouthDirectionImpl();
    }

    public Direction turnRight() {
        return new NorthDirectionImpl();
    }

    public Position moveForward(Position currentPosition) {
        return new Position(currentPosition.getX() - 1, currentPosition.getY());
    }

    public DirectionEnum getSymbol() {
        return W;
    }
}
