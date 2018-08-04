package externo.soap.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import externo.soap.model.Plan;
import externo.soap.model.ProveedorTelefonia;
import externo.soap.repository.TelefoniaRepository;

@Repository("telefoniaRepository")
public class TelefoniaRepositoryImpl implements TelefoniaRepository {

    public List<ProveedorTelefonia> obtenerProveedoresTelefonia() {

        List<ProveedorTelefonia> list = new ArrayList<>();
        ProveedorTelefonia proveedor1 = new ProveedorTelefonia();
        ProveedorTelefonia proveedor2 = new ProveedorTelefonia();
        ProveedorTelefonia proveedor3 = new ProveedorTelefonia();

        proveedor1.setNombre("TELMEX");
        proveedor2.setNombre("AT&T");
        proveedor3.setNombre("MAXCOM");

        proveedor1.setDireccion("CDMX");
        proveedor2.setDireccion("CDMX");
        proveedor3.setDireccion("CDMX");

        Plan plan = new Plan();
        plan.setNombre("HOGAR");
        plan.setCosto("6000");
        plan.setReferencia("TEL0019012");
        plan.setTasaFija(true);

        Plan plan2 = new Plan();
        plan2.setNombre("NEGOCIO");
        plan2.setCosto("15000");
        plan2.setReferencia("TEL0021010");
        plan2.setTasaFija(true);

        Plan plan3 = new Plan();
        plan3.setNombre("PERSONAL");
        plan3.setCosto("230");
        plan3.setReferencia("TEL0030000");
        plan3.setTasaFija(false);

        Plan plan4 = new Plan();
        plan4.setNombre("AT&T Ya!");
        plan4.setCosto("3000");
        plan4.setReferencia("ATT0000012");
        plan4.setTasaFija(true);

        Plan plan5 = new Plan();
        plan5.setNombre("AT&T Negocios");
        plan5.setCosto("15400");
        plan5.setReferencia("ATT0000092");
        plan5.setTasaFija(true);

        Plan plan6 = new Plan();
        plan6.setNombre("Premium");
        plan6.setCosto("2000");
        plan6.setReferencia("1230930932");
        plan6.setTasaFija(true);

        proveedor1.getPlan().add(plan);
        proveedor1.getPlan().add(plan2);
        proveedor1.getPlan().add(plan3);
        proveedor2.getPlan().add(plan4);
        proveedor2.getPlan().add(plan5);
        proveedor3.getPlan().add(plan6);

        list.add(proveedor1);
        list.add(proveedor2);
        list.add(proveedor3);

        return list;
    }

}
