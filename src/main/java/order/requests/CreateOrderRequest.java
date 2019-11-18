package order.requests;

import com.amazonaws.services.dynamodbv2.document.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private String id;
    private String description;
    private List<Item> items;
}
