import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hospital {


    public List<Patient> getPatients() {
        List<Patient> patientList = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus3Days = currentDate.minusDays(3);
        LocalDate currentDateMinus5Days = currentDate.minusDays(5);

        Patient p1 = new OutPatient("Patient1", "Bengaluru", currentDate);
        Patient p2 = new OutPatient("Patient2", "Bengaluru", currentDate);
        Patient p3 = new OutPatient("Patient3", "Mysuru", currentDate);
        Patient p4 = new OutPatient("Patient4", "Bengaluru", currentDateMinus5Days);
        Patient p5 = new OutPatient("Patient5", "Chikmagalore", currentDateMinus5Days);
        Patient p6 = new OutPatient("Patient6", "Kolar", currentDateMinus3Days);

        patientList.add(p1);
        patientList.add(p2);
        patientList.add(p3);
        patientList.add(p4);
        patientList.add(p5);
        patientList.add(p6);

        return patientList;
    }

    public List<Patient> getPatientsFromBengaluru(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = getPatients();
        return patients.stream().parallel().filter(patient -> {
            return "Bengaluru".equalsIgnoreCase(patient.getPatientLoc()) && patient.getPatientRegTime().isAfter(startDate)
                    && patient.getPatientRegTime().isBefore(endDate);
        }).collect(Collectors.toList());
    }

    public List<Patient> getPatientsOutOfBengaluru(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = getPatients();
        return patients.stream().parallel().filter(patient -> {
            return "Bengaluru".equalsIgnoreCase(patient.getPatientLoc()) && patient.getPatientRegTime().isAfter(startDate)
                    && patient.getPatientRegTime().isBefore(endDate);
        }).collect(Collectors.toList());
    }

    public List<Patient> getNoOfPatients(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = getPatients();
        return patients.stream().parallel().filter(patient -> {
            return patient.getPatientRegTime().isAfter(startDate)
                    && patient.getPatientRegTime().isBefore(endDate);
        }).collect(Collectors.toList());
    }
}
