package data.class_data;

import models.Contract;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ContractData {
    public static final String CONTRACT_PATH =
            "C:\\Dropbox\\Codegym\\FuramaResort\\src\\data\\csv_file\\contract.csv";

    private ContractData() {
    }

    public static Queue<Contract> readFile() throws IOException {
        FileReader fileReader = new FileReader(CONTRACT_PATH);
        BufferedReader buffReader = new BufferedReader(fileReader);

        Queue<Contract> contractDataQueue = new LinkedList<>();

        String[] temp;
        String line = buffReader.readLine();
        Contract contract;

        while (line != null) {
            temp = line.split(",");

            int contractID = Integer.parseInt(temp[0]);
            int bookingID = Integer.parseInt(temp[1]);
            long deposits = Long.parseLong(temp[2]);
            long payment = Long.parseLong(temp[3]);
            int customerID = Integer.parseInt(temp[4]);

            contract = new Contract(contractID, bookingID, deposits, payment, customerID);
            contractDataQueue.add(contract);
            line = buffReader.readLine();
        }
        buffReader.close();
        return contractDataQueue;
    }

    public static void writeFile(Contract contract) throws IOException {
        FileWriter fileWriter = new FileWriter(CONTRACT_PATH, true);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write(
                contract.getContractID() + ","
                        + contract.getBookingID() + ","
                        + contract.getDeposits() + ","
                        + contract.getPayment() + ","
                        + contract.getCustomerID() + "\n"
        );
        buffWriter.close();
    }

    public static void clear() throws IOException {
        FileWriter fileWriter = new FileWriter(CONTRACT_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.flush();
        buffWriter.close();
    }
}
