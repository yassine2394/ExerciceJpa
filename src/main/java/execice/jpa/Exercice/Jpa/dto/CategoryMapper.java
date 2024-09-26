package execice.jpa.Exercice.Jpa.dto;

import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> categoriesToCategoryDTOs(List<Category> categories);
}

