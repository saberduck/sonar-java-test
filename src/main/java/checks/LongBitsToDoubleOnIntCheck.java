package checks;

class A {
  void foo() {
    byte b = 1;
    short s = 1;
    Double.longBitsToDouble('c'); // Noncompliant [[sc=12;ec=28]] {{Remove this "Double.longBitsToDouble" call.}}
    Double.longBitsToDouble(s); // Noncompliant
    Double.longBitsToDouble(b); // Noncompliant
    Double.longBitsToDouble(1); // Noncompliant
    Double.longBitsToDouble(1L);
    Double.longBitsToDouble(Long.valueOf(1l));
  }
}
