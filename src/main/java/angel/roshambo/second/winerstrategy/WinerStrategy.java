/*
 * Second RoShamBo
 * Creado el 27-jul-2020 a las 22:43:33
 */
package angel.roshambo.second.winerstrategy;

/**
 * <strong>WinerStrategy</strong> Following SOLID pattern we area going to <br>uncople
 * Round and RoundResult classes.
 * <p>This class after a TDD process will be translated to an Strategy design pattern</p>
 * @author Angel
 */
public class WinerStrategy {

    /* NO JAVADOC
     * Interface for winner strategy
     */
    private IWinnerStrategy iWinnerStrategy;
    
    /**
     * <strong>Context</strong> Set strategy for determining the winner
     * <p>Set the way for determinate winner</p>
     * @param iWinnerStrategy
     */
    public void Context(IWinnerStrategy iWinnerStrategy) {
        this.iWinnerStrategy = iWinnerStrategy;
    }
    
    /**
     * <strong>executeStrategy</strong> Run correct strategy
     * <p>Executing the strategy we'll get the winner</p>
     * @param second String of move
     * @return String of winner in strategicall solution
     */
    public String executeStrategy(String second) {
        return iWinnerStrategy.isWinner(second);
    }
}
