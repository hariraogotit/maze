package uk.gov.dwp.maze.utils;

import uk.gov.dwp.maze.constants.DirectionEnum;
import static uk.gov.dwp.maze.constants.MazeApplicationConstants.S;
import uk.gov.dwp.maze.constants.MazeComponentEnum;
import uk.gov.dwp.maze.models.Coordinate;
import uk.gov.dwp.maze.models.Explorer;

import java.util.Optional;

public class MazeUtils {

    public static long getCount(String mazeFromTheFile, char noOfCharsInMazeFromTheFile) {
        return mazeFromTheFile.chars().filter(character -> (char) character == noOfCharsInMazeFromTheFile).count();
    }

    public static boolean isValidCoordinate(int y, int x, char[][] structure) {
        if(y < 0 || y >= structure.length ||
                x < 0 || x >= structure[y].length) {
            return false;
        }
        return true;
    }

    public static Coordinate getTheStartPointCoordinate(char[][] structure, char searchForChar){
        for(int i=0; i<structure.length; i++){
            for (int j=0;j<structure[i].length;j++){
                if(structure[j][i] == searchForChar){
                    Coordinate coordinate = new Coordinate(j,i);
                    if(searchForChar== S.toCharArray()[0]){
                        coordinate.setDirectionEnum(DirectionEnum.STARTING_POINT);
                    }
                    return coordinate;
                }
            }
        }
        return null;
    }

    public static Optional<String> getWhatExists(Coordinate coordinate, char[][] structure){
        if(structure[coordinate.getY()][coordinate.getX()]==' '){
            return Optional.of(MazeComponentEnum.SPACE.getComponent());
        }else if(structure[coordinate.getY()][coordinate.getX()]=='X'){
            return Optional.of(MazeComponentEnum.X.getComponent());
        }else if(structure[coordinate.getY()][coordinate.getX()]=='S'){
            return Optional.of(MazeComponentEnum.S.getComponent());
        }else if(structure[coordinate.getY()][coordinate.getX()]=='F'){
            return Optional.of(MazeComponentEnum.F.getComponent());
        }
        return Optional.empty();
    }

    public static Coordinate getCoordinate(Explorer explorer, int x, int y){
        int xIncrement =  explorer.getPath().peek().getX() + x;
        int yIncrement =  explorer.getPath().peek().getY() + y;
        return new Coordinate(yIncrement, xIncrement);
    }
}
