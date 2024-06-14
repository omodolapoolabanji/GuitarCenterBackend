package GuitarCenter.GuitarCenter.controller;

import GuitarCenter.GuitarCenter.model.Customer;
import GuitarCenter.GuitarCenter.repository.CustomerRepository;
import GuitarCenter.GuitarCenter.security.TokenService;
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
    public boolean signup(@RequestBody Customer customer){
        try{
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(password);
            repo.save(customer);
            return true;
        }
        catch(Exception e){
            throw new RuntimeException(e);
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
