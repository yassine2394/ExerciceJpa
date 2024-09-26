package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.dto.CategoryDTO;
import execice.jpa.Exercice.Jpa.dto.CategoryMapper;
import execice.jpa.Exercice.Jpa.repo.production.categories.CategoriesRepo;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoriesRepo categoryRepo;
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        return categoryMapper.categoryToCategoryDTO(categoryRepo.save(category));
    }

    public CategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
        if (!categoryRepo.existsById(id)) {
            return null;
        }
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        category.setCategoryId(id);
        return categoryMapper.categoryToCategoryDTO(categoryRepo.save(category));
    }

    public void deleteCategory(int categoryId) {
        categoryRepo.deleteById(categoryId);
    }

    public CategoryDTO getCategoryById(int categoryId) {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
        return categoryOptional.map(categoryMapper::categoryToCategoryDTO).orElse(null);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categoryMapper.categoriesToCategoryDTOs(categories);
    }
}
