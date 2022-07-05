package by.itstep.stpnbelko.javastages.stage20.model.logic.salaryFindStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class SalaryLessThan implements MusicianSalary{
    @Override
    public boolean compare(Musician musician, int salary) {
        return musician.getSalary() < salary;
    }
}
