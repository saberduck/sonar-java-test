package checks;

class A {
  
  void method(String[] args, String string) {
    String argStr = args.toString(); // Noncompliant [[sc=26;ec=34]] {{Use "Arrays.toString(array)" instead.}}
    int argHash = args.hashCode(); // Noncompliant {{Use "Arrays.hashCode(array)" instead.}}
    java.lang.Class class1 = args.getClass();
    String str = string.toString();
    int hash = string.hashCode();
  }
}
