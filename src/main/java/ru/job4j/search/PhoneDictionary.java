package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineByName = (var person) -> person.getName().contains(key);
        Predicate<Person> combineBySurname = (var person) -> person.getSurname().contains(key);
        Predicate<Person> combineByPhone = (var person) -> person.getPhone().contains(key);
        Predicate<Person> combineByAddress = (var person) -> person.getAddress().contains(key);
        var combine = combineByName.or(combineBySurname).
                or(combineByPhone).or(combineByAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}