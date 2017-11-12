package de.gedoplan.jpademo;

import de.gedoplan.jpademo.entity.LabExperiment2IdEquality;
import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.function.BiFunction;

public class LabExperiment2IdEqualityTest extends LabExperimentTestBase<LabExperiment2IdEquality> {

  @Override
  protected Class<? extends SingleIdEntity> getEntityClass() {
    return LabExperiment2IdEquality.class;
  }

  @Override
  protected BiFunction<String, Boolean, LabExperiment2IdEquality> getTwoParmCtor() {
    return LabExperiment2IdEquality::new;
  }
}