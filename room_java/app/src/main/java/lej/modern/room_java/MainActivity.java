package lej.modern.room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.todo_edit);
        textView = findViewById(R.id.result_textview);

        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,"todo-db")
                .allowMainThreadQueries()
                .build();

        textView.setText(db.todoDao().getALL().toString());
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.todoDao().insert(new Todo(editText.getText().toString()));
                textView.setText(db.todoDao().getALL().toString());
            }
        });

    }
}