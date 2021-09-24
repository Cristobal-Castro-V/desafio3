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

    public static boolean isOdd(Long number){
        if (number % 2 != 0){
            return true;
        }
        return false;
    }

    public static boolean isPrime(Long number) {
        if(number == 0 || number == 1){
            return false;
        }
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

}
