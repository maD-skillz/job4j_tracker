package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortToHigh() {
        List<Integer> list = Arrays.asList(12, 4, 46, 99, 1);
        Collections.sort(list);
        List<Integer> expect = Arrays.asList(1, 4, 12, 46, 99);
        assertThat(list, is(expect));
    }

    @Test
    public void whenSortToLow() {
        List<Integer> list = Arrays.asList(12, 4, 46, 99, 1);
        Collections.sort(list, Collections.reverseOrder());
        List<Integer> expect = Arrays.asList(99, 46, 12, 4, 1);
        assertThat(list, is(expect));
    }

}