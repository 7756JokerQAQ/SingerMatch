package com.yupi.yupao.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/im")
@CrossOrigin(origins = {"http://localhost:8080/api"},allowCredentials = "true")
public class ImController {

}
