package ru.job4j.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenGetAddress() {
        List<Address> addressList = Arrays.asList(
                new Address("New York", "6th Avenue", 6, 12),
                new Address("Washington", "North Capital Street", 15, 2),
                new Address("Springfield", "Everhreen Street", 1, 1)
        );
        List<Profile> list = Arrays.asList(
                new Profile(addressList.get(0)),
                new Profile(addressList.get(1)),
                new Profile(addressList.get(2)));
        assertThat(Profiles.collect(list), is(addressList));
    }

    @Test
    public void whenDuplicateAddress() {
        List<Address> addressList = Arrays.asList(
                new Address("New York", "6th Avenue", 6, 12),
                new Address("New York", "6th Avenue", 6, 12),
                new Address("Washington", "North Capital Street", 15, 2),
                new Address("Springfield", "Evergreen Street", 1, 1),
                new Address("Springfield", "Evergreen Street", 1, 1)
        );
        List<Profile> list = Arrays.asList(
                new Profile(addressList.get(0)),
                new Profile(addressList.get(1)),
                new Profile(addressList.get(2)),
                new Profile(addressList.get(3)),
                new Profile(addressList.get(4))
        );
        List<Address> expectedList = Arrays.asList(
                new Address("New York", "6th Avenue", 6, 12),
                new Address("Springfield", "Evergreen Street", 1, 1),
                new Address("Washington", "North Capital Street", 15, 2)
        );
        assertThat(Profiles.sortTheSame(list), is(expectedList));
    }
}