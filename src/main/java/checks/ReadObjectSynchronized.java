package checks;

class XXX {

  public class TestClass1 {

    private synchronized void readObject(java.io.ObjectInputStream is) { // Compliant, not in a Serializable class
    }

  }

  public class TestClass21 implements java.io.Serializable {

    private void readObject(java.io.ObjectInputStream is) { // Compliant, not a synchronized method
    }

  }

  public class TestClass3 implements java.io.Serializable {

    private String readObject; // Compliant

    private synchronized void readObject(java.io.InputStream is) { // Compliant, wrong signature
    }

    private synchronized void readObject() { // Compliant, wrong signature
    }

    private synchronized void read(java.io.ObjectInputStream is) { // Compliant, wrong signature
    }

    private synchronized void readObject(java.io.ObjectInputStream is) { // Noncompliant {{Remove the "synchronized" keyword from this method.}}
    }

  }
}
