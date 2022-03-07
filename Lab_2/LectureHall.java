package com.company;

public class LectureHall extends Room {
    boolean hasProjector;
    boolean projectorInfo;

    public LectureHall(String roomName, int cap) {
        super(roomName, cap);
        this.projectorInfo = false;
    }

    public LectureHall(String roomName, int cap, boolean hasProjector) {
        super(roomName, cap);
        this.hasProjector = hasProjector;
        this.projectorInfo = true;
    }

    @Override
    public String toString() {
        if (projectorInfo) {
            if (hasProjector) {
                return "LectureHall{" +
                        "roomName='" + roomName + '\'' +
                        ", cap=" + cap +
                        ", hasProjector=true}";
            } else {
                return "LectureHall{" +
                        "roomName='" + roomName + '\'' +
                        ", cap=" + cap +
                        ", hasProjector=false}";
            }
        } else {
            return "LectureHall{" +
                    "roomName='" + roomName + '\'' +
                    ", cap=" + cap +
                    '}';
        }
    }
}
