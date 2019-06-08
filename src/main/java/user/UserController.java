package user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.model.User;
import user.model.UserDao;

import java.util.*;
/*
   操作相关注解 @PostMapping, @GetMapping, @PutMapping, Deletemapping
   参数相关注解 @RequestBody, @PathVariable
*/
@RestController //Controller本身也是一个 Component
public class UserController {

    // 依赖于 UserMockDao 需要注入UserMockDao的实例
    private UserDao userDao;

    // 使用构造函数注入
    UserController(UserDao userDao){
        this.userDao = userDao;
        System.out.println("创建 UserController");
    }

    @GetMapping("/users")
    List<User> listUser(){
        return userDao.getAll();
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
        if(userDao.contains(name)){
            return new ResponseEntity<>(userDao.get(name),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User>  AddUser(@RequestBody User user) {
        userDao.put(user);
        return new ResponseEntity<>(userDao.get(user.getName()),HttpStatus.CREATED);
    }



    @PutMapping("/users/{name}")
    public ResponseEntity<User> UpdateUser(@PathVariable("name") String name ,@RequestBody User user) {
        if(userDao.contains(name)){
            User updateUser = userDao.get(name);
            updateUser.setAge(user.getAge());
            return new ResponseEntity<>(userDao.get(name),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{name}")
    public ResponseEntity<User> DelUserByName(@PathVariable("name") String name){
        if(userDao.contains(name)){
            userDao.delete(name);
            return new ResponseEntity<>(userDao.get(name),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}