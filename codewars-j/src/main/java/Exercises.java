import java.util.*;

public class Exercises {
    public static void main(String[] args) {
        // sortArray()

        // high()
        /*
        Write simple camelCase method for strings.
        All words must have their first letter
        capitalized without spaces.

        camelCase("hello case"); // => "HelloCase"

        camelCase("camel case word"); // => "CamelCaseWord"
        String t1 = "man i need a taxi up to ubud";

        System.out.println(high(t1));
        */

        // countSmileys()

        // countPassengers()

    }

    public static int[] sortArray(int[] array) {
        /*
        You have an array of numbers.
        Your task is to sort ascending
        odd numbers but even numbers must
        be on their places.

        Zero isn't an odd number and you
        don't need to move it. If you have
        an empty array, you need to return it.

        sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
        */
        ArrayList<Integer> odds = new ArrayList<>();
        int j = 0;

        // place odds in list
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                odds.add(array[i]);
            }
        }

        // sort odds and place them in sorted order
        Collections.sort(odds);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array[i] = odds.get(j);
                j++;
            }
        }
        return array;
    }

    public static String high(String s) {
        /*
        Given a string of words, you need to find the
        highest scoring word.

        Each letter of a word scores points according
        to its position in the alphabet:
        a = 1, b = 2, c = 3 etc.

        You need to return the highest scoring word
        as a string.

        If two words score the same, return the word
        that appears earliest in the original string.

        All letters will be lowercase and all inputs
        will be valid.
        */

        // split string into an array of words
        String[] sArray = s.split(" ");

        // initialize an empty array to store
        // word scores
        int[] scoreArray = new int[sArray.length];

        // store alphabet and scores in a map
        HashMap<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('a', 1);
        scoreMap.put('b', 2);
        scoreMap.put('c', 3);
        scoreMap.put('d', 4);
        scoreMap.put('e', 5);
        scoreMap.put('f', 6);
        scoreMap.put('g', 7);
        scoreMap.put('h', 8);
        scoreMap.put('i', 9);
        scoreMap.put('j', 10);
        scoreMap.put('k', 11);
        scoreMap.put('l', 12);
        scoreMap.put('m', 13);
        scoreMap.put('n', 14);
        scoreMap.put('o', 15);
        scoreMap.put('p', 16);
        scoreMap.put('q', 17);
        scoreMap.put('r', 18);
        scoreMap.put('s', 19);
        scoreMap.put('t', 20);
        scoreMap.put('u', 21);
        scoreMap.put('v', 22);
        scoreMap.put('w', 23);
        scoreMap.put('x', 24);
        scoreMap.put('y', 25);
        scoreMap.put('z', 26);

        // tally scores for each word
        for (int i = 0; i < sArray.length; i++) {
            for (int j = 0; j < sArray[i].length(); j++) {
                scoreArray[i] += scoreMap.get(sArray[i].charAt(j));
            }
        }

        // find highest score and that score's index
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < scoreArray.length; i++) {
            if (scoreArray[i] > max) {
                max = scoreArray[i];
                maxIdx = i;
            }
        }

        // return word at highest score's index
        return sArray[maxIdx];
    }

    public static int countSmileys(List<String> arr) {
        int count = 0;
        for (String el :
                arr) {
            if ((el.charAt(0) == ':' ||
                    el.charAt(0) == ';') &&
                    (el.charAt(el.length() - 1) == ')' ||
                            el.charAt(el.length() - 1) == 'D'))  {
                if (el.length() == 3 &&
                        (el.charAt(1) == '-' ||
                                el.charAt(1) == '~')) {
                    count++;
                } else if (el.length() == 2){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countPassengers(ArrayList<int[]> stops) {
        int count = 0;
        for(int[] stop : stops) {
            count += (stop[0] - stop[1]);
        }
        return count;
    }




}
