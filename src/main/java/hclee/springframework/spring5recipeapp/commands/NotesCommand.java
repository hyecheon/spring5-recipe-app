package hclee.springframework.spring5recipeapp.commands;

import hclee.springframework.spring5recipeapp.domain.Recipe;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private String recipeNotes;

}