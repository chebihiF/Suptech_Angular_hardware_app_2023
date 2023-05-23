package org.suptech.hardware.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.suptech.hardware.enumeration.Status;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    @NotEmpty(message = "Ip Address cannot be empty or null")
    private String ipAddress;
    private String name ;
    private String memory;
    private String type ;
    private String imageUrl ;
    private Status status ;
}
