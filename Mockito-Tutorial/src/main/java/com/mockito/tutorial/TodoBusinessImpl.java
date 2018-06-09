package com.mockito.tutorial;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl
{
	TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	public TodoService getTodoService() {
		return todoService;
	}

	public void setTodoService(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> getTodosForSpring(String user)
	{
		List<String> filteredTodos=new ArrayList<String>();
		for(String todo: todoService.retrieveTodos(user))
		{
			if(todo.contains("Spring"))
			{
				filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;
	}
	
	
}
