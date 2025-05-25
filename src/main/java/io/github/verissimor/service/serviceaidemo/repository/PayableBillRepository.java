package io.github.verissimor.service.serviceaidemo.repository;

import io.github.verissimor.service.serviceaidemo.entities.PayableBill;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PayableBillRepository {
  private static final List<PayableBill> bills = new ArrayList<>();
  private final List<PayableBill> initialBills = new ArrayList<>(bills);

  public long getMaxId() {
    return bills.stream()
            .map(PayableBill::id)
            .filter(Objects::nonNull)
            .max(Long::compareTo)
            .orElse(1L);
  }

  public List<PayableBill> listBills() {
    return List.copyOf(bills);
  }

  public PayableBill createBill(PayableBill bill) {
    bills.add(bill);
    return bill;
  }

  public void resetBills() {
    bills.clear();
    bills.addAll(initialBills);
  }
}
