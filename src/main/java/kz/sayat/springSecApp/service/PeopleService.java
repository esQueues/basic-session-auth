    package kz.sayat.springSecApp.service;

    import jakarta.transaction.Transactional;
    import kz.sayat.springSecApp.models.Person;
    import kz.sayat.springSecApp.repo.PeopleRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    @Service
    public class PeopleService {
        private final PeopleRepository peopleRepository;

        private final PasswordEncoder passwordEncoder;


        @Autowired
        public PeopleService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
            this.peopleRepository = peopleRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Transactional
        public void register(Person person) {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
            person.setRole("ROLE_USER");
            peopleRepository.save(person);
        }

    }
