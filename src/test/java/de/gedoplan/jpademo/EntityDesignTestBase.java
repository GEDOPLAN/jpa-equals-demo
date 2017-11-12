package de.gedoplan.jpademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import de.gedoplan.jpademo.entity.SingleIdEntity;

import java.util.Random;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class EntityDesignTestBase extends TestBase {

  public static final int MASS_COUNT = 100000;
  public static final int FIND_COUNT = MASS_COUNT / 1000;

  protected abstract Class<? extends SingleIdEntity> getEntityClass();

  protected abstract SingleIdEntity[] getTestData();

  protected abstract Set<? extends SingleIdEntity> getDataSet();

  protected abstract SingleIdEntity getRandomItem();

  protected Random random = new Random();

  @Test
  public void test_00_clearData() {
    this.entityManager.createQuery("delete from " + getEntityClass().getSimpleName() + " x").executeUpdate();
  }

  @Test
  public void test_01_insertTestData() {
    for (SingleIdEntity entity : getTestData()) {
      this.entityManager.persist(entity);
    }
  }

  @Test
  public void test_02_populateSet() {
    Set<? extends SingleIdEntity> dataSet = getDataSet();
    assertTrue("Dataset incomplete", dataSet.size() >= 2);
  }

  @Test
  public void test_03_insertSetContent() {
    Set<? extends SingleIdEntity> dataSet = getDataSet();
    for (SingleIdEntity entity : dataSet) {
      this.entityManager.persist(entity);
    }
    checkSetIntact(dataSet);
    this.entityManager.getTransaction().commit();
    checkSetIntact(dataSet);
  }

  private void checkSetIntact(Set<?> dataSet) {
    for (Object object : dataSet) {
      assertTrue("Dataset currupted", dataSet.contains(object));
    }
  }

  @Test
  public void test_04_compareDetached() {
    SingleIdEntity entity = this.entityManager
        .createQuery("select x from " + getEntityClass().getSimpleName() + " x", getEntityClass())
        .setMaxResults(1)
        .getResultList()
        .get(0);

    this.entityManager.clear();

    SingleIdEntity entity2 = this.entityManager.find(getEntityClass(), entity.getId());

    assertEquals("Detached entity not equals", entity, entity2);
  }

  // @Test
  // public void test_05_massInsert() {
  // for (int i = 0; i < MASS_COUNT; ++i) {
  // this.entityManager.merge(getRandomItem());
  // }
  // }
  //
  // @Test
  // public void test_06_massfind() {
  // List<Object> ids = new ArrayList<>();
  // for (int i = 0; i < FIND_COUNT; ++i) {
  // List<? extends SingleIdEntity> resultList = this.entityManager
  // .createQuery("select x from " + getEntityClass().getSimpleName() + " x", getEntityClass())
  // .setFirstResult(this.random.nextInt(MASS_COUNT))
  // .setMaxResults(1)
  // .getResultList();
  // if (!resultList.isEmpty()) {
  // ids.add(resultList.get(0).getId());
  // }
  // }
  //
  // for (int j = 0; j < 100; ++j) {
  // for (Object id : ids) {
  // this.entityManager.clear();
  // SingleIdEntity entity = this.entityManager.find(getEntityClass(), id);
  // assertNotNull(entity);
  // }
  // }
  // }
}
