import java.util.Iterator;
import java.util.NoSuchElementException;
/** This represents the Line that People stand in. It is
 * a LinkedList of People holding parcels of type T.
 * @author Daniel Deller
 * @version 1.0
 * @param <T> the type of the parcel that a person is carrying.
 */
public class Line<T> implements List<T> {

    /** The head of a linked list made of Person nodes.*/
    private Person<T> firstPerson;
    /** The size of the list. */
    private int size;

    /** Constructor which initializes a Line object. The {@code size} is
     * exactly determined by the length of {@code parcel}.
     * @param parcel an array of parcels to put inot a Line. Must not be null.
     * @throws IllegalArgumentException if {@code parcel} is null.
     */
    public Line(T[] parcel) {
        if (parcel == null) {
            throw new IllegalArgumentException("constructor arg parcel is null"
                + ", please enter the proper value...");
        }
        if (parcel.length == 1) {
            this.firstPerson = new Person<T>(parcel[0]);
        } else {
            this.size = 0;
            for (int i = 0; i < parcel.length; i++) {
                this.add(i, (T) parcel[i]);
            }
        }
    }

    /** Default constructor which initializes an empty List, wich a null
     * {@code firstPerson}.
     */
    public Line() {
        this.firstPerson = null;
        this.size = 0;
    }

    /** Returns the head of the Linked List, or the first person in line.
     * @return the first Person in Line
     */
    public Person<T> getFirstPerson() {
        return firstPerson;
    }

    /** Returns the LinkedList of People holding parcels of type T as
     * an array of parcels from beginning to end.
     * @return an arrray of the parcel objects held by the Persons in the line.
     */
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINE %d =====\nisEmpty: %b\nsize: %d\nfirstPerson: %s\n: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (firstPerson == null ? "null" : firstPerson.getParcel())));

        T[] people = toArray();
        if (people == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < people.length - 1; ++i) {
                sb.append(String.format("%s, ", people[i])); // append all but last value
            }
            if (people.length > 0) {
                sb.append(String.format("%s", people[people.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element is null, please enter"
                + " a proper value...");
        }
        if (size == 0) {
            this.firstPerson = new Person<T>(element);
            size++;
            return;
        } else {
            Person<T> last = this.getPerson(size - 1);
            last.setNextPerson(new Person<T>(element));
            size++;
        }
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element is null, please enter"
                + " a proper value...");
        }
        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException("tindex out of bounds");
        }

        if (index == 0) {
            Person<T> nex = this.firstPerson;
            this.firstPerson = new Person<T>(element, nex);
            size++;
        } else if (index == size) {
            Person<T> last = this.getPerson(size - 1);
            last.setNextPerson(new Person<T>(element));
            size++;
        } else {
            Person<T> last = this.getPerson(index - 1);
            Person<T> next = last.getNextPerson();
            last.setNextPerson(new Person<T>(element, next));
            size++;
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("List is empty!");
        }
        Person<T> orig = this.firstPerson;
        this.firstPerson = this.firstPerson.getNextPerson();
        size--;
        return orig.getParcel();
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (size == 0) {
            throw new NoSuchElementException("List is empty!");
        }
        T cur;
        if (index == 0) {
            return this.remove();
        } else if (index == size - 1) {
            Person<T> end = this.getPerson(size - 2);
            cur = end.getNextPerson().getParcel();
            end.setNextPerson(null);
        } else {
            Person<T> prev = this.getPerson(index - 1);
            cur = prev.getNextPerson().getParcel();
            Person<T> next = prev.getNextPerson().getNextPerson();
            prev.setNextPerson(next);
        }
        size--;
        return cur;
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("element is null, please enter"
                + " a proper value...");
        }
        if (!this.contains(element)) {
            throw new NoSuchElementException("Element doesn't exist in Line!");
        }
        if (size == 0) {
            throw new NoSuchElementException("List is empty!");
        }
        //FIXME
        Iterator<T> itr = this.iterator();
        int i = 0;
        while (itr.hasNext()) {
            T n = itr.next();
            if (n.equals(element)) {
                return this.remove(i);
            }
            i++;
        }

        return null;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("function arg element is null,"
                + " please enter the proper value...");
        }
        Person<T> p = this.getPerson(index);
        T rep = p.getParcel();
        p.setParcel(element);
        return rep;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        Person<T> p = this.getPerson(index);
        return p.getParcel();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        Iterator<T> itr = this.iterator();
        while (itr.hasNext()) {
            T n = itr.next();
            if (n.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.firstPerson = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LineIterator<T>(this);
    }

    /** Reverses the order of the linked list. */
    public void reverse() {
        if (size > 1) {
            this.firstPerson = recurseReverse(null, firstPerson);
        }
    }

    /** Helper method for traversing the linked list from the beginning.
     * @param index the index at which to access the list
     * @return the instance of the Person in the linked list
     * @throws IndexOutOfBoundsException if the index is out of bounds of the
     * linked list
     */
    private Person<T> getPerson(int index) throws IndexOutOfBoundsException {
        if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException("index out of bounds :(");
        }
        int i = 0;
        Person<T> p = this.firstPerson;
        while (i < index) {
            p = p.getNextPerson();
            i++;
        }
        return p;
    }

    /** Helper recursive method for sorting in reverse. It traverses the list
     * by recursively shuffling the list to the right.
     * @param current the current Person
     * @param next the next Person
     * @return the head of the new linked list
     */
    private Person<T> recurseReverse(Person<T> current, Person<T> next) {
        if (next == null) {
            return current;
        } else {
            Person<T> future = next.getNextPerson();
            next.setNextPerson(current);
            return recurseReverse(next, future);
        }
    }
}
