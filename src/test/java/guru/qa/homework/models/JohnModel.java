package guru.qa.homework.models;

import com.github.javafaker.Address;

import java.util.List;

public class JohnModel {
    private String  name;
    private String email;
    private int age;
    private List<String> hobbies;
    private Address address;
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public static class Address {
        String street,
                city,
                state,
                country;
        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getCountry() {
            return country;
        }
    }
}
