##Steps to run in intellij:

Download Intellij: https://www.jetbrains.com/idea/download/#section=mac

For installation instructions, click `installation instructions` link on the left hand side of the intellij download page.

---

####After installation:


Run:
 `'git clone https://github.com/BreannaBothke/Word_Wrapper.git'` in the Terminal/Command line.

After cloning, you can `'cd'` into the project and run the command `'git log'` to view my commits.

I built this coding test in intellij.
 
###Instructions to run application in intellij:

     > open Word_Wrapper folder in intellij
     
     > at the top, next to the green hammer icon, click `Add Configuration`
     
     > click the plus sign in the upper left corner
     
     > click `Application`
     
     > Change Name from `Unnamed` to `Main`
     
     > Click ellipse icon `...` next to `Main class` text field
     
     > Select Main (main) and click ok
     
     > Select JRE file from dropdown or leave at `Default` - I used JRE 11.0.5 (You might have to download a JRE file?)
     
     > Select `ok` button at the bottom right corner
     
     > Navigate to `WordWrapper/src/main and open `main.java` file in the Project side bar on the far left of the intellij application
     
     > Select the play icon on the left hand side of the Main class and select `Run Main.main()`

##Application Requirements:

####Take Home Test

###Description:

>You are working on a word processing application and want to be able to take a string and insert line breaks at just the right places
so that it will fit into a column of a given length. You want to break lines at word boundaries.

This exercise is to implement the following method:

```
    public class WordWrapper {
        public static String wrap(String text, int maxLineLength) {
            // your implementation here
        }
    }
```
>1.The wrap function should break the text into lines no longer than the max length

>2.The wrap function should break the text on word boundaries by replacing a space with a newline character

>3.The wrap function should output the resulting text

###Requirements

>* Please complete the exercise in Java
>* Please submit your code in a local git repo (zipped and emailed, not on github etc)
>* Please use Test Driven Development
>* Commit your changes for each test so we can see your progress as you code the solution