package com.assignment.rover.grid;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
