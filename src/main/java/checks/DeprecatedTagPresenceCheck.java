package checks;

class Foo {

  @Deprecated
  public int foo; // Noncompliant [[sc=14;ec=17]] {{Do not forget to remove this deprecated code someday.}}

  public void foo1() { // Compliant
  }

  @Deprecated
  public void foo2() { // Noncompliant
  }

  /**
   * @deprecated
   */
  public void foo3() { // Noncompliant

  }

  /**
   * @deprecated
   */
  @Ignore
  @Deprecated
  public void foo4() { // Noncompliant [[sc=15;ec=19]]
  }

  @Deprecated
  /**
   * @deprecated
   */
  public void foo5() { // Noncompliant
  }

  /*
   * @deprecated
   */
  @Deprecated
  public int foo7() { // Noncompliant
  }

  /**
   *
   */
  @Deprecated
  public void foo8() { // Noncompliant
  }

  @Deprecated // Compliant - no one does this
  public void foo9() {

    @Deprecated
    int local1 = 0; // Noncompliant

  }

}

interface Bar {

  @Deprecated
  int foo(); // Noncompliant

}