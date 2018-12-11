package betterdoodle.project.mmu.ac.uk.betterdoodleappServer;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import betterdoodle.project.mmu.ac.uk.betterdoodleappServer.DatabaseHandler;
import betterdoodle.project.mmu.ac.uk.betterdoodleappServer.Meetings;
import betterdoodle.project.mmu.ac.uk.betterdoodleappServer.Users;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

    public class MainActivity extends Activity {

        // Database Handler
        DatabaseHandler db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            db = new DatabaseHandler(getApplicationContext());

            // Creating tags
            Meetings meeting1 = new Meetings("Pub Time", "Courtyard");
            Meetings meeting2 = new Meetings("Important");
            Meetings meeting3 = new Meetings("Watchlist");
            Meetings meeting4 = new Meetings("Androidhive");

            // Inserting tags in db
            long meeting1_id = db.createMeeting(meeting1);
            long meeting2_id = db.createMeeting(meeting2);
            long meeting3_id = db.createMeeting(meeting3);
            long meeting4_id = db.createMeeting(meeting4);

            Log.d("Tag Count", "Tag Count: " + db.getAllTags().size());

            // Creating ToDos
            Todo todo1 = new Todo("iPhone 5S", 0);
            Todo todo2 = new Todo("Galaxy Note II", 0);
            Todo todo3 = new Todo("Whiteboard", 0);

            Todo todo4 = new Todo("Riddick", 0);
            Todo todo5 = new Todo("Prisoners", 0);
            Todo todo6 = new Todo("The Croods", 0);
            Todo todo7 = new Todo("Insidious: Chapter 2", 0);

            Todo todo8 = new Todo("Don't forget to call MOM", 0);
            Todo todo9 = new Todo("Collect money from John", 0);

            Todo todo10 = new Todo("Post new Article", 0);
            Todo todo11 = new Todo("Take database backup", 0);

            // Inserting todos in db
            // Inserting todos under "Shopping" Tag
            long todo1_id = db.createToDo(todo1, new long[] { tag1_id });
            long todo2_id = db.createToDo(todo2, new long[] { tag1_id });
            long todo3_id = db.createToDo(todo3, new long[] { tag1_id });

            // Inserting todos under "Watchlist" Tag
            long todo4_id = db.createToDo(todo4, new long[] { tag3_id });
            long todo5_id = db.createToDo(todo5, new long[] { tag3_id });
            long todo6_id = db.createToDo(todo6, new long[] { tag3_id });
            long todo7_id = db.createToDo(todo7, new long[] { tag3_id });

            // Inserting todos under "Important" Tag
            long todo8_id = db.createToDo(todo8, new long[] { tag2_id });
            long todo9_id = db.createToDo(todo9, new long[] { tag2_id });

            // Inserting todos under "Androidhive" Tag
            long todo10_id = db.createToDo(todo10, new long[] { tag4_id });
            long todo11_id = db.createToDo(todo11, new long[] { tag4_id });

            Log.e("Todo Count", "Todo count: " + db.getToDoCount());

            // "Post new Article" - assigning this under "Important" Tag
            // Now this will have - "Androidhive" and "Important" Tags
            db.createTodoTag(todo10_id, tag2_id);

            // Getting all tag names
            Log.d("Get Tags", "Getting All Tags");

            List<Tag> allTags = db.getAllTags();
            for (Tag tag : allTags) {
                Log.d("Tag Name", tag.getTagName());
            }

            // Getting all Todos
            Log.d("Get Todos", "Getting All ToDos");

            List<Todo> allToDos = db.getAllToDos();
            for (Todo todo : allToDos) {
                Log.d("ToDo", todo.getNote());
            }

            // Getting todos under "Watchlist" tag name
            Log.d("ToDo", "Get todos under single Tag name");

            List<Todo> tagsWatchList = db.getAllToDosByTag(tag3.getTagName());
            for (Todo todo : tagsWatchList) {
                Log.d("ToDo Watchlist", todo.getNote());
            }

            // Deleting a ToDo
            Log.d("Delete ToDo", "Deleting a Todo");
            Log.d("Tag Count", "Tag Count Before Deleting: " + db.getToDoCount());

            db.deleteToDo(todo8_id);

            Log.d("Tag Count", "Tag Count After Deleting: " + db.getToDoCount());

            // Deleting all Todos under "Shopping" tag
            Log.d("Tag Count",
                    "Tag Count Before Deleting 'Shopping' Todos: "
                            + db.getToDoCount());

            db.deleteTag(tag1, true);

            Log.d("Tag Count",
                    "Tag Count After Deleting 'Shopping' Todos: "
                            + db.getToDoCount());

            // Updating tag name
            tag3.setTagName("Movies to watch");
            db.updateTag(tag3);

            // Don't forget to close database connection
            db.closeDB();

        }
    }
}
