package checks;

class A {

  public void method() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    String className = System.getProperty("messageClassName");
    java.lang.Class clazz = java.lang.Class.forName(className);  // Noncompliant [[sc=25;ec=32]]

    ClassLoader loader = null;
    Object main = loader.loadClass(className).newInstance(); // Noncompliant
  }

  public static void main(String[] args) {
    try {
      java.lang.Class cls1 = java.lang.Class.forName("java.lang.ClassLoader");
      // test with a constant from JDK because this test file is not compiled and constants evaluation needs .class
      java.lang.Class cls2 = java.lang.Class.forName(java.util.jar.JarFile.MANIFEST_NAME);
    } catch (ClassNotFoundException ex) {
    }
  }
}
