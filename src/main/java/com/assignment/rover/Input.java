package com.assignment.rover;

import com.assignment.rover.enums.CommandEnum;
import com.assignment.rover.enums.DirectionEnum;
import com.assignment.rover.grid.Grid;
import com.assignment.rover.grid.Position;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Input {
    private Grid grid = new Grid();
    private Position initialPosition = new Position();
    private DirectionEnum initialDirection;
    private List<CommandEnum> commands = new ArrayList<>();
}
