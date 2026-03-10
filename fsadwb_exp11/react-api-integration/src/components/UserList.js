import React, { useState, useEffect } from "react";

function UserList() {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {

    fetch("https://jsonplaceholder.typicode.com/users")
      .then((response) => response.json())
      .then((data) => {
        setUsers(data);
        setLoading(false);
      });

  }, []);

  if (loading) return <p>Loading users...</p>;

  return (

    <div>

      <h2>Users API</h2>

      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.name} | {user.email} | {user.phone}
          </li>
        ))}
      </ul>

    </div>

  );
}

export default UserList;