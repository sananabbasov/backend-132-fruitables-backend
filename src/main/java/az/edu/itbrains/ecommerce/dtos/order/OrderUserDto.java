package az.edu.itbrains.ecommerce.dtos.order;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderUserDto {
    private String address;
    private String city;
    private String postcode;
    private String phoneNumber;
}
