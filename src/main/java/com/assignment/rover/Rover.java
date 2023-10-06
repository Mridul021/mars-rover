package com.assignment.rover;

import com.assignment.rover.command.Command;
import com.assignment.rover.direction.Direction;
import com.assignment.rover.enums.CommandEnum;
import com.assignment.rover.enums.DirectionEnum;
import com.assignment.rover.factory.CommandFactory;
import com.assignment.rover.factory.DirectionFactory;
import com.assignment.rover.grid.Grid;
import com.assignment.rover.grid.Position;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rover {
    @Getter
    private final Position currentPosition;
    private Direction direction;
    private final Grid grid;
    private final HashMap<Position, Integer> mapper = new HashMap<>();
    private final List<Position> obstaclesDetected = new ArrayList<>();
    private Integer timesOutOfGrid = 0;

    public Rover(Position initialPosition, DirectionEnum direction, Grid grid) {
        this.currentPosition = initialPosition;
        this.direction = DirectionFactory.getInstance(direction);
        this.grid = grid;
    }

    public void executeCommands(List<CommandEnum> commands) {
        for (CommandEnum commandEnum : commands) {
            Command command = CommandFactory.getInstance(commandEnum);
            command.execute(this);
        }
    }

    public void moveForward() {
        Position newPosition = direction.moveForward(currentPosition);
        int newX = newPosition.getX();
        int newY = newPosition.getY();

        // Check if the new position is within the grid boundaries
        if (newX >= 0 && newX <= grid.getLength() && newY >= 0 && newY <= grid.getBreadth()) {
            // Check for obstacles
            if (!grid.isObstacle(newX, newY)) {
                currentPosition.setX(newX);
                currentPosition.setY(newY);
            } else {
                obstaclesDetected.add(new Position(newX, newY));
                if (mapper.containsKey(new Position(newX, newY))) {
                    Integer curFreq = mapper.get(new Position(newX, newY));
                    mapper.put(new Position(newX, newY), curFreq + 1);
                } else {
                    mapper.put(new Position(newX, newY), 1);
                }
            }
        } else {
            // Rover would go out of bounds
            timesOutOfGrid += 1;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public String getStatusReport() {
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<Position, Integer> entry : mapper.entrySet()) {
            sb.append(entry.getKey().toString());
            sb.append(" is detected ");
            sb.append(entry.getValue());
            sb.append(" times.\n");
        }

        String obstacleDetectedMessage = obstaclesDetected.isEmpty() ? "No obstacles detected." : sb.toString();
        return String.format("Rover is at (%d, %d) facing %s.\n%sRover tried to go out of the grid %s times.", currentPosition.getX(), currentPosition.getY(), direction.getSymbol().getValue(), obstacleDetectedMessage, timesOutOfGrid);
    }

    @Override
    public String toString() {
        return String.format("Final Position: (%d, %d, %s)\n%s", currentPosition.getX(), currentPosition.getY(), direction.getSymbol().getValue(), getStatusReport());
    }
}
