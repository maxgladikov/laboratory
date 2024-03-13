package org.aston.ems.admin_service.service;

import org.aston.ems.admin_service.model.User;

import java.util.List;

public interface UserService {

    User get(String name);

    List<User> get();

    List<User> get(int page, int elementPerPage);

    void create(User user);

    void update(User user);

    void delete(String username);
}
