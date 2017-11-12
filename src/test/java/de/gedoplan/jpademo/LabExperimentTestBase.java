package de.gedoplan.jpademo;

import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

public abstract class LabExperimentTestBase<E extends SingleIdEntity> extends EntityDesignTestBase {

  protected abstract BiFunction<String, Boolean, E> getTwoParmCtor();

  @Override
  protected SingleIdEntity[] getTestData() {
    return new SingleIdEntity[] { getTwoParmCtor().apply("Oxyhydrogen reaction", true), getTwoParmCtor().apply("Cupper oxidation", true) };
  }

  @Override
  protected Set<E> getDataSet() {
    Set<E> dataSet = new HashSet<>();
    dataSet.add(getTwoParmCtor().apply("Helium reaction", false));
    dataSet.add(getTwoParmCtor().apply("Lead to gold conversion", false));
    return dataSet;
  }

  @Override
  protected SingleIdEntity getRandomItem() {
    int nr = this.random.nextInt(MASS_COUNT);
    return getTwoParmCtor().apply("Test " + nr, false);
  }

}
