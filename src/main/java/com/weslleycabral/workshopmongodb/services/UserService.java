package com.weslleycabral.workshopmongodb.services;import com.weslleycabral.workshopmongodb.dto.UserDTO;import com.weslleycabral.workshopmongodb.entities.Post;import com.weslleycabral.workshopmongodb.entities.User;import com.weslleycabral.workshopmongodb.repository.UserRepository;import com.weslleycabral.workshopmongodb.services.exception.ObjectNotFoundException;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;import java.util.Optional;@Servicepublic class UserService {    @Autowired    private UserRepository repository;    public List<UserDTO> findAll() {        List<User> list = repository.findAll();        List<UserDTO> listDTO = new ArrayList<>();        for (User e : list) {            listDTO.add(new UserDTO(e));        }        return listDTO;    }    public UserDTO findById(String id) {       Optional<User> user = repository.findById(id);       if (user.isPresent()) {           var userDTO = new UserDTO(user.get());           return userDTO;       } else {           throw new ObjectNotFoundException("Object not found.");       }    }    public User create(User user) {        return repository.save(user);    }    public User fromDTO(UserDTO userDTO) {        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());    }    public void delete(String id) {        if(findById(id).getId().equals(id)) {            repository.deleteById(id);        } else {            throw new ObjectNotFoundException("Object not found.");        }    }    public User update(User newUser) {        Optional<User> user = repository.findById(newUser.getId());        if (user.isPresent()) {            updateData(newUser, user);            return repository.save(newUser);        } else {            throw new ObjectNotFoundException("Object not found.");        }    }    public void updateData(User newUser, Optional<User> user) {        user.get().setName(newUser.getName());        user.get().setEmail(newUser.getEmail());    }    public List<Post> findPostsById(String id) {        var user = repository.findById(id);        List<Post> postList = user.orElseThrow(() -> new ObjectNotFoundException("This user not existing")).getPosts();        return postList;    }}