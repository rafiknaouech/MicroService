package com.esprit.microservices.gestionstock.Controlleur;


import com.esprit.microservices.gestionstock.Entity.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockitems")


public class StockRestAPI {
    private String title = "Hello,i'm the stock micro service";

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;

    }

    @Autowired
    private com.esprit.microservices.gestionstock.Service.StockItemService StockItemService;

    @GetMapping("/{id}")
    public ResponseEntity<StockItem> getStockItemById(@PathVariable Long id) {
        StockItem stockItem = StockItemService.getStockItemById(id);

        if (stockItem != null) {
            return new ResponseEntity<>(stockItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getallStocks")
    public List<StockItem> getAllStocks() {
        return StockItemService.getAllStocks();
    }

   /* @GetMapping("")
    public List<StockItem> getbyidStocks(@PathVariable Long id) {
        return StockItemService.getbyidStocks();
    }*/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StockItem> createStockItem (@RequestBody StockItem stockItem){
        return new ResponseEntity<>(StockItemService.addStockItem(stockItem), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<StockItem> updateStockItem (@PathVariable(value = "id") Long id,
                                                      @RequestBody StockItem stockItem){
        return new ResponseEntity<>(StockItemService.updateStockItem(id, stockItem), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStockItem (@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(StockItemService.deleteStockItem(id), HttpStatus.OK);
    }


    @GetMapping("/search/stockItemBynomProduit")
    public ResponseEntity<List<StockItem>> getStockItemsByNomProduit(@RequestParam String name) {
        List<StockItem> stockItems = StockItemService.getStockItemsByNomProduit(name);

        if (!stockItems.isEmpty()) {
            return new ResponseEntity<>(stockItems, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } //http://localhost:8080/stockitems/search/stockItemBynomProduit?name=yourProductName
    }


}

