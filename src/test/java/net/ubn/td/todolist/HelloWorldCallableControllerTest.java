package net.ubn.td.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


//@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloWorldCallableControllerTest {

    @Autowired
    private MockMvc mockMvc;

}
