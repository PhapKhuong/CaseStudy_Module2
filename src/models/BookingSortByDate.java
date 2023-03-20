package models;

import utils.MyUtil;

import java.time.LocalDate;
import java.util.Comparator;

public class BookingSortByDate implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        LocalDate beginDate1 = MyUtil.parseDate(o1.getBeginDate());
        LocalDate beginDate2 = MyUtil.parseDate(o2.getBeginDate());
        LocalDate finishDate1 = MyUtil.parseDate(o1.getFinishDate());
        LocalDate finishDate2 = MyUtil.parseDate(o2.getFinishDate());

        if (beginDate1.isAfter(beginDate2)) {
            return 1;
        } else if (beginDate1.equals(beginDate2)) {
            if (finishDate1.isAfter(finishDate2)) {
                return 1;
            } else if (finishDate1.equals(finishDate2)) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}