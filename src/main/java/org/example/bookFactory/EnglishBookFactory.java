package org.example.bookFactory;

import org.example.bookshelf.books.EnglishFiction;
import org.example.bookshelf.books.EnglishTextBook;
import org.example.bookshelf.books.IFiction;
import org.example.bookshelf.books.ITextBook;

import java.util.ArrayList;
import java.util.Random;

public class EnglishBookFactory implements BookFactory {
    private final Random random = new Random();
    private DataEnglishBook dataStoreFromExcel;
    //Fiction
    private final ArrayList<String> types;
    private final ArrayList<String> firstNames;
    private final ArrayList<String> secondNames;
    private final ArrayList<String> authors;

    //textbook
    private final ArrayList<String> disciplines;
    private final ArrayList<String> levels;
    private final ArrayList<String> authors_textbook;
    private final ArrayList<String> universitys;

    public EnglishBookFactory() {
        dataStoreFromExcel = DataEnglishBook.getInstance();
        //Fiction
        types = dataStoreFromExcel.getTypes();
        authors = dataStoreFromExcel.getAuthors();
        firstNames = dataStoreFromExcel.getFirstNames();
        secondNames = dataStoreFromExcel.getSecondNames();

        //textbook
        disciplines = dataStoreFromExcel.getDisciplines();
        levels = dataStoreFromExcel.getLevels();
        authors_textbook = dataStoreFromExcel.getAuthors_textbook();
        universitys = dataStoreFromExcel.getUniversitys();
    }


    @Override
    public ITextBook createTextBook() {
        var discipline = disciplines.get(random.nextInt(disciplines.size()));
        var author = authors_textbook.get(random.nextInt(authors_textbook.size()));
        var level = levels.get(random.nextInt(levels.size()));
        var university = universitys.get(random.nextInt(universitys.size()));

        var title = discipline + " " +level + " " + university +", " + author;
        return new EnglishTextBook(title,discipline, level, author,university);
    }

    @Override
    public IFiction createFiction() {

        var type = types.get(random.nextInt(types.size()));
        var author = authors.get(random.nextInt(authors.size()));
        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var secondName = secondNames.get(random.nextInt(secondNames.size()));
        var name = firstName + " " + secondName;

        var title = type + " \"" + name + "\", " + author;

        return new EnglishFiction(title, type, name, author);
    }
}
