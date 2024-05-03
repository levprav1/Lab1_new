package org.example.dataManipulation;

import org.example.bookFactory.BookFactory;
import org.example.bookFactory.EnglishBookFactory;
import org.example.bookFactory.RussianBookFactory;
import org.example.bookshelf.Bookable;
import org.example.dataManipulation.Bookshelf;
import org.example.dataManipulation.UserRegistry;
import org.example.userFactory.StudentFactory;
import org.example.userFactory.TutorFactory;
import org.example.users.Student;
import org.example.users.User;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Random;

public class DataManipulation {
    private final Random random = new Random();
    private Bookshelf bookshelf;
    private UserRegistry userRegistry;

    public DataManipulation() {
    }
    public void generateUsers(int count){
        UserRegistry userRegistry = new UserRegistry();
        for (int i = 0; i < count; i++) {
            if(random.nextBoolean()){
                StudentFactory factoryStudent = new StudentFactory();
                User user = factoryStudent.createUser();
                if(userRegistry.hasUser(user)) i--;
                else userRegistry.addUser(user);
            }else{
                TutorFactory factoryStudent = new TutorFactory();
                User user = factoryStudent.createUser();
                if(userRegistry.hasUser(user)) i--;
                else userRegistry.addUser(user);
            }
        }
        this.userRegistry = userRegistry;
    }
    public void generateBookshelf(){
        if (bookshelf == null) {
            Bookshelf bookshelf = new Bookshelf();
            BookFactory factory;
            do{
                for (int i = 0; i < 50; i++) {
                    switch (random.nextInt(4)) {
                        case 0: {factory = new RussianBookFactory(); bookshelf.addBook(factory.createFiction());} break;
                        case 1: {factory = new RussianBookFactory(); bookshelf.addBook(factory.createTextBook());} break;
                        case 2: {factory = new EnglishBookFactory(); bookshelf.addBook(factory.createFiction());} break;
                        case 3: {factory = new EnglishBookFactory(); bookshelf.addBook(factory.createTextBook());} break;
                    }
                }
        }while (bookshelf.sizeFiction()<50||bookshelf.sizeEnglishFiction()<15||bookshelf.sizeRussianFiction()<20||bookshelf.sizeTextBook()<50||bookshelf.sizeRussianTextBook()<20||bookshelf.sizeEnglishTextBook()<15);

        this.bookshelf = bookshelf;
        }
    }

    public void generateBook2Users(){
        for(User user : userRegistry.getUsers()){
            for (int j = 0; j <= (random.nextInt(8)+3); j++) {
                Bookable book = random.nextInt(2) == 0? bookshelf.getBook(random.nextInt(bookshelf.size())) : bookshelf.getRandomBookDepartment(user.getDepartment());
                if (user.hasBook(book)) {
                    --j;
                } else {
                    user.addBook(book);
                }
            }
        }
    }
    public DefaultMutableTreeNode addInfo2GUI(){
        return userRegistry.addInfo2GUI();
    }
}
