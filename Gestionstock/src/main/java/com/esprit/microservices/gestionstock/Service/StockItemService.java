package com.esprit.microservices.gestionstock.Service;


import com.esprit.microservices.gestionstock.Entity.StockItem;
import com.esprit.microservices.gestionstock.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockItemService {
    @Autowired
    private StockRepository stockItemRepository;

    public List<StockItem> getAllStocks() {
        return stockItemRepository.findAll();
    }
   /* public List<StockItem>getbyidStocks() {

        return stockItemRepository.findById();
    }*/

    public StockItem addStockItem(StockItem stockItem) {
        return stockItemRepository.save(stockItem);
    }

    public StockItem updateStockItem(Long id, StockItem newStockItem) {
        if (stockItemRepository.findById(id).isPresent()) {
            StockItem existingStockItem = stockItemRepository.findById(id).get();
            existingStockItem.setNomProduit(newStockItem.getNomProduit());
            existingStockItem.setQuantiteEnStock(newStockItem.getQuantiteEnStock());
            existingStockItem.setQuantiteMinimale(newStockItem.getQuantiteMinimale());
            existingStockItem.setPrixUnitaire(newStockItem.getPrixUnitaire());
            return stockItemRepository.save(existingStockItem);
        } else
            return null;
    }

    public String deleteStockItem(Long id) {
        if (stockItemRepository.findById(id).isPresent()) {
            stockItemRepository.deleteById(id);
            return "Article en stock supprimé";
        } else
            return "Article en stock non supprimé";
    }
    public StockItem getStockItemById(Long id) {
        return stockItemRepository.findById(id).orElse(null);
    }
    public List<StockItem> getStockItemsByNomProduit(String nomProduit) {
        return stockItemRepository.stockItemBynomProduit(nomProduit, PageRequest.of(0, 10)).getContent();
    }

}
