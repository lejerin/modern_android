package lej.modern.room_java;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    AppDatabase db;
    public LiveData<List<Todo>> todos;
    public String newTodo;


    public MainViewModel(@NonNull Application application) {
        super(application);

        db = Room.databaseBuilder(application, AppDatabase.class,"todo-db")
                .build();
        todos = getAll();
    }


    public LiveData<List<Todo>> getAll(){
        return db.todoDao().getALL();
    }

    public void insert(String todo){
        new InsertAsyncTask(db.todoDao())
                .execute(new Todo(todo));
    }

    private static class InsertAsyncTask extends AsyncTask<Todo, Void, Void> {
        private TodoDao mTodoDao;

        public InsertAsyncTask(TodoDao todoDao) {this.mTodoDao = todoDao;}

        @Override
        protected Void doInBackground(Todo... todos) {
            mTodoDao.insert(todos[0]);
            return null;
        }
    }
}
