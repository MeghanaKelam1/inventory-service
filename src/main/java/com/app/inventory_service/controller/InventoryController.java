package com.app.inventory_service.controller;

import com.app.inventory_service.dto.AvailabilityDTO;
import com.app.inventory_service.dto.InventoryDTO;
import com.app.inventory_service.model.Inventory;
import com.app.inventory_service.repo.AvailabilityRepo;
import com.app.inventory_service.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Autowired
    private AvailabilityRepo availabilityRepo;


    //To get the entire inventory stock
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllStock() {
        List<Inventory> stockList = inventoryService.getAllStock();
        return ResponseEntity.ok(stockList);
    }

    //To post a stock in inventory
    @PostMapping
    public ResponseEntity<String> addStock(@RequestBody @Valid InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory(inventoryDTO.getProductId(), inventoryDTO.getQuantity());
        inventoryService.addStock(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body("Stock added successfully");
    }

    //to get a stock quantity
    @GetMapping("{productId}")
    public ResponseEntity<Integer> getStockQuantity(@PathVariable Long productId) {
        Integer count = inventoryService.getStockQuantity(productId);
        return ResponseEntity.ok(count);
    }

    //To get the delivery details
    @GetMapping("availability/{productId}/{requestedQuantity}")
    public ResponseEntity<AvailabilityDTO> getAvailability(
            @PathVariable Long productId,
            @PathVariable Integer requestedQuantity) {

        AvailabilityDTO dto = inventoryService.getAvailabilityDetails(productId, requestedQuantity);

        if (dto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok(dto);
    }
    @GetMapping("/details/{productId}")
    public ResponseEntity<InventoryDTO> getInventoryDetails(@PathVariable Long productId) {
        InventoryDTO dto = inventoryService.getInventoryDetails(productId);
        return ResponseEntity.ok(dto);
    }

}

