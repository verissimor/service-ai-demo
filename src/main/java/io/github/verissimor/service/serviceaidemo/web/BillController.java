package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.entities.PayableBill;
import io.github.verissimor.service.serviceaidemo.service.AgentService;
import io.github.verissimor.service.serviceaidemo.service.ParseUrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {

  private final ParseUrlService parseUrlService;
  private final AgentService agentService;

  public BillController(ParseUrlService parseUrlService, AgentService agentService) {
    this.parseUrlService = parseUrlService;
    this.agentService = agentService;
  }

  @GetMapping("/bills/parse")
  public List<PayableBill> parseUrl(@RequestParam String url) {
    return parseUrlService.parseUrl(url);
  }

  @GetMapping("/bills/agent")
  public List<PayableBill> useAgent(@RequestParam String url) {
    return agentService.useMcp(url);
  }
}
