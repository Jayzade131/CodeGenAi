package com.main.http;

import com.main.dto.CodeReqDto;
import com.main.dto.CodeResDto;
import com.main.dto.Message;
import com.main.dto.OpenRouterRequest;
import com.main.dto.OpenRouterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class RestTemplateEngine {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.model}")
    private String model;

    @Autowired
    private RestTemplate restTemplate;


    public CodeResDto callApi(CodeReqDto codeReqDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("HTTP-Referer", "https://yourdomain.com");
        headers.set("Content-Warning", "true"); // Required for some models
        headers.set("Accept", "application/json");

        OpenRouterRequest request = new OpenRouterRequest(
                List.of(new Message("user",
                        codeReqDto.getPrompt())),
                model
        );

        HttpEntity<OpenRouterRequest> requestEntity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<OpenRouterResponse> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    requestEntity,
                    OpenRouterResponse.class);
            return CodeResDto.builder().status("success").output(
                    response.getBody().getChoices().get(0).getMessage().getContent()).localDateTime(LocalDateTime.now()).build();


        } catch (RestClientException e) {
            throw new RuntimeException("Failed to get response from DeepSeek-R1-Zero", e);
        }
    }


}
