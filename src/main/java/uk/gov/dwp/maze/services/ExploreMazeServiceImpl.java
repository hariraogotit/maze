package uk.gov.dwp.maze.services;


import org.apache.log4j.Logger;

import uk.gov.dwp.maze.constants.DirectionEnum;
import uk.gov.dwp.maze.constants.MazeComponentEnum;
import uk.gov.dwp.maze.models.Coordinate;
import uk.gov.dwp.maze.models.Explorer;
import uk.gov.dwp.maze.models.Maze;
import java.util.Deque;

import static uk.gov.dwp.maze.constants.DirectionEnum.*;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.*;
import static uk.gov.dwp.maze.utils.MazeUtils.*;

public class ExploreMazeServiceImpl implements ExploreMazeService {

    private static Logger logger = Logger.getLogger(ExploreMazeServiceImpl.class);


    @Override
    public Explorer exploreMaze(Maze maze) {
        Explorer explorer = new Explorer();
        initializePathWithStartingCoordinate(maze.getStartingPointCoordinate(), explorer.getPath());
        return  explorer;
    }

    private void initializePathWithStartingCoordinate(Coordinate startingCoordinate, Deque<Coordinate> path) {
        path.push(startingCoordinate);
    }

    @Override
    public String moveForward(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, 0, 1);
        return move(coordinate, maze.getStructure(),explorer, MOVED_FORWARD);
    }

    @Override
    public String moveUp(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, 0, -1);
        return move(coordinate, maze.getStructure(), explorer, MOVED_UP);
    }

    @Override
    public String moveLeft(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, -1, 0);
        return move(coordinate, maze.getStructure(), explorer, MOVED_LEFT);
    }

    @Override
    public String moveRight(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, 1, 0);
        return move(coordinate, maze.getStructure(), explorer, MOVED_RIGHT);
    }

    private String move(Coordinate coordinate, char[][] structure, Explorer explorer, DirectionEnum directionEnum){
        if(isValidCoordinate(coordinate.getY(),coordinate.getX(),structure)
                && !MazeComponentEnum.X.getComponent().equals(getWhatExists(coordinate, structure).get())){
            coordinate.setExit(false);
            coordinate.setDirectionEnum(directionEnum);
            if(F.trim().toCharArray()[0] == structure[explorer.getPath().peek().getY()][explorer.getPath().peek().getX()]){
                coordinate.setExit(true);
            }
            explorer.getPath().push(coordinate);
            return MOVED;
        }
        return INVALID_COORDINATES_PLEASE_TRY_AGAIN;
    }

    @Override
    public String getWhatIsInFront(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, 0, 1);
        if(isValidCoordinate(coordinate.getY(),coordinate.getX(),maze.getStructure())) {
            return String.format(IN_FRONT_OF_YOU,getWhatExists(coordinate,maze.getStructure()).get());
        }
        return INVALID_COORDINATE;
    }

    @Override
    public String getWhatIsUp(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, 0, -1);
        if(isValidCoordinate(coordinate.getY(),coordinate.getX(),maze.getStructure())) {
            return String.format(BEHIND_YOU,getWhatExists(coordinate,maze.getStructure()).get());
        }
        return INVALID_COORDINATE;
    }

    @Override
    public String getWhatIsInTheLeft(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, -1, 0);
        if(isValidCoordinate(coordinate.getY(),coordinate.getX(),maze.getStructure())) {
            return String.format(IN_LEFT_OF_YOU,getWhatExists(coordinate,maze.getStructure()).get());
        }
        return INVALID_COORDINATE;
    }

    @Override
    public String getWhatIsInTheRight(Maze maze, Explorer explorer){
        Coordinate coordinate = getCoordinate(explorer, 1, 0);
        if(isValidCoordinate(coordinate.getY(),coordinate.getX(),maze.getStructure())) {
            return String.format(IN_RIGHT_OF_YOU,getWhatExists(coordinate,maze.getStructure()).get());
        }
        return INVALID_COORDINATE;
    }


}
