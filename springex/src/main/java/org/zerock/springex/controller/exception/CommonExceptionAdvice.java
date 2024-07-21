package org.zerock.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ResponseBody // 문자열이나 JSON 데이터를 그대로 전송할 때 사용되는 어노테이션
    @ExceptionHandler(NumberFormatException.class) // 해당 타입의 예외를 파라미터로 전달받을 수 있음
    public String exceptNumber(NumberFormatException e) {
        log.error("----------------------------------------");
        log.error(e.getMessage());

        return "NUMBER FORMAT EXCEPTION";
    }

    // 모든 예외를 처리하는 용도(디버깅용)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception e) {
        log.error("----------------------------------------");
        log.error(e.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + e.getMessage() + "</li>");

        Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }
}
