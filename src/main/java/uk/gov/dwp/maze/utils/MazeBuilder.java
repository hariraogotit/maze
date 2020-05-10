package uk.gov.dwp.maze.utils;

import org.apache.log4j.Logger;
import uk.gov.dwp.maze.exceptions.MazeApplicationException;
import uk.gov.dwp.maze.models.Maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static uk.gov.dwp.maze.constants.MazeApplicationConstants.EXCEPTION_WHILE_READING_THE_FILE;
import static uk.gov.dwp.maze.utils.MazeUtils.getCount;
import static uk.gov.dwp.maze.utils.MazeUtils.getTheStartPointCoordinate;

public class MazeBuilder {

    private static Logger logger = Logger.getLogger(MazeBuilder.class);

    public static String readMazeFile(String mazeFile) throws MazeApplicationException {
        String mazeFromTheFile = null;
        try {
             mazeFromTheFile =  new String(Files.readAllBytes(Paths.get(mazeFile)));
        } catch (IOException e) {
            logger.error(String.format(EXCEPTION_WHILE_READING_THE_FILE, mazeFile, e));
            throw new MazeApplicationException(e.getMessage());
        }
        return mazeFromTheFile;
    }

    public static char[][] buildStructureOfMaze(String mazeFromTheFile){
        String rows[] = mazeFromTheFile.split("\n");
        char[][] structureOfMaze = new char[rows.length][rows[0].length()];
        for (int i = 0; i < rows.length; i++) {
            structureOfMaze[i] = rows[i].toCharArray();
        }
        return structureOfMaze;
    }

    public static Maze buildMaze(String mazeFile) throws MazeApplicationException {
        char[][] structureOfMaze = null;
        String mazeFromTheFile = readMazeFile(mazeFile);
        if(mazeFromTheFile !=null){
           structureOfMaze = buildStructureOfMaze(mazeFromTheFile);
        }
        return new Maze(structureOfMaze,
                           getCount(mazeFromTheFile,'X'),
                           getCount(mazeFromTheFile, ' '), getTheStartPointCoordinate(structureOfMaze, 'S'));
    }
}
