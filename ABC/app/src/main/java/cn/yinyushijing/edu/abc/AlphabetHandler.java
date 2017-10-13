package cn.yinyushijing.edu.abc;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by wenjusun on 10/11/17.
 */

public class AlphabetHandler {
    private static AlphabetHandler ourInstance = new AlphabetHandler();
    private char[] upperLetters = new char[26];
    private char[] lowerLetters = new char[26];

    private char[] allLetters = new char[52];

    //65-90,97-122
    private AlphabetHandler(){
         for(int i=65,j=0;i<=90;i++){
             upperLetters[j++]=(char)i;
         }
         for(int i=97,j=0;i<=122;i++){
             lowerLetters[j++]=(char)i;
         }

    }

    public static AlphabetHandler getInstance(){
        return ourInstance;
    }

    public LetterPair getLetterPair2(){
        int randomIndex = new Random().nextInt(26);
        char upperLetter = upperLetters[randomIndex];
        int lowerLetter = upperLetter+32;
        return new LetterPair(upperLetter,(char)lowerLetter);
    }

    public LetterPair getLetterPair(){
        int randomValue = new Random().nextInt(26);
        int upperLetter = randomValue+65;
        int lowerLetter = upperLetter+32;
        return new LetterPair((char)upperLetter,(char)lowerLetter);
    }

    public String getSingleLetterRandomly(){
        return "A";

    }

}
