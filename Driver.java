import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        Line emptyLine = new Line();
        String parcel1 = "a";
        System.out.println("==========Empty Line Tests==========\n");
        System.out.println("Empty Line:");
        System.out.printf("%s\n\n", emptyLine);

        System.out.println("Person 1 added to end of list:");
        emptyLine.add(parcel1);
        System.out.printf("%s\n\n", emptyLine);
        emptyLine.remove();

        System.out.println("Person 1 added to front using index:");
        emptyLine.add(0, parcel1);
        System.out.printf("%s\n\n", emptyLine);
        emptyLine.remove(0);

        System.out.println("Reversing empty line:");
        emptyLine.reverse();
        System.out.printf("%s\n\n", emptyLine);

        System.out.println("Empty line contains:");
        System.out.printf("%s\n\n", emptyLine.contains(parcel1));
        
        System.out.println("Clearing an empty line:");
        System.out.printf("%s\n\n", emptyLine);

        // EMPTY LIST SPECIFIC EXCEPTION TESTING:
        // COMMENT OUT ONE GROUP OF LINES
        // AT A TIME FOR EACH EXCEPTION

        // emptyLine.remove(); // should throw NoSuchElementException

        // emptyLine.remove(10000); // should throw NoSuchElementException

        // emptyLine.set(0, parcel1); // should throw IndexOutOfBoundsException

        // emptyLine.get(0); // should throw IndexOutOfBoundsException

        String[] parcels = new String[]{"A", "B", "C", "D", "E"};
        Line line = new Line(parcels);
        System.out.println("==========Basic Line Tests==========\n");
        System.out.println("Printing line:");
        System.out.printf("%s\n\n", line);

        System.out.println("=====Add tests=====\n");
        System.out.println("Appending an element:");
        line.add("F");
        System.out.printf("%s\n\n", line);

        System.out.println("Inserting an element into the middle:");
        line.add(2, "F");
        System.out.printf("%s\n\n", line);

        System.out.println("Appending an element with index:");
        line.add(line.size(), "FF");
        System.out.printf("%s\n\n", line);

        System.out.println("Adding to the front:");
        line.add(0, "AA");
        System.out.printf("%s\n\n", line);

        System.out.println("=====Remove Tests=====\n");
        System.out.println("Removing the first 'F':");
        System.out.printf("Returns: %s\n", line.remove("F"));
        System.out.printf("%s\n\n", line);

        System.out.println("Removing an element from the middle:");
        System.out.printf("Returns: %s\n", line.remove(4));
        System.out.printf("%s\n\n", line);

        System.out.println("Removing the first element:");
        System.out.printf("Returns: %s\n", line.remove());
        System.out.printf("%s\n\n", line);

        System.out.println("Removing the first element with index:");
        System.out.printf("Returns: %s\n", line.remove(0));
        System.out.printf("%s\n\n", line);

        System.out.println("Removing the last index:");
        System.out.printf("Returns: %s\n", line.remove(line.size() - 1));
        System.out.printf("%s\n\n", line);

        System.out.println("Resetted line:");
        line.add(0, "A");
        line.add(3, "D");
        System.out.printf("%s\n\n", line);

        System.out.println("=====Set Tests=====\n");
        System.out.println("Set 'A' to 'a':");
        System.out.printf("Returns: %s\n", line.set(0, "a"));
        System.out.printf("%s\n\n", line);
        line.set(0, "A");
        
        System.out.println("Set 'D' to 'd':");
        System.out.printf("Returns: %s\n", line.set(3, "d"));
        System.out.printf("%s\n\n", line);
        line.set(3, "D");

        System.out.println("Set 'F' to 'f':");
        System.out.printf("Returns: %s\n", line.set(line.size() - 1, "f"));
        System.out.printf("%s\n\n", line);
        line.set(line.size() - 1, "F");

        System.out.println("=====Get Tests=====\n");
        System.out.println("Get first element:");
        System.out.printf("First element: %s\n\n", line.get(0));

        System.out.println("Get middle element:");
        System.out.printf("Middle element: %s\n\n", line.get(3));

        System.out.println("Get last element:");
        System.out.printf("Last element: %s\n\n", line.get(line.size() - 1));

        System.out.println("=====Contains Tests=====\n");
        System.out.println("Check for first element:");
        System.out.printf("Line contains first element: %b\n\n", line.contains("A"));

        System.out.println("Check for middle element:");
        System.out.printf("Line contains middle element: %b\n\n", line.contains("C"));

        System.out.println("Check for last element:");
        System.out.printf("Line contains last element: %b\n\n", line.contains("F"));

        System.out.println("Check for element it doesn't contain:");
        System.out.printf("Line contains element it doesn't contain: %b\n\n", line.contains("Z"));

        System.out.println("Reversed line:");
        line.reverse();
        System.out.printf("%s\n\n", line);

        System.out.println("Cleared line:");
        line.clear();
        System.out.printf("%s\n", line);

        line.add("A");
        line.add("B");
        line.add("C");
        line.add("D");
        line.add("E");
        line.add("F");
        // ALL REMAINING LINE EXCEPTIONS TESTS:
        // COMMENT OUT ONE GROUP OF LINES
        // AT A TIME FOR EACH EXCEPTION

        // String[] nullArray = null;
        // Line nullLine = new Line(nullArray); // should throw IllegalArgumentException

        // String[] nullArray = new String[]{"A", null};
        // Line nullLine = new Line(nullArray); // should throw IllegalArgumentException

        // line.add(null); // should throw IllegalArgumentException

        // line.add(-1, "A"); // should throw IndexOutOfBoundsException

        // line.add(10000, "A"); // should throw IndexOutOfBoundsException

        // line.add(2, null); // should throw IllegalArgumentException

        // line.add(line.size() + 1, null); // should throw IndexOutOfBoundsException

        // line.remove(line.size()); // should throw IndexOutOfBoundsException

        // line.remove(-5); // should throw IndexOutOfBoundsException

        // line.remove(null); // should throw IllegalArgumentException

        // line.remove("Z"); // should throw NoSuchElementException

        // line.set(line.size(), "L"); // should throw IndexOutOfBoundsException

        // line.set(-2, "K"); // should throw IndexOutOfBoundsException

        // line.set(-3, null); // should throw IndexOutOfBoundsException

        // line.set(3, null); // should throw IllegalArgumentException

        // line.get(line.size()); // should throw IndexOutOfBoundsException

        // line.get(-5); // should throw IndexOutOfBoundsException

        // line.contains(null); // should throw IllegalArgumentException

        // ALL OTHER CLASSES EXCEPTIONS TESTS:
        // COMMENT OUT ONE GROUP OF LINES
        // AT A TIME FOR EACH EXCEPTION

        // Person person = new Person(null); // should throw IllegalArgumentException

        // LineIterator iterator = new LineIterator(null); // should throw IllegalArgumentException
        
        // LineIterator iterator = new LineIterator(line);
        // while (true) {
        //     iterator.next(); // should eventually throw a NoSuchElementException
        // }
    }
}