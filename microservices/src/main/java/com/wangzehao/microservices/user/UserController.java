package com.wangzehao.microservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceDAO daoService;

    @GetMapping("/users")
    public List<User> retrieveAllUser(){
        return daoService.finaAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveOneUser(@PathVariable Integer id){
        User user = daoService.findOne(id);
        if(user==null){
            throw new UserNotFountException("id:"+id);
        }

        // Hatoas
        EntityModel<User> entity = new EntityModel<User>(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
        entity.add(linkTo.withRel("all-users"));

        // Dynamic Filtering
//        SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.filterOutAllExcept("name");
//        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter",user);
//        MappingJacksonValue mapping = new MappingJacksonValue(user);
//        mapping.setFilters(filters);
//        return mapping;

        return entity;
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = daoService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        User user = daoService.deleteOne(id);
        if(user==null){
            throw new UserNotFountException("id:"+id);
        }
    }
}
