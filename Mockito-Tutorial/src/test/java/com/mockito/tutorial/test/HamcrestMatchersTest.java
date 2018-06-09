package com.mockito.tutorial.test;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> nums=Arrays.asList(1,2,3,4);
		
		assertThat(nums, hasSize(4));
		assertThat(nums, hasItems(1,2));
		
		assertThat(nums, everyItem(greaterThan(0)));
		assertThat(nums, everyItem(lessThan(5)));
		
		assertThat("",isEmptyString());
		assertThat(null,isEmptyOrNullString());
	}

}
