package betterdoodle.project.mmu.ac.uk.betterdoodleappServer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pugs on 07/11/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // Logcat tag
    private static final String log = "DatabaseHandler";

    // Database Version
    private static final int dbVer = 1;

    // Database Name
    private static final String dbName = "meetings";

    // Table Names
    private static final String tbMeetings = "meetings";
    private static final String tbUsers = "users";
    private static final String tbSlots = "slots";

    // Common column names
    private static final String clID = "id";

    // meetings Table - column names
    private static final String clMeetingName = "meetingName";
    private static final String clMeetingLocation = "meetingLocation";

    // users Table - column names
    private static final String clUsername = "userUsername";
    private static final String clEmail = "userEmail";

    // slots Table - column names
    private static final String meetingsID = "meetingsID";
    private static final String usersID = "usersID";
    private static final String availableSlot = "availableSlot";

    // Table Create Statements
    // Todo table create statement
    private static final String createTBMeetings = "CREATE TABLE "
            + tbMeetings + "(" + clID + " INTEGER PRIMARY KEY," + clMeetingName
            + " TEXT," + clMeetingLocation + " TEXT," + ")";

    // Tag table create statement
    private static final String createTBUsers = "CREATE TABLE " + tbUsers
            + "(" + clID + " INTEGER PRIMARY KEY," + clUsername + " TEXT,"
            + clEmail + "TEXT" + ")";

    // todo_tag table create statement
    private static final String createTBSlots = "CREATE TABLE "
            + tbSlots + "(" + clID + " INTEGER PRIMARY KEY,"
            + meetingsID + " INTEGER," + usersID + " INTEGER,"
            + availableSlot + "DATETIME" + ")";

    public DatabaseHandler(Context context) {
        super(context, dbName, null, dbVer);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(createTBMeetings);
        db.execSQL(createTBUsers);
        db.execSQL(createTBSlots);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + tbMeetings);
        db.execSQL("DROP TABLE IF EXISTS " + tbUsers);
        db.execSQL("DROP TABLE IF EXISTS " + tbSlots);

        // create new tables
        onCreate(db);
    }

    public long createMeeting(Meetings meetings, long[] usersIDs, long availSlot) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(clMeetingName, meetings.getMeetingName());

        // insert row
        long meetingID = db.insert(tbMeetings, null, values);

        // assigning users to meetings
        for (long usersID : usersIDs) {
            createSlots(meetingID, usersID, availSlot);
        }

        return meetingID;

    }

    public Meetings getMeeting(long meetingID) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + tbMeetings + " WHERE "
                + clID + " = " + meetingID;

        Log.e(log, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Meetings mt = new Meetings();
        mt.setId(c.getInt(c.getColumnIndex(clID)));
        mt.setMeetingName((c.getString(c.getColumnIndex(clMeetingName))));
        mt.setMeetingLocation(c.getString(c.getColumnIndex(clMeetingLocation)));

        return mt;
    }

    public List<Meetings> getAllMeetings() {
        List<Meetings> meetings = new ArrayList<Meetings>();
        String selectQuery = "SELECT  * FROM " + tbMeetings;

        Log.e(log, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Meetings mt = new Meetings();
                mt.setId(c.getInt(c.getColumnIndex(clID)));
                mt.setMeetingName((c.getString(c.getColumnIndex(clMeetingName))));
                mt.setMeetingLocation(c.getString(c.getColumnIndex(clMeetingLocation)));

                // adding to meeting to array
                meetings.add(mt);
            } while (c.moveToNext());
        }

        return meetings;
    }

    public List<Meetings> getAllMeetingsByUserName(String meetingName) {
        List<Meetings> Meetings = new ArrayList<Meetings>();

        String selectQuery = "SELECT  * FROM " + tbMeetings + " mt, "
                + tbUsers + " usr, " + tbSlots + " slt WHERE usr."
                + clUsername + " = '" + meetingName + "'" + " AND usr." + clID
                + " = " + "slt." + meetingsID + " AND mt." + clID + " = "
                + "slt." + usersID;

        Log.e(log, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Meetings mt = new Meetings();
                mt.setId(c.getInt((c.getColumnIndex(clID))));
                mt.setMeetingName((c.getString(c.getColumnIndex(meetingName))));
                mt.setMeetingLocation(c.getString(c.getColumnIndex(clMeetingLocation)));

                // adding to meeting to array
                Meetings.add(mt);
            } while (c.moveToNext());
        }

        return Meetings;
    }

    public int updateMeetings(Meetings meetings) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(clMeetingName, meetings.getMeetingName());
        values.put(clMeetingLocation, meetings.getMeetingLocation());

        // updating row
        return db.update(tbMeetings, values, clID + " = ?",
                new String[] { String.valueOf(meetings.getId()) });
    }

    public void deleteMeeting(long meetingID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tbMeetings, clID + " = ?",
                new String[] { String.valueOf(meetingID) });
    }

    public long createUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(clUsername, users.getUserUsername());
        values.put(clEmail, users.getUserEmail());

        // insert row
        long usersID = db.insert(tbUsers, null, values);

        return usersID;
    }

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        String selectQuery = "SELECT  * FROM " + tbUsers;

        Log.e(log, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Users us = new Users();
                us.setId(c.getInt((c.getColumnIndex(clID))));
                us.setUserUsername(c.getString(c.getColumnIndex(clUsername)));
                us.setUserEmail(c.getString(c.getColumnIndex(clEmail)));

                // adding to tags list
                users.add(us);
            } while (c.moveToNext());
        }
        return users;
    }

    public int updateUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(clUsername, users.getUserUsername());
        values.put(clEmail, users.getUserEmail());
        // updating row
        return db.update(tbUsers, values, clID + " = ?",
                new String[] { String.valueOf(users.getId()) });
    }


    public long createSlots(long meetingID, long userID, long availSlot) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(meetingsID, meetingID);
        values.put(usersID, userID);
        values.put(availableSlot, availSlot);

        long id = db.insert(tbSlots, null, values);

        return id;
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
