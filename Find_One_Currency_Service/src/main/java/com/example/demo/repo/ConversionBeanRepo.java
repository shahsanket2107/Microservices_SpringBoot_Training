package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.ConversionBean;

@Repository
public interface ConversionBeanRepo extends JpaRepository<ConversionBean, Integer> {

	@Query("select o from com.example.demo.pojo.ConversionBean o where o.valueTo=:valueTo and o.valueFrom=:valueFrom")
	Optional<ConversionBean> findByValueToAndValueFrom(@Param("valueTo") String valueTo,
			@Param("valueFrom") String valueFrom);

}

