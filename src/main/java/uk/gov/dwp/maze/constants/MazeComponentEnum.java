package uk.gov.dwp.maze.constants;

public enum MazeComponentEnum {

    X("Wall"),
    F("Exit"),
    S("Start Point"),
    SPACE("Space");

    private String component;

    MazeComponentEnum(String component){
        this.component = component;
    }

    public String getComponent() {
        return component;
    }
}
