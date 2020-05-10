package uk.gov.dwp.maze.validators;

import uk.gov.dwp.maze.exceptions.MazeValidationException;

public interface MazeValidator {

    void validate(String mazeFromTheFile) throws MazeValidationException;
    boolean doesTheMazeHaveAStartingPoint(String mazeFromTheFile) throws MazeValidationException;
    boolean doesTheMazeHaveAExit(String mazeFromTheFile) throws MazeValidationException;
    boolean isThisAValidMaze(String mazeFromTheFile) throws MazeValidationException;
}
