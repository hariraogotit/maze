package uk.gov.dwp.maze.services;

import uk.gov.dwp.maze.exceptions.MazeApplicationException;
import uk.gov.dwp.maze.exceptions.MazeValidationException;
import uk.gov.dwp.maze.models.Maze;

public interface MazeService {

    Maze process(String mazeFile) throws MazeValidationException, MazeApplicationException;
}
