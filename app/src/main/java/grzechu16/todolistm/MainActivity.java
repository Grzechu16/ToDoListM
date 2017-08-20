package grzechu16.todolistm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private final int requestCode = 1;
    ArrayList<ToDoTask> lista = new ArrayList<>();
    ToDoAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonAdd);
        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new ToDoAdapter(this, R.layout.row, lista);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddToDoTask.class);
                startActivityForResult(intent, requestCode);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String title, description, date;
        Boolean isDone;

        if (requestCode == 1) {
            if (null != data) {
                title = data.getStringExtra("title");
                description = data.getStringExtra("description");
                date = data.getStringExtra("date");
                isDone = data.getBooleanExtra("done", false);

                lista.add(new ToDoTask(title, description, date, isDone));
                adapter.notifyDataSetChanged();
            }
        }
    }
}
