package com.thaohm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thaohm on 7/26/16.
 */
@RestController
public class AnswerController {
    @RequestMapping("/answer/{answerId}")
    public ResponseEntity<String> getAnswer() {
        return new ResponseEntity<String>("Don't Panic!", HttpStatus.OK);
    }
}
