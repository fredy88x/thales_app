package com.thales.app.infraestructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

  @GetMapping("/{path:^(?!api|static|js|css|img).*$}")
  public String redirect() {
    return "forward:/index.html";
  }
}
