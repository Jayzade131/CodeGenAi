package com.main.service.impl;

import com.main.dto.CodeReqDto;
import com.main.dto.CodeResDto;
import com.main.http.RestTemplateEngine;
import com.main.service.GenerativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerativeServiceImpl implements GenerativeService {

    @Autowired
    private RestTemplateEngine restTemplateEngine;

    @Override
    public CodeResDto GenerationProcess(CodeReqDto codeReqDto) {

        return restTemplateEngine.callApi(codeReqDto);

    }
}
