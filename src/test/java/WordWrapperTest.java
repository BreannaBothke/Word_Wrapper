package test.java;

import main.WordWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


public class WordWrapperTest {

    private static final int CONST_MAX_LINE_LENGTH = 30;
    private static final int CONST_NUM_CHAR_COUNT = 0;

//    TODOS
    //The wrap function should break the text into lines no longer than the max length
    //The wrap function should break the text on word boundaries by replacing a space with a newline character
    //The wrap function should output the resulting text

    //checks if string parameter is not empty
    //returns an empty string if string param is empty
    @Test
    public void checkTextParamIsNotEmpty() {
        String results;

        results = WordWrapper.wrap(" ", CONST_MAX_LINE_LENGTH);
        assertEquals(CONST_NUM_CHAR_COUNT, results.length());

    }

    //checks if maxLength parameter is not zero, returns true if maxLength is greater than zero, fails if not
    @Test
    public void checkLengthParamIsNotZero() {
        int maxLength = 20;

        try {

            if (maxLength > 0) {

                Assertions.assertTrue(true);

            }

        } catch (Exception e) {

            Assertions.fail();

        }

    }

    //Should break the text into lines no longer than the max length
    @Test
    public void breakTextNoLongerThanMaxLength() {
        //Local Variable Instantiation
        String randomString = createRandomString();
        int maxLineLength = 20;


        //Splits string on spaces and adds each "word" to stringList
        List<String> stringList = new ArrayList<>(Arrays.asList(randomString.split(" ")));

        //accesses helper method to create a list of strings that are no longer than the max line length specified in the parameters
        List<String> maxLengthStringList = new ArrayList<>(createListOfStringsWithMaxLength(stringList, maxLineLength));

        //Tests that each line is no longer than the max length
        for (String line : maxLengthStringList) {
            Assertions.assertTrue(line.length() < maxLineLength);
        }
    }



    //Should append a newline character to the end of each line
    @Test
    public void addNewLineCharacterAfterTextBreaks() {
        //Local Variable Instantiation
        List<String> maxLengthStringList = new ArrayList<>();
        int maxLineLength = 20;
        //accesses helper method to create long string of random 'words'
        String randomString = createRandomString();

        //Splits string on spaces and adds each "word" to stringList
        List<String> stringList = new ArrayList<>(Arrays.asList(randomString.split(" ")));

        //accesses helper method to create a list of strings that are no longer than the max line length specified in the parameters
        List<String> listOfStringsWithMaxLength = createListOfStringsWithMaxLength(stringList, maxLineLength);

        //Tests that each line is no longer than the max length and that "\n" is being added to each string
        for (int i = 0; i < listOfStringsWithMaxLength.size(); i++) {
            //appends '\n' to end of string
            String newString = listOfStringsWithMaxLength.get(i) + "\n";
            //adds updated string to new list of strings that meet max length criteria
            maxLengthStringList.add(i, newString);

            //Tests that each string line is no longer than max line length ** We subtract 2 characters from the length to account for the '\n'
            Assertions.assertTrue(newString.length() - 2 < maxLineLength);
            //Tests that each string line has '\n' appended to the end
            Assertions.assertEquals("\n", maxLengthStringList.get(i).substring((newString.length() - 1), newString.length()));

        }

    }

    //Test should output the strings with `\n` on new lines and print strings without `\n` on the same line.
    @Test
    public void printStrings() {
        //Instantiate List
        List<String> listOfStrings = new ArrayList<>();

        //add multiple strings with `\n` and without `\n` to list
        listOfStrings.add("Hello, my name is Karen\n");
        listOfStrings.add("Hi, Karen. How are you?\n");
        listOfStrings.add("Random string\n");
        listOfStrings.add("Another random string\n");
        listOfStrings.add("String without new line character.");
        listOfStrings.add("another string without new line character.");

        //print out each string to the console
        for(String string : listOfStrings)
            System.out.print(string);

    }

//    @Test
//    public void

    //Helper method that splits strings for tests.
    private List<String> createListOfStringsWithMaxLength(List<String> stringList, int maxLineLength) {

        StringBuilder concatString = new StringBuilder();
        List<String> maxLengthStringList = new ArrayList<>();


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

        return maxLengthStringList;
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