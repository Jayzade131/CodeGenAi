package com.main.service;

import com.main.dto.CodeReqDto;
import com.main.dto.CodeResDto;

public interface GenerativeService {

     CodeResDto GenerationProcess(CodeReqDto codeReqDto);
}
