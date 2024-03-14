import biuoop.DrawSurface;
/**.
 * @author SAGIV ANTEBI
 * A class of Animation
 * The interface of animation
 */
public interface Animation {
    /**.
     * doOneFrame - draw one frame each time
     * @param d - the draw surface
     */
    void doOneFrame(DrawSurface d);

    /**.
     * shouldStop - indicates when to stop the animation
     * @return - false if need to stop | ture otherwise
     */
    boolean shouldStop();
}
