import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

  const initialStudents = [
    { id: 1, name: "Alice", course: "Computer Science" },
    { id: 2, name: "Bob", course: "Information Technology" },
    { id: 3, name: "Charlie", course: "Electronics" },
    { id: 4, name: "David", course: "Mechanical" },
    { id: 5, name: "Eva", course: "Civil" }
  ];

  const [students, setStudents] = useState(initialStudents);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const handleChange = (e) => {
    setNewStudent({
      ...newStudent,
      [e.target.name]: e.target.value
    });
  };

  const addStudent = () => {

    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      return;
    }

    setStudents([...students, newStudent]);

    setNewStudent({
      id: "",
      name: "",
      course: ""
    });
  };

  const deleteStudent = (id) => {
    const updatedStudents = students.filter((student) => student.id !== id);
    setStudents(updatedStudents);
  };

  return (
    <div className="container">

      <h2>Student Manager</h2>

      <input
        type="text"
        name="id"
        placeholder="Student ID"
        value={newStudent.id}
        onChange={handleChange}
      />

      <input
        type="text"
        name="name"
        placeholder="Student Name"
        value={newStudent.name}
        onChange={handleChange}
      />

      <input
        type="text"
        name="course"
        placeholder="Course"
        value={newStudent.course}
        onChange={handleChange}
      />

      <button onClick={addStudent}>Add Student</button>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>

          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button onClick={() => deleteStudent(student.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>

        </table>
      )}

    </div>
  );
}

export default StudentManager;