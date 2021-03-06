package desafio.devoptopus.desafio3.util;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Util {

    private Util(){

    }
    public static boolean isPalindrome(String originalString) {

        String tempString = originalString.replaceAll("\\s+", "").toLowerCase();

        if (tempString.length() < 3) {
            return false;
        }
        return IntStream.range(0, tempString.length() / 2)
                .noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));

    }

    public static double calDiscount(double price) {
        return price * 0.5;
    }
}
