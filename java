package ar.edu.unq.objetos2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by gabriel on 12/04/17.
 */
public class StudentFileReader extends CSVFileReader<Student> {

    /**
     * @param filePath the absolute path of the file to be read.
     */
    public StudentFileReader(String filePath) {
        super(filePath);
    }

    @Override
    protected Student parseLine(String[] line) {
        //Get rid of the id, line[0]

        //Format of the string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Convert from String to LocalDate
        LocalDate registerDate = LocalDate.parse(line[4], formatter);

        return new Student(line[1], line[2], line[3], registerDate, line[5]);
    }

    @Override
    protected String getSeparator() {
        return ",";
    }
}
