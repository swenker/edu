package cn.yinyushijing.edu.abc;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by wenjusun on 10/11/17.
 */

public class AlphabetHandler {
    private static AlphabetHandler ourInstance = new AlphabetHandler();
    private char[] upperLetters = new char[]{
        'A','B','C','D','E','F','G','H','I','J',
        'K','L','M','N','O','P','Q','R','S','T',
        'U','V','W','X','Y','Z'
    };

    private AlphabetHandler(){

    }

    public static AlphabetHandler getInstance(){
        return ourInstance;
    }

    public LetterPair getLetterPair(){
        int randomIndex = new Random().nextInt(26);
        char upperLetter = upperLetters[randomIndex];
        int lowerLetter = upperLetter+32;
        return new LetterPair(upperLetter,(char)lowerLetter);
    }
    public String getUpperLetterRandomly(){
        return "A";

    }

    public String getLowerLetterRandomly(){
        return "a";
    }
}
