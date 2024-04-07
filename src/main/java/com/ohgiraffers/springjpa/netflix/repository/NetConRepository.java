package com.ohgiraffers.springjpa.netflix.repository;

import com.ohgiraffers.springjpa.netflix.dto.ContentsDTO;
import com.ohgiraffers.springjpa.netflix.entity.Contents;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NetConRepository extends JpaRepository<Contents, Integer> {
    List<Contents> findByRatingLessThan(Integer rating);
}
