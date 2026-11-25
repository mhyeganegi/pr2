package de.bht.pr2.lab01;

public class Student {

  //-------------------------------------------
  // Attribute
  private String name = "";

  // Matrikelnummer
  private int registrationNumber = 0;

  // Medieninformatik, Technische Informatik, Druck- und Medientechnik und Screen Based Media
  private String courseOfStudies = "";

  // Rückmeldegebühr
  public static final int TUITION_FEE = 312;

  /**
   * This contructor parses a comma-separated row describing a student object.
   *
   * @param dataRow a comma-separated row describing a student object
   */
  public Student(String dataRow) 
  throws StudentParseException, 
  RegistrationNumberException, 
  WrongCourseOfStudiesException, 
  NotPaidTuitionFeeException {

    String[] fields = dataRow.split(",", -1);

    if(fields.length != 4){
      throw new StudentParseException(dataRow);
    }

    String parsedName = fields[0].trim();
    String registrationText = fields[1].trim();
    String parsedCourse = fields[2].trim();
    String feeText = fields[3].trim();

    if (parsedName.isEmpty()) {
      throw new StudentParseException(dataRow);
    }

    if (!registrationText.matches("[0-9]{5,}")) {
      throw new RegistrationNumberException(registrationText);

    }
    int parsedRegistrationNumber;
    try {
      parsedRegistrationNumber = Integer.parseInt(registrationText);
    } catch (NumberFormatException e) {
      throw new RegistrationNumberException(registrationText);
    }

    if (!parsedCourse.equals("Medieninformatik") && !parsedCourse.equals("Technische Informatik") && !parsedCourse.equals("Druck- und Medientechnik") && !parsedCourse.equals("Screen Based Media")) {
      throw new WrongCourseOfStudiesException(parsedCourse);
    }

    int paidFee;
    try {
      paidFee = Integer.parseInt(feeText);
    } catch (NumberFormatException e) {
      throw new StudentParseException(dataRow);
    }

    if(paidFee < TUITION_FEE){
      int missingAmount = TUITION_FEE - paidFee;
      throw new NotPaidTuitionFeeException(missingAmount + " €");

    }

    this.name = parsedName;
    this.registrationNumber = parsedRegistrationNumber;
    this.courseOfStudies = parsedCourse;
    
  }
}
