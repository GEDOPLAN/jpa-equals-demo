package de.gedoplan.jpademo;

import de.gedoplan.jpademo.entity.LabExperiment4UUIdEquality;
import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.function.BiFunction;

public class LabExperiment4UUIdEqualityTest extends LabExperimentTestBase<LabExperiment4UUIdEquality> {

  @Override
  protected Class<? extends SingleIdEntity> getEntityClass() {
    return LabExperiment4UUIdEquality.class;
  }

  @Override
  protected BiFunction<String, Boolean, LabExperiment4UUIdEquality> getTwoParmCtor() {
    return LabExperiment4UUIdEquality::new;
  }
}