```java
class Solution {
    // We will store the routes (bus stops) in a map, where each stop points to the list of bus routes that pass through it.
    // Then, we will perform BFS to find the minimum number of buses required to go from the source to the target stop.

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0; // If source and target are the same, no buses are required.

        // Map each bus stop to the list of bus routes that pass through it.
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) { // Iterate through all bus routes
            for (int stop : routes[i]) { // For each stop in the route
                stopToRoutes.putIfAbsent(stop, new ArrayList<>()); // Initialize the list if the stop is not already in the map
                stopToRoutes.get(stop).add(i); // Add the current route index to the list of routes for this stop
            }
        }

        // BFS initialization
        Queue<Integer> queue = new LinkedList<>(); // Queue to hold the routes to be explored
        Set<Integer> visitedRoutes = new HashSet<>(); // Keep track of visited routes to avoid reprocessing
        Set<Integer> visitedStops = new HashSet<>(); // Keep track of visited stops to avoid revisiting them
        int buses = 0; // Count the number of buses taken

        // Add all routes that pass through the source stop to the queue
        if (!stopToRoutes.containsKey(source)) return -1; // If the source stop is not in the map, it is impossible to reach the target
        for (int route : stopToRoutes.get(source)) { // Get all routes passing through the source stop
            queue.add(route); // Add the route to the queue
            visitedRoutes.add(route); // Mark the route as visited
        }

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of routes to process in this BFS level
            buses++; // Increment the bus count for each BFS level (each transfer)

            for (int i = 0; i < size; i++) {
                int route = queue.poll(); // Dequeue a route to process

                // Check all stops in the current route
                for (int stop : routes[route]) {
                    if (stop == target) return buses; // If the target stop is found, return the bus count

                    // Add all routes passing through this stop
                    if (!visitedStops.contains(stop)) { // If the stop hasn't been visited yet
                        visitedStops.add(stop); // Mark the stop as visited
                        for (int nextRoute : stopToRoutes.get(stop)) { // Get all routes passing through this stop
                            if (!visitedRoutes.contains(nextRoute)) { // If the route hasn't been visited yet
                                queue.add(nextRoute); // Add the route to the queue
                                visitedRoutes.add(nextRoute); // Mark the route as visited
                            }
                        }
                    }
                }
            }
        }

        return -1; // If the target is unreachable, return -1
    }
}

```
