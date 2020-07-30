/*
 * Second RoShamBo
 * Creado el 26-jul-2020 a las 10:15:57
 */
package angel.roshambo.second.enums;

/**
 * <strong>RoundValue</strong> Enumerated that describes Round valid values.
 * <p>It represents the diferents options a gamer can take.<br>Extends {@link java.lang.Enum}</p>
 * <p>Allowed values</p>
 * <ul>
 * <li><b>ROCK</b> - Represents: Rock move option</li>
 * <li><b>PAPER</b> - Represents: Paper move option</li>
 * <li><b>SCISSORS</b> - Represents: Scissors move option</li>
 * <li><b>UNKNOWN</b> - Represents: Indeterminated state</li>
 * </ul>
 * @author Angel Montilla
 * @version 0.1
 * @see java.lang.Enum
 */
public enum MoveEnum {
    ROCK, PAPER, SCISSORS, UNKNOWN;
}
