package kr.co.yigil.travel.domain.course;

import kr.co.yigil.travel.domain.Course;
import kr.co.yigil.travel.domain.course.CourseCommand.RegisterCourseRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface CourseService {

    Slice<Course> getCoursesSliceInPlace(Long placeId, Pageable pageable);
    void registerCourse(RegisterCourseRequest request, Long memberId);
}
