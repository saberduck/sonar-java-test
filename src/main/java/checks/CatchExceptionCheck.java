package checks;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

class A {
  void m1() {
    try {
      m3();
    } catch (MyException e) {
    } catch (MyException1 | MyException2 e) {
    } catch (Exception e) { // Noncompliant [[sc=14;ec=23]] {{Catch a list of specific exception subtypes instead.}}
    }
    try {
    } catch (MyException1 | Exception e) { // Noncompliant
    }
    try {
      m2();
      m2();
    } catch (Exception e) { // compliant, m2 throws explicitly java.lang.Exception
    }
    try {
    } catch (UnsupportedEncodingException | UnsupportedDataTypeException | RuntimeException e) {
    }
  }

  void m2() throws Exception {
  }

  void m3() throws MyException {
  }
}

class B {
  public void foo() {
    try {
      unknownMethod();
    } catch (Exception e) { // Compliant
    }
  }
}

class ExceptionsWithParametrizedMethods {

  void foo() {
    try {
      AccessController.doPrivileged(new B());
    } catch (Exception e) { // Noncompliant
    }

    try {
      AccessController.doPrivileged(
        new PrivilegedAction() {
          @Override
          public Object run() {
            return null;
          }
        });
    } catch (Exception e) { // Noncompliant
    }

    try {
      AccessController.doPrivileged(new C());
    } catch (Exception e) { // Noncompliant
    }

    try {
      AccessController.doPrivileged(new C());
    } catch (PrivilegedActionException e) { // Compliant
    }

    try {
      AccessController.doPrivileged(
        new PrivilegedExceptionAction() {
          @Override
          public Object run() {
            return null;
          }
        });
    } catch (Exception e) { // Noncompliant
    }
  }

  class B implements PrivilegedAction<Integer> {
    @Override
    public Integer run() {
      return null;
    }
  }

  class C implements PrivilegedExceptionAction<Integer> {
    @Override
    public Integer run() throws Exception {
      return null;
    }

  }

  class FOoBar {
    void plop(java.lang.Class type) {
      try {
        type.getMethod("getListeners", new java.lang.Class[]{java.lang.Class.class});
      }catch (Exception e){ // Noncompliant

      }
    }
  }

  class ExceptionThrower {
    ExceptionThrower() throws Exception {
      throw new Exception("");
    }
  }
  void instanceExceptionThrower() {
    try {
      String s = new String();
      ExceptionThrower et = new ExceptionThrower();
    } catch(Exception e) {
    }
  }
}
