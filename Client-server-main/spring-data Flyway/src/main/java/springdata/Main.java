package kz.reself.springdata;

import kz.reself.springdata.config.SpringConfig;
import kz.reself.springdata.controller.AddressController;
import kz.reself.springdata.controller.BookController;
import kz.reself.springdata.controller.UserController;
import kz.reself.springdata.entity.Address;
import kz.reself.springdata.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

       UserController userController = context.getBean("userController", UserController.class);
List<User> userList = userController.getAll().getContent();

       System.out.println(userList);

       AddressController addressController = context.getBean("addressController", AddressController.class);

       Address address = new Address();
        address.setCity("Almaty");
    address.setStreet("Kipchakpayev");
        address.setHouseNo("100");

       User user = new User();
       user.setName("New User");
       user.setAge(50);
        user.setId(8L);

       address.setUser(user);

        addressController.saveAddress(address);

        System.out.println("addressController.getAllAddresses() = " + addressController.getAllAddresses());


       BookController bookController = context.getBean(BookController.class);
        System.out.println("bookController.getAllPages() = " + bookController.getAllPages());
      System.out.println("bookController.getAllBooks() = " + bookController.getAllBooks());
   }
}
