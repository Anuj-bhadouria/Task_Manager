package blah.blah.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, tasks);

        ListView taskListView = findViewById(R.id.taskListView);
        taskListView.setAdapter(taskAdapter);

        final EditText titleEditText = findViewById(R.id.titleEditText);
        final EditText descriptionEditText = findViewById(R.id.descriptionEditText);
        Button addTaskButton = findViewById(R.id.addTaskButton);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                Task newTask = new Task(title, description);
                tasks.add(newTask);
                taskAdapter.notifyDataSetChanged();

                titleEditText.setText("");
                descriptionEditText.setText("");
            }
        });
    }
}
