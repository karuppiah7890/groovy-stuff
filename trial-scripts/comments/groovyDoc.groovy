/**
 * A Class description
 */
class Person {
    /** the name of the person */
    String name

    /**
     * Creates a greeting method for a certain person.
     *
     * @param otherPerson the person to greet
     * @return a greeting message
     */
    static String greet(String otherPerson) {
       "Hello ${otherPerson}"
    }

    static void main(String[] args) {
        println greet("Karuppiah")
    }
}
