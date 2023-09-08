package com.mykettlebellproject.ragnarokproject;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import com.mykettlebellproject.ragnarokproject.UserController;

//import org.springframework.data.jpa.repository.JpaRepository;


@Controller
public class web_faceController {
        
        //UserRepository injector - must be initialized before action (before... return"index.hmtl").   
        @Autowired
        private final UserRepository userRepository;

        public web_faceController(UserRepository userRepository) {
        this.userRepository = userRepository;
        }

    @GetMapping("/ragnarok")
    public String web_face() {

        return "index.html";
}

        //method for successful login and redirection to next page (must be declared first - retur html. page is only fake)
    @GetMapping("/uspesnePrihlaseni")
            public String success() {
            return "index_user.html";
            }

        //method for unsuccessful login and redirection to another page (must be declared first - retur html. page is only fake)
    @GetMapping("/neuspesnePrihlaseni")
            public String failed() {
            return "register.html";
            }

    //add new users
    /*private void addUser() {
        User user1 = new User();
        user1.setUsername("Matej");
        user1.setPassword("Pella");
        userRepository.save(user1);
        //if want next user, create by pattern (up)
    }
    @PostMapping("/register")
    public String register(String username, String password) {
        addUser();
        return "redirect:/login";
    }
*/
    /**
     * @param username
     * @param password
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Ověření uživatele pomocí UserRepository
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Přihlášení úspěšné
            return "redirect:/uspesnePrihlaseni";
        } else {
            // Přihlášení selhalo
            return "redirect:/neuspesnePrihlaseni";
    }

}
}





/*
 * use Spring Data JPA for working with database, and style website by CSS, javascript and bootstrap
 * (bootstrap mainly)!
 */