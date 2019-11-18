package order.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import order.models.Order;
import order.requests.CreateOrderRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/v1")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Post("/order")
    public HttpResponse createOrder(@Body CreateOrderRequest orderRequest) {
        LOGGER.info("create order request received: {}", orderRequest);
        ModelMapper modelMapper = getModelMapper();
        Order order = modelMapper.map(orderRequest, Order.class);
        return HttpResponse.created(order);
    }

    private ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
