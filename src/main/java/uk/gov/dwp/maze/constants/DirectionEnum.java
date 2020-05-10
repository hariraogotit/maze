package uk.gov.dwp.maze.constants;

public enum DirectionEnum {


    MOVED_RIGHT("Moved Right"),
    MOVED_UP("Moved Up"),
    MOVED_FORWARD("Moved Forward"),
    MOVED_BACK("Moved Back"),
    STARTING_POINT("Starting Point"),
    MOVED_LEFT("Moved left");

    private String direction;

    DirectionEnum(String direction){
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

}
