import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        LocalDate startDate = LocalDate.of(2021, 06, 14);
        LocalDate endDate = LocalDate.of(2021, 06, 23);
        Hospital hospital = new Hospital();
        int noOfPatientsBengaluru = hospital.getPatientsFromBengaluru(startDate, endDate).size();
        int noOfPatientsOutOfBengaluru = hospital.getPatientsOutOfBengaluru(startDate, endDate).size();
        int totalNoOfPatients = hospital.getNoOfPatients(startDate, endDate).size();
        double percentage = totalNoOfPatients!=0?(noOfPatientsOutOfBengaluru * 100) / totalNoOfPatients:0;
        double percentageBengaluru = totalNoOfPatients!=0?(noOfPatientsBengaluru * 100) / totalNoOfPatients:0;


        System.out.println("From "+ startDate +" to "+ endDate+", "+ totalNoOfPatients +" OP registrations took place of which "+percentageBengaluru+"% are from bangalore and " +percentage+"% are outstation");
    }
}
