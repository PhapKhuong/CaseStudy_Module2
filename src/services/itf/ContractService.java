package services.itf;

import models.Contract;

import java.util.List;

public interface ContractService extends Service {

    void add(Contract contract);

    List<Contract> display();

    void edit(int id);
}
