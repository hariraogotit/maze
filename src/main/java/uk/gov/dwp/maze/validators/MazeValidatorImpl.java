package uk.gov.dwp.maze.validators;

import org.apache.log4j.Logger;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.*;
import uk.gov.dwp.maze.exceptions.MazeValidationException;

import static uk.gov.dwp.maze.utils.MazeUtils.getCount;

public class MazeValidatorImpl implements MazeValidator {

    private static Logger logger = Logger.getLogger(MazeValidatorImpl.class);

    @Override
    public void validate(String mazeFromTheFile) throws MazeValidationException {
        isThisAValidMaze(mazeFromTheFile);
        doesTheMazeHaveAStartingPoint(mazeFromTheFile);
        doesTheMazeHaveAExit(mazeFromTheFile);
    }

    @Override
    public boolean doesTheMazeHaveAStartingPoint(String mazeFromTheFile) throws MazeValidationException {
        if(getCount(mazeFromTheFile, S.toCharArray()[0])!=1){
            logger.error(MAZE_DOES_NOT_HAVE_A_STARTING_POINT_OR_HAS_MORE_THAN_ONE_STARING_POINT);
            throw  new MazeValidationException(MAZE_DOES_NOT_HAVE_A_STARTING_POINT_OR_HAS_MORE_THAN_ONE_STARING_POINT);
        }
        return true;
    }

    @Override
    public boolean doesTheMazeHaveAExit(String mazeFromTheFile) throws MazeValidationException {
        if(getCount(mazeFromTheFile, F.toCharArray()[0])!=1){
            logger.error(MAZE_DOES_NOT_HAVE_AN_EXIT_OR_HAS_MORE_THAN_ONE_EXITS);
            throw  new MazeValidationException(MAZE_DOES_NOT_HAVE_AN_EXIT_OR_HAS_MORE_THAN_ONE_EXITS);
        }
        return true;
    }

    @Override
    public boolean isThisAValidMaze(String mazeFromTheFile) throws MazeValidationException{
        if (!mazeFromTheFile.matches("[SFX \n]*")) {
            logger.error(MAZE_CONTAINS_INVALID_CHARACTERS);
            throw new MazeValidationException(MAZE_CONTAINS_INVALID_CHARACTERS);
        }
        return true;
    }
}
