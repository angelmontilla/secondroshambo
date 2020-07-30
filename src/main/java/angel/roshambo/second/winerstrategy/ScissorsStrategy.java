/*
 * Second RoShamBo
 * Creado el 28-jul-2020 a las 19:22:31
 */
package angel.roshambo.second.winerstrategy;

/**
 * <strong>ScissorsStrategy</strong> Is the Strategy for knowing winner from Scissors
 * <p>Following S,O from SOLID</p>
 * <p>Note: uncople classes</p>
 * @author Angel
 */
public class ScissorsStrategy implements IWinnerStrategy {

    /**
     * <strong>isWinner</strong> Determinates winner in a Scissors way
     * @param second the second player move
     * @return the winner
     */
    @Override
    public String isWinner(String second) {
        String sRes = "DRAW";
        
        if (second.toUpperCase().equals("ROCK")) {
            sRes = "SECOND";
        } else {
            if (second.toUpperCase().equals("PAPER")) {
                sRes = "FIRST";
            } else {
                if (!second.toUpperCase().equals("SCISSORS")) {
                    sRes = "UNKNOWED";
                }
            }
        }
        
        return sRes;
    }
    
}
