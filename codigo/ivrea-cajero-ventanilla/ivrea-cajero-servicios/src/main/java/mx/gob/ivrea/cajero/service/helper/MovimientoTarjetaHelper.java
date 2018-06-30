package mx.gob.ivrea.cajero.service.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.gob.ivrea.api.model.MovimientoTarjeta;
import mx.gob.ivrea.base.BaseAssembler;
import mx.gob.ivrea.base.BaseHelper;
import mx.gob.ivrea.constants.FormatosConstants;

@Component("movimientoTarjetaHelper")
public class MovimientoTarjetaHelper extends BaseHelper
        implements BaseAssembler<List<Object[]>, List<MovimientoTarjeta>> {

    @Override
    public List<MovimientoTarjeta> aModel(List<Object[]> entrada) {
        if (entrada != null && !entrada.isEmpty()) {
            logger.info("Numero de registros a procesar: '[{}]",entrada.size());
            List<MovimientoTarjeta> movimientos = new ArrayList<MovimientoTarjeta>();
            for (int cont = 0; cont < entrada.size(); cont++) {
                MovimientoTarjeta movTarjeta = new MovimientoTarjeta();
                Object[] movEntity = entrada.get(cont);
                movTarjeta.setConcepto(movEntity[0].toString());
                movTarjeta.setCantidad(agregandoPesos(movEntity[1].toString()));
                movTarjeta.setFecha(
                        this.convertirDate((Date) movEntity[2], FormatosConstants.FORMATO_FECHA_ESPANIOL_HORA));
                movimientos.add(movTarjeta);
            }
            return movimientos;
        }
        logger.info("La entrada era null o estaba vacia: [{}]",entrada);
        return new ArrayList<MovimientoTarjeta>();
    }
}
