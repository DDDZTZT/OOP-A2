
import java.util.Comparator;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // check null
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Error: Visitor object is null, cannot compare!");
        }

        // younger age first
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }

        // earlier entry date first
        try {
            LocalDate date1 = LocalDate.parse(v1.getEntryDate());
            LocalDate date2 = LocalDate.parse(v2.getEntryDate());
            return date1.compareTo(date2);
        } catch (DateTimeParseException e) {
            System.out.printf("Error: Visitor %s or %s has invalid entry date format (YYYY-MM-DD), sorted by name instead%n",
                    v1.getName(), v2.getName());
            // fallback to compare by name if date format is invalid
            return v1.getName().compareTo(v2.getName());
        }
    }
}
