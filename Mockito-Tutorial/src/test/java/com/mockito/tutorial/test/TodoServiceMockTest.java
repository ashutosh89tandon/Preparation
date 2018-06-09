package com.mockito.tutorial.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.tutorial.TodoBusinessImpl;
import com.mockito.tutorial.TodoService;

public class TodoServiceMockTest {

	@Test
	public void test() {
		TodoService todoService=mock(TodoService.class);
		List<String> todos=Arrays.asList(new String[]{"Spring","MVC"});
		when(todoService.retrieveTodos("ABC")).thenReturn(todos);
		TodoBusinessImpl impl=new TodoBusinessImpl(todoService);
		List<String> list=impl.getTodosForSpring("ABC");
		assertTrue(list.contains("Spring"));
		assertEquals(1, list.size());
	}

}
