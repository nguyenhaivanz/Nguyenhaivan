package com.example.md4.repository;

import com.example.md4.model.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ICoach extends CrudRepository<Coach, Long> {
}
