package uk.gov.dwp.maze.services;

import uk.gov.dwp.maze.exceptions.MazeApplicationException;
import uk.gov.dwp.maze.exceptions.MazeValidationException;
import uk.gov.dwp.maze.models.Maze;
import uk.gov.dwp.maze.validators.MazeValidator;
import uk.gov.dwp.maze.validators.MazeValidatorImpl;

import static uk.gov.dwp.maze.utils.MazeBuilder.buildMaze;
import static uk.gov.dwp.maze.utils.MazeBuilder.readMazeFile;

public class MazeServiceImpl implements MazeService {
    @Override
    public Maze process(String mazeFile) throws MazeValidationException, MazeApplicationException {
        MazeValidator mazeValidator = new MazeValidatorImpl();
        String mazeFromTheFile = readMazeFile(mazeFile);
        if(mazeFromTheFile!=null){
            mazeValidator.validate(mazeFromTheFile);
        }
        return buildMaze(mazeFile);
    }
}
