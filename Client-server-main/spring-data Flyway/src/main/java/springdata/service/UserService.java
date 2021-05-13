package kz.reself.springdata.service;

import kz.reself.springdata.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void create(User user);
    Page<User> getAll();
    List<User> getAllUserList();
    List<User> getUsersByName(String name);
    User getById(Long id);
    void update(Long id, User user);
    void updateName(Long id, String name);
    void delete(Long id);
}
