package uk.gov.dwp.maze.utils;

import org.junit.Test;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.S;

import uk.gov.dwp.maze.constants.DirectionEnum;
import uk.gov.dwp.maze.constants.MazeComponentEnum;
import uk.gov.dwp.maze.models.Coordinate;

import java.util.Optional;

import static org.junit.Assert.*;
import static uk.gov.dwp.maze.utils.MazeUnitTestUtils.*;

public class MazeUtilsTest {

    @Test
    public void testGetCount(){
        long countOfWalls = MazeUtils.getCount(MAZE_FROM_THE_FILE, 'X');
        assertTrue(countOfWalls==150);
    }

    @Test
    public void testIsValidCoordinatesWithInValidCoordinates(){
        assertFalse(MazeUtils.isValidCoordinate(-1,-1,STRUCTURE_OF_MAZE));
    }

    @Test
    public void testIsValidCoordinatesWithValidCoordinates(){
        assertTrue(MazeUtils.isValidCoordinate(1,1,STRUCTURE_OF_MAZE));
    }

    @Test
    public void testGetTheStartPointCoordinate(){
        Coordinate expectCoordinate = buildCoordinate(3,3, DirectionEnum.STARTING_POINT);
        Coordinate actualCoordinate = MazeUtils.getTheStartPointCoordinate(STRUCTURE_OF_MAZE, S.toCharArray()[0]);
        assertTrue(expectCoordinate.equals(actualCoordinate));
    }

    @Test
    public void testGetWhatExists_ShouldReturnStartPoint(){
        Coordinate coordinate = buildCoordinate(3,3,DirectionEnum.STARTING_POINT);
        Optional<String> itemInTheCoordinate = MazeUtils.getWhatExists(coordinate, STRUCTURE_OF_MAZE);
        assertTrue(MazeComponentEnum.S.getComponent().equals(itemInTheCoordinate.get()));
    }

    @Test
    public void testGetWhatExists_ShouldReturnWall(){
        Coordinate coordinate = buildCoordinate(0,0,DirectionEnum.MOVED_FORWARD);
        Optional<String> itemInTheCoordinate = MazeUtils.getWhatExists(coordinate, STRUCTURE_OF_MAZE);
        assertTrue(MazeComponentEnum.X.getComponent().equals(itemInTheCoordinate.get()));
    }

    @Test
    public void testGetCoordinate(){
        Coordinate expectCoordinate = buildCoordinate(0,0,DirectionEnum.MOVED_FORWARD);
        Coordinate actualCoordinate = MazeUtils.getCoordinate(buildExplorer(-1,-1,DirectionEnum.MOVED_FORWARD),1,1);
        actualCoordinate.setDirectionEnum(DirectionEnum.MOVED_FORWARD);
        actualCoordinate.setExit(false);
        assertTrue(expectCoordinate.equals(actualCoordinate));
    }
}