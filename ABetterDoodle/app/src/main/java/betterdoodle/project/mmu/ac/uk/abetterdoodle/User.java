package betterdoodle.project.mmu.ac.uk.abetterdoodle;

/**
 * Created by Pugs on 05/03/2018.
 */

public class Users {

    private String user_Email;
    private String user_Name;
    private String user_Picture;
    private String event_Description;

    public Users(){

    }

    public Event(String event_HostId, String event_Name, String event_Date, String event_Description) {
        this.event_HostId = event_HostId;
        this.event_Name = event_Name;
        this.event_Date = event_Date;
        this.event_Description = event_Description;
    }

    public String getEvent_HostId() {
        return event_HostId;
    }

    public String getEvent_Name() {
        return event_Name;
    }

    public String getEvent_Date() {
        return event_Date;
    }

    public String getEvent_Description() {
        return event_Description;
    }

}
