package com.ohgiraffers.springjpa.netflix.repository;

import com.ohgiraffers.springjpa.netflix.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT category_code, category_name FROM net_category ORDER BY category_code",
            nativeQuery = true)
    List<Category> findAllCategory();
}
