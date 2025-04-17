package com.main.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class AppResDto {


    private String message;
    private Object data;
    private String status;
    private int statusCode;


    public static AppResDto ok() {
        return ok(null);
    }

    public static AppResDto ok(Object data) {
        AppResDto AppResDto = new AppResDto();
        AppResDto.setMessage("success");
        AppResDto.setData(data);
        AppResDto.setStatus(HttpStatus.OK.getReasonPhrase());
        AppResDto.setStatusCode(HttpStatus.OK.value());
        return AppResDto;
    }

    public static AppResDto badRequest(String message) {
        AppResDto AppResDto = new AppResDto();
        AppResDto.setMessage(message);
        AppResDto.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        AppResDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return AppResDto;
    }


    public static AppResDto internalServerError(String message) {
        AppResDto AppResDto = new AppResDto();
        AppResDto.setMessage(message);
        AppResDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        AppResDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return AppResDto;
    }

    public static AppResDto customStatus(String message, HttpStatus status) {
        AppResDto AppResDto = new AppResDto();
        AppResDto.setMessage(message);
        AppResDto.setStatus(status.getReasonPhrase());
        AppResDto.setStatusCode(status.value());
        return AppResDto;
    }
}


