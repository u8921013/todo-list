package net.ubn.td.todolist;

import jakarta.servlet.http.HttpServletRequest;
import net.ubn.td.todolist.dto.Todo;
import net.ubn.td.todolist.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class HtmlController {

    private final MainService mainService;

    public HtmlController(MainService mainService) {
        this.mainService = mainService;
    }


    @GetMapping("/index")
    public String index(HttpServletRequest request){
        System.out.println("index request="+request.getServletPath());

        return "index";
    }

    @GetMapping("/index2")
    public String index2(HttpServletRequest request){
        String strReferer=request.getHeader("Referer");
        System.out.println("Referer="+strReferer);
        return "index";
    }

}
