package lej.modern.room_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lej.modern.room_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        //liveData를 사용하기 위해 if not 관찰해도 refresh가 되지않음
        binding.lifecycleOwner = this

        val viewModel: MainViewModel by viewModels()
        binding.mainViewModel = viewModel

//        viewModel.getAll().observe(this, Observer { todos ->
//            result_textview.text = todos.toString()
//        })

//        add_btn.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(Todo(todo_edit.text.toString()))
//            }
//
//        }


    }
}