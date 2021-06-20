package de.romycomer.bookregal;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import de.romycomer.bookregal.DB.AppDatabase;
import de.romycomer.bookregal.DB.Book;
import de.romycomer.bookregal.DB.BookDao;

public class BookRepository {

    BookDao bookDao;

    BookRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        bookDao = db.bookDao();
    }
    LiveData<List<Book>> getBook(){
        return bookDao.getAllBooks();
    }
}
