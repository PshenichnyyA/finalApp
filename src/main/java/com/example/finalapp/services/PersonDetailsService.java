package com.example.finalapp.services;

import com.example.finalapp.models.Person;
import com.example.finalapp.repositories.PersonRepository;
import com.example.finalapp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;


    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Получаем пользователя из таблицы по логину с формы аунтификации
        Optional<Person> person = personRepository.findByLogin(username);
        //Если пользователь не был найден
        if(person.isEmpty()){
            //Исключение, что пользователь не найден
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return new PersonDetails(person.get());
    }
}
