package net.ubn.td.todolist.service;

import net.ubn.td.todolist.dto.Todo;

import java.util.List;

public interface MainService {

    List<Todo> findAllTodoList();
}
