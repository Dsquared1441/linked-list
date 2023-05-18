/** This is a generic class of a Person in line carrying a
 * parcel of type T.
 * @author Daniel Deller
 * @version 1.0
 * @param <T> the type of parcel a person is carrying
 */
public class Person<T> {
    /** The parcel that the person is carrying. */
    private T parcel;
    /** A reference to the next Person in line carrying
     * the same type of parcel. IF this is null, it is the
     * the current Person object is the last one in the line.
     */
    private Person<T> nextPerson;

    /** Full constructor which instantiates a Person object using type T.
     * @param parcel The parcel that the person is carrying. Must not be null.
     * @param nextPerson A reference to the next Person in line carrying
     * the same type of parcel. IF this is null, it is the
     * the current Person object is the last one in the line.
     * @throws IllegalArgumentException if {@code parcel} is null
     */
    public Person(T parcel, Person<T> nextPerson) {
        if (parcel == null) {
            throw new IllegalArgumentException("function arg parcel was null,"
                + " please enter a proper value...");
        }
        this.parcel = parcel;
        this.nextPerson = nextPerson;
    }

    /** Constructor whichi instantiates a Person object.
     * {@code nextPerson} is set to {@code null}.
     * @param parcel The parcel that the person is carrying. Must not be null.
     * @throws IllegalArgumentException if {@code parcel} is null
     */
    public Person(T parcel) {
        this(parcel, null);
    }

    /** Gets the parcel that the Person is carrying.
     * @return the parcel the person is carrying
     */
    public T getParcel() {
        return parcel;
    }

    /** Changes the parcel that the Person is carrying to {@code parcel}.
     * @param parcel The new parcel that the person is carrying.
    */
    public void setParcel(T parcel) {
        this.parcel = parcel;
    }

    /** Gets the reference to the next Person in line.
     * @return the object of the next person in line.
     */
    public Person<T> getNextPerson() {
        return this.nextPerson;
    }

    /** Changes which Person is next in line.
     * @param nextPerson the new next Person in line
    */
    public void setNextPerson(Person<T> nextPerson) {
        this.nextPerson = nextPerson;
    }
}