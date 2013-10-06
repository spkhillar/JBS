package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.Payment;
import com.service.PaymentService;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/admin")
public class PaymentController extends BaseAuthenticatedController {

  @Autowired
  private PaymentService paymentService;

  @RequestMapping(value = "/update/payment/{id}", method = RequestMethod.GET)
  public String updatePaymentRecord(@PathVariable final long id, final ModelMap map) {
    paymentService.updatePaymentDate(id);
    return "payment.list";
  }

  @RequestMapping(value = "/payment/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<Payment> paymentRecords(@RequestParam("_search") final Boolean search,
      @RequestParam(value = "filters", required = false) final String filters,
      @RequestParam(value = "page", required = false) final Integer page,
      @RequestParam(value = "rows", required = false) final Integer rows,
      @RequestParam(value = "sidx", required = false) final String sidx,
      @RequestParam(value = "sord", required = false) final String sord) {
    Page<Payment> payment = null;
    if (search == true) {
      payment = paymentService.findAll(page, rows, sord, sidx);
    } else {
      payment = paymentService.findAll(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(payment);
    JqGridResponse<Payment> response = new JqGridResponse<Payment>();
    response.setRows(list);
    response.setRecords(Long.valueOf(payment.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(payment.getTotalPages()).toString());
    response.setPage(Integer.valueOf(payment.getNumber() + 1).toString());
    return response;
  }

}
