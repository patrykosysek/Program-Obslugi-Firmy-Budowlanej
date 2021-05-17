package pl.mirbudpol.sklepbudowlany.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.BasketDTO;
import pl.mirbudpol.sklepbudowlany.services.OrderService;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody BasketDTO dto){
        orderService.addOrder(dto);
    }
}
