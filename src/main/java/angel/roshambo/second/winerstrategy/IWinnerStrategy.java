/*
 * Second RoShamBo
 * Creado el 28-jul-2020 a las 19:04:02
 */
package angel.roshambo.second.winerstrategy;

/**
 * <strong>IWinnerStrategy</strong> Methods to implement for searching winnwer
 * <p>We have several ways looking for winner</p>
 * <ul>
 * <li>The Rock One thats compares from Rock</li>
 * <li>The Paper One that makes it from Paper</li>
 * <li>And the Scissor way</li>
 * </ul>
 * <p>Note that now we can add new states to our moves</p>
 * @author Angel
 */
public interface IWinnerStrategy {
    /**
     * <strong>isWinner</strong> Method to calculate from the correct strategy
     * @param second Second player move
     * @return The Winner in String Format
     */
    public String isWinner(String second);
}
