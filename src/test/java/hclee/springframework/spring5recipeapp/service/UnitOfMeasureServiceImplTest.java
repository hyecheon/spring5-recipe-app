package hclee.springframework.spring5recipeapp.service;

import hclee.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import hclee.springframework.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import hclee.springframework.spring5recipeapp.domain.UnitOfMeasure;
import hclee.springframework.spring5recipeapp.repository.UnitOfMeasureRepository;
import hclee.springframework.spring5recipeapp.services.UnitOfMeasureService;
import hclee.springframework.spring5recipeapp.services.UnitOfMeasureServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UnitOfMeasureServiceImplTest {
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    private UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUomsTest() {
        List<UnitOfMeasure> unitOfMeasures = new LinkedList<>();
        final UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);
        final UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        final Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }
}