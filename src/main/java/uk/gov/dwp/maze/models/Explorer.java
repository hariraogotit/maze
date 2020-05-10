package uk.gov.dwp.maze.models;

import java.util.Deque;
import java.util.LinkedList;

public class Explorer {


    private Deque<Coordinate> path = new LinkedList<>();
    public Deque<Coordinate> getPath() {
        return path;
    }

}
