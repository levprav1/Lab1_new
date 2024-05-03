package org.example.userFactory;


import org.example.excelProvider.ExcelReader;

import java.util.ArrayList;

public class DataStudent {
    private static DataStudent instance;

    private final ArrayList<String> maleFirstNames;
    private final ArrayList<String> femaleFirstNames;
    private final ArrayList<String> maleLastNames;
    private final ArrayList<String> femaleLastNames;

    private final ArrayList<String> departments;

    public DataStudent() {
        var firstNames = ExcelReader.read("./data/Имена.xlsx", 0);
        var firstNamesGender = ExcelReader.read("./data/Имена.xlsx", 1);
        maleFirstNames = new ArrayList<String>();
        femaleFirstNames = new ArrayList<String>();

        for (int i = 0; i < firstNamesGender.size(); i++) {
            if (firstNamesGender.get(i).equals("м")) {
                maleFirstNames.add(firstNames.get(i));
            } else {
                femaleFirstNames.add(firstNames.get(i));
            }
        }

        var lastNames = ExcelReader.read("./data/Фамилии.xlsx", 0);
        var lastNamesGender = ExcelReader.read("./data/Фамилии.xlsx", 1);

        maleLastNames = new ArrayList<String>();
        femaleLastNames = new ArrayList<String>();

        for (int i = 0; i < lastNamesGender.size(); i++) {
            if (lastNamesGender.get(i).equals("м")) {
                maleLastNames.add(lastNames.get(i));
            } else {
                femaleLastNames.add(lastNames.get(i));
            }
        }


        departments = ExcelReader.read("./data/Кафедры.xlsx", 0);


    }

    public static DataStudent getInstance() {
        if (instance == null) {
            instance = new DataStudent();
        }
        return instance;
    }

    public ArrayList<String> getMaleFirstNames() {
        return maleFirstNames;
    }

    public ArrayList<String> getFemaleFirstNames() {
        return femaleFirstNames;
    }

    public ArrayList<String> getMaleLastNames() {
        return maleLastNames;
    }

    public ArrayList<String> getFemaleLastNames() {
        return femaleLastNames;
    }

    public ArrayList<String> getDepartments() {
        return departments;
    }
}
