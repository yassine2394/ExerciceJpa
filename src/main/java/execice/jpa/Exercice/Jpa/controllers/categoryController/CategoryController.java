package execice.jpa.Exercice.Jpa.controllers.categoryController;

import execice.jpa.Exercice.Jpa.controllers.payloads.CategoryPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.CategoryDTO;
import execice.jpa.Exercice.Jpa.services.categoryService.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/category")
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Gestion de categories
    @PostMapping("/create")
    public CategoryDTO createCategory(@Valid @RequestBody CategoryPayload payload){
        CategoryDTO categoryDTO = categoryService.CreateCategory(payload);
        return  categoryDTO;
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable int id){
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return categoryDTO;
    }

    @GetMapping("/all")
    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> dto = categoryService.getAllCategory();
        return dto;
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@Valid @PathVariable int id, @RequestBody CategoryPayload payload){
        CategoryDTO dto = categoryService.updateCategory(id, payload);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }


}
