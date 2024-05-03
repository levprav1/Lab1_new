package org.example.bookFactory;

import org.example.excelProvider.ExcelReader;
import org.example.bookshelf.books.IFiction;
import org.example.bookshelf.books.ITextBook;
import org.example.bookshelf.books.RussianFiction;
import org.example.bookshelf.books.RussianTextBook;

import java.util.ArrayList;
import java.util.Random;

public class RussianBookFactory implements BookFactory {
    private final Random random = new Random();
    private DataRussianBook dataRussianBook;
    //fiction
    private final ArrayList<String> types;
    private final ArrayList<String> firstNames;
    private final ArrayList<String> prepositions;
    private final ArrayList<String> secondNames;
    private final ArrayList<String> authors;

    //textbook
    private final ArrayList<String> types_textbook;
    private final ArrayList<String> disciplines;
    private final ArrayList<String> departments;

    public RussianBookFactory() {
        dataRussianBook = DataRussianBook.getInstance();
        //Fiction
        types = dataRussianBook.getTypes();
        authors = dataRussianBook.getAuthors();
        firstNames = dataRussianBook.getFirstNames();
        prepositions = dataRussianBook.getPrepositions();
        secondNames = dataRussianBook.getSecondNames();

        //Textbook
        types_textbook = dataRussianBook.getTypes_textbook();
        disciplines = dataRussianBook.getDisciplines();
        departments = dataRussianBook.getDepartments();
    }

    @Override
    public ITextBook createTextBook() {
        var type = types_textbook.get(random.nextInt(types_textbook.size()));
        var discipline = disciplines.get(random.nextInt(disciplines.size()));
        var department = departments.get(disciplines.indexOf(discipline));
        var title = type + " \"" + discipline + "\" (каф. №" + department + ")";
        return new RussianTextBook(title, discipline,type,department);
    }

    @Override
    public IFiction createFiction() {
        var type = types.get(random.nextInt(types.size()));
        var author = authors.get(random.nextInt(authors.size()));
        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var preposition = prepositions.get(random.nextInt(prepositions.size()));
        var secondName = secondNames.get(random.nextInt(secondNames.size()));
        var name = firstName + " " + preposition + " " +secondName;

        var title = type + " \"" + name + "\", " + author;

        return new RussianFiction(title, type, name, author);
    }
}
