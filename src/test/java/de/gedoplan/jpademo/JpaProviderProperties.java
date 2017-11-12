package de.gedoplan.jpademo;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public final class JpaProviderProperties {

  public static final Properties PROP = new Properties();

  static {
    // Properties-File mit UTF-8 einlesen, weil dieses Charset im POM eingetragen ist.
    try (Reader reader = new InputStreamReader(Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("jpaprovider.properties"), "UTF-8");) {
      PROP.load(reader);
    } catch (Exception e) {
      // ignore
    }

    // Properties entfernen, die nicht gesetzt wurden, d. h. noch die Form ${key} haben
    @SuppressWarnings({ "unchecked", "rawtypes" })
    Iterator<Entry<String, String>> iterator = (Iterator) PROP.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<String, String> entry = iterator.next();
      String value = entry.getValue();
      if (value.startsWith("${")
          && value.endsWith("}")
          && value.substring(2, value.length() - 1).equals(entry.getKey())) {
        iterator.remove();
      }
    }
  }

  private JpaProviderProperties() {
  }
}
