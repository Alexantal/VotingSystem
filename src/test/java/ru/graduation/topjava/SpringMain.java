package ru.graduation.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.graduation.topjava.model.User;
import ru.graduation.topjava.web.UserRestController;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-db.xml", "spring/spring-app.xml", "spring/spring-mvc.xml")) {
//        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/inmemory.xml")) {
            System.out.println("\n----------------------------------------------");
            System.out.println("Bean definition names: ");
            Arrays.stream(appCtx.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("----------------------------------------------\n");

            UserRestController userController = appCtx.getBean(UserRestController.class);
            List<User> userList = userController.getAll();
            userList.forEach(System.out::println);

        }
    }
}
