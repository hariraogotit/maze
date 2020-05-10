# Maze Test DWP

## Assumptions
1. Maze1.txt file is available in src/main/resources/Maze1.txt
2. This does not take the explorer automatically to exit. Explorer needs to travers using the console/keystroke

## How to Run
1. Run LoadMazeExplorerApplication.java which requests for key strokes, select the required key strokes.
2. Please look at https://github.com/hariraogotit/maze/blob/master/User_Stories_Usage_Of_Maze_App.doc which shows the screenshot output for each requirement
3. Log is also available in log/log4j-application.log

## Highlevel overview
1. LoadMazeExplorerApplication.java loads the application.
2. MazeValidator is used to validate the given Maze.
3. Uses MazeService to load and build Maze.
4. ExploreMazeService is used to explore the Maze.
