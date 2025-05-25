package io.github.verissimor.service.serviceaidemo.service;

import io.github.verissimor.service.serviceaidemo.entities.PayableBill;
import io.github.verissimor.service.serviceaidemo.repository.PayableBillRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PayableBillService {

  private final PayableBillRepository payableBillRepository;

  public PayableBillService(PayableBillRepository payableBillRepository) {
    this.payableBillRepository = payableBillRepository;
  }

  public List<PayableBill> listBills() {
    return payableBillRepository.listBills();
  }

  @Tool(description = "Create a new payable bill")
  public PayableBill createBill(
          @ToolParam(description = "The description, should be clean and preferable no more than 3 words")
          String description,
          @ToolParam(description = "The date of the bill")
          LocalDate date,
          @ToolParam(description = "Amount to be paid, always greater than 0")
          BigDecimal value,
          @ToolParam(description = "The identifier of the category, must be a valid category")
          Long categoryId,
          @ToolParam(description = "The identifier of the supplier, must be a valid supplier")
          Long supplierId
  ) {
    long newId = payableBillRepository.getMaxId() + 1;
    PayableBill bill = new PayableBill(newId, description, date, value, categoryId, supplierId);
    return payableBillRepository.createBill(bill);
  }
}
