/*
 * Second RoShamBo
 * Creado el 30-jul-2020 a las 19:56:58
 */
package angel.roshambo.second.dtoacumulate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>DtoAcumulate</b> Total counts from all plays
 * <ul>
 * <li>totalRounds - Number of rounds played</li>
 * <li>totalFirstWin - Number of rounds won by first player</li>
 * <li>totalSecondWin - Number of rounds won by second player</li>
 * <li>totalDraws - Number of Draws</li>
 * </ul>
 * @author Angel
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAcumulate {
    private long totalRounds;
    private long totalFirstWin;
    private long totalSecondWin;
    private long totalDraws;
}
