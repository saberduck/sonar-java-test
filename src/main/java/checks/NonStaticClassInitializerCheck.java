package checks;

class A {
  static {
  }

  { // Noncompliant [[sc=3;ec=4]] {{Move the contents of this initializer to a standard constructor or to field initializers.}}
    System.out.println();
  }

  public A() {
    System.out.println();

    new Runnable() {

      { // Noncompliant
        System.out.println();
      }

      @Override
      public void run() {
      }
    };
  }
}
