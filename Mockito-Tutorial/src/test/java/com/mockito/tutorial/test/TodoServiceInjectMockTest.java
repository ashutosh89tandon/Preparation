package com.mockito.tutorial.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mockito.tutorial.TodoBusinessImpl;
import com.mockito.tutorial.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceInjectMockTest {

	@Mock
	TodoService todoService;
	
	@InjectMocks
	TodoBusinessImpl impl;
	
	@Test
	public void test() {
		
		List<String> todos=Arrays.asList(new String[]{"Spring","MVC"});
		when(todoService.retrieveTodos("ABC")).thenReturn(todos);
		List<String> list=impl.getTodosForSpring("ABC");
		assertTrue(list.contains("Spring"));
		assertEquals(1, list.size());
	}

}
