package net.ubn.td.todolist;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ubn.td.todolist.dto.Todo;
import net.ubn.td.todolist.service.MainService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Controller
public class HelloController {

    private final MainService mainService;

    public HelloController(MainService mainService) {
        this.mainService = mainService;
    }


//    @GetMapping("/**")
//    public ResponseEntity<String> parse(HttpServletRequest request){
//        System.out.println("request="+request.getServletPath());
//
//        return ResponseEntity.ok("Hello");
//    }
//    @GetMapping("/{path1}/{path2}/{path3}/{path4}")
//    public ResponseEntity<String> aaa(@PathVariable("path1") String path1,@PathVariable("path2") String path2,@PathVariable("path3") String path3,@PathVariable("path4") String path4 ){
//        System.out.println("path1="+path1);
//        System.out.println("path2="+path2);
//        System.out.println("path3="+path3);
//        System.out.println("path4="+path4);
//        return ResponseEntity.ok("Hello");
//    }


    @PostMapping("/setCookie")
    public ResponseEntity<ApiReturn> setCookie(@RequestBody CookieData cookieData,HttpServletRequest request, HttpServletResponse response){

        ResponseCookie cookie=ResponseCookie.from(cookieData.name(),cookieData.value())
                .httpOnly(true)
                .secure(true)
                .domain("homeworld.top")
                .sameSite("NONE")
                .build();
        response.setHeader(HttpHeaders.SET_COOKIE,cookie.toString());

        return ResponseEntity.ok(new ApiReturn(0,"success","success"));
    }

    @PostMapping("/getCookie")
    public ResponseEntity<ApiReturn> getCookie(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String allCookie=Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue())
                    .collect(Collectors.joining(", "));
            System.out.println("allCookie="+allCookie);
            return ResponseEntity.ok(new ApiReturn(0,"Find Cookie",allCookie));
        }else {
            System.out.println("No Cookie!!");
            return ResponseEntity.ok(new ApiReturn(1,"No Cookie!!","No Cookie!!"));
        }
    }

    @GetMapping("/sayHello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping(value = "/testCallable")
    public Callable<String> echoHelloWorld()
    {
        return () ->
        {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));

            return "Hello World !!";
        };
    }

    @GetMapping("/findAllTodoList")
    public ResponseEntity<List<Todo>> findAllTodoList(){
        List<Todo> todoList=mainService.findAllTodoList();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping("/findTodo")
    public ResponseEntity<Todo> findTodo(){
        Todo todo1=new Todo();
        todo1.setId("1");
        todo1.setName("待完成項目1");
        return ResponseEntity.ok(todo1);
    }

    @PostMapping("/postTodo")
    public ResponseEntity<String> postTodo(@RequestBody Todo todo){
        System.out.println("postTodo=> id"+todo.getId()+",name:"+todo.getName());
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/getData")
    public ResponseEntity<CookieData> getData(){

        return ResponseEntity.ok(new CookieData("This is cookieName","this is cookieValue"));
    }


}

record ApiReturn(int code,String message,String data){

}

record CookieData(String name,String value){

}
