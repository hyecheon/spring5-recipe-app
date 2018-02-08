package hclee.springframework.spring5recipeapp.converters;

import hclee.springframework.spring5recipeapp.commands.CategoryCommand;
import hclee.springframework.spring5recipeapp.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final Long IdValue = 1L;
    public static final String Description = "description";
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        //given
        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(IdValue);
        categoryCommand.setDescription(Description);

        //when
        final Category category = converter.convert(categoryCommand);

        //then
        assertEquals(IdValue, category.getId());
        assertEquals(Description, category.getDescription());
    }
}