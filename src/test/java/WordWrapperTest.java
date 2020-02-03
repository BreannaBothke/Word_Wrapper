package test.java;

import main.WordWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


public class WordWrapperTest {

    private static final int CONST_MAX_LINE_LENGTH_30 = 30;
    private static final int CONST_MAX_LINE_LENGTH_10 = 10;
    private static final int CONST_MAX_LINE_LENGTH_5 = 5;
    private static final int CONST_ZERO_CHAR_COUNT = 0;
    private static final String CONST_STRING = "The fox jumped over the lazy dog.";

   /* TODO
       * The wrap function should break the text into lines no longer than the max length
       * The wrap function should break the text on word boundaries by replacing a space with a newline character
       * The wrap function should output the resulting text
   */

    //checks method behavior if string parameter is empty or not
    //returns an empty string if string param is empty
    @Test
    public void textParamIsEmptyOrNotBehavior() {
        String resultsNotEmpty, resultsEmpty;

        resultsNotEmpty = WordWrapper.wrap(CONST_STRING, CONST_MAX_LINE_LENGTH_30);
        resultsEmpty = WordWrapper.wrap(" ", CONST_MAX_LINE_LENGTH_30);

        assertTrue(resultsNotEmpty.length() > CONST_ZERO_CHAR_COUNT);
        assertEquals(CONST_ZERO_CHAR_COUNT, resultsEmpty.length());


    }

    //checks if Error message is being returned if maxLength parameter is zero or less
    @Test
    public void maxLengthParamZeroOrLessBehavior() {

        String results = WordWrapper.wrap(CONST_STRING, -2);

        assertEquals("Error: MaxLineLength needs to be more than zero.", results);


    }

    //Tests if `\n` is replacing a space after maxLineLength criteria is being met
    //
    @Test
    public void replaceSpaceWithNewLineCharacterAfter10MaxLineLength() {

        //call wrap method, returns a string with newline characters
        String results = WordWrapper.wrap(CONST_STRING, CONST_MAX_LINE_LENGTH_10);

        //get first line of 10 characters
        String stringOf10 = results.substring(0, CONST_MAX_LINE_LENGTH_10);
        int count = 1;
        int startOfLine = 0;
        //index of first occurence of `\n`
        int endOfLine = stringOf10.indexOf("\n");

        //count number of `\n` instances in string
        int numOfNewChars = countNewLineCharacters(results) + 1;

        //iterate through lines
        while (count <= numOfNewChars) {
            //get first line
            String line = results.substring(startOfLine, endOfLine + 1);
            System.out.println(line);

            //set startOfLine to value of previous line endOfLine
            startOfLine = endOfLine + 1;

            //find end of next line
            endOfLine += results.substring(startOfLine).indexOf("\n") + 1;

            //increment count
            count++;

            //Tests if there's a `\n` at the end of each line
            assertEquals("\n", line.substring(line.length() - 1));

            //Tests if `\n` is replacing spaces and not being appended after spaces
            //Length of string being passed in should match length of string being returned
            assertEquals(CONST_STRING.length(), results.length() - 1);

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


    private int countNewLineCharacters(String string) {
        int count = 0;
        String[] temp = string.split(" ");

        //Loops through list of strings
        for (String s : temp) {
            //if current string contains newline character
            if (s.contains("\n"))
                //increment count
                count++;
        }

        return count;
    }

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