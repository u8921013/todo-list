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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        String oldData=Optional.ofNullable(request.getSession().getAttribute("OLD_DATA"))
                .map(o->(String)o).orElseGet(()->"裡面是空的");
        System.out.println("oldData="+oldData);
        return "index";
    }

    @GetMapping("/setSessionData")
    public String setSessionData(HttpServletRequest request){
        String newData="password";
        request.getSession().setAttribute("OLD_DATA",newData);
        System.out.println("newData="+newData);
        return "index";
    }

    @GetMapping("/index2")
    public String index2(HttpServletRequest request){
        String strReferer=request.getHeader("Referer");
        System.out.println("Referer="+strReferer);

        return "index";
    }

}
