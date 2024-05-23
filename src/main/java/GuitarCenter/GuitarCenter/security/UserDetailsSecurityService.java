
package GuitarCenter.GuitarCenter.security;


import GuitarCenter.GuitarCenter.model.Customer;
import GuitarCenter.GuitarCenter.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurityService implements UserDetailsService {
    CustomerRepository customerRepository;

    public UserDetailsSecurityService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Customer customer = customerRepository.findByEmail(username);
            if (customer == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return User.withUsername(username).password(customer.getPassword()).build();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
