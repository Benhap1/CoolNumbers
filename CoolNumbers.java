package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class CoolNumbers {
    private ArrayList<String> list = new ArrayList<>();

    private String letters = "АВЕКМНОРСТУХ";
    private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public CoolNumbers() {
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            char letter = letters.charAt((int) (Math.random() * letters.length()));
            int digit = numbers[(int) (Math.random() * numbers.length)];
            sb.append(letter).append(digit).append(digit).append(digit);
            sb.append(letters.charAt((int) (Math.random() * letters.length())));
            sb.append(letters.charAt((int) (Math.random() * letters.length())));
            int range = (int) (Math.random() * 199) + 1;
            if (range < 10) {
                sb.append("0");
            }
            sb.append(range);
            list.add(sb.toString());
//            for (String number : list) {
//                System.out.println(number);
//            }
        }
        Collections.sort(list); // sort for binary search
    }

    public boolean directSearch(String number) {
        long startTime = System.nanoTime();
        boolean found = false;
        for (String n : list) {
            if (n.equals(number)) {
                found = true;
                break;
            }
        }
        long endTime = System.nanoTime();
        if (found) {
            System.out.println("Direct search found " + number + " in " + (endTime - startTime) + " nanoseconds.");
        } else {
            System.out.println("Direct search did not find " + number + " in " + (endTime - startTime) + " nanoseconds.");
        }
        return found;
    }

    public boolean binarySearch(String number) {
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(list, number);
        long endTime = System.nanoTime();
        if (index >= 0) {
            System.out.println("Binary search found " + number + " in " + (endTime - startTime) + " nanoseconds.");
        } else {
            System.out.println("Binary search did not find " + number + " in " + (endTime - startTime) + " nanoseconds.");
        }
        return false;
    }

    public boolean hashSetSearch(String number) {
        HashSet<String> set = new HashSet<>(list);
        long startTime = System.nanoTime();
        boolean found = set.contains(number);
        long endTime = System.nanoTime();
        if (found) {
            System.out.println("HashSet search found " + number + " in " + (endTime - startTime) + " nanoseconds.");
        } else {
            System.out.println("HashSet search did not find " + number + " in " + (endTime - startTime) + " nanoseconds.");
        }
        return found;
    }

    public boolean treeSetSearch(String number) {
        TreeSet<String> set = new TreeSet<>(list);
        long startTime = System.nanoTime();
        boolean found = set.contains(number);
        long endTime = System.nanoTime();
        if (found) {
            System.out.println("TreeSet search found " + number + " in " + (endTime - startTime) + " nanoseconds.");
        } else {
            System.out.println("TreeSet search did not find " + number + " in " + (endTime - startTime) + " nanoseconds.");
        }
        return found;
    }

    public static void main(String[] args) {
        CoolNumbers coolNumbers = new CoolNumbers();

        String number = "Н444МР91";
        System.out.println("Searching for " + number);
        System.out.print("Direct search: ");
        System.out.println(coolNumbers.directSearch(number));
        System.out.print("BinarySearch search: ");
        System.out.println(coolNumbers.binarySearch(number));
        System.out.print("HashSetSearch search: ");
        System.out.println(coolNumbers.hashSetSearch(number));
        System.out.print("TreeSetSearch search: ");
        System.out.println(coolNumbers.treeSetSearch(number));
    }
}
