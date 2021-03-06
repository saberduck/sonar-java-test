package checks;

class A {
  void foo(boolean condition1, boolean condition2) {
    if (condition1) {
      // ...
    } if (condition2) {  // Noncompliant [[sc=7;ec=9;secondary=5]] {{Move this "if" to a new line or add the missing "else".}}
      //...
    }
    if (condition1) {
      // ...
    }
    if (condition2) {  // compliant, if on next line
      //...
    }

    if (condition1) {
      // ...
    } else if (condition2) {  // compliant, else statement
      //...
    }
    if (condition1) { if(condition2) {} } // compliant
  }
}
