package checks;

class A {
  void foo(){} // Compliant
}
interface I {
  public void finalize(); // Compliant - from Object
  void bar(); // Compliant
}
interface J extends I {
  public void finalize(); // Compliant - from Object
  void bar(); // Compliant - from interface
}
interface K extends J {
  public boolean equals(Object obj); // Compliant - from Object
}
class B extends A implements I {
  void foo() {} // Noncompliant [[sc=8;ec=11]] {{Add the "@Override" annotation above this method signature}}
  void bar() {} // Compliant - from interface

  protected void finalize() { // Compliant - from Object
    super.finalize();
  }
}
class C extends A implements I {
  @Override
  void foo() {}
  @Deprecated
  @Override
  void bar() {}
}

interface InterfaceWithDefault {
  default boolean qix() { return true; }
  default boolean gul() { return false; }
  boolean bar();
}

abstract class AbstractMethodFromInterface implements InterfaceWithDefault {
  abstract boolean bar(); // Compliant
}

interface InterfaceExtendsDefault extends InterfaceWithDefault {
  boolean qix(); // Noncompliant [[sc=11;ec=14]] {{Add the "@Override" annotation above this method signature}}
  @Override
  boolean gul(); // Compliant - hide default behavior
}

class ImplemInterfaceWithDefault implements InterfaceWithDefault {
  public boolean gul() { return false; } // Noncompliant [[sc=18;ec=21]] {{Add the "@Override" annotation above this method signature}}
}

abstract class AbstractClass {
  abstract boolean foo();
  boolean bar() { return false; }
}

class ExtendsAbstractClass extends AbstractClass {
  boolean foo() { return false; } // Compliant - overridee is abstract
  boolean bar() { return super.bar(); } // Noncompliant
}

abstract class ImplementsFromJDK8 implements java.lang.reflect.AnnotatedElement {

  public <A extends java.lang.annotation.Annotation> A[] getAnnotationsByType(java.lang.Class<A> annotationClass) { // Noncompliant [[sc=58;ec=78]] {{Add the "@Override" annotation above this method signature}}
    return null;
  }
}
