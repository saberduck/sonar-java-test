package checks;// foo

// Noncompliant@+1 {{Take the required action to fix the issue indicated by this comment.}}
// fixME
class A{
// Noncompliant@+5
// Noncompliant@+3
/*

  fixme
  FixMe
*/

// Noncompliant@+1
// FIXME

// Noncompliant@+1
// [FIXME]

// PreFixMe
// FixMePost
// PreFixMePost
}
