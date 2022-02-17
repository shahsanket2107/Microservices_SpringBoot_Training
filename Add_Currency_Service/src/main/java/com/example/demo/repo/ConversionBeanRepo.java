package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.ConversionBean;

public interface ConversionBeanRepo extends JpaRepository<ConversionBean, Integer> {

}
