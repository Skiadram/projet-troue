package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    /*
    Another method with @RequestParam (replace get All method) -> I didn't create this features for the other controllers
    in order to keep them very simple
     */
    @GetMapping("/users")
    public Iterable<UserEntity> getAllUsers(){
        return this.userService.getAllUser();
    }
/*

    @GetMapping("/user")
    public Iterable<UserEntity> getAllAdresseParam(@RequestParam(value = "id_adresse", required = false) List<String> id_adresse,
                                                   @RequestParam(value = "libelle", required = false)List<String> libelle,
                                                   @RequestParam(value = "id_concessionaire", required = false)List<String> id_concessionaire){
        return this.userService.getAlluserParam(id_adresse, libelle, id_concessionaire);
    }

    @GetMapping("/user/{id}")
    public Optional<UserEntity>getAdresseById(@PathVariable("id") int id){
    return this.userService.getUserById(id);
    }

    @PostMapping("/user")
    public UserEntity addAdresseById(@RequestBody UserEntity userEntity) {
        return this.userService.addUser(userEntity);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteAdresseById(@PathVariable("id") int id) throws RessourceNotFoundException {
        if(this.userService.getUserById(id).get().equals(null))
            throw new RessourceNotFoundException("Not found any address to this Id ::" + id);
        userService.deleteUserById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/user/{id}")
    public UserEntity updateAdresseById(@PathVariable("id") int id, @RequestBody UserEntity userEntity) throws RessourceNotFoundException {
        UserEntity user = userService.getUserById(id).get();
        if(user.equals(null))
            throw new RessourceNotFoundException("Not found any address to this Id ::" + id);

        user.setId_user(userEntity.getId_user());
        user.setNom(userEntity.getNom());
        user.setPassword(user.getPassword());
        userService.addUser(user);
        return user;
    }
*/


}
