package com.assignment.rover.factory;
import com.assignment.rover.enums.DirectionEnum;
import com.assignment.rover.direction.*;
import com.assignment.rover.direction.impl.EastDirectionImpl;
import com.assignment.rover.direction.impl.NorthDirectionImpl;
import com.assignment.rover.direction.impl.SouthDirectionImpl;
import com.assignment.rover.direction.impl.WestDirectionImpl;

public class DirectionFactory {
    public static Direction getInstance(DirectionEnum direction) {
        switch (direction) {
            case N:
                return new NorthDirectionImpl();
            case S:
                return new SouthDirectionImpl();
            case E:
                return new EastDirectionImpl();
            case W:
                return new WestDirectionImpl();
            default:
                throw new RuntimeException("Direction Invalid");
        }
    }
}
