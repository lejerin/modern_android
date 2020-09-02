package lej.modern.room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviderKt;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    private ViewModelProvider.AndroidViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.todo_edit);
        textView = findViewById(R.id.result_textview);

        if(viewModelFactory == null){
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        }
        MainViewModel viewModel =  new ViewModelProvider(this,viewModelFactory).get(MainViewModel.class);


        //UI 갱신
        viewModel.getAll().observe(this, todos -> {
            textView.setText(todos.toString());
        });


        //버튼 클릭시 DB에 INSERT
        findViewById(R.id.add_btn).setOnClickListener(v -> {
            viewModel.insert(new Todo(editText.getText().toString()));
        });

    }




}