package kz.reself.springdata.repository;

import kz.reself.springdata.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByEnabledTrue();
    Page<User> findAllByEnabledTrue(Pageable pageable);

    //select * from user where name=?
    List<User> findByName(String name);

    //select * from user where name=? and age >= ?
    List<User> findByNameAndAgeGreaterThanEqual(String name, Integer age);

//    @Query(value = "select u from User u where u.name=:name and u.age>=:age")
//    List<User> findByNameGreaterThan(@Param("name") String name, @Param("age") Integer age);
//    @Query(value = "select u from User u where u.name=?1 and u.age>=?2")
//    List<User> findByNameGreaterThan(String name, Integer age);
    @Query(value = "select * from users u where u.name=?1 and u.age>=?2", nativeQuery = true)
    List<User> findByNameGreaterThan(String name, Integer age);

}
