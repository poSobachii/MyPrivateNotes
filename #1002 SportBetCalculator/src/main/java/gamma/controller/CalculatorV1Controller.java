package gamma.controller;

import gamma.entity.SimpleRecordDTO;
import gamma.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class CalculatorV1Controller {

    @Autowired
    SomeService someService;

    @GetMapping("/calculation")
    public String main(SimpleRecordDTO recordDto) {

        return "calculateV1";
    }

    @PostMapping("/calculation")
    public String addRecord(SimpleRecordDTO recordDto){
        return "calculateV1";
    }
}
