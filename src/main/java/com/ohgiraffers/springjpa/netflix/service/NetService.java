package com.ohgiraffers.springjpa.netflix.service;

import com.ohgiraffers.springjpa.netflix.dto.CategoryDTO;
import com.ohgiraffers.springjpa.netflix.dto.ContentsDTO;
import com.ohgiraffers.springjpa.netflix.entity.Category;
import com.ohgiraffers.springjpa.netflix.entity.Contents;
import com.ohgiraffers.springjpa.netflix.repository.CategoryRepository;
import com.ohgiraffers.springjpa.netflix.repository.NetConRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NetService {

    private NetConRepository conRepository;
    private CategoryRepository categoryRepository;

    private ModelMapper modelMapper;

    public NetService(NetConRepository conRepository,
                      CategoryRepository categoryRepository,
                      ModelMapper modelMapper){
        this.conRepository = conRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    //전체 조회
    public Page<ContentsDTO> findAllContents(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("conCode").descending());
        Page<Contents> conList = conRepository.findAll(pageable);
        return conList.map(con -> modelMapper.map(con, ContentsDTO.class));
    }
    //카테고리별 조회
    public Page<ContentsDTO> findByCategory(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("conCode").descending());
        Page<Contents> conList = conRepository.findAll(pageable);
        return conList.map(con -> modelMapper.map(con, ContentsDTO.class));
    }

    //카테고리 조회
    public List<CategoryDTO> findAllCategory(){
        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    //선택 조회
    public ContentsDTO findConById(int conCode){
        Contents content = conRepository.findById(conCode).orElseThrow(IllegalAccessError::new);
        return modelMapper.map(content, ContentsDTO.class);
    }

    //등록
    @Transactional
    public void registCon(ContentsDTO contents){
        conRepository.save(modelMapper.map(contents, Contents.class));
    }

    //수정
    @Transactional
    public void modifyCon(ContentsDTO contents){
        Contents foundCon = conRepository.findById(contents.getConCode()).orElseThrow(IllegalAccessError::new);

        if(contents.getConName() != ""){
            foundCon = foundCon.conName(contents.getConName()).builder();
        }
    }
    //삭제
    @Transactional
    public void deleteCon(Integer conCode){
        conRepository.deleteById(conCode);
    }

    //연령으로 조회
    public List<ContentsDTO> findByRating(Integer rating){

        List<Contents> conList = conRepository.findByRatingLessThan(rating);
        return conList.stream()
                .map(con -> modelMapper.map(con, ContentsDTO.class))
                .collect(Collectors.toList());
    }

    //
}
