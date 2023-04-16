package guru.qa.homework.utils;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {
    static String[] genders = {"Male", "Female", "Other"};
    static String[] months = {
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};
    static  String[] hobbies = {"Sports", "Reading", "Music"};
    static String[] subjects = {"Physics","Maths","Chemistry","English",
            "Commerce", "Social Studies", "Biology", "Economics", "Arts",
            "History", "Accounting" };
    static String[] states = {"NCR","Uttar Pradesh", "Haryana", "Rajasthan"};
    static String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
    static String[] citiesUttarPradesh = {"Agra", "Lucknow", "Merrut"};
    static String[] citiesHaryana = {"Karnal", "Panipat"};
    static String[] citiesRajasthan = {"Jaipur", "Jaiselmer"};




    //Для тестирования методов
    public static void main(String[] args) {
        System.out.println(getRandomItemFromArray(genders));
    }
    //Случайны элемент массива
    public static String getRandomItemFromArray(String[] values){
        int index = getRandomInt(0, values.length - 1);
        return values[index];

    }
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    //Случайный гендер
    public static String getRandomGender(){
        return getRandomItemFromArray(genders);
    }
    //Случайный месяц
    public static String getRandomMonth() {
        return getRandomItemFromArray(months);
    }
    //Случайное увлечение
    public static String getRandomHobbie(){return getRandomItemFromArray(hobbies);
    }
    //Случайный предмет
    public static String getRandomSubject(){return getRandomItemFromArray(subjects);
    }
    //Случайный штат
    public static String getRandomState(){return getRandomItemFromArray(states);
    }
    public static String getRandomCity(String state){
        String City = "";
        switch(state){
            case "NCR":
                City = getRandomItemFromArray(citiesNCR);
                break;
            case "Uttar Pradesh":
                City = getRandomItemFromArray(citiesUttarPradesh);
                break;
            case "Haryana":
                City = getRandomItemFromArray(citiesHaryana);
                break;
            case "Rajasthan":
                City = getRandomItemFromArray(citiesRajasthan);
        }
        return City;

    }


}
