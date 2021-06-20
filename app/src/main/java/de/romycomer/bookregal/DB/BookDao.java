package de.romycomer.bookregal.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {

    @Query("SELECT * FROM Book")
    LiveData<List<Book>> getAllBooks();

    @Insert
    void insertBook(Book... books);

    @Delete
    void deleteBook(Book... books);


}
