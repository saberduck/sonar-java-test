package checks.ClassFieldCountCheck;

class TooManyFields { // Noncompliant [[sc=7;ec=20]] {{Refactor this class so it has no more than 20 public fields, rather than the 26 it currently has.}}
  int nonPublicField1;
  int nonPublicField2;
  int nonPublicField3;
  int nonPublicField4;
  public int field1;
  public int field2;
  public int field3;
  public int field4;
  public int field5;
  public int field6;
  public int field7;
  public int field8;
  public int field9;
  public int field10;
  public int field11;
  public int field12;
  public int field13;
  public int field14;
  public int field15;
  public int field16;
  public int field17;
  public int field18;
  public int field19;
  public int field20;
  public int field21;
  public int field23;
  public int field24;
  public int field25;
  public int field26;
  public int field27;
}

class ThisIsOK { // Compliant
  int nonPublicField1;
  int nonPublicField2;
  int nonPublicField3;
  int nonPublicField4;
  public int field1;
  public int field2;
  public int field3;
  public int field4;
  public int field5;
  public int field6;
  public int field7;
  public int field8;
  public int field9;
  public int field10;
  public int field11;
  public int field12;
  public int field13;
  public int field14;
  public int field15;
  public int field16;
  public int field17;
  public int field18;
  public int field19;
  public int field20;
  public static final int STATIC_FINAL_FIELD_5;
  public static final int STATIC_FINAL_FIELD_6;
  public static final int STATIC_FINAL_FIELD_7;
  public static final int STATIC_FINAL_FIELD_8;
  public static final int STATIC_FINAL_FIELD_9;
  public static final int STATIC_FINAL_FIELD_10;
  private static final int STATIC_FINAL_FIELD_11;
  private static final int STATIC_FINAL_FIELD_12;
  private static final int STATIC_FINAL_FIELD_13;
  private static final int STATIC_FINAL_FIELD_14;
  private static final int STATIC_FINAL_FIELD_15;
}