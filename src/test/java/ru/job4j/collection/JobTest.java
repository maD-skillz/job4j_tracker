package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenSortAscName() {
        Comparator<Job> cmpName = new SortAscJobByName();
        int rsl = cmpName.compare(new Job("Spoon", 0),
        new Job("Fork", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortAscPriority() {
        Comparator<Job> cmpPriority = new SortAscJobByPriority();
        int rsl = cmpPriority.compare(new Job("Spoon", 0),
                new Job("Fork", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortDescName() {
        Comparator<Job> cmpName = new SortDescJobByName();
        int rsl = cmpName.compare(new Job("Spoon", 0),
                new Job("Fork", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortDescPriority() {
        Comparator<Job> cmpPriority = new SortDescJobByPriority();
        int rsl = cmpPriority.compare(new Job("Spoon", 0),
                new Job("Fork", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscByNameAndPriority() {
        Comparator<Job> cmpPriorityName = new SortAscJobByPriority().thenComparing(new SortAscJobByName());
        int rsl = cmpPriorityName.compare(new Job("Spoon", 0),
                new Job("Fork", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByNameAndDescPriority() {
        Comparator<Job> cmpNameDescPriority = new SortAscJobByName().thenComparing(new SortDescJobByPriority());
        int rsl = cmpNameDescPriority.compare(new Job("Spoon", 0),
                new Job("Fork", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDescByNameAndAscPriority() {
        Comparator<Job> cmpNameAndAscPriority = new SortDescJobByName().thenComparing(new SortAscJobByPriority());
        int rsl = cmpNameAndAscPriority.compare(new Job("Spoon", 0),
                new Job("Fork", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new SortDescJobByName().thenComparing(new SortDescJobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }


}