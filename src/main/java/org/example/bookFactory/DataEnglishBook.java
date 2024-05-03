package org.example.bookFactory;

import org.example.excelProvider.ExcelReader;

import java.util.ArrayList;

public class DataEnglishBook {
    private static DataEnglishBook instance;
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

    public static DataEnglishBook getInstance() {
        if (instance == null) {
            instance = new DataEnglishBook();
        }
        return instance;
    }

    public DataEnglishBook() {
        this.types = ExcelReader.read("./data/Жанры художественной литературы.xlsx", 1);
        this.authors = ExcelReader.read("./data/Авторы художественной литературы.xlsx", 1);
        this.firstNames = ExcelReader.read("./data/Английская художественная литература.xlsx", 0);
        this.secondNames = ExcelReader.read("./data/Английская художественная литература.xlsx", 1);

        //textbook
        this.disciplines = ExcelReader.read("./data/Английские учебные дисциплины.xlsx", 0);
        this.levels = ExcelReader.read("./data/Уровни литературы.xlsx", 0);
        this.authors_textbook = ExcelReader.read("./data/Английские преподаватели.xlsx", 0);
        this.universitys = ExcelReader.read("./data/Список университетов.xlsx", 0);
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<String> getFirstNames() {
        return firstNames;
    }

    public ArrayList<String> getSecondNames() {
        return secondNames;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }

    public ArrayList<String> getLevels() {
        return levels;
    }

    public ArrayList<String> getAuthors_textbook() {
        return authors_textbook;
    }

    public ArrayList<String> getUniversitys() {
        return universitys;
    }
}
