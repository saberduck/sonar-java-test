package checks;

class A11 {
  public void f(boolean var) {
    boolean b = var == false;// Noncompliant [[sc=12;ec=17]] {{Remove the literal "false" boolean value.}}
    b= var == true;        // Noncompliant {{Remove the literal "true" boolean value.}}
    b = var != false;       // Noncompliant {{Remove the literal "false" boolean value.}}
    b = var != true;        // Noncompliant {{Remove the literal "true" boolean value.}}
    b = false == var;       // Noncompliant {{Remove the literal "false" boolean value.}}
    b = true == var;        // Noncompliant {{Remove the literal "true" boolean value.}}
    b = false != var;       // Noncompliant {{Remove the literal "false" boolean value.}}
    b = true != var;        // Noncompliant {{Remove the literal "true" boolean value.}}
    b = !true;              // Noncompliant {{Remove the literal "true" boolean value.}}
    b = !false;             // Noncompliant {{Remove the literal "false" boolean value.}}
    b = false && foo();     // Noncompliant {{Remove the literal "false" boolean value.}}
    b = foo() || true;      // Noncompliant {{Remove the literal "true" boolean value.}}

    b= var == foo(true);   // Compliant
//    b = true < 0;           // Compliant
//    b = ~true;              // Compliant
//    b = ++ true;            // Compliant
    b = !foo();               // Compliant
    b = foo() && bar();     // Compliant

    boolean exp = foo();
    var = foo() ? true : false; // Noncompliant
    var = foo() ? true : exp;   // Noncompliant
    var = foo() ? false : exp;  // Noncompliant
    var = foo() ? exp : true;   // Noncompliant
    var = foo() ? exp : false;  // Noncompliant

    var = foo();
    var = foo() || exp;
    var = !foo() && exp;
    var = !foo() || exp;
    var = foo() && exp;
  }

  boolean foo()          { return true; }
  boolean foo(boolean b) { return b;    }
  boolean bar()          { return true; }
}
