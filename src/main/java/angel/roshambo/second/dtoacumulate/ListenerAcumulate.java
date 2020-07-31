/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 1:41:51
 */
package angel.roshambo.second.dtoacumulate;

/**
 *
 * @author Angel
 */
public interface ListenerAcumulate {
    void OnData(DtoAcumulate event);
    void processComplete();
}
