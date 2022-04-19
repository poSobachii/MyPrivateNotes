package store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import store.service.resolver.ApiResolver;

@RestController
@RequestMapping("/script")
public class UtilityController {

    @Autowired
    ApiResolver apiResolver;

    @PostMapping("/addToBasket")
    public String addToBasket(@RequestParam("itemId") Long itemId) {
        return apiResolver.addItemToBasket(itemId);
    }

    @GetMapping("/getPdf")
    public ResponseEntity<Resource> getPdf() {
        Resource file = apiResolver.getPdfOrder();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
