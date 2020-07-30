/*
 * Second RoShamBo
 * Creado el 26-jul-2020 a las 10:15:57
 */
package angel.roshambo.second.enums;

/**
 * <strong>ResultEnum</strong> Enumerated that describes end-game status.
 * <p>It represents the way game has ended.<br>Extends {@link java.lang.Enum}</p>
 * <ul>
 * <li><b>FIRST</b> - Represents: First gamer wins</li>
 * <li><b>SECOND</b> - Represents: Second gamer wins</li>
 * <li><b>DRAW</b> - Represents: Tied gamers</li>
 * <li><b>UNKOWED</b> - Represents: Unknowed status</li>
 * </ul>
 * @author Angel Montilla
 * @version 0.1
 * @see java.lang.Enum
 * @author Angel
 */
public enum ResultEnum {
    FIRST, SECOND, DRAW, UNKNOWED;
}
