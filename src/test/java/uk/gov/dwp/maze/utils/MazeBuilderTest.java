package uk.gov.dwp.maze.utils;


import org.junit.Test;
import uk.gov.dwp.maze.constants.DirectionEnum;
import uk.gov.dwp.maze.exceptions.MazeApplicationException;
import uk.gov.dwp.maze.models.Maze;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.MAZE_INPUT_FILE;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.MAZE_INPUT_FILE_FOR_TEST;
import static uk.gov.dwp.maze.utils.MazeUnitTestUtils.*;

public class MazeBuilderTest {


    @Test
    public void testReadMazeFile() throws MazeApplicationException {
        String actualMazeFromTheFile = MazeBuilder.readMazeFile(MAZE_INPUT_FILE_FOR_TEST);
        assertTrue(MAZE_FROM_THE_FILE.equals(actualMazeFromTheFile));
    }

    @Test
    public void testBuildStructureOfMaze(){
        char[][] actualStructureOfMaze = MazeBuilder.buildStructureOfMaze(MAZE_FROM_THE_FILE);
        assertTrue(Arrays.deepEquals(STRUCTURE_OF_MAZE, actualStructureOfMaze));
    }

    @Test
    public void testBuildMaze() throws MazeApplicationException {
        Maze expectedMaze = buildMazeForTest(3,3, DirectionEnum.STARTING_POINT);
        Maze actualMaze = MazeBuilder.buildMaze(MAZE_INPUT_FILE_FOR_TEST);
        assertTrue(Arrays.deepEquals(expectedMaze.getStructure(), actualMaze.getStructure()));
        assertTrue(expectedMaze.getStartingPointCoordinate().equals(actualMaze.getStartingPointCoordinate()));
        assertTrue(expectedMaze.getNoOfWalls()==actualMaze.getNoOfWalls());
        assertTrue(expectedMaze.getNoOfEmptySpaces()==actualMaze.getNoOfEmptySpaces());
    }


}