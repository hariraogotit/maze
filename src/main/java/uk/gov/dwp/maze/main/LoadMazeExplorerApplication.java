package uk.gov.dwp.maze.main;

import uk.gov.dwp.maze.exceptions.MazeApplicationException;
import uk.gov.dwp.maze.exceptions.MazeValidationException;
import uk.gov.dwp.maze.models.Coordinate;
import uk.gov.dwp.maze.models.Explorer;
import uk.gov.dwp.maze.models.Maze;
import uk.gov.dwp.maze.services.ExploreMazeService;
import uk.gov.dwp.maze.services.ExploreMazeServiceImpl;
import uk.gov.dwp.maze.services.MazeService;
import uk.gov.dwp.maze.services.MazeServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static uk.gov.dwp.maze.constants.MazeApplicationConstants.*;
import static uk.gov.dwp.maze.utils.MazeUtils.getWhatExists;
import static uk.gov.dwp.maze.utils.MazeUtils.isValidCoordinate;

public class LoadMazeExplorerApplication {


    public static void main(String[] args) throws MazeValidationException, MazeApplicationException {
        MazeService mazeService = new MazeServiceImpl();
        Maze maze = mazeService.process(MAZE_INPUT_FILE);
        printMazeDetails(maze);
        printWhatExistsInTheGivenCoordinate(maze);
        ExploreMazeService exploreMazeService = new ExploreMazeServiceImpl();
        Explorer explorer = exploreMazeService.exploreMaze(maze);
        traverse(exploreMazeService, explorer, maze);
        System.out.println(PATH_VISITED_BY_THE_EXPLORER + explorer.getPath());
    }

    private static void traverse(ExploreMazeService exploreMazeService, Explorer explorer, Maze maze) {
        System.out.println(MOVE_ANY_SIDE);
        Scanner input = new Scanner(System.in);
        String move = input.next();
        while(isValidInput(move)){
            if(L.equals(move) || LOWER_CASE_L.equals(move)) {
                System.out.println(exploreMazeService.moveLeft(maze, explorer));
            }else if(R.equals(move) || LOWER_CASE_R.equals(move)) {
                System.out.println(exploreMazeService.moveRight(maze, explorer));
            }else if(U.equals(move) || LOWER_CASE_U.equals(move)) {
                System.out.println(exploreMazeService.moveUp(maze, explorer));
            }else if(F.equals(move) || LOWER_CASE_F.equals(move)) {
                System.out.println(exploreMazeService.moveForward(maze, explorer));
            }
            if(explorer.getPath().peek().isExit()){
                return;
            }
            System.out.println(String.format(YOU_ARE_AT_X_D_Y_D, explorer.getPath().peek().getX(), explorer.getPath().peek().getY() ));
            printWhatExistsInFront(maze, explorer, exploreMazeService);
            printAllTheMovementOptionAround(maze, explorer, exploreMazeService);
            System.out.println(MOVE_ANY_SIDE);
            move = input.next();
        }
    }

    private static void printAllTheMovementOptionAround(Maze maze, Explorer explorer, ExploreMazeService exploreMazeService) {
        System.out.println(WHAT_EXISTS_AROUND);
        Scanner input = new Scanner(System.in);
        String whatExistsAround = input.next();
        List<String> allTheMovementOptionAround = new ArrayList<>();
        while (Y.equals(whatExistsAround) || LOWER_CASE_Y.equals(whatExistsAround)) {
            allTheMovementOptionAround.add(exploreMazeService.getWhatIsInFront(maze, explorer));
            allTheMovementOptionAround.add(exploreMazeService.getWhatIsUp(maze, explorer));
            allTheMovementOptionAround.add(exploreMazeService.getWhatIsInTheLeft(maze, explorer));
            allTheMovementOptionAround.add(exploreMazeService.getWhatIsInTheRight(maze, explorer));
            System.out.println(allTheMovementOptionAround);
            System.out.println(WHAT_EXISTS_AROUND);
            whatExistsAround = input.next();
        }
    }

    private static void printWhatExistsInFront(Maze maze, Explorer explorer, ExploreMazeService exploreMazeService) {
        System.out.println(WHAT_EXISTS_IN_FRONT);
        Scanner input = new Scanner(System.in);
        String whatExistsAhead = input.next();
        while (Y.equals(whatExistsAhead) || LOWER_CASE_Y.equals(whatExistsAhead)){
            System.out.println(exploreMazeService.getWhatIsInFront(maze, explorer));
            System.out.println(WHAT_EXISTS_IN_FRONT);
            whatExistsAhead = input.next();
        }
    }

    public static boolean isValidInput(String move){
        return L.equals(move) || LOWER_CASE_L.equals(move) || R.equals(move) || LOWER_CASE_R.equals(move) ||
                U.equals(move) || LOWER_CASE_U.equals(move) || F.equals(move) || LOWER_CASE_F.equals(move) ;
    }

    private static void printWhatExistsInTheGivenCoordinate(Maze maze) {
        Scanner input = new Scanner(System.in);
        System.out.println(ENTER_Y_OR_EXIT);
        String whatExistsInACoordinate = input.next();
        while(LOWER_CASE_Y.equals(whatExistsInACoordinate) || Y.equals(whatExistsInACoordinate)){
            System.out.println(ENTER_X_COORDINATE);
            int x = input.nextInt();
            System.out.println(ENTER_Y_COORDINATE);
            int y = input.nextInt();
            processCoordinate(maze, x, y);
            System.out.println(ENTER_Y_OR_EXIT);
            whatExistsInACoordinate = input.next();

        }
    }

    private static void processCoordinate(Maze maze, int x, int y) {
        if(isValidCoordinate(y, x, maze.getStructure() )) {
            System.out.println(String.format
                     (VALUE_IN_THE_COORDINATE, x, y,
                             getWhatExists(new Coordinate(y, x), maze.getStructure()).get() ));
        }else{
            System.out.println(INVALID_COORDINATES_PLEASE_TRY_AGAIN);
        }
    }

    private static void printMazeDetails(Maze maze) {
        printProcessedMaze(maze);
        long numberOfWalls = maze.getNoOfWalls();
        long noOfWhiteSpaces = maze.getNoOfEmptySpaces();
        System.out.println(String.format("\n" + NO_OF_WALLS_AND_SPACES ,numberOfWalls, noOfWhiteSpaces));
        System.out.println(YOU_ARE_AT_THE_STARTING_POINT_COORDINATE + maze.getStartingPointCoordinate());
    }

    private static void printProcessedMaze(Maze maze) {
        System.out.println("\n" + LOADED_MAZE_FROM_THE_GIVEN_FILE + "\n");
        System.out.println(Arrays.deepToString(maze.getStructure()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
}
