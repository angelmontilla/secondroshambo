/*
 * Second RoShamBo
 * Creado el 26-jul-2020 a las 10:15:57
 */
package angel.roshambo.second.dtoresult;

import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import angel.roshambo.second.enums.MoveEnum;
import angel.roshambo.second.enums.ResultEnum;

/**
 * <strong>DtoResult</strong> Represents Result of move DTO patter design.
 * @author Angel
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoResult {
    private UUID id;
    private Date date;
    private MoveEnum fPlayer;
    private MoveEnum sPlayer;
    private ResultEnum result;
}
