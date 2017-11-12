package de.gedoplan.jpademo.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SingleIdEntity {
  public abstract Object getId();
}
