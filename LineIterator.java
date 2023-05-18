import java.util.Iterator;
import java.util.NoSuchElementException;

/** This class serves as an Iterator object that can traverse
 * a Line object of people carrying percels of type {@code T}.
 * @author Daniel Deller
 * @version 1.0
 * @param <T> The type of the List that the iterator is traversing
*/
public class LineIterator<T> implements Iterator<T> {
    /** A reference to the next Person in line carrying
     * the same type of parcel. IF this is null, it is the
     * the current Person object is the last one in the line.
    private Person nextPerson;
    */
    private Person<T> nextPerson;

    /** Constructor which instantiates a LineIterator object.
     * @param line The line that you want to iterate over.
     * Must not be null.
     * @throws IllegalArgumentException if {@code line} is null.
     */
    public LineIterator(Line line) {
        if (line == null) {
            throw new IllegalArgumentException("function arg line is null,"
                + " please enter a proper value!");
        }
        this.nextPerson = line.getFirstPerson();
    }

    @Override
    public boolean hasNext() {
        if (this.nextPerson == null) {
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        if (this.nextPerson == null) {
            throw new NoSuchElementException("This was the last person in "
                + "line. End of iterator reached.");
        } else {
            T parcel = (T) this.nextPerson.getParcel();
            this.nextPerson = this.nextPerson.getNextPerson();
            return parcel;
        }
    }
}
