package tn.esprit.spring;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;
import tn.esprit.spring.services.IVoyageurService;
import tn.esprit.spring.services.VoyageurServiceImpl;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class VoyageurServiceImplTest {

    @Autowired
    private IVoyageurService voyageurService;

    @Mock
    private VoyageurRepository voyageurRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        voyageurService = new VoyageurServiceImpl();
    }

    @Test
    public void testAjouterVoyageur() {
        Voyageur voyageur = new Voyageur();
        // Set the properties of voyageur

        voyageurService.ajouterVoyageur(voyageur);

        Mockito.verify(voyageurRepository).save(voyageur);
    }

    @Test
    public void testModifierVoyageur() {
        Voyageur voyageur = new Voyageur();
        // Set the properties of voyageur

        voyageurService.modifierVoyageur(voyageur);

        Mockito.verify(voyageurRepository).save(voyageur);
    }

    @Test
    public void testRecupererAll() {
        List<Voyageur> voyageurList = new ArrayList<>();
        // Add some test data to voyageurList

        Mockito.when(voyageurRepository.findAll()).thenReturn(voyageurList);

        List<Voyageur> result = voyageurService.recupererAll();

        Assertions.assertEquals(voyageurList, result);
    }

    @Test
    public void testRecupererVoyageParId() {
        long idVoyageur = 1L;
        // Create a test voyageur with the given id
        Voyageur voyageur = new Voyageur();
        voyageur.setIdVoyageur(idVoyageur);

        Mockito.when(voyageurRepository.findById(idVoyageur)).thenReturn(java.util.Optional.of(voyageur));

        Voyageur result = voyageurService.recupererVoyageParId(idVoyageur);

        Assertions.assertEquals(voyageur, result);
    }

    @Test
    public void testSupprimerVoyageur() {
        Voyageur voyageur = new Voyageur();
        // Set the properties of voyageur

        voyageurService.supprimerVoyageur(voyageur);

        Mockito.verify(voyageurRepository).delete(voyageur);
    }
}
