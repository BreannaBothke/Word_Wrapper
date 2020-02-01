package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordWrapperTest {

//The wrap function should break the text into lines no longer than the max length
//The wrap function should break the text on word boundaries by replacing a space with a newline character
//The wrap function should output the resulting text



    //Should break the text into lines no longer than the max length
    @Test
    public void breakTextNoLongerThanMaxLength() {
        //Local Variable Instantiation
        String randomString = createRandomString();
        List<String> maxLengthStringList = new ArrayList<>();
        int maxLineLength = 20;
        StringBuilder concatString = new StringBuilder();

        //Splits string on spaces and adds each "word" to stringList
        List<String> stringList = new ArrayList<>(Arrays.asList(randomString.split(" ")));

        //Loops through each word in stringList
        for (String word : stringList) {
            //If appending a word to the concatString goes over the length limit,
            if ((concatString.length() + word.length() + 1) > maxLineLength) {
                //then add current concatString to maxLengthStringList,
                maxLengthStringList.add(concatString.toString());
                //null concatString
                concatString.setLength(0);
                //rebuild concatString with current iterated word
                concatString = new StringBuilder(word);
                concatString.append(" ");

            //else if appending the current iterated word to the concatString does not go over the length limit,
            } else {
                //append current iterated word to concatString
                concatString.append(word);
                concatString.append(" ");

            }
        }

        //Tests that each line is no longer than the max length
        for (String line : maxLengthStringList) {
            Assertions.assertTrue(line.length() < maxLineLength);
        }
    }


    //Helper method that generates random strings for tests.
    private String createRandomString(){
        //instantiate local variables
        StringBuilder longString = new StringBuilder();

        //iterate up to 20 and create long string with the random generated strings
        for (int i = 0; i <= 20; i++) {
            //set word length
            byte[] array = new byte[5]; // length is bounded by 5
            new Random().nextBytes(array);
            //generate 5 character string
            String generatedString = new String(array, StandardCharsets.UTF_8);
            //append generated string to longString variable
            longString.append(generatedString).append(" ");
        }

        //return longString variable
        return longString.toString();
    }
}