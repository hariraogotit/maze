package uk.gov.dwp.maze.exceptions;

import org.apache.log4j.Logger;


public class MazeValidationException extends Exception {

    public MazeValidationException(String message){
        super(message);
    }
}
