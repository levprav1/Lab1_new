package org.example.userFactory;
import org.example.excelProvider.ExcelReader;
import org.example.users.Tutor;
import org.example.users.User;

import java.util.ArrayList;
import java.util.Random;

public class TutorFactory implements UserFactory {
    private final ArrayList<String> maleFirstNames;
    private final ArrayList<String> femaleFirstNames;
    private final ArrayList<String> maleLastNames;
    private final ArrayList<String> femaleLastNames;
    private final ArrayList<String> maleFatherNames;
    private final ArrayList<String> femaleFatherNames;
    private final ArrayList<String> maleDepartments;
    private final ArrayList<String> femaleDepartments;

    private DataTutor dataTutor;
    private final Random random = new Random();
    public TutorFactory() {
        dataTutor = DataTutor.getInstance();
        maleFirstNames = dataTutor.getMaleFirstNames();
        femaleFirstNames = dataTutor.getFemaleFirstNames();
        maleLastNames = dataTutor.getMaleLastNames();
        femaleLastNames = dataTutor.getFemaleLastNames();
        maleFatherNames = dataTutor.getMaleFatherNames();
        femaleFatherNames = dataTutor.getFemaleFatherNames();
        maleDepartments = dataTutor.getMaleDepartments();
        femaleDepartments = dataTutor.getFemaleDepartments();
    }


    @Override
    public User createUser() {
        int gender = random.nextInt(2);
        var firstNames = gender == 0 ? maleFirstNames : femaleFirstNames;
        var lastNames = gender == 0 ? maleLastNames : femaleLastNames;
        var departments = gender == 0 ? maleDepartments : femaleDepartments;
        var fatherNames = gender == 0 ? maleFatherNames : femaleFatherNames;

        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var lastName = lastNames.get(random.nextInt(lastNames.size()));
        var fatherName = fatherNames.get(random.nextInt(fatherNames.size()));
        var department = departments.get(lastNames.indexOf(lastName));




        return new Tutor(firstName, lastName, fatherName,department, new ArrayList<>());
    }
}
