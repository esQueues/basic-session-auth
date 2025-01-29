package kz.sayat.springSecApp.service;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doAdminStaff(){
        System.out.println("only admin here");
    }
}
