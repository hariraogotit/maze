package uk.gov.dwp.maze.models;




public class Maze {


    private char[][] structure;
    private long noOfWalls;
    private long noOfEmptySpaces;
    private Coordinate startingPointCoordinate;

    public Maze(char[][] structure, long noOfWalls, long  noOfEmptySpaces, Coordinate startingPointCoordinate){
        this.noOfEmptySpaces = noOfEmptySpaces;
        this.noOfWalls = noOfWalls;
        this.structure = structure;
        this.startingPointCoordinate = startingPointCoordinate;
    }


    public long getNoOfWalls() {
        return noOfWalls;
    }

    public long getNoOfEmptySpaces() {
        return noOfEmptySpaces;
    }

    public char[][] getStructure() {
        return structure;
    }


    public Coordinate getStartingPointCoordinate() {
        return startingPointCoordinate;
    }

}
