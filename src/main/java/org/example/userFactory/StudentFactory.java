package org.example.userFactory;
import org.example.excelProvider.ExcelReader;
import org.example.users.Student;
import org.example.users.User;

import java.util.ArrayList;
import java.util.Random;

public class StudentFactory implements UserFactory {
    private final ArrayList<String> maleFirstNames;
    private final ArrayList<String> femaleFirstNames;
    private final ArrayList<String> maleLastNames;
    private final ArrayList<String> femaleLastNames;
    private final ArrayList<String> departments;
    private final Random random = new Random();
    private DataStudent dataStudent;

    public StudentFactory() {
        dataStudent = DataStudent.getInstance();
        maleFirstNames = dataStudent.getMaleFirstNames();
        femaleFirstNames = dataStudent.getFemaleFirstNames();
        maleLastNames = dataStudent.getMaleLastNames();
        femaleLastNames = dataStudent.getFemaleLastNames();
        departments = dataStudent.getDepartments();
    }

    @Override
    public User createUser() {
        int gender = random.nextInt(2);
        var firstNames = gender == 0 ? maleFirstNames : femaleFirstNames;
        var lastNames = gender == 0 ? maleLastNames : femaleLastNames;
        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var lastName = lastNames.get(random.nextInt(lastNames.size()));
        var department = departments.get(random.nextInt(departments.size()));


        return new Student(firstName, lastName, department, new ArrayList<>());
    }
}
