/*
 * Second RoShamBo
 * Creado el 28-jul-2020 a las 19:08:27
 */
package angel.roshambo.second.winerstrategy;

/**
 * <strong>RockStrategy</strong> Is the Strategy for know winner from Rock
 * <p>Following S,O from SOLID</p>
 * <p>Note: uncople classes</p>
 * @author Angel
 */
public class RockStrategy implements IWinnerStrategy{

    /**
     * <strong>isWinner</strong> Determinates winner in a Rock way
     * @param second the second player move
     * @return the winner
     */
    @Override
    public String isWinner(String second) {
        String sRes = "DRAW";
        
        if (second.toUpperCase().equals("PAPER")) {
            sRes = "SECOND";
        } else {
            if (second.toUpperCase().equals("SCISSORS")) {
                sRes = "FIRST";
            } else {
                if (!second.toUpperCase().equals("ROCK")) {
                    sRes = "UNKNOWED";
                }
            }
        }
        
        return sRes;
    }    
}
