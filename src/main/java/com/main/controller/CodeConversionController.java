package com.main.controller;


import com.main.constant.UrlConstant;
import com.main.dto.AppResDto;
import com.main.dto.CodeReqDto;
import com.main.service.GenerativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstant.CODE_CONVERSION_API)
public class CodeConversionController {

    @Autowired
    private GenerativeService generativeService;

    @PostMapping(UrlConstant.CODE_GEN)
    public ResponseEntity<AppResDto> codeGen(@RequestBody CodeReqDto codeReqDto) {
        return ResponseEntity.ok(AppResDto.ok(generativeService.GenerationProcess(codeReqDto)));
    }

}
