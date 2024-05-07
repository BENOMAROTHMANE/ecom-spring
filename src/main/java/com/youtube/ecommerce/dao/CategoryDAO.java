package com.youtube.ecommerce.dao;

import com.youtube.ecommerce.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Integer> {
}
