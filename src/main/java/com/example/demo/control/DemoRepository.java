package com.example.demo.control;

import com.example.demo.entity.Demo;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<Demo, Long> {
}
