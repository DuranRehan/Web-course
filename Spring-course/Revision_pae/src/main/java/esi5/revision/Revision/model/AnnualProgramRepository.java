package esi5.revision.Revision.model;

import org.springframework.data.repository.CrudRepository;

public interface AnnualProgramRepository extends CrudRepository<AnnualProgram, Integer> {
    public AnnualProgram findByStudentNumber(int number);
}
