package de.romycomer.bookregal;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import de.romycomer.bookregal.DB.Book;

public class BookViewmodel extends AndroidViewModel {

    BookRepository repository;
    LiveData<List<Book>> bookList;

    public BookViewmodel(Application application){
        super(application);
        repository = new BookRepository(application);
        bookList = repository.getBook();
    }
    LiveData<List<Book>> getAllBooks(){
        return bookList;
    }
}
