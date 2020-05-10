package uk.gov.dwp.maze.services;

import uk.gov.dwp.maze.models.Explorer;
import uk.gov.dwp.maze.models.Maze;

public interface ExploreMazeService {

    Explorer exploreMaze(Maze maze);

    String moveForward(Maze maze, Explorer explorer);

    String moveUp(Maze maze, Explorer explorer);

    String moveLeft(Maze maze, Explorer explorer);

    String moveRight(Maze maze, Explorer explorer);

    String getWhatIsInFront(Maze maze, Explorer explorer);

    String getWhatIsUp(Maze maze, Explorer explorer);

    String getWhatIsInTheLeft(Maze maze, Explorer explorer);

    String getWhatIsInTheRight(Maze maze, Explorer explorer);
}
