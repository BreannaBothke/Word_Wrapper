package main;

public class Main {

    public static void main(String[] args) {

        //Excerpt from 'Where the crawdads sing'
        String excerpt = "Part 1: The Marsh. Prologue - 1969 Marsh is not swamp." +
                " Marsh is a space of light, where grass grows in water," +
                " and water flows into the sky. Slow-moving creeks wander," +
                " carrying the orb of the sun with them to the sea, and long-legged birds" +
                " lift with unexpected grace-as though not built to fly-against the roar of a thousand snow geese." +
                " Then within the marsh, here and there, true swamp crawls into low-lying bogs, hidden in clammy forests." +
                " Swamp water is still and dark, having swallowed the light in its muddy throat. Even night crawlers are" +
                " diurnal in this lair. There are sounds, of course, but compared to the marsh, the swamp is quiet because" +
                " decomposition is cellular work. Life decays and reeks and returns to the rotted duff; a poignant wallow of" +
                " death begetting life. On the morning of October 30, 1969, the body of Chase Andrews lay in the swamp, which" +
                " would have absorbed it silently, routinely. Hiding it for good. A swamp knows all about death, and doesn't" +
                " necessarily define it as tragedy, certainly not a sin. But this morning two boys from the village rode their" +
                " bikes out to the old fire tower and, from the third switchback, spotted his denim jacket.";

        //should output returned string on multiple lines with length no longer than 70 characters.
        System.out.print(WordWrapper.wrap(excerpt, 70));

        //should output empty string because the text parameter is empty.
        System.out.print(WordWrapper.wrap(" ", 50));

        //should output single worded lines because of how small the maxLineLength parameter is.
        System.out.println(WordWrapper.wrap(excerpt, 1));

    }
}