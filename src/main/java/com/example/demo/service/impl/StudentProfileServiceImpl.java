// package com.example.demo.service.impl;

// import com.example.demo.entity.StudentProfile;
// import com.example.demo.repository.StudentProfileRepository;
// import com.example.demo.service.StudentProfileService;
// import com.example.demo.exception.ResourceNotFoundException;

// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class StudentProfileServiceImpl implements StudentProfileService {

//     private final StudentProfileRepository repository;

//     public StudentProfileServiceImpl(StudentProfileRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public StudentProfile createStudent(StudentProfile studentProfile) {
//         studentProfile.setRepeatOffender(false);
//         return repository.save(studentProfile);
//     }

//     @Override
//     public StudentProfile getStudentById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("StudentProfile not found"));
//     }

//     @Override
//     public List<StudentProfile> getAllStudents() {
//         return repository.findAll();
//     }

//     @Override
//     public StudentProfile updateRepeatOffenderStatus(Long id) {
//         StudentProfile profile = getStudentById(id);
//         profile.setRepeatOffender(true);
//         return repository.save(profile);
//     }
// }




package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl {

    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator calculator;

    public StudentProfileServiceImpl(
            StudentProfileRepository studentProfileRepository,
            IntegrityCaseRepository integrityCaseRepository,
            RepeatOffenderRecordRepository repeatOffenderRecordRepository,
            RepeatOffenderCalculator calculator) {

        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.calculator = calculator;
    }
}
