package hclee.springframework.spring5recipeapp.service;

import hclee.springframework.spring5recipeapp.domain.Recipe;
import hclee.springframework.spring5recipeapp.repository.RecipeRepository;
import hclee.springframework.spring5recipeapp.services.ImageService;
import hclee.springframework.spring5recipeapp.services.ImageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;


import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ImageServiceImplTest {
    @Mock
    RecipeRepository recipeRepository;
    ImageService imageService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.imageService = new ImageServiceImpl(recipeRepository);
    }

    @Test
    public void saveImageFile() throws IOException {
        final MockMultipartFile multipartFile = new MockMultipartFile("imagefile", "test.txt", "text/plain", "Spring Framework".getBytes());
        final Recipe recipe = new Recipe();
        recipe.setId(1L);
        final Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        final ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);

        imageService.saveImageFile(1L, multipartFile);

        verify(recipeRepository, times(1)).save(argumentCaptor.capture());
        final Recipe saveRecipe = argumentCaptor.getValue();
        assertEquals(multipartFile.getBytes().length, saveRecipe.getImage().length);
    }
}