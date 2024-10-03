package com.triana.salesianos.dam.bares.initData;

import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.models.Tag;
import com.triana.salesianos.dam.bares.repository.BarRepository;
import com.triana.salesianos.dam.bares.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {
    private final BarRepository baresRepository;
    private final TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {
        Tag tag1 = new Tag();
        tag1.setNombre("Cañas");
        Tag tag2 = new Tag();
        tag2.setNombre("Chicharrones");
        tagRepository.saveAll(Set.of(tag1, tag2));


        Bar bar1 = new Bar();
        bar1.setNombre("Bar Paleta");
        bar1.setDireccion("Calle Evangelista 69-71");
        bar1.setLatitud(40.416775);
        bar1.setLongitud(-3.703790);
        bar1.setDescripcion("Un bar con auténtica esencia. Se aferran a la calidad con uñas y dientes.");
        bar1.setTag(tag1);
        bar1.setTag(tag2);
        bar1.setUrlImagen("http://example.com/paleta.jpg");
        baresRepository.save(bar1);


        Bar bar2 = new Bar();
        bar2.setNombre("Tasca Triana");
        bar2.setDireccion("Calle Evangelista, 73A");
        bar2.setLatitud(19.432608);
        bar2.setLongitud(-99.133209);
        bar2.setDescripcion("Un bar con auténtica cerveza de barril. Lugar perfecto para una '¡caña aquí!'");
        bar2.setTag(tag1);
        bar2.setUrlImagen("http://example.com/tasca.jpg");
        baresRepository.save(bar2);


        Bar bar3 = new Bar();
        bar3.setNombre("Max & Henry");
        bar3.setDireccion("Calle Mirador de Montepinar, 7");
        bar3.setLatitud(40.456123);
        bar3.setLongitud(-3.678456);
        bar3.setDescripcion("El bar de Max y Henry, conocido por sus tapas y ambiente acogedor.");
        bar3.setTag(tag1);
        bar3.setTag(tag2);
        bar3.setUrlImagen("http://example.com/maxhenry.jpg");
        baresRepository.save(bar3);


    }

}
