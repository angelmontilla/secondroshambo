/*
 * First RoShamBo
 * Creado el 28-jul-2020 a las 19:15:59
 */
package angel.roshambo.second.winerstrategy;

/**
 * <strong>PaperStrategy</strong> Is the Strategy for knowing winner from Paper
 * <p>Following S,O from SOLID</p>
 * <p>Note: uncople classes</p>
 * @author Angel
 */
public class PaperStrategy implements IWinnerStrategy {

    /**
     * <strong>isWinner</strong> Determinates winner in a Paper way
     * @param second the second player move
     * @return the winner
     */    
    @Override
    public String isWinner(String second) {
        String sRes = "DRAW";
        
        if (second.toUpperCase().equals("SCISSORS")) {
            sRes = "SECOND";
        } else {
            if (second.toUpperCase().equals("ROCK")) {
                sRes = "FIRST";
            } else {
                if (!second.toUpperCase().equals("PAPER")) {
                    sRes = "UNKNOWED";
                }
            }
        }
        
        return sRes;
    }
    
}
