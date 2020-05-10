package uk.gov.dwp.maze.validators;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import uk.gov.dwp.maze.exceptions.MazeValidationException;

import static org.junit.Assert.*;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.*;
import static uk.gov.dwp.maze.utils.MazeUnitTestUtils.MAZE_FROM_THE_FILE;
import static uk.gov.dwp.maze.utils.MazeUnitTestUtils.MAZE_FROM_THE_FILE_WITH_IN_VALID_CHARS;

public class MazeValidatorImplTest {

    private  MazeValidator mazeValidator = new MazeValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testDoesTheMazeHaveAStartingPoint_ShouldReturnTrue() throws MazeValidationException {
        assertTrue(mazeValidator.doesTheMazeHaveAStartingPoint(MAZE_FROM_THE_FILE));
    }

    @Test
    public void testDoesTheMazeHaveAStartingPoint_ShouldThrowException() throws MazeValidationException {
        thrown.expect(MazeValidationException.class);
        thrown.expectMessage(MAZE_DOES_NOT_HAVE_A_STARTING_POINT_OR_HAS_MORE_THAN_ONE_STARING_POINT);
        mazeValidator.doesTheMazeHaveAStartingPoint(MAZE_FROM_THE_FILE_WITH_IN_VALID_CHARS);
    }

    @Test
    public void testDoesTheMazeHaveAExit_ShouldReturnTrue() throws MazeValidationException {
        assertTrue(mazeValidator.doesTheMazeHaveAExit(MAZE_FROM_THE_FILE));
    }

    @Test
    public void testDoesTheMazeHaveAExit_ShouldThrowException() throws MazeValidationException {
        thrown.expect(MazeValidationException.class);
        thrown.expectMessage(MAZE_DOES_NOT_HAVE_AN_EXIT_OR_HAS_MORE_THAN_ONE_EXITS);
        mazeValidator.doesTheMazeHaveAExit(MAZE_FROM_THE_FILE_WITH_IN_VALID_CHARS);
    }

    @Test
    public void testIsThisAValidMaze_ShouldReturnTrue() throws MazeValidationException {
        assertTrue(mazeValidator.isThisAValidMaze(MAZE_FROM_THE_FILE));
    }

    @Test
    public void testIsThisAValidMaze_ShouldThrowException() throws MazeValidationException {
        thrown.expect(MazeValidationException.class);
        thrown.expectMessage(MAZE_CONTAINS_INVALID_CHARACTERS);
        mazeValidator.isThisAValidMaze(MAZE_FROM_THE_FILE_WITH_IN_VALID_CHARS);
    }
}