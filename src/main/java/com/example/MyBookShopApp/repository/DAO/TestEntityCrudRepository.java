package com.example.MyBookShopApp.repository.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityCrudRepository extends CrudRepository<TestEntity, Long> {
}
