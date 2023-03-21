package services.impl;

import data.class_data.BookingData;
import models.Booking;
import models.Customer;
import services.itf.PromotionService;
import utils.MyUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    private static Set<Booking> bookingSet;

    static {
        try {
            bookingSet = BookingData.readFile();
        } catch (IOException e) {
            System.out.println("File is not exist");
            ;
        }
    }

    private static Set<Integer> customerIdUseServiceSet = new TreeSet<>();

    private static Stack<Integer> customerGetVoucherList = new Stack<>();

    @Override
    public Set<Integer> displayListUseService(int year) {
        for (Booking booking : bookingSet) {
            int yyyy = MyUtil.parseDate(booking.getBeginDate()).getYear();
            if (yyyy == year){
                customerIdUseServiceSet.add(booking.getCustomerID());
            }
        }
        return customerIdUseServiceSet;
    }

    @Override
    public Stack<Integer> displayListGetVoucher() {
        int yearNow = LocalDate.now().getYear();
        int monthNow = LocalDate.now().getMonthValue();

        for (Booking booking : bookingSet) {
            int yyyy = MyUtil.parseDate(booking.getBeginDate()).getYear();
            int mm = MyUtil.parseDate(booking.getBeginDate()).getMonthValue();

            if (yyyy == yearNow && mm == monthNow){
                customerGetVoucherList.add(booking.getCustomerID());
            }
        }

        return customerGetVoucherList;
    }
}
