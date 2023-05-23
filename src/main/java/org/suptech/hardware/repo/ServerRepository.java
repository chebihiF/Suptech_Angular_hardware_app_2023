package org.suptech.hardware.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.suptech.hardware.model.Server;

public interface ServerRepository extends JpaRepository<Server, Long> {

    Server findByIpAddress(String address);
}
