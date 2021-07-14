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
}