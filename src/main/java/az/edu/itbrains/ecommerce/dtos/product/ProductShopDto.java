package az.edu.itbrains.ecommerce.dtos.product;

import az.edu.itbrains.ecommerce.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductShopDto {
    private Long id;
    private String name;
    private Float price;
    private String shortDescription;
    private Float discountPrice;
    private String photoUrl;
    private CategoryDto category;
}
