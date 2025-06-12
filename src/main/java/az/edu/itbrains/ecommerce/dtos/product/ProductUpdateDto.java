package az.edu.itbrains.ecommerce.dtos.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {
    private String name;
    private String shortDescription;
    private String description;
    private Float price;
    private Float discountPrice;
    private String photoUrl;
    private int quantity;
    private Long categoryId;
}
