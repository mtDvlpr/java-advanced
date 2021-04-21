package nl.inholland.apidemo.service;

import nl.inholland.apidemo.model.Stock;
import nl.inholland.apidemo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

  @Autowired
  private StockRepository stockRepository;

  public List<Stock> getAllStock() {
    return (List<Stock>)stockRepository.findAll();
  }

  public Stock addStock(Stock stock) {
    stockRepository.save(stock);
    return stock;
  }
}
