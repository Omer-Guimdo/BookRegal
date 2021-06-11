package de.romycomer.bookregal.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "titel")
    public String titel;

    @ColumnInfo(name = "autor")
    public String autor;



    public Book(String titel, String autor){
        this.titel = titel;
        this.autor = autor;
    }
}
