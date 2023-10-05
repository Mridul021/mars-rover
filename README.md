# Mars-Rover

This is a part of coding exercise by Educational Initiatives (On-Campus)



### Problem Statement

Create a Mars Rover simulation with grid-based terrain navigation. The Rover must have actions to move forward, turn left, and turn right, while avoiding obstacles and staying within grid boundaries. Utilize Object-Oriented Programming, design patterns, and minimize the use of if-else conditions.



### Functional Requirements

1. The Rover will have a starting position (let say {x, y}) and an initial direction (one of the {N, S, E, W}) placed in a fixed sized Grid.
2. Rover will perform actions according to the following commands:
   - 'M' for moving one step forward in the direction it is facing.
   - 'L' for turning left
   - 'R' for turning right
3. There will be some fixed obstacles in the grid at pre-defined positions.
4. The Rover will detect the obstacles coming in its path when following the given commands.
5. Rover will not move in case it encounters an obstacle and proceed with the next command.
6. At the end, the Rover will send it's final position and the direction it is facing, along with all the obstacles it encountered while following the commands.



### Key Design Principles used

1. Used the **Command Pattern** to **encapsulate** 'M', 'L', 'R' as objects for flexibility.
2. Used the **Composite Pattern** to represent the grid and obstacles.
3. **OOPs**: Leveraged **encapsulation**, **inheritance**, and **polymorphism**.
