package com.assignment.rover.grid;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Grid {
    private int length;
    private int breadth;
    private final Set<Position> obstacles = new HashSet<>();

    public void addObstacle(int x, int y) {
        obstacles.add(new Position(x, y));
    }

    public boolean isObstacle(int x, int y) {
        return obstacles.contains(new Position(x, y));
    }
}
