package app.recipes.entity;

import lombok.Data;

@Data
public class Recipe {
    private Long id;
    private String name;
    private String image;
    private String description;
    private String category;
    private Long frequency;
    private Chat chat;

}
