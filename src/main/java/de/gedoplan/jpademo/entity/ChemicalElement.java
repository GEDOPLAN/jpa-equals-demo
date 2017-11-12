package de.gedoplan.jpademo.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Access(AccessType.FIELD)
@Table(name = ChemicalElement.TABLE_NAME)
public class ChemicalElement extends SingleIdEntity {
  public static final String TABLE_NAME = "JPA_CHEMICAL_ELEMENT";

  @Id
  @NotNull
  // @Pattern(regexp = "[A-Z][a-z]?")
  private String id;

  @NotNull
  @Size(min = 1)
  private String name;

  @Enumerated(EnumType.STRING)
  private AggregateState aggregateState;

  public ChemicalElement(String id, String name, AggregateState aggregateState) {
    this.id = id;
    this.name = name;
    this.aggregateState = aggregateState;
  }

  protected ChemicalElement() {
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "ChemicalElement [id=" + this.id + ", name=" + this.name + ", aggregateState=" + this.aggregateState + "]";
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
    ChemicalElement other = (ChemicalElement) obj;
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
