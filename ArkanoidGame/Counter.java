// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of Counter
 * The class Counts has all the basic counter methods s.e: increase,decrease,getValue
 */
public class Counter {
    //the counter
    private int count;

    /**.
     * Counter - the constructor (default - 0)
     */
    public Counter() {
        this.count = 0;
    }

    /**.
     * Counter - the constructor
     *
     * @param counter - the counter to add to
     */
    public Counter(int counter) {
        this.count = counter;
    }

    // add number to current count.

    /**
     * increase -add number to current count.
     *
     * @param number - the number to add
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * decrease - subtract number from current count.
     *
     * @param number - the number to subtract
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**.
     * getValuie - get the current value of the counter
     *
     * @return - the current value of the counter
     */
    public int getValue() {
        return this.count;
    }
}
