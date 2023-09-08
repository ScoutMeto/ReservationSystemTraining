package com.mykettlebellproject.ragnarokproject;

//import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import com.mykettlebellproject.ragnarokproject.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.data.jpa.repository.JpaRepository;



@Controller
public class web_faceController {
            
    @GetMapping("/ragnarok")
    public String web_face() {

        return "index.html";
}

//tato metoda je možná zbytečná - přidána navíc. Má provést nejdříve získání username a pass, při prvním načtení stránky, aby backendová logika neházela chybu
@PostMapping("/process-getting username, password")
    public String saveUP(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "redirect:/login";
    }


@PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // name and password verification
    
        final UserRepository userRepository;  //nejsem si jistý, jestli to tady není zbytečné

        User user = UserRepository.findByUsername(); //smazáno "username" z konstruktoru
        
        if (user != null && user.getPassword().equals(password)) {
            // login successful
            return "redirect:/index_user"; //redirect to dashboard (zde zadej URL - pozor, v rámci app musí existovat controller nebo endpoint, který je mapován na danou URL a je zajištěna obsluha této stránky)
        } else {
            // login failed
            return "redirect:/login?error";
            
            /*
            ...
    } else {
        // Neúspěšné přihlášení
        model.addAttribute("error", "Nesprávné uživatelské jméno nebo heslo.");
        return "login.html";
    }
}

Následně se uživatel přesměruje zpět na stránku login.html, kde může být tato chybová zpráva zobrazena pro 
uživatele. Ve vašem HTML šablonovacím souboru (login.html) můžete potom přidat kód pro zobrazení chybové zprávy v 
případě, že existuje v modelu.
        <!-- login.html -->
        <!-- ... -->
        <div th:if="${error}" class="error-message">
            <span th:text="${error}"></span>
        </div>
        <!-- ... -->    

V tomto příkladu je vytvořen <div> s třídou error-message, který se zobrazí pouze pokud existuje chybová 
zpráva v modelu. Chybová zpráva je vložena do <span> pomocí atributu th:text="${error}".
    */
        }
    }
}



/*
 * use Spring Data JPA for working with database, and style website by CSS, javascript and bootstrap
 * (bootstrap mainly)!
 */