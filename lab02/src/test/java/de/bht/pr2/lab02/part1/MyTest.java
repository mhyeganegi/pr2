package de.bht.pr2.lab02.part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyTest {

  @Test
  void acceptsValidStudent() {
    Student student = assertDoesNotThrow(
      () -> new Student("Anna Alt,70001,Medieninformatik,312"));

      assertEquals("Anna Alt", student.getName());
      assertEquals(70001, student.getRegistrationNumber());
      assertEquals("Medieninformatik", student.getCourseOfStudies());
  }

  @Test 
  void rejectsUnknownCourse() {
    assertThrows(WrongCourseOfStudiesException.class, 
      () -> new Student("IngridcInsel,70009,Musik und Tanz,312"));
  }

  @Test
  void rejectsInsufficientTuitionFee() {
    assertThrows(NotPaidTuitionFeeException.class, 
      () -> new Student("Rafael Raum,70018,Druck- und Medientechnik,200"));
  }
}
