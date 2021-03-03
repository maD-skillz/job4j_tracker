package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++ ) {
            if (rsl == -1) {
                throw new ElementNotFoundException("Not Found");
            } else if (value[i] == key) {
                return i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
          FindEl.indexOf();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
