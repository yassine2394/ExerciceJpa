package execice.jpa.Exercice.Jpa.services.categoryService;

import execice.jpa.Exercice.Jpa.controllers.payloads.CategoryPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.CategoryDTO;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.CategoryMapper;
import execice.jpa.Exercice.Jpa.repo.production.categories.CategoriesRepo;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import execice.jpa.Exercice.Jpa.repo.production.products.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {


    @Autowired
    private CategoriesRepo categoriesRepo;

    private  final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    // Gestion de Category
    public CategoryDTO CreateCategory(CategoryPayload payload){
        Category category = categoryMapper.toEntity(payload);
        category = categoriesRepo.save(category);
        return categoryMapper.toDTO(category);
    }

    public CategoryDTO getCategoryById(int id){
        Category category = categoriesRepo.findByCategoryId(id);
        return categoryMapper.toDTO(category);
    }

    public List<CategoryDTO> getAllCategory(){
        List<Category> categories = categoriesRepo.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());


    }

    public CategoryDTO updateCategory(int id, CategoryPayload payload){
        Category category = categoriesRepo.findByCategoryId(id);

        category.setCategoryName(payload.getCategoryName());
        category = categoriesRepo.save(category);
        return categoryMapper.toDTO(category);
    }

    public void deleteCategory(int id){
        Category category = categoriesRepo.findByCategoryId(id);
        categoriesRepo.delete(category);
    }


}
