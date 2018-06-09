package com.mockito.tutorial.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.tutorial.TodoBusinessImpl;
import com.mockito.tutorial.TodoService;

public class TodoServiceBDDTest {

	@Test
	public void test() {
		TodoService todoService=mock(TodoService.class);
		List<String> todos=Arrays.asList(new String[]{"Spring","MVC"});
		given(todoService.retrieveTodos("ABC")).willReturn(todos);
		TodoBusinessImpl impl=new TodoBusinessImpl(todoService);
		List<String> list=impl.getTodosForSpring("ABC");
		assertTrue(list.contains("Spring"));
		assertThat(list.size(), is(1));
	}

}
