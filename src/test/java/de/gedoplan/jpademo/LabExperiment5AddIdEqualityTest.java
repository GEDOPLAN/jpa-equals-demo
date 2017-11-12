package de.gedoplan.jpademo;

import de.gedoplan.jpademo.entity.LabExperiment5AddIdEquality;
import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.function.BiFunction;

public class LabExperiment5AddIdEqualityTest extends LabExperimentTestBase<LabExperiment5AddIdEquality> {

  @Override
  protected Class<? extends SingleIdEntity> getEntityClass() {
    return LabExperiment5AddIdEquality.class;
  }

  @Override
  protected BiFunction<String, Boolean, LabExperiment5AddIdEquality> getTwoParmCtor() {
    return LabExperiment5AddIdEquality::new;
  }
}