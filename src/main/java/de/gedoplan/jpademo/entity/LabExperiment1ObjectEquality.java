package de.gedoplan.jpademo.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Access(AccessType.FIELD)
@Table(name = LabExperiment1ObjectEquality.TABLE_NAME)
public class LabExperiment1ObjectEquality extends SingleIdEntity {
  public static final String TABLE_NAME = "JPA_LAB_EXPERIMENT_1";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Size(min = 1)
  private String description;

  private Boolean positiveResult;

  public LabExperiment1ObjectEquality(String description, Boolean positiveResult) {
    this.description = description;
    this.positiveResult = positiveResult;
  }

  protected LabExperiment1ObjectEquality() {
  }

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "LabExperiment [id=" + this.id + ", description=" + this.description + ", positiveResult=" + this.positiveResult + "]";
  }
}
