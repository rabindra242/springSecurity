package com.example.reactspringboot.utill;

import com.example.reactspringboot.domain.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import static org.apache.logging.log4j.util.Strings.EMPTY;


import java.time.LocalDateTime;
import java.util.Map;

public class RequestUtill {

    public static Response getResponse(HttpServletRequest request, Map<?,?> data, String message, HttpStatus status){
        return new Response(LocalDateTime.now().toString(),status.value(),request.getRequestURI(),HttpStatus.valueOf(status.value()),message, EMPTY,data);
    }
}
