package grzechu16.todolistm;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gregory on 2017-08-19.
 */

public class ToDoAdapter extends ArrayAdapter<ToDoTask> {


    ArrayList<ToDoTask> objects;
    Context context;
    int resource;

    public ToDoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<ToDoTask> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = convertView;
        ToDoHolder toDoHolder = null;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.row, parent, false);

            toDoHolder = new ToDoHolder();
            toDoHolder.rowTitle = (TextView) view.findViewById(R.id.rowTitle);
            toDoHolder.rowDesc = (TextView) view.findViewById(R.id.rowDesc);
            toDoHolder.rowDate = (TextView) view.findViewById(R.id.rowDate);
            toDoHolder.rowIsDone = (CheckBox) view.findViewById(R.id.rowCheckBoxDone);
            toDoHolder.rowIsDone.setTag(view);
            toDoHolder.rowIsDone.setOnCheckedChangeListener(checkBoxListener);

            view.setTag(toDoHolder);

        } else {
            toDoHolder = (ToDoHolder) view.getTag();
        }

        ToDoTask object = objects.get(position);
        toDoHolder.rowTitle.setText(object.getTitle());
        toDoHolder.rowDesc.setText(object.getDescription());
        toDoHolder.rowDate.setText(object.getDate());
        toDoHolder.rowIsDone.setChecked(object.getDone());

        return view;
    }

    static class ToDoHolder {
        TextView rowTitle;
        TextView rowDesc;
        TextView rowDate;
        CheckBox rowIsDone;
    }

    CompoundButton.OnCheckedChangeListener checkBoxListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            View view = (View) compoundButton.getTag();
            if (checked) {
                view.setBackgroundColor(Color.parseColor("#8FE370"));
            } else
                view.setBackgroundColor(Color.WHITE);
        }
    };

}
