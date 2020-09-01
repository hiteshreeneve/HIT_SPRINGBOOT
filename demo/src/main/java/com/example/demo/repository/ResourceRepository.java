package com.example.demo.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Resources;
import com.example.demo.model.Skills;
import java.util.Set;
import java.util.List;

public interface ResourceRepository extends JpaRepository<Resources, Long>  {
	Set<Resources> findBySkilsIn(Set<Skills> skils);
		
	Set<Resources> findByExperienceLessThanAndSkilsIn(Integer exp, Set<Skills> skils);

	//Optional<Resources> findByResourceId();
}
