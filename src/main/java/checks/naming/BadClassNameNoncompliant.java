package checks.naming;

class badClassName { // Noncompliant [[sc=7;ec=19]] {{Rename this class name to match the regular expression '^[A-Z][a-zA-Z0-9]*$'.}}
}

class GoodClassName {
}

interface should_not_be_checked_interface {
}

enum should_not_be_checked_enum {
}

@interface should_not_be_checked_annotation {
}
