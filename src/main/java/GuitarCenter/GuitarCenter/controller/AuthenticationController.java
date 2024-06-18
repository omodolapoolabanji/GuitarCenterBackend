package GuitarCenter.GuitarCenter.controller;

import GuitarCenter.GuitarCenter.model.Customer;
import GuitarCenter.GuitarCenter.repository.CustomerRepository;
import GuitarCenter.GuitarCenter.security.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class AuthenticationController {
    CustomerRepository repo;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    private AuthenticationController(AuthenticationManager authenticationManager,  TokenService tokenService, CustomerRepository repo){
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.repo = repo;
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Customer customer) {
        try {
            if (repo.existsByEmail(customer.getEmail())) {
                return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(encodedPassword);
            repo.save(customer);
            return new ResponseEntity<>("Signup successful", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/login")
    public String login(@RequestBody Customer customer){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPassword())
        );
        return tokenService.generateToken(authentication);

    }
}
