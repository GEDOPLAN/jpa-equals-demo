package de.gedoplan.jpademo;

import de.gedoplan.jpademo.entity.AggregateState;
import de.gedoplan.jpademo.entity.ChemicalElement;
import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.HashSet;
import java.util.Set;

public class ChemicalElementTest extends EntityDesignTestBase {

  public static final SingleIdEntity[] testData = {
      new ChemicalElement("H", "Hydrogen", AggregateState.GAS),
      new ChemicalElement("He", "Helium", AggregateState.GAS),
      new ChemicalElement("Li", "Litium", AggregateState.SOLID),
      new ChemicalElement("Be", "Beryllium", AggregateState.SOLID),
      new ChemicalElement("B", "Boron", AggregateState.SOLID),
      new ChemicalElement("C", "Carbon", AggregateState.SOLID),
      new ChemicalElement("N", "Nitrogen", AggregateState.GAS),
      new ChemicalElement("O", "Oxygen", AggregateState.GAS),
      new ChemicalElement("F", "Fluorine", AggregateState.GAS),
      new ChemicalElement("Ne", "Neon", AggregateState.GAS),
  };

  @Override
  protected Class<? extends SingleIdEntity> getEntityClass() {
    return ChemicalElement.class;
  }

  @Override
  protected SingleIdEntity[] getTestData() {
    return testData;
  }

  @Override
  protected Set<? extends SingleIdEntity> getDataSet() {
    Set<ChemicalElement> dataSet = new HashSet<>();
    dataSet.add(new ChemicalElement("Cu", "Copper", AggregateState.SOLID));
    dataSet.add(new ChemicalElement("Fe", "Iron", AggregateState.SOLID));
    return dataSet;
  }

  @Override
  protected SingleIdEntity getRandomItem() {

    int nr = this.random.nextInt(MASS_COUNT);
    return new ChemicalElement("E" + nr, "Element " + nr, AggregateState.LIQUID);
  }

}
