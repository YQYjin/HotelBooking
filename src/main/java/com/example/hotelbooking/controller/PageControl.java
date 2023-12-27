package com.example.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControl {
    @RequestMapping("/index")
    public String toindex() {

        return "index";
    }
    @RequestMapping("/employee_sign")
    public String toemployee() {

        return "employee_sign";
    }
    @RequestMapping("/administrators_sign")
    public String toadmin() {

        return "administrators_sign";
    }
    @RequestMapping("/user-register")
    public String toregister() {

        return "user-register";
    }
    @RequestMapping("/user_home")
    public String touserhome() {

        return "user_home";
    }
    @RequestMapping("/administrators_home")
    public String toadminhome() {

        return "administrators_home";
    }
    @RequestMapping("/employee_home")
    public String toemployeehome() {

        return "employee_home";
    }
    @RequestMapping("/checkout")
    public String tocheckout() {

        return "/user_html/checkout";
    }
    @RequestMapping("/credit-card")
    public String tocreditcard() {

        return "/user_html/credit-card";
    }
    @RequestMapping("/email")
    public String toemail() {

        return "/user_html/email";
    }@RequestMapping("/hotel")
    public String tohotel() {

        return "/user_html/hotel";
    }@RequestMapping("/reservation")
    public String toreservation() {

        return "/user_html/reservation";
    }@RequestMapping("/generate_penalty")
    public String togenerate_penalty() {

        return "/employee_html/generate_penalty";
    }@RequestMapping("/generate_report")
    public String togenerate_report() {

        return "/employee_html/generate_report";
    }@RequestMapping("/manage_reservations")
    public String tomanage_reservations() {

        return "/employee_html/manage_reservations";
    }@RequestMapping("/send_email")
    public String tosend_email() {

        return "/employee_html/send_email";
    }@RequestMapping("/price_adjustment")
    public String toprice_adjustment() {

        return "/administrators_html/price_adjustment";
    }@RequestMapping("/print_report")
    public String toprint_report() {

        return "/administrators_html/print_report";
    }

}
