package services.itf;

import models.Customer;

import java.util.List;
import java.util.Set;
import java.util.Stack;

public interface PromotionService {
    Set<Integer> displayListUseService(int year);

    Stack<Integer> displayListGetVoucher();
}
