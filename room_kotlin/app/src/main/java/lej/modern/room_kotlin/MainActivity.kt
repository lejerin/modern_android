package lej.modern.room_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "todo-db"
        ).allowMainThreadQueries()
            .build()

        result_text.setText(db.todoDao().getAll().toString())
        add_btn.setOnClickListener {
            db.todoDao().insert(Todo(todo_edit.text.toString()))
            result_text.setText(db.todoDao().getAll().toString())

        }

    }
}