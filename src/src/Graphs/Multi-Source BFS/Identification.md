# Identifying Multi-Source BFS Problems in Java

## Characteristics of Multi-Source BFS Problems
Multi-Source BFS is suitable when:
1. **Multiple Starting Points**:
   - The problem involves multiple sources of propagation, such as rot, fire, or spreading information.
   - You need to compute the shortest or minimum steps, distance, or time for a process starting from multiple locations.

2. **Simultaneous or Parallel Spread**:
   - The task involves "spreading" some property (e.g., infection, fire) where multiple sources affect their surroundings simultaneously.

3. **Time or Distance Calculation**:
   - The solution requires calculating the **minimum time**, steps, or distance.

4. **Grid-Based Problems**:
   - These problems often use grids where propagation spreads in four or eight directions.

## Common Scenarios for Multi-Source BFS
1. **Rotting Oranges Problem**:
   - Problem: Spread rot from multiple rotten oranges to fresh ones in the grid.
   - Why Multi-Source BFS? Rot spreads from all sources simultaneously, affecting neighbors in the same minute.

2. **Walls and Gates**:
   - Problem: Fill each room with the distance to its nearest gate in a grid with walls and gates.
   - Why Multi-Source BFS? Multiple gates act as starting points for propagation.

3. **Fire Spread**:
   - Problem: Spread fire from multiple sources and determine the time to burn the entire area.

## Identifying Multi-Source BFS Problems
Ask yourself:
- Are there **multiple starting points**?
- Is the problem about **spreading** something (e.g., infection, fire)?
- Does the solution require the **shortest or minimum time/steps**?
- Is a **level-by-level traversal** required?

If yes, Multi-Source BFS is likely the solution.
