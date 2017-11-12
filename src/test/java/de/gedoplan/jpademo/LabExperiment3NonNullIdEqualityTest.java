package de.gedoplan.jpademo;

import de.gedoplan.jpademo.entity.LabExperiment3NonNullIdEquality;
import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.function.BiFunction;

public class LabExperiment3NonNullIdEqualityTest extends LabExperimentTestBase<LabExperiment3NonNullIdEquality> {

  @Override
  protected Class<? extends SingleIdEntity> getEntityClass() {
    return LabExperiment3NonNullIdEquality.class;
  }

  @Override
  protected BiFunction<String, Boolean, LabExperiment3NonNullIdEquality> getTwoParmCtor() {
    return LabExperiment3NonNullIdEquality::new;
  }
}