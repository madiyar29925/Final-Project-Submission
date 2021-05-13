package kz.reself.springdata.service.impl;

import kz.reself.springdata.entity.User;
import kz.reself.springdata.repository.UserRepository;
import kz.reself.springdata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

//    private static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * asdjhhasjd;f
     * asdasjdlaksd
     * asdk;l
     *
     * @param user
     */
    @Override
    public void create(User user) {
//        User userNew = User.builder()
//                .name(user.getName())
//                .age(user.getAge())
//                .enabled(user.getEnabled()).build();
        log.debug("saving new user details: " + user);

        userRepository.save(user);
    }

    @Override
    public Page<User> getAll() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC,"name", "age"));
//        return userRepository.findAll(pageable);
        return userRepository.findAllByEnabledTrue(pageable);
    }

    @Override
    public List<User> getAllUserList() {

        return userRepository.findAllByEnabledTrue();
    }

    @Override
    public List<User> getUsersByName(String name) {
//        return userRepository.findByNameAndAgeGreaterThanEqual(name, 40);
        return userRepository.findByNameGreaterThan(name, 40);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public void update(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User dbUser = userOptional.get();



            dbUser.setName(user.getName() != null ? user.getName() : dbUser.getName());
            dbUser.setAge(user.getAge());

            userRepository.save(dbUser);
        }
    }

    @Override
    public void updateName(Long id, String name) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User dbUser = userOptional.get();
            dbUser.setName(name);

            userRepository.save(dbUser);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User dbUser = userOptional.get();
            dbUser.setEnabled(false);

            userRepository.save(dbUser);
        }

//        userRepository.deleteById(id);
    }
}
