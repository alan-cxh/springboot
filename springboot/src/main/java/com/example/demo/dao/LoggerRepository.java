package com.example.demo.dao;

import com.example.demo.model.LoggerEntity;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alan on 2017/12/1.
 */
public interface LoggerRepository  extends JpaRepository<LoggerEntity, Long> {
}
