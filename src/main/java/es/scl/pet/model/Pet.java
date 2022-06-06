package es.scl.pet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Pet {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String nombre;
    private Date fechanacimiento;
    private String raza;
    private float peso;
    private boolean chipsi;
}
