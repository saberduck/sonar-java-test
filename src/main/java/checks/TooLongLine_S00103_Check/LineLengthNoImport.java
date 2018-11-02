package checks.TooLongLine_S00103_Check;

class LineLength {
  void method() {
    // Noncompliant {{Split this 97 characters long line (which is greater than 20 authorized).}}
    // Noncompliant {{Split this 97 characters long line (which is greater than 20 authorized).}}
  }
}
