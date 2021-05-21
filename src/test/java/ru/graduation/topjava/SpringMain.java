package ru.graduation.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graduation.topjava.model.Dish;
import ru.graduation.topjava.web.dish.AdminDishUIController;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "spring/spring-db.xml", "spring/spring-app.xml", "spring/spring-mvc.xml")) {
//            System.out.println("\n----------------------------------------------");
//            System.out.println("Bean definition names: ");
//            Arrays.stream(appCtx.getBeanDefinitionNames()).forEach(System.out::println);
//            System.out.println("----------------------------------------------\n");

//            AdminDishUIController adminDishUIController = appCtx.getBean(AdminDishUIController.class);
//            List<Dish>  dishes = adminDishUIController.getLastMenu(8);

//            dishes.forEach(System.out::println);

//            adminDishController.createOrUpdate(new Dish(null, "test1", 200, LocalDate.now()), 8);
//            adminDishController.createOrUpdate(new Dish(null, "test2", 250, LocalDate.now()), 8);
//            dishes = adminDishUIController.getLastMenu(8);
//            dishes.forEach(System.out::println);

            /*VoteRestController voteRestController = appCtx.getBean(VoteRestController.class);
            voteRestController.createOrUpdate(7);
            voteRestController.createOrUpdate(6);

            List<Vote> votes = voteRestController.getToday();
            votes.forEach(System.out::println);*/

            /*DishRestController dishRestController = appCtx.getBean(DishRestController.class);
            List<Dish> dishList = dishRestController.getTodayMenu(7);
            dishList.forEach(System.out::println);*/

            /*UserRestController userController = appCtx.getBean(UserRestController.class);
            List<User> userList = userController.getAll();
            userList.forEach(System.out::println);*/

        }

//        System.out.println(LocalDate.now());
    }
}
