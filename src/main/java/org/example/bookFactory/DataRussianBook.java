package org.example.bookFactory;

import org.example.excelProvider.ExcelReader;

import java.util.ArrayList;

public class DataRussianBook {
    private static DataRussianBook instance;
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

    public DataRussianBook() {
        types = ExcelReader.read("./data/Жанры художественной литературы.xlsx", 0);
        authors = ExcelReader.read("./data/Авторы художественной литературы.xlsx", 0);
        firstNames = ExcelReader.read("./data/Русская художественная литература.xlsx", 0);
        prepositions = ExcelReader.read("./data/Русская художественная литература.xlsx", 1);
        secondNames = ExcelReader.read("./data/Русская художественная литература.xlsx", 2);

        //Textbook
        types_textbook = ExcelReader.read("./data/Виды учебных пособий на русском.xlsx", 0);
        disciplines = ExcelReader.read("./data/Русские учебные дисциплины.xlsx", 0);
        departments = ExcelReader.read("./data/Русские учебные дисциплины.xlsx", 1);
    }

    public static DataRussianBook getInstance() {
        if (instance == null) {
            instance = new DataRussianBook();
        }
        return instance;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<String> getFirstNames() {
        return firstNames;
    }

    public ArrayList<String> getPrepositions() {
        return prepositions;
    }

    public ArrayList<String> getSecondNames() {
        return secondNames;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public ArrayList<String> getTypes_textbook() {
        return types_textbook;
    }

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }

    public ArrayList<String> getDepartments() {
        return departments;
    }
}
