
/**
 * @author SAGIV ANTEBI
 * An interface of HitNotifier
 * The interface of the hit notifier
 */
public interface HitNotifier {
    /**
     * addHitListener - Add hl as a listener to hit events.
     * @param hl - a hit listener to add
     */
    void addHitListener(HitListener hl);

    /**
     * removeHitListener - Remove hl from the list of listeners to hit events.
     * @param hl - the hit listener to remove
     */
    void removeHitListener(HitListener hl);
}
