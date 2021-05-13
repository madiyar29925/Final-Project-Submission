package kz.reself.springdata.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.reself.springdata.entity.User;
import kz.reself.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/user")
@Api(value = "User Controller Class", description = "REST API methods to manage users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "Get list of all users", notes = "Some methods notes here")
    public Page<User> getAll() {
        System.out.println("UserController.getAll");
        return userService.getAll();
    }

    @GetMapping("/list")
    public List<User> getAllUserList() {
        System.out.println("UserController.getAll");
        return userService.getAllUserList();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public User getUserById(@PathVariable("id") Long id) {
        System.out.println("UserController.getUserById");
        System.out.println("id = " + id);
        return userService.getById(id);
    }

    @GetMapping("/byname/")
    public List<User> getUserByName(@RequestParam String name) {
        System.out.println("UserController.getUserByName");
        System.out.println("name = " + name);
        return userService.getUsersByName(name);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void addUser(@RequestBody User user) {
        System.out.println("UserController.addUser");
        System.out.println("user = " + user);
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        System.out.println("UserController.update");
        System.out.println("id = " + id);
        userService.update(id, user);
    }

    @PatchMapping("/{id}")
    public void updateName(@PathVariable Long id,
                           String newName) {
        System.out.println("UserController.updateName");
        System.out.println("id = " + id);
        System.out.println("newName = " + newName);
        userService.updateName(id, newName);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
