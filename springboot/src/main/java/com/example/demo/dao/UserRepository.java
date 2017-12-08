package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alan on 2017/11/29.
 */
//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过姓名查询
     * 采用抽象函数名执行sql数据
     * @param s
     * @return
     */
    public User getByUsername(String s);

    /**
     * 通过姓名查询
     * 采用注解方式执行sql数据 ， nativeQuery=true ,表示除了select查询外，还可以做增删改的sql操作
     * @param s
     * @return
     */
    @Query(value="select * from t_user where username=?1", nativeQuery = true)
    public User getByUsername1(String s);


}
