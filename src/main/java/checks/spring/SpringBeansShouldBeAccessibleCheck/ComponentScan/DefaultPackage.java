package checks.spring.SpringBeansShouldBeAccessibleCheck.ComponentScan;

import org.springframework.stereotype.Component;

@Component
class FooBar { // Noncompliant
  A1() {}
}
