package com.mockito.tutorial.test;

import java.util.Arrays;
import java.util.List;

import com.mockito.tutorial.TodoService;

public class TodoServiceStub implements TodoService{

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList(new String[]{"Spring","MVC"});
	}

}
