package az.edu.itbrains.ecommerce.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PaginationPayload<TModel> {
    private List<TModel> models;
    private int currentPage;
    private int totalPage;
}
