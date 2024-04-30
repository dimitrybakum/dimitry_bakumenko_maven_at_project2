package utils;

import java.util.Random;

public class Randomizer {
    static Random random = new Random();

    static String pwd = "Q!1q123456";
    static String name = "Aszx";

    public static String generateName() {
        return name + random.nextInt();

    }

    public static String generatePassword() {
        return pwd + random.nextInt(5);
    }

    public static void main(String[] args) {

        System.out.println(generateName());
        System.out.println(generatePassword());
    }
}
