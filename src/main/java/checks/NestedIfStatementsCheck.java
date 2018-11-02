package checks;

class A {
  private void f() {
    if (false) { // Compliant - 1
    }

    if (false) { // Compliant - 1
    }

    if (false) { // Compliant - 1
    }

    if (false) { // Compliant - 1
    }

    if (false) { // Compliant - 1
      if (true) { // Compliant - 2
      } else {
        if (false) { // Compliant - 3
          if (true) { // Noncompliant [[sc=11;ec=13;secondary=18,16,15]] {{Refactor this code to not nest more than 3 if/for/while/switch/try statements.}}
            if (false) { // Compliant - 5
            }
          } else if (true) { // Compliant - 4
          } else {
            if (false) { // Compliant - 5
            }
          }
        }
      }
    }

    if (false) { // Compliant - 1
    } else if (false) { // Compliant - 1
    } else if (false) { // Compliant - 1
    } else if (false) { // Compliant - 1
    } else if (false) { // Compliant - 1
    }

    if (false) // Compliant - 1
      if (false) // Compliant - 2
        if (false) // Compliant - 3
          if (true) // Noncompliant
            System.out.println();

    if (false) // Compliant - 1
      if (false) // Compliant - 2
        if (false) // Compliant - 3
          if (false) System.out.println(); // Noncompliant
          else System.out.println();
        else System.out.println();
      else System.out.println();
    else System.out.println();

    for (int i = 0; i < 0; i++) { // Compliant - 1
      for (Object o: getObjects()) { // Compliant - 2
        while (false) { // Compliant - 3

          for (int i = 0; i < 0; i++) { // Noncompliant
          }

          for (Object o: getObjects()) { // Noncompliant
          }

          while (false) { // Noncompliant
          }

          do { // Noncompliant
          } while (false);

          if (false) { // Noncompliant
          }

          switch (foo) { // Noncompliant
          }

          try {  // Noncompliant
          } catch (Exception e) {
          }
        }
      }
    }
  }
}
