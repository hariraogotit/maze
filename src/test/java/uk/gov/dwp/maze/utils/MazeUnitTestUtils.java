package uk.gov.dwp.maze.utils;

import uk.gov.dwp.maze.constants.DirectionEnum;
import uk.gov.dwp.maze.models.Coordinate;
import uk.gov.dwp.maze.models.Explorer;
import uk.gov.dwp.maze.models.Maze;

public class MazeUnitTestUtils {


    public static final String MAZE_FROM_THE_FILE = "XXXXXXXXXXXXXXX\n" +
            "X             X\n" +
            "X XXXXXXXXXXX X\n" +
            "X XS        X X\n" +
            "X XXXXXXXXX X X\n" +
            "X XXXXXXXXX X X\n" +
            "X XXXX     FX X\n" +
            "X XXXX XXXX X X\n" +
            "X XXXX XXXX X X\n" +
            "X X    XXXXXX X\n" +
            "X X XXXXXXXXX X\n" +
            "X X XXXXXXXXX X\n" +
            "X X         X X\n" +
            "X XXXXXXXXX   X\n" +
            "XXXXXXXXXXXXXXX";

    public static final String MAZE_FROM_THE_FILE_WITH_IN_VALID_CHARS = "XXXXXXXXXXXXXXX\n" +
            "X             X\n" +
            "X XLXXXXXXXXX X\n" +
            "X XS        X X\n" +
            "X XSXXXXXXX X X\n" +
            "X XXXXXXXXX X X\n" +
            "X XXXX     FX X\n" +
            "X XXXX XXXX X X\n" +
            "X XXXX XXXF X X\n" +
            "X X    XXXXXX X\n" +
            "X X XXXXXXXXX X\n" +
            "X X XXXXXXXXX X\n" +
            "X X         X X\n" +
            "X XXXXXXXXX   X\n" +
            "XXXXXXXXXXXXXXX";

    public static final char[][] STRUCTURE_OF_MAZE = {
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X',' ' , ' ' ,' ' ,' '  ,' '  ,' '  ,' '  , ' ' , ' ' ,' '  , ' ' , ' ' , ' ' , 'X'},
            {'X',' '  , 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ' , 'X'},
            {'X', ' ' , 'X', 'S',' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,' '  , 'X',' '  , 'X'},
            {'X',' '  , 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ' , 'X', ' ' , 'X'},
            {'X',' '  , 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',' '  , 'X',' '  , 'X'},
            {'X',' '  , 'X', 'X', 'X', 'X',' '  ,' '  ,' '  ,' '  ,' '  , 'F', 'X',' '  , 'X'},
            {'X',' ', 'X', 'X', 'X', 'X', ' ' , 'X', 'X', 'X', 'X',' '  , 'X',' '  , 'X'},
            {'X', ' ' , 'X', 'X', 'X', 'X', ' ' , 'X', 'X', 'X', 'X', ' ' , 'X',' '  , 'X'},
            {'X', ' ' , 'X', ' ' ,' '  ,' '  ,' '  , 'X', 'X', 'X', 'X', 'X', 'X', ' ' , 'X'},
            {'X', ' ' , 'X', ' ' , 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ' , 'X'},
            {'X', ' ' , 'X',' '  , 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ' , 'X'},
            {'X', ' ' , 'X', ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , 'X',' ', 'X'},
            {'X',' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',' ',' ',' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
    };


    public static  Maze buildMazeForTest(int x, int y, DirectionEnum directionEnum){
        Coordinate coordinate = buildCoordinate(x, y, directionEnum);
        return new Maze(STRUCTURE_OF_MAZE, 150, 73,coordinate );
    }

    public static Coordinate buildCoordinate(int x, int y, DirectionEnum directionEnum) {
        Coordinate coordinate = new Coordinate(y,x);
        coordinate.setDirectionEnum(directionEnum);
        coordinate.setExit(false);
        return coordinate;
    }

    public static Explorer buildExplorer(int x, int y, DirectionEnum directionEnum){
        Explorer explorer  = new Explorer();
        explorer.getPath().add(buildCoordinate(x,y,directionEnum));
        return explorer;
    }
}
