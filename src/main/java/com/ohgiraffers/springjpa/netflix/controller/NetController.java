package com.ohgiraffers.springjpa.netflix.controller;

import com.ohgiraffers.springjpa.netflix.common.Pagenation;
import com.ohgiraffers.springjpa.netflix.common.PagingButton;
import com.ohgiraffers.springjpa.netflix.dto.CategoryDTO;
import com.ohgiraffers.springjpa.netflix.dto.ContentsDTO;
import com.ohgiraffers.springjpa.netflix.service.NetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/net")
public class NetController {

    private NetService netService;

    public NetController(NetService netService){
        this.netService = netService;
    }

    @GetMapping("/list")
    public String findAllContents(Model model, @PageableDefault Pageable pageable){
        Page<ContentsDTO> conList = netService.findAllContents(pageable);
        PagingButton paging = Pagenation.getPagingButtonInfo(conList);

        model.addAttribute("conList", conList);
        model.addAttribute("paging", paging);

        return "net/list";
    }

    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){
        return netService.findAllCategory();
    }

    @GetMapping("/search")
    public void searchPage(){}

    @PostMapping("/search")
    public String findByCode(Model model, int conCode){
        ContentsDTO contents = netService.findConById(conCode);
        model.addAttribute("con", contents);
        return "/net/searchResult";
    }

    @GetMapping("/regist")
    public void registPage(){}

    @PostMapping("/regist")
    public String registContents(ContentsDTO contentsDTO){
        netService.registCon(contentsDTO);
        return "redirect:/net/list";
    }
    @GetMapping("/modify")
    public void modifyPage(){}

    @PostMapping("/modify")
    public String modifyContents(ContentsDTO contentsDTO){
        netService.modifyCon(contentsDTO);
        return "redirect:/net/list";
    }

    @GetMapping("/delete")
    public void deletePage(){}

    @PostMapping("/delete")
    public String deleteContents(int conCode){
        netService.deleteCon(conCode);
        return "redirect:/net/list";
    }

    @GetMapping("/query")
    public void ratingQuery(){}

    @GetMapping("/rating")
    public String findByRating(Model model, @RequestParam Integer rating){
        List<ContentsDTO> conList = netService.findByRating(rating);

        model.addAttribute("conList", conList);

        return "/net/queryResult";
    }
}
