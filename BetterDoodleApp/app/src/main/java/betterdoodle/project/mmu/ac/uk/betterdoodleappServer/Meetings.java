package betterdoodle.project.mmu.ac.uk.betterdoodleappServer;

/**
 * Created by Pugs on 07/11/2017.
 */

public class Meetings {

    int id;
    String meetingName;
    String meetingLocation;

    //constructs
    public Meetings() {
    }

    public Meetings(String meetingName, String meetingLocation) {
        this.meetingName = meetingName;
        this.meetingLocation = meetingLocation;
    }

    public Meetings(int id, String meetingName, String meetingLocation) {
        this.id = id;
        this.meetingName = meetingName;
        this.meetingLocation = meetingLocation;
    }
    //gets the values
    public long getId() {
        return this.id;
    }

    public String getMeetingName() {
        return this.meetingName;
    }

    public String getMeetingLocation() {
        return this.meetingLocation;
    }
    //sets the values
    public void setId(int id) {
        this.id = id;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }
}
