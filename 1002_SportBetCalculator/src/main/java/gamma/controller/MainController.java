package gamma.controller;

import gamma.entity.BettingStrategyDTO;
import gamma.entity.DataRecord;
import gamma.entity.DataRecordDTO;
import gamma.service.RecordService;
import gamma.service.StrategyService;
import gamma.trash.BetLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    RecordService recordService;
    @Autowired
    StrategyService strategyService;

    @GetMapping()
    public String main() {
        return "home";
    }

    @GetMapping("/calculation/live")
    public String main(Model model, DataRecordDTO recordDto, BettingStrategyDTO bettingStrategyDTO) {
        model.addAttribute("date", recordService.getDate());
        model.addAttribute("links", BetLink.betLinks);
        model.addAttribute("records", recordService.getAllOpenedRecords());
        model.addAttribute("record", new DataRecord());
        model.addAttribute("strategies", strategyService.getAllStrategies());
        return "calculateV1";
    }

    @PostMapping("/addRecord")
    public String addRecord(DataRecordDTO recordDto){
        recordService.addNewRecord(recordDto);
        return "redirect:/calculation/live";
    }

    @PostMapping("/addStrategy")
    public String addStrategy(BettingStrategyDTO bettingStrategyDTO){
        strategyService.addNewStrategy(bettingStrategyDTO);
        return "redirect:/calculation/live";
    }

    @PostMapping("/proceed/{path}")
    public String proceed(@PathVariable Long path, @RequestParam Integer result){
        recordService.proceedResult(path, result);
        return "redirect:/calculation/live";
    }

    @PostMapping("/calculate/{path}")
    public String calculateBet(@PathVariable Long path){
        recordService.calculateBet(path);
        return "redirect:/calculation/live";
    }

    @PostMapping("/delete/{path}")
    public String delete(@PathVariable Long path){
        recordService.deleteRecord(path);
        return "redirect:/calculation/live";
    }

    @PostMapping("/deletestr/{path}")
    public String deleteStrategy(@PathVariable Long path){
        strategyService.deleteStrategy(path);
        return "redirect:/calculation/live";
    }

    @PostMapping("/hide/{path}")
    public String hideBet(@PathVariable Long path){
        recordService.hideRecord(path);
        return "redirect:/calculation/live";
    }


}
