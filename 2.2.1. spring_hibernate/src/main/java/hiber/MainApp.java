package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

      User user1 = new User("Илья", "Сорокин", "soroka90@mail.ru");
      User user2 = new User("Кирилл", "Капризов", "kapriz@mail.ru");
      User user3 = new User("Илья", "Ковальчук", "koval17@mail.ru");

      Car car1 = new Car("Renault", 10);
      Car car2 = new Car("Kia", 15);
      Car car3 = new Car("BMW", 8);

      user1.setUsersCar(car1);
      user2.setUsersCar(car2);
      user3.setUsersCar(car3);

        UserService userService = context.getBean(UserService.class);


        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        List<User> users = userService.listUsers();
        System.out.println(users);

        System.out.println("Владелец авто Renault 10: " + userService.getUserByCar("Renault", 10));


//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

        context.close();
    }
}
