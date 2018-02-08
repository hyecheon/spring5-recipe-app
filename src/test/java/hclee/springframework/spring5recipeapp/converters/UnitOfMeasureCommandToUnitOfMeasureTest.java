package hclee.springframework.spring5recipeapp.converters;

import hclee.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import hclee.springframework.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String Description = "description";
    public static final Long LongValue = 1L;
    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullParamter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        //given
        final UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LongValue);
        command.setDescription(Description);

        //when
        final UnitOfMeasure uom = converter.convert(command);
        //then
        assertNotNull(uom);
        assertEquals(LongValue, uom.getId());
        assertEquals(Description, uom.getDescription());

    }
}