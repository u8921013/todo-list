package net.ubn.td.todolist.service;

import net.ubn.td.todolist.dto.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainServiceImpl implements MainService{
    @Override
    public List<Todo> findAllTodoList() {

        List<Todo> returnList=new ArrayList<>();
        Todo todo1=new Todo();
        todo1.setId("1");
        todo1.setName("待完成項目1");
        returnList.add(todo1);

        Todo todo2=new Todo();
        todo2.setId("2");
        todo2.setName("待完成項目2");
        returnList.add(todo2);

        return returnList;
    }
}
