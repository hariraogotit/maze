package uk.gov.dwp.maze.services;

import org.junit.Test;
import uk.gov.dwp.maze.constants.DirectionEnum;
import uk.gov.dwp.maze.exceptions.MazeApplicationException;
import uk.gov.dwp.maze.exceptions.MazeValidationException;
import uk.gov.dwp.maze.models.Maze;
import uk.gov.dwp.maze.utils.MazeBuilder;

import java.util.Arrays;

import static org.junit.Assert.*;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.MAZE_INPUT_FILE;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.MAZE_INPUT_FILE_FOR_TEST;
import static uk.gov.dwp.maze.utils.MazeUnitTestUtils.buildMazeForTest;

public class MazeServiceImplTest {

    @Test
    public void testProcess() throws MazeValidationException, MazeApplicationException {
        MazeService mazeService = new MazeServiceImpl();
        Maze expectedMaze = buildMazeForTest(3,3, DirectionEnum.STARTING_POINT);
        Maze actualMaze = mazeService.process(MAZE_INPUT_FILE_FOR_TEST);
        assertTrue(Arrays.deepEquals(expectedMaze.getStructure(), actualMaze.getStructure()));
        assertTrue(expectedMaze.getStartingPointCoordinate().equals(actualMaze.getStartingPointCoordinate()));
        assertTrue(expectedMaze.getNoOfWalls()==actualMaze.getNoOfWalls());
        assertTrue(expectedMaze.getNoOfEmptySpaces()==actualMaze.getNoOfEmptySpaces());
    }
}