package com.Nteam.backend.hospital.controller;

import com.Nteam.backend.hospital.dto.HospitalDto;
import com.Nteam.backend.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("")
    public String init() {
        return "hello";
    }

    @GetMapping("/all") // 전체 병원 조회
    public List<HospitalDto> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/{registerNum}") // 등록번호로 개별 조회
    public HospitalDto getHospitalByRegisterNum(@PathVariable("registerNum") String registerNum) {
//        log.info("GET request received at /hospital/{}", registerNum);
        return hospitalService.getHospitalByRegisterNum(registerNum);
    }

    @GetMapping("/gu/{gu}") // 구로 조회 ex. 노원구
    public List<HospitalDto> getHospitalsByGu(@PathVariable("gu") String gu) {
        return hospitalService.getHospitalsByGu(gu);
    }

    @GetMapping("/category/{category}") // 카테고리별로 조회
    public List<HospitalDto> getHospitalsByCategory(@PathVariable("category") String category) {
        return hospitalService.getHospitalsByCategory(category);
    }

    @GetMapping("/search") // 키워드로 병원 검색
    public List<HospitalDto> findHospitalsByKeyword(@RequestParam("keyword") String keyword) {
//        log.info("GET request received at /hospital/search?keyword={}", keyword);
        return hospitalService.findHospitalsByKeyword(keyword);
    }

    @GetMapping("/nation/{nationName}") // 국가별로 조회
    public List<HospitalDto> getHospitalsByNation(@PathVariable("nationName") String nationName) {
//        log.info("GET request received at /hospital/nation/{}", nationName);
        return hospitalService.getHospitalsByNation(nationName);
    }

}
