package services;

import models.Contract;

import java.util.List;

public interface ContractService extends Service {

    void creatContract(Contract contract);

    List<Contract> displayContract();

    void editContract(int contractID);
}
