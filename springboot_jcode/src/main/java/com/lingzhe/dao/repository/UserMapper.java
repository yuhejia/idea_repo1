package com.lingzhe.dao.repository;

import com.lingzhe.repository.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserMapper extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {

    /*public List<User> findAll();*/

    public void deleteAllBy(Integer id);

    public void saveOne(User user);
}
