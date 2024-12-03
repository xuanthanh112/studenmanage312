package vn.edu.hust.studentman

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {
    private val _students = MutableLiveData<MutableList<StudentModel>>(mutableListOf(

        StudentModel("Nguyễn Thị Anh", "20220001"),
        StudentModel("Trần Văn Bình", "20220002"),
        StudentModel("Lê Thị Cẩm", "20220003"),
        StudentModel("Phạm Văn Đức", "20220004"),
        StudentModel("Đỗ Thị Hoa", "20220005"),
        StudentModel("Bùi Văn Khánh", "20220006"),
        StudentModel("Hoàng Thị Lan", "20220007"),
        StudentModel("Lý Văn Minh", "20220008"),
        StudentModel("Vũ Thị Ngọc", "20220009"),
        StudentModel("Phan Văn Phúc", "20220010"),
        StudentModel("Ngô Thị Quỳnh", "20220011"),
        StudentModel("Đặng Văn Sơn", "20220012"),
        StudentModel("Dương Thị Trang", "20220013"),
        StudentModel("Nguyễn Văn Việt", "20220014"),
        StudentModel("Trần Thị Xuân", "20220015")


    ))
    val students: LiveData<MutableList<StudentModel>> get() = _students

    fun addStudent(student: StudentModel) {
        _students.value?.add(student)
        _students.value = _students.value // Trigger LiveData update
    }

    fun updateStudent(oldId: String, newName: String, newId: String) {
        _students.value?.find { it.studentId == oldId }?.let {
            it.studentName = newName
            it.studentId = newId
            _students.value = _students.value // Trigger LiveData update
        }
    }

    fun deleteStudent(student: StudentModel) {
        _students.value?.remove(student)
        _students.value = _students.value // Trigger LiveData update
    }

    fun getStudentById(id: String?): StudentModel? {
        return _students.value?.find { it.studentId == id }
    }
}
