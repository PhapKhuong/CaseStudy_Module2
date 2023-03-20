package services.impl;

import data.class_data.ContractData;
import models.Contract;
import services.itf.ContractService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ContractServiceImpl implements ContractService {
    private static Queue<Contract> contractQueue = new LinkedList<>();

    static {
        try {
            contractQueue = ContractData.readFile();
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public void add(Contract contract) {
        try {
            ContractData.writeFile(contract);
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public Queue<Contract> display() {
        try {
            contractQueue = ContractData.readFile();
            return contractQueue;
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
        return null;
    }

    @Override
    public void edit(int id, Contract contract) {
        Queue<Contract> tempQueue = new LinkedList<>();

        for (Contract c : contractQueue) {
            if (id == c.getContractID()) {
                tempQueue.add(contract);
            } else {
                tempQueue.add(c);
            }

            try {
                ContractData.clear();
                for (Contract temp : tempQueue) {
                    ContractData.writeFile(temp);
                }
            } catch (IOException e) {
                System.out.println("File is not exist");
            }
        }
    }
}