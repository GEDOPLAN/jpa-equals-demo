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
@Table(name = LabExperiment2IdEquality.TABLE_NAME)
public class LabExperiment2IdEquality extends SingleIdEntity {
  public static final String TABLE_NAME = "JPA_LAB_EXPERIMENT_2";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Size(min = 1)
  private String description;

  private Boolean positiveResult;

  public LabExperiment2IdEquality(String description, Boolean positiveResult) {
    this.description = description;
    this.positiveResult = positiveResult;
  }

  protected LabExperiment2IdEquality() {
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
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
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
    LabExperiment2IdEquality other = (LabExperiment2IdEquality) obj;
    if (this.id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!this.id.equals(other.id)) {
      return false;
    }
    return true;
  }

}
