package services.itf;

import models.Contract;

import java.util.Queue;

public interface ContractService extends Service {

    void add(Contract contract);

    Queue<Contract> display();

    void edit(int id, Contract contract);
}
