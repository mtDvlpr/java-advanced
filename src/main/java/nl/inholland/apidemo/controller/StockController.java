package nl.inholland.apidemo.controller;

import nl.inholland.apidemo.model.Stock;
import nl.inholland.apidemo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stocks")
public class StockController {

  @Autowired
  private StockService stockService;

  @GetMapping
  public ResponseEntity<List<Stock>> getAllStocks() {
    return new ResponseEntity<>(stockService.getAllStock(), HttpStatus.OK);
  }
}
