package grzechu16.todolistm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class AddToDoTask extends AppCompatActivity {

    private String title;
    private String description;
    private String date;
    private Boolean isDone = false;
    private Calendar calendar;
    private DatePickerDialog.OnDateSetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do_task);

        final EditText editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        final EditText editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        final TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBoxDone);
        Button buttonDate = (Button) findViewById(R.id.buttonDate);
        Button button = (Button) findViewById(R.id.buttonAddTask);


        InputMethodManager keyboard = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
        keyboard.showSoftInput(editTextTitle, InputMethodManager.SHOW_IMPLICIT);

        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                int year, month, day;
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddToDoTask.this, listener, year, month, day);
                datePickerDialog.show();


            }
        });
        listener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
                textViewDate.setText(date);
                textViewDate.requestLayout();

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", editTextTitle.getText().toString());
                intent.putExtra("description", editTextDesc.getText().toString());
                intent.putExtra("date", textViewDate.getText());
                intent.putExtra("done",isDone);
                setResult(1, intent);
                finish();
            }
        });

    }

}
