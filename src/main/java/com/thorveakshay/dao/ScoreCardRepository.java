package com.thorveakshay.dao;

import com.thorveakshay.model.ScoreCard;
import org.springframework.data.repository.CrudRepository;

// USING SPRING BOOT JPA AND CRUD REPO TO COMMUNICATE WITH DATABASE

public interface ScoreCardRepository extends CrudRepository<ScoreCard, Integer> {


}
