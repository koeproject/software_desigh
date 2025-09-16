package com.lab8;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest req) {
        Customer saved = repo.save(new Customer(req.getName(), req.getEmail()));
        return ResponseEntity.ok(CustomerResponse.fromEntity(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
        return repo.findById(id)
            .map(CustomerResponse::fromEntity)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CustomerResponse> getAll() {
        return repo.findAll().stream()
                   .map(CustomerResponse::fromEntity)
                   .toList();
    }
}

