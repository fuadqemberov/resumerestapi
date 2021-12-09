package com.company.controller;

import com.company.Entity.Nationality;
import com.company.Entity.User;


import com.company.dto.ResponseDto;
import com.company.dto.UserDto;
import com.company.service.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserRestController {

    @Autowired
    private UserServiceInter repo;


    @GetMapping("/users")
    public ResponseEntity<ResponseDto> getUsers(
            @RequestParam(name="name",required = false) String name,
            @RequestParam(name="surname",required = false) String surname
 ){

        List<User> list = repo.getAll(name,surname,null);

        List<UserDto> userDtos = new ArrayList<>();

        for(int i=0 ;i<list.size();i++){
            User u = list.get(i);
            userDtos.add(new UserDto(u));


        }


return ResponseEntity.ok(ResponseDto.of(userDtos));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id")Integer id){

        User u = repo.getById(id);
        UserDto dto = new UserDto(u);


        return ResponseEntity.ok(ResponseDto.of(dto));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id")Integer id){
    User u = repo.getById(id);
        repo.removeUserById(id);


        return ResponseEntity.ok(ResponseDto.of(new UserDto(u),"Ugurla silindi !"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDto> addUser(@RequestBody UserDto user){
       User u = new User();
        u.setName(user.getName());
        u.setSurname(user.getSurname());
        u.setPassword(user.getPassword());
        Nationality n = new Nationality(1);
        u.setNationalityId(n);
        repo.addUser(u);

        return ResponseEntity.ok(ResponseDto.of(new UserDto(u), "Successfully Added" ));
    }


}
