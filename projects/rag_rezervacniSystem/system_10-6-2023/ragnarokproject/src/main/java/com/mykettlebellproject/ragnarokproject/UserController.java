//class for methods of interaction between user and web/database

package com.mykettlebellproject.ragnarokproject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class UserController {
    

        @PostMapping("/login")
    public int numberData(@RequestParam())
    public String wordData(@RequestParam("username") String username, @RequestParam("password") String password) {



}
}
