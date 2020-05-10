package uk.gov.dwp.maze.models;

import uk.gov.dwp.maze.constants.DirectionEnum;

import java.util.Objects;

public class Coordinate {

    private int x;
    private int y;
    private DirectionEnum directionEnum;
    private boolean isExit;

    public Coordinate(int y, int x) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public DirectionEnum getDirectionEnum() {
        return directionEnum;
    }

    public void setDirectionEnum(DirectionEnum directionEnum) {
        this.directionEnum = directionEnum;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y &&
                isExit == that.isExit &&
                directionEnum == that.directionEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, directionEnum, isExit);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", directionEnum=" + directionEnum.getDirection() +
                '}';
    }
}