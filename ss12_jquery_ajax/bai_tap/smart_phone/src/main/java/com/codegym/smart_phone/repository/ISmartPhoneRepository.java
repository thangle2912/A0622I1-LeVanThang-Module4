package com.codegym.smart_phone.repository;

import com.codegym.smart_phone.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone,Integer> {

}
