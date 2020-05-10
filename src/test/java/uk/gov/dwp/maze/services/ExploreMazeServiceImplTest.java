package uk.gov.dwp.maze.services;

import org.junit.Before;
import org.junit.Test;
import uk.gov.dwp.maze.constants.DirectionEnum;

import static uk.gov.dwp.maze.constants.MazeApplicationConstants.*;
import static uk.gov.dwp.maze.constants.MazeComponentEnum.*;

import uk.gov.dwp.maze.constants.MazeComponentEnum;
import uk.gov.dwp.maze.models.Explorer;
import uk.gov.dwp.maze.models.Maze;

import static org.junit.Assert.*;
import static uk.gov.dwp.maze.utils.MazeUnitTestUtils.buildExplorer;
import static uk.gov.dwp.maze.utils.MazeUnitTestUtils.buildMazeForTest;

public class ExploreMazeServiceImplTest {

    private ExploreMazeService exploreMazeService = null;
    private Explorer explorerWithStartPoint =  null;
    private Maze mazeWithStartPoint = null;

    @Before
    public void init(){
        explorerWithStartPoint = buildExplorer(3,3, DirectionEnum.STARTING_POINT);
        mazeWithStartPoint = buildMazeForTest(3,3,DirectionEnum.STARTING_POINT);
        exploreMazeService = new ExploreMazeServiceImpl();
    }

    @Test
    public void testMoveForward_Return_Moved() {
        Explorer explorer = buildExplorer(1,1,DirectionEnum.MOVED_FORWARD);
        assertTrue(MOVED.equals(exploreMazeService.moveForward(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testMoveForward_Return_Invalid_Coordinates() {
        Explorer explorer = buildExplorer(0,14,DirectionEnum.MOVED_FORWARD);
        assertTrue(INVALID_COORDINATES_PLEASE_TRY_AGAIN.equals(exploreMazeService.moveForward(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testMoveUp_Return_Moved() {
        Explorer explorer = buildExplorer(1,2,DirectionEnum.MOVED_UP);
        assertTrue(MOVED.equals(exploreMazeService.moveUp(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testMoveUp_Return_Invalid_Coordinates() {
        Explorer explorer = buildExplorer(0,0,DirectionEnum.MOVED_UP);
        assertTrue(INVALID_COORDINATES_PLEASE_TRY_AGAIN.equals(exploreMazeService.moveUp(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testMoveLeft_Return_Moved() {
        Explorer explorer = buildExplorer(6,3,DirectionEnum.MOVED_LEFT);
        assertTrue(MOVED.equals(exploreMazeService.moveLeft(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testMoveLeft_Return_Invalid_Coordinates() {
        Explorer explorer = buildExplorer(0,0,DirectionEnum.MOVED_LEFT);
        assertTrue(INVALID_COORDINATES_PLEASE_TRY_AGAIN.equals(exploreMazeService.moveLeft(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testMoveRight_Return_Moved() {
        assertTrue(MOVED.equals(exploreMazeService.moveRight(mazeWithStartPoint, explorerWithStartPoint)));
    }

    @Test
    public void testMoveRight_Return_Invalid_Coordinates() {
        Explorer explorer = buildExplorer(14,0,DirectionEnum.MOVED_RIGHT);
        assertTrue(INVALID_COORDINATES_PLEASE_TRY_AGAIN.equals(exploreMazeService.moveRight(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testGetWhatIsInFront_Should_Return_Wall() {
        assertTrue(String.format(IN_FRONT_OF_YOU, MazeComponentEnum.X.getComponent()).equals(exploreMazeService.getWhatIsInFront(mazeWithStartPoint, explorerWithStartPoint)));
    }

    @Test
    public void testGetWhatIsInFront_Should_Return_Invalid_Coordinate() {
        Explorer explorer = buildExplorer(0,14,DirectionEnum.MOVED_FORWARD);
        assertTrue(INVALID_COORDINATE.equals(exploreMazeService.getWhatIsInFront(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testGetWhatIsUp_Should_Return_Wall() {
        assertTrue(String.format(BEHIND_YOU, MazeComponentEnum.X.getComponent()).equals(exploreMazeService.getWhatIsUp(mazeWithStartPoint, explorerWithStartPoint)));
    }

    @Test
    public void testGetWhatIsUp_Return_Invalid_Coordinate() {
        Explorer explorer = buildExplorer(0,0,DirectionEnum.MOVED_UP);
        assertTrue(INVALID_COORDINATE.equals(exploreMazeService.getWhatIsUp(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testGetWhatIsInTheLeft_Should_Return_Wall() {
        assertTrue(String.format(IN_LEFT_OF_YOU, MazeComponentEnum.X.getComponent()).equals(exploreMazeService.getWhatIsInTheLeft(mazeWithStartPoint, explorerWithStartPoint)));
    }

    @Test
    public void testGetWhatIsInTheLeft_Should_Return_Invalid_Coordinate() {
        Explorer explorer = buildExplorer(0,0,DirectionEnum.MOVED_LEFT);
        assertTrue(INVALID_COORDINATE.equals(exploreMazeService.getWhatIsInTheLeft(mazeWithStartPoint, explorer)));
    }

    @Test
    public void testGetWhatIsInTheRight_Should_Return_Space() {
        assertTrue(String.format(IN_RIGHT_OF_YOU, SPACE.getComponent()).equals(exploreMazeService.getWhatIsInTheRight(mazeWithStartPoint, explorerWithStartPoint)));
    }

    @Test
    public void testGetWhatIsInTheRight_Should_Return_Invalid_Coordinate() {
        Explorer explorer = buildExplorer(14,0,DirectionEnum.MOVED_RIGHT);
        assertTrue(INVALID_COORDINATE.equals(exploreMazeService.getWhatIsInTheRight(mazeWithStartPoint, explorer)));
    }
}