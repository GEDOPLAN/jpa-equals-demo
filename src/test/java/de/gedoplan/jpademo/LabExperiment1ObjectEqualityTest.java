package de.gedoplan.jpademo;

import de.gedoplan.jpademo.entity.LabExperiment1ObjectEquality;
import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.function.BiFunction;

public class LabExperiment1ObjectEqualityTest extends LabExperimentTestBase<LabExperiment1ObjectEquality> {

  @Override
  protected Class<? extends SingleIdEntity> getEntityClass() {
    return LabExperiment1ObjectEquality.class;
  }

  @Override
  protected BiFunction<String, Boolean, LabExperiment1ObjectEquality> getTwoParmCtor() {
    return LabExperiment1ObjectEquality::new;
  }
}
