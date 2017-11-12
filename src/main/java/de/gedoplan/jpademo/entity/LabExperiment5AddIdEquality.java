package de.gedoplan.jpademo.entity;

import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Access(AccessType.FIELD)
@Table(name = LabExperiment5AddIdEquality.TABLE_NAME)
public class LabExperiment5AddIdEquality extends SingleIdEntity {
  public static final String TABLE_NAME = "JPA_LAB_EXPERIMENT_5";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Size(min = 1)
  private String description;

  private Boolean positiveResult;

  @NotNull
  @Column(unique = true)
  private String uuid;

  public LabExperiment5AddIdEquality(String description, Boolean positiveResult) {
    this.description = description;
    this.positiveResult = positiveResult;
    this.uuid = UUID.randomUUID().toString();
  }

  protected LabExperiment5AddIdEquality() {
  }

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "LabExperiment [id=" + this.id + ", description=" + this.description + ", positiveResult=" + this.positiveResult + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LabExperiment5AddIdEquality other = (LabExperiment5AddIdEquality) obj;
    if (this.uuid == null) {
      if (other.uuid != null) {
        return false;
      }
    } else if (!this.uuid.equals(other.uuid)) {
      return false;
    }
    return true;
  }
}
