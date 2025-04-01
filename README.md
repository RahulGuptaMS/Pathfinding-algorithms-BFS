# Pathfinding BFS Visualizer

This project is a graphical representation of the **Breadth-First Search (BFS)** algorithm, implemented in Java using **Swing**. The visualizer allows users to interactively select start and end points in a grid and watch the BFS algorithm traverse the grid in real-time to find the shortest path.

## Features

- **Interactive Grid**: Click on the grid to set start and end points.
- **Real-Time BFS Visualization**: Watch the algorithm explore nodes in real-time.
- **Path Highlighting**: The shortest path is highlighted in yellow once found.
- **Grid Size**: Configured for a 20x20 grid (can be easily adjusted for different sizes).
- **Simple User Interface**: Easy-to-use interface with intuitive controls.

## Technologies

- **Programming Language**: Java
- **GUI Framework**: Swing (`javax.swing`)
- **Data Structures**:
  - **Queue** (LinkedList) for BFS traversal.
  - **HashMap** for backtracking and path reconstruction.
  - **2D Array** for grid representation.
  
## Getting Started

### Prerequisites

Before running the project, make sure you have the following installed:

- Java Development Kit (JDK) 8 or higher.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).

### Running the Project

1. **Clone the repository** to your local machine:

   ```bash
  [ git clone https://github.com/your-username/Pathfinding-BFS-Visualizer.git](https://github.com/RahulGuptaMS/Pathfinding-algorithms-BFS.git)
Open the project in your Java IDE (e.g., IntelliJ IDEA, Eclipse).

Run the PathfindingBFS_GUI.java file to start the visualizer.

How to Use

1.Click on a cell in the grid to set the start point (this will be highlighted in green).

2.Click on another cell to set the end point (this will be highlighted in red).

3.Press the "Run BFS" button to start the pathfinding process.

4.Watch the BFS algorithm in action:

5.The blue cells represent the explored nodes.

6.The yellow cells represent the shortest path found by BFS.

Customization
Grid Size: You can change the grid size by modifying the ROWS and COLS constants in the PathfindingBFS_GUI.java file.

Animation Speed: Adjust the speed of the BFS traversal by modifying the Thread.sleep() duration inside the bfs() and drawPath() methods.

Challenges & Solutions
Real-Time Visualization: Ensured smooth visualization of the algorithm using Thread.sleep() to delay each step and avoid UI lag.

Handling User Inputs: Implemented mouse listeners to allow users to select start and end points interactively.

Future Improvements
Adding Obstacles: Users can place obstacles on the grid to simulate more complex scenarios.

Other Algorithms: Implement Dijkstra's Algorithm and A* to allow users to compare different pathfinding techniques.

Custom Grid Sizes: Allow users to dynamically change the grid size during runtime.

UI Enhancements: Enhance the user interface with better controls and visual effects.

Contributing
If you'd like to contribute to this project, feel free to fork the repository and submit a pull request with improvements, bug fixes, or new features.
