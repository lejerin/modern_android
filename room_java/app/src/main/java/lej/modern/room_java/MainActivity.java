package lej.modern.room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
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

import lej.modern.room_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ViewModelProvider.AndroidViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        if(viewModelFactory == null){
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        }
        MainViewModel viewModel =  new ViewModelProvider(this,viewModelFactory).get(MainViewModel.class);

        binding.setViewModel(viewModel);

        //data binding 사용
//        //UI 갱신
//        viewModel.getAll().observe(this, todos -> {
//            binding.resultTextview.setText(todos.toString());
//        });


//        //버튼 클릭시 DB에 INSERT
//        findViewById(R.id.add_btn).setOnClickListener(v -> {
//            viewModel.insert(new Todo(binding.todoEdit.getText().toString()));
//        });

    }




}