# Key Characteristics of Topological Sort Problems:
```text

1.Directed Acyclic Graph (DAG):
      The problem explicitly states or implies that the input is a directed graph and acyclic.
      If there's a possibility of cycles, the problem may ask you to detect and handle them (e.g., "check if the            graph is   a DAG").

2.Dependency Relationships:
      Tasks or nodes have dependencies, meaning one task/node must occur before another. For example:
      "Task A must be completed before Task B."
      "Node X must appear before Node Y."
      These dependencies naturally form a directed edge in a graph.

3.Ordering Requirement:
      The problem asks for an order of execution or processing that respects all dependencies. For example:
      "Find the order of tasks."
      "Determine a valid sequence of steps."
      "Arrange nodes so that dependencies are resolved."

4.Graph Representation:
      Input is given as:
      Edges: A list of directed edges like (A → B), implying A must come before B.
      Adjacency List/Matrix: A graph representation of nodes and their dependencies.
      Problems may also provide tasks or courses in plain text, requiring you to model them as a graph first.
```

Common Problem Types Involving Topological Sort:
```text
1.Task Scheduling:
      Example: "Given tasks with prerequisites, find a valid task execution order."
      Hint: Words like "prerequisites," "order," "tasks," or "schedule" signal this type of problem.

2.Course Ordering:
      Example: "Can you finish all courses given course prerequisites?"
      Hint: Phrases like "complete all courses," "valid order," or "prerequisite graph" are clues.

3.Dependency Resolution:
      Example: "Find the order of building a project given dependencies between components."
      Hint: Words like "dependency graph," "build order," or "execution sequence."

4.Cycle Detection in Directed Graphs:
      Example: "Is it possible to schedule all tasks?" (May involve finding a topological order or detecting cycles.)
      Hint: Look for tasks, prerequisites, or nodes without a feasible order.
```

Common Questions and Scenarios:
```text
1.Determine Feasibility:
      If the problem asks whether tasks can be completed, it's likely testing for cycle detection in a DAG.
      Use Kahn’s Algorithm or DFS to check if a topological order is possible.

2.Generate a Valid Order:
      If the problem asks for a specific valid sequence, it involves topological sorting.
      Use either:
      Kahn's Algorithm (BFS-based) for a level-by-level approach.
      DFS with a stack for reverse post-order traversal.

3.Multiple Valid Orders:
      If the problem mentions multiple possible orders, find one of them using any standard topological sorting method.

```
