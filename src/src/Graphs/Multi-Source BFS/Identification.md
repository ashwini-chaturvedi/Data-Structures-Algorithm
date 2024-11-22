# Identifying Multi-Source BFS Problems in Java

## Characteristics of Multi-Source BFS Problems

Multi-Source BFS is suitable when:

1. **Multiple Starting Points**:
   - The problem involves multiple sources of propagation, such as rot, fire, or spreading information.
   - You need to compute the shortest or minimum steps, distance, or time for a process starting from multiple locations.

2. **Simultaneous or Parallel Spread**:
   - The task involves "spreading" some property (e.g., infection, fire) where multiple sources affect their surroundings simultaneously at the **same time**.

3. **Time or Distance Calculation**:
   - The solution requires calculating the **minimum time**, steps, or distance.

4. **Grid-Based Problems**:
   - These problems often use grids where propagation spreads in four or eight directions.

## Signs in Problem Statements

Here are some common cues in problem descriptions that suggest Multi-Source BFS:

### A. Propagation Behavior
   - "Spread" is mentioned explicitly (e.g., rot, fire, infection, signal).
   - Multiple points or areas simultaneously affect the surroundings.

### B. Simultaneous Effect
   - The problem specifies that events or actions occur in parallel.
   - Neighbors of a node or cell are affected simultaneously.

### C. Time or Distance
   - The problem involves calculating the minimum time, steps, or levels required for something to happen (e.g., fully spread or reach all targets).

### D. Multiple Starting Points
   - The initial state consists of multiple independent starting points (e.g., multiple rotten oranges, multiple fire sources).

## Why BFS is Necessary?

BFS is ideal for these problems because:

- **Simultaneous Propagation**: BFS processes nodes in a level-by-level manner, ensuring that all points at the same "distance" or "time" are processed together.
- **Optimal Time or Distance**: BFS naturally computes the shortest time/distance since it explores all possible options simultaneously at each level.

**DFS** cannot handle these effectively because it explores deeply along one path before moving to another, failing to handle simultaneous propagation or level-wise updates.

## How to Apply Multi-Source BFS

Here’s a step-by-step method to solve Multi-Source BFS problems:

1. **Identify the Sources**:
   - Find all the starting points (e.g., rotten oranges, fire sources, gates).

2. **Initialize a Queue**:
   - Enqueue all the starting points with their initial state (e.g., time = 0).

3. **Use Level-Order Traversal**:
   - Process the queue level by level, where each level represents a time unit or distance.

4. **Propagate to Neighbors**:
   - For each point in the current level, propagate to its neighbors (e.g., mark cells as affected or enqueue new points).

5. **Terminate When Complete**:
   - Stop when all cells are processed, or return the result (e.g., time, distance, or unreachable condition).

## Common Scenarios for Multi-Source BFS

1. **Rotting Oranges Problem**:
   - **Problem**: Spread rot from multiple rotten oranges to fresh ones in the grid.
   - **Why Multi-Source BFS?** Rot spreads from all sources simultaneously, affecting neighbors in the same minute.

2. **Walls and Gates**:
   - **Problem**: Fill each room with the distance to its nearest gate in a grid with walls and gates.
   - **Why Multi-Source BFS?** Multiple gates act as starting points for propagation.

3. **Fire Spread**:
   - **Problem**: Spread fire from multiple sources and determine the time to burn the entire area.

## Identifying Multi-Source BFS Problems

Ask yourself:

- Are there **multiple starting points**?
- Is the problem about **spreading** something (e.g., infection, fire)?
- Does the solution require the **shortest or minimum time/steps**?
- Is a **level-by-level traversal** required?

If yes, Multi-Source BFS is likely the solution.
