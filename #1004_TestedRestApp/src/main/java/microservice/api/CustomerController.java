package microservice.api;

import microservice.dto.customer.CustomerDTO;
import microservice.dto.customer.CustomerRequestDTO;
import microservice.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getOneById(@PathVariable("id") Long id) {
        return customerService.getOneById(id);
    }

    @PostMapping("/{id}")
    public void editById(@PathVariable("id") Long id, @RequestBody CustomerRequestDTO customerRequestDTO) throws Exception {
        customerService.updateById(id, customerRequestDTO);
    }

    @PutMapping("/create")
    public void create(@RequestBody CustomerRequestDTO customerRequestDTO) throws Exception {
        customerService.create(customerRequestDTO);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        customerService.deleteById(id);

    }
}
