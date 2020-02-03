package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordWrapper {


    //    TODOS
    //The wrap function should break the text into lines no longer than the max length
    //The wrap function should break the text on word boundaries by replacing a space with a newline character
    //The wrap function should output the resulting text

    public static String wrap(String text, int maxLineLength) {
        //String variable with new line characters
        StringBuilder newLineString = new StringBuilder();

        try {
            //if the max line length parameter is 0 or less,
            if (maxLineLength <= 0) {
                //then print out error message to the console
                return "Error: MaxLineLength needs to be more than zero.";
            //else if text parameter is empty
            } else if (text.isEmpty() || (text.trim().length() == 0)) {
                //then return empty string
                return "";
            //else if text parameter is not empty and max Line Length parameter is greater than 0
            } else {
                //then continue on

                //Splits string on spaces and adds each "word" to stringList
                List<String> stringList = new ArrayList<>(Arrays.asList(text.split(" ")));

                //accesses helper method to create a list of strings that don't exceed the max line length specified in the parameters
                List<String> maxLengthStringList = new ArrayList<>(createListOfStringsWithMaxLength(stringList, maxLineLength));

                //Loops through each string in the list
                for (String s : maxLengthStringList) {

                    //appends '\n' to end of string
                    String newString = s.trim() + "\n";
                    newLineString.append(newString);

                }
            }

            //catch possible exception errors
        } catch (Exception e) {
            //print exception error to console
            System.out.println(e);
        }
        return newLineString.toString();

    }

    //Helper method that splits strings to where their length doesn't exceed the max line length specified.
    private static List<String> createListOfStringsWithMaxLength(List<String> stringList, int maxLineLength) {

        //Instantiate Variables
        StringBuilder concatString = new StringBuilder();
        List<String> maxLengthStringList = new ArrayList<>();


        //Loops through each word in stringList
        for (String word : stringList) {


            //If appending a word to the concatString goes over the length limit,
            if ((concatString.length() + word.length()) > maxLineLength) {
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

                //if last iteration of the list
                if(word.equals(stringList.get(stringList.size() - 1))) {
                    //add last concatString to maxLengthStringList
                    maxLengthStringList.add(concatString.toString());
                }

        }
        //return list of updated strings
        return maxLengthStringList;
    }
}